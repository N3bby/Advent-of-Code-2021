package day4

import util.readResource

fun parseDrawnNumbers(input: String): List<Int> {
    return input
        .lines()[0]
        .split(',')
        .map { it.toInt() }
}

fun parseBingoBoards(input: String): List<BingoBoard> {
    return input
        .split("\n\n")
        .drop(1) // Drop the drawnNumbers line
        .map { parseBingoBoard(it.lines()) }
}

fun parseBingoBoard(lines: List<String>): BingoBoard {
    val board = lines
        .map { line -> line.split(' ').filter { it.isNotBlank() } }
        .map { row -> row.map { BingoBoardCell(it.toInt(), false) } }
        .map { row -> row.toTypedArray() }
        .toTypedArray()
    return BingoBoard(board)
}

fun determineWinningBoard(bingoBoards: List<BingoBoard>, drawnNumbers: List<Int>): WinningResult {
    for (number in drawnNumbers) {
        bingoBoards.forEach { it.mark(number) }
        val winningBoard = bingoBoards.find { it.hasWon() }
        if (winningBoard != null) {
            return WinningResult(winningBoard, number)
        }
    }
    throw RuntimeException("All numbers have been drawn, but no board has won")
}

fun determineLastWinningBoard(bingoBoards: List<BingoBoard>, drawnNumbers: List<Int>): WinningResult {
    val bingoBoardsLeft = bingoBoards.toMutableList()
    var lastWinningBoard: BingoBoard? = null
    var lastWinningBoardDrawnNumber: Int? = null

    for (number in drawnNumbers) {
        bingoBoardsLeft.forEach { it.mark(number) }
        val winningBoards = bingoBoardsLeft.filter { it.hasWon() }
        if (winningBoards.isNotEmpty()) {
            bingoBoardsLeft.removeAll(winningBoards)
            lastWinningBoard = winningBoards[0]
            lastWinningBoardDrawnNumber = number
        }
    }
    return WinningResult(lastWinningBoard!!, lastWinningBoardDrawnNumber!!)
}

data class WinningResult(val winningBoard: BingoBoard, val lastDrawnNumber: Int) {
    fun finalScore(): Int {
        return winningBoard.sumOfUnmarkedNumbers() * lastDrawnNumber
    }
}

fun main() {
    val input = readResource("day4/input.txt")
    val drawnNumbers = parseDrawnNumbers(input)
    val bingoBoards = parseBingoBoards(input)

    val winningResult = determineWinningBoard(bingoBoards, drawnNumbers)
    println("After drawing number ${winningResult.lastDrawnNumber}, board number ${bingoBoards.indexOf(winningResult.winningBoard)} won with a score of ${winningResult.finalScore()}")

    val lastWinningResult = determineLastWinningBoard(bingoBoards, drawnNumbers)
    println("After drawing number ${lastWinningResult.lastDrawnNumber}, the last board with board number ${bingoBoards.indexOf(lastWinningResult.winningBoard)} won with a score of ${lastWinningResult.finalScore()}")
}

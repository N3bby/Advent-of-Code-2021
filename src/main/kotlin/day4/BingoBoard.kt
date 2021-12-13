package day4

import util.transpose

class BingoBoard(private val board: Array<Array<BingoBoardCell>>) {

    private val rows: List<List<BingoBoardCell>>
        get() {
            return board.map { it.toList() }
        }

    private val columns: List<List<BingoBoardCell>>
        get() {
            return rows.transpose()
        }

    fun hasWon(): Boolean {
        return rows.any { row -> row.all { it.marked } }
                || columns.any { column -> column.all { it.marked } }
    }

    fun sumOfUnmarkedNumbers(): Int {
        return board.sumBy { col -> col.filter { !it.marked }.sumBy { it.number } }
    }

    fun mark(number: Int) {
        board.forEachIndexed { rowIndex, column ->
            column.forEachIndexed { colIndex, cell ->
                run {
                    if (cell.number == number) board[rowIndex][colIndex] = BingoBoardCell(cell.number, true)
                }
            }
        }
    }
}

class BingoBoardCell(val number: Int, val marked: Boolean)

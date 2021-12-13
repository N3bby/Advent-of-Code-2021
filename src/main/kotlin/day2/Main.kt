package day2

import util.readResourceLines

fun main() {
    val commands = parseCommands(readResourceLines("day2/input.txt"))

    println("Regular submarine")
    val submarine = Submarine()
    submarine.executeCommands(commands)
    println("horizontalPosition: " + submarine.horizontalPosition)
    println("depth: " + submarine.depth)
    println("multiplied: " + submarine.depth * submarine.horizontalPosition)

    println("Aimed submarine")
    val aimedSubmarine = AimedSubmarine()
    aimedSubmarine.executeCommands(commands)
    println("horizontalPosition: " + aimedSubmarine.horizontalPosition)
    println("depth: " + aimedSubmarine.depth)
    println("multiplied: " + aimedSubmarine.depth * aimedSubmarine.horizontalPosition)
}

package day2

sealed class Command(val units: Int)

class ForwardCommand(units: Int) : Command(units)
class DownCommand(units: Int) : Command(units)
class UpCommand(units: Int) : Command(units)

fun parseCommands(commands: List<String>): List<Command> {
    return commands
        .map { it.trim() }
        .filter { it.isNotEmpty() }
        .map {
            val (command, units) = it.split(" ")
            when (command) {
                "forward" -> ForwardCommand(units.toInt())
                "up" -> UpCommand(units.toInt())
                "down" -> DownCommand(units.toInt())
                else -> throw NotImplementedError("Command '$command' is not supported")
            }
        }
}

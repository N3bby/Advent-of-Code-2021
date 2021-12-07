package day2

open class Submarine {

    var horizontalPosition: Int = 0
        protected set

    var depth: Int = 0
        protected set

    fun executeCommands(commands: List<Command>) {
        commands.forEach(this::executeCommand)
    }

    fun executeCommand(command: Command) {
        val units = command.units
        when (command) {
            is ForwardCommand -> goForward(units)
            is UpCommand -> goUp(units)
            is DownCommand -> goDown(units)
        }
    }

    open fun goForward(units: Int) {
        horizontalPosition += units
    }

    open fun goDown(units: Int) {
        depth += units
    }

    open fun goUp(units: Int) {
        depth -= units
    }

}

class AimedSubmarine: Submarine() {

    var aim: Int = 0
        private set

    override fun goForward(units: Int) {
        horizontalPosition += units
        depth += aim * units
    }

    override fun goDown(units: Int) {
        aim += units
    }

    override fun goUp(units: Int) {
        aim -= units
    }

}

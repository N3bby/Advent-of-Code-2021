package day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2 {

    private val exampleCommandString: List<String> = """
        forward 5
        down 5
        forward 8
        up 3
        down 8
        forward 2
    """.lines()

    @Test
    internal fun `Moving a submarine following the example commands should arrive at the correct position`() {
        val commands = parseCommands(exampleCommandString)

        val submarine = Submarine()
        submarine.executeCommands(commands)

        assertEquals(15, submarine.horizontalPosition)
        assertEquals(10, submarine.depth)
    }

    @Test
    internal fun `AimedSubmarine is at correct position after executing example commands`() {
        val commands = parseCommands(exampleCommandString)

        val submarine = AimedSubmarine()
        submarine.executeCommands(commands)

        assertEquals(15, submarine.horizontalPosition)
        assertEquals(60, submarine.depth)
    }
}

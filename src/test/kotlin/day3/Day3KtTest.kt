package day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3KtTest {

    private val exampleInput = """
        00100
        11110
        10110
        10111
        10101
        01111
        00111
        11100
        10000
        11001
        00010
        01010
    """.trimIndent()

    @Test
    fun `determineGammaRate works for example input`() {
        assertEquals(22, determineGammaRate(exampleInput.lines()))
    }

    @Test
    fun `determineEpsilonRate works for example input`() {
        assertEquals(9, determineEpsilonRate(exampleInput.lines()))
    }

    @Test
    fun `determinePowerConsumption works for example input`() {
        assertEquals(198, determinePowerConsumption(exampleInput.lines()))
    }

    @Test
    fun `determineOxygenGeneratorRating works for example input`() {
        assertEquals(23, determineOxygenGeneratorRating(exampleInput.lines()))
    }

    @Test
    fun `determineCO2ScrubberRating works for example input`() {
        assertEquals(10, determineCO2ScrubberRating(exampleInput.lines()))
    }

    @Test
    fun `determineLifeSupportRating works for example input`() {
        assertEquals(230, determineLifeSupportRating(exampleInput.lines()))
    }

}

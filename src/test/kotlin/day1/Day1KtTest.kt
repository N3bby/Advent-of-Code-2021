package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1KtTest {

    private val depthMeasurements = listOf(
        199,
        200,
        208,
        210,
        200,
        207,
        240,
        269,
        260,
        263
    )

    @Test
    fun `getCountOfMeasurementsThatAreLargerThanThePreviousMeasurement should return example result`() {
        val count = getCountOfMeasurementsThatAreLargerThanThePreviousMeasurement(depthMeasurements)
        assertEquals(7, count)
    }

    @Test
    fun `getCountOfSlidingWindowSumThatIsLargerThanThePreviousWindow should return example result`() {
        val count = getCountOfSlidingWindowSumThatIsLargerThanThePreviousWindow(depthMeasurements, 3)
        assertEquals(5, count)
    }

}

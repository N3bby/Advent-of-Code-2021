package util

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ListExtensionKtTest {

    @Test
    fun `List transpose should return a transposed lists`() {
        val list = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9)
        )

        val expectedTransposedList = listOf(
            listOf(1, 4, 7),
            listOf(2, 5, 8),
            listOf(3, 6, 9)
        )

        assertEquals(expectedTransposedList, list.transpose())
    }
}

package day1

import util.readResourceLines

fun getCountOfMeasurementsThatAreLargerThanThePreviousMeasurement(depthMeasurements: List<Int>): Int {
    var count = 0
    for (i in 1 until depthMeasurements.size) {
        if (depthMeasurements[i] > depthMeasurements[i-1]) count++
    }
    return count
}

fun getCountOfSlidingWindowSumThatIsLargerThanThePreviousWindow(measurements: List<Int>, windowSize: Int): Int {
    val windowSums = createListWindows(measurements, windowSize)
        .map { it.sum() }
    return getCountOfMeasurementsThatAreLargerThanThePreviousMeasurement(windowSums)
}

private fun <T> createListWindows(list: List<T>, windowSize: Int): List<List<T>> {
    val windows = mutableListOf<List<T>>()
    for (i in 0 .. list.size - windowSize) {
        windows.add(list.subList(i, i + windowSize))
    }
    return windows
}

fun main() {
    val depthMeasurements = readResourceLines("day1/input.txt").map { it.toInt() }
    println(getCountOfMeasurementsThatAreLargerThanThePreviousMeasurement(depthMeasurements))
    println("With sliding window of 3: " + getCountOfSlidingWindowSumThatIsLargerThanThePreviousWindow(depthMeasurements, 3))
}

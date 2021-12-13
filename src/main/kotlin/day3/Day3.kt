package day3

import util.fromBinary
import util.leastCommonElement
import util.mostCommonElement
import util.readResourceLines

fun determineGammaRate(diagnosticReport: DiagnosticReport): Int {
    val binaryGammaRate = (0 until diagnosticReport[0].length)
        .map { index ->
            diagnosticReport
                .map { it.elementAt(index) }
                .mostCommonElement()
        }
    return Int.fromBinary(binaryGammaRate)
}

fun determineEpsilonRate(diagnosticReport: DiagnosticReport): Int {
    val binaryEpsilonRate = (0 until diagnosticReport[0].length)
        .map { index ->
            diagnosticReport
                .map { it.elementAt(index) }
                .leastCommonElement()
        }
    return Int.fromBinary(binaryEpsilonRate)
}

fun determinePowerConsumption(diagnosticReport: DiagnosticReport): Int {
    return determineGammaRate(diagnosticReport) * determineEpsilonRate(diagnosticReport)
}

fun determineRating(diagnosticReport: DiagnosticReport, bitCriteria: (bitOccurrence: Map<Char, Int>) -> Char, currentBit: Int = 0): Int {
    if (diagnosticReport.size == 1) {
        return Int.fromBinary(diagnosticReport[0])
    }

    val bitOccurrence = diagnosticReport
        .groupBy { it[currentBit] }
        .mapValues { it.value.size }

    val bitToFilterBy = bitCriteria(bitOccurrence)

    val matchingNumbers = diagnosticReport.filter { it[currentBit] == bitToFilterBy }
    return determineRating(matchingNumbers, bitCriteria, currentBit + 1)
}

fun determineOxygenGeneratorRating(diagnosticReport: DiagnosticReport, currentBit: Int = 0): Int {
    val bitCriteria = { bitOccurrence: Map<Char, Int> ->
        if (bitOccurrence['0'] == bitOccurrence['1']) '1'
        else bitOccurrence.maxByOrNull { it.value }!!.key
    }
    return determineRating(diagnosticReport, bitCriteria)
}

fun determineCO2ScrubberRating(diagnosticReport: DiagnosticReport, currentBit: Int = 0): Int {
    val bitCriteria = { bitOccurrence: Map<Char, Int> ->
        if (bitOccurrence['0'] == bitOccurrence['1']) '0'
        else bitOccurrence.minByOrNull { it.value }!!.key
    }
    return determineRating(diagnosticReport, bitCriteria)
}

fun determineLifeSupportRating(diagnosticReport: DiagnosticReport): Int {
    return determineCO2ScrubberRating(diagnosticReport) * determineOxygenGeneratorRating(diagnosticReport)
}

fun main() {
    val diagnosticReport = readResourceLines("day3/input.txt")
    println("Power consumption: ${determinePowerConsumption(diagnosticReport)}")
    println("Life support rating: ${determineLifeSupportRating(diagnosticReport)}")
}

typealias DiagnosticReport = List<String>


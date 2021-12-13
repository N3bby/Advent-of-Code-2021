package util

fun Int.Companion.fromBinary(bits: List<Char>): Int {
    return fromBinary(bits.joinToString(""))
}


fun Int.Companion.fromBinary(binaryString: String): Int {
    return Integer.parseInt(binaryString, 2)
}

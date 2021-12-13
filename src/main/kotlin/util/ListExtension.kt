package util

fun <T> List<T>.mostCommonElement(): T {
    return this
        .groupBy { it }
        .maxByOrNull { it.value.size }!!
        .key
}

fun <T> List<T>.leastCommonElement(): T {
    return this
        .groupBy { it }
        .minByOrNull { it.value.size }!!
        .key
}

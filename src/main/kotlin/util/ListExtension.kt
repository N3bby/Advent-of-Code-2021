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

// This only handles rectangular grids
fun <T> List<List<T>>.transpose(): List<List<T>> {
    val transposed = mutableListOf<MutableList<T>>()
    repeat(this[0].size) { transposed.add(mutableListOf()) }

    this.forEach { subList -> subList.forEachIndexed { index, e -> transposed[index].add(e) } }

    return transposed
}

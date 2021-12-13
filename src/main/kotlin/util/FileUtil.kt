package util

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors.toList

fun readResourceLines(resourcePath: String): List<String> {
    val inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream(resourcePath)
    return BufferedReader(InputStreamReader(inputStream!!)).lines().collect(toList())
}

fun readResource(resourcePath: String): String {
    return readResourceLines(resourcePath).joinToString("\n")
}

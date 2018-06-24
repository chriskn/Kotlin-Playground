package com.github.chriskn.kotlin.playground

import com.github.chriskn.kotlin.playground.GravityLevel.*

fun main(args: Array<String>) {

    val runtime = benchmark {
        for (i in 0..100 * 100 * 100) {
            Point(i, i)
        }
    }
    println("Executed in ${runtime}ms")

    val calculator = getGravityCalculator(LOW)
    println("New Position: ${calculator.invoke(Point(10,10))}")

    val divisibleBy5 = listOf(1,2,5,8,15,255).filter { it % 5 == 0 }
    println("Result: $divisibleBy5")

}

fun benchmark(block: () -> Unit): Long {
    val startTime = System.currentTimeMillis()
    block.invoke()
    return System.currentTimeMillis() - startTime
}

fun <T> List<T>.filter(condition: (T) -> Boolean): List<T> {
    val result = arrayListOf<T>()
    for (item in this) {
        if (condition(item)) {
            result.add(item)
        }
    }
    return result
}

enum class GravityLevel { LOW, HIGH }

fun getGravityCalculator(level: GravityLevel): (Point) -> Point {
    when (level) {
        LOW -> return { point -> Point(point.x + 2, point.y + 2) }
        HIGH -> return { point -> Point(point.x + 4, point.y + 4) }
        else -> throw IllegalArgumentException("Unknown GravityLLevel")
    }
}

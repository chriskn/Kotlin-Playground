package com.github.chriskn.kotlin.playground

fun main(args: Array<String>) {
    println("Peter".great())

    val list = arrayListOf("one", "two")
    list.swap(0, 1)
    println("Swap ${list}")

    val numbers = listOf(1, 0, 33, 4, 75, 9)
    println("Sorted ${numbers.quicksort()}")

    println(null.toString())
}

fun String.great(): String {
    return """Hello $this
     |and welcome to Kotlin""".trimMargin()
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

fun <T : Comparable<T>> List<T>.quicksort(): List<T> {
    if (this.count() < 1) return this
    val pivot = this[this.count() / 2]
    val equal = this.filter { it == pivot }
    val less = this.filter { it < pivot }
    val greater = this.filter { it > pivot }
    return less.quicksort() + equal + greater.quicksort()
}


fun Any?.toString(): String = this?.toString() ?: "I am null"


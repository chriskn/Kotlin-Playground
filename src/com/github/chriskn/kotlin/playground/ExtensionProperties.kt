package com.github.chriskn.kotlin.playground

fun main(args: Array<String>) {

    val p = Point(-10, 20)
    println(p.distanceToNull)

    println(p.reference)
    p.reference = Point(10, 10)
    println(p.reference)
    p.reference = Point(10, 101)
    println(p.reference)

}

var Point.reference: Point
    get() = this.zero ?: Point(0, 0)
    set(value) {
        if (value.x > 0 && value.y in 0..100) {
            this.zero = value
        }
    }


val Point.distanceToNull: Int
    get() = kotlin.math.abs(x) + kotlin.math.abs(y)


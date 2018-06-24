package com.github.chriskn.kotlin.playground

operator fun Point.unaryMinus() = Point(-x, -y)
operator  fun Point.plus(other:Point) =  Point(this.x +other.x , this.y +other.y)

fun main(args: Array<String>) {
    val point = Point(10, 20)
    println(-point)
    println(-point+Point(10,20))
}

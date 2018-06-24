package chriskn.github.kotlin.playground.nullsafety.kotlin

fun main(args: Array<String>) {

    val x: Any = listOf("one", "two")
    check(x)

    val values = intArrayOf(1, 2, 3)
    println("Sum ${sum(values)}")

    println("Status is ${statusMessageFor(200)}")
}

private fun check(x: Any) {
    if (x is String && x.length > 0) { // x is cast after &&
        println(x.length)
    }
    if (x !is String) { // same as !(x is String)
        println("Not a String")
    }
    if (x is List<*>) {
        x.forEach { println(it) } // the items are typed as Any?
    }
}

fun sum(x: Any): Int {
    when (x) {
        is Int -> return x
        is String -> return x.toInt()
        is IntArray -> return x.sum()
        else -> return 0
    }
}

fun statusMessageFor(code: Int): String {
    when (code) {
        in 100..199 -> return "info"
        in 200..299 -> return "success"
        in 300..399 -> return "redirect"
        in 400..499 -> return "client error"
        in 500..599 -> return "server error"
        else -> return "unknown"
    }
}

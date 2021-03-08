package chapter_ii

class Account(private val debits: Float,
              private val credits: Float,
              private val fees: Float,
              private val balance: Float) {

    fun printBalance() {

        println()
        reportLine("Debits", debits)
        reportLine("Credits", credits)
        reportLine("Fees", fees)
        printLine("", "----")
        reportLine("Balance", balance)
    }

    private fun reportLine(label: String, value: Float) = printLine(label, formatAmount(value))
    private fun printLine(label: String, value: String) = println("%-9s%s".format(label, value))
    private fun formatAmount(f: Float): String = "%-10.2f".format(f)
}

// -----Violations
class Point(val x: Int, val y: Int) {
    fun distanceTo(other: Point): Double = TODO("I do not know how to calculate Hamiltonian distance yet.")
}
class Line(val start: Point, val end: Point) {
    val length: Double by lazy { start.distanceTo(end) }
}

fun main() {

    Account(1355F, 1000F, 45F, 2500F).also { it.printBalance() }
    Account(1355F, 1000F, -45F, -200F).also { it.printBalance() }
    Account(1355F, 1000F, -45F, 2500F).also { it.printBalance() }

    val l = Line(Point(0, 0), Point(2, 3))
    println(l.length)
}


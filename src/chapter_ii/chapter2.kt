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

fun main() {

    Account(1355F, 1000F, 45F, 2500F).also { it.printBalance() }
    Account(1355F, 1000F, -45F, -200F).also { it.printBalance() }
    Account(1355F, 1000F, -45F, 2500F).also { it.printBalance() }
}


package chapter_ii



class Account(private val debits: Float,
              private val credits: Float,
              private val fees: Float,
              private val balance: Float) {

    fun printBalance() {

        println()

        println("Debits:  ${formatAmount(debits)}")
        println("Credits: ${formatAmount(credits)}")
        println("Fees:    ${formatAmount(fees)}")
        println("    ----")
        println("Balance: ${formatAmount(balance)}")
    }

    private fun formatAmount(f: Float): String = "%-10.2f".format(f)
}

fun main() {

    Account(1355F, 1000F, 45F, 2500F).also { it.printBalance() }
    Account(1355F, 1000F, -45F, -200F).also { it.printBalance() }
    Account(1355F, 1000F, -45F, 2500F).also { it.printBalance() }
}


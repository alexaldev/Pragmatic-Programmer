package chapter_ii

class Account(private val debits: Float,
              private val credits: Float,
              private val fees: Float,
              private val balance: Float) {

    fun printBalance() {

        println("Debits: %10.2f".format(debits))
        println("Credits: %10.2f".format(credits))

        if (fees < 0) {
            println("Fees:    -%.2f".format(-fees))
        } else {
            println("Fees:    %10.2f".format(fees))
        }
        println("    ----")
        if (balance < 0) {
            println("Balance: -%.2f".format(-balance))
        } else {
            println("Balance: %10.2f".format(balance))
        }
    }
}

fun main() {
    val a = Account(1355F, 1000F, 45F, 2500F)
    val a1 = Account(1355F, 1000F, -45F, -200F)
    val a2 = Account(1355F, 1000F, -45F, 2500F)

    a.printBalance()
    a1.printBalance()
    a2.printBalance()
}


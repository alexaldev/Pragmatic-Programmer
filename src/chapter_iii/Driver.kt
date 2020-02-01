/**
 * Task 13 from chapter 3. Includes implementation only for the C programming language.
 */
import java.io.File
import StartingSymbol.*

enum class StartingSymbol {
    M, F, E, L
}

fun String.toStartingSymbol(): StartingSymbol {
    return when (this) {
        "M" -> M
        "F" -> F
        "E" -> E
        "" -> L
        else -> throw IllegalArgumentException("Unknown starting symbol")
    }
}

abstract class ClassGenerator {
    val output = StringBuilder()
    abstract fun generateFrom(input: File): String
}

class CGenerator : ClassGenerator() {

    private val DEFINITION_START = "typedef struct {\n"
    private val fourSpaces = "    "

    // Buffer
    private lateinit var messageTitle: String

    init {
        output.append(DEFINITION_START)
    }

    override fun generateFrom(input: File): String {
        input.forEachLine { parseLine(it) }.also { return output.toString() }
    }

    private fun parsePrimitiveType(line: String) {
        line.split(" ", limit = 2)
            .also { splits ->
                output.append(splits[1], fourSpaces, splits[0], ";\n")
            }
    }

    private fun parseArrayType(line: String) {

        val (fieldName, arrayTypeSplit) = line.split(" ", limit = 2)
        val arraySize = arrayTypeSplit.filter { it in '0'..'9' }
        val fieldType = arrayTypeSplit.filter { it in 'a'..'z' }
        output.append("  ", fieldType, fourSpaces, fieldName, "[", arraySize, "];\n")
    }

    private fun handleField(fieldAndType: String) {

        val type = fieldAndType.split(" ", limit = 2)[1]
        if (type.isArrayType()) {
            parseArrayType(fieldAndType)
        } else {
            parsePrimitiveType(fieldAndType)
        }
    }

    private fun String.isArrayType(): Boolean = this.contains('[')

    private fun handleEnd() {
        output.append("} ${messageTitle.split(" ")[1]}")
    }

    private fun parseLine(line: String) {

        val symbolAndField = line.split(" ", limit = 2)

        when (symbolAndField[0].toStartingSymbol()) {
            M -> messageTitle = line + "Msg;"
            F -> handleField(symbolAndField[1])
            E -> handleEnd()
            L -> return
        }
    }
}

fun main() {
    print(CGenerator().generateFrom(File("/home/alexallaf/Code/Pragmatic Programmer/src/chapter_iii/requirements_sample.txt")))
}
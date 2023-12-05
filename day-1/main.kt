import java.io.File

private val wordsToDigits =
        mapOf<String, Int>(
                "one" to 1,
                "two" to 2,
                "three" to 3,
                "four" to 4,
                "five" to 5,
                "six" to 6,
                "seven" to 7,
                "eight" to 8,
                "nine" to 9
        )

fun main() {
    val lines = File("input.txt").readLines()

    val resultPart1 = part1(lines)
    val resultPart2 = part2(lines)

    print("Part1: $resultPart1, Part2: $resultPart2")
}

fun part1(lines: List<String>): Int {
    return lines.sumOf {
        val firstDigit = it.first { it.isDigit() }.digitToInt()
        val lastDigit = it.last { it.isDigit() }.digitToInt()
        firstDigit * 10 + lastDigit
    }
}

fun part2(lines: List<String>): Int {
    val allOptions = wordsToDigits.keys + wordsToDigits.values.map { it.toString() }

    return lines.sumOf {
        val firstDigit =
                it.findAnyOf(allOptions)?.second.orEmpty().let { wordsToDigits[it] ?: it.toInt() }
        val lastDigit =
                it.findLastAnyOf(allOptions)?.second.orEmpty().let {
                    wordsToDigits[it] ?: it.toInt()
                }
        firstDigit * 10 + lastDigit
    }
}

import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val splitInput = input.map { it.split("\\s+".toRegex()) }
        val (leftColumn, rightColumn) = splitInput.map { line ->
            val (left, right) = line.map { it.toInt() }
            left to right
        }.unzip()

        val sortedLeftColumn = leftColumn.sorted()
        val sortedRightColumn = rightColumn.sorted()

        val zipped = sortedLeftColumn.zip(sortedRightColumn)
        println(zipped)
        
        return zipped.sumOf { abs(it.second - it.first) }
    }

    fun part2(input: List<String>): Int {
        val splitInput = input.map { it.split("\\s+".toRegex()) }
        val (leftColumn, rightColumn) = splitInput.map { line ->
            val (left, right) = line.map { it.toInt() }
            left to right
        }.unzip()

        return leftColumn.sumOf { leftNum ->
            leftNum * rightColumn.count { it == leftNum }
        }
    }

    val testInput = readInput("Day01_test")
    val input = readInput("Day01")

    part1(testInput).println()
    part1(input).println()
    part2(testInput).println()
    part2(input).println()
}

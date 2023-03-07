package com.internal.knapsack

/*
Suppose you’re going camping.
You have a knapsack that will hold 6 lb, and you can take the following items.
Each has a value, and the higher the value, the more important the item is:

formula = max (previous max knapsack[i-1][j], value of current item + value of remaining space knapsack[i-1][j-item weight]
 */
fun main(args: Array<String>) {
    val items = listOf(
        Item("water", 3, 10),
        Item("book", 1, 3),
        Item("food", 2, 9),
        Item("jacket", 2, 5),
        Item("camera", 1, 6)
    )// solution = water + food + camera

    val weights = arrayOf(1, 2, 3, 4, 5, 6) //Sack capacity is 6lb
    val resultsMatrix = Array(items.size + 1) { IntArray(weights.size + 1) } //5 items x 6 weights plus initial empty column and row

    for (item in 0..items.size) {
        for (weight in 0..weights.size) {
            if (item == 0 || weight == 0) {
                resultsMatrix[item][weight] = 0
            } else if (items[item - 1].weightInLb <= weight) {
                resultsMatrix[item][weight] = maxOf(
                    items[item - 1].value + resultsMatrix[item - 1][weight - items[item - 1].weightInLb],
                    resultsMatrix[item - 1][weight]
                )
            } else {
                resultsMatrix[item][weight] = resultsMatrix[item - 1][weight]
            }
        }
    }

    val knapsack = mapResultToItemsInKnapsack(items, resultsMatrix, weights)

    println("The best combination has the value: ${knapsack.values.sumOf { it.value }} " +
            "and weight ${knapsack.values.sumOf { it.weightInLb }} " +
            "and are items ${knapsack.values.sortedByDescending { it.value }.joinToString { it.name }}")
}

private fun mapResultToItemsInKnapsack(
    items: List<Item>,
    resultsMatrix: Array<IntArray>,
    weights: Array<Int>
): HashMap<String, Item> {
    val knapsack = HashMap<String, Item>()

    val reverseSortedItemsByValue = items.sortedByDescending { it.value }
    val dpResults = mutableSetOf<Int>()
    for (i in resultsMatrix.lastIndex downTo 1) {
        dpResults.add(resultsMatrix[i][weights.size])
    }

    var substractor = resultsMatrix[items.size][weights.size]
    for (i in dpResults.indices) {
        if (substractor > 0) {
            knapsack[reverseSortedItemsByValue[i].name] = reverseSortedItemsByValue[i]
            substractor -= reverseSortedItemsByValue[i].value
        }

    }
    return knapsack
}

data class Item(
    val name: String,
    val weightInLb: Int,
    val value: Int
)

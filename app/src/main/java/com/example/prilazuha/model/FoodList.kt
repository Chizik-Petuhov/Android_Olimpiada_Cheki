package com.example.prilazuha.model

class FoodList {
    private var foods:MutableList<FoodItem> = mutableListOf<FoodItem>()

    fun getFoods(): List<FoodItem> {
        return foods
    }

    fun getItem(index: Int): FoodItem {
        return foods[index]
    }

    fun getSize(): Int{
        return foods.size
    }

//    fun deleteFood(food: FoodItem){
//        val indexToDelete: Int = foods.indexOfFirst { it.name == food.num }
//        if (indexToDelete == -1) return
//        foods.removeAt(indexToDelete)
//    }
//
    fun add(name: String){
        val Foundedindex: Int = foods.indexOfFirst { it.name == name }
        if (Foundedindex != -1) return
        val food = FoodItem(
            id = foods.size.toLong(),
            name = name,
            num = 1
        )
        foods.add(food)
    }
    fun add(name: String, num: String){
        val Foundedindex: Int = foods.indexOfFirst { it.name == name }
        if (Foundedindex != -1) return
        val food = FoodItem(
            id = foods.size.toLong(),
            name = name,
            num = num.toLong()
        )
        foods.add(food)
    }

    fun incFood(name: String){
        val indexToInc: Int = foods.indexOfFirst { it.name == name }
        if (indexToInc == -1) return
        foods[indexToInc].num.inc()
    }

    fun decFood(name: String){
        val indexToDec: Int = foods.indexOfFirst { it.name == name }
        if (indexToDec == -1) return
        foods[indexToDec].num.dec()
    }
}
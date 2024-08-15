package com.example.prilazuha.model

class FoodItem(
    var id: Long,
    var name: String,
    var num: Long
) {
    override fun toString(): String {
        return name+"/"+num
    }
}

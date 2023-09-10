package com.example.myapplication

class Dice (private val numSides: Int) {
    var sides = 6;

    fun roll(): Int {
        return  (1..numSides).random()
    }



}
package com.example.pencilduration

class Pencil {
    var durability = 0

    constructor() {
        this.durability = 50
    }

    constructor(durability: Int) {
        this.durability = durability
    }

    fun degrades(sentence: String){
        this.durability = this.durability - sentence.length
    }
}

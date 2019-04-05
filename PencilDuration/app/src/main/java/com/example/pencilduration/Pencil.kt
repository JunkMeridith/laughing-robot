package com.example.pencilduration

class Pencil {

    var durability = 0
    private var defaultDurability = 0
    private val uppercaseDegradation = 2
    private val lowercaseDegradation = 1
    private val spaceDegradation = 0
    var remainingSharpenings = 0
    var EraserDurability = 0

    constructor() {
        this.durability = 50
        this.defaultDurability = 50
        this.remainingSharpenings = 5
        this.EraserDurability = 50
    }

    constructor(durability: Int) {
        this.durability = durability
        this.defaultDurability = durability
        this.remainingSharpenings = 5
        this.EraserDurability = 50
    }

    constructor(durability: Int, sharpenings: Int) {
        this.durability = durability
        this.defaultDurability = durability
        this.remainingSharpenings = sharpenings
        this.EraserDurability = 50
    }

    constructor(durability: Int, sharpenings: Int, eraserDurability: Int) {
        this.durability = durability
        this.defaultDurability = durability
        this.remainingSharpenings = sharpenings
        this.EraserDurability = eraserDurability
    }

    fun degrades(sentence: String): String {

        sentence.toCharArray().forEach {
            degradePencilDurability(it)
        }
        return sentence
    }


    private fun degradePencilDurability(characterInSentence: Char) {
        when {
            this.durability <= 0 -> this.durability = 0
            !characterInSentence.isLetter() -> this.durability = this.durability - spaceDegradation
            characterInSentence.isUpperCase() -> this.durability = this.durability - uppercaseDegradation
            characterInSentence.isLowerCase() -> this.durability = this.durability - lowercaseDegradation
        }

    }

    private fun writeItOut(character: Char): Char {
        return when {
            this.durability == 0 -> ' '
            else -> return character
        }
    }

    fun degradesByChar(character : Char): Char{
        var writeThatCharacter =  writeItOut(character)
        degradePencilDurability(writeItOut(character))
        return writeThatCharacter
    }

    fun sharpen() {
        if (this.remainingSharpenings > 0) {
            this.durability = this.defaultDurability
            this.remainingSharpenings--
        }
    }

    fun erase(wordToErase: String) {
        this.EraserDurability -= wordToErase.length
    }
}

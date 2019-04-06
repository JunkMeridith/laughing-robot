package com.example.pencilduration

class Pencil(var durability: Int = 50, var remainingSharpenings: Int = 5, var EraserDurability: Int = 50) {

    private var defaultDurability = 0
    private val uppercaseDegradation = 2
    private val lowercaseDegradation = 1
    private val spaceDegradation = 0


    init {
        this.defaultDurability = durability
    }

    fun writeSentence(sentence: String): String {
        var sentenceToWrite = ""

        sentence.toCharArray().forEach {
            when {
                this.durability == 0 -> {sentenceToWrite += ' '}
                else -> {
                    degradePencilDurability(it)
                    sentenceToWrite += it
                }
            }
        }

        return sentenceToWrite
    }

    private fun degradePencilDurability(characterInSentence: Char) {
        when {
            !characterInSentence.isLetter() -> this.durability = this.durability - spaceDegradation
            characterInSentence.isUpperCase() -> this.durability = this.durability - uppercaseDegradation
            characterInSentence.isLowerCase() -> this.durability = this.durability - lowercaseDegradation
        }
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

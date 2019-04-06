package com.example.pencilduration

class Paper {

    private var sentence: String? = null

    constructor(Sentence: String) {
        this.sentence = Sentence
    }

    fun getSentence(): String? {
        return this.sentence
    }

    fun write(textToWrite: String, writingUtensil: Pencil) {
        var textToGoOnPaper = writingUtensil.writeSentence(textToWrite)
        this.sentence += textToGoOnPaper
    }

    fun erase(word: String, writingUtensil: Pencil) {
        var whitespaceWordToReplace = " ".repeat(word.length)
        val indicesOfWord = findWord(word)

        this.sentence =
            StringBuilder(this.sentence).replace(
                indicesOfWord.first(),
                indicesOfWord.last(),
                whitespaceWordToReplace
            )
                .toString()

        writingUtensil.erase(word)
    }

    fun edit(wordToErase: String, wordToReplace: String, writingUtensil: Pencil) {
        val indicesOfWords = findWord(wordToErase)

        erase(wordToErase, writingUtensil)
        writingUtensil.writeSentence(wordToReplace)

        val startingIndex = indicesOfWords.first()
        val tempSentence = StringBuilder(this.getSentence())

        for (i in wordToReplace.indices) {
            val character = wordToReplace[i]

            when(tempSentence[startingIndex + i]) {
                ' ' -> { tempSentence.setCharAt(startingIndex + i, character) }
                else -> { tempSentence.setCharAt(startingIndex + i, '@') }
            }
        }

        this.sentence = tempSentence.toString()
    }

    private fun findWord(word: String): ArrayList<Int> {
        val indicesOfWords = ArrayList<Int>()

        val startOfWordIndex = this.sentence?.lastIndexOf(word)
        val endOfWordIndex = startOfWordIndex?.plus(word.length)

        indicesOfWords.add(startOfWordIndex!!)
        indicesOfWords.add(endOfWordIndex!!)

        return indicesOfWords
    }

}

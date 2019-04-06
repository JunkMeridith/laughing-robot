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

    fun erase(word: String) {
        var whitespaceWordToReplace = " ".repeat(word.length)
        val indicesOfWord = findWord(word)

        this.sentence =
            StringBuilder(this.sentence).replace(indicesOfWord.first(), indicesOfWord.last(), whitespaceWordToReplace)
                .toString()
    }

    fun edit(wordToErase: String, wordToReplace: String) {
        val indicesOfWords = findWord(wordToErase)

        this.sentence =
            StringBuilder(this.sentence).replace(indicesOfWords.first(), indicesOfWords.last(), wordToReplace)
                .toString()
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

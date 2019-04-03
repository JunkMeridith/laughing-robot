package com.example.pencilduration

class Paper {

    private var sentence: String? = null
    private var pencil: Pencil

    constructor(Sentence: String, Pencil: Pencil) {
        this.sentence = Sentence
        this.pencil = Pencil
    }

    fun getSentence(): String? {

        return this.sentence
    }

    fun write(textToWrite: String) {
        this.sentence += textToWrite
    }

}

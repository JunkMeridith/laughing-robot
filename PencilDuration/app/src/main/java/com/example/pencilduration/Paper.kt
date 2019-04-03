package com.example.pencilduration

class Paper {

    private var sentence: String? = null

    constructor(Sentence: String) {
        this.sentence = Sentence
    }

    fun getSentence(): String? {

        return this.sentence
    }

}

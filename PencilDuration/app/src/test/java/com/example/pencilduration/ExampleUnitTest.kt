package com.example.pencilduration

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun givenAPaperWhenAPaperStartsOffWithASentenceThenTheSentenceIsStored() {
        val sentence = "this is a sentence"
        val paper: Paper = Paper(sentence)

        assertEquals(sentence, paper.getSentence())
    }

    @Test
    fun givenAPaperWithASentenceInItWhenIWriteToItThenItWillAppendToTheSentence() {
        val sentence = "this is a sentence"
        val paper = Paper(sentence)

        paper.write(" and it is really cool!")

        val expectedValue = "this is a sentence and it is really cool!"

        assertEquals(expectedValue, paper.getSentence())
    }
}

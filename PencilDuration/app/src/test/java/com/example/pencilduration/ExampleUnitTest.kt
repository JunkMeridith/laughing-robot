package com.example.pencilduration

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    var paper: Paper? = null
    var pencil = Pencil()
    val sentence = "this is a sentence"

    @Before
    fun setup() {

        this.pencil = Pencil()
        this.paper = Paper(sentence, this.pencil)
    }

    @Test
    fun GIVEN_APencilAndPaper_WHEN_IWriteASentence_THEN_ThatSentenceIsReturned() {
        assertEquals(this.sentence, this.paper?.getSentence())
    }

    @Test
    fun givenAPaperWithASentenceInItWhenIWriteToItThenItWillAppendToTheSentence() {
        paper?.write(" and it is really cool!")

        val expectedValue = "this is a sentence and it is really cool!"

        assertEquals(expectedValue, paper?.getSentence())
    }
}

package com.example.pencilduration

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PaperUnitTests {

    private var paper: Paper? = null
    private val sentence = "this is a sentence"

    @Before
    fun setup() {

        this.paper = Paper("")
    }

    @Test
    fun GIVEN_APencilAndPaper_WHEN_IWriteASentence_THEN_ThatSentenceIsReturned() {
        assertEquals("", this.paper?.getSentence())
    }

    @Test
    fun givenAPaperWithASentenceInItWhenIWriteToItThenItWillAppendToTheSentence() {
        var pencil = Pencil()
        paper?.write("this is a sentence", pencil)
        paper?.write(" and it is really cool!", pencil)

        val expectedValue = "this is a sentence and it is really cool!"

        assertEquals(expectedValue, paper?.getSentence())
    }

    @Test
    fun `Given text on paper that is misspelled, WHEN i want to edit, THEN the text will be replaced`() {
        var pencil = Pencil()
        paper = Paper("How much wood would a woodchuck chuck if a woodchuck could chuck wood")
        paper?.erase("chuck")

        val expectedValue = "How much wood would a woodchuck chuck if a woodchuck could       wood"

        assertEquals(expectedValue, paper?.getSentence())
    }

    @Test
    fun `GIVEN pencil has durability of 4 WHEN i attempt to write Hello THEN i will get 'Hell '`() {
        var pencil = Pencil(durability=5)
        paper?.write("Hello", pencil)
        val expectedValue = "Hell "

        assertEquals(expectedValue, paper?.getSentence())
    }


}

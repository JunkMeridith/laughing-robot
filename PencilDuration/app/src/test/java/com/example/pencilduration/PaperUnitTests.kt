package com.example.pencilduration

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


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
        paper?.erase("chuck", pencil)

        val expectedValue = "How much wood would a woodchuck chuck if a woodchuck could       wood"
        val expectedEraserDegrationValue = 45
        assertEquals(expectedValue, paper?.getSentence())
        assertEquals(expectedEraserDegrationValue, pencil.EraserDurability)
    }

    @Test
    fun `GIVEN pencil has durability of 4 WHEN i attempt to write Hello THEN i will get 'Hell '`() {
        var pencil = Pencil(durability=5)
        paper?.write("Hello", pencil)
        val expectedValue = "Hell "

        assertEquals(expectedValue, paper?.getSentence())
    }

    @Test
    fun `GIVEN a paper with text WHEN i want to edit a word with a new word of the same exact length THEN the editing should happen`() {
        var expectedText = "How much wood would a woodchuck chuck if a woodchuck could HELLO wood"
        val expectedEraserDegrationValue = 45

        var pencil = Pencil()
        var sentence = "How much wood would a woodchuck chuck if a woodchuck could chuck wood"
        paper = Paper(sentence)
        paper?.edit("chuck", "HELLO", pencil)

        assertEquals(expectedText, paper?.getSentence())
        assertEquals(expectedEraserDegrationValue, pencil.EraserDurability)
    }

    @Test
    fun `GIVEN a paper with text WHEN i want to edit a word with a new word of the greater length THEN the editing should happen and letters that collide will have '@'`() {
        var expectedText = "How much wood would a woodchuck chuck if a woodchuck could HELLOH@ood"
        val expectedEraserDegrationValue = 45
        val expectedDurability = 36

        var pencil = Pencil()
        var sentence = "How much wood would a woodchuck chuck if a woodchuck could chuck wood"
        paper = Paper(sentence)
        paper?.edit("chuck", "HELLOHI", pencil)

        assertEquals(expectedText, paper?.getSentence())
        assertEquals(expectedEraserDegrationValue, pencil.EraserDurability)
        assertEquals(expectedDurability, pencil.durability)
    }
}

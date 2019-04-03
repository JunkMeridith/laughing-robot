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
    fun givenAPaperWhenYouWriteASentenceThenTheSentenceIsStored() {
        val sentence = "this is a sentence"
        val paper: Paper = Paper(sentence)
       //  assertEquals( Paper::class.java, paper::class.java)
        assertEquals(sentence, paper.getSentence())
    }
}

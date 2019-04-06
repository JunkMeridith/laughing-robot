package com.example.pencilduration

import org.junit.Assert.*
import org.junit.Test

class PencilTest {
    @Test
    fun GIVEN_I_Have_No_Pencil_WHEN_A_Pencil_Is_Created_THEN_Pencil_will_have_durability() {
        var pencil = Pencil()
        assertEquals(50, pencil.durability)
    }

    @Test
    fun GIVEN_I_want_a_pencil_with_20_durability_WHEN_I_create_the_pencil_THEN_the_pencil_will_have_durability_of_twenty() {
        var pencil = Pencil(20)
        assertEquals(20, pencil.durability)
    }

    @Test
    fun Given_A_Pencil_When_I_Write_Then_the_Pencil_Degrades() {
        var pencil = Pencil(50)
        pencil.writeSentence("hello")
        assertEquals(45, pencil.durability)

    }

    @Test
    fun Given_A_Pencil_When_I_Write_Then_the_Pencil_DegradesbyCharacter() {
        var pencil = Pencil(50)
        pencil.writeSentence("Hello")
        assertEquals(44, pencil.durability)

    }

    @Test
    fun Given_A_Pencil_When_I_Write_Then_the_Pencil_DegradesbyCharacter_andNotWhitespace() {
        var pencil = Pencil(50)
        pencil.writeSentence("Hello World")
        assertEquals(38, pencil.durability)
    }

    @Test
    fun Given_A_Pencil_When_I_Write_Then_the_Pencil_DegradesbyCharacter_andNotNewLine() {
        var pencil = Pencil(50)
        pencil.writeSentence(System.lineSeparator())
        assertEquals(50, pencil.durability)
    }

    @Test
    fun `GIVEN A pencil using default constructor WHEN the pencil is sharpend THEN the durability of the pencil will be 50`() {
        var pencil = Pencil()
        pencil.writeSentence("Hello World")

        pencil.sharpen()

        assertEquals(50, pencil.durability)

    }

    @Test
    fun `GIVEN A pencil using specified durability constructor WHEN the pencil is sharpend THEN the durability of the pencil will be 50`() {
        var pencil = Pencil(40)
        pencil.writeSentence("Hello World")

        pencil.sharpen()

        assertEquals(40, pencil.durability)
        assertEquals(50, pencil.EraserDurability)
    }

    @Test
    fun `GIVEN no pencil WHEN I create a pencil THEN I have a default sharpening capability of 5`() {
        var pencil = Pencil()
        assertEquals(5, pencil.remainingSharpenings)
    }

    @Test
    fun `Given no pencil, WHEN I create a pencil with sharpening capability of 200, THEN I have a pencil that can be shapened 200 times`() {
        var pencil = Pencil(50, 200)
        assertEquals(200, pencil.remainingSharpenings)
        assertEquals(50, pencil.durability)
        assertEquals(50, pencil.EraserDurability)
    }

    @Test
    fun `Given no pencil, WHEN I create a pencil using durability constructor, THEN I have a pencil that can be shapened 5 times`() {
        var pencil = Pencil(50)
        assertEquals(5, pencil.remainingSharpenings)
    }

    @Test
    fun `Given a pencil with 5 sharpenings When I sharpen the pencil Then the Sharpenings decrease to 4`() {
        var pencil = Pencil()
        pencil.sharpen()
        assertEquals(4, pencil.remainingSharpenings)
    }

    @Test
    fun `Given a pencil with no sharpenings, When I sharpen Then the durability stays the same`() {
        var pencil = Pencil(10, 0)
        pencil.writeSentence("Hello")
        pencil.sharpen()
        assertEquals(4, pencil.durability)
    }

    @Test
    fun `Given a pencil When I construct the pencil Then I should have default eraser durability`() {
        var pencil = Pencil()
        assertEquals(50, pencil.EraserDurability)
    }

    @Test
    fun `Given a pencils with an eraser When I erase Then the eraser durability decreses`() {
        var pencil = Pencil()
        pencil.erase("Hello")
        assertEquals(45, pencil.EraserDurability)
    }

    @Test
    fun `Given a pencil WHEN i specify the eraser durability THEN the pencil will have that durability`() {
        var expectedEraserDurability = 100
        var pencil = Pencil(durability = 50, remainingSharpenings = 5, EraserDurability = expectedEraserDurability)
        var actualEraserDurability = pencil.EraserDurability

        assertEquals(expectedEraserDurability, actualEraserDurability)
    }
}
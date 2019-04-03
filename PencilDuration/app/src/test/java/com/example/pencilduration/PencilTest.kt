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
}
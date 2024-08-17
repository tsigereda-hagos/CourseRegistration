package edu.mum.se.miusched.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UtilsTest {


    @Test
    void testGetMonth() {
        assertEquals("January", Utils.getMonth(1));
    }
}


package edu.mum.se.miusched.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AdminControllerTest {


    @Test
    void testShowMainAdminPage() {

        assertEquals("main-admin", (new AdminController()).showMainAdminPage());
    }
}


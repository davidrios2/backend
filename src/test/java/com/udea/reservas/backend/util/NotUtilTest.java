package com.udea.reservas.backend.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotUtilTest {

    private final NotUtil notUtil = new NotUtil();

    @Test
   void testSum() {
        int result = notUtil.sum(2, 3);
        assertEquals(5, result, "3 + 2 = 5");
    }

    @Test
  void testIsPalindrome() {
        boolean result = notUtil.isPalindrome("");
        assertTrue(result, "el String vacìo es palíndromo");
    }
}

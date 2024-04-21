package com.udea.reservas.backend.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotUtilTest {

    private final NotUtil notUtil = new NotUtil();

    @Test
    public void testSum() {
        int result = notUtil.sum(2, 3);
        assertEquals(5, result, "Sum of 2 and 3 should be 5");
    }

    @Test
    public void testIsPalindrome() {

        boolean result = notUtil.isPalindrome("");
        assertEquals(true, result, "'blank' is a palindrome");
    }
}

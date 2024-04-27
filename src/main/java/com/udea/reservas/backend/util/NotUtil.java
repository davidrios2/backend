package com.udea.reservas.backend.util;

public class NotUtil {

    int sum(int a, int b) {
        return a + b;
    }

    public boolean isPalindrome(String inputString) {
        if (inputString.isEmpty()) {
            return true;
        } else {
            char firstChar = inputString.charAt(0);
            char lastChar = inputString.charAt(inputString.length() - 1);
            String mid = inputString.substring(1, inputString.length() - 1);
            return (firstChar == lastChar) && isPalindrome(mid);
        }
    }

}

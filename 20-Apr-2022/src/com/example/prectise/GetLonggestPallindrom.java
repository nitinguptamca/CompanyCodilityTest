package com.example.prectise;

public class GetLonggestPallindrom {
    public static final String pallingdromString = "nitin";

    public static void main(String[] args) {
        String maxPalindrom = "";
        for (int i = 0; i < pallingdromString.length(); i++) {
            for (int j = i + 1; j <= pallingdromString.length(); j++) {
                String act = pallingdromString.substring(i, j);
                String actRes = reverseString(act);
                if (act.equalsIgnoreCase(actRes) && act.length() > maxPalindrom.length()) {
                    maxPalindrom = act;
                }
            }
        }

        System.out.println("maxPalindrom      " + maxPalindrom);
    }

    public static String reverseString(String str) {
        // return new StringBuffer(str).reverse().toString();
        String reverse = "";
        for (int i = str.length()-1; i >= 0; i--) {
            reverse +=str.charAt(i);
        }
        return reverse;
    }
}

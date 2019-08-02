package com.CK;

public class Main {

    public static void main(String[] args) {
//        String a = "1010", b = "1011";
//        String a = "111", b = "11";
        String a = "0", b = "0";
        Solution solution = new Solution();
        System.out.println(solution.addBinary(a, b));
    }
}

class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0) return b;
        if (b.length() == 0) return addBinary(b, a);
        int carry = 0, lenA = a.length(), lenB = b.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= Math.max(a.length(), b.length()); i++) {
            int charA = lenA - 1 - i >= 0 ? Integer.parseInt(String.valueOf(a.charAt(lenA - 1 - i))) : 0;
            int charB = lenB - 1 - i >= 0 ? Integer.parseInt(String.valueOf(b.charAt(lenB - 1 - i))) : 0;
            if (charA + charB + carry >= 2) {
                sb.insert(0, charA + charB + carry - 2);
                carry = 1;
            } else {
                if (i == Math.max(a.length(), b.length()) && charA + charB + carry == 0) continue;
                sb.insert(0, charA + charB + carry);
                carry = 0;
            }
        }
        return sb.toString();
    }
}

class Solution2 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
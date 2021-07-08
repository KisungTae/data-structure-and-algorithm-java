package com.company.bitmanipulation;

// two's compliment --> https://master-hun.tistory.com/48

// The arithmetic right shift essentially divides by two. >> operator, shifts bits by 1 not putting 0 in the most significant bit

// In a logical right shift, we shift the bits and put a 0 in the most significant bit. It is indicated with a >>> operator.

public class BitManipulation {
    public BitManipulation() {
        System.out.println(Integer.toBinaryString(~1));
    }
}

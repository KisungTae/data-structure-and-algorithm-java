package com.company.bitmanipulation;

// two's compliment --> https://master-hun.tistory.com/48

// The arithmetic right shift essentially divides by two. >> operator, shifts bits by 1 not putting 0 in the most significant bit

// In a logical right shift, we shift the bits and put a 0 in the most significant bit. It is indicated with a >>> operator.

// clear i bit --> int mask = =(1 << i); return num & mask;

// clear most significant to i --> int mask = (1 << i) - 1; return num & mask;

// clear i to 0 --> 2 int mask = (-1 << (i + 1)); return num & mask;

public class BitManipulation {
    public BitManipulation() {
        System.out.println(Integer.toBinaryString(~1));
    }
}

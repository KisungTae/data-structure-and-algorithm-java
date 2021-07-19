package com.company.bitmanipulation;

//Binary to String: Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
//        print the binary representation. If the number cannot be represented accurately in binary with at
//        most 32 characters, print"ERROR:'

// https://www.youtube.com/watch?v=vOO-oLS0H68&t=298s
// https://www.youtube.com/watch?v=8afbTaA-gOQ&t=3s
// https://www.youtube.com/watch?v=PZRI1IfStY0


public class Question2Review {
    public Question2Review() {
        double n = 0.5;
        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.length() <= 32 && n > 0) {
            System.out.println(n);
            n *= 2.0;
            stringBuilder.append((int) n);
            if (n > 1)
                n -= 1.0;
        }
        if (stringBuilder.length() > 32) System.out.println("ERROR");
        else System.out.println(stringBuilder.toString());
    }
}

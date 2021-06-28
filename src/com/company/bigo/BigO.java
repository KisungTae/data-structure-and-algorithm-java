package com.company.bigo;


// 1 + 2 + 4 + 8 + 16 + ... + X = 2X - 1
// 2^0 + 2^1 + 2^2 + 2^3 + 2^4 + ... + 2^x = 2^(x+1) - 1

// recursive function runtime is O(branches ^ depth)

// As you may recall, the base of a log doesn't matter for big O since logs of different bases are
// only different by a constant factor. However, this does not apply to exponents. The base of an
// exponent does matter. Compare 2^n and 8n. If you expand 8^n, you get (2^3)n, which equals 2^3n,
// which equals 2^2n * 2^n. As you can see, 8^n and 2^n are different by a factor of 2^2n. That is very much
// not a constant factor!

// 1 + 2 + 3 + ... + n - 1 = n(n-1)/2
// 1 + 2 + 3 + ... + n = n(n+1)/2

// nPr = n!/(n-r)!
// nCr = n!/(n-r)!r!

public class BigO {
    public BigO() {
        int n = 25;
        System.out.println(n + " is prime: " + isPrime(n));
    }

    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

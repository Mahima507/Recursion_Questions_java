class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        if (b.length == 0) return 1;

        a = a % MOD; // Reduce 'a' to the range [0, 1336]

        int result = 1;
        for (int i = 0; i < b.length; i++) {
            int digit = b[i];
            result = (pow(result, 10) * pow(a, digit)) % MOD;
        }

        return result;
    }

    private int pow(int base, int exponent) {
        if (exponent == 0) return 1;

        base = base % MOD; // Reduce 'base' to the range [0, 1336]

        if (exponent % 2 == 0) {
            int halfPow = pow(base, exponent / 2);
            return (halfPow * halfPow) % MOD;
        } else {
            int halfPow = pow(base, exponent / 2);
            return (((halfPow * halfPow) % MOD) * base) % MOD;
        }
    }
}




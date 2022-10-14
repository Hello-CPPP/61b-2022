package DebugExercise;

public class Cal {
    public static void main(String[] args) {
        test();
    }

    static int gcd(int a, int b) {
        //int c = a % b;
        if (a % b == 0) {
            return b;
        }
        return gcd(b, (a % b));
    }

    static void test() {
        System.out.println(gcd(1071, 462));
    }
}

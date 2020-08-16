package com.arithmetic.leetcode;

public class EmptyBottle {

    public static void main(String[] args) {

        int n = 10000000;
        int total = 0;
        long start = System.currentTimeMillis();
        while (n > 3) {
            int add = n / 3;
            total += add * 3;
            n = add + n % 3;
        }

        total += n;

        System.out.println(total);
        System.out.println(System.currentTimeMillis() - start);

    }

//    public static void main(String[] args) {
//        int n = 10000000;
//        int i = 0;
//        long start = System.currentTimeMillis();
//        while (true) {
//            n -= 3;
//            n++;
//            if (n < 3) {
//                System.out.println("共喝了" + (50 + i) + "瓶");
//                break;
//            }
//        }
//        System.out.println(System.currentTimeMillis() - start);
//    }

}

package com.learn.fqy;

public class Fibonacci {

    public static int fibonacci1(int orderNumber) {
        if ((0 == orderNumber) || (1 == orderNumber))
            return orderNumber;
        else
            return fibonacci1(orderNumber - 1) + fibonacci1(orderNumber - 2);
    }

    public static int fibonacci(int orderNumber) {
        orderNumber--;
        return fibonacci1(orderNumber);
    }

    public static void main(String[] args) {
        int orderNumber = 11;
        System.out.println("第" + orderNumber + "个数是：" + fibonacci(orderNumber));
    }

}

package com.example.javalib;

import java.util.ArrayList;
import java.util.List;


class JavaTest {

    public static void main(String[] args) {
        JavaTest test = new JavaTest();
        List<JavaTest.Fruit> list = new ArrayList<>();
//        List<JavaTest.Apple> list = new ArrayList<>();
//        List<JavaTest.GreenApple> list = new ArrayList<>();
//        List<JavaTest.AppleAndMeat> list = new ArrayList<>();

        test.addApple(list);
        test.addSuperApple(list);
        test.addExtendsApple(list);
        test.addExtendsTApple(list);
        test.addExtendsTAppleAndMeat(list);
        test.addUnboundedList(list);

        test.printApple(list);
        test.printSuperApple(list);
        test.printExtendsApple(list);
        test.printExtendsTApple(list);
        test.printExtendsTAppleAndMeat(list);
        test.printUnboundedList(list);

    }

    void addApple(List<Apple> list) {
        list.add(new Fruit()); // error
        list.add(new Apple());
        list.add(new GreenApple());
    }

    void addSuperApple(List<? super Apple> list) {
        list.add(new Fruit()); // error
        list.add(new Apple());
        list.add(new GreenApple());
    }

    // T super Apple can't
        <T super Apple>

    void addSuperTApple(List<T> list) {
        list.add(new Fruit());
        list.add(new Apple());
        list.add(new GreenApple());
    }

    void addExtendsApple(List<? extends Apple> list) {
        list.add(new Fruit()); // error
        list.add(new Apple()); // error
        list.add(new GreenApple()); // error
    }

    <T extends Apple> void addExtendsTApple(List<T> list) {
        list.add(new Fruit()); // error
        list.add(new Apple()); // error
        list.add(new GreenApple()); // error
    }

    <T extends Apple & Meat> void addExtendsTAppleAndMeat(List<T> list) {
        list.add(new Fruit()); // error
        list.add(new Apple()); // error
        list.add(new GreenApple()); // error
        list.add(new AppleAndMeat()); // error
    }

    void addUnboundedList(List<?> list) {
        list.add(new Fruit()); // error
        list.add(new Apple()); // error
        list.add(new GreenApple()); // error
    }

    void printApple(List<Apple> list) {
        for (Apple apple : list) {
            System.out.println(apple.toString());
        }
    }

    void printSuperApple(List<? super Apple> list) {
        for (Apple apple : list) { // error
            System.out.println(apple.toString());
        }
    }

    void printExtendsApple(List<? extends Apple> list) {
        for (Apple apple : list) {
            System.out.println(apple.toString());
        }
    }

    <T extends Apple> void printExtendsTApple(List<T> list) {
        for (Apple apple : list) {
            System.out.println(apple.toString());
        }
    }

    <T extends Apple & Meat> void printExtendsTAppleAndMeat(List<T> list) {
        for (Apple apple : list) {
            System.out.println(apple.toString());
        }
    }

    void printUnboundedList(List<?> list) {
        for (Object object : list) {
            System.out.println(object.toString());
        }
    }

    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    static class GreenApple extends Apple {
    }

    static class AppleAndMeat extends Apple implements Meat {

    }

    interface Meat {

    }
}
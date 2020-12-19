package com.example.javalib

import java.util.*

internal class KotlinTest {

    companion object {

        fun main(args: Array<String>) {
            val test = KotlinTest()

            val list: MutableList<Fruit> = ArrayList()
//            val list: MutableList<Apple> = ArrayList()
//            val list: MutableList<GreenApple> = ArrayList()
//            val list: MutableList<AppleAndMeat> = ArrayList()

            test.addApple(list)
            test.addSuperApple(list)
            test.addExtendsApple(list)
            test.addExtendsTApple(list)
            test.addExtendsTAppleAndMeat(list)
            test.addUnboundedList(list)

            test.printApple(list)
            test.printSuperApple(list)
            test.printExtendsApple(list)
            test.printExtendsTApple(list)
            test.printExtendsTAppleAndMeat(list)
            test.printUnboundedList(list)
        }

    }


    fun addApple(list: MutableList<Apple>) {
        list.add(Fruit()) // error
        list.add(Apple())
        list.add(GreenApple())
    }

    fun addSuperApple(list: MutableList<in Apple>) {
        list.add(Fruit()) // error
        list.add(Apple())
        list.add(GreenApple())
    }

    // error
    fun <T in Apple> addSuperTApple(list: MutableList<T?>) {
        list.add(Fruit())
        list.add(Apple())
        list.add(GreenApple())
    }

    fun addExtendsApple(list: MutableList<out Apple>) {
        list.add(Fruit()) // error
        list.add(Apple()) // error
        list.add(GreenApple()) // error
    }

    fun <T : Apple> addExtendsTApple(list: MutableList<T>) {
        list.add(Fruit()) // error
        list.add(Apple()) // error
        list.add(GreenApple()) // error
    }

    fun <T> addExtendsTAppleAndMeat(list: MutableList<T>) where T : Apple?, T : Meat? {
        list.add(Fruit()) // error
        list.add(Apple()) // error
        list.add(GreenApple()) // error
        list.add(AppleAndMeat()) // error
    }

    fun addUnboundedList(list: MutableList<*>) {
        list.add(Fruit()) // error
        list.add(Apple()) // error
        list.add(GreenApple()) // error
    }

    fun printApple(list: List<Apple>) {
        for (apple in list) {
            System.out.println(apple.toString())
        }
    }

    fun printSuperApple(list: List<in Apple>) { // error
        for (apple in list) { // super 는 write 만 가능함!
            System.out.println(apple.toString())
        }
    }

    fun printExtendsApple(list: List<Apple>) {
        for (apple in list) { // extends 는 read 에서 당연히 사용 가능하다. Apple, GreenApple 다 상관없다.
            System.out.println(apple.toString())
        }
    }

    fun <T : Apple?> printExtendsTApple(list: List<T>) {
        for (apple in list) {
            System.out.println(apple.toString())
        }
    }

    fun <T> printExtendsTAppleAndMeat(list: List<T>) where T : Apple?, T : Meat? {
        for (apple in list) {
            System.out.println(apple.toString())
        }
    }

    fun printUnboundedList(list: List<*>) {
        for (obj in list) {
            System.out.println(obj.toString())
        }
    }

    //error
    fun <T> isA(value: Any) = value is T

    inline fun <reified T> isAWithReified(value: Any) = value is T

    internal open class Fruit
    internal open class Apple : Fruit()
    internal class GreenApple : Apple()
    internal class AppleAndMeat : Apple(), Meat
    internal interface Meat

}

package com.api.nothidg;

import java.io.Console;
import java.util.Collections;
import java.util.HashSet;

public class NewClass {
    int a = 10;
    static int b = 15;

    void m3() {
        System.out.println("Class NewClass, method m3()");
        return;
    }

    public NewClass() {
    }

    public NewClass(int a) {
        this.a = a;
    }

   static class A implements B {
        void m1() {
            System.out.println("Class A, method m1()");
            Console console = System.console();
            if (console == null) {
                System.out.println("No console available");
                return;
            }

            String username = console.readLine("Enter your username: ");
            char[] password = console.readPassword("Enter your password: ");

            // Process the input
            String passwordStr = new String(password);
            java.util.Arrays.fill(password, ' '); // Clear the password array

            System.out.println("Username: " + username);
            System.out.println("Password: " + passwordStr);
        }

    }

    interface B {
        default void m2() {
            System.out.println("Interface B, method m2()");
        }
    }

    public static void main(String[] args) {
        NewClass newClass = new NewClass();
        System.out.println(newClass.a);
        System.out.println(b);
        newClass.m3();
//        Collections
//        HashSet
        A a = new A();
        a.m1();
        a.m2();
    }
}


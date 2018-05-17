package ru.melpholan.osmp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MAin {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/root-context.xml");

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/root-context.xml");

        System.out.println(ctx);

    }
}

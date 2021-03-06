package ru.innopolis.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Human humanProxy = (Human) Proxy.newProxyInstance(
                EuropeanHuman.class.getClassLoader(),
                new Class[]{Human.class},
                new HumanInvocation());
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            humanProxy.eat("bread", 2);
            System.out.println(humanProxy.say());
            humanProxy.sleep(6);
            scanner.nextLine();
        }

        /*Human human = new EuropeanHuman();
        System.out.println(human.say());
        human.eat("banana", 5);
        ClassLoader parentLoader = EuropeanHuman.class.getClassLoader();
        HumanLoader humanLoader = new HumanLoader(parentLoader);
        Class humanClass = humanLoader.loadClass("ru.innopolis.stx13._7_classLoader.magic.proxy.EuropeanHuman");
        System.out.println(humanClass.getMethod("say").invoke(humanClass.newInstance(), null));
        */
    }
}

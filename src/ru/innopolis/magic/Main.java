package ru.innopolis.magic;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        ClassLoader parentClassLoader = Human.class.getClassLoader();
        Class magicClass = parentClassLoader.loadClass("file:/home/sa/study/Task-lesson7-180918/out/production/Task-lesson7-180918/ru/innopolis/Human.class");
        Human magic = (Human) magicClass.newInstance();
        //magicClass.cast();

        KindMagicClassLoader kindMagicClassLoader = new KindMagicClassLoader(parentClassLoader);
        Class kindMagicClass = kindMagicClassLoader.loadClass("file:/home/sa/study/Task-lesson7-180918/out/production/Task-lesson7-180918/ru/innopolis/Human.class");
        kindMagicClass.getMethod("cast").invoke(kindMagicClass.newInstance());
        //Human magic2 = (Human) kindMagicClass.newInstance();
    }
}

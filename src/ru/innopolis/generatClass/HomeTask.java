package ru.innopolis.generatClass;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class HomeTask {

    String readAndWriteSourseCode() throws IOException {
        //System.out.print("Введите имя файла: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //String className = bufferedReader.readLine();

        String up = "package ru.innopolis.generatClass;\n\npublic class SomeClass {\n\nvoid doWork() {";
        String down = "   }\n}";
        System.out.println("Введите реализацию метода (для завершения ввода нажмите ctrl+D): ");
        String line;
        StringBuilder sb = new StringBuilder().append(up);
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        sb.append(down);
        File file = new File("src/ru/innopolis/generatClass/SomeClass.java");
        FileWriter writer = new FileWriter(file);
        writer.write(sb.toString());
        writer.flush();
        writer.close();
        return file.getAbsolutePath();
    }

    void compiler(String pathToSourseCode) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, pathToSourseCode);
    }

    void call() throws Exception {
        ClassLoader classLoader = HomeTask.class.getClassLoader();
        Class<?> homeTaskClazz = classLoader.loadClass("ru.innopolis.generatClass.SomeClass");
        Constructor<?> constructor = homeTaskClazz.getConstructors()[0];
        Method doWork = homeTaskClazz.getMethod("doWork");
        doWork.invoke(constructor.newInstance());
    }
}
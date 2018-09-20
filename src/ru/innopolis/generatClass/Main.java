package ru.innopolis.generatClass;

public class Main {
    public static void main(String[] args) throws Exception {
        HomeTask homeTask = new HomeTask();
        String pathToSourceCode = homeTask.readAndWriteSourseCode();

        homeTask.compiler(pathToSourceCode);
        homeTask.call();
    }
}

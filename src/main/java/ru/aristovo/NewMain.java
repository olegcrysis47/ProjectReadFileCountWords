package ru.aristovo;

import ru.aristovo.file.WorkWithFile;
import ru.aristovo.file.WorkWithMap;

import java.util.Map;

public class NewMain {

    public static void main(String[] args) {

        String str = WorkWithFile.readPath();
        Map<String, Integer> map = WorkWithFile.readFile(str);
        WorkWithMap.viewMap(map);

        System.out.println("-----------------------");
        System.out.println("Самые частые слова");
        WorkWithMap.maxRate(map);

    }
}

package ru.aristovo.file;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class WorkWithFile {

    //метод считывает строку с консоли
    public static String readPath() {
        String strPath = null;
        System.out.println("Введите путь к файлу:");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            strPath = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strPath;
    }

    //метод считывает файл с консоли и формирует map
    public static Map<String, Integer> readFile(String strPath) {
        Map<String, Integer> map = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(strPath));
            while (reader.ready()) {
                String strText = reader.readLine();
                String[] words = strText.split("\\s*(\\s|,|\\.|/|:|;|\"|\'|\\?|!)\\s*");
                map = WorkWithMap.createdMap(map, words);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}

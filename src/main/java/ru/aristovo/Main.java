package ru.aristovo;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        try {
            //Открываем поток чтения с консоли пути к файлу
            BufferedReader readerPath = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите путь к файлу:");
            String strPath = readerPath.readLine();
            System.out.println("-----------------------------------------------------");
            //Закрываем поток чтение с консоли
            readerPath.close();
            //Открываем поток чтения файла
            BufferedReader readerFile = new BufferedReader(new FileReader(strPath));
            //Создаем map для хранения строк и их количества
            Map<String, Integer> map = new TreeMap<String, Integer>();
            //Читаем файл по строкам
            while (readerFile.ready()) {
                //Считываем строку из файла
                String str = readerFile.readLine();
                //Преобразовываем строку в массив слов
                String[] strText = str.split("\\s*(\\s|,|\\.|/|:|;|\"|\'|\\?|!)\\s*");
                //Заполняем map
                for (String s : strText) {
                    //Приводим слова к нижнему регистру
                    s = s.toLowerCase();
                    //Проверяем map на наличие ключа s
                    if (map.containsKey(s)) {
                        //если ключ s в map есть
                        //по ключу получаем значение и увеличиваем на единицу
                        int i = map.get(s) + 1;
                        //возращаем ключ с новым значением в map
                        map.put(s, i);
                    } else {
                        //если ключа s в map нет
                        //создаем новый ключ в map
                        map.put(s, 1);
                    }
                }
            }
            //Закрываем поток чтения файла
            readerFile.close();
            //Выводим статистику слов из map на экран, параллельно считаем максимальное значение
            int maxValue = 0;
            System.out.println("Выводим содержимое map на экран:");
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                System.out.println("Ключ: " + pair.getKey() + " Значение: " + pair.getValue());
                if (maxValue < pair.getValue()) maxValue = pair.getValue();
            }
            System.out.println("-----------------------------------------------------");
            System.out.println("Слово (Слова) с максимальной частотой в map:");
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                if (pair.getValue() == maxValue)
                    System.out.println("Слово: " + pair.getKey() + " встречается: " + pair.getValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

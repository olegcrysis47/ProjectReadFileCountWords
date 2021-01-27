package ru.aristovo.file;

import java.util.Map;
import java.util.TreeMap;

public class WorkWithMap {

    //формирование map
    public static Map<String, Integer> createdMap(Map<String, Integer> map, String[] words) {
        if (map == null) map = new TreeMap<String, Integer>();
        for (String s : words) {
            s = s.toLowerCase();
            if (map.containsKey(s)) {
                int i = map.get(s) + 1;
                map.put(s, i);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }

    //вывод map на экран
    public static void viewMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    //нахождение максимального значения map
    public static Integer maxValueMap(Map<String, Integer> map) {
        int max = 0;
        for (Map.Entry<String, Integer> pair: map.entrySet()) {
            if (max < pair.getValue()) max = pair.getValue();
        }
        return max;
    }

    //вывод слов с наибольшей частотой
    public static void maxRate(Map<String, Integer> map) {
        //int max = maxValueMap(map);
        for (Map.Entry<String, Integer> pair: map.entrySet()) {
            if (maxValueMap(map) == pair.getValue())
                System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

}

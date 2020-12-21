package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> firstMap = new HashMap<>();
        Map<String, Integer> secondMap = new HashMap<>();
        Map<String, Integer> thirdMap = new HashMap<>();
        List<Map<String, Integer>> products = List.of(firstMap, secondMap, thirdMap);
        firstMap.put("tables", 14);
        firstMap.put("chairs", 6);
        secondMap.put("bananas", 14);
        secondMap.put("apples", 5);
        thirdMap.put("chairs", 24);
        thirdMap.put("bananas", 6);

        System.out.println(countProduct(products));
    }

    public static Map<String, Integer> countProduct(List<Map<String, Integer>> products) {
        return products.stream()
                .flatMap(prod -> prod.entrySet().stream())
                .collect(groupingBy(Map.Entry::getKey, summingInt(Map.Entry::getValue)));
    }
}

package com.prectise.tough.customeHashMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxWordCount {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/company/TechMahendra/FunctionalInterfaceConceptCheck.java");
        Stream<String> stringStream = Files.lines(path);
        Stream<String> lines = stringStream.flatMap(line -> Arrays.stream(line.trim().split(" ")));
        Stream<String> hjds = lines.map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim());
        Map<String, Long> countWords = hjds.filter(s -> !s.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<AbstractMap.SimpleEntry<String, Integer>, Long> countwordsaa = hjds.map(word -> new AbstractMap.SimpleEntry<>(word, 1)).sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        Map<String, Long> wordCount3 = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.counting()));

    }
}

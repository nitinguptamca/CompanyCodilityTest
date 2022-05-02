package com.example.prectise.java8;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



//Check functionalInterface functionality.

@FunctionalInterface
interface Test1 {
    void display1();
}

@FunctionalInterface
interface Test2 extends Test1 {
    void display1();
}

@FunctionalInterface
interface Test3 extends Test2, Test1 {
    void display1();
}

@FunctionalInterface
interface ShortToByteFunction {
    byte applyAsByte(short s);
}

public class FunctionalInterfaceConceptCheck {
    /// Legacy Functional Interfaces
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello From Another Thread"));
        thread.start();
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());
        value = nameMap.computeIfAbsent("John", String::length);
        System.out.println(value);

        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);
       // assertEquals("'5'", quoteIntToString.apply(5));

        short[] array = { (short) 1, (short) 2, (short) 3 };
        byte[] transformedArray = transformArray(array, s -> (byte) (s * 2));

        byte[] expectedArray = { (byte) 2, (byte) 4, (byte) 6 };
      //  assertArrayEquals(expectedArray, transformedArray);

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);

        int[] fibs = { 0, 1 };
        Stream<Integer> fibonacci = Stream.generate(() -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        });

        System.out.println(fibonacci.toString());

        List<String> names = Arrays.asList("John", "Freddy", "Samuel");
        names.forEach(name -> System.out.println("Hello, " + name));

        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);

        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));

        names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");
        names.replaceAll(name -> name.toUpperCase());
        names.replaceAll(String::toUpperCase);
        List<String> namesWithA = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        values.stream().mapToInt(a -> a).sum();
        values.stream().mapToInt(Integer::intValue).sum();
        //// IntStream perfect valid scenario

        int[] intArray = IntStream.of(1, 2, 3, 4, 5).toArray();
        List<Integer> ints = IntStream.of(1, 2, 3, 4, 5).mapToObj(Integer::valueOf).collect(Collectors.toList());
        List<Integer> ints1 = IntStream.of(1, 2, 3, 4, 5).boxed().collect(Collectors.toList());

        // ***********************
        int sum = values.stream().reduce(0, (i1, i2) -> i1 + i2);
        sum = values.stream().mapToInt(a -> a).sum();
        int[] values11 = { 3, 5, 8, 9, 12 };
        sum = Arrays.stream(values11).sum();
        int[]array2 =  IntStream.rangeClosed(1, 10).toArray();

        List<String> string = Arrays.asList("aA12Z22", "qwerty", "ABCDEF0");

        boolean valid = Stream.of(string).flatMapToInt(s -> {
            if (((CharSequence) s).length() < 5)
                return IntStream.of(42); // 42 is a '*' char
            else
                return ((CharSequence) s).chars();
        }).mapToObj(i -> (char) i).allMatch(c -> Character.isLetterOrDigit(c));
        System.out.println(valid);

    }

    public static byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsByte(array[i]);
        }
        return transformedArray;
    }

    public static double squareLazy(Supplier<Double> lazyValue) {
        return Math.pow(lazyValue.get(), 2);
    }

}


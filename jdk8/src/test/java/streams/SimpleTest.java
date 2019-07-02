package streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SimpleTest {

    @Test
    void shouldDisplayAllStreamElements() {
        println(Data.NAMES.stream().collect(Collectors.toList()));
    }

    @Test
    void shouldDisplayUniqueStreamElements() {
        println(Data.NAMES.stream().distinct().collect(Collectors.toList()));
    }

    @Test
    void shouldDisplayOnlyFiveLetterStreamElements() {
        println(Data.NAMES.stream().filter(e -> e.length() == 5).collect(Collectors.toList()));
    }

    @Test
    void shouldDisplayOnlyFiveElements() {
        println(Data.NAMES.stream().limit(5).collect(Collectors.toList()));
    }

    @Test
    void shouldMapElementsToLenght() {
        println(Data.NAMES.stream().map(String::length).collect(Collectors.toList()));
    }

    @Test
    void shouldFlatMapElements() {
        println(Data.NAMES.stream().flatMap(s -> Stream.of(s.split(""))).distinct().collect(Collectors.toList()));
    }

    @Test
    void shouldMatchElements() {
        println(Stream.of(Data.ARRAY_OF_NAMES).anyMatch(str -> str.endsWith("Robert")));
        println(Stream.of(Data.ARRAY_OF_NAMES).allMatch(str -> str.length() > 3));
        println(Stream.of(Data.ARRAY_OF_NAMES).noneMatch(str -> str.endsWith("Kazimierz")));
    }

    @Test
    void shouldFindElement() {
        Data.NAMES.parallelStream().filter(str -> str.startsWith("T")).findAny().ifPresent(this::println);
        Data.NAMES.parallelStream().filter(str -> str.startsWith("T")).findFirst().ifPresent(this::println);
    }

    @Test
    void shouldReduceNamesAndCountTotalLength() {
        Data.NAMES.stream().map(String::length).reduce(Integer::sum).ifPresent(this::println);
    }

    @Test
    void shouldCountStreamElements() {
        println(Data.NAMES.stream().collect(Collectors.counting()));
    }

    @Test
    void shouldJoinAllNames() {
        println(Data.NAMES.stream().collect(Collectors.joining()));
        println(Data.NAMES.stream().collect(Collectors.joining(", ")));
        println(Data.NAMES.stream().distinct().collect(Collectors.joining(", ", "[", "]")));
    }

    @Test
    void shouldJoinAllNames_żółtko() {
        println(Data.NAMES.stream().collect(Collectors.reducing(0, String::length, Integer::sum)));
    }

    private void println(List list) {
        System.out.println(list);
    }
    private void println(boolean b) { System.out.println(b); }
    private void println(Object b) { System.out.println(b); }

}
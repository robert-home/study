package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Data {

    static final String[] ARRAY_OF_NAMES = {"Adam", "Bolesław", "Cezary", "Dariusz", "Edmund", "Feliks", "Grzegorz", "Henryk", "Ignacy", "Jerzy", "Krzysztof",
            "Leon", "Łukasz", "Mariusz", "Nikodem", "Olek", "Piotr", "Robert", "Robert", "Stefan", "Tadeusz", "Teodor", "Tomasz", "Tadeusz", "Wiktor", "Zenon"};

    static final List<String> NAMES = Arrays.asList(ARRAY_OF_NAMES);

    static final int[] ARRAY_OF_INTS = {1, 29, 900, 432, 523, 852, 52345, 2, 0, -4, 5, 55, -2304};

    public static void main(String[] args) {
        System.out.println(NAMES.size());
        System.out.println(NAMES.stream().filter(p -> p.length() > 5).collect(Collectors.toList()));

        System.out.println(Arrays.stream(ARRAY_OF_INTS));
    }

}

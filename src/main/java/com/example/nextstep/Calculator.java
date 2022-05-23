package com.example.nextstep;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Calculator {

    public int add(String param) {

        int result = 0;
        String[] separator = {",", ":", "\n"};
        String regex = Arrays.stream(separator)
                .reduce((x, y) -> x + "|" + y).orElse(null);

        if (param == null || param.isEmpty()) {
            return 0;
        }

        if(param.length() == 1) {
            return Integer.parseInt(param);
        }

        if (param.contains(",")) {
            result = Arrays.stream(param.split(regex))
                    .mapToInt(item -> Integer.parseInt(item))
                    .sum();
        }

        return result;
    }
}

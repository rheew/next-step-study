package com.example.nextstep;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int add(String param) {
        int result = 0;

        if (isEmpty(param)) {
            return result;
        }

        final List<Integer> nums = findInt(param);

        result = nums.stream()
                .reduce((x, y) -> x + y)
                .orElse(null);

        return result;
    }

    private List<Integer> findInt(String s) {
        String[] separator = {",", ":", "\n"};
        String regex = Arrays.stream(separator)
                .reduce((x, y) -> x + "|" + y).orElse(null);

        return Arrays.stream(s.split(regex))
                .map(i -> Integer.parseInt(i))
                .collect(Collectors.toList());
    }

    private boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}

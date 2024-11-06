package com.inflearn;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
    @Test
    void main() {
        // given
        String str = "abccbbb";

        // when
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // then
        assertNull(map.get('D'));
        assertNotEquals(map.get('D'), map.get('a'));
        // null과 상수를 비교할 수 있다!
    }
}
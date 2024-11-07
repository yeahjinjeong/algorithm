package com.inflearn;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindAllAnagramTest {
    @Test
    void hashSetTest() {
        // HashSet과 HashSet의 비교
        HashSet<String> set = new HashSet<>();
        set.add("L");
        set.add("O");
        set.add("V");
        set.add("E");

        HashSet<String> set2 = new HashSet<>();
        set2.add("O");
        set2.add("E");
        set2.add("L");
        set2.add("V");

        assertEquals(set, set2);
    }

    @Test
    void hashMapTest() {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        String S = "sba";
        String T = "abs";

        for (char x : S.toCharArray()) {
            mapS.put(x, mapS.getOrDefault(x, 0) + 1);
        }

        for (char x : T.toCharArray()) {
            mapT.put(x, mapT.getOrDefault(x, 0) + 1);
        }

        assertEquals(mapS.keySet(), mapT.keySet());
        assertEquals(mapS, mapT);
    }
}
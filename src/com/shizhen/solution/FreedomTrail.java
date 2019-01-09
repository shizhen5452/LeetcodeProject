package com.shizhen.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/freedom-trail/
 */
public class FreedomTrail {

    private static Map<String, Map<Integer, Integer>> map;

    public static int findRotateSteps(String ring, String key) {
        map = new HashMap<>();
        return dfs(ring, key, 0);
    }

    private static int dfs(String ring, String key, int index) {
        if (index == key.length()) {
            return 0;
        }
        if (map.containsKey(ring) && map.get(ring).containsKey(index)) {
            return map.get(ring).get(index);
        }
        char ch = key.charAt(index);
        int f = findClock(ring, ch);
        int b = findAntiClock(ring, ch);
        int forward = 1 + f + dfs(ring.substring(f) + ring.substring(0, f), key, index + 1);
        int back = 1 + ring.length() - b + dfs(ring.substring(b) + ring.substring(0, b), key, index + 1);
        int res = Math.min(forward, back);
        Map<Integer, Integer> ans = map.getOrDefault(ring, new HashMap<>());
        ans.put(index, res);
        map.put(ring, ans);
        return res;
    }

    private static int findClock(String ring, char ch) {
        return ring.indexOf(ch);
    }

    private static int findAntiClock(String ring, char ch) {
        for (int i = ring.length() - 1; i >= 0; i--) {
            if (ring.charAt(i) == ch) {
                return i;
            }
        }
        return 0;
    }


}

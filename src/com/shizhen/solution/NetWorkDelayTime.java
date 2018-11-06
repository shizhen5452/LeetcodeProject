package com.shizhen.solution;

import java.util.*;

/**
 * https://leetcode.com/problems/network-delay-time/description/
 */
public class NetWorkDelayTime {
    Map<Integer, Integer> dist;

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<Integer, List<int[]>>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[]{0, K});
        dist = new HashMap<>();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int time = info[0];
            int node = info[1];
            if (dist.containsKey(node)) {
                continue;
            }
            dist.put(node, time);
            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    if (!dist.containsKey(edge[0])) {
                        heap.offer(new int[]{time + edge[1], edge[0]});
                    }
                }
            }
        }

        if (dist.size() != N) {
            return -1;
        }
        int res = 0;
        for (Integer value : dist.values()) {
            res = Math.max(res, value);
        }
        return res;
    }
}

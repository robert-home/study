package pl.rbudner.study.codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

class PhoneBilling2 {

    public static void main(String[] args) {
        StringBuilder input = new StringBuilder();
        input.append("00:01:07,400-234-090\n");
        input.append("00:05:01,701-080-080\n");
        input.append("00:05:00,400-234-090\n");
        input.append("00:04:59,701-080-080\n");
        System.out.println(new PhoneBilling2().solution(input.toString()));
    }

    public int solution(String S) {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(S));
        String line;
        Map<String, CallStats> log = new TreeMap<>();
        int maxDur = 0, totalCost = 0;
        try {
            while (null != (line = bufferedReader.readLine())) {
                String[] s1 = line.split(",");
                String[] s2 = s1[0].split(":");
                CallStats stat = log.get(s1[1]);
                if (stat == null) stat = new CallStats();
                int dur = Integer.valueOf(s2[0]) * 60 * 60 + Integer.valueOf(s2[1]) * 60 + Integer.valueOf(s2[2]);
                stat.add(dur);
                log.put(s1[1], stat);
                if (maxDur < stat.getTotalDuration()) maxDur = stat.getTotalDuration();
                totalCost += stat.getCost(dur);
            }
        } catch (IOException e) {
            return 0;
        }
        int discount = 0;
        for (Map.Entry<String, CallStats> entry : log.entrySet()) {
            if (entry.getValue().getTotalDuration() == maxDur) {
                discount = entry.getValue().getTotalCost();
                break;
            }
        }
        return totalCost - discount;
    }
}

class CallStats {
    private int totalDuration;
    private int totalCost;

    void add(int dur) {
        totalDuration += dur;
        totalCost += getCost(dur);
    }

    int getCost(int duration) {
        return (duration < 5 * 60) ? 3 * duration : 150 * (duration / 60) + ((duration % 60 > 0) ? 150 : 0);
    }

    int getTotalCost() {
        return totalCost;
    }

    int getTotalDuration() {
        return totalDuration;
    }
}

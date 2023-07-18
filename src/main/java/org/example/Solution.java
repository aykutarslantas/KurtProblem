package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {
    public static int uniqueWolfs(List<Integer> arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int minID = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && num < minID)) {
                maxCount = count;
                minID = num;
            }
        }

        return minID;
    }
}

public class Solution {
    public static void main(String[] args) {
        String outputPath = System.getProperty("user.home") + "/output.txt";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));

            int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
            String arrInput = bufferedReader.readLine().replaceAll("\\s+", "");

            List<Integer> arr = new ArrayList<>();
            for (char c : arrInput.toCharArray()) {
                int num = Character.getNumericValue(c);
                arr.add(num);
            }

            int result = Result.uniqueWolfs(arr);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

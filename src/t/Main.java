package t;

import java.util.Random;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(15) + 1;
        }
        System.out.println("Массив: " + Arrays.toString(array));
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("\nПовторяющиеся числа:");
        boolean foundDup = false;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                int count = entry.getValue();
                String times;
                if (count % 10 == 1 && count % 100 != 11) {
                    times = "раз";
                } else if (count % 10 >= 2 && count % 10 <= 4 && (count % 100 < 10 || count % 100 >= 20)) {
                    times = "раза";
                } else {
                    times = "раз";
                }
                System.out.printf("Число '%d' встречается %d %s%n", entry.getKey(), count, times);
                foundDup = true;
            }
        }
        if (!foundDup) {
            System.out.println("Повторяющихся чисел не найдено!");
        }
    }
}
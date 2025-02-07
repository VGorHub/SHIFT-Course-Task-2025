package org.example.statistics;

import org.example.model.FilteredData;
import org.example.model.Params.StatsMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;

public class StatisticsCollector {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsCollector.class);

    public void printStatistics(FilteredData data, StatsMode mode) {
        logger.info("Вывод статистики в режиме {}...", mode);

        switch (mode) {
            case SHORT:
                printShortStats(data);
                break;
            case FULL:
                printFullStats(data);
                break;
        }
    }

    private void printShortStats(FilteredData data) {
        System.out.println("=== Краткая статистика ===");
        System.out.println("Целых чисел: " + data.getIntegers().size());
        System.out.println("Вещественных чисел: " + data.getFloats().size());
        System.out.println("Строк: " + data.getStrings().size());
    }

    private void printFullStats(FilteredData data) {
        System.out.println("=== Полная статистика ===");

        // Целые числа
        List<Integer> ints = data.getIntegers();
        System.out.println("Целых чисел: " + ints.size());
        if (!ints.isEmpty()) {
            int min = ints.stream().min(Integer::compareTo).orElse(0);
            int max = ints.stream().max(Integer::compareTo).orElse(0);
            long sum = ints.stream().mapToLong(Integer::longValue).sum();
            double avg = ints.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);

            System.out.println("  Минимум: " + min);
            System.out.println("  Максимум: " + max);
            System.out.println("  Сумма: " + sum);
            System.out.println("  Среднее: " + avg);
        }

        // Вещественные числа
        List<Double> floats = data.getFloats();
        System.out.println("Вещественных чисел: " + floats.size());
        if (!floats.isEmpty()) {
            double min = floats.stream().min(Double::compareTo).orElse(0.0);
            double max = floats.stream().max(Double::compareTo).orElse(0.0);
            double sum = floats.stream().mapToDouble(Double::doubleValue).sum();
            double avg = floats.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            System.out.println("  Минимум: " + min);
            System.out.println("  Максимум: " + max);
            System.out.println("  Сумма: " + sum);
            System.out.println("  Среднее: " + avg);
        }

        // Строки
        List<String> strings = data.getStrings();
        System.out.println("Строк: " + strings.size());
        if (!strings.isEmpty()) {
            int minLen = strings.stream()
                    .min(Comparator.comparingInt(String::length))
                    .map(String::length)
                    .orElse(0);
            int maxLen = strings.stream()
                    .max(Comparator.comparingInt(String::length))
                    .map(String::length)
                    .orElse(0);

            System.out.println("  Длина самой короткой строки: " + minLen);
            System.out.println("  Длина самой длинной строки: " + maxLen);
        }
    }
}
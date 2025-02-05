package org.example.processing;

import org.example.model.FilteredData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

public class FileProcessor {
    private static final Logger logger = LoggerFactory.getLogger(FileProcessor.class);

    public FilteredData processFiles(List<String> filePaths) {
        FilteredData data = new FilteredData();

        for (String filePath : filePaths) {
            logger.info("Обработка файла: {}", filePath);
            File file = new File(filePath);
            if (!file.exists()) {
                logger.error("Файл не найден: {}", filePath);
                continue;
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int lineNumber = 0;
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    // Пустые строки мы пропускаем
                    if (line.trim().isEmpty()) {
                        continue;
                    }
                    //Распределяем по типам
                    // Проверяем на ште
                    try {
                        int intValue = Integer.parseInt(line.trim());
                        data.addInteger(intValue);
                        continue;
                    } catch (NumberFormatException ignored) {
                    }
                    // Проверяем на float
                    try {
                        double doubleValue = Double.parseDouble(line.trim());
                        data.addFloat(doubleValue);
                        continue;
                    } catch (NumberFormatException ignored) {
                    }
                    //  Если не то и не то то строка
                    data.addString(line);
                }
            } catch (IOException e) {
                logger.error("Ошибка при чтении файла {}: {}", filePath, e.getMessage());
            }
        }
        return data;
    }
}
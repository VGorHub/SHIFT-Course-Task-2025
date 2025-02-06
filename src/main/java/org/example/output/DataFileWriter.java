package org.example.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class DataFileWriter<T> {
    private static final Logger logger = LoggerFactory.getLogger(DataFileWriter.class);

    private final String outputDir;
    private final String prefix;
    private final boolean appendMode;

    public DataFileWriter(String outputDir, String prefix, boolean appendMode) {
        this.outputDir = outputDir;
        this.prefix = prefix;
        this.appendMode = appendMode;
    }

    protected abstract String getBaseFileName();

    protected abstract String transformData(T item);

    public void writeData(List<T> data) {
        if (data == null || data.isEmpty()) {
            logger.info("Нет данных для записи в файл {}, файл не создан", getBaseFileName());
            return;
        }

        String fileName = getFileName();
        File file = new File(fileName);
        // Создание директории
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            boolean created = file.getParentFile().mkdirs();
            if (created) {
                logger.info("Создана директория файла {}", file.getParentFile().getAbsolutePath());
            }
        }

        // Запись данных
        try (FileWriter writer = new FileWriter(file, appendMode)) {
            for (T item : data) {
                writer.write(transformData(item));
                writer.write(System.lineSeparator());
            }
            logger.info("Запись в файл {} завершена ({} элементов)", fileName, data.size());
        } catch (IOException e) {
            logger.error("Ошибка записи в файл {}: {}", fileName, e.getMessage());
        }
    }

    //Для формирования имени файла
    private String getFileName() {
        String directory = (outputDir != null && !outputDir.isEmpty()) ? outputDir : ".";
        String pref = (prefix != null && !prefix.isEmpty()) ? prefix + "_" : "";
        return directory + File.separator + pref + getBaseFileName();
    }
}
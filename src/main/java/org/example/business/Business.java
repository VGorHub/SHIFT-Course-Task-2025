package org.example.business;

import org.example.model.FilteredData;
import org.example.model.Params;
import org.example.output.FloatFileWriter;
import org.example.output.IntegerFileWriter;
import org.example.output.StringFileWriter;
import org.example.processing.FileProcessor;
import org.example.statistics.StatisticsCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class Business {
    private static final Logger logger = LoggerFactory.getLogger(Business.class);

    private final FileProcessor fileProcessor;
    private final StatisticsCollector statisticsCollector;

    public Business() {
        this.fileProcessor = new FileProcessor();
        this.statisticsCollector = new StatisticsCollector();
    }


    public void doSomething(Params params) {
        logger.info("Логика с параметрами: {}", params);

        FilteredData filteredData = fileProcessor.processFiles(params.getInputFiles());


        String outputDir = Optional.ofNullable(params.getOutputDir()).orElse(".");
        String prefix = Optional.ofNullable(params.getPrefix()).orElse("");

        logger.info("outputDir='{}' и prefix='{}'", outputDir, prefix);

        IntegerFileWriter intWriter = new IntegerFileWriter(outputDir, prefix, params.isAppendMode());
        FloatFileWriter floatWriter = new FloatFileWriter(outputDir, prefix, params.isAppendMode());
        StringFileWriter strWriter = new StringFileWriter(outputDir, prefix, params.isAppendMode());

        intWriter.writeData(filteredData.getIntegers());
        floatWriter.writeData(filteredData.getFloats());
        strWriter.writeData(filteredData.getStrings());

        statisticsCollector.printStatistics(filteredData, params.getStatsMode());

        logger.info("Логика отработана");
    }
}
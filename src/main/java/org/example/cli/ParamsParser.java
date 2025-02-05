package org.example.cli;

import org.example.model.Params;
import org.apache.commons.cli.*;

import java.util.List;

public class ParamsParser {

    public static Params parse(String[] args) throws ParseException {
        Options options = new Options();

        // Опция -o
        Option outputDir = Option.builder("o")
                .longOpt("output")
                .hasArg()
                .argName("outputDir")
                .desc("Путь для результатов")
                .build();
        options.addOption(outputDir);

        // Опция -p
        Option prefix = Option.builder("p")
                .longOpt("prefix")
                .hasArg()
                .argName("prefix")
                .desc("Префикс для выходных файлов")
                .build();
        options.addOption(prefix);

        // Опция -a
        Option append = Option.builder("a")
                .longOpt("append")
                .desc("Режим добавления в существующие файлы")
                .build();
        options.addOption(append);

        //опция -s и -f
        Option shortStats = Option.builder("s")
                .longOpt("short")
                .desc("Краткая статистика (только количество элементов)")
                .build();
        Option fullStats = Option.builder("f")
                .longOpt("full")
                .desc("Полная статистика (минимальное, максимальное, сумма среднее для чисел, длина строк для строк)")
                .build();
        OptionGroup statsGroup = new OptionGroup();
        statsGroup.addOption(shortStats);
        statsGroup.addOption(fullStats);
        statsGroup.setRequired(true);
        options.addOptionGroup(statsGroup);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
            List<String> remainingArgs = cmd.getArgList();
            if (remainingArgs.isEmpty()) {
                throw new ParseException("Не указаны входные файлы.");
            }
        } catch (ParseException e) {
            if (args.length > 0) {
                System.out.println("Ошибка: " + e.getMessage());
                formatter.printHelp("java -jar util.jar [ОПЦИИ] file1 file2 ...", options);
            } else {
                formatter.printHelp("java -jar util.jar [ОПЦИИ] file1 file2 ...", options);
            }
            throw e;
        }

        Params params = new Params();
        params.setOutputDir(cmd.getOptionValue("o"));
        params.setPrefix(cmd.getOptionValue("p"));
        params.setAppendMode(cmd.hasOption("a"));
        if (cmd.hasOption("s")) {
            params.setStatsMode(Params.StatsMode.SHORT);
        } else if (cmd.hasOption("f")) {
            params.setStatsMode(Params.StatsMode.FULL);
        }
        params.setInputFiles(cmd.getArgList());

        return params;
    }
}

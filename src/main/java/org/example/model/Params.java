package org.example.model;

import java.util.List;

public class Params {
    private String outputDir;
    private String prefix;
    private boolean appendMode;
    private StatsMode statsMode;
    private List<String> inputFiles;

    public enum StatsMode {
        SHORT, FULL
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isAppendMode() {
        return appendMode;
    }

    public void setAppendMode(boolean appendMode) {
        this.appendMode = appendMode;
    }

    public StatsMode getStatsMode() {
        return statsMode;
    }

    public void setStatsMode(StatsMode statsMode) {
        this.statsMode = statsMode;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }

    public void setInputFiles(List<String> inputFiles) {
        this.inputFiles = inputFiles;
    }

    @Override
    public String toString() {
        return "Params{" +
                "outputDir='" + outputDir + '\'' +
                ", prefix='" + prefix + '\'' +
                ", appendMode=" + appendMode +
                ", statsMode=" + statsMode +
                ", inputFiles=" + inputFiles +
                '}';
    }
}
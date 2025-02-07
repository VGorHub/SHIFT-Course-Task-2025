package org.example.output;

public class StringFileWriter extends DataFileWriter<String> {

    public StringFileWriter(String outputDir, String prefix, boolean appendMode) {
        super(outputDir, prefix, appendMode);
    }

    @Override
    protected String getBaseFileName() {
        return "strings.txt";
    }

    @Override
    protected String transformData(String item) {
        return item;
    }
}
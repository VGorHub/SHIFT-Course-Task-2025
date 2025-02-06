package org.example.output;

public class IntegerFileWriter extends DataFileWriter<Integer> {

    public IntegerFileWriter(String outputDir, String prefix, boolean appendMode) {
        super(outputDir, prefix, appendMode);
    }

    @Override
    protected String getBaseFileName() {
        return "integers.txt";
    }

    @Override
    protected String transformData(Integer item) {
        return item.toString();
    }
}
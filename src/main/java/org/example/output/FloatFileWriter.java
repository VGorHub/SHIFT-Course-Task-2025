package org.example.output;

public class FloatFileWriter extends DataFileWriter<Double> {

    public FloatFileWriter(String outputDir, String prefix, boolean appendMode) {
        super(outputDir, prefix, appendMode);
    }

    @Override
    protected String getBaseFileName() {
        return "floats.txt";
    }

    @Override
    protected String transformData(Double item) {
        return item.toString();
    }
}
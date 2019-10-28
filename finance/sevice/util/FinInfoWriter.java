package by.epam.finance.sevice.util;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;

public class FinInfoWriter implements Closeable {
    private String path;
    private boolean appended;
    private FileWriter writer;

    public FinInfoWriter(String path) {
        this.path = path;
    }

    public void prepareWriter(boolean appended) {
        try {
            writer = new FileWriter(path, appended);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNote(int s) throws IOException {
        writer.write(s + "\n");
    }


    public void writeNote(String s) throws IOException {
        writer.write(s);
    }

    public void replaceAllFile(String fileContents) throws IOException {
        writer = new FileWriter(path, false);
        writer.write(fileContents);
        writer.flush();
        writer.close();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isAppended() {
        return appended;
    }

    public void setAppended(boolean appended) {
        this.appended = appended;
    }

    public void close() throws IOException {
        if (writer != null)
            writer.close();
    }

    public void writerFlush() throws IOException {
        if (writer != null)
            writer.flush();
    }
}

package by.epam.finance.sevice.util;

import java.io.*;

public class FinInfoReader implements Closeable {
    private String path;
    private BufferedReader reader;

    public FinInfoReader(String path) {
        this.path = path;
    }

    public void resetReader() {
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    public String readNote() throws IOException {
        if (reader != null)
            return reader.readLine();
        return "";
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void close() throws IOException {
        if (reader != null)
            reader.close();
    }
}

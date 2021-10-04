package com.techelevator.logger;

import java.io.*;

public class Logger implements Closeable {
    // attributes
    private File logFile;  // File logFile = new File(path);
    private PrintWriter writer;  // PrintWriter writer = new PrintWriter(logFile);

    public Logger(String path){
        this.logFile = new File(path);

        if (logFile.exists()){ // if the logfile already exists, we need to append
            try {
                                            // anonymous object of type FileWriter
                                            // FileWriter lets us pass in a boolean for appending
                this.writer = new PrintWriter(new FileWriter(this.logFile, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {  // if file doesn't already exist, we just need to finish setting up writer
            try {
                writer = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void write(String logMessage){
        writer.println(logMessage);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}

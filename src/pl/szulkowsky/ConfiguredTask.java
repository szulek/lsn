package pl.szulkowsky;

import java.io.*;

public abstract class ConfiguredTask {
    final private String absolutePath = new File("").getAbsolutePath();
    final protected BufferedReader reader;
    final protected BufferedWriter writer;

    protected Configuration configuration = null;
    protected boolean readFromFile = false;
    protected String readFilePath = null;
    protected boolean writeToFile = false;
    protected String writeFilePath = null;


    public ConfiguredTask(String configPath) throws IOException {
        readConfiguration(configPath);
        if(readFromFile){
            if(readFilePath != null){
                reader = new BufferedReader(new FileReader(readFilePath));
            }
            else {
                reader = null;
                System.exit(1);
            }
        }
        else
            reader = new BufferedReader(new InputStreamReader(System.in));

        if(writeToFile){
            if(writeFilePath != null) {
                File file = new File(writeFilePath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                writer = new BufferedWriter(fw);
            }
            else {
                writer = null;
                System.exit(1);
            }

        }
        else
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private void readConfiguration(String path){
        configuration = new Configuration(path);
        configuration.readConfiguration();

        String readFromFileString = configuration.getField("READ_FROM_FILE");
        if(readFromFileString != null){
            readFromFile = Boolean.parseBoolean(readFromFileString);
        }

        readFilePath = absolutePath + configuration.getField("READ_FILE_PATH");

        String writeToFileString = configuration.getField("WRITE_TO_FILE");
        if(writeToFileString != null){
            writeToFile = Boolean.parseBoolean(writeToFileString);
        }

        writeFilePath = absolutePath + configuration.getField("WRITE_FILE_PATH");
    }

    public void run() throws IOException {
    }

    public void finish() throws IOException {
        if(reader != null){
            reader.close();
        }
        if(writer != null){
            writer.close();
        }
    }

    protected void print(String string) throws IOException {
        writer.write(string);
    }
}

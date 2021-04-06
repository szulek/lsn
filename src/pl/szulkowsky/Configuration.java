package pl.szulkowsky;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private final String path;
    Map<String, String> config = new HashMap<>();

    public Configuration(String path) {
        String filePath = new File("").getAbsolutePath();
        this.path = filePath + path;
    }

    public void readConfiguration(){
        BufferedReader reader;
        if(new File(path).exists()) {
            try {
                reader = new BufferedReader(new FileReader(path));
                String line = reader.readLine();
                while (line != null) {
                    if(!line.startsWith("#")) {
                        String[] array = line.split("=");
                        if (array.length == 2) {
                            config.put(array[0], array[1]);
                        }
                    }
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getField(String key){
        if(!config.isEmpty()){
            return config.get(key);
        }
        return null;
    }
}

package pl.szulkowsky;

import pl.szulkowsky.task3.Task3;

import java.io.IOException;

public class LSN3 {
    public static void main(String[] args) {
        try {
            ConfiguredTask task = new Task3(args[0]);
            task.run();
            task.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

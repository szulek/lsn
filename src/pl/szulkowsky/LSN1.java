package pl.szulkowsky;

import pl.szulkowsky.task1.Task1;

import java.io.IOException;

public class LSN1 {

    public static void main(String[] args) {
        try {
            ConfiguredTask task = new Task1(args[0]);
            task.run();
            task.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

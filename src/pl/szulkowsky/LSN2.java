package pl.szulkowsky;

import pl.szulkowsky.task2.Task2;

import java.io.IOException;

public class LSN2 {

    public static void main(String[] args) {
        try {
            ConfiguredTask task = new Task2(args[0]);
            task.run();
            task.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

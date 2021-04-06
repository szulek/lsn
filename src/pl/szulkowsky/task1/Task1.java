package pl.szulkowsky.task1;

import pl.szulkowsky.ConfiguredTask;

import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

public class Task1 extends ConfiguredTask {

    public Task1(String configPath) throws IOException {
        super(configPath);
    }

    @Override
    public void run() throws IOException {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        String[] data = null;
        int counter = 0;

        if(reader != null) {
            data = reader.readLine().trim().split(" ");
        }
        if(data != null) {
            for (String s : data) {
                counter++;
                //Adding to a set because we need only distinct numbers
                sortedSet.add(Integer.parseInt(s));
            }

            //Printing the set
            sortedSet.forEach((n) -> {
                try {
                    print(n + " ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            if (sortedSet.size() > 0) {
                print("\ncount: " + counter);
                print("\ndistinct: " + sortedSet.size());
                print("\nmin: " + sortedSet.first());
                print("\nmax: " + sortedSet.last());
            }
        }
        else{
            System.err.print("No data found in input");
            System.exit(-1);
        }
    }
}

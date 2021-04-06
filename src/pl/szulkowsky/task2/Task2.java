package pl.szulkowsky.task2;

import pl.szulkowsky.ConfiguredTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 extends ConfiguredTask {

    public Task2(String configPath) throws IOException {
        super(configPath);
    }

    @Override
    public void run() throws IOException {
        String[] data = null;
        List<Integer> delimiterAndSmaller = new ArrayList<>();
        List<Integer> greaterThanDelimiter = new ArrayList<>();
        String sumString = configuration.getField("SUM");
        int sum = 13;
        if(sumString != null){
            sum = Integer.parseInt(sumString);
        }
        //Used to split numbers to two tables for optimization
        int delimiter = sum/2;

        //Used to determine if sum is even -> have to be done to split pairs of the same numbers which added create SUM
        // to two lists
        boolean isSumEven = sum%2 == 0;
        //Only used when sum is even
        boolean putIntoFirstTable = true;

        if(reader != null) {
            data = reader.readLine().trim().split(" ");
        }
        if(data != null) {
            for (String s : data) {
                int i = Integer.parseInt(s);
                if(isSumEven){
                    if(i == delimiter) {
                        if (putIntoFirstTable) {
                            delimiterAndSmaller.add(i);
                            putIntoFirstTable = false;
                        } else {
                            greaterThanDelimiter.add(i);
                            putIntoFirstTable = true;
                        }
                    }
                    else if (i < delimiter)
                        delimiterAndSmaller.add(i);
                    else
                        greaterThanDelimiter.add(i);
                }
                else {
                    //Splitting numbers to two lists -> sum only can be created of two numbers, one smaller than half of
                    // sum and other one - bigger
                    if (i <= delimiter)
                        delimiterAndSmaller.add(i);
                    else
                        greaterThanDelimiter.add(i);
                }
            }
        }
        else {
            System.out.print("No data found in input");
            System.exit(-1);
        }

        //When sorted we can save indexes where we are to optimize and don't start again from the beginning of list
        Collections.sort(delimiterAndSmaller);
        Collections.sort(greaterThanDelimiter);

        if(delimiterAndSmaller.size() > 0 && greaterThanDelimiter.size() > 0) {
            //we start with the smallest and the biggest to achieve ascending order
            int index1 = 0;
            int index2 = greaterThanDelimiter.size() - 1;

            while (index1 < delimiterAndSmaller.size()) {
                int indexToSave = -1;
                while (index2 >= 0) {
                    if (delimiterAndSmaller.get(index1) + greaterThanDelimiter.get(index2) < sum) {
                        indexToSave = index2;
                        break;
                    }
                    else if (delimiterAndSmaller.get(index1) + greaterThanDelimiter.get(index2) > sum)
                        index2--;
                    else {
                        print(delimiterAndSmaller.get(index1) + " " + greaterThanDelimiter.get(index2) + "\n");
                        if(indexToSave == -1 && index2 > 0 && greaterThanDelimiter.get(index2 - 1).equals(greaterThanDelimiter.get(index2))){
                            //saving index when the same number appears in the second table,
                            //because the same number can appear in the first table too
                            indexToSave = index2;
                        }
                        index2--;
                    }
                }
                ++index1;
                if(indexToSave != -1){
                    index2 = indexToSave;
                }
                else {
                    ++index2;
                }
            }
        }
    }
}

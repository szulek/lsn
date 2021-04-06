package pl.szulkowsky;

import java.util.*;

public class LSN1 {

    public static void main(String[] args) {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;

        while (scanner.hasNextInt()) {
            i++;
            sortedSet.add(scanner.nextInt());
        }
        sortedSet.forEach((n) -> {
            print(n + " ");
        });

        if(sortedSet.size() > 0) {
            print("\ncount: " + i);
            print("\ndistinct: " + sortedSet.size());
            print("\nmin: " + sortedSet.first());
            print("\nmax: " + sortedSet.last());
        }
    }


    private static void print(String string){
        System.out.print(string);
    }
}

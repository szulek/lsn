package pl.szulkowsky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LSN3 {
    public static void main(String[] args) {
        List<Set<Integer>> graphs = new ArrayList<>();
        int noOfLines = 0;
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            noOfLines = Integer.parseInt(line.trim());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < noOfLines; i++){
            try {
                String line = reader.readLine();
                String[] array = line.split(" ");
                if(array.length == 2){
                    int versicle1 = Integer.parseInt(array[0]);
                    int versicle2 = Integer.parseInt(array[1]);
                    boolean contains = false;
                    int indexOfGraphContaining = -1;
                    for(int j = 0; j < graphs.size(); j++){
                        Set<Integer> graph = graphs.get(j);
                        if(graph.contains(versicle1) || graph.contains(versicle2)){
                            if(indexOfGraphContaining != -1){
                                Set<Integer> graphContaining = graphs.get(indexOfGraphContaining);
                                graphContaining.addAll(graph);
                                graphs.remove(graph);
                                break;
                            }
                            graph.add(versicle1);
                            graph.add(versicle2);
                            contains = true;
                            indexOfGraphContaining = j;
                        }
                    }
                    if(!contains){
                        Set<Integer> graph = new HashSet<>();
                        graph.add(versicle1);
                        graph.add(versicle2);
                        graphs.add(graph);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.print(graphs.size());
    }
}

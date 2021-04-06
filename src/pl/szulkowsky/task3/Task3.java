package pl.szulkowsky.task3;

import pl.szulkowsky.ConfiguredTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task3 extends ConfiguredTask {

    public Task3(String configPath) throws IOException {
        super(configPath);
    }

    @Override
    public void run() throws IOException {
        List<Set<Integer>> graphs = new ArrayList<>();
        int noOfLines = 0;

        if(reader != null) {
            String line = reader.readLine();
            noOfLines = Integer.parseInt(line.trim());
        }
        else {
            System.err.print("Reader error!");
            System.exit(-1);
        }

        for(int i = 0; i < noOfLines; i++){
            try {
                String line = reader.readLine();
                String[] array = line.split(" ");
                if(array.length == 2){
                    int node1 = Integer.parseInt(array[0]);
                    int node2 = Integer.parseInt(array[1]);
                    boolean contains = false;
                    int indexOfGraphContaining = -1;
                    for(int j = 0; j < graphs.size(); j++){
                        Set<Integer> graph = graphs.get(j);
                        //if any of graphs contains any of nodes, add both of them to set (graph)
                        if(graph.contains(node1) || graph.contains(node2)){
                            if(indexOfGraphContaining != -1){
                                //If other graph contained one of nodes and other contains it too,
                                //merging have to occur
                                Set<Integer> graphContaining = graphs.get(indexOfGraphContaining);
                                graphContaining.addAll(graph);
                                graphs.remove(graph);
                                break;
                            }
                            graph.add(node1);
                            graph.add(node2);
                            contains = true;
                            indexOfGraphContaining = j;
                        }
                    }
                    if(!contains){
                        //If none of graphs contain nodes - create new graph
                        Set<Integer> graph = new HashSet<>();
                        graph.add(node1);
                        graph.add(node2);
                        graphs.add(graph);
                    }
                }
                else {
                    System.err.print("Input line error! Line is: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        print(String.valueOf(graphs.size()));
    }
}

package pl.szulkowsky;

import java.util.*;

public class LSN2 {

    public static void main(String[] args) {
        List<Integer> smallerThanSeven = new ArrayList<>();
        List<Integer> sevenAndGreater = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if(i < 7)
                smallerThanSeven.add(i);
            else
                sevenAndGreater.add(i);
        }

        Collections.sort(smallerThanSeven);
        Collections.sort(sevenAndGreater);

        if(smallerThanSeven.size() > 0 && sevenAndGreater.size() > 0) {
            int index1 = 0;
            int index2 = sevenAndGreater.size() - 1;

            while (index1 < smallerThanSeven.size()) {
                int indexToSave = -1;
                while (index2 >= 0) {
                    if (smallerThanSeven.get(index1) + sevenAndGreater.get(index2) < 13)
                        break;
                    else if (smallerThanSeven.get(index1) + sevenAndGreater.get(index2) > 13)
                        index2--;
                    else {
                        print(smallerThanSeven.get(index1) + " " + sevenAndGreater.get(index2) + "\n");
                        if(indexToSave == -1 && index2 > 0 && sevenAndGreater.get(index2 - 1).equals(sevenAndGreater.get(index2))){
                            indexToSave = index2;
                        }
                        index2--;
                    }
                }
                index1++;
                if(indexToSave != -1){
                    index2 = indexToSave;
                }
                else {
                    index2++;
                }
            }
        }
    }


    private static void print(String string){
        System.out.print(string);
    }
}

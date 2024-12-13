import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String FileName = "list.txt";
        ArrayList<String> columnOne = new ArrayList<>();
        ArrayList<String> columnTwo = new ArrayList<>();
        int partResult;
        int result = 0;

        try {
            BufferedReader inputFile = new BufferedReader(new FileReader(FileName));

            for(String textRead = inputFile.readLine(); textRead != null; textRead = inputFile.readLine()) {
                String[] splitText = textRead.split(" {3}");
                columnOne.add(splitText[0]);
                columnTwo.add(splitText[1]);
                Collections.sort(columnOne);
                Collections.sort(columnTwo);
            }

            for(int i = 0; i < columnOne.size(); ++i) {
                int firstElement = Integer.parseInt((String)columnOne.get(i));
                int secondElement = Integer.parseInt((String)columnTwo.get(i));
                if (firstElement < secondElement) {
                    partResult = secondElement - firstElement;
                } else {
                    partResult = firstElement - secondElement;
                }

                result += partResult;
            }

            System.out.println(columnOne);
            System.out.println(columnTwo);
            System.out.println("The resultOne is: " + result);
        } catch (FileNotFoundException var11) {
            System.out.println("File not found");
        } catch (Exception var12) {
            System.out.println("An error occurred");
        }

    }
}
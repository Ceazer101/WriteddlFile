package Package.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

    public String addFileToList() {
        File movieData = new File("data/imdb-data.csv");
        String result = "CREAT TABLE imdb-data(\n";
        try {
            Scanner scan = new Scanner(movieData);
            String line = scan.nextLine();
            String[] stringArray = line.split(";");
                for(int i=0; i<stringArray.length; i++){
                    if(i == stringArray.length-1)
                        result += stringArray[i] + " varChar(255)\n";
                    else
                        result += stringArray[i]+" varChar(255),\n";
                }
                result += ");";
            System.out.println(result);

        } catch (
                FileNotFoundException e) {
            System.out.println("Error: Could not find file.");
            e.printStackTrace();
        }
        return result;
    }

    public void writeFile(String csv){
        try {
            FileWriter myWriter = new FileWriter("data/ddl.sql");
            myWriter.write(csv);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileHandler fh = new FileHandler();
        fh.writeFile(fh.addFileToList());
    }
}

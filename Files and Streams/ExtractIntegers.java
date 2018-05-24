import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String inputPat="D:\\0 Java ADVANCED\\presentations\\9b  InputOutput, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output="D:\\0 Java ADVANCED\\presentations\\9b  InputOutput, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        try (Scanner scanner=new Scanner(new FileInputStream(inputPat));
             PrintWriter out=new PrintWriter(new FileOutputStream(output))){
            //

            out.println(scanner.next());
            scanner.nextLine();
            while (true) {
                out.println(scanner.nextInt());
                if(scanner.hasNext()==false){
                    break;
                }
                scanner.nextLine();
            }


        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}

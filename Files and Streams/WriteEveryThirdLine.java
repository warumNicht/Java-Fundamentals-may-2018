import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {

        String inputPat="D:\\0 Java ADVANCED\\presentations\\9b  InputOutput, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output="D:\\0 Java ADVANCED\\presentations\\9b  InputOutput, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        try(BufferedReader in= new BufferedReader(new FileReader(inputPat));
            PrintWriter out=new PrintWriter(new FileWriter(output))){

            int counter=1;
            String line=in.readLine();

            while (line!=null){

                    out.println(line);

                counter++;
                line=in.readLine();
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

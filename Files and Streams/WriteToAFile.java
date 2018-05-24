import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToAFile {
    public static void main(String[] args) {
        String inputPat="D:\\0 Java ADVANCED\\presentations\\9b  InputOutput, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output="D:\\0 Java ADVANCED\\presentations\\9b  InputOutput, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        List<Character> symbols=new ArrayList<>();
        Collections.addAll(symbols,'.',',','!','?');

        try (InputStream in=new FileInputStream(inputPat);
             OutputStream out=new FileOutputStream(output)){

            int oneByte=in.read();
            while (oneByte>=0){

                if(symbols.contains((char)oneByte)==false){
                    out.write(oneByte);
                }
                oneByte=in.read();
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) {
        String pat="D:\\0 Java ADVANCED\\presentations\\9b  InputOutput, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (InputStream in=new FileInputStream(pat)){

            int oneByte=in.read();
            while (oneByte>=0){
                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte=in.read();
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

import java.io.File;

public class FileList {
    public static void main(String[] args) {
        File file=new File("D:\\0 Java ADVANCED\\presentations\\9b  InputOutput, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if(file.exists()){
            if(file.isDirectory()){
                File[] files=file.listFiles();
                for (File f : files) {
                    if(f.isDirectory()==false){
                        System.out.printf("%s: %d%n",f.getName(), f.length());
                    }
                }
            }
        }
    }
}

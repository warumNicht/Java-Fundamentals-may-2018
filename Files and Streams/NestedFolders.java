import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {
        String pat="D:\\0 Java ADVANCED\\presentations\\9b  InputOutput, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root=new File(pat);

        ArrayDeque<File> dirs=new ArrayDeque<>();

        dirs.offer(root);
        int count=1;
        while (dirs.isEmpty()==false){
            File current=dirs.poll();
            File[] files=current.listFiles();
            for (File file : files) {
                if(file.isDirectory()){
                    dirs.offer(file);
                    count++;
                }
            }
            System.out.println(current.getName());
        }
        System.out.println(count+" folders");

    }
}

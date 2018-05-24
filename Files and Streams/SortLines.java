import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        Path inPat=Paths.get("D:\\input.txt");
        Path outPat=Paths.get("D:\\output.txt");

        try {
            List<String> lines=Files.readAllLines(inPat);
            Collections.sort(lines);

            Files.write(outPat,lines);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

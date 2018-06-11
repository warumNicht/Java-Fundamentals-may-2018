import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class _1_Internships {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex="^[A-Z][a-z]+\\s[A-Z][a-z]+$";
        Pattern pat=Pattern.compile(regex);

        int n=Integer.parseInt(reader.readLine());
        int m=Integer.parseInt(reader.readLine());

        ArrayDeque<String> problems=new ArrayDeque<>();
        ArrayDeque<String> candidates=new ArrayDeque<>();

        for(int i=0; i<n; i++){
            String curProblem=reader.readLine();
            problems.push(curProblem);
        }

        for (int j = 0; j <m ; j++) {
            String curCandidat=reader.readLine();

            Matcher mat=pat.matcher(curCandidat);

            if(mat.find()){
                candidates.offer(curCandidat);
            }
        }

        while (problems.isEmpty()==false&&candidates.size()>1){

            String curPb=problems.pop();
            String curCand=candidates.poll();

            if(isSovled(curPb, curCand)){
                System.out.println(curCand+" solved "+curPb+".");
                candidates.offer(curCand);
            }else{
                System.out.println(curCand+" failed "+ curPb+".");
                problems.addLast(curPb);
            }
        }

        if(candidates.size()==1){
            System.out.println(candidates.poll()+" gets the job!");
        }else{
            System.out.println(String.join(", ",candidates));
        }
    }

    private static boolean isSovled(String curPb, String curCand) {

        int sumProblem=0;
        for(int i=0; i<curPb.length(); i++){
            sumProblem+=curPb.charAt(i);
        }
        int sumCan=0;
        for(int i=0; i<curCand.length(); i++){
            sumCan+=curCand.charAt(i);
        }
        if(sumCan>sumProblem){
            return true;
        }else {
            return false;
        }
    }
}

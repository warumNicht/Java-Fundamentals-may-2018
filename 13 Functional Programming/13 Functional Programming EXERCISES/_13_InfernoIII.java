import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class _13_InfernoIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] gems=Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean[] toRemove=new boolean[gems.length];

        List<String[]> actions=new ArrayList<>();
        String input=scanner.nextLine();

        while ("Forge".equals(input)==false){
            String[] tockens=input.split(";");
            String[] curFilter={tockens[1],tockens[2]};
            if(input.startsWith("Exclude")){
                actions.add(curFilter);
            }else {
                actions.removeIf(x->x[0].equals(tockens[1])&&x[1].equals(tockens[2]));
            }
            input=scanner.nextLine();
        }
        for (String[] action : actions) {
            Consumer<int[]> filtering=excluding(action, toRemove);
            filtering.accept(gems);
        }

        for(int i=0; i<gems.length; i++){
            if(toRemove[i]==false){
                System.out.print(gems[i]+" ");
            }
        }
    }

    private static Consumer<int[]> excluding(String[] action, boolean[] toRem) {
        switch (action[0]){
            case"Sum Left":
                return list->{
                    removeLeftSum(list,Integer.parseInt(action[1]),toRem);
                };
            case"Sum Right":
                return list->{
                    removeRightSum(list,Integer.parseInt(action[1]),toRem);
                };
            case"Sum Left Right":
                return list->{
                    removeLeftRightSum(list,Integer.parseInt(action[1]),toRem);
                };
                default:
                     return list->{
                };
        }
    }

    private static void removeLeftRightSum(int[] list, int n, boolean[] toRemove) {

        if(list.length==1){
            if(list[0]==n){
                toRemove[0]=true;
            }
        }else if(list.length==2){
            if(list[0]+list[1]==n){
                toRemove[0]=true;
                toRemove[1]=true;
            }
        }else if(list.length>2){
            if(list[0]+list[1]==n){
                toRemove[0]=true;
            }
            if(list[list.length-1]+list[list.length-2]==n){
                toRemove[list.length-1]=true;
            }
            for(int i=1; i<list.length-1; i++){
                if(list[i]+list[i-1]+list[i+1]==n){
                    toRemove[i]=true;
                }
            }
        }
    }

    private static void removeRightSum(int[]  list, int n, boolean[] toRemove) {
        if(list[list.length-1]==n){
            toRemove[list.length-1]=true;
        }
        for(int i=0; i<list.length-1; i++){
            if(list[i]+list[i+1]==n){
                toRemove[i]=true;
            }
        }
    }

    private static void removeLeftSum(int[] list, int n, boolean[] toRemove) {
        if(list[0]==n){
            toRemove[0]=true;
        }
        for(int i=1; i<list.length; i++){
            if(list[i]+list[i-1]==n){
                toRemove[i]=true;
            }
        }
    }
}

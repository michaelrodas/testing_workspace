package exercises.oca;

import java.util.*;

public class Game {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int n = game.length;
        List list = Arrays.asList(game);
        if(list.stream().allMatch(list.get(0)::equals))
            return true;
        for(int i=0;i<n;i++){
            if(i==(n-1) || i+leap >=n)
                return true;
            if(game[i+1] ==0){
                i++;continue;
            }
            if(game[i+leap] ==0){
                i+=leap;continue;
            }
            if(game[i]==1 || game[i+1]==1)
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}


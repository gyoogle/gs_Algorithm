import java.util.HashSet;
import java.util.Scanner;
 
public class Solution_2819_Hyunah {
    public static HashSet<String> hs = new HashSet<>();
     
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
     
    public static void dfs(int[][] arr, int i, int j, int cnt, String str) {
        if(cnt==7) hs.add(str);
        else {
            for(int loc=0; loc<4; loc++) {
                int rx=i+dx[loc]; int ry=j+dy[loc];
                if(rx >= 0 && rx < arr.length && ry >= 0 && ry < arr[0].length) {
                    dfs(arr, rx, ry, cnt+1, str+arr[rx][ry]+"");
                }
            }
        }
        return;
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++) {
            int[][] arr = new int[4][4];
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            hs.clear();
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    dfs(arr, i, j, 1, arr[i][j]+"");
                }
            }
            System.out.println("#" + t + " " + hs.size());
        }
    }
}
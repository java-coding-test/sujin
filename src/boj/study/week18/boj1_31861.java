package boj.study.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1_31861 {
    static final int MOD=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        long[][] dp=new long[M+1][27];
        for(int i=1;i<=26;i++){
            dp[1][i]=1;
        }

        for(int i=2;i<=M;i++){
            for(int j=1;j<=26;j++){
                for(int k=1;k<=26;k++){
                    if(Math.abs(j-k)>=N){
                        dp[i][j]=(dp[i][j]+dp[i-1][k]);
                    }
                }
                dp[i][j] %= MOD;
            }
        }

        long result=0;
        for(int i=1;i<=26;i++){
            result+=dp[M][i]%MOD;
        }
        System.out.println(result);
    }
}

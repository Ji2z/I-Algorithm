/**
* @since 2021. 3. 19.
* @author Jin
* @see https://programmers.co.kr/learn/courses/30/lessons/72413?language=java
* @acc 50/50
* @eff 50/50
* @caution 2021 KAKAO BLIND RECRUITMENT : 합승 택시 요금
*/
public class Solution {
	public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] map = new int[n+1][n+1];
        for(int i = 0 ; i<fares.length; i++){
            map[fares[i][0]][fares[i][1]] = fares[i][2];
            map[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j<= n; j++){
                    if(i==j || map[i][k]==0 || map[k][j]==0)
                        continue;
                    if(map[i][j]==0){
                        map[i][j] = map[i][k]+map[k][j];
                        map[j][i] = map[i][j]; 
                    }else{
                        map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
                        map[j][i] = map[i][j];  
                    }
                }
            }
        }
        
        answer = Math.min(map[s][a]+map[s][b],map[s][a]+map[a][b]);
        answer = Math.min(answer, map[s][b]+map[b][a]);
        
        for(int k=1; k<=n; k++){
            if(k!=s&&k!=a&&k!=b&&map[k][a]!=0&&map[k][b]!=0&&map[s][k]!=0)
                answer = Math.min(answer,map[s][k]+map[k][a]+map[k][b]);
        }
        
        return answer;
    }
}

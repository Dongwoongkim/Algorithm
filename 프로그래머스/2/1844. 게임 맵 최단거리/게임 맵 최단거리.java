import java.util.*;

class Solution {
    
    static boolean[][] check; 
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n;
    static int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        check = new boolean[n + 1][m + 1];
        
        return bfs(0, 0, maps);
    }
    
    public int bfs(int x, int y, int[][] maps) {
        check[x][y] = true;
        
        Queue<Position> queue = new LinkedList<>();
        
        queue.add(new Position(x, y, 1));
        
        while(!queue.isEmpty()) {
            Position pos = queue.poll();
            
            int curX = pos.x;
            int curY = pos.y;
            int curStep = pos.step;
            
            if(curX == n - 1 && curY == m - 1) {
                return curStep;
            }
            
            for(int i=0;i<4;i++) {
                int nx = curX+dx[i];
                int ny = curY+dy[i];

                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                if(check[nx][ny] == false && maps[nx][ny] == 1) {
                    check[nx][ny] = true;
                    queue.add(new Position(nx, ny, curStep + 1));
                }
            }
        }
        
        return -1;
    }
    
    static class Position {
        
        int x; 
        int y;
        int step;
        
        public Position(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}
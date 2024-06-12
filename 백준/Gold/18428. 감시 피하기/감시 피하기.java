import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n + 1][n + 1];
        List<Position> xPos = new ArrayList<>();
        List<Position> teachers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);

                if (map[i][j] == 'X') {
                    xPos.add(new Position(i, j));
                }

                if (map[i][j] == 'T') {
                    teachers.add(new Position(i, j));
                }
            }
        }

        for (int i = 0; i < xPos.size(); i++) {
            for (int j = i + 1; j < xPos.size(); j++) {
                for (int k = j + 1; k < xPos.size(); k++) {
                    Position pos1 = xPos.get(i);
                    Position pos2 = xPos.get(j);
                    Position pos3 = xPos.get(k);

                    map[pos1.x][pos1.y] = 'O';
                    map[pos2.x][pos2.y] = 'O';
                    map[pos3.x][pos3.y] = 'O';

                    boolean flag = true;

                    for (int l = 0; l < teachers.size(); l++) {
                        if (!check(teachers.get(l))) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        System.out.println("YES");
                        return;
                    }

                    map[pos1.x][pos1.y] = 'X';
                    map[pos2.x][pos2.y] = 'X';
                    map[pos3.x][pos3.y] = 'X';
                }
            }
        }

        System.out.println("NO");
    }

    private static boolean check(Position position) {
        int posX = position.x;
        int posY = position.y;

        for (int i = 0; i < 4; i++) {
            int s = 1;

            while (true) {
                int nx = posX + dx[i] * s;
                int ny = posY + dy[i] * s;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    break;
                }

                if (map[nx][ny] == 'O') {
                    break;
                }

                if (map[nx][ny] == 'S') {
                    return false;
                }

                s++;
            }
        }

        return true;
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

package main.java.solutions.array;

import java.util.*;

public class TheMaze490 {
    public static  final  int[][] OFFSETS  = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};//down up left right
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int N = maze.length, M = maze[0].length;
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] nextPos : getNext(pos, maze, N, M)) {
                int nr = nextPos[0], nc = nextPos[1];
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.offer(nextPos);
                if (Arrays.equals(nextPos, destination)) return true;
            }
        }
        return false;
    }
    private static List<int[]> getNext(int[] pos, int[][] maze, int N, int M) {
        int r = pos[0], c = pos[1];
        List<int[]> ans = new ArrayList<>();
        for (int[] os : OFFSETS) {
            int nr = r, nc = c;
            while (nr + os[0] >= 0 && nc + os[1] >= 0 &&
                    nr + os[0] < N && nc + os[1] < M &&
                    maze[nr + os[0]][nc + os[1]] == 0) {
                nr += os[0];
                nc += os[1];
            }
            if (nr != r || nc != c) ans.add(new int[]{nr, nc});
        }
        return ans;
    }

    private static List<int[]> getNext(int[] pos, String[] maze) {
        int x = pos[0], y = pos[1];
        List<int[]> ans = new ArrayList<>();
        for (int[] dir : dirs) {
            int nx = x, ny = y;
            while (nx + dir[0] >= 0 &&
                    nx + dir[0] < m &&
                    ny + dir[1] >= 0 &&
                    ny + dir[1] < n &&
                    maze[nx + dir[0]].charAt(ny + dir[1]) == '.') {
                nx += dir[0];
                ny += dir[1];
            }
            if (nx != x || ny != y) ans.add(new int[]{nx, ny});
        }
        return ans;
    }
    private static int m = 0;
    private static int n = 0;
    private static int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
    public static boolean findHer(String[] maze){
        m = maze.length;
        n = maze[0].length();
        int[] s = new int[2], t = new int[2];
        getPosNow(maze,s,t);
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(s);
        visited[s[0]][s[1]] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] nextPos : getNext(pos, maze)) {
                int nx = nextPos[0], ny = nextPos[1];
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.offer(nextPos);
                if(Arrays.equals(nextPos, t)) return true;
            }
        }
        return false;
    }

    public static void getPosNow(String[] maze, int[] s, int[] t){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(maze[i].charAt(j)=='S') {
                    s[0]=i;s[1]=j;
                }
                if(maze[i].charAt(j)=='T') {
                    t[0]=i;t[1]=j;
                    maze[i] = maze[i].replace('S','.');
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] maze = {{1,0,0,1},{1,1,1,0},{0,0,0,1}};
        System.out.println(hasPath(maze,new int[]{0,0},new int[]{2,3}));
    }
}

import java.util.HashMap;

public class lc547 {
    HashMap<Integer, Boolean> map = new HashMap<>();
    int[] father;
    public int findCircleNum(int[][] M) {
        // int res = 0;
        // for (int i = 0; i < M.length; i++)
        //     if(map.getOrDefault(i, false) == false) {
        //         res++;
        //         map.put(i, true);
        //         dfs(i, M);
        //     }  
        // return res;
        return findCircleNumUnion(M);
    }

    public void dfs(int row, int[][] M) {
        for (int i = 0; i < M.length; i++)
            if (M[row][i] != 0 && map.getOrDefault(i, false) == false) {
                map.put(i, true);
                dfs(i, M);
            }
        return;
    }

    public int findCircleNumUnion(int[][] M) {
        father = new int[M.length];
        for (int i = 0; i < M.length; i++)
            father[i] = i;
        for (int i = 0; i < M.length; i++)
            for (int j = i + 1; j < M.length; j++) 
                if (M[i][j] == 1)
                    union(i, j);
        int res = 0;
        for (int i = 0; i < M.length; i++) 
            if (father[i] == i)
                res++;
        return res;    
    }
    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy)
            father[fx] = fy;
    }
    public int find(int x) {
        if (father[x] == x)
            return x;
        return father[x] = find(father[x]);
    }
}

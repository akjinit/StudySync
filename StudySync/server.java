import java.util.*;
class Solution {

    static int mod = (int)1e9 + 7;
    public int countTrapezoids(int[][] points) {
        TreeMap<Integer,Integer> y_coor = new TreeMap<>();
        int n = points.length;
        for(int i=0;i<n;i++)
            {
                int y = points[i][1];
                y_coor.put(y,y_coor.getOrDefault(y,0) + 1);
            }

        int y_arr[] = new int[y_coor.size()];
        int i = 0;
        for(int e : y_coor.keySet())
            {
                y_arr[i++] = e;
            }

        long count_trap = 0;
        int pWays = 0;
        for(i=0;i<y_arr.length;i++)
            {
                int y = y_arr[i];
                if(y_coor.get(y) <= 1) continue;
                else{
                    long cWays = combinations(y_coor.get(y));
                    count_trap = (count_trap + (pWays * cWays ) % mod) % mod;
                    pWays += cWays;
                }
            }


        return (int)count_trap % mod;
    }



    static long combinations(int n)
    {
        return 1L * n * (n-1)/2;
    }
}
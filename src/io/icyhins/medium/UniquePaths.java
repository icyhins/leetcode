package io.icyhins.medium;

import java.util.Date;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 * <img src="https://leetcode.com/static/images/problemset/robot_maze.png"/>
 * from(0,0) to (m-1,n-1)
 *
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 *
 *
 Note: m and n will be at most 100.
 */
public class UniquePaths {

    public static void main(String[] args){
        UniquePaths up = new UniquePaths();
        long start = new Date().getTime();
        System.out.println(up.uniquePaths2(100,100));
        long end = new Date().getTime();
        System.out.println(end-start);
    }



    /**
     * Solution main idea:
     *  give a simple test case m=2, n=2
     *  |start ,  0 |
     *  |   0  , end|
     *  from [0,0] to [1,1] , result is 2 ,
     *  [0,0] -> [0,1] -> [1,1]
     *  [0,0] -> [1,0] -> [1,1]
     *
     *  test case m=2, n=3,result is 3 ,
     *  |start , 0 , 0 |
     *  |   0  , 0 ,end|
     *
     *  [0,0]->[0,1]->[0,2]->[1,2]
     *  [0,0]->[0,1]->[1,1]->[1,2]
     *  [0,0]->[1,0]->[1,1]->[1,2]
     *
     *  so we can see there are 2 paths to [1,1], 1 path to [0,2],
     *  and total (2+1)=3 paths to [1,2]
     *
     * This solution use a array to store the total result
     * so Space is O(n*m), Time is  O(n*m)
     * */
    public int uniquePaths2(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }

}

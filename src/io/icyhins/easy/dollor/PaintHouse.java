package io.icyhins.easy.dollor;

/** 256
 * There are a row of n houses,
 * each house can be painted with one of the three colors:
 *
 * red, blue or green.
 *
 * The cost of painting each house with a certain color is different.
 *
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 *
 * For example,
 * costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green,
 * and so on...
 *
 * Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 */
public class PaintHouse {


    public static void main(String[] args){
        PaintHouse  ph = new PaintHouse();

        int n = 5;
        int[][] costs = new int[n][3];
        costs[0][0] = 1;
        costs[1][1] = 1;
        costs[2][1] = 1;


    }

    /**
     * Solution main Idea:
     *
     * It's a DP(dynamic programming) problem, get min ,get min and get min.
     * mulity discision
     *
     * Current cost is costs[i][0],costs[i][1],costs[i][2]
     * pre cost is the min of (r,b,g)
     *
     * */
    public int minCost(int[][] costs){

        if(costs==null||costs.length==0){
            return 0;
        }

        int size = costs.length;
        int r = 0; //Red cost
        int b = 0; //Blue cost
        int g = 0; //Green cost
        for(int i = 0; i < size; i++){
            int rr = r, bb = b, gg = g;
            r = costs[i][0] + Math.min(bb,gg);
            b = costs[i][1] + Math.min(rr,gg);
            g = costs[i][2] + Math.min(rr,bb);
        }

        return Math.min(r,Math.min(b,g));
    }


    public int minCost2(int[][] costs){

        if(costs == null || costs.length == 0){
            return 0;
        }
        int size = costs.length;

        //Loop house
        for(int house=1;house<size;house++){
            //Loop Color
            for(int color = 0; color <3; color++ ){
                costs[house][color] += Math.min(costs[house-1][(color+1)%3], costs[house-1][(color+2)%3]);
            }
        }

        return Math.min(costs[size-1][0],Math.min(costs[size-1][1],costs[size-1][2]));
    }
}

package com.github;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/14 上午11:03
 */
public class Test {

    public static void main(String[] args) {

        //try {
        //    System.out.println(0);
        //    int i = 10 / 0;
        //    System.out.println(1);
        //}catch (Exception e){
        //    System.out.println(2);
        //}finally {
        //    System.out.println(3);
        //}
        //System.out.println(4);

        int[] arr = new int[]{1,-1,0,9,5,2,9};
        System.out.println(new Test().getMaxWithList(arr));
    }

    public int getMaxWithList(int[] arr){
        int curMax = 0, resMax = 0;
        for (int j : arr) {
            curMax = curMax + j;
            if (curMax > resMax) {
                resMax = curMax;
            } else if (curMax < 0) {
                curMax = 0;
            }
        }
        return resMax;
    }
}

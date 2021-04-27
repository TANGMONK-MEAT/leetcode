package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/16 上午10:06
 */
public class 可获得最大的点数 {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,1};
        System.out.println(getMacPoint(arr,3));
    }

    public static int getMacPoint(int[] arr,int k){
        int res = 0;
        int cur = 0;
        int n = arr.length - k;
        int i = 0;
        int next = i + n;
        int preS = 0;
        int nextS = 0;
        for (int t = next; t < arr.length; t++) {
            nextS += arr[t];
        }
        res = nextS;
        while (i < k){
            cur = preS + arr[i];
            preS = cur;

            nextS = nextS - arr[next];
            cur = cur + nextS;
            if (cur > res){
                res = cur;
            }
            cur = 0;
            i++;
            next = i + n;
        }
        //for (int j = n; j < arr.length; j++) {
        //    cur += arr[j];
        //    if (cur > res){
        //        res = cur;
        //    }
        //}


        //for (int j = 0; j < k; j++) {
        //    System.out.println(j);
        //    res+=arr[j];
        //}
        //int l=k-1;
        //int r= arr.length-1;
        //int resT=res;
        //for (int j=0;j<k;j++){
        //    System.out.println(l);
        //    System.out.println(r);
        //    resT=resT-arr[l]+arr[r];
        //    l--;
        //    r--;
        //    res=res>resT?res:resT;
        //}

        return res;
    }
}

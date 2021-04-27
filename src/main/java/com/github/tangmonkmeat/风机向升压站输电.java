package com.github.tangmonkmeat;

import java.util.Arrays;

/**
 * Description:
 * 某风电场每台风机的发电量和距离升压站的距离各不相同，
 * 如：
 * 风机1：发电量30，距离20；
 * 风机2：发电量35，距离25；
 * 风机3：发电量25，距离18……，
 * <p>
 * 要求在输电总距离限定（如小于100）的前提下，选择风机向升压站输电，使得输送的电量最大。
 *
 * @author zwl
 * @version 1.0
 * @date 2021/3/12 下午2:57
 */
public class 风机向升压站输电 {

    public static void main(String[] args) {
        // 发电量
        int[] ele = new int[]{1, 2};
        int[] len = new int[]{2, 1};
        System.out.println(new 风机向升压站输电().getMaxEle(ele, len, 3));
    }

    //public int getMaxEle(int[] ele, int[] len, int maxLen) {
    //    return def(ele, len, maxLen, 0, 0, 0);
    //}
    //
    //public int def(int[] ele, int[] len, int maxLen, int curLen, int curEle, int maxEle) {
    //    for (int i = 0; i < ele.length; i++) {
    //        if (curLen + len[i] > maxLen) {
    //            maxEle = Math.max(maxEle, curEle);
    //        } else {
    //            int t = def(ele, len, maxLen, curLen + len[i], curEle + ele[i], maxEle);
    //            if (t > maxEle) {
    //                maxEle = t;
    //            }
    //        }
    //    }
    //    return maxEle;
    //}

    public int getMaxEle(int[] ele, int[] len, int maxLen) {
        int maxEle = 0;
        if (maxLen > 0) {
            for (int i = 0; i < ele.length; i++) {
                int curEle;
                int l = len[i];
                int e = ele[i];
                if (l <= maxLen) {
                    curEle = getMaxEle(ele, len, maxLen - l) + e;
                    if (curEle > maxEle) {
                        maxEle = curEle;
                    }
                }
            }
        }
        return maxEle;
    }

    public int getMaxEle2(int[] ele, int[] len, int maxLen) {
        int[][] ps = new int[maxLen][maxLen + 1];
        for (int i = 1; i < ele.length; i++) {
            int ln = len[i];
            int el = ele[i];
            for (int v = 1; v < maxLen; v++) {
                // 存的下
                int with = (v - len[i] >= 0) ? (ele[i - 1] + ele[v - len[i - 1]]) : 0;
                // 存不下
                int without = ele[i - 1];
                // 存最大值
                ps[i][v] = Math.max(with,without);
            }
        }
        return ps[maxLen - 1][maxLen];
    }
}

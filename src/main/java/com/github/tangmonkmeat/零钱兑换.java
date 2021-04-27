package com.github.tangmonkmeat;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/7 11:49
 */
public class 零钱兑换 {

    public static void main(String[] args) {

        // int num = coinChange(new int[]{83,186,408,419}, 6249);
        // System.out.println(num);

        int num = new 零钱兑换().coinChange(new int[]{1, 7, 10}, 14);
        System.out.println(num);

    }

    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        def(coins.length - 1, coins, 0, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void def(int index, int[] coins, int count, int has) {
        if (has == 0) {
            ans = Math.min(count, ans);
            return;
        }
        if (index < 0) {
            return;
        }

        for (int i = has / coins[index]; i >= 0 && count + i < ans; i--) {
            def(index - 1, coins, count + i, has - i * coins[index]);
        }
    }

}

package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/6 14:15
 */
public class 交换字符使得字符串相同 {

    public static void main(String[] args) {

        System.out.println((2 >> 1) + (0 >> 1));
        System.out.println(2 >> 1 + 0 >> 1);

        String s1 = "xxyxxyxyxyxyy";
        String s2 = "yyxxyxxxxxxxy";

        // for (int i = 0;i < s1.length();i++){
        //     if (s1.charAt(i) != s2.charAt(i)){
        //         if (s1.charAt(i) == 'x'){
        //             System.out.print("x");
        //         }else{
        //             System.out.print("y");
        //         }
        //     }
        // }

        // c1 = xxyxyyyy
        // c2 = yyxyxxxx


        System.out.println(minimumSwap(s1,s2));
        // c1 = yyyx
        // c2 = xxxy

        // c1 = xxxxyy
        // c2 = yyyyxx

        // c1 = xyxyyx
        // c2 = yxyxxy
    }


    public static int minimumSwap(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len = c1.length;
        // 记录 c1 中 x 和 y 的个数
        int xn = 0,yn = 0;
        // 长度默认是相同的
        // 遍历 s1 和 s2
        for (int i = 0; i < len; i++) {
            // 找 c1 和 c2 相同位置，value 不同
            // x - y 或者 y - x
            // 所以最后得到的:
            // c1x + c2x = c1y + c2y; c1x == c2y; c1y == c2x;
            // xn 记录 c1 中 x 的个数
            // yn 记录 c1 中 y 的个数
            if(c1[i] != c2[i]){
                if (c1[i] == 'x') {
                    xn++;
                }else{
                    yn++;
                }
            }
        }
        // 两边的 xn 或者 yn 的总个数不可以是奇数，因为无法平分
        // 如果 c1 有 xn 个 x，yn 个y，那么，c2 就一定有 xn 个y，yn个x
        if((xn + yn) % 2 != 0){
            return -1;
        }
        // c1 和 c2 的长度必定是 偶数了
        // 所以，xn 是偶数，yn就一定是偶数
        // 相反，xn 是奇数，yn 也一定是奇数
        // 最后， c1 和 c2 类似于：
        // xxyy    xxxyyy    yy
        // yyxx    yyyxxx    xx
        if(xn % 2 == 0){
            return (xn >> 1) + (yn >> 1);
        }
        // 如果是奇数，就必定会留下 x - y 和 y - x, 故在加上两次交换
        return (xn >> 1) + (yn >> 1) + 2;
    }

}

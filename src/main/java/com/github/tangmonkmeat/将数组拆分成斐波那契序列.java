package com.github.tangmonkmeat;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/2 13:26
 */
public class 将数组拆分成斐波那契序列 {

    public static void main(String[] args) {
        System.out.println(new 将数组拆分成斐波那契序列().splitIntoFibonacci("1101111"));
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        char[] cs = S.toCharArray();
        def(res,cs, cs.length, 0);
        return res;
    }

    public boolean def(List<Integer> res, char[] cs, int n, int i){
        if (i == n && res.size() >= 3){
            return true;
        }

        for (int j = i;j < n;j++){
            // 不能 0 开头
            if (cs[i] == '0' && j > i){
                break;
            }
            // 截取字符串转化为数字
            long currentValue = subString(cs, i, j);
            if (currentValue > Integer.MAX_VALUE){
                break;
            }

            int size = res.size();
            // 如果 res size >= 2 且 currentValue < res[size - 1] + res[size - 2],则继续遍历拼接下一个字符
            // 否则直接返回
            if (size >= 2 && currentValue > res.get(size - 1) + res.get(size - 2)){
                break;
            }
            // 如果 res size <= 1 或者 currentValue == res[size - 1] + res[size - 2]
            if (size <= 1 || currentValue == res.get(size - 1) + res.get(size - 2)){
                res.add((int) currentValue);

                // 如果找到了完整的结果，一层层退出
                if (def(res,cs,n,j + 1)){
                    return true;
                }
                // 回溯，移除上一次添加的
                // 此时，必须重新获取 size，应为进行了递归
                res.remove(res.size() - 1);
            }

        }
        return false;
    }

    public long subString(char[] cs, int start, int end){
        long res = 0;
        for (int i = start;i <= end;i++){
            res = res * 10 + cs[i] - '0';
        }
        return res;
    }
}

package com.github.tangmonkmeat;

import java.util.*;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/1/30 19:47
 */
public class N皇后 {

    public static void main(String[] args) {
        System.out.println(new N皇后().solveNQueens(4));
    }

    int m;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>(n);
        m = n;
        // 记录 N 皇后的位置
        // key=x, value=y
        Map<Integer, Integer> has = new HashMap<>(n);
        def(res, has, 0, 0, n);
        return res;
    }

    public void def(List<List<String>> res, Map<Integer, Integer> has, int x, int y, int n) {
        if (n <= 0) {
            if (!has.isEmpty()) {
                res.add(create(has));
                has.clear();
            }
            return;
        }

        if (x < 0 || x >= m || y >= m || y < 0) {
            return;
        }

        for (int i = x; i < m; i++) {
            for (int j = y; j < m; j++) {
                if (enablePut(i, j, has)) {
                    has.put(x, y);
                    def(res, has, i + 1, j - 2, n - 1);
                    def(res, has, i + 2, j - 1, n - 1);
                    def(res, has, i + 2, j + 1, n - 1);
                    def(res, has, i + 1, j + 2, n - 1);
                    has.remove(x);
                }
            }
        }
    }

    public boolean enablePut(int i, int j, Map<Integer, Integer> has) {
        for (Map.Entry<Integer, Integer> entry : has.entrySet()) {
            if(i == 1 && j == 1){
                System.out.println();
            }
            Integer key = entry.getKey();
            if (key == i) {
                return false;
            }
            Integer value = entry.getValue();
            if (value == j) {
                return false;
            }
            if (Math.abs(key - i) == Math.abs(value - j)) {
                return false;
            }
        }
        return true;
    }

    public List<String> create(Map<Integer, Integer> map) {

        String[] ss = new String[m];
        List<String> l = new ArrayList<>(m);
        for (Integer i : map.keySet()) {
            System.out.println(i + ", " + map.get(i));
            char[] cs = new char[m];
            Arrays.fill(cs, '.');
            cs[map.get(i)] = 'Q';
            ss[i] = new String(cs);
        }
        System.out.println("gggg");
        Collections.addAll(l,ss);
        return l;
    }
}

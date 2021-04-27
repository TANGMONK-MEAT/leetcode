package com.github.tangmonkmeat;

import sun.plugin2.gluegen.runtime.CPU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/1/30 23:44
 */
public class N皇后1 {

    public static void main(String[] args) {
        System.out.println(new N皇后1().solveNQueens(1));
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] css = new char[n][n];
        // 填充 '.'
        fillChar(css, '.');
        List<List<String>> res = new ArrayList<>();
        def(res, css, 0);
        return res;
    }

    // 填充 '.'
    public void fillChar(char[][] css, char c) {
        for (char[] chars : css) {
            Arrays.fill(chars, c);
        }
    }

    // 递归遍历每一行的元素
    public void def(List<List<String>> res, char[][] css, int row) {
        if (row == css.length) {
            res.add(creatList(css));
            return;
        }

        // 遍历 一行的每个元素，如果遍历完一行，还不可以放皇后，则此行会没有皇后
        // 因为，N皇后问题是每行都必须有且仅有一个皇后
        // 因此 上一行放置的皇后有问题，需要找过
        for (int col = 0; col < css[row].length; col++) {
            if (isValid(css, row, col)) {
                css[row][col] = 'Q';
                // 递归
                def(res, css, row + 1);
                // 回溯
                css[row][col] = '.';
            }
        }
    }

    // 因为，我是一行一行从上往下依次遍历的，所以，只需要判断遍历过的位置
    public boolean isValid(char[][] css, int row, int col) {
        // 判断 列
        for (int i = 0; i < row; i++) {
            if (css[i][col] == 'Q') {
                return false;
            }
        }
        // 判断 横
        for (int i = 0; i < col; i++) {
            if (css[row][i] == 'Q') {
                return false;
            }
        }
        // 判断 右斜边
        for (int i = row - 1, j = col + 1; i >= 0 && j < css[i].length; --i, ++j) {
            if (css[i][j] == 'Q') {
                return false;
            }
        }
        // 判断 左斜边
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (css[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // 构造 棋子放置方案 集合
    private List<String> creatList(char[][] css) {
        List<String> l = new ArrayList<>();
        for (char[] chars : css) {
            l.add(new String(chars));
        }
        return l;
    }
}

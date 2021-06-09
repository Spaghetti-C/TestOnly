package com.yy.algorithm.daily;

import java.util.Arrays;

/**
 * Description: KMP算法
 *
 * @author chenyiqin02
 * @date 2021/05/12
 */
public class KMP {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String pat = "ababc";
        String pat = "gtgfgtgtt";
        String txt = "gtgggtgfgtgtt";
        System.out.println(solution.KMP(txt, pat));
        System.out.println(solution.KMP1(txt, pat));
    }

    static class Solution {
        // 一维数组记录最长相等的前后缀
        public int KMP(String txt, String pat) {
            int[] next = solution(pat);
            System.out.println(Arrays.toString(next));
            int i = 0;
            int j = 0;
            while (i < txt.length() && j < pat.length()) {
                if (j == -1 || txt.charAt(i) == pat.charAt(j)) {
                    i++;
                    j++;
                } else {
                    // 回溯
                    j = next[j];
                }
            }

            if (j >= pat.length()) {
                return i - pat.length();
            }
            return -1;
        }

        public int[] solution(String pat) {
            int[] next = new int[pat.length()];
            int nextIndex = -1;
            int patIndex = 0;
            next[0] = -1;

            while (patIndex < pat.length() - 1) {
                if (nextIndex == -1 || pat.charAt(patIndex) == pat.charAt(nextIndex)) {
                    patIndex++;
                    nextIndex++;
                    next[patIndex] = nextIndex;
                } else {
                    // 回溯
                    nextIndex = next[nextIndex];
                }
            }
            return next;
        }

        // 动态规划数组解出字符跳转位置
        public int KMP1(String txt, String pat) {
            int[][] next = solution1(pat);
            int txtIdx = 0;
            int patIdx = 0;
            while (txtIdx < txt.length() && patIdx < pat.length()) {
                patIdx = next[patIdx][txt.charAt(txtIdx)];
                txtIdx++;
            }

            if (patIdx >= pat.length()) {
                return txtIdx - pat.length();
            }
            return -1;
        }

        public int[][] solution1(String pat) {
            int ascii = 128;
            int[][] next = new int[pat.length()][ascii];
            next[0][pat.charAt(0)] = 1;
            int x = 0;
            for (int i = 1; i < pat.length(); i++) {
                for (int j = 0; j < ascii; j++) {
                    next[i][j] = next[x][j];
                }
                next[i][pat.charAt(i)] = i + 1;
                x = next[x][pat.charAt(i)];
            }

            return next;
        }
    }
}

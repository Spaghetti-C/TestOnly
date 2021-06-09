package com.yy.algorithm.daily;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Description: 图论
 * 邻接矩阵表示法
 *
 * @author chenyiqin02
 * @date 2021/05/09
 */
public class GraphInAdjacencyMatrix {
    public static void main(String[] args) {
//        int height = 5;
//        int width = 4;
//        Graph graph = new Graph(height, width);
//        graph.addEdgeDG(1, 1, 1, 2, 4);
//        graph.addEdgeDG(1, 1, 2, 2, 5);
//        graph.addEdgeDG(1, 2, 4, 4, 8);
//        graph.addEdgeDG(2, 2, 5, 4, 10);
//        graph.printMatrix();
//        graph.dfs((5 - 1) * width + 4);
//        graph.bfs((5 - 1) * width + 4);

        // 迪杰斯特拉算法
        int vertex = 7;
        Graph graph = new Graph(vertex);
        graph.addEdgeDG(1, 2, 6);
        graph.addEdgeDG(1, 4, 2);
        graph.addEdgeDG(2, 3, 5);
        graph.addEdgeDG(2, 6, 3);
        graph.addEdgeDG(4, 2, 7);
        graph.addEdgeDG(4, 5, 5);
        graph.addEdgeDG(5, 6, 5);
        graph.addEdgeDG(5, 7, 1);
        graph.addEdgeDG(6, 3, 2);

        graph.djikstra(2);
    }

    static class Graph {
        private int[][] matrix;
        private boolean[] visited;
        private int height;
        private int width;
        private int[] prev;
        private int[] dist;

        public void printMatrix() {
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        }

        public Graph(int height, int width) {
            this.height = height;
            this.width = width;
            // 大小加一，减少从零开始计数带来的复杂度
            matrix = new int[height * width + 1][height * width + 1];
            visited = new boolean[height * width + 1];
            prev = new int[height * width + 1];
            dist = new int[height * width + 1];
        }

        public Graph(int vertex) {
            // 大小加一，减少从零开始计数带来的复杂度
            matrix = new int[vertex + 1][vertex + 1];
            visited = new boolean[vertex + 1];
            prev = new int[vertex + 1];
            dist = new int[vertex + 1];
        }

        public void addEdgeUDG(int sourceVertex, int targetVertex, int weight) {
            matrix[sourceVertex][targetVertex] = weight;
            matrix[targetVertex][sourceVertex] = weight;
        }

        public void addEdgeDG(int sourceVertex, int targetVertex, int weight) {
            matrix[sourceVertex][targetVertex] = weight;
        }

        public void addEdgeDG(int sourceX, int sourceY, int targetX, int targetY, int weight) {
            matrix[(sourceX - 1) * width + sourceY][(targetX - 1) * width + targetY] = weight;
        }

        public List<Integer> dfs(int target) {
            Stack<Integer> stack = new Stack<>();
            List<Integer> path = new LinkedList<>();

            // 先把起始点能到达的位置压栈
            for (int i = 1; i < matrix[1].length; i++) {
                if (matrix[1][i] != 0) {
                    stack.push(i);
                    visited[i] = true;
                }
            }

            while (!stack.empty()) {
                int stackTop = stack.pop();
                path.add(stackTop);
                if (stackTop == target) {
                    break;
                }
                boolean hasNext = false;
                for (int i = 1; i < matrix[stackTop].length; i++) {
                    if (matrix[stackTop][i] != 0) {
                        stack.push(i);
                        visited[i] = true;
                        hasNext = true;
                    }
                }
                if (!hasNext) {
                    path.remove(new Integer(stackTop));
                }
            }
            return path;
        }

        public List<Integer> bfs(int target) {
            Queue<Integer> queue = new LinkedList<>();
            Stack<Integer> path = new Stack<>();

            // 先把起始点能到达的位置压栈
            for (int i = 1; i < matrix[1].length; i++) {
                if (matrix[1][i] != 0) {
                    queue.add(i);
                    visited[i] = true;
                    prev[i] = 1;
                }
            }

            while (!queue.isEmpty()) {
                int queueHead = queue.poll();
                if (queueHead == target) {
                    break;
                }
                for (int i = 1; i < matrix[queueHead].length; i++) {
                    if (matrix[queueHead][i] != 0) {
                        queue.add(i);
                        visited[i] = true;
                        prev[i] = queueHead;
                    }
                }
            }

            for (int i = target; i != 1; i = prev[i]) {
                path.add(i);
            }
            return path;
        }

        public List<Integer> djikstra(int target) {
            Stack<Integer> path = new Stack<>();
            visited[1] = true;
            int index = 1;
            for (int i = 1; i < matrix[1].length; i++) {
                if (matrix[1][i] != 0) {
                    dist[i] = matrix[1][i];
                    prev[i] = 1;
                }
            }

            for (int i = 2; i < matrix.length; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j < matrix.length; j++) {
                    if (!visited[j] && dist[j] != 0 && min > dist[j]) {
                        min = dist[j];
                        index = j;
                    }
                }
                visited[index] = true;

                for (int j = 1; j < matrix.length; j++) {
                    if (!visited[j] && matrix[index][j] != 0) {
                        if (dist[j] == 0 || dist[j] > dist[index] + matrix[index][j]) {
                            dist[j] = dist[index] + matrix[index][j];
                            prev[j] = index;
                        }
                    }
                }
            }

            for (int i = target; i != 0; i = prev[i]) {
                path.add(i);
            }
            return path;
        }
    }
}

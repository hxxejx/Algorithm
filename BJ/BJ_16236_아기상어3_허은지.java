package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class BJ_16236_아기상어3_허은지 {

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int N;
    private static int[][] arr;
    private static int[][] visited;
    private static int size = 2;
    private static int count = 0;
    private static int ans = 0;
    private static int sharkX = -1;
    private static int sharkY = -1;
    private static int minX;
    private static int minY;
    private static int min;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = scanner.nextInt();

                if (arr[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    arr[i][j] = 0;
                }
            }
        }

        while (true) {
            visited = new int[N + 1][N + 1];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            min = Integer.MAX_VALUE;

            bfs(sharkX, sharkY);

            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                count++;
                arr[minX][minY] = 0;
                sharkX = minX;
                sharkY = minY;
                ans += visited[minX][minY];

                if (count == size) {
                    size++;
                    count = 0;
                }
            } else {
                break;
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
    	Queue<int[]> queue2 = new LinkedList<>();
        queue2.add(new int[] {i,j});

        while (!queue.isEmpty()) {
            Point p = queue.poll();
        	int[] ij = queue2.poll();
//        	System.out.println(ij[0] + " " + p.x);
//        	System.out.println(ij[1] + " " + p.y);
        	
            for (int k = 0; k < 4; k++) {
            	int r = p.x + dx[k];
                int c = p.y + dy[k];
                System.out.println(ij[0] + " " + p.x);
            	System.out.println(ij[1] + " " + p.y);
            	int r2 = ij[0] + dx[k];
            	int c2 = ij[1] + dy[k];
                
            	//배열을 벗어나면 continue
                if(r<=0 || r>N || c<=0 || c>N) continue;
                
              //아기상어의 크기보다 작거나 같고 방문한 적 없으면 탐색
                if (arr[r][c] <= size && visited[r][c] == 0) {
                	
                	//탐색 횟수 +1씩 더해감
                    visited[r][c] = visited[p.x][p.y] + 1;
                    
                    //비어 있지 않고(0이 아니고) 아기상어의 크기보다 작으면 먹음
                    if (arr[r][c] != 0 && arr[r][c] < size) {
                    	//가장 가까운 곳을 골라서 먹음
                        if (min > visited[r][c]) {
                            min = visited[r][c];
                            minX = r;
                            minY = c;
                          //가장 가까운 곳이 두 곳 이상이면(이미 존재하면)
                        } else if (min == visited[r][c]) {
                        	//X가 같을 때
                            if (minX == r) {
                            	//Y가 더 작은 쪽을 먹음
                                if (minY > c) {
                                    minX = r;
                                    minY = c;
                                }
                              //아니면 X가 더 작은 쪽을 먹음
                            } else if (minX > r) {
                                minX = r;
                                minY = c;
                            }
                        }
                    }
                    //큐에 추가
                    queue.add(new Point(r, c));
                    queue2.add(new int[] {r, c});
                }
            }
        }
    }


    private static class Point {
        private int x;
        private int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
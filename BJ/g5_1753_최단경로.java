package com.ssafy.boj;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 정점의 개수 V 간선의 개수 E
 * 2. 시작 정점 K
 * 3. E개의 줄에 간선(u에서 v로 가는 가중치 w인 간선)
 */
public class g5_1753_최단경로 {
	static class Node implements Comparable<Node> {
        int number, weight;
        
        Node(int n, int w) {
            this.number = n;
            this.weight = w;
        }
        
        public int compareTo(Node n) {
            return weight - n.weight;
        }
    }
	
	static LinkedList<Node> list[];
    static int distance[];
    static boolean visit[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int K = Integer.parseInt(br.readLine());
        
        //방문 체크
        visit = new boolean[V+1];
        //문제에서 주어진 간선
        list = new LinkedList[V+1];
        //가중치의 값
        distance = new int[V+1];
        //-1이 남아 있으면 경로가 존재하지 않는 것
        Arrays.fill(distance, -1);
        
        //이게 뭐 하는 건지 잘 이해가 안감...
        //문제에서 주어진 간선
        for(int i = 1; i <= V; i++)
            list[i] = new LinkedList<>();
        
        //u번째 리스트에 v로 향하는 가중치 w의 간선 추가
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        
        //정점 K에서 시작하는 다익스트라 함수 호출
        dijkstra(K);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++)
            sb.append(distance[i] == -1 ? "INF" : distance[i]).append("\n");
        System.out.print(sb.toString());
    }
    
    public static void dijkstra(int start) {
    	//우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //우선순위 큐에 시작 정점을 넣어 줌
        pq.offer(new Node(start, 0));
        
        //시작 지점의 가중치는 0
        distance[start] = 0;
        
        //큐가 빌 때까지 while문 반복
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(!visit[now.number]) {
                visit[now.number] = true;
                for(Node next : list[now.number]) {
                    if(distance[next.number] == -1 || distance[next.number] > distance[now.number] + next.weight) {
                        distance[next.number] = distance[now.number] + next.weight;
                        pq.offer(new Node(next.number, distance[next.number]));
                    }
                }
            }
        }
    }
    
    
}
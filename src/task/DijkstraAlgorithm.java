package task;

import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class DijkstraAlgorithm {

    private int INF = Integer.MAX_VALUE / 2; // "Бесконечность"
    private int vNum; // количество вершин
    private int[][] graph; // матрица смежности

    public DijkstraAlgorithm(int vNum, int[][] graph) {
        this.vNum = vNum;
        this.graph = graph;
    }

    public int[] dijkstra(int start) {
        boolean[] used = new boolean[vNum]; // массив пометок
        int[] dist = new int[vNum]; // массив расстояния. dist[v] = минимальное_расстояние(start, v)
        int indexer = -1;
        fill(dist, INF); // устанаавливаем расстояние до всех вершин INF
        dist[start] = 0;// для начальной вершины положим 0

        while (!used[start]) {
            int minValueV = INF;//примитив для нахождения ближайшей из возможных вершинd
            for (int v = 0; v < vNum; v++) {
                    if (!used[v] && graph[start][v] != 0) {
                        dist[v] = min(dist[v], graph[start][v] +  dist[start]);
                        indexer = minValueV > graph[start][v] ? v : indexer;
                        minValueV = indexer == v ? graph[start][v] : minValueV;
                }
            }
            used[start] = true;
            start = indexer;
        }
        return dist;
    }
}

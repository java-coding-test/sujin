package boj.study.week6;

public class adjacencyArray {
    public static void main(String[] args) {
        int initSize = 6;
        ArrGraph adjArr = new ArrGraph(initSize);

        adjArr.put(1, 2);
        adjArr.put(1, 3);
        adjArr.put(2, 3);
        adjArr.put(2, 4);
        adjArr.put(3, 4);
        adjArr.put(3, 5);
        adjArr.put(4, 5);
        adjArr.put(4, 6);

        adjArr.printGraphToAdjArr();
    }
}

class ArrGraph {
    private int[][] arrGraph;

    public ArrGraph(int initSize) {
        /**
         * 그래프 초기화
         * put(int x, int y)에서 입력되는 정점의 값은 0 이상의 정수이나
         * 배열의 indexsms 0 부터 시작이므로
         * ArrayIndexOutOfBoundsException을 방지하기 위해
         * 정점을 담는 인접행렬의 행과 열 size는 1을 더하여 초기화 해줌
         */
        this.arrGraph = new int[initSize + 1][initSize + 1];
    }

    // 그래프 return
    public int[][] getGraph() {
        return this.arrGraph;
    }

    // 그래프 추가(양방향)
    public void put(int x, int y) {
        this.arrGraph[x][y] = this.arrGraph[y][x] = 1;
    }

    // 그래프 추가(단방향)
    public void putSingle(int x, int y) {
        this.arrGraph[x][y] = 1;
    }

    // 그래프 출력 (인접행렬)
    public void printGraphToAdjArr() {
        for (int i = 1; i < arrGraph.length; i++) {
            for (int j = 1; j < arrGraph[i].length; j++) {
                System.out.print(" " + arrGraph[i][j]);
            }
            System.out.println();
        }
    }
}

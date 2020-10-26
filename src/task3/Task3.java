package task3;

public class Task3 {
    public static void main(String[] args) {
        printResultTask3(0, 1, 0, 100);
        printResultTask3(1, 0, 0, 100);
        printResultTask3(5, 5, 100, 0);
        printResultTask3(5, 5, -100, 100);
        printResultTask3(4, 6,  0, 10);
    }

    static void printResultTask3(int A, int C, int minRandom, int maxRandom){
        try {
            swapColumns(fillRandom(A, C, minRandom, maxRandom));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    static void swapColumns(int[][] matrix){
        display(matrix);

        int tmp;
        int maxIndex = searchMaxIndex(matrix);
        int minIndex = searchMinIndex(matrix);

        for (int i = 0; i < matrix.length; i++) {
            tmp = matrix[i][maxIndex];
            matrix[i][maxIndex]=matrix[i][minIndex];
            matrix[i][minIndex] = tmp;
        }

        display(matrix);

    }

    static int searchMaxIndex(int[][] matrix){
        int maxIndex = 0;
        int max = matrix[0][0];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (max <= matrix[j][i]){
                    max = matrix[j][i];
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }

    static int searchMinIndex(int[][] matrix){
        int minIndex = 0;
        int min = matrix[0][0];
        for (int i = matrix[0].length-1; i >=0 ; i--) {
            for (int j = matrix.length-1; j >= 0; j--) {
                if (min >= matrix[j][i] ){
                    min = matrix[j][i];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    static int[][] fillRandom(int A, int C, int minRandom, int maxRandom){
        if(A <= 0 || C <= 0) throw new IllegalArgumentException("> Param i and j must be above zero!!!");
        if (minRandom >= maxRandom) throw new IllegalArgumentException("> Param maxRandom must be bigger than minRandom!!!");

        int[][] matrix = new int[A][C];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j]=  (int) ((Math.random() * (maxRandom-minRandom)) + minRandom);
            }
        }
        return matrix;
    }

    static void display(int[][]matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

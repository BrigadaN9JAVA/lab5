package task10;

public class Task10 {
    public static void main(String[] args) {
        printResultTask10(0);
        printResultTask10(2);
        printResultTask10(4);
        printResultTask10(5);
        printResultTask10(7);
    }

    static void printResultTask10(int N){
        try{
            if(isUnbalanced(fillRandom(N))){
                System.out.println("Хоча б одна команда виграла більше половини ігор!!!" + "\n");
            }
            else{
                System.out.println("Жодна команда не виграла більше поливини ігор!!!" + "\n");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    static boolean isUnbalanced(int[][] results){

        display(results);

        int count = 0;

        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results.length; j++) {
                if (results[i][j] == 2)
                    count++;
            }
        if(count >= Math.ceil(results.length/2.0)) {
            return true;
        }
        else
            count = 0;
        }
        return false;
    }

    static int[][] fillRandom(int N){
        if(N <= 0) throw new IllegalArgumentException("> Param N must be above zero!!!");

        int[][] results = new int[N][N];

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (i == j)
                    results[i][j] = 0;
                else if((int) (Math.random() * 3) == 2) {
                    results[i][j] = 2;
                    results[j][i] = 0;
                }
                else if((int) (Math.random() * 3) == 1){
                    results[i][j] = results[j][i] = 1;
                }
                else {
                    results[i][j] = 0;
                    results[j][i] = 2;
                }
            }
        }
        return results;
    }

    static void display(int[][] results){
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[i].length; j++) {
                System.out.print(results[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

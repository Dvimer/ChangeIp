package dvimer;

/**
 * Created by dvime_000 on 16.10.2016.
 */
//Дан массив целых неотрицательных чисел A и некоторое целое неотрицательное число a.
//        Написать функцию, принимающую на вход массив A и число a и возвращающую числа i и j
//        такие, что:
//        A[i] + A[i+1] + … + A[j-1] + A[j] = a
public class Task2 {
    public static void main(String[] args) {


        int A[] = {53, 5, 23, 67, 88, 3, 34, 96, 6};
        int a = 386;
        Pair pair = getIJ(A, a);
        System.out.println(pair.getI() + " " + pair.getJ());
    }

    public static Pair getIJ(int A[], int a) {
        int sum = 0;

        for (int legendary = 0, legendary2 = A.length - 1; legendary < A.length - 1; legendary++, legendary2--) {


            for (int i = legendary, j = legendary2; i < A.length - 1; i++, j--) {

                sum = sum + A[i] + A[j];
                if (sum == a) {
                    return new Pair(i, j);
                }
                if (sum > a) {
                    sum = 0;
                    i = A.length + 1;
                }
            }
        }
        return null;
    }
}


class Pair {
    private int i;
    private int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }
}



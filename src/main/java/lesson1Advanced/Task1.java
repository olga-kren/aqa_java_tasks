package lesson1Advanced;

import java.util.Arrays;

public class Task1 {
    /* Минимум n чисел
    Написать функцию, которая вычисляет минимум из массива чисел.
    */
    public static void main(String[] args) {
        int[] num = new int[]{2, 4, 6, 1, 90, 2, 0};
        int[] num1 = new int[]{2,4,6};

        Arrays.sort(num);
        Arrays.sort(num1);
        //System.out.println(min([2,4,6]));
        //System.out.println(min([2,4,6,1,90,2,0]));
        System.out.println("Minimum = " + num[0]);
        System.out.println("Minimum = " + num1[0]);

    }


}


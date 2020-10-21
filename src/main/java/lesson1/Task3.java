package lesson1;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом while
*/

public class Task3 {

    public static void main(String[] args) {
        String s = "Olga";
        int i = 5;
        while (i>0){
            int j = +10;
            while (j>0){
                System.out.print(s+" ");
                j--;
            }
            System.out.println(s);
            i--;
        }
    }
}
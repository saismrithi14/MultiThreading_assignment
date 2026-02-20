import java.util.*;
import java.io.*;
public class odd_even
{
    public static void main(String[] args) throws InterruptedException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();

        numberResource obj = new numberResource(number);
        Thread t1 = new Thread(()->{
           obj.printOdd(number);
        });

        Thread t2 = new Thread(()->{
           obj.printEven(number);
        });

        t1.start();
        t2.start();

    }
}
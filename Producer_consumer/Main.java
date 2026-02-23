import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of resources you want: ");
        int number_of_resources = sc.nextInt();
        Resource resource = new Resource(number_of_resources);

        Thread producer_thread = new Thread(()->{
           resource.producer();
        }, "Producer_thread");

        Thread consumer_thread = new Thread(()->{
           resource.consumer();
        }, "Consumer_thread");

        producer_thread.start();
        consumer_thread.start();
        try
        {
            producer_thread.join();
            consumer_thread.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("An exception occured");
        }
    }
}
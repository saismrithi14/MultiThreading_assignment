import java.util.*;
class odd_task extends Thread
{
    private int number;
    public odd_task(int number)
    {
        this.number = number;
    }
    @Override
    public void run()
    {
        for(int i = 1; i <= number; i++)
        {
            if(i%2 != 0)
            {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class even_task extends Thread
{
    private int number;
    public even_task(int number)
    {
        this.number = number;
    }
    @Override
    public void run()
    {
        for(int i = 1; i <= number; i++)
        {
            if(i%2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
public class basic_odd_even
{
    public static void main(String[] args)
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number between 1 and 100: ");
            int number = sc.nextInt();
            if(number < 1 || number > 100)
            {
                throw new OutOfRangeException("Number not in the asked range");
            }

            even_task even_thread = new even_task(number);
            odd_task odd_thread = new odd_task(number);

            even_thread.start();
            odd_thread.start();

            try
            {
                even_thread.join();
                odd_thread.join();
            }

            catch(InterruptedException e)
            {
                e.printStackTrace();
            }

            System.out.println("All threads have finished their execution");
        }

        catch(OutOfRangeException or)
        {
            System.out.println(or.getMessage());
        }
    }

}
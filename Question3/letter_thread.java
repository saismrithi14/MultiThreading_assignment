import java.util.*;
class myThread extends Thread
{
    private letterResource resource;
    private int number;
    public myThread(letterResource resource, int number)
    {
        this.resource = resource;
        this.number = number;
    }

    public int getNumber()
    {
        return this.number;
    }

    @Override
    public void run()
    {
        this.resource.printLetter(number);
    }
}

public class letter_thread
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        letterResource r = new letterResource(num);
        myThread a_thread = new myThread(r,0);
        myThread b_thread = new myThread(r,1);
        myThread c_thread = new myThread(r,2);
        myThread d_thread = new myThread(r,3);

        a_thread.start();
        b_thread.start();
        c_thread.start();
        d_thread.start();

        try
        {
            a_thread.join();
            b_thread.join();
            c_thread.join();
            d_thread.join();
        }

        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("All threads have been finished");


    }
}
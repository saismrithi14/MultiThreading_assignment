public class numberResource
{
    private boolean isEven;
    private int number;
    private int shared;

    public numberResource(int number)
    {
        this.isEven = false;
        this.number = number;
        this.shared = 1;
    }

    public synchronized void printOdd(int number)
    {
        while(shared < number)
        {
            while(isEven)
            {
                try {
                    wait();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + ": " + shared);
            shared ++;
            isEven = true;
            notify();
        }

    }

    public synchronized void printEven(int number)
    {
        while(shared < number)
        {
        while(!isEven)
        {
            try
            {
                wait();
            }

            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + ": " + shared);
        shared ++;
        isEven = false;
        notify();
        }
    }

}
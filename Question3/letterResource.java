public class letterResource
{
    private int shared;
    private int lock;
    private int number;


    public letterResource(int number)
    {
        this.number = number;
        this.shared = 0;
        this.lock = 0;
    }


    public synchronized void printLetter(int id)
    {
        while(shared < number)
        {
            while(id != lock && shared < number)
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

            if(shared < number) {
                System.out.println(Thread.currentThread().getName() + ": " + (char) (97 + id));
                shared++;
                lock = (lock + 1) % 4;
                notifyAll();
            }
        }
    }

}
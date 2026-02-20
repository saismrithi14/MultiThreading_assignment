public class sharedNumberResource
{
    private int shared;
    private int number;

    sharedNumberResource(int n)
    {
        this.number = n;
        this.shared = 2;
    }

    private boolean isPrime(int number)
    {
        if(number == 2)
        {
            return true;
        }
        int flag = 0;
        for(int i = 2; i < number; i++)
        {
            if(number % i == 0)
            {
                flag = 1;
                break;
            }
        }

        return flag == 0;
    }

    public synchronized void printPrimeNumbers(int number)
    {
        while(shared <= number)
        {
            while(!isPrime(shared))
            {
                try{wait();}
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }

            }

            if(shared <= number) {
                System.out.println(Thread.currentThread().getName() + ": " + shared);
                shared++;
                notifyAll();
            }
        }
    }

    public synchronized void printNonPrimeNumbers(int number)
    {
        while(shared <= number) {
            while (isPrime(shared)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                continue;
            }

            if (shared <= number){
            System.out.println(Thread.currentThread().getName() + ": " + shared);
            shared++;
            notifyAll();
        }
        }
    }

}
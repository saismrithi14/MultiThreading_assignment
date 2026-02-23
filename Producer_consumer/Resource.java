public class Resource
{
    private int number;
    private int shared;
    private boolean isAvailable;

    public Resource(int number)
    {
        this.number = number;
        this.shared = 1;
        this.isAvailable = false;
    }

    public synchronized void producer() {
        while (shared <= number) {
            while (isAvailable && shared <= number) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("An exception occured");
                }
            }

            System.out.println(Thread.currentThread().getName() + " produced: " + (shared));
            isAvailable = true;
            notify();

            while (isAvailable) {
                try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

        public synchronized void consumer()
        {
            while(shared <= number)
            {
                while(!isAvailable && shared <= number)
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

                if(shared > number)
                {
                    break;
                }

                System.out.println(Thread.currentThread().getName() + " consumed " + (shared));
                isAvailable = false;
                shared ++;
                notify();


            }
        }

    }

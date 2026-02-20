import java.util.*;
public class prime
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sharedNumberResource s = new sharedNumberResource(number);

        prime_task prime = new prime_task(s,number);
        nonPrime_task nonPrime = new nonPrime_task(s,number);

        Thread prime_thread = new Thread(prime,"Prime-Thread");
        Thread non_prime_thread = new Thread(nonPrime, "Non prime Thread");

        prime_thread.start();
        non_prime_thread.start();


    }
}

class prime_task implements Runnable
{
    private sharedNumberResource resource;
    private int number;

    public prime_task(sharedNumberResource resource, int number)
    {
        this.resource = resource;
        this.number = number;
    }

    @Override
    public void run()
    {
        this.resource.printPrimeNumbers(number);
    }

}

class nonPrime_task implements Runnable
{
    private sharedNumberResource resource;
    private int number;

    public nonPrime_task(sharedNumberResource resource, int number)
    {
        this.number = number;
        this.resource = resource;
    }

    @Override
    public void run()
    {
        this.resource.printNonPrimeNumbers(number);
    }

}

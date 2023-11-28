import java.util.*;
//thread prg with prime no
//this is sample
class Prime extends Thread 
{
    public void start()
    {
        int i;

        System.out.println("\nPrime Numbers :");

        for (i = 1; i <= 100; i++)

        { 
            int temp = 0;

            for (int j = i; j>=1; j--)
            {
                if(i%j==0)
                temp+=1;
            }
            if(temp==2) 
            {
                System.out.println(i);
            }
        }
    }
}
class Fibonacci extends Thread
{
    public void start()
    {   
        int a=0,b=1,c=0;

        System.out.println("\nFibonacci Series : ");
        System.out.println("1. "+a+" ");
        System.out.println("2. "+b+" ");

        for(int i=1;i<49;i++)
        {
            System.out.println(i+2+". "+c+" ");
            a=b;
            b=c;
            c=a+b;

            if(i==23)
            {
                try 
                {
                    Thread.sleep(1000);
                    Prime p=new Prime();
                    p.setName("Prime Thread");
                    p.setPriority(4);
                    p.start();

                    System.out.println("\nName:"+p.getName());
                    System.out.println("Priority:"+p.getPriority());
                    System.out.println("Alive:"+p.isAlive());

                   // System.out.println("\nFibonacci Series : ");
                } 
                catch (InterruptedException e) 
                {
                    System.out.println(e);
                }
            }

        }

    }
}
public class MultiThreading
{
    public static void main(String[] args) 
    {
        Fibonacci f=new Fibonacci();
        f.setName("Fibonacci Thread");
        f.setPriority(8);
        f.start();

        System.out.println("\nName:"+f.getName());
        System.out.println("Priority:"+f.getPriority());
        System.out.println("Alive:"+f.isAlive());
    }
}

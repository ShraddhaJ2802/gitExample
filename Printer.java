import java.io.*;
import java.util.*;

class FileInfo
{
	public void File()throws IOException
	{
		/*
		System.out.print("Enter File Name :");
		Scanner sc =new Scanner(System.in);
		String fname=sc.nextLine();
		*/
		File f=new File("NARENDRA");
		
		File f1=new File("D:/C Dac TVM/Data Structure/Queue Printer");
		System.out.println("\n Name : "+f.getName());
		System.out.println("\n Path : "+f1.getPath());
		System.out.println("\n Exists : "+f.exists());
		System.out.println("\n Directory : "+f.isDirectory());
		System.out.println("\n Is File : "+f.isFile());
		System.out.println("\n Last Modified : "+f.lastModified());
		System.out.println("\n Length : "+f.length()+" "+"Bytes");
		try
		{
			FileInputStream f2=new FileInputStream(f);
			StringBuffer buff = new StringBuffer(); 
			char ch;
			while(f2.available()!=0)
			{
				ch = (char)f2.read(); 
				buff.append(ch); 
			}
			System.out.println("\n Contents of the file are: \n");
			System.out.println(buff);
			f2.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found ! ");
		}
	}
	
}

class QueueOperations 
{
	int[] arr;  	
	int front;  	
	int rear;   	
	int capacity;  
	int count;  
	int size;	
	
	QueueOperations(int size)
	{
		arr = new int[size];
		capacity = size;
		front = 0;
		rear = -1;
		count = 0;
	}

	public int dequeue()
	{
		if (isEmpty())
		{
			System.out.println("Underflow\nProgram Terminated\n");
			System.exit(-1);
		}

		int x = arr[front];

		System.out.println("Removing " + x);

		front = (front + 1) % capacity;
		count--;

		return x;
	}

	public void enqueue(int item)
	{
		if (isFull())
		{
			System.out.println("Overflow\nProgram Terminated\n");
			System.exit(-1);
		}

		System.out.println("Inserting " + item);

		rear = (rear + 1) % capacity;
		arr[rear] = item;
		count++;
	}

	public int size() 
	{
		return count;
	}

	public boolean isEmpty() 
	{
		return (size() == 0);
	}

	public boolean isFull() 
	{
		return (size() == capacity);
	}
	
	public void disp()
	{
		if(front < rear ) 
		{
			for(int i = front; i != rear; i++ ) 
			{
				System.out.print(arr[i]+"--->");
			}
		}
	
		else 
		{
			for(int i = front; i != rear; i= (i + 1) % size ) 
			{
				System.out.println( arr[i]);
			}
		}
		
	}
}
public class Printer 
{
	public static void main(String[] args)throws IOException
	{
		try 
		{   
			int val;
			
			FileInfo file=new FileInfo();
			
			System.out.println("Enter Size of Queue");
			Scanner sc=new Scanner(System.in);
			int num=sc.nextInt();
			
			QueueOperations q = new QueueOperations (num);
			
			while(true)
			{
				System.out.print("\nEnter the Choice For Queue Operation:\n");

	            System.out.print("1.Enqueue\n");
	            System.out.print("2.Dequeue\n");
	            System.out.print("3.Check Queue is Empty or not\n");
				System.out.println("4.Display Queue Elements");
	            System.out.print("5.Size of Queue\n"); 
	            System.out.println("6.Exit\n");
	            
	            Scanner sc1=new Scanner(System.in);
				int ch=sc1.nextInt();
	            
				switch (ch)
				{
					case 1:
					{
						int arr[]=new int[num];
						
						System.out.println("Enter Value\n");
						for (int i = 0; i < arr.length; i++) 
						{
					        val = sc.nextInt();
					        q.enqueue(val);
						}
					}
						
					break;
					
					case 2:
					{
						q.dequeue();
					}
					    	
					break;
					
					case 3:
                    if (q.isEmpty()) 
                    {
                        System.out.println("The queue is empty\n");
                    }
                    else 
                    {
                        System.out.println("The queue is not empty\n");
                    }
					break;

					case 4:
					{
						q.disp();
					}
					
					case 5:
					{
						System.out.println("Size of Queue is"+" "+q.size()+"\n");
					}
					break;
					
					case 6:
					{
                        System.out.println("Sucessfully Exit !");
						System.exit(0);	
					}
					default:
						System.out.println("Invalid Input !");
				}
			}
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
	}

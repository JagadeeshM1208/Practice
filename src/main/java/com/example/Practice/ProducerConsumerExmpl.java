package com.example.Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerExmpl { 
	public static void main(String[] args) 
						throws InterruptedException 
	{ 
		// Object of a class that has both produce() 
		// and consume() methods 
		final PC ex = new PC(); 
		
		//SamplePCEx ex = new SamplePCEx();
		
		// Create producer thread 
		Thread t1 = new Thread(new Runnable() 
		{ 
			@Override
			public void run() 
			{ 
				try
				{ 
					ex.produce(); 
				} 
				catch(InterruptedException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
		}); 

		// Create consumer thread 
		Thread t2 = new Thread(new Runnable() 
		{ 
			@Override
			public void run() 
			{ 
				try
				{ 
					ex.consume(); 
				} 
				catch(InterruptedException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
		}); 

		// Start both threads 
		t1.start(); 
		t2.start(); 

		// t1 finishes before t2 
		t1.join(); 
		t2.join(); 
	} 

	// This class has a list, producer (adds items to list 
	// and consumber (removes items). 
	public static class PC 
	{ 
		// Create a list shared by producer and consumer 
		// Size of list is 2. 
		LinkedList<Integer> list = new LinkedList<>(); 
		int capacity = 2; 

		// Function called by producer thread 
		public void produce() throws InterruptedException 
		{ 
			int value = 0; 
			while (true) 
			{ 
				synchronized (this) 
				{ 
					// producer thread waits while list 
					// is full 
					while (list.size()==capacity) 
						wait(); 

					System.out.println("Producer produced-"
												+ value); 

					// to insert the jobs in the list 
					list.add(value++); 

					// notifies the consumer thread that 
					// now it can start consuming 
					notify(); 

					// makes the working of program easier 
					// to understand 
					Thread.sleep(1000); 
				} 
			} 
		} 

		// Function called by consumer thread 
		public void consume() throws InterruptedException 
		{ 
			while (true) 
			{ 
				synchronized (this) 
				{ 
					// consumer thread waits while list 
					// is empty 
					while (list.size()==0) 
						wait(); 

					//to retrive the ifrst job in the list 
					int val = list.removeFirst(); 

					System.out.println("Consumer consumed-"
													+ val); 

					// Wake up producer thread 
					notify(); 

					// and sleep 
					Thread.sleep(1000); 
				} 
			} 
		} 
	} 
} 

class Product1{  
    int id;  
    String name;  
    float price;  
    public Product1(int id, String name, float price) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
    
} 

class SamplePCEx{
	List<Product> list=new ArrayList<>();
	
	List<Product> list1=new ArrayList<>();
	
	int capacity=2;
	int size=0;
    
	public void producer() throws InterruptedException{
		list.add(new Product(1,"Samsung A5",17000f));  
		list.add(new Product(3,"Iphone 6S",65000f));  
		list.add(new Product(3,"Iphone 6S",65000f));  
		list.add(new Product(4,"Nokia Lumia",15000f));  
		list.add(new Product(5,"Redmi4 ",26000f));  
		list.add(new Product(6,"Lenevo Vibe",19000f));
		
		while(true){
			synchronized (this) {
				System.out.println("Prodcer Started !!!!!!!!!!!!!!!!!!!!");
				while(list1.size()==capacity)
					wait();
				if(list1.size()<=capacity){
					list1.add(list.get(size));
					size++;
				} else{
					Thread.currentThread().stop();
				}
				notify();
				Thread.sleep(1000);
			}
		}
		
	}
	
	public void consumer() throws InterruptedException{
		while(true){
			synchronized(this){
				System.out.println("Consumer Started!!!!!!!!!!!!!!!!!");
				while(list1.size()==0)
					wait();
				list1.forEach(obj->System.out.println("ID=="+obj.id+"name:::"+obj.name+"price==="+obj.price));
				list1.removeAll(list1);
				notify();
				Thread.sleep(1000);
			}
		}
	}
}


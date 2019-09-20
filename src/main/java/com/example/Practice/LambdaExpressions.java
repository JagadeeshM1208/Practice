package com.example.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface 
interface FunctionalIntr{
	//void a(String k);
	
	//int cal(int a, float b);
	 String toString(int id,String name,float price);
}

class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
    
}  

public class LambdaExpressions {
	public static void main(String[] args) {
		/*String msg="hjhfshfk";
		FunctionalIntr funIntr = (k)->{
			System.out.println("success"+k);
		};
		funIntr.a(msg);
		
		FunctionalIntr f1 = (k,v)->{
			return (int) (k+v);
		};
		System.out.println(f1.cal(10, 10.1f));*/
		
		List<Product> list=new ArrayList<Product>();  
        list.add(new Product(1,"Samsung A5",17000f));  
        list.add(new Product(3,"Iphone 6S",65000f));  
        list.add(new Product(3,"Iphone 6S",65000f));  
        list.add(new Product(4,"Nokia Lumia",15000f));  
        list.add(new Product(5,"Redmi4 ",26000f));  
        list.add(new Product(6,"Lenevo Vibe",19000f));  
        
        list.forEach(k->System.out.println("Value=="+k));
        
        list.stream().filter(k->k.price>10000).collect(Collectors.toList()).forEach(oj->System.out.println(oj.id));
        
       //BiFunction<Integer,String,Float,String> mref = FunctionalIntr::toString;
        
        System.out.println(list.stream().anyMatch(b->b.name=="Redmi4 "));
        
        System.out.println(list.stream().allMatch(b->b.name=="Redmi4 "));
        
        list.stream().distinct().forEach(obb->{
        	System.out.println(obb.id);
        });
        
        System.out.println(list.stream().findFirst());
        
        list.stream().limit(2).forEach(on->System.out.println(on.name));
        list.stream().mapToDouble(d->(double)d.id).forEach(o->System.out.println(o));;
	}
}

package com.example.Practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

public class FileOperations {
	static FileOutputStream fos;
	static FileReader fis;
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance(); 
		int dom =  c.get(Calendar.DAY_OF_MONTH);
		writeFile();
		readFile();
		serializationWriteOperation();
		deSerializationReadOperation();
	}
	
	public static void readFile(){
		try {
			fis = new FileReader("D://strTxt.txt");
			BufferedReader br = new BufferedReader(fis);
			String c;
			try {
				while((c = br.readLine()) != null){
					System.out.println(c);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void writeFile(){
		try {
			String cont = "Hello Jagadeesh M";
			
			fos = new FileOutputStream("D://strTxt.txt");
			try {
				fos.write(cont.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void serializationWriteOperation(){
		try {
			fos = new FileOutputStream("D://Emp.txt");
			emp e = new emp("jaga","TL",10);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(e);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void deSerializationReadOperation(){
		try {
			FileInputStream fis = new FileInputStream("D://Emp.txt");
			ObjectInputStream oos = new ObjectInputStream(fis);
			emp e = (emp)oos.readObject();
			System.out.println("Employee Name:: "+e.getName()+" Designation:: "+e.getDesc()+" Salary:: "+e.getSal());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}

class emp implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String desc;
	private int sal;
	
	public emp(String name, String desc, int sal) {
		super();
		this.name = name;
		this.desc = desc;
		this.sal = sal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
}

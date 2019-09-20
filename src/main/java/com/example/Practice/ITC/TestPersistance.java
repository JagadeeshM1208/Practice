package com.example.Practice.ITC;

import javax.persistence.Column;

class Base {
    public String f1() {
        return "fb" ;
    }
}

class Try extends Base {
	@Column(name="EmployeeName")
	String str;
    public String f1() {
        return "ft";
    }
    
}

public class TestPersistance {
 public static void main(String[] args) {
	 String str="00003ABC123";
	 Long sl = Long.parseLong(str,36);
	 System.out.println(sl);
	 System.out.println(String.valueOf(sl));
	 Try t = new Try(); t.f1();
 }
}

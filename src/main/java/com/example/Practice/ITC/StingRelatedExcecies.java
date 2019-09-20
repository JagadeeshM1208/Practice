package com.example.Practice.ITC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StingRelatedExcecies {
	
	static char ch=' ';
	//write the code to find the non repeted character for a given String
	static Character firstNonRepeating(String str) 
    { 
		Map<Character,Integer> mapCheck = new HashMap<>();
        for (int i = 0; i < str.length();  i++) 
        { 
        	if(mapCheck.get(str.charAt(i))!=null){
        		mapCheck.put(str.charAt(i),mapCheck.get(str.charAt(i))+1);
        	} else{
        		mapCheck.put(str.charAt(i),1);
        	}
        }   
        mapCheck.forEach((k,v)->{
        	if(v==1){
        		ch=k;
        	}
        });
        
      return ch; 
    } 
	
	public static void main(String[] args) {
		String str = "jagajagadsgfgjgfjfgjfgjfgjfjgffgjfjjjgjgjghjghjghjghjghjghjhgjhgjghj";
		Character index = firstNonRepeating(str);
		System.out.println(index);
		int[] nums = {12,13,1,9,10,34,1};
		System.out.println("Second Smallest Num==="+findSecondSmallestNum(nums));
		int[] arr1={5,8,9};int[] arr2={4,7,8};
		mergeTwoSortedArrays(arr1,arr2);
		String name="getting good at coding needs a lot of practice";
		System.out.println(reverseStringInOrder(name));
		String[] arry={"aaa","bbb","ccc","bbb","aaa","aaa"};
		System.out.println("Second Most repeated Value ====="+findSecondMostRepeatedWord(arry));
		int[] values = {121,123,124,125,121};
		printTheMissingAndRepeatedValue(values);
		String[] anagaram = {"art","cat","cheese","rat","tar","act","tca"};
		findTheAnagarams(anagaram);
		primeFactors(24);
		int[] aass ={10,22,33,44,55,66,77};
		insertElementInSortedArray(aass,24);
		getPowerOfTwoNums(2,2);
	}
	
	public static  void converCharacterArrayToInt(){
		Character charArray[] = { 'G', 'e', 'e', 'k', 's' }; 
		  
        // Convert charArray to IntStream 
        IntStream 
            intStream 
            = Stream 
  
                  // Convert charArray into Stream of characters 
                  .of(charArray) 
  
                  // Convert the Stream of characters into IntStream 
                  .flatMapToInt(IntStream::of); 
  
        // Print the elements of the IntStream 
        System.out.println("IntStream:"); 
        intStream.forEach(System.out::println);
        
        //convert Set Of Integers to Array Of Strings
        
        Set<Integer> setOfInteger = new HashSet<>( 
                Arrays.asList(1, 2, 3, 4, 5)); 
        int[] arr = setOfInteger.stream().mapToInt(Integer::intValue).toArray();
        
	}
	
	public static void getPowerOfTwoNums(int exponent,int base){
        long result = 1;
        while (exponent != 0)
        {
            result *= base;
            --exponent;
        }
        System.out.println("Answer = " + result);
        System.out.println("Answer = " + Math.pow(exponent, base));
	}
	
	static void isAnagram(String str1, String str2) {  
        String s1 = str1.replaceAll("\\s", "");  
        String s2 = str2.replaceAll("\\s", "");  
        boolean status = true;  
        if (s1.length() != s2.length()) {  
            status = false;  
        } else {  
            char[] ArrayS1 = s1.toLowerCase().toCharArray();  
            char[] ArrayS2 = s2.toLowerCase().toCharArray();  
            Arrays.sort(ArrayS1);  
            Arrays.sort(ArrayS2);  
            status = Arrays.equals(ArrayS1, ArrayS2);  
        }  
        if (status) {  
            System.out.println(s1 + " and " + s2 + " are anagrams");  
        } else {  
            System.out.println(s1 + " and " + s2 + " are not anagrams");  
        }  
    } 
	public static int findSecondSmallestNum(int[] arr){
		List<Integer> intsSeq = new ArrayList<>();
		for(int i=0;i<arr.length;i++){
			intsSeq.add(arr[i]);
		}
		intsSeq.sort(Comparator.naturalOrder());
		Set<Integer> intsN = new LinkedHashSet<>(intsSeq);
		return new ArrayList<>(intsN).get(1);
	}
	
	public static int[] mergeTwoSortedArrays(int[] arr1,int[] arr2){
		Integer[] mergArr= new Integer[arr1.length+arr2.length];
		Set<Integer> sortedSet = new HashSet<>();
		for(int i=0;i<arr1.length;i++){
			sortedSet.add(arr1[i]);
			//mergArr[i]=arr1[i];
		}
		int count=0;
		for(int i=arr1.length;i<=mergArr.length-1;i++){
			sortedSet.add(arr2[count]);
			//mergArr[i]=arr2[count];
			count++;
		}
		for(int a: sortedSet){
			//sortedSet.add(a);
			System.out.println(a);
		}
		return null;
	}
	
	public static String reverseStringInOrder(String sentense){
		String[] sentences = sentense.split(" ");
		StringBuffer sb = new StringBuffer();
		for(int i=sentences.length-1;i>=0;i--){
			sb.append(sentences[i]+" ");
		}
		return sb.toString();
	}
	
	static String value="";
	static int first_Max=0,second_Max=0;
	     
	private static String findSecondMostRepeatedWord(String[] arr){
		Map<String,Integer> secondMap = new LinkedHashMap<>();
		for(int i=0;i<arr.length;i++){
			if(secondMap.get(arr[i])!=null){
				secondMap.put(arr[i],secondMap.get(arr[i])+1);
			} else{  
				secondMap.put(arr[i],1);
			}
		}
		
		secondMap.forEach((k,v)->{
			if(v>=2 && first_Max==0){
				first_Max=1;
			} else if(v>=2 && first_Max==1){
				value=k;
			}
		});
		return value;
	}
	static int repeatedVal;
	public static void printTheMissingAndRepeatedValue(int[] arr){
		Map<Integer,Integer> counts = new HashMap<>();
		Set<Integer> missingNum = new HashSet<>();
		for(int i=0;i<arr.length;i++){
			missingNum.add(arr[i]);
		}
		List<Integer> nLi11 = new ArrayList<>(missingNum);
		List<Integer> nLi12 = new ArrayList<>(); 
		int v = nLi11.get(0);
		for(int i=0;i<arr.length;i++){
			System.out.println(v);
			nLi12.add(v);
			v++;
			if(counts.get(arr[i])!=null){
				counts.put(arr[i],counts.get(arr[i])+1);
			} else{
				counts.put(arr[i], 1);
			}
		}
		nLi12.removeAll(nLi11);
		System.out.println("Missing Value is ===="+nLi12.get(0));
		counts.forEach((k,v1)->{
			if(v1>=2){
				repeatedVal=k;
			}
		});
		System.out.println("Repeated Value is ===="+repeatedVal);

	}
	
	public static void findTheAnagarams(String[] arr){
		Map<String,List<String>> anagarmMap = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			List<Character> chList = new ArrayList<>();
			for(char c:arr[i].toCharArray()){
				chList.add(c);
			}
			for(int j=i+1;j<arr.length;j++){
				List<Character> chList1 = new ArrayList<>();
				for(char c:arr[j].toCharArray()){
					chList1.add(c);
				}
				Collections.sort(chList);Collections.sort(chList1);
				if(chList.equals(chList1)){
					if(anagarmMap.get(arr[i])!=null){
						List<String> aa = anagarmMap.get(arr[i]);
						aa.add(arr[j]);
					} else{
						List<String> aa = new ArrayList<>();
						aa.add(arr[j]);
						aa.add(arr[i]);
						anagarmMap.put(arr[i], aa);
					}
				}
			}
		}
		System.out.println(anagarmMap);
	}
	
	public static void primeFactors(int n) 
    { 
        // Print the number of 2s that divide n 
        while (n%2==0) 
        { 
            System.out.print(2 + " "); 
            n /= 2; 
        } 
  
        // n must be odd at this point.  So we can 
        // skip one element (Note i = i +2) 
        for (int i = 3; i <= Math.sqrt(n); i+= 2) 
        { 
            // While i divides n, print i and divide n 
            while (n%i == 0) 
            { 
                System.out.print(i + " "); 
                n /= i; 
            } 
        } 
  
        // This condition is to handle the case whien 
        // n is a prime number greater than 2 
        if (n > 2) 
            System.out.print(n); 
    } 
	
	public static void insertElementInSortedArray(int[] arr, int num){
		//{10,22,33,44,55,66,77}; //24
		Boolean insertion=false;
		Integer[] finalOne= new Integer[arr.length+1];
		for(int i=0;i<arr.length;i++){
			if(!insertion){
				if(arr[i]<num){
					finalOne[i] = arr[i];
				} else{
					System.out.println("insertion Value::"+arr[i]);
					finalOne[i] = num;
					finalOne[i+1] = arr[i];
					insertion=true;
				}
			} else{
				finalOne[i+1] = arr[i];
			}
		}
		System.out.println(finalOne);
	}

}

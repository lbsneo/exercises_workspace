package ex1;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise 
{
	public static void main(String[] args) 
	{
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList();		// 교집합
		ArrayList cha = new ArrayList();		// 차집합
		ArrayList hap = new ArrayList();		// 합집합
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		/* 코드 작성 */
		kyo.addAll(list1);
		cha.addAll(list1);
		hap.addAll(list2);
		
		kyo.retainAll(list2);
		cha.removeAll(list2);
		hap.addAll(cha);
		
		Collections.sort(hap);
				
		System.out.println("list1 = " + list1);
		System.out.println("list2 = " + list2);
		System.out.println("kyo = " + kyo);
		System.out.println("cha = " + cha);
		System.out.println("hap = " + hap);
	}
}

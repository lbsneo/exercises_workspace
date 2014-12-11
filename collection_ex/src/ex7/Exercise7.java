package ex7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 다음에 제시된 BanNoAscending클래스를 완성하여, ArrayList에 담긴 Student 인스턴스들이
 * 반(ban)과 번호(no)로 오름차순 정렬되게 하시오.(반이 같은 경우 번호를 비교해서 정렬한다.)
 * */
class Student 
{
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	Student(String name, int ban, int no, int kor, int eng, int math) 
	{
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	/*합계 */
	int getTotal()
	{
		return kor+eng+math;
	}
	
	/* 평균 */
	float getAverage()
	{
		return  (int) (((getTotal()/3f)*10+0.5)/10f);
	}

	@Override
	public String toString() 
	{
		return name + "," + ban + "," + no
				+ "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}
	
}	// class Student

class BanNoAscending implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) 
	{
		if(o1 instanceof Student && o2 instanceof Student)
		{
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;
			
			if(s1.ban == s2.ban)
				return s1.no<s2.no? -1 : s1.no>s2.no? 1 : 0;
			else
				return s1.ban<s2.ban? -1 : s1.ban>s2.ban? 1 : 0;
		}
		else
		{
			return -1;
		}
		
	}
	
}

public class Exercise7 
{
	public static void main(String[] args) 
	{
		ArrayList list = new ArrayList();
		list.add(new Student("이자바", 2, 1, 70, 90, 70));
		list.add(new Student("안자바", 2, 2, 60, 100, 80));
		list.add(new Student("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student("김자바", 1, 2, 80, 80, 90));
		
		Collections.sort(list, new BanNoAscending());
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());

	}

}

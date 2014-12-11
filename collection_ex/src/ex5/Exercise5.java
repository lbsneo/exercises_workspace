package ex5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * 다음에 제시된 Student 클래스가 Comparable 인터페이스를 구현 하도록 변경해서 이름(name)이 기본 정렬기준으로 되도록 하시오.
 * */
class Student implements Comparable
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

	/* 문제 구현부 */
	@Override
	public int compareTo(Object o) 
	{
		if(o instanceof Student)
			return this.name.compareTo(((Student) o).name);
		else
			return -1;
	}
}	// class Student

public class Exercise5 
{
	public static void main(String[] args) 
	{
		ArrayList list = new ArrayList();
		list.add(new Student("홍길동", 1, 1, 100, 100, 100));
		list.add(new Student("남궁성", 1, 2, 90, 70, 80));
		list.add(new Student("김자바", 1, 3, 80, 80, 90));
		list.add(new Student("이자바", 1, 4, 70, 90, 70));
		list.add(new Student("안자바", 1, 5, 60, 100, 80));
		
		Collections.sort(list);
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
	}
}

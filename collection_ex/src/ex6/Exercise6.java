package ex6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 다음의 코드는 성적평균의 범위별로 학생 수를 세기 위한 것이다. TreeSet이 학생들의 평균을
 * 기준으로 정렬하도록 compare(Object o1, Object o2)와 평균점수의 범위를 주면
 * 해당 범위에 속한 상생의 수를 반환하는 getGroupCount()를 완성하라.
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

public class Exercise6 
{
	static int getGroupCount(TreeSet tset, int from, int to)
	{
		/* 문제 구현부 */
		int result = 0;
		Iterator it = tset.iterator();
		
		while(it.hasNext())
		{
			 Student s = (Student) it.next();
			 result += s.getAverage() >= from && s.getAverage() < to? 1 : 0;
		}
		
		return result;
	}
	
	public static void main(String[] args) 
	{
		TreeSet set = new TreeSet(new Comparator() 
							{
								/* 문제 구현부 */
								@Override
								public int compare(Object o1, Object o2) 
								{
									if(o1 instanceof Student && o2 instanceof Student)
									{
										float average1 = ((Student) o1).getAverage();
										float average2 = ((Student) o2).getAverage();
										
										return average1<average2? -1 : average1>average2? 1:0;
									}
									else
									{
										return -1;
									}
								}
								
							});
		
		set.add(new Student("홍길동", 1, 1, 100, 100, 100));
		set.add(new Student("남궁성", 1, 2, 90, 70, 80));
		set.add(new Student("김자바", 1, 3, 80, 80, 90));
		set.add(new Student("이자바", 1, 4, 70, 90, 70));
		set.add(new Student("안자바", 1, 5, 60, 100, 80));
		
		Iterator it = set.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
		
		System.out.println("[60~69] : " + getGroupCount(set, 60, 70));
		System.out.println("[70~89] : " + getGroupCount(set, 70, 80));
		System.out.println("[80~99] : " + getGroupCount(set, 80, 90));
		System.out.println("[90~100] : " + getGroupCount(set, 90, 101));
	}
}

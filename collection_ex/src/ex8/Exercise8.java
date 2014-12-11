package ex8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 다음에 제시된 Student 클래스가 Comparable 인터페이스를 구현 하도록 변경해서 이름(name)이 기본 정렬기준으로 되도록 하시오.
 * */
class Student implements Comparable
{
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	private int total;	// 총점
	int schoolRank;		// 전교 등수
	
	Student(String name, int ban, int no, int kor, int eng, int math) 
	{
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		this.total = kor+eng+math;
	}
	
	/*합계 */
	int getTotal()
	{
		return total;
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
				+ "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage() + "," + schoolRank;
	}

	/* 문제 구현부 */
	@Override
	public int compareTo(Object o) 
	{
		if(o instanceof Student)
			return (this.total < ((Student) o).getTotal()? -1 : this.total > ((Student) o).getTotal()? 1 : 0) * -1;
		else
			return -1;
	}
}	// class Student

public class Exercise8 
{
	public static void calculateSchoolRank(List list) 
	{
		Collections.sort(list);		// 먼저 총점 기준으로 내림차순으로 정렬한다.
		
		int prevRank = -1;		// 이전 전교등수
		int prevTotal = -1;		// 이전 총점
		int length = list.size();
		
		for(int n=0; n < length; n++)
		{
			Student s = (Student)list.get(n);
			
			if(n == 0)
				s.schoolRank = 1;
			else
				s.schoolRank = prevTotal > s.getTotal()? n+1 : prevRank;
				
			prevRank = s.schoolRank;
			prevTotal = s.getTotal();
		}
	}

	public static void main(String[] args) 
	{
		ArrayList list = new ArrayList();
		list.add(new Student("이자바", 2, 1, 70, 90, 70));
		list.add(new Student("안자바", 2, 2, 60, 100, 80));
		list.add(new Student("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student("김자바", 1, 2, 80, 80, 90));
		
		calculateSchoolRank(list);
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());

	}

}

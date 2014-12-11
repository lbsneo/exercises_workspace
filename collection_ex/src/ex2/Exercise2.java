package ex2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

/*
 *  다음 코드의 실행 결과를 적으시오.
 * */
public class Exercise2 
{

	public static void main(String[] args) 
	{
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		
		HashSet set = new HashSet(list);
		TreeSet tset = new TreeSet(set);
		Stack stack = new Stack();
		stack.addAll(tset);
		
		while(!stack.empty())
			System.out.println(stack.pop());

	}

}

/********** 실행결과 ************
 * 7
 * 6
 * 3
 * 2
 * ****************************/


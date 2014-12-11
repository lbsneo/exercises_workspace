package ex8;

/*
 * 다음의 코드는 '-'를 추력하는 쓰레드와 'l'를 출력하는 쓰레드를 생성해서 실행 시킨다.
 * 이 두 개의 쓰레드가 실행겨과처럼 '-'와 'l'를 한번씩 번갈아 가며 찍게 하려면 아래의 코드를 어떻게 변경해야 하는가?
 * */
public class Exercise8 
{
	public static void main(String[] args) 
	{
		Thread6_1 th6_1 = new Thread6_1();
		Thread6_2 th6_2 = new Thread6_2();
		
		th6_1.start();
		th6_2.start();
	}
}

class Thread6_1 extends Thread
{

	@Override
	public void run() 
	{
		for(int i = 0; i < 300; i++)
		{
			System.out.print('-');
			yield();
		}
	} // run
}

class Thread6_2 extends Thread
{

	@Override
	public void run() 
	{
		for(int i = 0; i < 300; i++)
		{
			System.out.print('l');
			yield();
		}
	} // run
}
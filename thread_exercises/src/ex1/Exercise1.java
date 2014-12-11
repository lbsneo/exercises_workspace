package ex1;

/*
 *  쓰레드를 구현하는 방법에는 Thread 클래스로부터 상속받는 것과 Runnable인터페이스를
 *  구현하는 것 두가지가 있는데, 다음의 코드는 Thread클래스를 상속받아서 쓰레드를 구현한 것이다.
 *  이 코드를 Runnable인터페이스를 구현 하도록 변경하시오.
 * */
public class Exercise1 
{

	public static void main(String[] args) 
	{
		Runnable r = new Thread1();
		Thread th = new Thread(r);
		
		th.start();
	}

}

/* 문제구현부 */
class Thread1 implements Runnable
{

	@Override
	public void run() 
	{
		for(int i=0; i < 300; i++)
		{
			System.out.print('-');
			
			if((i+1) % 50 == 0)
				System.out.println();
		}
	}
	
}
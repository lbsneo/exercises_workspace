package ex2;

/*
 * 다음 코드의 실행 결과로 옳은 것은? b <-- 내가 고른 답
 * 
 * a. 01021233454567689789 처럼 0부터 9까지의 숫자가 섞여서 출력된다.
 * b. 01234567890123456789 처럼 0부터 9까지의 숫자가 순서대로 출력된다.
 * c. IIIegaIThreadSrateException이 발생한다.
 * */
public class Exercise2 
{
	public static void main(String[] args) 
	{
		Thread th2 = new Thread2();
		th2.run();
		
		for(int i = 0; i < 10; i++)
			System.out.print(i);
	}
}

class Thread2 extends Thread
{

	@Override
	public void run() 
	{
		for(int i = 0; i < 10; i++)
			System.out.print(i);
	}
	
}

/* 문제 정답 */
// b
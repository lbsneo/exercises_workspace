package ex6;

/*
 * 다음의 코드르 실행한 결과를 예측하고, 직접 실행한 결과와 비교하라. 만일 예측한 결과와 실행한 결과의 차이가 있다면 그 이유를 설명하라.
 * */

/* 결과 예측 
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 꽝~!!!
 * */

/* 비교 후 설명
 * 역시 내가 생각한 결과와 크게 다르지 않았다.
 * Thread4 데몬 쓰레드로 설정하였는다.
 * 
 * 데몬 쓰레드는 일반 쓰레드를 돕는 역활로 
 * 일반 쓰레드가 모두 종료 되면 같이 종료가 된다.
 * main 메서드에서 5초뒤 Exception 오류를 발생시키면서
 * 쓰레드가 종료 되었으므로 데몬쓰레드도 같이 종료 된다.
 * 
 * */
public class Exercise6 
{
	public static void main(String[] args) throws Exception
	{
		Thread4 th4 = new Thread4();
		th4.setDaemon(true);
		th4.start();
		
		try 
		{
			Thread.sleep(5 * 1000);	// 5초
		} 
		catch (Exception e) 
		{
			
		}
		
		throw new Exception("꽝~!!!");
	}
}

class Thread4 extends Thread
{
	@Override
	public void run() 
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println(i);
			
			try
			{
				Thread.sleep(1000);		// 1초
			}
			catch(Exception e)
			{
				
			}
		}
	}	// run()
	
}
/* 문제 정답 
 * 0
	1
	2
	3
	4
	5
	Exception in thread "main" java.lang.Exception: 꽝~!!!
		at ex5.Exercise5.main(Exercise5.java:38)
 * */
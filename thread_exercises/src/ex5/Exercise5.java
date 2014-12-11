package ex5;

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
 * 6
 * 7
 * 8
 * 9
 * */

/* 비교 후 설명
 * 역시 내가 생각한 결과와 크게 다르지 않았다.
 * 먼저 Thread3 와 메인에서도 쓰레드 2개가 실행중이다.
 * Thread3는 1초마다 숫자가 1씩증가하고
 * main메서드에서는 5초 뒤에 Exception 오류를 발생하게 만들었다.
 * 
 * 0~5까지 출력후 main메서드에서 발생한 Exception오류 메세지가 나오고
 * Thread3의 쓰레드와는 별개이니 계속 진행되어 6~9까지 찍어내고 종료가 된다.
 * 
 * */
public class Exercise5 
{

	public static void main(String[] args) throws Exception
	{
		Thread3 th3 = new Thread3();
		th3.start();
		
		try 
		{
			Thread.sleep(5 * 1000);	// 5초
		} 
		catch (Exception e) 
		{
			
		}
		
		throw new Exception("꽝~!!!");
	}	// main(String[] args)
}

class Thread3 extends Thread
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
	6
	7
	8
	9
 * */

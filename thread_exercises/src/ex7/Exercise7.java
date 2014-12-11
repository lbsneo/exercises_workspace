package ex7;

/*
 * 다음의 코드는 쓰레드 th5을 생성해서 실행시킨 다음 6초 후에 정지시키는 코드이다.
 * 그러나 실제로 실행시켜보면 쓰레드르 정지시킨 다음에도 몇 초가 지난 후에서야 멈춘다.
 * 그 이유를 설명하고, 쓰레드를 정지시키면 지체없이 바로 정지 되도록 코드를 개선하시오.
 * */

/* 설명
 * - 기존 소스 코드에는 Thread 가 sleep 상태 일때 즉시 깨우는 코드가 없다.
 *   2개의 쓰레드의 실행되는 시간이 맞아 떨어지지 않으면 바로 종료되지 않는다.
 *   Thread5 쓰레드를 interrupt() 실행하여 sleep 상태의 쓰레드를 깨워야 한다.
 * */
public class Exercise7 
{
	static boolean stopped = false;
	
	public static void main(String[] args) 
	{
		Thread5 th5 = new Thread5();
		th5.start();
		
		try 
		{
			Thread.sleep(6 * 1000);
		}
		catch (Exception e) 
		{
			
		}
		
		stopped = true;	// 쓰레드 정지
		/* 문제 구현부 */
		th5.interrupt();
		// end 문제 구현부
		System.out.println("stopped");
	}

}

class Thread5 extends Thread
{
	@Override
	public void run() 
	{
		// Exercise7.stopped의 값이 flase인 동안 반복한다.
		for(int i=0; !Exercise7.stopped; i++)
		{
			System.out.println(i);
			
			try 
			{
				Thread.sleep(3 * 1000);
			} 
			catch (Exception e) 
			{
				
			}
		} // for(int i=0; !Exercise7.stopped; i++)
	}	// run
	
}
package ex9;

import java.util.Scanner;
import java.util.Vector;

/* 다음의 코드는 텍스트기반의 타ㅏ연습게임인데 WordGenerator라는 쓰레드가
 * Vecator에 2초마다 단어를하나씩 추가하고, 사용자가 단어를 입력하면 Vector에서 일치하는 단어를 삭제하도록 되어 있다. 
 * WordGenerator의 run()을 완성하시오.
 * */
public class Exercise9 
{
	Vector words = new Vector();
	String[] data = {"태연","유리","윤아","효연","수영","서현","티파니","써니","제시카"};
	
	int interval = 2 * 1000;
	
	WordGenerator wg = new WordGenerator();
	
	public static void main(String[] args) 
	{
		Exercise9 game = new Exercise9();
		
		game.wg.start();
		
		Vector words = game.words;
		
		while(true)
		{
			System.out.println(words);
			
			String prompt = ">>";
			System.out.print(prompt);
			
			// 화면으로부터 라인 단위로 입력 받는다.
			Scanner s = new Scanner(System.in);
			String input= s.nextLine().trim();
			
			int index = words.indexOf(input);
			
			if(index != -1)
				words.remove(index);
		}
	
	}
	
	class WordGenerator extends Thread
	{
		@Override
		public void run() 
		{
			/* 문제 구현부 */
			while(true)
			{
				try 
				{
					words.add(data[(int)(Math.random() * data.length)]);
					
					Thread.sleep(interval);
				} 
				catch (Exception e) 
				{
					
				}
			}
			
		} // end of run()
	} // class WordGenerator
} 

package ex6;

import java.io.File;
import java.util.Scanner;

/*
 * 다음은 콘솔 명령어 중에서 디레토리를 변경하는 cd명령을 구현한 거이다. 알맞은 코드를 넣어 cd()를 완성하시오.
 * */
public class Exercise6 
{
	static String[] argArr;
	static File curDir;
	
	static 
	{
		try 
		{
			curDir = new File(System.getProperty("user.dir"));
		}
		catch (Exception e) {} 
	}
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		while(true)
		{
			try 
			{
				String prompt = curDir.getCanonicalPath() + ">>";
				System.out.print(prompt);
				
				// 화면으로부터 라인단위 입력받는다.
				String input = s.nextLine();
				
				input = input.trim();	// 입력받은 값에서 불필요한 공백제거
				argArr = input.split(" +");
				
				String command = argArr[0].trim();
				
				if("".equals(command)) continue;
				
				command = command.toLowerCase();			// 명령어를 소문자로 변경.
				
				if(command.equals("q"))	// "q" 또는 "Q" 입력시 종료.
						System.exit(0);
				else if(command.equals("cd"))
				{
					cd();
				}
				else 
				{
					for(int i = 0; i < argArr.length; i++)
					{
						System.out.println(argArr[i]);
					}
				}
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println("입력 오류입니다.");
			}
		}	// while
	}	// main
	
	/* 문제 구현부 */
	public static void cd()
	{
		if(argArr.length == 1)
		{
			System.out.println(curDir);
			return;
		}
		else if(argArr.length > 2)
		{
			System.out.println("USAGE : cd directory");
			return;
		}
		
		String subDir = argArr[1];
		
		if("..".equals(subDir))
		{
			File file = new File(curDir.getPath());
			if(file.exists())
				curDir =  new File(file.getParent());
			else
			{
				System.out.println("최상위 폴더 입니다.");
				return;
			}
		}
		else if(".".equals(subDir))
		{
			System.out.println(curDir.getPath());
			return;
		}
		else
		{
			File file = new File(curDir.getPath() + curDir.separator + subDir);
			
			if(file.exists() && file.isDirectory())
			{
				curDir = file;
			}
			else
			{
				System.out.println("유효하지 않은 디렉토리 입니다.");
				return;
			}
		}
	} // cd
}

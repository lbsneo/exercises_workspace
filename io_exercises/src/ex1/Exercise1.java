package ex1;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * 커맨드라인으로 부터 파일명과 숫자를 입력 받아서, 입력받은 파일의 내용의 처음부터
 * 입력받은 숫자만큼의 라인을 출력하는 프로그램을 작성하라
 * */
public class Exercise1 
{
	public static void main(String[] args) 
	{
		try 
		{
			int line = Integer.parseInt(args[0]);
			String fileName = "src/ex1/"+args[1];
			
			FileReader frd = null;
			BufferedReader brd = null;
			
			String data;
			
			frd = new FileReader(fileName);
			brd = new BufferedReader(frd);
			
			for(int n=1; (data = brd.readLine()) != null; n++)
			{
				if(n > line) break;
				
				System.out.println(n+": "+data);
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}

	}

}

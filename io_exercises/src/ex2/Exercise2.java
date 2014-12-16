package ex2;

import java.io.FileInputStream;
import java.io.PrintStream;

/*
 * 지정된 이진파이의 내용을 실행결과와 같이 16진수로 보여주는 프로그램을 작성하라.
 * 
 * 예제
 * > java Exercise2 Exercise2.class
 * ca fe ba be 00 00 00 33 00 5a 07 00 02 01 00 0d 
	65 78 32 2f 45 78 65 72 63 69 73 65 32 07 00 04 
	01 00 10 6a 61 76 61 2f 6c 61 6e 67 2f 4f 62 6a 
	65 63 74 01 00 06 3c 69 6e 69 74 3e 01 00 03 28 
	29 56 01 00 04 43 6f 64 65 0a 00 03 00 09 0c 00 
	05 00 06 01 00 0f 4c 69 6e 65 4e 75 6d 62 65 72 
	.........(생략)
 * */
public class Exercise2 
{
	public static void main(String[] args) 
	{
		if(args.length < 0)
		{
			System.out.println("USAGE: java Exercise2 FILENAME");
			System.exit(0);
		}
		
		String inputFile = "bin/ex2/"+args[0];
		
		try 
		{
			FileInputStream input = new FileInputStream(inputFile);
			PrintStream output = new  PrintStream(System.out);
			
			int data = 0;
			int i = 0;
			
			while((data = input.read()) != -1)
			{
				System.out.printf("%02x ",data);
				
				if(++i%16 == 0)
					System.out.println();
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

}

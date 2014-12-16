package ex4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

/*
 * 커맨드드라인으로 부터 여러 파일의 이름을 입력받고, 이파일들을 순서대로 합쳐
 * 서 새로운 파일을 만들어 내는 프로그램을 작성하시오. 단, 합칠 파일의 개수에는 제한을 두지 않는다.
 * */
public class Exercise4 
{
	public static void main(String[] args)
	{
		if(args.length < 1)
		{
			System.out.println("USAGE : java Exercise4 MERGE_FILENAME FILENAME1 FILNAME2 .....");
			System.exit(0);
		}
		else if(args.length == 1)
		{
			System.out.println("USAGE : java Exercise4 " +args[0]+ " FILENAME1 FILNAME2 .....");
			System.exit(0);
		}
		
		try 
		{
			Vector v = new Vector();
			
			for(int n = 1; n < args.length; n++)
			{
				File f = new File("src/ex4/"+args[n]);
				
				if(f.exists())
				{
					v.add(new FileInputStream(f));	
				}
				else
				{
					System.out.println("존재하지 않는 파일 입니다.");
					System.exit(0);
				}
			}
			
			SequenceInputStream sis = new SequenceInputStream(v.elements());
			FileOutputStream fos = new FileOutputStream("src/ex4/"+args[0]);
			
			int data = 0;
			
			while((data = sis.read()) != -1)
			{
				fos.write(data);
			}
			
			fos.close();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		
	}

}

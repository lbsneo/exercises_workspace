package ex4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

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

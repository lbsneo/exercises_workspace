package ex8;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 *  다음의 코드는 파일로부터 한 줄 씩 데이터를 읽어서 보여주는 프로그램이다. 
 *  버튼을 이용해서 첫 줄, 다음 줄, 이전 줄, 마지막 주로 이동할 수 있으며, 각 줄의 개행문자는
 *  '|'를 사용한다.
 * */
public class Exercise8 extends Frame 
{
	Button first = new Button("<<");
	Button prev = new Button("<");
	Button next = new Button(">");
	Button last = new Button(">>");
	Panel buttons = new Panel();
	TextArea ta = new TextArea();
	ArrayList wordList = new ArrayList();
	
	final String WORD_FILE = "src/ex8/word_data.txt";
	final String CR_LF = System.getProperty("line.separator");
	
	int pos = 0;
	
	public Exercise8(String title) {
		super(title);
		
		buttons.add(first);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);
		add("South", buttons);
		add("Center", ta);
		
		EventHandler handler = new EventHandler();
		this.addWindowListener(handler);
		first.addActionListener(handler);
		prev.addActionListener(handler);
		next.addActionListener(handler);
		last.addActionListener(handler);
		
		loadFile(WORD_FILE);
		
		setBackground(Color.BLACK);
		setSize(300, 200);
		setLocation(200, 200);
		setResizable(true);
		setVisible(true);
		
		showFirst();
	}
	
	void showFirst()
	{
		pos = 0;
		display(pos);
	}
	
	void showPrev()
	{
		pos = (pos > 0) ? --pos : 0;
		display(pos);
	}
	
	void showNext()
	{
		int size = wordList.size();
		pos = (pos < size -1)? ++pos : size-1;
		display(pos);
	}
	
	void showLast()
	{
		pos = wordList.size()-1;
		display(pos);
	}
	
	/* 문제 구현부 */
	void display(int pos)
	{
		String tmp = wordList.get(pos).toString();
		StringBuffer sb = new StringBuffer(tmp.length());
		
		StringTokenizer st = new StringTokenizer(tmp, "|");
		
		while(st.hasMoreTokens())
		{
			sb.append(st.nextToken()).append(CR_LF);
		}
		
		ta.setText(sb.toString());
		
	}
	/*// 문제 구현부 */
	
	/* 문제 구현부 */
	void loadFile(String fileName)
	{
		FileReader fr = null;
		BufferedReader br = null;
		
		try 
		{
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			String line = null;
			
			while((line = br.readLine()) != null)
			{
				wordList.add(line);
			}
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		} 
		finally
		{
			try 
			{
				if(br != null)
					br.close();
			} catch (IOException e) {}
		}
	}
	/*// 문제 구현부 */
	
	public static void main(String[] args) 
	{
		Exercise8 mainWin = new Exercise8("Word Study");
	}
	
	class EventHandler extends WindowAdapter implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent ae) 
		{
			Button b = (Button)ae.getSource();
			
			if(b == first)
			{
				showFirst();
			}
			else if(b ==  prev)
			{
				showPrev();
			}
			else if(b ==  next)
			{
				showNext();
			}
			else if(b ==  last)
			{
				showLast();
			}
		}
		
		@Override
		public void windowClosing(WindowEvent e) 
		{
			System.exit(0);
		}
	}

}

package ex7;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise7 extends Frame 
{
	String nickname = "";
	TextArea ta = new TextArea();
	Panel p = new Panel();
	TextField tf = new TextField();
	Button bSave = new Button("저장");
	
	public Exercise7(String nickname) 
	{
		super("채팅");
		this.nickname = nickname;
		
		setBounds(200, 100, 300, 200);
		
		p.setLayout(new FlowLayout());
		p.add(tf, "Center");
		p.add(bSave, "Center");
		
		add(ta, "Center");
		add(p, "South");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		});
		
		bSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				FileDialog fileSave = new FileDialog(Exercise7.this, "파일저장", FileDialog.SAVE);
				
				fileSave.setVisible(true);
				String fileName = fileSave.getDirectory() + fileSave.getFile();
				
				saveAs(fileName);
			}
		});
		
		EventHandler handler = new EventHandler();
		ta.addFocusListener(handler);
		tf.addFocusListener(handler);
		tf.addActionListener(handler);
		
		ta.setText("#" + nickname + "님 즐거운 채팅 되세요.");
		ta.setEditable(false);
		
		setResizable(false);
		setVisible(true);
		tf.requestFocus();
	}

	/* 문제 구현부 */
	void saveAs(String fileName)
	{
		FileWriter fw = null;
		BufferedWriter bw = null;
		try 
		{
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			
			bw.write(ta.getText());
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		} 
		finally
		{
			try 
			{
				if(bw != null)
					bw.close();
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}
	} // saveAs
	/*// 문제 구현부 */
	
	public static void main(String[] args) 
	{
		if(args.length != 1)
		{
			System.out.println("USAGE : java Exercise7 NICKNAME");
			System.exit(0);
		}
		
		new Exercise7(args[0]);
	}
	
	
	class EventHandler extends FocusAdapter implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String msg = tf.getText();
			if("".equals(msg)) return;
			
			ta.append("\r\n" + nickname + ">" + msg);
			tf.setText("");
		}

		@Override
		public void focusGained(FocusEvent e) 
		{
			tf.requestFocus();
		}
	}
}

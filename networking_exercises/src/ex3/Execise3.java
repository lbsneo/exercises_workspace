package ex3;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/* TextField에 URL을 입력하고 Enter키를 누르면 해당 페이지의 소스를 보여주는
 * 'Source Viwer' 프로그램이다. 예제15-4를 참고해서 (1)에 알맞은 코드를 넣어 완성하시오.
 * 
 * */
public class Execise3 extends Frame{
	
	TextField tf = new TextField();
	TextArea ta = new TextArea();

	public Execise3(String title) {
		super(title);
		
		add(tf, "North");
		add(ta, "Center");
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				displaySource();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		setBounds(500, 200, 500, 300);
		setVisible(true);
	}
	
	void displaySource() {
		URL url = null;
		BufferedReader input = null;
		String address = tf.getText().trim();
		String line = "";
		
		ta.setText("");
		
		try {
			
			if(!address.startsWith("http://"))
				address = "http://" + address;
			
			url = new URL(address);
			
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			StringBuffer sb = new StringBuffer();
			
			while((line = input.readLine()) != null)
				sb.append(line).append("\n");
			
			ta.setText(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
		
	}

	public static void main(String[] args) {
		Execise3 mainWin = new Execise3("Source Viwer");
	}

}

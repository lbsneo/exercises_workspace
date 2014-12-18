package ex4;

import java.awt.BorderLayout;
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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 다음의 코드는 예제 13-39(p.753)과 TCP통신을 하는 예제 15-6, 15-7을 결합하여 GUI채팅프로그램을
 * 작성한 것이다. (1)~(4)에 알맞은 코드를 넣어 프로그램을 완성하시오.
 * 
 * */
public class Execise4Server extends Frame{
	
	String nickname = "";
	
	DataOutputStream out;
	DataInputStream in;
	
	Panel p = new Panel();
	TextArea ta = new TextArea();
	TextField tf = new TextField();
	
	
	
	public Execise4Server(String nickname){
		super("Chatting");
		this.nickname = nickname;
		
		p.setLayout(new BorderLayout());
		p.add(tf, "Center");
		
		add(ta, "Center");
		add(p, "South");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		EventHandler handler = new EventHandler();
		ta.addFocusListener(handler);
		tf.addFocusListener(handler);
		tf.addActionListener(handler);
		
		ta.setEditable(false);
		setBounds(200, 200, 300, 200);
		setVisible(true);
		tf.requestFocus();
		
	}	
	
	void startServer()
	{
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		/* 코드 구현부 */
		try {
			serverSocket = new ServerSocket(7777);
			ta.append("서버가 준비 되었습니다.\n");
			
			socket = serverSocket.accept();
			ta.append("상대방과 연결되었습니다.");
			
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			while(in != null)
			{
				ta.append((in.readUTF()));
			}
		} catch (Exception e) {
			
		}
		/* // 코드 구현부 */
	}
	
	static String getTime()
	{
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("USAGE : java ChatServer NICKNAME");
			System.exit(0);
		}
		
		Execise4Server chatWin = new Execise4Server(args[0]);
		chatWin.startServer();
	}
	
	class EventHandler extends FocusAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			String msg = tf.getText();
			
			if("".equals(msg)) return;
			
			/* 코드 구현부 */
			try {
				out.writeUTF("\r\n" + nickname + ">" + tf.getText());
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*// 코드 구현부 */
			
			ta.append("\r\n" + nickname + ">" + msg);
			tf.setText("");
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			tf.requestFocus();
		}
		
	}

}

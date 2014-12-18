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
import java.net.Socket;

public class Execise4Client extends Frame{
	
	String nickname = "";
	String serverIp = "";
	int serverPort = 0;
	
	DataOutputStream out;
	DataInputStream in;
	
	Panel p = new Panel();
	TextArea ta = new TextArea();
	TextField tf = new TextField();
	
	

	public Execise4Client(String nickname, String serverIp, String serverPort) {
		super("Chatting with " + serverIp + ":" + serverPort);
		this.nickname = nickname;
		this.serverIp = serverIp;
		this.serverPort = Integer.parseInt(serverPort);
		
		setBounds(600, 200, 300, 200);
		
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
		
		setVisible(true);
		tf.requestFocus();
	}

	void startClient() {
		try {
			Socket socket = new Socket(serverIp, serverPort);
			ta.append("상대방과 연결되었습니다.");
			
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			while(in != null)
			{
				ta.append(in.readUTF());
			}
		} catch (Exception e) {
			
		}
	}

	public static void main(String[] args) {
		if(args.length != 3) {
			System.out.println("USAGE : java ChatClient NICKNAME SERVER_IP SERVER_PORT");
			System.exit(0);
		}
		
		Execise4Client chatWin = new Execise4Client(args[0], args[1], args[2]);
		chatWin.startClient();
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

package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import Computer.Easy;
import Data.DataBase;
public class Main implements ActionListener {
	private final int WIDTH=500;
	private final int HEIGHT=300;
	private ImageIcon forfexIcon = new ImageIcon(getClass().getResource("/forfex.png"));
	private ImageIcon stoneIcon = new ImageIcon(getClass().getResource("/stone.png"));
	private ImageIcon clothIcon = new ImageIcon(getClass().getResource("/cloth.png"));
	private JFrame frame = new JFrame();
	private JButton forfex = new JButton();
	private JButton stone = new JButton();
	private JButton cloth = new JButton();
	public JTextArea result = new JTextArea();
	public DataBase data = new DataBase();
	private WinThread winPrint;
	private Main() {
		this.initialComponent();
		this.addListener();
		this.initialFrame();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==forfex) {
			this.player("forfex");
		}else if(e.getSource()==stone) {
			this.player("stone");
		}else if(e.getSource()==cloth) {
			this.player("cloth");
		}
	}
	private void initialComponent() {
		frame.setLayout(null);
		forfex.setIcon(forfexIcon);
		forfex.setBorderPainted(false);
		forfex.setContentAreaFilled(false);
		forfex.setBounds(50, 120, 100, 100);
		frame.add(forfex);
		stone.setIcon(stoneIcon);
		stone.setBorderPainted(false);
		stone.setContentAreaFilled(false);
		stone.setBounds(190, 120, 100, 100);
		frame.add(stone);
		cloth.setIcon(clothIcon);
		cloth.setBorderPainted(false);
		cloth.setContentAreaFilled(false);
		cloth.setBounds(330, 120, 100, 100);
		frame.add(cloth);
		result.setEditable(false);
		result.setBounds(50, 20, 375, 80);
		frame.add(result);
	}
	private void addListener() {
		forfex.addActionListener(this);
		stone.addActionListener(this);
		cloth.addActionListener(this);
	}
	private void initialFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame.setTitle("猜拳游戏");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void player(String player) {
		Easy computer = new Easy(this);
		computer.setcomputer();
		String win;
		win = data.setPlayer(player);
		this.print(win);
	}
	@SuppressWarnings("deprecation")
	private void print(String win) {
		String Print;
		if(win.equals("平局")) {
			Print = win+"！";
		}else{
			Print = win+"赢了！";
		}
		if(!result.getText().toString().equals("")) {
			winPrint.stop();
		}
		winPrint = new WinThread(this,Print);
		winPrint.start();
	}
	public static void main(String[] args) {
		new Main();
	}
}
package VIEW;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import CONTROL.AccountUniversity;
import MODEL.LogIn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JPasswordField password;
	private AccountUniversity ACC=new AccountUniversity();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN frame = new LOGIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LOGIN() {
		setResizable(false);
		setTitle("\u0110\u0102NG NH\u1EACP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel Name = new JLabel("\u0110\u0102NG NH\u1EACP");
		Name.setFont(new Font("Arial", Font.BOLD, 25));
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel user = new JLabel("T\u00EAn truy c\u1EADp (*)");
		user.setFont(new Font("Arial", Font.BOLD, 17));
		
		ID = new JTextField();
		ID.setColumns(10);
		
		JButton LOGIN = new JButton("\u0110\u0102NG NH\u1EACP");
		
		
		JLabel pass = new JLabel("M\u1EADt kh\u1EA9u (*)");
		pass.setFont(new Font("Arial", Font.BOLD, 17));
		
		password = new JPasswordField();
		
		JButton btnngK = new JButton("ĐĂNG KÝ");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(user, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
						.addComponent(pass, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(password)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnngK, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LOGIN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(ID, 204, 204, Short.MAX_VALUE))
					.addGap(124))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(Name, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Name, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(user, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(ID, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(password, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(LOGIN)
								.addComponent(btnngK)))
						.addComponent(pass, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
//event button
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Register rt=new Register();
			}
		});
//đăng nhập
		LOGIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ACC.setAccount(ID.getText());
				ACC.setPassword(password.getText());
				
				LogIn lg=new LogIn();
				if(lg.login(ACC)==true)
				{
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Kiểm tra lại tại khoản,mật khẩu", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				ACC.setAccount(ID.getText());
				ACC.setPassword(password.getText());
				if(evt.getKeyCode()==KeyEvent.VK_ENTER)
				{
				LogIn lg=new LogIn();
				if(lg.login(ACC)==true)
				{
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Kiểm tra lại tại khoản,mật khẩu", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				}
			}
		});

		ID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				ACC.setAccount(ID.getText());
				ACC.setPassword(password.getText());
				if(evt.getKeyCode()==KeyEvent.VK_ENTER)
				{
				LogIn lg=new LogIn();
				if(lg.login(ACC)==true)
				{
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Kiểm tra lại tại khoản,mật khẩu", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				}
			}
		});
}
	
}

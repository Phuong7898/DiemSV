package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;

import CONTROL.AccountUniversity;
import MODEL.InformationStudent;
import MODEL.InformationTeacher;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class Register {

	private JFrame frame;
	private JTextField TaiKhoan;
	private JPasswordField MatKhau;
	private JPasswordField NLMatKhau;
	private int s;
	 
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 831, 273);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0102NG K\u00DD");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 8;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00C0I KHO\u1EA2N");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		TaiKhoan = new JTextField();
		
		GridBagConstraints gbc_TaiKhoan = new GridBagConstraints();
		gbc_TaiKhoan.insets = new Insets(0, 0, 5, 5);
		gbc_TaiKhoan.fill = GridBagConstraints.BOTH;
		gbc_TaiKhoan.gridx = 2;
		gbc_TaiKhoan.gridy = 1;
		frame.getContentPane().add(TaiKhoan, gbc_TaiKhoan);
		TaiKhoan.setColumns(10);
		
		JLabel taikhoanLB = new JLabel("");
		taikhoanLB.setForeground(Color.RED);
		taikhoanLB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_taikhoanLB = new GridBagConstraints();
		gbc_taikhoanLB.gridwidth = 5;
		gbc_taikhoanLB.insets = new Insets(0, 0, 5, 0);
		gbc_taikhoanLB.gridx = 3;
		gbc_taikhoanLB.gridy = 1;
		frame.getContentPane().add(taikhoanLB, gbc_taikhoanLB);
		
		JLabel lblNewLabel_1_1 = new JLabel("M\u1EACT KH\u1EA8U");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		MatKhau = new JPasswordField();
		GridBagConstraints gbc_MatKhau = new GridBagConstraints();
		gbc_MatKhau.insets = new Insets(0, 0, 5, 5);
		gbc_MatKhau.fill = GridBagConstraints.BOTH;
		gbc_MatKhau.gridx = 2;
		gbc_MatKhau.gridy = 2;
		frame.getContentPane().add(MatKhau, gbc_MatKhau);
		
		JLabel MKLB = new JLabel("");
		MKLB.setForeground(Color.RED);
		MKLB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_MKLB = new GridBagConstraints();
		gbc_MKLB.gridwidth = 5;
		gbc_MKLB.insets = new Insets(0, 0, 5, 0);
		gbc_MKLB.gridx = 3;
		gbc_MKLB.gridy = 2;
		frame.getContentPane().add(MKLB, gbc_MKLB);
		
		JLabel lblNewLabel_1_2 = new JLabel("NH\u1EACP L\u1EA0I M\u1EACT KH\u1EA8U");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 3;
		frame.getContentPane().add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		NLMatKhau = new JPasswordField();
		GridBagConstraints gbc_NLMatKhau = new GridBagConstraints();
		gbc_NLMatKhau.insets = new Insets(0, 0, 5, 5);
		gbc_NLMatKhau.fill = GridBagConstraints.BOTH;
		gbc_NLMatKhau.gridx = 2;
		gbc_NLMatKhau.gridy = 3;
		frame.getContentPane().add(NLMatKhau, gbc_NLMatKhau);
		
		JLabel nhaplaiLB = new JLabel("nocap");
		nhaplaiLB.setForeground(Color.RED);
		nhaplaiLB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_nhaplaiLB = new GridBagConstraints();
		gbc_nhaplaiLB.gridwidth = 5;
		gbc_nhaplaiLB.insets = new Insets(0, 0, 5, 0);
		gbc_nhaplaiLB.gridx = 3;
		gbc_nhaplaiLB.gridy = 3;
		frame.getContentPane().add(nhaplaiLB, gbc_nhaplaiLB);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 8;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		frame.getContentPane().add(panel, gbc_panel);
		
		JButton DangKy = new JButton("\u0110\u0102NG K\u00DD");
		DangKy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		panel.add(DangKy);
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LOGIN lg=new LOGIN();
				lg.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(btnCancel);
		frame.setVisible(true);
//event text
		TaiKhoan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				InformationStudent info=new InformationStudent();
				InformationTeacher infoGV=new InformationTeacher();
				if(info.ViewRT(TaiKhoan.getText())||infoGV.ViewRT(TaiKhoan.getText()))
				{	
					if(info.ViewRT(TaiKhoan.getText()))
						s=3;
					else
						if(infoGV.ViewRT(TaiKhoan.getText()))
							s=2;
					taikhoanLB.setText("OK");
					taikhoanLB.setForeground(Color.GREEN);
				}
				else
				{
					taikhoanLB.setText("Fail");
					taikhoanLB.setForeground(Color.RED);
				}
			}
		});
		//mật khẩu
		MatKhau.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						if(MatKhau.getText().length()>=8)
						{
							MKLB.setText("OK");
							MKLB.setForeground(Color.GREEN);
						}
						else
						{
							MKLB.setText("Mật khẩu > 8");
							MKLB.setForeground(Color.RED);
						}
					}
				});
		//nhập lại mk
		NLMatKhau.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						if(MatKhau.getText()!=null)
						{
							if(MatKhau.getText().equals(NLMatKhau.getText()))
							{
									nhaplaiLB.setText("OK");
									nhaplaiLB.setForeground(Color.GREEN);
							}
							else
							{
								nhaplaiLB.setText("Không khớp");
								nhaplaiLB.setForeground(Color.RED);
							}
						}
					}
				});
//event button
	
		DangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InformationStudent info=new InformationStudent();
				InformationTeacher infoGV=new InformationTeacher();
				AccountUniversity SV=new AccountUniversity();
				SV.setAccount(TaiKhoan.getText());
				SV.setPassword(MatKhau.getText());
				if(taikhoanLB.getText().equalsIgnoreCase("OK")&&MKLB.getText().equalsIgnoreCase("OK")&&nhaplaiLB.getText().equalsIgnoreCase("OK"))
				{
					if(s==3)
						info.insertRT(SV);
					else
						if(s==2)
							infoGV.insertRT(SV);
				}
			}
		});
	}

}

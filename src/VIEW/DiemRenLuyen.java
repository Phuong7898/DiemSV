package VIEW;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JYearChooser;

import CONTROL.AcademicTranscript;
import MODEL.InformationTeacher;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DiemRenLuyen extends JPanel {
	private JTable table;
	private JTextField DRL;
	private JTextField masv;
	private JComboBox HK = new JComboBox();
	JYearChooser namhoc = new JYearChooser();
	private DefaultTableModel defaultTable;
	String info;
	int typeSV;
	/**
	 * Create the panel.
	 */
	public DiemRenLuyen(String in,int type) {
		info=in;
		typeSV=type;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton capnhat = new JButton("C\u1EADp nh\u1EADt");
		capnhat.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{38, 131, 149, 129, 148, 185, 0};
		gbl_panel_1.rowHeights = new int[]{69, 34, 34, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 Sinh Vi\u00EAn");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		masv = new JTextField();
		masv.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_masv = new GridBagConstraints();
		gbc_masv.anchor = GridBagConstraints.NORTH;
		gbc_masv.fill = GridBagConstraints.HORIZONTAL;
		gbc_masv.insets = new Insets(0, 0, 5, 5);
		gbc_masv.gridx = 2;
		gbc_masv.gridy = 1;
		panel_1.add(masv, gbc_masv);
		masv.setColumns(10);
		
		JLabel lblNmHc = new JLabel("N\u0103m h\u1ECDc");
		lblNmHc.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNmHc = new GridBagConstraints();
		gbc_lblNmHc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNmHc.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmHc.gridx = 4;
		gbc_lblNmHc.gridy = 1;
		panel_1.add(lblNmHc, gbc_lblNmHc);
		
		
		GridBagConstraints gbc_namhoc = new GridBagConstraints();
		gbc_namhoc.fill = GridBagConstraints.BOTH;
		gbc_namhoc.insets = new Insets(0, 0, 5, 0);
		gbc_namhoc.gridx = 5;
		gbc_namhoc.gridy = 1;
		namhoc.getSpinner().setFont(new Font("Times New Roman", Font.PLAIN, 24));
		namhoc.setValue(2020);
		panel_1.add(namhoc, gbc_namhoc);
		
		JLabel lblHcK = new JLabel("H\u1ECDc k\u1EF3");
		lblHcK.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblHcK = new GridBagConstraints();
		gbc_lblHcK.anchor = GridBagConstraints.WEST;
		gbc_lblHcK.insets = new Insets(0, 0, 0, 5);
		gbc_lblHcK.gridx = 1;
		gbc_lblHcK.gridy = 2;
		panel_1.add(lblHcK, gbc_lblHcK);
		
		
		HK.setModel(new DefaultComboBoxModel(new String[] {"", "HK1", "HK2"}));
		HK.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_HK = new GridBagConstraints();
		gbc_HK.anchor = GridBagConstraints.NORTH;
		gbc_HK.fill = GridBagConstraints.HORIZONTAL;
		gbc_HK.insets = new Insets(0, 0, 0, 5);
		gbc_HK.gridx = 2;
		gbc_HK.gridy = 2;
		panel_1.add(HK, gbc_HK);
		
		JLabel lblimRnLuyn = new JLabel("\u0110i\u1EC3m r\u00E8n luy\u1EC7n");
		lblimRnLuyn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblimRnLuyn = new GridBagConstraints();
		gbc_lblimRnLuyn.anchor = GridBagConstraints.EAST;
		gbc_lblimRnLuyn.insets = new Insets(0, 0, 0, 5);
		gbc_lblimRnLuyn.gridx = 4;
		gbc_lblimRnLuyn.gridy = 2;
		panel_1.add(lblimRnLuyn, gbc_lblimRnLuyn);
		
		DRL = new JTextField();
		DRL.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_DRL = new GridBagConstraints();
		gbc_DRL.anchor = GridBagConstraints.NORTH;
		gbc_DRL.fill = GridBagConstraints.HORIZONTAL;
		gbc_DRL.gridx = 5;
		gbc_DRL.gridy = 2;
		panel_1.add(DRL, gbc_DRL);
		DRL.setColumns(10);
		GridBagConstraints gbc_capnhat = new GridBagConstraints();
		gbc_capnhat.fill = GridBagConstraints.VERTICAL;
		gbc_capnhat.insets = new Insets(0, 0, 5, 0);
		gbc_capnhat.gridx = 0;
		gbc_capnhat.gridy = 1;
		panel.add(capnhat, gbc_capnhat);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
				
		scrollPane.setViewportView(table);
		if(type==1)
		{
		infoDRL();
		}
		else if(type==2)
			infoDRL();
		else if(type==3)
		{
			infoDRLSV();
			panel_1.setEnabled(false);
			panel_1.setVisible(false);
			capnhat.setEnabled(false);
			capnhat.setVisible(false);
		}
//event mouse
		//table
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint()); 
		        int numcols = defaultTable.getColumnCount();
		        for(int i=0;i<numcols;i++)
	            {
	                                if(row<0) {
	                                    break;
	                                }
	                                String str  = (String)defaultTable.getValueAt(row,i);
	                                if(i==0) masv.setText(str);
	                                if(i==2) HK.setSelectedItem(str);
	                                if(i==4) DRL.setText(str);
	                                if(i==5) namhoc.setValue(Integer.parseInt(str));
	            }
			}
		});
//event key
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int row=0;
				if(evt.getKeyCode()==KeyEvent.VK_UP)
				row=table.getSelectedRow()-1 ;
				else
					if(evt.getKeyCode()==KeyEvent.VK_DOWN)
						row=table.getSelectedRow()+1 ;
				if(row<0) row=0;
				if(row>=defaultTable.getRowCount()) row=defaultTable.getRowCount()-1;
				masv.setText((String)defaultTable.getValueAt(row,0));
				HK.setSelectedItem((String)defaultTable.getValueAt(row,2));
				DRL.setText((String)defaultTable.getValueAt(row,4));
				namhoc.setValue(Integer.parseInt((String)defaultTable.getValueAt(row,5)));
			}
		});

//event button
		capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AcademicTranscript SV=new AcademicTranscript();
				InformationTeacher InfoBD=new InformationTeacher();
				SV.setMASV(masv.getText());
				SV.setSemester(HK.getSelectedItem().toString());
				SV.setScholastic(""+namhoc.getValue());
				SV.setDRL(Float.parseFloat(DRL.getText()));
				InfoBD.updateDRL(SV, panel_1);
			}
		});
	}
protected void infoDRL()
{
	 Vector cols = new Vector();
	 Vector data = new Vector();
	 TableRowSorter sorter;
	 TableModel model;
	 cols.addElement("MASV");
     cols.addElement("Họ Tên");
     cols.addElement("Học kì");
     cols.addElement("Mã lớp");
     cols.addElement("Điểm rèn luyện");
     cols.addElement("Năm học");
     
     InformationTeacher InfoBD=new InformationTeacher();
     Iterator<AcademicTranscript> iterator=null;
     if(typeSV==1)
    	 iterator =InfoBD.ViewDRLAll().iterator();
     else if(typeSV==2)
    	 iterator =InfoBD.ViewDRL(info).iterator();
 	while (iterator.hasNext()) {
 		AcademicTranscript infoC=iterator.next();
 		 Vector user = new Vector();
 		 user.addElement(infoC.getMASV());
 		 user.addElement(infoC.getName());
 		 user.addElement(infoC.getSemester());
 		 user.addElement(infoC.getSClass());
 		 user.addElement(""+infoC.getDRL());
 		 user.addElement(infoC.getScholastic());
 		data.add(user);
 	}
 	defaultTable = new DefaultTableModel(data,cols);
 	 defaultTable = new DefaultTableModel(data,cols){
         @Override
         public boolean isCellEditable(int rows, int cols) {
             return false;
         }
     };
    model = defaultTable;
	sorter = new TableRowSorter<>(model);
	table.setModel(model);
	table.setRowSorter(sorter);
}
protected void infoDRLSV()
{
	 Vector cols = new Vector();
	 Vector data = new Vector();
	 TableRowSorter sorter;
	 TableModel model;
     cols.addElement("Học kì");
     cols.addElement("Mã lớp");
     cols.addElement("Điểm rèn luyện");
     cols.addElement("Năm học");
     
     InformationTeacher InfoBD=new InformationTeacher();
     Iterator<AcademicTranscript> iterator =InfoBD.ViewDRLSV(info).iterator();

 	while (iterator.hasNext()) {
 		AcademicTranscript infoC=iterator.next();
 		 Vector user = new Vector();
 		 if(infoC.getMASV().equalsIgnoreCase(info))
 		 {
 		 user.addElement(infoC.getSemester());
 		 user.addElement(infoC.getSClass());
 		 user.addElement(""+infoC.getDRL());
 		 user.addElement(infoC.getScholastic());
 		 data.add(user);
 		 }
 	}
 	defaultTable = new DefaultTableModel(data,cols);
 	 defaultTable = new DefaultTableModel(data,cols){
         @Override
         public boolean isCellEditable(int rows, int cols) {
             return false;
         }
     };
    model = defaultTable;
	sorter = new TableRowSorter<>(model);
	table.setModel(model);
	table.setRowSorter(sorter);
}
}

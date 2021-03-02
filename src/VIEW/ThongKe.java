package VIEW;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JYearChooser;

import CONTROL.AcademicTranscript;
import CONTROL.Information;
import CONTROL.RowFilterUtil;
import MODEL.InformationTeacher;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThongKe extends JPanel {
	private JTable table;
	private DefaultTableModel defaultTable;
	private JComboBox magv = new JComboBox();
	String info;
	int typeSV;
	InformationTeacher InfoBD=new InformationTeacher();
	private List<AcademicTranscript> list=new ArrayList<AcademicTranscript>();
	/**
	 * Create the panel.
	 */
	public ThongKe(String in,int type) {
		
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
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {30, 164, 122, 30, 30, 30, 0, 113};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng k\u00EA");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox TK = new JComboBox();
		
		TK.setModel(new DefaultComboBoxModel(new String[] {"", "Học Bổng", "Học lại"}));
		GridBagConstraints gbc_TK = new GridBagConstraints();
		gbc_TK.insets = new Insets(0, 0, 5, 5);
		gbc_TK.fill = GridBagConstraints.HORIZONTAL;
		gbc_TK.gridx = 2;
		gbc_TK.gridy = 2;
		panel_1.add(TK, gbc_TK);
		
		JLabel lblNmHc = new JLabel("N\u0103m h\u1ECDc");
		lblNmHc.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNmHc = new GridBagConstraints();
		gbc_lblNmHc.anchor = GridBagConstraints.EAST;
		gbc_lblNmHc.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmHc.gridx = 6;
		gbc_lblNmHc.gridy = 2;
		panel_1.add(lblNmHc, gbc_lblNmHc);
		
		JYearChooser namhoc = new JYearChooser();
		GridBagConstraints gbc_namhoc = new GridBagConstraints();
		gbc_namhoc.insets = new Insets(0, 0, 5, 0);
		gbc_namhoc.fill = GridBagConstraints.BOTH;
		gbc_namhoc.gridx = 7;
		gbc_namhoc.gridy = 2;
		panel_1.add(namhoc, gbc_namhoc);
		
		JLabel lblHcK = new JLabel("H\u1ECDc k\u1EF3");
		lblHcK.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblHcK = new GridBagConstraints();
		gbc_lblHcK.anchor = GridBagConstraints.WEST;
		gbc_lblHcK.insets = new Insets(0, 0, 0, 5);
		gbc_lblHcK.gridx = 1;
		gbc_lblHcK.gridy = 3;
		panel_1.add(lblHcK, gbc_lblHcK);
		
		JComboBox HK = new JComboBox();
		
		HK.setModel(new DefaultComboBoxModel(new String[] {"", "HK1", "HK2"}));
		GridBagConstraints gbc_HK = new GridBagConstraints();
		gbc_HK.insets = new Insets(0, 0, 0, 5);
		gbc_HK.fill = GridBagConstraints.HORIZONTAL;
		gbc_HK.gridx = 2;
		gbc_HK.gridy = 3;
		panel_1.add(HK, gbc_HK);
		
		JLabel lblGioVin = new JLabel("Gi\u00E1o vi\u00EAn");
		lblGioVin.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblGioVin = new GridBagConstraints();
		gbc_lblGioVin.anchor = GridBagConstraints.EAST;
		gbc_lblGioVin.insets = new Insets(0, 0, 0, 5);
		gbc_lblGioVin.gridx = 6;
		gbc_lblGioVin.gridy = 3;
		panel_1.add(lblGioVin, gbc_lblGioVin);
		
		
		GridBagConstraints gbc_magv = new GridBagConstraints();
		gbc_magv.fill = GridBagConstraints.HORIZONTAL;
		gbc_magv.gridx = 7;
		gbc_magv.gridy = 3;
		magv.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel_1.add(magv, gbc_magv);
		
		JLabel lblNewLabel_1 = new JLabel("Th\u1ED1ng K\u00EA");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		if(type==1)
			 Giaovien();
		infoTK();
//event combobox
		TK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list!=null)
				{ 
					if(TK.getSelectedItem().toString().equalsIgnoreCase("Học bổng"))
							{
								HB();
							}
					else
					if(TK.getSelectedItem().toString().equalsIgnoreCase("Học lại"))
					{
						HL();
					}
					else
					infoTK();
				}
			}
		});
		//học kỳ
		HK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(HK.getSelectedItem().toString()!=null)
				 {
					 RowFilterUtil.createRowFilter(table,HK.getSelectedItem().toString());
				 }
					 
			}
		});
		magv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(magv.getSelectedItem().toString()!=null)
				 {
					 RowFilterUtil.createRowFilter(table,magv.getSelectedItem().toString());
				 }
					 
			}
		});
	}
	protected void infoTK() {
		 Vector cols = new Vector();
		 Vector data = new Vector();
		 TableRowSorter sorter;
		 TableModel model;
		 cols.addElement("MASV");
	     cols.addElement("Họ Tên");
	     cols.addElement("Học kì");
	     cols.addElement("Magv");
	     cols.addElement("Mã lớp");
	     cols.addElement("ĐTBHK");
	     cols.addElement("Điểm rèn luyện");
	     cols.addElement("Năm học");
	     
	     Iterator<AcademicTranscript> iterator =InfoBD.ViewTK().iterator();
	     list=InfoBD.ViewTK();
	 	while (iterator.hasNext()) {
	 		AcademicTranscript infoC=iterator.next();
	 		if(infoC.getMAGV().equalsIgnoreCase(info)||typeSV==1)
	 		{
	 		 Vector user = new Vector();
	 		 user.addElement(infoC.getMASV());
	 		 user.addElement(infoC.getName());
	 		 user.addElement(infoC.getSemester());
	 		 user.addElement(infoC.getMAGV());
	 		 user.addElement(infoC.getSClass());
	 		 user.addElement(""+infoC.getGPA());
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
	
//học bổng
	protected void HB() {
		 Vector cols = new Vector();
		 Vector data = new Vector();
		 TableRowSorter sorter;
		 TableModel model;
		 cols.addElement("MASV");
	     cols.addElement("Họ Tên");
	     cols.addElement("Học kì");
	     cols.addElement("Magv");
	     cols.addElement("Mã lớp");
	     cols.addElement("ĐTBHK");
	     cols.addElement("Điểm rèn luyện");
	     cols.addElement("Năm học");
	     cols.addElement("Loại học bổng");
	     InformationTeacher InfoBD=new InformationTeacher();
	     Iterator<AcademicTranscript> iterator =InfoBD.ViewTK().iterator();
	     String s="";
	 	while (iterator.hasNext()) {
	 		AcademicTranscript infoC=iterator.next();
	 		if(infoC.getMAGV().equalsIgnoreCase(info)||typeSV==1)
	 		{
	 			if(infoC.getGPA()>=7&&infoC.getDRL()>=80)
	 			{
	 				s="";
	 		 Vector user = new Vector();
	 		 user.addElement(infoC.getMASV());
	 		 user.addElement(infoC.getName());
	 		 user.addElement(infoC.getSemester());
	 		 user.addElement(infoC.getMAGV());
	 		 user.addElement(infoC.getSClass());
	 		 user.addElement(""+infoC.getGPA());
	 		 user.addElement(""+infoC.getDRL());
	 		 user.addElement(infoC.getScholastic());
	 		if(infoC.getGPA()>=7&&infoC.getDRL()>=80)
	 			s="C";
	 		if(infoC.getGPA()>=8&&infoC.getDRL()>=80)
	 			s="B";
	 		if(infoC.getGPA()>=9&&infoC.getDRL()>=90)
	 			s="A";
	 		 user.addElement(s);
	 		 data.add(user);
	 			}
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
//học lại
	protected void HL() {
		 Vector cols = new Vector();
		 Vector data = new Vector();
		 TableRowSorter sorter;
		 TableModel model;
		 cols.addElement("MASV");
	     cols.addElement("Họ Tên");
	     cols.addElement("Học kì");
	     cols.addElement("Magv");
	     cols.addElement("Mã lớp");
	     cols.addElement("ĐTBHK");
	     cols.addElement("Điểm rèn luyện");
	     cols.addElement("Năm học");
	     InformationTeacher InfoBD=new InformationTeacher();
	     Iterator<AcademicTranscript> iterator =InfoBD. ViewHL().iterator();
	 	while (iterator.hasNext()) {
	 		AcademicTranscript infoC=iterator.next();
	 		if(infoC.getMAGV().equalsIgnoreCase(info)||typeSV==1)
	 		{
	 		 Vector user = new Vector();
	 		 user.addElement(infoC.getMASV());
	 		 user.addElement(infoC.getName());
	 		 user.addElement(infoC.getSemester());
	 		 user.addElement(infoC.getMAGV());
	 		 user.addElement(infoC.getSClass());
	 		 user.addElement(""+infoC.getGPA());
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
protected void Giaovien()
{
	List<Information> allGV=new ArrayList<Information>();
	allGV=InfoBD.ViewAll();
	Iterator<Information> iteratorGV =allGV.iterator();
	while (iteratorGV.hasNext()) {
		Information infoC=iteratorGV.next();
		magv.addItem(infoC.getID());
	}
}
}

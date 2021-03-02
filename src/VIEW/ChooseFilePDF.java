package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import CONTROL.PDFTranscript;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ChooseFilePDF extends JFrame {

	private JPanel contentPane;
	JScrollPane PDF = new JScrollPane();
	String info;
	int typeSV;
	public ChooseFilePDF(String in,int Type) {
		info=in;
		typeSV=Type;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 921, 424);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 30, 30, 30, 30, 0};
		gbl_contentPane.rowHeights = new int[] {42, 30, 30, 30, 30, 30, 30, 30, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton Save = new JButton("Save");
		panel_1.add(Save);
		Save.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		JButton Open = new JButton("Open");
		Open.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_1.add(Open);
		
		JLabel Path = new JLabel("");
		Path.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(Path);
		
		
		GridBagConstraints gbc_PDF = new GridBagConstraints();
		gbc_PDF.gridheight = 7;
		gbc_PDF.gridwidth = 5;
		gbc_PDF.insets = new Insets(0, 0, 5, 5);
		gbc_PDF.fill = GridBagConstraints.BOTH;
		gbc_PDF.gridx = 0;
		gbc_PDF.gridy = 1;
		contentPane.add(PDF, gbc_PDF);
		Open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
				  FileFilter filter = new FileNameExtensionFilter("PDF File","pdf");
				        j.setFileFilter(filter);
				        j.addChoosableFileFilter(filter);
				            // set the selection mode to directories only 
				            // invoke the showsOpenDialog function to show the save dialog 
				            int r = j.showOpenDialog(null); 
				  
				            if (r == JFileChooser.APPROVE_OPTION) { 
				                // set the label to the path of the selected directory 
				                Path.setText(j.getSelectedFile().getAbsolutePath()); 
				                 openpdf(Path.getText());
				            } 
				            // if the user cancelled the operation 
				            else
				                Path.setText("the user cancelled the operation");
			}
		});
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 // TODO add your handling code here:
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
				FileFilter filter = new FileNameExtensionFilter("PDF Document(*.pdf)","pdf");
				
				j.setFileFilter(filter);
				j.addChoosableFileFilter(filter);
		            // set the selection mode to directories only 
		            j.setFileSelectionMode(JFileChooser.APPROVE_OPTION); 
		            
		            // invoke the showsSaveDialog function to show the save dialog 
		            int r = j.showSaveDialog(null); 
		  
		            if (r == JFileChooser.APPROVE_OPTION) { 
		                // set the label to the path of the selected directory 
		            	 Path.setText(j.getSelectedFile().getAbsolutePath()); 
		                if(!j.getSelectedFile().getAbsolutePath().endsWith(".pdf") ) {
		                	 Path.setText(j.getSelectedFile().getAbsolutePath()+".pdf"); 
		                	 PDFTranscript pdf= new PDFTranscript();
		                	 if(typeSV==2)
		                	 { pdf.importPDFSV(info,Path.getText(),typeSV);
		                	 }
		                	 else
		                		 if(typeSV==1)
		                			 pdf.importPDFGV(Path.getText(), typeSV);
							 openpdf(Path.getText());
		                }
		                else
		                {
		                PDFTranscript pdf= new PDFTranscript();
		                if(info!=null)
	                		 pdf.importPDFSV(info,Path.getText(),typeSV);
	                	 else
	                		 if(info==null&&typeSV==1)
	                			 pdf.importPDFGV(Path.getText(), typeSV);
						 openpdf(Path.getText());
		                }
		            } 
		            // if the user cancelled the operation 
		            else
		                Path.setText("the user cancelled the operation"); 
			}
		});
	}
	void openpdf(String file){
		  
	    try {
	           SwingController control=new SwingController();
	            SwingViewBuilder factry=new SwingViewBuilder(control);
	            JPanel veiwerCompntpnl=factry.buildViewerPanel();
	            ComponentKeyBinding.install(control, veiwerCompntpnl);
	            control.getDocumentViewController().setAnnotationCallback(
	                    new org.icepdf.ri.common.MyAnnotationCallback(
	                    control.getDocumentViewController()));
	                   control.openDocument(file);
	        PDF.setViewportView(veiwerCompntpnl); 
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this,"Cannot Load Pdf");
	        }
	}

}

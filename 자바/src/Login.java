import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login extends JFrame{
	//������ ������ ���� �迭�� ����
	static int[] dsnum = new int[100];
	static int[] deno = new int[100];
	static String[] dename = new String[100];
	static String[] dpassword = new String[100];
	static String[] dposition = new String[100];
	static String[] dhiredate = new String[100];
	static String[] dhp = new String[100];
	static String[] deMail = new String[100];
	static String[] did = new String[100];
	static String[] daddress = new String[100];
	static String[] dsalary = new String[100];
	static String[] devaluation = new String[100];
	static int[] dmanager = new int[100];
	static int[] ddno = new int[100];
	static int[] dtno = new int[100];
	
	//ó�� ������ snum�� �����ϱ� ���� int
    static int numB = 0;
	
    //�μ� ��ȣ�� �� ��ȣ�� �̸��� ��������
	static String[] ddname = new String[100];
	static String[] dtname = new String[100];
	//�̸� ����صδ� ����
	static String gName;
	//���� ȭ������ ��� ȭ������ �����صα�
	static int emp;
	
	private JPanel contentPane;
	private JTextField tFid;
	private JPasswordField tFpassword;
	private JLabel labelid;
	private JLabel labelpassword;
	private JButton btntest;
	private JButton btntest_1;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setSize(250,200);
		setContentPane(contentPane);
		
		//���̵� ��й�ȣ �� �ʵ�
		labelid = new JLabel("��� �̸�");
		labelid.setBounds(16, 37, 52, 15);
		contentPane.add(labelid);
		labelpassword = new JLabel("��й�ȣ");
		labelpassword.setBounds(16, 82, 52, 15);
		contentPane.add(labelpassword);
		//���̵� ��й�ȣ �ؽ�Ʈ �ʵ�
		tFid = new JTextField();
		tFid.setBounds(80, 27, 129, 35);
		tFid.setColumns(10);
		contentPane.add(tFid);		
		tFpassword = new JPasswordField();
		tFpassword.setBounds(80, 72, 129, 35);
		contentPane.add(tFpassword);
		
		//�α��� ��ư
		JButton btnid = new JButton("�α���");	
		btnid.setBounds(80, 127, 95, 23);
		contentPane.add(btnid);
		
		//�����ͺ��̽� ����
		DataBase.dbConnect();
		try {
        	for(int i = 1; i <= 41; i++) {
        		DataBase.select("select", "employee", "snum", i); //���̺���� employee�� �͵� ��ȣ ������ ���ʴ�� ���
			while(DataBase.rs.next()) { 	//������ ������ �����ϱ� ���� ������ �ݺ���
				dsnum[i] = DataBase.rs.getInt("snum");		//�迭�� �����͵��� ����
				deno[i] = DataBase.rs.getInt("eno");
				dename[i] = DataBase.rs.getString("ename");
				dposition[i] = DataBase.rs.getString("position");
				dhiredate[i] = DataBase.rs.getString("hiredate");
				dhp[i] = DataBase.rs.getString("hp");
				deMail[i] = DataBase.rs.getString("eMail");
				did[i] = DataBase.rs.getString("id");
				daddress[i] = DataBase.rs.getString("address");
				dsalary[i] = DataBase.rs.getString("salary");
				devaluation[i] = DataBase.rs.getString("evaluation");
				dmanager[i] = DataBase.rs.getInt("manager");
				dpassword[i] = DataBase.rs.getString("password");
				ddno[i] = DataBase.rs.getInt("dno");
				dtno[i] = DataBase.rs.getInt("tno");
				//�μ� ��ȣ�� ���� �μ� �̸� ����
				if(ddno[i] == 1100) {
					ddname[i] = "�λ��";
				} else if(ddno[i] == 2100 ) {
					ddname[i] = "��ȹ��";
				} else if(ddno[i] == 3100) {
					ddname[i] = "������";
				}
				//�� ��ȣ�� ���� �� �̸� ����
				if(dtno[i] % 3 == 1) {
					dtname[i] = "1��";
				} else if(dtno[i] % 3 == 2){
					dtname[i] = "2��";
				} else if(dtno[i] % 3 == 0) {
					dtname[i] = "3��";
				} else if(dtno[i] == 0) {
					dtname[i] = "";
				}
			}
        }
		} catch (SQLException e1) {	//���� ���н� ���
			System.out.println("���� ����!");
		}


		  
		//�α��� ��ư �׼� ������
		btnid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//id�� pw�� �о������ ����
	            String id;
	            id = tFid.getText();
	            String pw;
	            pw = tFpassword.getText();	
	    
					for(int i = 2; i <= 40; i++) {
		            	 if(id.equals(dename[1]) && pw.equals(dpassword[1])) {			//���� �α���
								emp = 0;	//���� ȭ���� ���� ���� int
								JOptionPane.showMessageDialog(contentPane, "���� �α��� �Ϸ�!");
									new Mainp().setVisible(true);						//���� ȭ�� �̵�
									setVisible(false);
					            	i += 100;
		            	 }
		            	 else if(id.equals(dename[i]) && pw.equals(dpassword[i])) {	//���� �α���	���߿� �����ͺ��̽� ���ͼ� if������ �����鼭 �̸� Ȯ���ϱ�. 
				            	JOptionPane.showMessageDialog(contentPane, "ȸ�� �α��� �Ϸ�!");
			            	emp = 1;
			            	numB = dsnum[i];
			            	new Maine().setVisible(true);
			            	setVisible(false);
			            	i += 100;
			             } 
//		            	 else if(!id.equals(dename[i]) || !pw.equals(dpassword[i])){	
//			            	 String data = "�����: " + tFid.getText();			//����� ��й�ȣ Ʋ���� �������
//			                 data += ", ��й�ȣ: " + new String(tFpassword.getPassword());
//			                 JOptionPane.showMessageDialog(contentPane, data + "\n �ٽ��Է��ϼ���!");
//			             	}
					}
	            }
		});

	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


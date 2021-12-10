import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;

public class ProjectEd extends JFrame {

	private JPanel contentPane;
	
	Login login = new Login();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectEd frame = new ProjectEd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProjectEd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel labelDno_1 = new JLabel("���� ������Ʈ");
		labelDno_1.setFont(new Font("����", Font.PLAIN, 40));
		labelDno_1.setBounds(25, 20, 382, 64);
		contentPane.add(labelDno_1);
		
		JButton btnSelect = new JButton("����");
		btnSelect.setBounds(642, 10, 68, 31);
		contentPane.add(btnSelect);
		
		JButton btnHome = new JButton("Ȩ");
		btnHome.setBounds(722, 10, 52, 31);
		contentPane.add(btnHome);
		
		JLabel labelDno = new JLabel("�λ��(1��) :");
		labelDno.setBounds(12, 104, 219, 53);
		contentPane.add(labelDno);
		labelDno.setFont(new Font("����", Font.PLAIN, 35));
		
		JButton btnCon = new JButton("2001�⵵ ���� ����");
		btnCon.setBounds(233, 109, 398, 51);
		contentPane.add(btnCon);
		btnCon.setFont(new Font("����", Font.PLAIN, 20));
		
		
		JLabel labelpercent = new JLabel(" ��� ");
		labelpercent.setBounds(643, 109, 107, 47);
		contentPane.add(labelpercent);
		labelpercent.setFont(new Font("����", Font.PLAIN, 40));
		
		JLabel labelDno_2 = new JLabel("�λ��(2��) :");
		labelDno_2.setFont(new Font("����", Font.PLAIN, 35));
		labelDno_2.setBounds(12, 184, 219, 53);
		contentPane.add(labelDno_2);
		
		JButton btnCon_1 = new JButton("2002�⵵ ���� ��");
		btnCon_1.setFont(new Font("����", Font.PLAIN, 20));
		btnCon_1.setBounds(233, 189, 398, 51);
		contentPane.add(btnCon_1);
		
		JLabel labelpercent_1 = new JLabel(" ��� ");
		labelpercent_1.setFont(new Font("����", Font.PLAIN, 40));
		labelpercent_1.setBounds(643, 189, 107, 47);
		contentPane.add(labelpercent_1);
		
		JLabel labelDno_2_1 = new JLabel("�λ��(2��) :");
		labelDno_2_1.setFont(new Font("����", Font.PLAIN, 35));
		labelDno_2_1.setBounds(12, 269, 219, 53);
		contentPane.add(labelDno_2_1);
		
		JButton btnCon_1_1 = new JButton("2004�⵵ ���� ��");
		btnCon_1_1.setFont(new Font("����", Font.PLAIN, 20));
		btnCon_1_1.setBounds(233, 274, 398, 51);
		contentPane.add(btnCon_1_1);
		
		JLabel labelpercent_1_1 = new JLabel(" �Ϸ� ");
		labelpercent_1_1.setFont(new Font("����", Font.PLAIN, 40));
		labelpercent_1_1.setBounds(643, 274, 107, 47);
		contentPane.add(labelpercent_1_1);
		
		JLabel labelDno_2_2 = new JLabel("�λ��(3��) :");
		labelDno_2_2.setFont(new Font("����", Font.PLAIN, 35));
		labelDno_2_2.setBounds(12, 350, 219, 53);
		contentPane.add(labelDno_2_2);
		
		JButton btnCon_1_2 = new JButton("2006�⵵ ���� ����");
		btnCon_1_2.setFont(new Font("����", Font.PLAIN, 20));
		btnCon_1_2.setBounds(233, 355, 398, 51);
		contentPane.add(btnCon_1_2);
		
		JLabel labelpercent_1_2 = new JLabel(" �Ϸ� ");
		labelpercent_1_2.setFont(new Font("����", Font.PLAIN, 40));
		labelpercent_1_2.setBounds(643, 355, 107, 47);
		contentPane.add(labelpercent_1_2);
		
		
		JLabel labelDno_2_3 = new JLabel("��ȹ��(1��) :");
		labelDno_2_3.setFont(new Font("����", Font.PLAIN, 35));
		labelDno_2_3.setBounds(12, 434, 219, 53);
		contentPane.add(labelDno_2_3);
		
		JButton btnCon_1_3 = new JButton("2006�� ���� ���� ������ ��ȹ��");
		btnCon_1_3.setFont(new Font("����", Font.PLAIN, 20));
		btnCon_1_3.setBounds(233, 439, 398, 51);
		contentPane.add(btnCon_1_3);
		
		JLabel labelpercent_1_3 = new JLabel(" �Ϸ� ");
		labelpercent_1_3.setFont(new Font("����", Font.PLAIN, 40));
		labelpercent_1_3.setBounds(643, 439, 107, 47);
		contentPane.add(labelpercent_1_3);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(757, 94, 17, 404);
		contentPane.add(scrollBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 94, 762, 404);
		contentPane.add(scrollPane);
		
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(login.emp == 0) {
					new Mainp().setVisible(true);
				} else {
					new Maine().setVisible(true);
				}
				setVisible(false);
			}
		});
		
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProjectSelect().setVisible(true);
				setVisible(false);
			}
		});
		
		btnCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProjectCon().setVisible(true);
			}
		});
		
		btnCon_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProjectCon().setVisible(true);
			}
		});
		
		btnCon_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProjectCon().setVisible(true);
			}
		});
		
		btnCon_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProjectCon().setVisible(true);
			}
		});
		
		btnCon_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProjectCon().setVisible(true);
			}
		});
		

	}
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

public class DataBase {
	

	static String driver, url;
	static Connection conn;
	static Statement stmt, pstmt;
	static ResultSet rs;
	static String tmpstr;
	static long count = 0;
	static int b = 0;
	static int set;
	
	//�����ͺ��̽� ����
	public static void dbConnect() {
    	driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("����̹� �˻� ����!");        
    	}catch(ClassNotFoundException e){
    		System.err.println("error = " + e);
    	}
    	
        url = "jdbc:odbc:company";		//�����ͺ��̽� �̸�
        conn = null;
        stmt = null;
        rs = null;
        String url = "jdbc:mysql://localhost/company?useUnicode=yes&characterEncoding=UTF8";
        String sql1 = "Select * From employee";
        //���̺� 4�� ������
        
		try {
            conn = DriverManager.getConnection(url,"root","apmsetup");	//���̵�� �н������ ����
            stmt = conn.createStatement( );		//���ఴü �����
            rs = stmt.executeQuery(sql1);		//customer���̺��� ��� ��ü ã�ƿ���.
            System.out.println("�����ͺ��̽� ���� ����!");            
        }
        catch(Exception e) {
            System.out.println("�����ͺ��̽� ���� ����!");
        }
	}

	//���� order�� sql	
	//select�� �����ؼ� ����ϵ��� �ϱ�
	static void select(String order, String table, String filed, int num) throws SQLException{	
		if(order == "select") {
			String test1 = "select * from ";  
			String test2 = " where ";
			String test3 = " = ";
			rs = stmt.executeQuery(test1 + table + test2 + filed + test3 + num);
			if(table == "employee") {
				b = 1;
			} else if (table == "department") {
				b = 2;
			} else if (table == "team") {
				b = 3;
			} else {
				b = 4;
			}
		}
	}

	//��Ŀ��Ʈ ���� �����ϱ�
	static void dbDis(){
		try {
			if (conn != null)	//conn��ü�� null�� �ƴϸ�
				conn.close();	//conn �����
			if (stmt != null)	//���ఴü�� null�� �ƴϸ�
				stmt.close();	//���ఴü �����
			System.out.println("�����ͺ��̽� ���� ����!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public static void main(String[] args) throws SQLException  {
		dbConnect();
		if(b == 1) {	//table�� ���� ��� ����
			set = 15;
		} else if (b == 2) {
			set = 4;
		} else if (b == 3) {
			set = 5;
		} else if (b == 4) {
			set = 6;
		}
		//���� table�� / �˻�
		select("select", "employee", "snum", 3);
		if(rs.next()) {
			for(int i = 1; i <= set; i++) {
				System.out.printf("  ");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		
		dbDis();
	}
}

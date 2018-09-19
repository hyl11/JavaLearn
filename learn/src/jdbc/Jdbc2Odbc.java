package jdbc;
/*��ʾjdbc-odbc�����ķ�ʽ�������ݿ�Testbase2
 * ��� emp dept 
 * 1,��������Դ  ������� -> ������ -> odbc64λ����Դ ->�û�DNS(���)
 *   ->ѡ�����ݿ�sql server -> ��������������-> ��һ��ѡ���û�����id�����¼
 *   ->ѡ����Ĭ�����ݿ�ΪTestBase2
 * 2,�ڳ�������������Դ
 * */

import java.sql.*;
public class Jdbc2Odbc {

	public Jdbc2Odbc() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection ct = null;
		Statement sm = null;
		try {
			//1,��������,����Ҫ�� ���������ڴ�
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//2,�õ�����,���ӵ����ݿ�,��jdbc���洴�������ӵ�����
			//�����������Դѡ��windows nt��֤��ʽ������Ҫ�û���������
			ct = DriverManager.getConnection("jdbc:odbc:javaTest","sa","7");
			//3,����statement,����PreparedStatement,��Ҫ��������sql���,�ʹ����ݿ�
			//���ߵ�����ֱ��ʹ��statement�����sql����飬
			//ʹ��prepare��Ԥ���룬���Σ���ַ����ʺ���������
			sm = ct.createStatement();
			//4,ִ��(crud)
		    //(1),���һ�����ݵ�dept��,excuteupdate����ִ�г������
			
			int i = sm.executeUpdate("insert into dept values(40,'tec','hangzhou')");
			if(i == 1)
				System.out.println("insert success!");
			else System.out.println("error");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//�ر�˳�򣬺ʹ�˳���෴
				if(sm != null)
				    sm.close();
				if(ct!=null)
				    ct.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}

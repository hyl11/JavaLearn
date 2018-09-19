package jdbc;
/*
 * jdbcֱ�Ӳ������ݿ�
 * 
 * */
import java.sql.*;
public class jdbc1 {
	static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String connectAddr=
    		"jdbc:sqlserver://127.0.0.1:1433;databaseName=Testbase2";
	public static void main(String[] args) {
		//������Ҫ�Ķ���
		PreparedStatement pst=null;
		Connection ct=null;
		ResultSet rs=null;
		try {
			//��ʼ������
			//1,��������
			Class.forName(driverName);
			//2,��������
			ct=DriverManager.getConnection(connectAddr,"sa","7");
			pst=ct.prepareStatement("select empno,ename,sal from emp");
			//��ɾ��ʹ��update,��ѯ,ʹ��query
			rs=pst.executeQuery();
			while(rs.next()) {
				//����������������λ���ݣ�Ҳ���������е��±�����λ
				System.out.println(rs.getString("ename") + " " + rs.getInt("empno"));
				System.out.println(rs.getInt(1) + " "+ rs.getString(2) + " " + rs.getInt(3));
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			// TODO: handle finally clause
			try {
				if(pst!=null)
				    pst.close();
				if(ct!=null)
				    ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}

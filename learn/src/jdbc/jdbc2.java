package jdbc;
import java.sql.*;
/*
 * java����ddl��䣬������ɾ���Ȳ���
 * */
public class jdbc2 {

	static String connectAddr="jdbc:sqlserver://localhost:1433;databaseName=master";
	static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String order="create database test3";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection ct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			//��������
			Class.forName(driverName);
			ct=DriverManager.getConnection(connectAddr,"sa","7");
			pst=ct.prepareStatement(order);
			pst.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ct!=null)
					ct.close();
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}

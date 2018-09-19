package jdbc;
/*
 * jdbc直接操作数据库
 * 
 * */
import java.sql.*;
public class jdbc1 {
	static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String connectAddr=
    		"jdbc:sqlserver://127.0.0.1:1433;databaseName=Testbase2";
	public static void main(String[] args) {
		//定义需要的对象
		PreparedStatement pst=null;
		Connection ct=null;
		ResultSet rs=null;
		try {
			//初始化对象
			//1,加载驱动
			Class.forName(driverName);
			//2,创建连接
			ct=DriverManager.getConnection(connectAddr,"sa","7");
			pst=ct.prepareStatement("select empno,ename,sal from emp");
			//增删，使用update,查询,使用query
			rs=pst.executeQuery();
			while(rs.next()) {
				//可以适用列名来定位数据，也可以适用列的下标来定位
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

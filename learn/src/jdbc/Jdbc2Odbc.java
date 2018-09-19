package jdbc;
/*演示jdbc-odbc桥连的方式操作数据库Testbase2
 * 表格 emp dept 
 * 1,配置数据源  控制面板 -> 管理工具 -> odbc64位数据源 ->用户DNS(添加)
 *   ->选择数据库sql server -> 服务器输入名称-> 下一步选择用户输入id密码登录
 *   ->选择工作默认数据库为TestBase2
 * 2,在程序中连接数据源
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
			//1,加载驱动,把需要的 驱动加入内存
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//2,得到连接,连接到数据库,在jdbc里面创建的连接的名称
			//如果配置数据源选择windows nt验证方式，则不需要用户名和密码
			ct = DriverManager.getConnection("jdbc:odbc:javaTest","sa","7");
			//3,创建statement,或者PreparedStatement,主要用来发送sql语句,送达数据库
			//二者的区别，直接使用statement不会对sql语句检查，
			//使用prepare会预编译，检查危险字符，适合批量操作
			sm = ct.createStatement();
			//4,执行(crud)
		    //(1),添加一条数据到dept表,excuteupdate可以执行常用语句
			
			int i = sm.executeUpdate("insert into dept values(40,'tec','hangzhou')");
			if(i == 1)
				System.out.println("insert success!");
			else System.out.println("error");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//关闭顺序，和打开顺序相反
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

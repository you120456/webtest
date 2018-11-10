package com.sys.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 获取连接的类
 * 
 * @author 张金友
 * 
 */
public class DBUtils {
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://192.168.1.212:3306/system?characterEncoding=UTF-8";
	private static String USER = "root";
	private static String PASSWORD = "zhangjinyou";


	static {
		init();
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("未找到驱动文件");
		}
	}
	
	
	private static void init() {

		  DRIVER = "com.mysql.jdbc.Driver";
		  URL = "jdbc:mysql://192.168.1.212:3306/system?characterEncoding=UTF-8";
		  USER = "root";
		  PASSWORD = "zhangjinyou";
		// Properties 继承自Hashtable值都是字符串
/*
		Properties prop = new Properties();
		// 输入加载JDBC配置文件
		InputStream in = DBUtils.class.getClassLoader()
				.getResourceAsStream("com/sys/utils/db.properties");
		try {
			prop.load(in);
			// 读取配置文件数据并赋
			DRIVER = prop.getProperty("DRIVER");
			URL = prop.getProperty("URL");
			USER = prop.getProperty("USER");
			PASSWORD = prop.getProperty("PASSWORD");

			System.out.println("===="+DRIVER+URL+USER+PASSWORD +"====");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("加载属性文件失败");
		} finally {
			try {
				// 关闭数据
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}

	public static Connection getConnection() {
		
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取连接失败");
		}
		return conn;

	}

	/**
	 * 用于添加数据，修改数据，删除数据
	 * @param sql
	 * @param params
	 * @return
	 */
	public static boolean saveOrUpdate(String sql, Object[] params) {
		Connection con = null;
		PreparedStatement pre = null;

		try {

			con = getConnection();
			pre = con.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					pre.setObject(i + 1, params[i]);
				}

			}

			int i = pre.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pre.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return false;
	}

	/**
	 * 关闭资源
	 * @param con
	 * @param pre
	 */
	public static void close(Connection con, PreparedStatement pre) {

		try {
			pre.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 关闭资源
	 * @param con
	 * @param pre
	 */
	public static void close(Connection con, PreparedStatement pre,ResultSet res) {

		try {
			res.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			pre.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

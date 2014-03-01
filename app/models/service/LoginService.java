package models.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import play.Logger;
import models.utils.DBUtils;

public class LoginService {
	public static final String LOGIN_TABLE = "user";
	
	public static boolean verifyLogin(String userName, String password)
	{
		boolean isLoginSuccess = true;

		String loginSql = "SELECT username, password FROM " + LOGIN_TABLE + " WHERE username = ? AND password = ?";
		Connection dbConn = DBUtils.getDBConnection();		
		PreparedStatement preparedSql;
		try {
			preparedSql = dbConn.prepareStatement(loginSql);
			preparedSql.setString(1, userName);
			preparedSql.setString(2, password);

			ResultSet rs = preparedSql.executeQuery();
			if(!rs.next()) {
				isLoginSuccess = false;
			}
		} catch (SQLException e) {
			isLoginSuccess = false;
			Logger.error("Failed to login the user : " + userName);
			e.printStackTrace();
		}

		return isLoginSuccess;		
	}
}

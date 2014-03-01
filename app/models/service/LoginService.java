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
		PreparedStatement preparedSql = null;
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

		DBUtils.cleanDBResources(dbConn, preparedSql);
		return isLoginSuccess;		
	}
	
	public static boolean createLogin(String loginName, String loginPassword)
	{
		boolean doesLoginAlreadyExist = doesLoginAlreadyExist(loginName);
		if(doesLoginAlreadyExist) {
			return false;
		}

		Connection dbConn = DBUtils.getDBConnection();	
		boolean isAccountCreationDone = true;
		String loginSql = "INSERT INTO " + "user" + " (user_id, username, password, address1, address2, city, state, zip) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
		PreparedStatement preparedSql = null;
		try {
			preparedSql = dbConn.prepareStatement(loginSql);
			
			int id = 1 + (int)(Math.random() * ((1000 - 1) + 1));			
			preparedSql.setInt(1, id);
			preparedSql.setString(2, loginName);
			preparedSql.setString(3, loginPassword);
			preparedSql.setString(4, "2110 university Avenue");
			preparedSql.setString(5, "Apt 104");
			preparedSql.setString(6, "Madison");
			preparedSql.setString(7, "WI");
			preparedSql.setString(8, "53726");			
			preparedSql.executeUpdate();
		} catch (SQLException e) {
			isAccountCreationDone = false;
			Logger.error("Failed to create account for user : " + loginName);
			e.printStackTrace();
		}

		DBUtils.cleanDBResources(dbConn, preparedSql);
		return isAccountCreationDone;
	}	
	
	public static boolean doesLoginAlreadyExist(String loginName)
	{
		boolean doesLoginAlreadyExist = false;

		Connection dbConn = DBUtils.getDBConnection();	
		String validLoginSql = "SELECT username FROM " + "user" + " WHERE username = ?";
		PreparedStatement preparedSql = null;
		try {
			preparedSql = dbConn.prepareStatement(validLoginSql);
			preparedSql.setString(1, loginName);

			// If an existing login name matches with the provided login name, then it is not valid.
			// This is because login names have to be unique.
			ResultSet rs = preparedSql.executeQuery();

			if(rs.next()) {
				doesLoginAlreadyExist = true;
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}

		DBUtils.cleanDBResources(dbConn, preparedSql);
		return doesLoginAlreadyExist;
	}	
}

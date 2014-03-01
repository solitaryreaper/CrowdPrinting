package models.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import play.Logger;
import models.Job;
import models.utils.DBUtils;

public class JobService {
	
	public static Job getJobById(int jobId)
	{
		Connection dbConn = DBUtils.getDBConnection();

		String sql = "SELECT id, material, color, quantity FROM job_new WHERE id = ?";
		PreparedStatement preparedSql = null;
		Job job = null;
		try {
			preparedSql = dbConn.prepareStatement(sql);
			preparedSql.setInt(1, jobId);
			ResultSet results = preparedSql.executeQuery();
			while(results.next()) {
				job = new Job(results.getInt("id"), results.getString("material"), results.getString("color"), results.getInt("quantity"));
			}
		} catch (SQLException e) {
			Logger.error("Failed to fetch top N trends ..");
			e.printStackTrace();
		}

		DBUtils.cleanDBResources(dbConn, preparedSql);
		return job;
	}
	
	public static int insertJob(String email, String material, String color, String filePath, int quantity)
	{
		int jobId = 1 + (int)(Math.random() * ((1000 - 1) + 1));
		
		Connection dbConn = DBUtils.getDBConnection();
		String sql = "INSERT INTO " + "job_new" + "(id, user, material, color, model_file_path, quantity) VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement preparedSql = null;
		try {
			preparedSql = dbConn.prepareStatement(sql);
			preparedSql.setInt(1, jobId);
			preparedSql.setString(2, email);
			preparedSql.setString(3, material);
			preparedSql.setString(4, color);
			preparedSql.setString(5, filePath);
			preparedSql.setInt(6, quantity);			

			preparedSql.executeUpdate();
		} catch (SQLException e) {
			Logger.error("Failed to fetch top N trends ..");
			e.printStackTrace();
		}

		DBUtils.cleanDBResources(dbConn, preparedSql);
		
		return jobId;
	}
}

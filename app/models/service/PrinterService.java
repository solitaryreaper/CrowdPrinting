package models.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Job;
import models.Printer;
import models.Printer.PrintQuality;
import models.utils.DBUtils;
import play.Logger;

public class PrinterService
{
	public static ArrayList<Integer> getPrinterIDsByUserID(int userID)
	{
		ArrayList<Integer> printerIDs = new ArrayList<Integer>();
		
		Connection dbConn = DBUtils.getDBConnection();
		String sql = "SELECT printer_id FROM printer_new WHERE user_id = ?";
		PreparedStatement preparedSql = null;
		try
		{
			preparedSql = dbConn.prepareStatement(sql);
			preparedSql.setInt(1, userID);
			ResultSet results = preparedSql.executeQuery();
			while (results.next())
			{
				int printerID = results.getInt("printer_id");
				printerIDs.add(printerID);
			}
		} catch (SQLException e)
		{
			Logger.error("Failed to fetch top N trends ..");
			e.printStackTrace();
		}
		
		DBUtils.cleanDBResources(dbConn, preparedSql);
		
		return printerIDs;
	}

	public static ArrayList<Printer> getPrinters(String username)
	{
		ArrayList<Printer> printers = new ArrayList<Printer>();
		
		int userID = LoginService.getUserIDfromUsername(username);
		ArrayList<Integer> printerIDs = getPrinterIDsByUserID(userID);
		
		for(Integer printerID : printerIDs)
		{
			Connection dbConn = DBUtils.getDBConnection();
			String sql = "SELECT printer_id, model_name, quantity, max_b, max_w, max_h FROM printer_new WHERE printer_id = ?";
			PreparedStatement preparedSql = null;
			try
			{
				preparedSql = dbConn.prepareStatement(sql);
				preparedSql.setInt(1, printerID);
				ResultSet results = preparedSql.executeQuery();
				if (results.next())
				{
					Printer printer = new Printer(results.getInt("printer_id"), results.getString("model"), 0, 
												  results.getDouble("max_b"), results.getDouble("max_w"),results.getDouble("max_h"),
												  results.getDouble("resolution"));
					
					Logger.info("PRINTER FOUND: " + printer.getId() + " " + printer.getModel())
					;
					printers.add(printer);
				}
			} catch (SQLException e)
			{
				Logger.error("Failed to fetch top N trends ..");
				e.printStackTrace();
			}
			
			DBUtils.cleanDBResources(dbConn, preparedSql);
		}
		
		return printers;
	}

	public static void insertPrinter(String username, String model, Double max_b, Double max_w, Double max_h,
			Double resolution)
	{
		int printerID = 1 + (int)(Math.random() * ((1000 - 1) + 1));
		
		Connection dbConn = DBUtils.getDBConnection();
		String sql = "INSERT INTO "
				+ "printer_new"
				+ "(printer_id, model_name, quality, max_b, max_w, max_h, resolution) VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement preparedSql = null;
		try
		{
			preparedSql = dbConn.prepareStatement(sql);
			preparedSql.setInt(1, printerID);
			preparedSql.setString(2, model);
			preparedSql.setDouble(3, 3.0);
			preparedSql.setDouble(4, max_b);
			preparedSql.setDouble(5, max_w);
			preparedSql.setDouble(6, max_h);
			preparedSql.setDouble(7, resolution);

			preparedSql.executeUpdate();
			
			Logger.info("Printer successfulle inserted");
		} 
		catch (SQLException e)
		{
			Logger.error("Failed to fetch top N trends ..");
			e.printStackTrace();
		}

		DBUtils.cleanDBResources(dbConn, preparedSql);
		
		updateProvider(username, printerID);
	}
	
	public static boolean updateProvider(String username, int printerID)
	{
		int userID = LoginService.getUserIDfromUsername(username);
		
		Connection dbConn = DBUtils.getDBConnection();
		String sql = "INSERT INTO "
				+ "provider"
				+ "(user_id, printer_id, price, printer_rating) VALUES (?, ?, ?, ?)";

		PreparedStatement preparedSql = null;
		try
		{
			preparedSql = dbConn.prepareStatement(sql);
			preparedSql.setInt(1, userID);
			preparedSql.setInt(2, printerID);
			preparedSql.setDouble(3, 4.56);
			preparedSql.setDouble(4, 3.5);

			preparedSql.executeUpdate();
		} 
		catch (SQLException e)
		{
			Logger.error("Failed to fetch top N trends ..");
			e.printStackTrace();
		}

		DBUtils.cleanDBResources(dbConn, preparedSql);
		return true;
	}
}

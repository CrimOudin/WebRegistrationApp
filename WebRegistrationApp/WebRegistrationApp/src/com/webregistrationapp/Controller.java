package com.webregistrationapp;
import java.util.List;

public class Controller
{
	public static List<UserInfo> getDatabaseInfo()
	{
		MySQLAccess dba = new MySQLAccess();
		try 
		{
			return dba.readDataBase();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	public static void submitDatabaseInfo(UserInfo userInfo)
	{
		MySQLAccess dba = new MySQLAccess();
		try 
		{
			dba.submitUserInfo(userInfo);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

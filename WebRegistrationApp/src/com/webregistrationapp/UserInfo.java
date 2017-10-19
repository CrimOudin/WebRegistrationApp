package com.webregistrationapp;

public class UserInfo 
{
	String firstName;
	String lastName;
	String address1;
	String address2;
	String city;
	String state;
	String zip;
	String country;
	String date;
	
	//Constructor
	public UserInfo(String firstName, String lastName, String address1, String address2, 
			String city, String state, String zip, String country, String date)
	{
		this.firstName = firstName;
		this.lastName = lastName; 
		this.address1 = address1; 
		this.address2 = address2; 
		this.city = city;     
		this.state = state;    
		this.zip = zip;      
		this.country = country;  
		this.date = date;     
	}

	public String validate() 
	{//returns null if valid otherwise returns parameter that it failed at.
		if(firstName == null || firstName.toCharArray().length > 45 || firstName == "")
		{
			return "firstName";
		}
		if(lastName == null || lastName.toCharArray().length > 45 || lastName == "")
		{
			return "lastName";
		}
		if(address1 == null || address1.toCharArray().length > 100 || address1 == "")
		{
			return "address1";
		}
		if(address2.toCharArray().length > 100)
		{
			return "address2";
		}
		if(city == null || city.toCharArray().length > 60 || city == "")
		{
			return "city";
		}
		if(state == null || state.toCharArray().length > 2 || state == "")
		{
			return "state";
		}
		if(zip == null || zip.toCharArray().length > 10 || zip == "" || !zip.matches("[0-9]+"))
		{
			return "zip";
		}
		if(country == null || country.toCharArray().length > 55 || country == "")
		{
			return "country";
		}
		
		return null;
		
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getAddress1()
	{
		return address1;
	}
	public String getAddress2()
	{
		return address2;
	}
	public String getCity()
	{
		return city;
	}
	public String getState()
	{
		return state;
	}
	public String getZip()
	{
		return zip;
	}
	public String getCountry()
	{
		return country;
	}
	public String getDate()
	{
		return date;
	}

}

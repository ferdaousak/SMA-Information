package DAO;

import java.util.ArrayList;
import java.util.List;

public class Information {
	private int id;
	private String brand;
	private String model;
	private String type;
	private int year;
	private String engine_type;
	
	
	
	
	public Information(String brand, String model,String type)
	{
		super();
		this.brand = brand;
		this.model = model;
		this.type = type;
	}
	public Information(String brand, String model, String type, int year, String engine_type) {
		super();
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.year = year;
		this.engine_type = engine_type;
	}
	
	public Information(int id, String brand,String model,int year,String type,String engine_type)
	{
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.year = year;
		this.engine_type = engine_type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getEngine_type() {
		return engine_type;
	}
	public void setEngine_type(String engine_type) {
		this.engine_type = engine_type;
	}

	@Override
	public String toString() {
		return brand+":"+model+":"+type+":"+year+":"+engine_type;
	}
	
	public static String ListToString(List<Information> infos)
	{
		if(infos == null || infos.isEmpty())
			return null;
		String message ="";
		for(Information f: infos)
		{
			message += f.toString();
			
			message += ";";
		}
		
		return message;
	}
	public static List<Information> StringToList(String infos)
	{
		List<Information> info = new ArrayList<Information>();
		
		for(String row: infos.split(";"))
		{
			String[] columns = row.split(":");
			Information n = new Information(columns[0],columns[1],columns[2],Integer.parseInt(columns[3]),columns[4]);
			info.add(n);
		}
		
		return info;
	}
	
	
}

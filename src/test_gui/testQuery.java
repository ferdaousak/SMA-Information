package test_gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.Information;
import DAO.MySqlManager;

public class testQuery
{
	static java.sql.Connection cnx;

	static java.sql.PreparedStatement stmt;
	static ResultSet res; 
	public static void main(String[] args)
	{	
		List<Information> infos = new ArrayList<Information>();
		try
		{
			try {
				cnx = MySqlManager.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String query = "SELECT * FROM cars"
					+ " WHERE `brand` LIKE ?"
					+ " AND `type` LIKE ?;";
			
			stmt = cnx.prepareStatement(query);
			stmt.setString(1, "dacia");
			stmt.setString(2, "manual");
			
			res = stmt.executeQuery();
			
			while(res.next())
			{
				Information info =  new Information(
						res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getInt(4),
						res.getString(5),
						res.getString(6));
			
				infos.add(info);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		String message = Information.ListToString(infos);
		
		System.out.println("infos : "+message);
		
		List<Information> infos2 = Information.StringToList(message);
		
		System.out.println("-- infos 2 --");
		for(Information f : infos2)
			System.out.println("info2 : " + f);
		
	}

}

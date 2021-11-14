package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.Query;
import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.SQLException;

public class InformationDAO {

	java.sql.Connection cnx;

	java.sql.PreparedStatement stmt;
	ResultSet res;

	public InformationDAO() throws ClassNotFoundException, SQLException {
		cnx = MySqlManager.getConnection();
	}

	public List<Information> FindInformationByNom(String Brand, String Type)
	{
		String query = "SELECT * FROM cars"
				+ " WHERE (`brand` LIKE ? OR `model` LIKE ?)"
				+ " AND `type` LIKE ?;";
		
		try
		{
			stmt = cnx.prepareStatement(query);
			stmt.setString(1, Brand.toLowerCase());
			stmt.setString(2, Brand.toLowerCase());
			stmt.setString(3, Type.toLowerCase());
			
			List<Information> infos = new ArrayList<Information>();
			res = stmt.executeQuery();
			while (res.next())
			{
				Information info =  new Information(
						res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getInt(4),
						res.getString(5),
						res.getString(6));
				System.out.println("DAO info : " + info);

				infos.add(info);
				
				//return List<>
			}
			System.out.println("Informations List :" + infos);
			if(infos.isEmpty())
				return null;
			return infos;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}

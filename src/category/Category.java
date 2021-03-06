package category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import connection.ConnectionDB;

public class Category {


	ConnectionDB link;

	PreparedStatement state = null;
    ResultSet set = null;


	public Category() {

        link = new ConnectionDB();
        state = link.GetState();


	}

	public ResultSet get_categories()
	{
		try
	    {
	        state = (link.GetCon()).prepareStatement(
	        		"SELECT * "+
	        		"FROM ted.category"
	        		);
	        set = state.executeQuery();
	    }
	    catch(SQLException ex)
	    {
	    	ex.printStackTrace();
	    }

		return set;
	}

	public ResultSet get_item_categories(long item_id)
	{
		try
	    {
	        state = (link.GetCon()).prepareStatement(
	        		"SELECT * "+
	        		"FROM ted.item_category "
	        		+ "WHERE item_id=?"
	        		);
	        state.setLong(1, item_id);
	        set = state.executeQuery();
	    }
	    catch(SQLException ex)
	    {
	    	ex.printStackTrace();
	    }

		return set;
	}

	public ResultSet get_categories(long item_id)
	{
		try
	    {
			state = (link.GetCon()).prepareStatement(
	        		"SELECT value "+
	        		"FROM ted.category c, ted.item_category i "
	        		+ "WHERE c.category_id=i.category_id AND i.item_id=?"
	        		);
	        state.setLong(1, item_id);
	        set = state.executeQuery();
	    }
	    catch(SQLException ex)
	    {
	    	ex.printStackTrace();
	    }

		return set;
	}

	public ResultSet get_categories_id(String category)
	{
		try
	    {
	        state = (link.GetCon()).prepareStatement(
	        		"SELECT category_id "+
	        		"FROM ted.category "+
	        		"WHERE value=?"
	        		);
	        state.setString(1, category);
	        set = state.executeQuery();
	    }
	    catch(SQLException ex)
	    {
	    	ex.printStackTrace();
	    }

		return set;
	}

}

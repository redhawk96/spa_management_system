package spa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Package {

	private String sql;
	private PreparedStatement ps;

	public int addPackage(String client_id, String spa_category, String spa_package, double price) throws SQLException, ClassNotFoundException {

		if (Connect.getInstance() != null) {

			Connection con = Connect.getConnction();

			sql = "INSERT INTO `spa`(`client_id`, `spa_category`, `spa_package`, `price`) VALUES (?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, client_id);
			ps.setString(2, spa_category);
			ps.setString(3, spa_package);
			ps.setDouble(4, price);

			int query = ps.executeUpdate();

			return query;
		}

		return 0;
	}

	
	public static ResultSet displayPackage(String client_id, String spa_category) throws ClassNotFoundException, SQLException {

		if (Connect.getInstance() != null) {

			Connection con = Connect.getConnction();
			Statement st = con.createStatement();

			String sql = "SELECT `package_id`, `spa_package`, `price` FROM `spa` WHERE `client_id` = '"+client_id+"' AND `spa_category` = '"+spa_category+"'";
			ResultSet query = st.executeQuery(sql);

			return query;
		}

		return null;

	}
	
	
	public int removePackage(String package_id) throws SQLException, ClassNotFoundException {
		
		
		if (Connect.getInstance() != null) {

            Connection con = Connect.getConnction();

            sql = "DELETE FROM `spa` WHERE `package_id` = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, package_id);
            
            int query = ps.executeUpdate();

            return query;
        }
		
        return 0;
	}
}

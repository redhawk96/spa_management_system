package spa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authenticate {

	private String username;
	private String password;
	private ResultSet rs = null;

	public Authenticate(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean validateAdmin() throws ClassNotFoundException, SQLException {

		if (Connect.getInstance() != null) {

			Connection con = Connect.getConnction();
			Statement st = con.createStatement();

			String query = "SELECT COUNT(*) FROM admin WHERE email = '" + username + "' AND password = '" + password+ "'";
			rs = st.executeQuery(query);
			int Countrow = 0;
			while (rs.next()) {
				Countrow = rs.getInt(1);
			}

			if (Countrow == 1) {
				return true;
			} else
				return false;
		}

		return false;

	}

	public ResultSet getAdmin() throws ClassNotFoundException, SQLException {

		if (Connect.getInstance() != null) {

			Connection con = Connect.getConnction();
			Statement st = con.createStatement();

			String query = "SELECT username, email FROM admin WHERE email = '" + username + "' AND password = '"+ password + "'";
			rs = st.executeQuery(query);
		}

		return rs;
	}

}

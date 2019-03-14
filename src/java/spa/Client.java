package spa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {
	
	private String sql;
	private PreparedStatement ps;
	
	
	public int addClient(String first_name, String last_name, String nic, String contact_number, String email, String spa_name, String spa_address, String spa_contact, String spa_image, String user_name, String password ) throws SQLException, ClassNotFoundException {
		
		
		if (Connect.getInstance() != null) {

            Connection con = Connect.getConnction();

            sql = "INSERT INTO `spa_clients`(`username`, `first_name`, `last_name`, `nic`, `contact_no`, `email`, `spa_name`, `spa_address`, `spa_contact`, `spa_image`, `password`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2, first_name);
            ps.setString(3, last_name);
            ps.setString(4, nic);
            ps.setString(5, contact_number);
            ps.setString(6, email);
            ps.setString(7, spa_name);
            ps.setString(8, spa_address);
            ps.setString(9, spa_contact);
            ps.setString(10, spa_image);
            ps.setString(11, password);
            
            int query = ps.executeUpdate();

            return query;

        }
		
        return 0;
	}
	
	
	public static ResultSet displayAllClients() throws ClassNotFoundException, SQLException {
		
		if (Connect.getInstance() != null) {

            Connection con = Connect.getConnction();
            Statement st = con.createStatement();

            String sql = "SELECT `client_id`, `first_name`, `last_name`, `spa_name`, `spa_address`, `spa_contact` FROM client_info";
            ResultSet query = st.executeQuery(sql);

            return query;
        }
		
		return null;
		
	}
	
	
	public ResultSet displayClient(String client_id) throws ClassNotFoundException, SQLException {
		
		if (Connect.getInstance() != null) {

            Connection con = Connect.getConnction();
            Statement st = con.createStatement();

            String sql = "SELECT `client_id`, `first_name`, `last_name`, `nic`, `contact_no`,`email`, `spa_name`, `spa_address`, `spa_contact`, `spa_image` FROM client_info WHERE `client_id` = "+client_id;
            ResultSet query = st.executeQuery(sql);

            return query;
        }
		
		return null;
		
	}
	
	
	public int removeClient(String client_id) throws SQLException, ClassNotFoundException {
		
		
		if (Connect.getInstance() != null) {

            Connection con = Connect.getConnction();

            sql = "DELETE FROM `spa_clients` WHERE `client_id` = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, client_id);
            
            int query = ps.executeUpdate();

            return query;
        }
		
        return 0;
	}

}

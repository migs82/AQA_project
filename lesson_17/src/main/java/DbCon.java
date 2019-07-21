import java.sql.*;

public class DbCon {
    private String url = "jdbc:mysql://localhost:3306/aqa-home?useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "root";
    public ResultSet executeSql(String query) throws SQLException {
            Connection con = DriverManager.getConnection( url, user, password );
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery( query );
    return rs;
    }
}

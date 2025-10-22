import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException; // Import for better exception handling

public class JavaApplication2 {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null; // Declare ResultSet outside try for proper closing

        try {
            // 1. Register the JDBC Driver (PostgreSQL in this case)
            Class.forName("org.postgresql.Driver");

            // 2. Open a connection
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/emp", "postgres", "Periyar");
            c.setAutoCommit(false); // Disable auto-commit
            System.out.println("Open Database Connection Successfully");

            // 3. Execute a query
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * FROM emp_detail;");

            // 4. Process the result set
            while (rs.next()) {
                int id = rs.getInt("eid");
                String name = rs.getString("ename");
                int age = rs.getInt("eage");
                String address = rs.getString("eaddress");
                float salary = rs.getFloat("esalary");

                System.out.println("ID=" + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE=" + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
                System.out.println();
            }

            // 5. Close resources
            rs.close();
            stmt.close();
            c.close();

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        } finally {
            // Ensure resources are closed even if an exception occurs (best practice)
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (c != null) c.close();
            } catch (SQLException ex) {
                System.err.println("Error closing resources: " + ex.getMessage());
            }
        }

        System.out.println("Operation Done Successfully");
    }
}
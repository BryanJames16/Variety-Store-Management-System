/*
 * Copyright (C) 2015 Group #
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package JavaConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * DBConnection Class
 * @author Group #
 */
public class DBConnection {
    
    Connection connection               =   null;
    private final String connectionName =   "localhost";
    private final String databaseName   =   "sales_inventory";
    private final String username       =   "root";
    private final String password       =   "admin";
    
    public Connection getConnection () {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql://" + connectionName + "/" + databaseName + "?user=" + username + "&password=" + password);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException alle) {
		String report = "Error in database!\nCan't start application!\n" + alle;
                System.err.println (report);
                JOptionPane.showMessageDialog (null, report, "E R R O R", javax.swing.JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        return (connection);
    } // getConnection()
    
    public void closeConnection() throws SQLException {
        connection.close();
    } // closeConnection()
    
} // Class DBConnection

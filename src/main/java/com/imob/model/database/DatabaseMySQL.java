package com.imob.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public abstract class DatabaseMySQL implements Database{

    Connection connection;

    @Override
    public Connection conectar()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_imob","root","");
            return connection;

        }
        catch(SQLException | ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco MySql: " + ex);
            return null;
        }
    }
}

package handling;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.LoginClass;

public class DBConnection {

    static Connection ORACLECONN = null;
    static Connection MYSQLCONN = null;

    private DBConnection() {
    }

    public static Connection getOracleConnection(String login, String password) {
        try {
            if (ORACLECONN == null) {
                Properties prop = new Properties();
                URL url = ClassLoader.getSystemResource("data/config.properties");

                prop.load(url.openStream());
                String databaseData = prop.getProperty("dataOracleDB");

                ORACLECONN = DriverManager.getConnection("jdbc:oracle:thin:@" + databaseData, login, password);
                System.out.println("Connected to Oracle database");

                prop.setProperty("loginOracleDB", login);
                prop.setProperty("passwordOracleDB", password);
            }

        } catch (SQLException exc) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, exc);
            String state = exc.getSQLState();
            System.out.println(state);

            if (state.equals("72000")) {
                JOptionPane.showMessageDialog(null, "Wrong login or password!", "Error", JOptionPane.ERROR_MESSAGE);

                java.awt.EventQueue.invokeLater(() -> {
                    new LoginClass().setVisible(true);
                });

            } else {
                JOptionPane.showMessageDialog(null, "Error when connecting to Oracle database;\nCheck your internet connection!", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

        } catch (IOException ex) {
            System.out.println("Error when reading Oracle data from config.properties");
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }

        return ORACLECONN;
    }

    public static Connection resetOracleConnection() {
        return ORACLECONN = null;
    }

    public static Connection getMysqlConnection() {
        try {
            if (MYSQLCONN == null) {
                Properties prop = new Properties();
                URL url = ClassLoader.getSystemResource("data/config.properties");

                prop.load(url.openStream());

                String login = prop.getProperty("loginMysqlDB");
                String password = prop.getProperty("passwordMysqlDB");
                String databaseData = prop.getProperty("dataMysqlDB");

                MYSQLCONN = DriverManager.getConnection("jdbc:mysql://" + databaseData + "?useTimezone=true&serverTimezone=UTC", login, password);
                System.out.println("Connected to MySql database");
            }

        } catch (SQLException exc) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, exc);
            JOptionPane.showMessageDialog(null, "Error when connecting to MySQL database;\nCheck your internet connection!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Error when reading Mysql data from config.properties");
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }

        return MYSQLCONN;
    }

}

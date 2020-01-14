package handling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import net.proteanit.sql.DbUtils;

public class SelectingRunnable implements Runnable {

    Connection CONNECTION = null;
    Statement statement;
    ResultSet result;

    JTable table;
    JProgressBar progressBar;
    JButton commitButton;
    String query, name;

    public SelectingRunnable(Connection conn, Statement stat, JTable table, JProgressBar progressBar, JButton commitButton, String name, String query) {
        this.CONNECTION = conn;
        this.statement = stat;
        this.table = table;
        this.progressBar = progressBar;
        this.commitButton = commitButton;
        this.query = query;
        this.name = name;
    }

    @Override
    public void run() {
        if (query.equals("") == false) {
            try {
                if (CONNECTION.isValid(0) == false) {
                    JOptionPane.showMessageDialog(null, "Lost connection to the server;\nProgram will be closed", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SelectingRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (CONNECTION != null) {
                System.out.println(name + " thread starts");

                SwingUtilities.invokeLater(() -> {
                    commitButton.setEnabled(false);
                    progressBar.setIndeterminate(true);
                });

                try {
                    result = statement.executeQuery(query);

                    SwingUtilities.invokeLater(() -> {
                        table.setModel(DbUtils.resultSetToTableModel(result));
                        commitButton.setEnabled(true);
                        progressBar.setIndeterminate(false);
                    });

                } catch (SQLException ex) {
                    Logger.getLogger(SelectingRunnable.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "There's an error in your query;\nDO NOT USE \" ; \" at the end of query!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Query can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}

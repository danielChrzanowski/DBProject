package view;

import data.User;
import handling.DBConnection;
import handling.SelectingRunnable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class EmployeeView extends javax.swing.JFrame {

    static Connection ORACLECONN;
    static Statement oracleStatement;

    static Connection MYSQLCONN;
    static Statement mysqlStatement;

    ResultSet result;
    SelectingRunnable oracleRunnable, mysqlRunnable;

    User user;

    public EmployeeView() {
        initComponents();
        user = User.getUser();

        Properties prop = new Properties();
        URL url = ClassLoader.getSystemResource("data/config.properties");

        try {
            prop.load(url.openStream());
        } catch (IOException ex) {
            Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
        }
        String login = prop.getProperty("loginOracleDB");
        String password = prop.getProperty("passwordOracleDB");

        ORACLECONN = DBConnection.getOracleConnection(login, password);
        MYSQLCONN = DBConnection.getMysqlConnection();
        System.out.println();

        try {
            oracleStatement = ORACLECONN.createStatement();
            mysqlStatement = MYSQLCONN.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
        }

        usedTable.setText(user.databaseName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oraclePopup = new javax.swing.JPopupMenu();
        oraclePopupEdit = new javax.swing.JMenuItem();
        oraclePopupAdd = new javax.swing.JMenuItem();
        scrollMysql = new javax.swing.JScrollPane();
        mysqlTable = new javax.swing.JTable();
        scrollOracle = new javax.swing.JScrollPane();
        oracleTable = new javax.swing.JTable();
        oracleNameText = new javax.swing.JLabel();
        mysqlNameText = new javax.swing.JLabel();
        mysqlProgressBar = new javax.swing.JProgressBar();
        oracleComboBox = new javax.swing.JComboBox<>();
        oracleProgressBar = new javax.swing.JProgressBar();
        oracleSelectText = new javax.swing.JLabel();
        separator = new javax.swing.JSeparator();
        oracleCommitButton = new javax.swing.JButton();
        mysqlSelectText = new javax.swing.JLabel();
        mysqlCommitButton = new javax.swing.JButton();
        mysqlComboBox = new javax.swing.JComboBox<>();
        usedTable = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        showUserInfo = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        infoMenu = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenuItem();

        oraclePopupEdit.setText("  Edit employee");
        oraclePopupEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oraclePopupEditActionPerformed(evt);
            }
        });
        oraclePopup.add(oraclePopupEdit);

        oraclePopupAdd.setText("  Add Employee");
        oraclePopupAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oraclePopupAddActionPerformed(evt);
            }
        });
        oraclePopup.add(oraclePopupAdd);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DBProject");
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        mysqlTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollMysql.setViewportView(mysqlTable);

        oracleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        oracleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                oracleTableMouseReleased(evt);
            }
        });
        scrollOracle.setViewportView(oracleTable);

        oracleNameText.setText("Oracle:");

        mysqlNameText.setText("MySQL:");

        oracleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all employees", "name, job_id, dep, salary, grade", "name, job_id (SA_REP, ST_CLERK), salary (not: 2500, 3500)", "emp, job_id INTERSECT job_history" }));

        oracleSelectText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        oracleSelectText.setText("Select:");

        oracleCommitButton.setText("Commit");
        oracleCommitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oracleCommitButtonActionPerformed(evt);
            }
        });

        mysqlSelectText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mysqlSelectText.setText("Select:");

        mysqlCommitButton.setText("Commit");
        mysqlCommitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mysqlCommitButtonActionPerformed(evt);
            }
        });

        mysqlComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all employees", "all products" }));

        usedTable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        menuFile.setText("File");

        showUserInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/person.png"))); // NOI18N
        showUserInfo.setText("Show user info");
        showUserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUserInfoActionPerformed(evt);
            }
        });
        menuFile.add(showUserInfo);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/exit.png"))); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        menuFile.add(exit);

        menuBar.add(menuFile);

        menuHelp.setText("Help");

        infoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/i.png"))); // NOI18N
        infoMenu.setText("Info");
        infoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoMenuActionPerformed(evt);
            }
        });
        menuHelp.add(infoMenu);

        aboutMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/h.png"))); // NOI18N
        aboutMenu.setText("About");
        aboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuActionPerformed(evt);
            }
        });
        menuHelp.add(aboutMenu);

        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oracleSelectText)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(oracleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(oracleCommitButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(oracleNameText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oracleProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(usedTable, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollOracle, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mysqlSelectText)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mysqlComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mysqlCommitButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollMysql, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mysqlNameText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mysqlProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(separator))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oracleSelectText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(oracleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oracleCommitButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(oracleNameText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(oracleProgressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usedTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollOracle, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mysqlProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mysqlNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollMysql, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mysqlSelectText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mysqlCommitButton)
                            .addComponent(mysqlComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void oracleCommitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oracleCommitButtonActionPerformed
        int comboBoxIndex = oracleComboBox.getSelectedIndex();

        if (oracleCommitButton.isEnabled()) {
            String query = null;

            switch (comboBoxIndex) {
                case 0:
                    query = getOracleComboBoxQuery(0);
                    break;
                case 1:
                    query = getOracleComboBoxQuery(1);
                    break;

                case 2:
                    query = getOracleComboBoxQuery(2);
                    break;

                case 3:
                    query = getOracleComboBoxQuery(3);
                    break;
            }

            oracleRunnable = new SelectingRunnable(ORACLECONN, oracleStatement, oracleTable, oracleProgressBar, oracleCommitButton, "Oracle", query);
            Thread oracleThread = new Thread(oracleRunnable);
            oracleThread.start();
        }

    }//GEN-LAST:event_oracleCommitButtonActionPerformed

    private String getOracleComboBoxQuery(int oracleComboBoxIndex) {
        switch (oracleComboBoxIndex) {
            case 0:
                return "select * from " + user.databaseName + ".employees order by employee_id";

            case 1:
                return "select e.last_name, e.job_id, d.department_name, e.salary,"
                        + " j.grade_level from " + user.databaseName + ".employees e\n"
                        + "join " + user.databaseName + ".departments d on e.department_id=d.department_id join " + user.databaseName + ".job_grades j\n"
                        + "on salary between j.lowest_sal and j.highest_sal order by e.last_name";

            case 2:
                return "select last_name, job_id, salary from " + user.databaseName
                        + ".employees where (job_id='SA_REP' or job_id='ST_CLERK') and (salary<>2500 and salary<>3500) order by last_name";

            case 3:
                return "select employee_id, job_id from " + user.databaseName
                        + ".employees INTERSECT\n select employee_id, job_id from " + user.databaseName + ".job_history order by employee_id";
        }
        return null;
    }

    private String getMysqlComboBoxQuery(int mysqlComboBoxIndex) {
        switch (mysqlComboBoxIndex) {
            case 0:
                return "select * from pracownicy";

            case 1:
                return "select * from produkty";

        }
        return null;
    }

    private void showUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUserInfoActionPerformed
        JOptionPane.showMessageDialog(null, "Login: " + user.login + "\nDatabase: " + user.databaseName, "UserInfo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_showUserInfoActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void infoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoMenuActionPerformed
        JOptionPane.showMessageDialog(null, "Program connects to:\n"
                + "    - MySQL database (every time the same)\n"
                + "    - Oracle database indicated by user\n"
                + "    \n"
                + "    It uses multithreading to manage two databases \"at the same time\"", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoMenuActionPerformed

    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuActionPerformed
        JOptionPane.showMessageDialog(null, "Screen is divided into two parts.\nTop part uses Oracle database and bottom part uses MySQL database\nThey can work at the same time", "About", JOptionPane.QUESTION_MESSAGE);
    }//GEN-LAST:event_aboutMenuActionPerformed

    private void mysqlCommitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mysqlCommitButtonActionPerformed
        int comboBoxIndex = mysqlComboBox.getSelectedIndex();

        if (mysqlCommitButton.isEnabled()) {
            String query = null;

            switch (comboBoxIndex) {
                case 0:
                    query = getMysqlComboBoxQuery(0);
                    break;
                case 1:
                    query = getMysqlComboBoxQuery(1);
                    break;
            }

            mysqlRunnable = new SelectingRunnable(MYSQLCONN, mysqlStatement, mysqlTable, mysqlProgressBar, mysqlCommitButton, "MySQL", query);
            Thread mysqlThread = new Thread(mysqlRunnable);
            mysqlThread.start();

        }
    }//GEN-LAST:event_mysqlCommitButtonActionPerformed

    private void oracleTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oracleTableMouseReleased
        if (evt.isPopupTrigger()) {
            int verticalScrollValue = scrollOracle.getVerticalScrollBar().getValue();
            oraclePopup.show(this, evt.getX() + 482, evt.getY() - verticalScrollValue + 109);
        }
    }//GEN-LAST:event_oracleTableMouseReleased

    private void oraclePopupEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oraclePopupEditActionPerformed
        SwingUtilities.invokeLater(() -> {
            new EditEmployee().setVisible(true);
        });
    }//GEN-LAST:event_oraclePopupEditActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (evt.isPopupTrigger()) {
            oraclePopup.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_formMouseReleased

    private void oraclePopupAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oraclePopupAddActionPerformed
        SwingUtilities.invokeLater(() -> {
            new AddEmployee().setVisible(true);
        });
    }//GEN-LAST:event_oraclePopupAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenuItem infoMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JComboBox<String> mysqlComboBox;
    private javax.swing.JButton mysqlCommitButton;
    private javax.swing.JLabel mysqlNameText;
    private javax.swing.JProgressBar mysqlProgressBar;
    private javax.swing.JLabel mysqlSelectText;
    public javax.swing.JTable mysqlTable;
    private javax.swing.JComboBox<String> oracleComboBox;
    private javax.swing.JButton oracleCommitButton;
    private javax.swing.JLabel oracleNameText;
    private javax.swing.JPopupMenu oraclePopup;
    private javax.swing.JMenuItem oraclePopupAdd;
    private javax.swing.JMenuItem oraclePopupEdit;
    private javax.swing.JProgressBar oracleProgressBar;
    private javax.swing.JLabel oracleSelectText;
    public javax.swing.JTable oracleTable;
    private javax.swing.JScrollPane scrollMysql;
    private javax.swing.JScrollPane scrollOracle;
    private javax.swing.JSeparator separator;
    private javax.swing.JMenuItem showUserInfo;
    private javax.swing.JLabel usedTable;
    // End of variables declaration//GEN-END:variables
}

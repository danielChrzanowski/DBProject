package view;

import handling.DBConnection;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static view.LoginClass.ORACLECONN;

public class CreateUser extends javax.swing.JFrame {

    public CreateUser() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginText = new java.awt.Label();
        passwordText = new java.awt.Label();
        createUserText = new java.awt.Label();
        loginInput = new javax.swing.JTextField();
        passwordInput = new javax.swing.JPasswordField();
        createUserButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        repeatPasswordInput = new javax.swing.JPasswordField();
        powtorzHaslo = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DBProject");
        setResizable(false);

        loginText.setText("login:");

        passwordText.setText("password:");

        createUserText.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        createUserText.setText("Create user");

        loginInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginInputKeyPressed(evt);
            }
        });

        passwordInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordInputKeyPressed(evt);
            }
        });

        createUserButton.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        createUserButton.setText("Create");
        createUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserButtonActionPerformed(evt);
            }
        });
        createUserButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                createUserButtonKeyPressed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        backButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backButtonKeyPressed(evt);
            }
        });

        repeatPasswordInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                repeatPasswordInputKeyPressed(evt);
            }
        });

        powtorzHaslo.setText("repeat password:");

        jLabel1.setText("(User will be able to deal with ZIIBD6 database)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(createUserText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createUserButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(powtorzHaslo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(passwordText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginInput)
                                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(repeatPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createUserText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginInput, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(loginText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(passwordInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(powtorzHaslo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(repeatPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createUserButton)
                    .addComponent(backButton))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("Magazyn - dodaj pracownika");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginInputKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            passwordInput.requestFocusInWindow();
        }
    }//GEN-LAST:event_loginInputKeyPressed

    private void passwordInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordInputKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            repeatPasswordInput.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            loginInput.requestFocusInWindow();
        }
    }//GEN-LAST:event_passwordInputKeyPressed

    private void repeatPasswordInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repeatPasswordInputKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            passwordInput.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            createUserButton.requestFocusInWindow();
        }
    }//GEN-LAST:event_repeatPasswordInputKeyPressed

    private void createUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserButtonActionPerformed
        //get all:
        String login = loginInput.getText();
        char[] getPassword = passwordInput.getPassword();
        String password = new String(getPassword);

        char[] getSecondPassword = repeatPasswordInput.getPassword();
        String secondPassword = new String(getSecondPassword);

        //check data
        boolean corectness = checkData(login, password, secondPassword);

        //add to database:
        boolean added = false;
        if (corectness) {
            added = addToDatabase(login, password);
        }

        if (added) {
            backButton.doClick();
        }
    }//GEN-LAST:event_createUserButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();

        EventQueue.invokeLater(() -> {
            new LoginClass().setVisible(true);
        });
    }//GEN-LAST:event_backButtonActionPerformed

    private void createUserButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_createUserButtonKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            createUserButton.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            repeatPasswordInput.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            backButton.requestFocusInWindow();
        }
    }//GEN-LAST:event_createUserButtonKeyPressed

    private void backButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backButtonKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            backButton.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            repeatPasswordInput.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            createUserButton.requestFocusInWindow();
        }
    }//GEN-LAST:event_backButtonKeyPressed

    boolean addToDatabase(String login, String password) {
        Properties prop = new Properties();
        URL url = ClassLoader.getSystemResource("data/config.properties");

        try {
            prop.load(url.openStream());
        } catch (IOException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        String STATIC_login = prop.getProperty("STATIC_loginOracleDB");
        String STATIC_password = prop.getProperty("STATIC_passwordOracleDB");

        ORACLECONN = DBConnection.getOracleConnection(STATIC_login, STATIC_password);
        Statement oracleStatement = null;
        ResultSet result;
        System.out.println();

        try {
            oracleStatement = ORACLECONN.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            result = oracleStatement.executeQuery("select username from all_users order by created desc");

            String upperLogin = login.toUpperCase();

            while (result.next()) {
                if (result.getString("username").equals(upperLogin)) {
                    JOptionPane.showMessageDialog(null, "User with this login already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    DBConnection.resetOracleConnection();
                    return false;
                }
            }

            oracleStatement.executeQuery("create user " + upperLogin + " identified by " + password);
            oracleStatement.executeQuery("grant create session to " + upperLogin);

            //grant privileges
            String[] tables = {"countries", "departments", "dept", "emp", "employees", "job_grades", "job_history", "jobs", "locations", "regions"};

            for (String table : tables) {
                oracleStatement.executeQuery("grant select, insert, update, delete on " + table + " to " + upperLogin);
                System.out.println("Granted privileges to: " + table);
            }

            System.out.println("\n");

        } catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        DBConnection.resetOracleConnection();
        return true;
    }

    boolean checkData(String login, String password, String secondPassword) {
        if (login.length() > 10) {
            JOptionPane.showMessageDialog(null, "Login is too long!\nMax 10 characters", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.length() > 20) {
            JOptionPane.showMessageDialog(null, "Password is too long!\nMax 20 characters", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //check if not empty
        if (login.length() <= 0) {
            JOptionPane.showMessageDialog(null, "Login can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (password.length() <= 0) {
            JOptionPane.showMessageDialog(null, "Password can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //check repeated password
        if (password.equals(secondPassword) == false) {
            JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton createUserButton;
    private java.awt.Label createUserText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField loginInput;
    private java.awt.Label loginText;
    private javax.swing.JPasswordField passwordInput;
    private java.awt.Label passwordText;
    private java.awt.Label powtorzHaslo;
    private javax.swing.JPasswordField repeatPasswordInput;
    // End of variables declaration//GEN-END:variables
}

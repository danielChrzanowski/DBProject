/*
    Program connects to:
    - MySQL database (every time the same)
    - Oracle database indicated by user
    
    It uses multithreading to manage two databases "at the same time"
 */
package view;

import data.User;
import handling.DBConnection;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

public class LoginClass extends javax.swing.JFrame {

    static Connection ORACLECONN = null;
    static Statement oracleStatement;

    static Connection MYSQLCONN = null;
    static Statement mysqlStatement;

    User user;

    public LoginClass() {
        initComponents();
        user = User.getUser();

        loginInput.requestFocus(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginText = new java.awt.Label();
        passwordText = new java.awt.Label();
        loginInput = new javax.swing.JTextField();
        passwordInput = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        addUserButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DBProject");
        setLocation(new java.awt.Point(0, 0));
        setName("Magazyn - logowanie"); // NOI18N
        setResizable(false);

        loginText.setText("login:");

        passwordText.setText("password:");

        loginInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loginInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        loginInput.setText("ziibd6");
        loginInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginInputKeyPressed(evt);
            }
        });

        passwordInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        passwordInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passwordInput.setPreferredSize(new java.awt.Dimension(6, 20));
        passwordInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordInputKeyPressed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        loginButton.setText("Log in");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginButtonKeyPressed(evt);
            }
        });

        addUserButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        addUserButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addUserButton.setText("Create user");
        addUserButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addUserButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addUserButtonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addUserButtonFocusLost(evt);
            }
        });
        addUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addUserButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addUserButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addUserButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addUserButtonMouseReleased(evt);
            }
        });
        addUserButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addUserButtonKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginInput, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(loginInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event loginButtonActionPerformed
        this.dispose();

        //new thread so ConnectingInfo will work
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                ConnectingInfo info = new ConnectingInfo();

                java.awt.EventQueue.invokeLater(() -> {
                    info.setVisible(true);
                });

                char[] getPassword = passwordInput.getPassword();
                String password = new String(getPassword);

                //check if user starts with "ziidb", so program knows which DB to connect;
                //if it doesn't start with "ziibd" then connect to ziibd6 database
                //because it means that is new user created by program and he has privileges to connect to ziidb6 database;
                if (loginInput.getText().length() >= 5) {
                    String checkUser = loginInput.getText().substring(0, 5);

                    if (checkUser.equals("ziibd")) {
                        user.databaseName = loginInput.getText();
                    } else {
                        user.databaseName = "ziibd6";
                    }
                } else {
                    user.databaseName = "ziibd6";
                }

                user.login = loginInput.getText();
                System.out.println("Login: " + user.login + "\nDatabase: " + user.databaseName + "\nPassword: " + password);
                ORACLECONN = DBConnection.getOracleConnection(loginInput.getText(), password);

                MYSQLCONN = DBConnection.getMysqlConnection();
                System.out.println();

                try {
                    oracleStatement = ORACLECONN.createStatement();
                    mysqlStatement = MYSQLCONN.createStatement();

                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
                }

                info.dispose();
                if (ORACLECONN != null && MYSQLCONN != null) {
                    java.awt.EventQueue.invokeLater(() -> {
                        new EmployeeView().setVisible(true);
                    });
                } else {
                    java.awt.EventQueue.invokeLater(() -> {
                        new LoginClass().setVisible(true);
                    });
                }

                return null;
            }
        }.execute();

    }//GEN-LAST:event loginButtonActionPerformed

    private void loginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event loginButtonKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            loginButton.doClick();
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            addUserButton.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            loginInput.requestFocusInWindow();
        }
    }//GEN-LAST:event loginButtonKeyPressed

    private void loginInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginInputKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            passwordInput.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            loginButton.requestFocusInWindow();
        }
    }//GEN-LAST:event_loginInputKeyPressed

    private void passwordInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordInputKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            loginButton.doClick();
        }

        if (keyCode == KeyEvent.VK_UP) {
            loginInput.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            addUserButton.requestFocusInWindow();
        }
    }//GEN-LAST:event_passwordInputKeyPressed

    private void addUserButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addUserButtonFocusGained
        editText(addUserButton, java.awt.font.TextAttribute.UNDERLINE, java.awt.font.TextAttribute.UNDERLINE_ON);
    }//GEN-LAST:event_addUserButtonFocusGained

    private void addUserButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addUserButtonFocusLost
        editText(addUserButton, java.awt.font.TextAttribute.UNDERLINE, -1);
    }//GEN-LAST:event_addUserButtonFocusLost

    private void addUserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMouseClicked
        this.dispose();

        java.awt.EventQueue.invokeLater(() -> {
            new CreateUser().setVisible(true);
        });
    }//GEN-LAST:event_addUserButtonMouseClicked

    private void addUserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMouseEntered
        editText(addUserButton, java.awt.font.TextAttribute.UNDERLINE, java.awt.font.TextAttribute.UNDERLINE_ON);
    }//GEN-LAST:event_addUserButtonMouseEntered

    private void addUserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMouseExited
        editText(addUserButton, java.awt.font.TextAttribute.UNDERLINE, -1);
    }//GEN-LAST:event_addUserButtonMouseExited

    private void addUserButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMousePressed
        editText(addUserButton, java.awt.font.TextAttribute.SIZE, 9);
    }//GEN-LAST:event_addUserButtonMousePressed

    private void addUserButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMouseReleased
        editText(addUserButton, java.awt.font.TextAttribute.SIZE, 11);
    }//GEN-LAST:event_addUserButtonMouseReleased

    private void addUserButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addUserButtonKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            java.awt.EventQueue.invokeLater(() -> {
                new CreateUser().setVisible(true);
            });
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            passwordInput.requestFocusInWindow();
        }

        if (keyCode == KeyEvent.VK_UP) {
            loginButton.requestFocusInWindow();
        }
    }//GEN-LAST:event_addUserButtonKeyPressed

    public void editText(javax.swing.JLabel object, TextAttribute text1, Integer text2) {
        Font font = object.getFont();
        Map attributes = font.getAttributes();
        attributes.put(text1, text2);
        object.setFont(font.deriveFont(attributes));
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginClass().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addUserButton;
    private javax.swing.JButton loginButton;
    protected javax.swing.JTextField loginInput;
    private java.awt.Label loginText;
    private javax.swing.JPasswordField passwordInput;
    private java.awt.Label passwordText;
    // End of variables declaration//GEN-END:variables
}

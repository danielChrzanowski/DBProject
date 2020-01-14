package view;

import data.User;
import handling.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddEmployee extends javax.swing.JFrame {

    Connection ORACLECONN = null;
    Statement oracleStatement;
    ResultSet result;

    public AddEmployee() {
        initComponents();

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
        System.out.println();

        try {
            oracleStatement = ORACLECONN.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameInput = new javax.swing.JTextField();
        firstNameText = new java.awt.Label();
        lastNameText = new java.awt.Label();
        lastNameInput = new javax.swing.JTextField();
        emailText = new java.awt.Label();
        emailInput = new javax.swing.JTextField();
        phoneNumberText = new java.awt.Label();
        phoneNumberInput = new javax.swing.JTextField();
        jobIDText = new java.awt.Label();
        addButton = new javax.swing.JButton();
        salaryText = new java.awt.Label();
        salaryInput = new javax.swing.JTextField();
        commissionText = new java.awt.Label();
        managerIDText = new java.awt.Label();
        departmentIDText = new java.awt.Label();
        jobIDCombobox = new javax.swing.JComboBox<>();
        departmentCombobox = new javax.swing.JComboBox<>();
        managerIDCombobox = new javax.swing.JComboBox<>();
        commissionCombobox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Employee");
        setResizable(false);

        firstNameText.setText("First name:");

        lastNameText.setText("Last name*:");

        emailText.setText("Email*:");

        phoneNumberText.setText("Phone number:");

        jobIDText.setText("JobID*:");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        salaryText.setText("Salary:");

        commissionText.setText("Commission pct:");

        managerIDText.setText("Manager ID:");

        departmentIDText.setText("Department ID:");

        jobIDCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AD_ASST", "MK_MAN", "AC_MGR", "AC_ACCOUNT", "AD_PRES", "AD_VP", "IT_PROG", "ST_MAN", "ST_CLERK", "SA_MAN", "SA_REP" }));

        departmentCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "10", "20", "50", "60", "80", "90", "110" }));

        managerIDCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "100", "101", "102", "103", "124", "149", "201", "205" }));

        commissionCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0.15", "0.2", "0.3" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(firstNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(lastNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(commissionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commissionCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(managerIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(managerIDCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(departmentIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(departmentCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jobIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phoneNumberInput, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jobIDCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(salaryText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salaryInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(firstNameInput)
                    .addComponent(firstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lastNameInput)
                    .addComponent(lastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailInput)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phoneNumberInput)
                    .addComponent(phoneNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jobIDText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jobIDCombobox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salaryInput)
                    .addComponent(salaryText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commissionText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commissionCombobox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(managerIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(managerIDCombobox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(departmentIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(departmentCombobox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        java.util.List<String> columns = new java.util.ArrayList<>();

        if (firstNameInput.getText().length() >= 0 && firstNameInput.getText().length() < 21) {
            columns.add("'" + firstNameInput.getText() + "'");
        } else {
            JOptionPane.showMessageDialog(null, "First name length can be max 20", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (lastNameInput.getText().length() > 0 && lastNameInput.getText().length() < 26) {
            columns.add("'" + lastNameInput.getText() + "'");
        } else {
            JOptionPane.showMessageDialog(null, "Last name length should be from 1 to 25", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (emailInput.getText().length() > 0 && emailInput.getText().length() < 26) {
            columns.add("'" + emailInput.getText() + "'");
        } else {
            JOptionPane.showMessageDialog(null, "Email length should be from 1 to 25", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (phoneNumberInput.getText().length() >= 0 && phoneNumberInput.getText().length() < 21) {
            columns.add("'" + phoneNumberInput.getText() + "'");
        } else {
            JOptionPane.showMessageDialog(null, "Phone number length can be max 20", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        columns.add("'" + jobIDCombobox.getSelectedItem() + "'");

        if (salaryInput.getText().length() > 0) {
            try {
                Double.parseDouble(salaryInput.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Salary must be a number (decimal part separated by a period)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (salaryInput.getText().length() < 12) {
                columns.add(salaryInput.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Salary length can be max 11", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            columns.add("''");
        }

        columns.add(commissionCombobox.getSelectedItem().toString());

        if (managerIDCombobox.getSelectedIndex() == 0) {
            columns.add(managerIDCombobox.getSelectedItem().toString());
        } else {
            columns.add("'" + managerIDCombobox.getSelectedItem() + "'");
        }

        if (departmentCombobox.getSelectedIndex() == 0) {
            columns.add(departmentCombobox.getSelectedItem().toString());
        } else {
            columns.add("'" + departmentCombobox.getSelectedItem() + "'");
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        columns.add("to_date('" + dtf.format(localDate) + "')");

        //add commas
        String queryTables = "";
        for (int i = 0; i < columns.size(); i++) {
            queryTables += columns.get(i) + ",";
        }

        if (queryTables.length() > 0) {
            queryTables = queryTables.substring(0, queryTables.length() - 1);
        }
        System.out.println(queryTables);

        if (queryTables.length() > 0) {
            try {
                //check max ID
                result = oracleStatement.executeQuery("select max(employee_id) maxid from " + User.databaseName + ".employees");
                result.next();

                int nextID = result.getInt("maxid") + 1;
                System.out.println(nextID);

                //connection is in auto commit mode by default, so don't have to do it
                oracleStatement.executeUpdate("insert into " + User.databaseName + ".employees(employee_id, first_name, last_name, email, phone_number, job_id, salary, commission_pct, manager_id, department_id, hire_date)"
                        + "values(" + nextID + ", " + queryTables + ")");
                firstNameInput.setText("");
                lastNameInput.setText("");
                emailInput.setText("");
                phoneNumberInput.setText("");
                salaryInput.setText("");
                commissionCombobox.setSelectedIndex(0);
                managerIDCombobox.setSelectedIndex(0);
                jobIDCombobox.setSelectedIndex(0);
                departmentCombobox.setSelectedIndex(0);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error with data compatibility!\nTry again", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fill at least 1 input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> commissionCombobox;
    private java.awt.Label commissionText;
    private javax.swing.JComboBox<String> departmentCombobox;
    private java.awt.Label departmentIDText;
    private javax.swing.JTextField emailInput;
    private java.awt.Label emailText;
    private javax.swing.JTextField firstNameInput;
    private java.awt.Label firstNameText;
    private javax.swing.JComboBox<String> jobIDCombobox;
    private java.awt.Label jobIDText;
    private javax.swing.JTextField lastNameInput;
    private java.awt.Label lastNameText;
    private javax.swing.JComboBox<String> managerIDCombobox;
    private java.awt.Label managerIDText;
    private javax.swing.JTextField phoneNumberInput;
    private java.awt.Label phoneNumberText;
    private javax.swing.JTextField salaryInput;
    private java.awt.Label salaryText;
    // End of variables declaration//GEN-END:variables
}

/*
Question. Create a Account class (fields private: String strName (TTU1, TTU2,..), int id(100, 101,…), char accountType i.e 
‘C’ for current &‘S’ for saving accounts, double balance (hard-coded values). Provide get & set methods and parameterize &
non-parameterize constructors. Also provide withdaw(double amount) & deposit(double amount) methods and displayBalance( )
and displayAll( ) method. Consult lecture#9 for this Assignment.

//displayAll( ) prints all instance variables
Create a SavingsAccount class inheriting from Account class. SavingsAccount class
(Instance Variables: private: double rate ; Methods: public addInterest(…), deductLoan(…), parameterize constructor) 
Note for simplicity, assume that SavingAccount class is managing both Saving (i.e. accountType =’s’) and Current
( i.e. accountType = ‘c’) accounHolders.
The first line of derived class constructor should invoke the base class constructor using super and then provide code to 
initialize the local instance variables.. You can hard-code the values also. 
Now create a class UseSavingBankAccount class which incorporates GUI components. Create 50 array of objects for 
SavingAccount class using  parameterize constructors.. Use a ‘for’ loop to create array of objects. Now provide radio button
to perform following operations . 


G20(Deepen, Tecpal, Rick) 

Provide three radio Buttons (title same as operations in the question), three labels(AccType, accountType and Amount), 
three text fields (to input AccType and to input amount and accountType) and a “submit” push Button for the following two
operations
 (11) Display all AccountHolders’ information by accountType sorted by balance in ascending order using JOptionPane. 
Provide Method: displayAllByAccountType(SavingAccount[], char); sortByBalance(SavingAccount[])
(12) withdraw loan amount from all account holders’ balance,. based upon accountType.. Provide a Method 
deductLoanByAccountType(SavingAccount[], char, double amount) should call withdraw(…).


 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deepen Silwal @ Tecpal
 */
import javax.swing.*;

class BankAccount{
    private String strName;
    private int id;
    private char accountType;
    private double balance;
    private int 5;
    private string aaja;
    
    String getstrName(){
        return this.strName;   
    }
    
    void setstrName(String strName){
        this.strName = strName;
    }
    
    int getid(){
        return this.id;   
    }
    
    void setid(int id){
        this.id = id;
    }
    
    char getaccounType(){
        return this.accountType;    
    }
    
    void setaccountType(char accountType){
        this.accountType = accountType;
    }
    
    double getbalance(){
        return this.balance;   
    }
    
    void setbalance(double balance){
        this.balance= balance;
    }

    BankAccount(){
        setstrName(" ");
        setid(0);
        setaccountType(' ');
        setbalance(0.0);
    }
    
    BankAccount(String strName, int id, char accountType, double balance){
        setstrName(strName);
        setid(id);
        setaccountType(accountType);
        setbalance(balance);
    }
    
    void deposit(double amount){
        double finalamount = getbalance() + amount;
        setbalance(finalamount);
    }
    
    void withdraw(double amount){
        double finalamount = getbalance() - amount;
        setbalance(finalamount);
    }
    
    void displayBalance(){
        System.out.println("Balance: " + getbalance());
    }
    
    void displayAll(){
        System.out.println("Name: " + getstrName());
        System.out.println("Id: " + getid());
        System.out.println("Account Type: " + getaccounType());
        System.out.println("Balance: " + getbalance());
        System.out.println();

    }
    
}

class SavingAccount extends BankAccount{
    private double rate;
    
    SavingAccount(String newstrName, int newid, char newaccountType, double newbalance, double rate){
        super(newstrName, newid, newaccountType, newbalance);
        this.rate = rate;
    }   
    
    public void addIntereset(){
        double finalamount = getbalance() * rate;
        setbalance(finalamount);
    }
    
    public void deductLoan(double amount){
        double balance = getbalance() - amount;
        setbalance(balance);
    }   
}


public class UseSavingBankAccount extends javax.swing.JFrame {
    boolean bmRb1 = false;
    boolean bmRb2 = false;
    boolean bExit = false;
    
    SavingAccount[] objarray = new SavingAccount[50];
    /**
     * Creates new form UseSavingBankAccount
     */
    public UseSavingBankAccount() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(mRb1);
        group.add(mRb2);
        group.add(Exit);
        
        char accountType = 'C';
        String name = " ";
        int id = 0;
        double rate = 0.03;
        double amount = 0.0;
        for(int i = 0; i < 50; i++){
            name = "TTU" + (i+1);
            id = i + 100;
            amount = 1000- i;
            objarray[i] = new SavingAccount(name, id, accountType, amount, rate); 
            if(accountType == 'C'){
                accountType = 'S';
            }
            else{
                accountType = 'C';
            }
            objarray[i].displayAll();  
        } 
        
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mRb1 = new javax.swing.JRadioButton();
        mRb2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        Exit = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AccountType1 = new javax.swing.JTextField();
        AccountType2 = new javax.swing.JTextField();
        TextFieldLoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mRb1.setText("AccountHolders Information");
        mRb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRb1ActionPerformed(evt);
            }
        });

        mRb2.setText("Deduct Loan Amount");
        mRb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRb2ActionPerformed(evt);
            }
        });

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        jLabel1.setText("Account Type (C/S)");

        jLabel2.setText("Account Type (C/S)");

        jLabel3.setText("Enter Loan Amount");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextFieldLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(mRb1)
                                            .addGap(31, 31, 31)
                                            .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(mRb2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2))))
                                    .addGap(63, 63, 63)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(AccountType2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                        .addComponent(AccountType1)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(275, 275, 275)
                                    .addComponent(jButton1))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(Exit))))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mRb1)
                    .addComponent(jLabel1)
                    .addComponent(AccountType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mRb2)
                    .addComponent(jLabel2)
                    .addComponent(AccountType2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldLoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(Exit)
                .addGap(74, 74, 74)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mRb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRb1ActionPerformed
        // TODO add your handling code here:
        bmRb1 = true;
        bmRb2 = false;
        bExit = false;
        
        AccountType1.setEnabled(true);
        AccountType2.setEnabled(false);
        TextFieldLoan.setEnabled(false);
        
    }//GEN-LAST:event_mRb1ActionPerformed

    private void mRb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRb2ActionPerformed
        // TODO add your handling code here:
        bmRb1 = false;
        bmRb2 = true;
        bExit = false;
        
        AccountType1.setEnabled(false);
        AccountType2.setEnabled(true);
        TextFieldLoan.setEnabled(true);
 
    }//GEN-LAST:event_mRb2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String accounttype1 = AccountType1.getText();
        String accounttype2 = AccountType2.getText();
        String LoanAmount = TextFieldLoan.getText();
        
        if(bmRb1){  
            char account1 = accounttype1.charAt(0);
            sortByBalance(objarray);
            displayAllByAccountType(objarray, account1);  
        }
        else if (bmRb2){
            double Amount = Double.parseDouble(LoanAmount);
            char account2 = accounttype2.charAt(0);
            deductLoanByAccountType(objarray, account2, Amount);
        }
        else{
            System.exit(0);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        bmRb1 = false;
        bmRb2 = false;
        bExit = true;
        
        AccountType1.setEnabled(false);
        AccountType2.setEnabled(false);
        TextFieldLoan.setEnabled(false);

        
    }//GEN-LAST:event_ExitActionPerformed
    
    public void displayAllByAccountType(SavingAccount[] newobj, char newaccountType){
        String print = " ";
        for(int k = 0; k < 50; k++){
            if (newaccountType == newobj[k].getaccounType()){
                print +=  newobj[k].getstrName()+ "    " + newobj[k].getid() + "   " + newobj[k].getaccounType() + "   " + newobj[k].getbalance() + "\n";
            }  
        }    
        JOptionPane.showMessageDialog(null, print);
    }
    
    public void sortByBalance(SavingAccount[] newobj){
        SavingAccount[] newobjarray = new SavingAccount[1];//creates a temp array of object inorder to swap
        int length = 50;
         for(int i = 0; i < length - 1; i++){//sorting using bubble sort
            for(int j = 0; j < length - i -1; j++){
                if(newobj[j].getbalance() > newobj[j+1].getbalance()){ 
                    newobjarray[0] = newobj[j];
                    newobj[j] = newobj[j+1];
                    newobj[j+1] = newobjarray[0];
                }
            }
        }
    }
    
    public void deductLoanByAccountType(SavingAccount[] newobj, char newaccount2, double amount){
        String print = " ";
        for(int i = 0; i < 50; i++){ 
            if (newobj[i].getaccounType() == newaccount2){
                newobj[i].withdraw(amount);
                print += newobj[i].getstrName()+ "    " + newobj[i].getid() + "   " + newobj[i].getaccounType() + "   " + newobj[i].getbalance() + "\n";
            }    
        }
        JOptionPane.showMessageDialog(null, print);
    }
    
    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) { 
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UseSavingBankAccount().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountType1;
    private javax.swing.JTextField AccountType2;
    private javax.swing.JRadioButton Exit;
    private javax.swing.JTextField TextFieldLoan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton mRb1;
    private javax.swing.JRadioButton mRb2;
    // End of variables declaration//GEN-END:variables
}

package com.sephcordovano.ciphersoapclient;

import javax.swing.JOptionPane;

public class CipherSoapClient extends javax.swing.JFrame {
    CipherSoapService proxy; 
    CipherSoapService_Service service;
    String output; // Final output to be displayed
    String textInput; // Users input to be de/cyphered
    int shiftInput; // The amount the user wants to shift the characters
    
    public CipherSoapClient() {
        initComponents(); // Initialize GUI components
        service = new CipherSoapService_Service(); // Initialize Web Service
        proxy = service.getCipherSoapServicePort(); // Initialize proxy
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAreaScrollPane = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();
        lblShift = new javax.swing.JLabel();
        txtShift = new javax.swing.JTextField();
        btnCipher = new javax.swing.JButton();
        btnDecipher = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblNote = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtInput.setColumns(20);
        txtInput.setRows(5);
        txtInput.setName(""); // NOI18N
        txtAreaScrollPane.setViewportView(txtInput);

        lblTitle.setText("Text to Cipher & Decipher");

        lblShift.setText("Enter number of char to shift");

        txtShift.setText("0");

        btnCipher.setText("Cipher");
        btnCipher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCipherActionPerformed(evt);
            }
        });

        btnDecipher.setText("Decipher");
        btnDecipher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecipherActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCipher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDecipher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(txtShift, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(lblShift)
                                .addContainerGap(37, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblShift)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCipher)
                    .addComponent(btnDecipher)
                    .addComponent(btnClear)
                    .addComponent(btnExit))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //*********** ACTIONABLES  ***********
    private void btnCipherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCipherActionPerformed
        shiftInput = Integer.parseInt(txtShift.getText()); // Get amount that user wants to shift text by
        textInput = txtInput.getText(); // Get user text input to be cyphered
        
        // Validate user info and send to web service if valid
        if ((validateTextInput(textInput) == true) && (validateShiftInput(shiftInput) == true)){
            try{
                output = proxy.cipher(textInput, shiftInput); // Send info to web service
            } catch (CipherArgumentException_Exception cae){ // If custom error thrown
                shiftInput = editShiftInput(shiftInput); // Edit shift amount to be within range
                try{ // Try again with new shift input 
                output = proxy.cipher(textInput, shiftInput); // Send to web service
                } catch (CipherArgumentException_Exception cae2){ // If error thrown again report display message
                    JOptionPane.showConfirmDialog(rootPane, 
                        cae2.getMessage(), 
                        "Error", 
                        JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
            // Display final out put to user 
            txtInput.setText("Original text: " + textInput + "\nNew Text: " + output); 
        }
    }//GEN-LAST:event_btnCipherActionPerformed
      
    private void btnDecipherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecipherActionPerformed
        shiftInput = Integer.parseInt(txtShift.getText()); // Get amount that user wants to shift text by
        textInput = txtInput.getText(); // Get user text input to be cyphered
        
        // Validate user info and send to web service if valid
        if ((validateTextInput(textInput) == true) && (validateShiftInput(shiftInput) == true)){
            try{
                output = proxy.decipher(textInput, shiftInput); // Send info to web service
            } catch (CipherArgumentException_Exception cae){ // If custom error thrown
                shiftInput = editShiftInput(shiftInput); // Edit shift amount to be within range
                try{ // Try again with new shift input
                output = proxy.decipher(textInput, shiftInput); // Send to web service
                } catch (CipherArgumentException_Exception cae2){ // If error thrown again report display message
                    JOptionPane.showConfirmDialog(rootPane, 
                        cae2.getMessage(), 
                        "Error", 
                        JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
            // Display final out put to user 
            txtInput.setText("Original text: " + textInput + "\nNew Text: " + output); 
        }
    }//GEN-LAST:event_btnDecipherActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtInput.setText(""); // Clear text input
        txtShift.setText("0"); // Set shift amount to 0
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0); // Exit app
    }//GEN-LAST:event_btnExitActionPerformed
    
    // Validate text input is not empty, if so, display message to user
    private boolean validateTextInput(String textInput){
        if (textInput.length() == 0){
            JOptionPane.showConfirmDialog(rootPane, 
                    "You must have at least one character in your message.", 
                    "Text Error", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.ERROR_MESSAGE);
            return false; // Return false to method to prevent sending data to web service
        } else
            return true;
    }
    
    // Validate shift input value is, and includes, 1 to 591
    private boolean validateShiftInput(int shiftValue){
        if (shiftValue < 1 || shiftValue > 591){ // if outside of range display message to user
            JOptionPane.showConfirmDialog(rootPane, 
                    "Enter a valid integer between 1 and 591 only.", 
                    "Shift Error", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.ERROR_MESSAGE);
            return false; // Return false to method to prevent sending data to web service
        } else
            return true;
    }
    
    // If shift data is sent back from web server, cycle through until between 1 and 94
    private int editShiftInput(int shiftValue){
        while(shiftValue > 94)
            shiftValue -= 94;
        return shiftValue;
    }
    
    // Starts the party
    public static void main(String args[]) {
        // Set the Nimbus look and feel
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
            java.util.logging.Logger.getLogger(CipherSoapClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CipherSoapClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CipherSoapClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CipherSoapClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CipherSoapClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCipher;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDecipher;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblShift;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane txtAreaScrollPane;
    private javax.swing.JTextArea txtInput;
    private javax.swing.JTextField txtShift;
    // End of variables declaration//GEN-END:variables
}
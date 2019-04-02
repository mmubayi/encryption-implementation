/**
 * FILE NAME: PasswordTest.java
 * WHO: Maya Mubayi
 * WHAT: Driver class for Cipher
 */

import javax.swing.JOptionPane; 

public class PasswordTest { 
  
   /**
   * Creates a Secret object and a Password object and exercises their encryption.
   */
  public static void main(String [] args) {
    
    String inputMsg, inputPassword; 
    int again; 
   
    inputMsg = JOptionPane.showInputDialog("What is the message?"); 
    inputPassword = JOptionPane.showInputDialog("What is the password?");
    Cipher encryptedMsg = new Cipher(inputMsg, inputPassword); 
    encryptedMsg.encrypt(); 
    JOptionPane.showMessageDialog(null, encryptedMsg.toString());   
    again = JOptionPane.showConfirmDialog(null, "Do you want it decrypted?"); 
    if (again == JOptionPane.YES_OPTION) {
      String decryptedMsg = encryptedMsg.decrypt();
      JOptionPane.showMessageDialog(null, decryptedMsg); 
    }
  }
}
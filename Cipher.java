/**
 * FILE NAME: Cipher.java
 * WHO: Maya Mubayi
 * WHAT: Class that implements Encryptable interface 
 * Property:  password - private property String for encryption password
 * newPassword - private property empty String to create full length password
 * phrase - private property String message entered 
 * encrypted - private property boolean returning whether message has been encrypted
 * 
 *   
 * Methods:
 * method encrypt() - encrypts message based on password
 * method decrypt() - decrypts message based on password
 * final method toString() - provides a string representation of encryped/decrypted message
 */

public class Cipher implements Encryptable {
  //instance variables
  private String password; 
  private String newPassword = ""; 
  private String phrase; 
  private boolean encrypted = false; 
  
   /**
   * Stores the original message after turning it into all uppercase without spaces. 
   * @param msg - the plain message
   * @param password - the encryption password
   */
  public Cipher(String msg, String password) {
    phrase = msg.toUpperCase().replaceAll("\\s", ""); //removes spaces between words
    this.password = password.toUpperCase();
    for (int i = 0; i < phrase.length()/password.length(); i++) {
      newPassword += password; 
    }
    if (newPassword.length() != phrase.length()) {
      for (int i = 0; i < phrase.length() % password.length(); i++) {
        newPassword += password.charAt(i); 
      } //sets up password length to match phrase length so it is letter for letter
    }
    newPassword = newPassword.toUpperCase(); 
  }
  
   /**
   * encrypts the message entered by the user with the password and updates encrypted boolean and phrase   
   */
  public void encrypt() {
    if (!isEncrypted()) {
      String masked = ""; 
      for (int i = 0; i < phrase.length(); i++) {
        int sum = (phrase.charAt(i)) + (newPassword.charAt(i) - 'A');
        if (sum >= 91) {
          masked += (char)(sum - 26); //uses the sum of the chars to find the next character if it'll pass Z
        }
        else {
        masked += (char)(phrase.charAt(i) + newPassword.charAt(i) - 'A');
        }
      }
      phrase = masked; 
      encrypted = true; 
    }
  }
  
   /**
   * decrypts the encrypted message with the password and updates encrypted boolean and phrase
   * @return the secret message
   */
  public String decrypt() {
    if (isEncrypted()) {
      String unmasked = ""; 
      for (int i = 0; i < phrase.length(); i++) {
        int diff = (phrase.charAt(i)) - (newPassword.charAt(i) - 'A');
        if (diff <= 64) {
          unmasked += (char)(diff + 26); //uses the difference between the chars to find the next character if passing A
        }
        else {
        unmasked += (char)(phrase.charAt(i) - (newPassword.charAt(i) - 'A')); 
        }
      }
      phrase = unmasked; 
      encrypted = false; 
    }
    return phrase;
  }
   /**
   * Returns true if this secret is currently encrypted.  
   * @return encryption status
   */
  public boolean isEncrypted() {
    return encrypted; 
  }
  
   /**
   * Returns this secret (may be encrypted).  
   */
  public String toString() {
    return phrase; 
  }
  
  }
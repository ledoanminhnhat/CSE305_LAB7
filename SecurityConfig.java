/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse305_lab5;

/**
 *
 * @author admin
 */
public class SecurityConfig {
    private boolean encryptionEnabled;
    private boolean twoFactorAuthentication;
   
    private SecurityConfig() {}

    
    public static class Builder {
        private boolean encryptionEnabled;
        private boolean twoFactorAuthentication;
       

        public Builder() {}

        
        public SecurityConfig build() {
            SecurityConfig config = new SecurityConfig();
            config.encryptionEnabled = this.encryptionEnabled;
            config.twoFactorAuthentication = this.twoFactorAuthentication;
           
            return config;
        }
    }
}


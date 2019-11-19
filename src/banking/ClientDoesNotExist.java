/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 *
 * @author Loufi
 */
public class ClientDoesNotExist extends Exception{
    
    public ClientDoesNotExist(String message) {
        super(message);
    }
}

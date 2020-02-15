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

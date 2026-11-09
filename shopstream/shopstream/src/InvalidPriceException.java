

public class InvalidPriceException extends  RuntimeException {

    public InvalidPriceException(int id){
        super("Price can be 0  for id "+id);
    }



}

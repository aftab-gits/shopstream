
public class InsufficeientStockException extends  RuntimeException {

    public InsufficeientStockException(int id, int quantity){
        super("Product of id "+ id+ " has insuffient stock in inventory There fore use less quantity than  "+ quantity);

    }
}

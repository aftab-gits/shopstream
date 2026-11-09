public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(int id){
        super("Product Not foud with id "+id);
    }
}

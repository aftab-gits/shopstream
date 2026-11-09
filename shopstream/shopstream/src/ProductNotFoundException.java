public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(int id){
        super("Product Not found with id "+id);
    }
}

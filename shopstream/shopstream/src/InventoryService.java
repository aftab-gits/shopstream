import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class InventoryService {

    private static final int LOW_STOCK_VAL=5;
    private final List<Product> listOfProduct = new ArrayList<>();

    public void addProduct(Product product){

        if(product.price()<=0){
            throw  new InvalidPriceException(product.id());
        }


        listOfProduct.add(product);
    }

    public Optional<Product> findById(int id){
        for(Product p: listOfProduct){
            if(p.id()==id){
                return Optional.of(p);
            }
        }

        return Optional.empty();
    }

    public Product getById(int id){
       Optional<Product> p =  findById(id);
       if(p.isPresent()){
           return  p.get();
       }

       throw new ProductNotFoundException(id);
    }

    public List<Product>  getAllProduct(){
        return new ArrayList<>(listOfProduct);
    }

    public Optional<Product> findByName(String name){
        for(Product p: listOfProduct){
            if(p.name().equals(name)){
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public void printLowStock(){
        for(Product p : listOfProduct){
            if(p.quantity()<InventoryService.LOW_STOCK_VAL){
                System.out.println("Stock running out for "+ p.name()+"With stock left as "+p.quantity());
            }
        }
    }

    public boolean removeProduct(int id) {
        return listOfProduct.removeIf(p -> p.id() == id);
    }

    public static int findIndex(List<Product> list ,int id){
        int index=-1;

        for(Product p : list){
            index++;
            if(p.id()==id){
                return index;
            }
        }
        return index;
    }

    public void reduceStock(int id, int quantity){

        if(quantity<0)
        {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        Product p = getById(id);

        if(p.quantity()<quantity){
            throw new InsufficeientStockException(id,quantity);


        }
        else {
            p = new Product(id,p.name(),p.price(),p.quantity()-quantity);
        }


        int index = findIndex(listOfProduct,id);

        listOfProduct.set(index,p);


    }

}

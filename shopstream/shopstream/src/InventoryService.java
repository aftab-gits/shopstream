import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class InventoryService {

    private static final int LOW_STOCK_VAL=5;
    private final List<Product> listOfProduct = new ArrayList<>();

    public void addProduct(Product product){
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

}

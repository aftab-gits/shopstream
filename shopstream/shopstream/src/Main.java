import java.util.List;
import java.util.Optional;

public class Main{

    public static void main(String[] args){

        InventoryService inventoryService = new InventoryService();
        inventoryService.addProduct(new Product(1,"Phone",11999,6));
        inventoryService.addProduct(new Product(2,"Laptop",49999,1));
        inventoryService.addProduct(new Product(3,"TV",30999,5));

        List<Product> allProduct= inventoryService.getAllProduct();
        System.out.println("All Products are :\n "+allProduct);

        Optional<Product> product = inventoryService.findById(1);
        if(product.isPresent()){
            System.out.println("Product Found is "+ product.get());
        }
        else {
            System.out.println("Product not found");
        }

        Optional<Product> product1 = inventoryService.findByName("Laptop");
        if(product1.isPresent()){
            System.out.println("Product Found is "+ product1.get());
        }
        else {
            System.out.println("Product not found");
        }

        boolean productRemoved = inventoryService.removeProduct(3);
        if(productRemoved){
            System.out.println("Product has been removed");
        }
        else{
            System.out.println("Prouduct could not be removed");
        }
        inventoryService.printLowStock();

        inventoryService.getAllProduct().clear();
        System.out.println("Size after clear is "+ inventoryService.getAllProduct().size());
    }






}
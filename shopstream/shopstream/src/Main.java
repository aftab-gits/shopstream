import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

public class Main{

    public static void tryAdd(InventoryService service , Product product){
        try{
            service.addProduct(product);
        }
        catch(InvalidPriceException e){
            System.out.println("Exception caught while ading product "+ e.getMessage());
        }
    }

    public static void main(String[] args) {

        InventoryService inventoryService = new InventoryService();
        tryAdd(inventoryService, new Product(1, "Phone", 9999, 6));
        tryAdd(inventoryService, new Product(2, "Laptop", 49999, 1));
        tryAdd(inventoryService, new Product(3, "TV", 1000, 5));

//        List<Product> allProduct = inventoryService.getAllProduct();
//        System.out.println("All Products are :\n " + allProduct);

        int id1 = 6;


//        try{
//            Optional<Product> product = inventoryService.findById(id1);
//            if(product.isPresent()){
//                System.out.println("Product found is "+product.get().name());
//            }
//            else
//            {
//                throw new ProductNotFoundException(id1);
//            }
//
//        }
//        catch(ProductNotFoundException e){
//            System.out.println("Exception caught in catch block "+e.getMessage());
//
//        }
//
//        try{
//            Product p = inventoryService.getById( id1);
//            System.out.println("getById returned a product ");
//        }
//        catch (ProductNotFoundException e){
//            System.out.println(e.getMessage());
//        }


//        Optional<Product> product1 = inventoryService.findByName("Laptop");
//        if(product1.isPresent()){
//            System.out.println("Product Found is "+ product1.get());
//        }
//        else {
//            System.out.println("Product not found");
//        }
//
//        boolean productRemoved = inventoryService.removeProduct(3);
//        if(productRemoved){
//            System.out.println("Product has been removed");
//        }
//        else{
//            System.out.println("Prouduct could not be removed");
//        }
//        inventoryService.printLowStock();

//        try {
//            inventoryService.reduceStock(1,2);
//            System.out.println("Stock update for "+inventoryService.getById(1));
//        }
//        catch (InsufficeientStockException e){
//            System.out.println(e.getMessage());
//    }
//
//        inventoryService.getAllProduct().clear();
//       System.out.println("Size after clear is "+ inventoryService.getAllProduct().size());

//        System.out.println(inventoryService.getProductsAbove(3000));
//        System.out.println(inventoryService.getProductNames());

        System.out.println("Producsts sorted by price are "+ inventoryService.getProductsSortedByPrice());

        inventoryService.lazyDemo();



    }
}

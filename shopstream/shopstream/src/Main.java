import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main{

    public record Product(int id, String name, double price, int quantity){

    }

    public static Optional<Product> findById(List<Product> list, int id) {
        for (Product product : list) {
            if (product.id() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public static void printLowStock(List<Product> list){

        for(Product product : list){
            if(product.quantity()<5){
                System.out.println("Warning! Stock running out for " + product.name() + ". Quantity left: " + product.quantity());
            }
        }
    }

    public static Optional<Product>findByName(List<Product> list , String name){
        for(Product product : list){
            if(product.name().equals(name)){
                return Optional.of(product);
            }
        }

        return Optional.empty();
    }

    public static void main(String[] args){
        System.out.println("Hello! Shopstream");

        List<Product> list = new ArrayList<>();
        list.add(new Product(1,"Phone" , 20000 , 1));
        list.add(new Product(2,"Cars" , 150000 , 11));
        list.add(new Product(3,"Bike" ,160000 , 1));

        System.out.println("Total products are "+ list.size());
        System.out.println("products are are shown below ");
        for(Product product : list){
            System.out.println(product);
        }
        System.out.println("Enter a product id you want to search ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Optional<Product> foundProduct = findById(list,id);
//
        if(foundProduct.isPresent()){
            System.out.println("Here is the product you searched :"+ foundProduct);
        }
        else{
            System.out.println("Product does not exist");
        }
        foundProduct.ifPresentOrElse(
                p -> System.out.println("Found: " + p),
                () -> System.out.println("Product does not exist")
        );

        System.out.println("Enter a product name you want to search");
        String productName = sc.nextLine();
        Optional<Product> productNameFoud = findByName(list,productName);
        if(productNameFoud.isPresent()){
            System.out.println("product name found "+ productNameFoud.get());
        }
        else {
            System.out.println("Product didnt found");
        }
        sc.close();

        printLowStock(list);



    }
}
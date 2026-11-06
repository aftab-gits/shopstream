import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    public record Product(int id, String name, double price, int quantity){

    }

    public static Product findById(List<Product> list, int id) {
        for (Product product : list) {
            if (product.id() == id) {
                return product;
            }
        }
        return null;
    }

    public static void printLowStock(List<Product> list){

        for(Product product : list){
            if(product.quantity()<5){
                System.out.println("Warning ! Stock running out for "+ product.name+ " Quatnitty left "+ product.quantity);
            }
        }
    }

    public static void main(String[] args){
        System.out.println("Hello! Shopstream");

        List<Product> list = new ArrayList<>();
        list.add(new Product(1,"Phone" , 20000 , 1));
        list.add(new Product(20,"Cars" , 150000 , 11));
        list.add(new Product(3,"Bike" ,160000 , 1));

        System.out.println("Total products are "+ list.size());
        System.out.println("products are are shown below ");
        for(Product product : list){
            System.out.println(product);
        }
        System.out.println("Enter a product id you want to search ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Product foundProduct = findById(list,id);

        if(foundProduct!=null){
            System.out.println("Product exist");
        }
        else{
            System.out.println("Product does not exist");
        }

        sc.close();

        printLowStock(list);



    }
}
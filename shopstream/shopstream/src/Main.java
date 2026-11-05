

public class Main{

    public record Product(int id, String name, double price, int quantity){

    }

    public static void main(String[] args){
        System.out.println("Hello! Shopstream");
        Product p1 = new Product(1, "SamrtPhone" , 20000, 1);
        System.out.println(p1);
        p1.name="Cars";
        System.out.println(p1.name());
    }
}
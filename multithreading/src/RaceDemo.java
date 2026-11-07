public class RaceDemo {

    static int counter=0;

    public static  void main(String[] args){

        System.out.println("Race demo Tutorial");

        Runnable task = ()->{
            for(int i = 1 ; i<=100000 ; i++){
                counter++;
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Expected value of Counter is 2000 "+counter);
    }
}

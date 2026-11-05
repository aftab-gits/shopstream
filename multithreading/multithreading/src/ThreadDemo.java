public class ThreadDemo {

    public static void main(String[] args){

        Thread t1 = new Thread(()->{
            for (int i = 1 ; i<=5 ; i++){
                System.out.println(Thread.currentThread().getName()+"Block A "+ i);
            }

            try{
                Thread.sleep(8000);
            }
            catch (InterruptedException e){
                System.out.println("Exception caught in catch block " );
                e.printStackTrace();
            }

        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"Bock B "+ i);
                try{
                Thread.sleep(8000);
                }
                catch (InterruptedException e){
                    System.out.println("Exception caught in catch block " );
                    e.printStackTrace();
                }
            }
        });


        t1.start();
        t2.start();
        try {
            Thread.sleep(10000);
        }
        catch(Exception e){
            e.printStackTrace();

        }
        System.out.println("Main thread woke up");


    }
}
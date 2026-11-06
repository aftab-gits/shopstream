public class Main{

    public static void main(String[] args){
        System.out.println("Hello ..Testing multhreading");

        Thread t1 = new Thread(()->{
            for(int i=1; i<=3; i++){
                System.out.println("Worker A: step " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        });


        Thread t2 = new Thread(()->{
            for(int i=1; i<=3; i++){
                System.out.println("Worker B step " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        });

        t1.start();
        t2.start();
        System.out.println("Main: waitig for A");
        try{
            t1.join();
            t2.join();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Main: Worker A is done, I can continue.");


    }
}
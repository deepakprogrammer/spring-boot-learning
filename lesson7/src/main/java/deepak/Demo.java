package deepak;

import javax.management.RuntimeErrorException;

public class Demo {
    public static void main(String[] args) {
        try (Res r = new Res()) {
            try{
                System.out.println("2. using");
                throw new RuntimeException("boom");
            }catch(RuntimeException e){
                System.out.println("3. inner catch, r = " + r.state());
            }
        }
        System.out.println("5. after try");
    }
}

class Res implements AutoCloseable{
    private boolean open = true;
    Res(){
        System.out.println("1. opened");
    }

    String state(){
        return open ? "OPEN" : "CLOSED";
    }

    @Override
    public void close(){
        open = false;
        System.out.println("4. closed");
    }
}
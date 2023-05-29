
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread {

    Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        SchemeOp product;
        product = this.buffer.consume();
        //System.out.println("Running Consumer...");
        if (product == null) {
            Buffer.print("Consumer couldn't find a not null buffer.");
        } else {
            Buffer.print("Consumer consumed: " + "Id -> " + product.Id + " Op -> " + product.SchemeFormat() + " Result -> " + product.result);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

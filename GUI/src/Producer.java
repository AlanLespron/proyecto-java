
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread {

    Buffer buffer;
    int min, max;

    Producer(Buffer buffer, int min, int max) {
        this.buffer = buffer;
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        SchemeOp randScheme = new SchemeOp(min, max);
        this.buffer.produce(randScheme);
        Buffer.print("Producer produced: " + "Id -> " + randScheme.Id + " Op -> " + randScheme.SchemeFormat() + " Result -> " + randScheme.result);
        try {
            Thread.sleep(this.buffer.waitProd);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

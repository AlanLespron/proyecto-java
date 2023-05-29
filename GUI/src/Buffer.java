
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {

    private SchemeOp[] buffer;
    public Random random;
    public int waitCons, waitProd;

    Buffer(int bufferSize, int waitProducer, int waitConsumer) {
        this.buffer = new SchemeOp[bufferSize];
        random = new Random(System.currentTimeMillis());
        waitCons = waitConsumer;
        waitProd = waitProducer;
    }

    synchronized SchemeOp consume() {
        SchemeOp product = null;
        int notNullBuffer = -1;

        for (int i = 0; i < this.buffer.length; i++) {
            if (this.buffer[i] != null) {
                notNullBuffer = i;
                break;
            }
            try {
                wait(waitCons);
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (notNullBuffer < 0) {
            return product;
        }
        product = this.buffer[notNullBuffer];
        this.buffer[notNullBuffer] = null;
        notifyAll();
        return product;
    }

    synchronized void produce(SchemeOp product) {
        int randBufferNum = random.nextInt(0, this.buffer.length);
        while (this.buffer[randBufferNum] != null) {
            try {
                wait(waitProd);
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.buffer[randBufferNum] = product;

        notifyAll();
    }

    static int count = 1;

    synchronized static void print(String string) {
        System.out.print(count++ + " ");
        System.out.println(string);
    }

}

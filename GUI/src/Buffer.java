
package producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {
    
    private int buffer;
    
    Buffer() {
        this.buffer = 0;
    }
    
    synchronized int consume() {
        int product = 0;
        
        if(this.buffer == 0) {
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        product = this.buffer;
        this.buffer = 0;
        notify();
        
        return product;
    }
    
    synchronized void produce(int product) {
        if(this.buffer != 0) {
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.buffer = product;
        
        notify();
    }
    
    static int count = 1;
    synchronized static void print(String string) {
        System.out.print(count++ + " ");
        System.out.println(string);
    }
    
}

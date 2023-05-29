
public class ProducerConsumer {
    
    private Producer _producerArr [];
    private Consumer _consumerArr [];
     public Buffer buffer;
    public static javax.swing.JProgressBar JProgressBarS;
    public static javax.swing.JSpinner jSpinner;
    
    public ProducerConsumer(int producerSize, int consumerSize){
        
        this._producerArr = new Producer[producerSize];
        this._consumerArr = new Consumer[consumerSize];
    }

   public void processIn(int bufferSize,int min, int max, javax.swing.JProgressBar JPBar, javax.swing.JSpinner jSpinner4){
       Buffer buffer = new Buffer(bufferSize);
        JProgressBarS = JPBar;
        JProgressBarS.setMaximum(100);
        JProgressBarS.setMinimum(0);
        jSpinner = jSpinner4;
        
        for (int i = 0; i < this._producerArr.length; i++){
            this._producerArr[i] = new Producer(buffer);
            this._producerArr[i].start();
        }
        
        for (int x = 0; x < this._consumerArr.length; x++){
            this._consumerArr[x] = new Consumer(buffer);
            this._consumerArr[x].start();
        }
   }
    public void StopAllThreads(){
    for (int i = 0; i < this._producerArr.length; i++){
            
            this._producerArr[i].interrupt();
        }
        
        for (int x = 0; x < this._consumerArr.length; x++){
            this._consumerArr[x].interrupt();
        }
    }
}

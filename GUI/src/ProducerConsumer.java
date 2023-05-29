
public class ProducerConsumer {

    private Producer _producerArr[];
    private Consumer _consumerArr[];
    public Buffer buffer;

    public ProducerConsumer(int producerSize, int consumerSize) {

        this._producerArr = new Producer[producerSize];
        this._consumerArr = new Consumer[consumerSize];
    }

    public void processIn(int bufferSize, int min, int max, int prodTime, int consTime) {
        Buffer buffer = new Buffer(bufferSize, prodTime, consTime);

        for (int i = 0; i < this._producerArr.length; i++) {
            this._producerArr[i] = new Producer(buffer, min, max);
            this._producerArr[i].start();
        }

        for (int x = 0; x < this._consumerArr.length; x++) {
            this._consumerArr[x] = new Consumer(buffer);
            this._consumerArr[x].start();
        }
    }

    public void StopAllThreads() {
        for (int i = 0; i < this._producerArr.length; i++) {

            this._producerArr[i].interrupt();
        }

        for (int x = 0; x < this._consumerArr.length; x++) {
            this._consumerArr[x].interrupt();
        }
    }
}

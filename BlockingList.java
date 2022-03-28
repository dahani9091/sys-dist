import java.util.LinkedList;
import java.util.Queue;

public class BlockingList<E>{
    private int max_size;
    private Queue<E> queue;
    private Object sharedQ;


    public BlockingList(int size){
        this.max = size;
        this.queue = new LinkedList<E>();
        this.sharedQ = new Object();
    }

    public void put(E e){
        synchronized(this){
            while(queue.size() == this.max){
                sharedQ.wait();
            }
            queue.add(e);
            sharedQ.notifyAll();
        }
    }

    public E take(){
        synchronized(this){
            while(queue.size() == 0){
                sharedQ.wait();
            }
            E item = queue.remove();
            sharedQ.notifyAll();
            return item;
        }
    }

} 






























public class BlockingQueue <E>{

    private int max;
    private Queue<E> queue;
    private Object sharedQ;


    public BlockingQueue(int size){
        this.queue = new LinkedList<E>();
        this.max = size;
        this.sharedQ = new Object();
    }

    public void put(E e){
        synchronized(this){
            while(this.queue.size() == this.max){
                sharedQ.wait();
            }
            this.queue.add(e);
            sharedQ.notifyAll();
        }
    }

    public E take(){
        synchronized(this){
            while(this.queue.size() == 0){
                sharedQ.wait();
            }
            E item = this.queue.remove(e);
            sharedQ.notifyAll();
            return item; 
        }
    }

}

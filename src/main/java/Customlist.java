import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Customlist<T>{
    private static final Logger LOGGER=LogManager.getLogger(Customlist.class);
    private Object[] list;
    private int capacity;
    public int index=0;

    public Customlist() throws Exception {
        this(10);
    }
    public Customlist(int initCapacity) throws Exception {
        capacity=initCapacity;
        if(capacity>0)
            this.list=new Object[capacity];
        else if(capacity==0)
            this.list=new Object[10];
        else
            throw new Exception("Illegal Capacity: "+capacity);
    }
    public void addElement(T ele) {
        if(index>=capacity) {
            increaseCapacity();
        }
        list[index]=ele;
        index++;
    }
    private void increaseCapacity() {
        double loadFactor = 0.8;
        int newCapacity = (int) (capacity + (capacity*loadFactor));
        capacity=newCapacity;
        list=Arrays.copyOf(list,capacity);
    }
    public T getElement(int pos) throws Exception {
        if(pos>=index)
            throw new Exception("ArrayIndexOutOfBoundsException at index "+pos);
        T ele = (T) list[pos];
        return ele;
    }
    public boolean removeElement(T ele) throws Exception {
        int i=indexOf(ele);
        if(i>=0) {
            pop(i);
            return true;
        }
        return false;
    }
    private int indexOf(Object ele) {
        for(int i=0;i<index;i++) {
            if(ele.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }
    public T pop() throws Exception {
        return pop(index-1);
    }

    public T pop(int pos) throws Exception {
        if(pos>index)
            throw new Exception("ArrayIndexOutOfBoundsException at position "+pos);
        T element = (T) list[pos];
        int len=capacity-1-pos;
        System.arraycopy(list,pos+1,list,pos,len);
        index--;
        return element;
    }
    public void display() {
        LOGGER.info("The elements in the list are: \n");
        for(int i=0;i<index;i++)
            LOGGER.info(list[i]+"\t");
        LOGGER.info("\n");

    }

}
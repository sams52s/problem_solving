package javaProblemsSolution.september;

class DesignCircularDeque {

    private ArrayList<Integer> deque;
    private int k;
    private int front;
    private int rear;
    private int currentCount;

    public MyCircularDeque(int k) {
        this.k = k;
        this.deque = new ArrayList<>(k);
        this.front = 0;
        this.rear = 0;
        this.currentCount = 0;
        
        for (int i = 0; i < k; i++) {
            deque.add(0);
        }
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + k) % k; 
        deque.set(front, value);  
        currentCount++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        deque.set(rear, value);   
        rear = (rear + 1) % k;  
        currentCount++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % k;  
        currentCount--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + k) % k;  
        currentCount--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1; 
        }
        return deque.get(front);   
    }

    public int getRear() {
        if (isEmpty()) {
            return -1; 
        }
        return deque.get((rear - 1 + k) % k); 
    }

    public boolean isEmpty() {
        return currentCount == 0;
    }

    public boolean isFull() {
        return currentCount == k;
    }
}

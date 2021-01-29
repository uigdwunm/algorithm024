package Week_01.assignment_641_design_circular_deque;

/**
 * Description
 *
 * @author zhaolaiyuan
 * Date 2021/1/29 8:46
 **/
class MyCircularDeque2 {

    private int[] tables;
    private int size;
    private int head;
    private int tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque2(int k) {
        this.tables = new int[k];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    private int forward(int index) {
        return index == 0 ? tables.length - 1 : index - 1;
    }

    private int backword(int index) {
        return index == tables.length - 1 ? 0 : index + 1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        }
        this.head = this.forward(head);
        if (this.isEmpty()) {
            // 数组实现的关键是保证 插入第一个节点时 ，头尾指针一致。
            tail = head;
        }

        tables[head] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        this.tail = this.backword(tail);
        if (this.isEmpty()) {
            head = tail;
        }

        tables[tail] = value;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.isEmpty()) {
            return false;
        }

        this.head = backword(head);
        size--;
//        if (this.isEmpty()) {
//            tail = head;
//        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (this.isEmpty()) {
            return false;
        }
        this.tail = forward(tail);
        size--;
//        if (this.isEmpty()) {
//            head = tail;
//        }
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (this.isEmpty()) {
            return -1;
        }
        return tables[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (this.isEmpty()) {
            return -1;
        }
        return tables[tail];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == tables.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

public class ArrayDeque<T>{
    private T[] items;
    private int size;
    private int capacity = 8;

    public ArrayDeque() {
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public void addFirst(T item) {
        if (isFull()) {
            resize(capacity * 2);
        }
        T[] a = (T []) new Object[capacity];
        a[0] = item;
        System.arraycopy(items, 0, a, 1, size);
        items = a;
        size++;
    }

     public void addLast(T item) {
        items[size] = item;
        size++;
}
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int x) {
        T[] a = (T[]) new Object[x];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
        capacity = x;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(items[i]);
                break;
            } else {
                System.out.println(items[i] + " ");
            }
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (isFull()) {
            resize(capacity * 2);
        }
        T[] a = (T []) new Object[capacity];
        T res = items[0];
        System.arraycopy(items, 1, a, 0, size - 1);
        items = a;
        size--;
        return res;
    }

    public T removeLast() {
        if (size == 0)  {
            return null;
        }
        if (isFull()) {
            resize(capacity * 2);
        }
        T[] a = (T []) new Object[capacity];
        T res = items[size - 1];
        System.arraycopy(items, 0, a, 0, size - 1);
        items = a;
        size--;
        return res;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[index];
    }
}

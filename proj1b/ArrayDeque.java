public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int capacity = 8;

    public ArrayDeque() {
        items = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
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

    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize(capacity * 2);
        }
        T[] a = (T []) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
        items[size] = item;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int x) {
        T[] a = (T[]) new Object[x];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
        capacity = x;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isOverSpace() {
        return size < (capacity / 2);
    }

    @Override
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

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (isFull()) {
            resize(capacity * 2);
        }
        if (isOverSpace()) {
            resize(capacity / 2);
        }
        T[] a = (T []) new Object[capacity];
        T res = items[0];
        System.arraycopy(items, 1, a, 0, size - 1);
        items = a;
        size--;
        return res;
    }

    @Override
    public T removeLast() {
        if (size == 0)  {
            return null;
        }
        if (isFull()) {
            resize(capacity * 2);
        }
        if (isOverSpace()) {
            resize(capacity / 2);
        }
        T[] a = (T []) new Object[capacity];
        T res = items[size - 1];
        System.arraycopy(items, 0, a, 0, size - 1);
        items = a;
        size--;
        return res;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0 || isEmpty()) {
            return null;
        }
        return items[index];
    }
}

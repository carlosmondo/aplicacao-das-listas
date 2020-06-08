package br.univille;


import java.util.NoSuchElementException;

public class SLinkedList<T> {
    protected Node<T> head;
    protected Node<T> tail;
    protected long size;

    public SLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public long size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void clear() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public T getFirst() {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty.");

        return this.head.getValue();
    }

    public T getLast() {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty.");

        return this.tail.getValue();
    }

    public void addFirst(T value) {
        Node<T> first = new Node<T>(value, this.head);

        if (this.head == null) this.tail = first;

        this.head = first;
        this.size++;
    }

    public void addLast(T value) {
        if (this.head == null) {
            this.addFirst(value);
        } else {
            Node<T> last = new Node<T>(value, null);
            this.tail.setNext(last);
            this.tail = last;
            this.size++;
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty");

        T value = this.head.getValue();
        this.head = head.getNext();
        this.size--;

        return value;
    }

    public T removeLast() {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty");

        T value = this.tail.getValue();
        Node<T> temp = this.head;

        while (temp.getNext() != null && temp.getNext() != this.tail) {
            temp = temp.getNext();
        }
        temp.setNext(null);

        this.tail = temp;
        this.tail.setNext(null);
        this.size--;

        return value;
    }

    public boolean contains(T value) {
        Node<T> temp = this.head;
        while (temp != null) {
            if (temp.getValue().equals(value)) {
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }

    public Object[] toArray() {
        Object[] array = new Object[(int) this.size];
        Node<T> temp = this.head;

        for (int i = 0; i < this.size; i++) {
            array[i] = temp.getValue();
            temp = temp.getNext();
        }

        return array;
    }

    public T get(int index) {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty.");
        if (index > (this.size - 1)) throw new NoSuchElementException("Index out of list.");

        if (index == 0) return this.getFirst();
        if (index == (this.size - 1)) return this.getLast();

        int actual_index = 0;
        Node<T> temp = this.head;

        while (actual_index < index && temp.getNext() != null && temp.getNext() != this.tail) {
            temp = temp.getNext();
            actual_index++;
        }

        return temp.getValue();
    }

    public T remove(int index) {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty");
        if (index > (this.size - 1)) throw new NoSuchElementException("Index out of list");

        if (index == 0) return this.removeFirst();
        if (index == (this.size - 1)) return this.removeLast();

        int actual_index = 0;
        Node<T> after_removed = this.head;
        Node<T> before_removed = null;
        T value = null;

        while (actual_index < index && after_removed.getNext() != null) {
            before_removed = after_removed;
            after_removed = after_removed.getNext();
            actual_index++;
        }

        value = after_removed.getValue();
        after_removed = after_removed.getNext();
        before_removed.setNext(after_removed);
        this.size--;

        return value;
    }

    /* Ao adicionar na ultima posição, exemplo: deve adicionar na posição 6 e empurrar
     o item da posição 6 para a 7, ou ao adicionar na posição 6, o item estará na posição
     7?
    * */
    public void add(int index, T value) {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty");
        if (index > (this.size - 1)) throw new NoSuchElementException("Index out of list");

        if (index == 0) {
            this.addFirst(value);
            return;
        }

        if (index == (this.size - 1)) {
            this.addLast(value);
            return;
        }

        int actual_index = 0;
        Node<T> before_add = new Node<T>();
        Node<T> after_temp = this.head;

        while (actual_index < index && after_temp.getNext() != null) {
            before_add = after_temp;
            after_temp = after_temp.getNext();
            actual_index++;
        }

        Node<T> value_node = new Node<T>(value, after_temp);
        before_add.setNext(value_node);

        this.size++;
    }

    public void set(int index, T value) {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty");
        if (index > (this.size - 1)) throw new NoSuchElementException("Index out of list");

        if (index == 0) {
            this.head.setValue(value);
            return;
        }

        if (index == (this.size - 1)) {
            this.tail.setValue(value);
            return;
        }

        int actual_index = 0;
        Node<T> after_temp = this.head;

        while (actual_index < index && after_temp.getNext() != null) {
            after_temp = after_temp.getNext();
            actual_index++;
        }
        after_temp.setValue(value);
    }
}
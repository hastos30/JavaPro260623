package main.java.lesson9.task1;

import java.util.*;

public class MyLinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (T item : this) {
            array[i++] = item;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }

        int i = 0;
        for (T item : this) {
            //noinspection unchecked
            a[i++] = (T1) item;
        }

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node<T> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<T> newNode = new Node<>(element);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }

        if (Objects.equals(head.data, o)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.data, o)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        T removedElement;
        if (index == 0) {
            removedElement = head.data;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedElement = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removedElement;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T item : c) {
            add(item);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (c.isEmpty()) {
            return false;
        }

        List<T> tempList = new ArrayList<>(c);
        if (index == 0) {
            Node<T> newHead = new Node<>(tempList.get(0));
            Node<T> current = newHead;
            for (int i = 1; i < tempList.size(); i++) {
                Node<T> newNode = new Node<>(tempList.get(i));
                current.next = newNode;
                current = newNode;
            }
            current.next = head;
            head = newHead;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<T> oldNext = current.next;
            Node<T> newHead = new Node<>(tempList.get(0));
            Node<T> tempCurrent = newHead;
            for (int i = 1; i < tempList.size(); i++) {
                Node<T> newNode = new Node<>(tempList.get(i));
                tempCurrent.next = newNode;
                tempCurrent = newNode;
            }
            current.next = newHead;
            tempCurrent.next = oldNext;
        }
        size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object item : c) {
            modified |= remove(item);
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node<T> current = head;
        while (current != null) {
            if (!c.contains(current.data)) {
                remove(current.data);
                modified = true;
            }
            current = current.next;
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T oldData = current.data;
        current.data = element;
        return oldData;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> current = head;
        int lastIndex = -1;
        int index = 0;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                lastIndex = index;
            }
            current = current.next;
            index++;
        }
        return lastIndex;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

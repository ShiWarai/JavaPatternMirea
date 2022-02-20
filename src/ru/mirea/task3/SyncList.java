package ru.mirea.task3;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncList<T> implements List<T> {

    private volatile List<T> list;
    private final Lock lock = new ReentrantLock();

    public SyncList() {
        this.list = new LinkedList<>();
    }

    @Override
    public int size() {
        int value;
        lock.lock();
        value = this.list.size();
        lock.unlock();
        return value;
    }

    @Override
    public boolean isEmpty() {
        boolean value;
        lock.lock();
        value = this.list.isEmpty();
        lock.unlock();
        return value;
    }

    @Override
    public boolean contains(Object o) {
        boolean value;
        lock.lock();
        value = this.list.contains(o);
        lock.unlock();
        return value;
    }

    @Override
    public Iterator iterator() {
        Iterator value;
        lock.lock();
        value = this.list.iterator();
        lock.unlock();
        return value;
    }

    @Override
    public Object[] toArray() {
        Object[] value;
        lock.lock();
        value = this.list.toArray();
        lock.unlock();
        return value;
    }

    @Override
    public boolean add(T o) {
        boolean value;
        lock.lock();
        value = this.list.add(o);
        lock.unlock();
        return value;
    }

    @Override
    public boolean remove(Object o) {
        boolean value;
        lock.lock();
        value = this.list.remove(o);
        lock.unlock();
        return value;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean value;
        lock.lock();
        value = this.list.addAll(c);
        lock.unlock();
        return value;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        boolean value;
        lock.lock();
        value = this.list.addAll(index, c);
        lock.unlock();
        return value;
    }

    @Override
    public void clear() {
        lock.lock();
        this.list.clear();
        lock.unlock();
    }

    @Override
    public T get(int index) {
        T value;
        lock.lock();
        value = this.list.get(index);
        lock.unlock();
        return value;
    }

    @Override
    public T set(int index, T element) {
        T value;
        lock.lock();
        value = this.list.set(index, element);
        lock.unlock();
        return value;
    }

    @Override
    public void add(int index, T element) {
        lock.lock();
        this.list.add(index, element);
        lock.unlock();
    }

    @Override
    public T remove(int index) {
        T value;
        lock.lock();
        value = this.list.remove(index);
        lock.unlock();
        return value;
    }

    @Override
    public int indexOf(Object o) {
        int value;
        lock.lock();
        value = this.list.indexOf(o);
        lock.unlock();
        return value;
    }

    @Override
    public int lastIndexOf(Object o) {
        int value;
        lock.lock();
        value = this.list.lastIndexOf(o);
        lock.unlock();
        return value;
    }

    @Override
    public ListIterator listIterator() {
        ListIterator value;
        lock.lock();
        value = this.list.listIterator();
        lock.unlock();
        return value;
    }

    @Override
    public ListIterator listIterator(int index) {
        ListIterator value;
        lock.lock();
        value = this.list.listIterator();
        lock.unlock();
        return value;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        List value;
        lock.lock();
        value = this.list.subList(fromIndex, toIndex);
        lock.unlock();
        return value;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean value;
        lock.lock();
        value = this.list.retainAll(c);
        lock.unlock();
        return value;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean value;
        lock.lock();
        value = this.list.removeAll(c);
        lock.unlock();
        return value;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean value;
        lock.lock();
        value = this.list.containsAll(c);
        lock.unlock();
        return value;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] value;
        lock.lock();
        value = this.list.toArray(a);
        lock.unlock();
        return value;
    }
}

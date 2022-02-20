package ru.mirea.task3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SyncSet<T> implements Set<T> {

    private volatile Set<T> set;

    public SyncSet() {
        this.set = new HashSet<T>();
    }

    @Override
    public synchronized int size() {
        return this.set.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return this.set.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return this.set.contains(o);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return this.set.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return this.set.toArray();
    }

    @Override
    public synchronized <T1> T1[] toArray(T1[] a) {
        return this.set.toArray(a);
    }

    @Override
    public synchronized boolean add(T t) {
        return this.set.add(t);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return this.set.remove(o);
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return this.set.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends T> c) {
        return this.set.addAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return this.set.retainAll(c);
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return this.set.removeAll(c);
    }

    @Override
    public synchronized void clear() {
        this.set.clear();
        return;
    }
}

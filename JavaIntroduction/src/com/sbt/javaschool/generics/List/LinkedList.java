package com.sbt.javaschool.generics.List;

import java.util.Collection;
import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;

    public void add(E e) {
        tail = new Node<>(e, tail, null);

        if (tail.getPrev() == null) {
            head = tail;
        } else {
            tail.getPrev().setNext(tail);
        }
    }

    public void addFirst(E e) {
        head = new Node<>(e, null, head);

        if (tail.getNext() == null) {
            tail = head;
        } else {
            head.getNext().setPrev(head);
        }
    }

    public void add(int index, E e) {
        Node<E> cur = head;

        for (int i = 0; i < index; i++) {
            if (cur == null)
                throw new IndexOutOfBoundsException();
            cur = cur.getNext();
        }

        if (cur == head) {
            addFirst(e);
        } else if (cur == tail) {
            add(e);
        } else {
            cur.getPrev().setNext(new Node<E>(e, cur.getPrev(), cur));
            cur.setPrev(cur.getPrev().getNext());
        }
    }

    public E get(int index) {
        Node<E> cur = head;

        for (int i = 0; i < index; i++) {
            if (cur == null)
                throw new IndexOutOfBoundsException();
            cur = cur.getNext();
        }
        return cur.getElement();
    }

    public E removeFirst() {

        E removeElement = head.getElement();

        head = head.getNext();

        if (head == null) {
            tail = null;
        }

        return removeElement;
    }

    public E removeLast() {

        E removeElement = tail.getElement();

        tail = tail.getPrev();

        if (tail == null) {
            head = null;
        }

        return removeElement;
    }

    public E remove(int index) {
        Node<E> cur = head;

        for (int i = 0; i < index; i++) {
            if (cur == null)
                throw new IndexOutOfBoundsException();
            cur = cur.getNext();
        }

        if (cur == head) {
            return removeFirst();
        } else if (cur == tail) {
            return removeLast();
        } else {
            E removeElement = cur.getElement();

            cur.getPrev().setNext(cur.getNext());
            cur.getNext().setPrev(cur.getPrev());

            return removeElement;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> cur = head;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public E next() {
                E element = cur.getElement();
                cur = cur.getNext();
                return element;
            }
        };
    }

    public int size(){
        int size = 0;

        for (E element:this) {
            size++;
        }

        return size;
    }

    public boolean addAll(Collection<? extends E> source) {

        int size = source.size();

        for (E element : source) {
            add(element);
        };

        return this.size()>size;
    }

    public boolean copy(Collection<? super E> destination) {

        int size = destination.size();

        for (E element : this) {
            destination.add(element);
        };

        return destination.size()>size;
    }

}

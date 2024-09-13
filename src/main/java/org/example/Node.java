package org.example;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


/**
 * Реализация базовой структуры односвязного списка
 * При необходимости, можно доработать реализацию
 *
 * @param <T>
 */
@Getter
@Setter
public class Node<T> implements Iterable<T> {

    private T value;

    private Node<T> next;
    @Setter(AccessLevel.NONE)
    @Accessors(fluent = true)
    private int size;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.size = 1;
    }

    public Node<T> add(T value) {
        Node<T> emptyNode = this;
        while (emptyNode.getNext() != null) {
            emptyNode = emptyNode.getNext();
        }
        Node<T> newNode = new Node<>(value);
        emptyNode.setNext(newNode);

        ++size;
        return newNode;
    }

    public Stream<T> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    @Override
    public Iterator<T> iterator() {
        return new NodeIterator<>(this);
    }

    static class NodeIterator<T> implements Iterator<T> {
        private Node<T> current;

        public NodeIterator(Node<T> node) {
            current = node;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T data = current.getValue();
            current = current.getNext();
            return data;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
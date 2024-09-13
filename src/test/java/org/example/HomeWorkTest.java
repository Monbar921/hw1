package org.example;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {
    private final HomeWork homeWork = new HomeWork();

    @Test
    void partitionBy_lessThanFour() {
        Predicate<Integer> predicate = x -> x < 4;

        Node<Integer> node = new Node<>(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);

        assertEquals(3, homeWork.partitionBy(node, predicate));
    }

    @Test
    void partitionBy_lessThanFour_notSorted() {
        Predicate<Integer> predicate = x -> x < 4;

        Node<Integer> node = new Node<>(1);
        node.add(2);
        node.add(4);
        node.add(3);
        node.add(2);

        assertEquals(2, homeWork.partitionBy(node, predicate));
    }


    @Test
    void partitionBy_lessThanZero() {
        Predicate<Integer> predicate = x -> x < 0;

        Node<Integer> node = new Node<>(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);

        assertEquals(0, homeWork.partitionBy(node, predicate));
    }

    @Test
    void findNthElement_first() {
        Node<Integer> node = new Node<>(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);

        assertEquals(1, homeWork.findNthElement(node, 0));
    }

    @Test
    void findNthElement_last() {
        Node<Integer> node = new Node<>(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);

        assertEquals(5, homeWork.findNthElement(node, 4));
    }
}
package org.example;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.StreamSupport;

/**
 * Сигнатуры методов в данном классе не менять
 */
public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Реализовать метод, который подсчитывает количество подходящих по условию узлов от 0 до N.
     * <br/>
     * Пример 1:
     * список 1, 2, 3, 4, 5
     * условие x < 4
     * ответ 3
     * <br/>
     * Пример 2:
     * список 1, 2, 3, 4, 5
     * условие x < 0
     * ответ 0
     *
     * @param list односвязный список
     * @param pred условие
     * @param <T>  - тип хранимых значений в списке
     * @return количество узлов от 0 до N, где N позиция на которой первый раз условие вернуло fals
     */
    public <T> int partitionBy(Node<T> list, Predicate<T> pred) {
        if(list == null || pred == null){
            throw new IllegalArgumentException();
        }
        return (int) list.stream().takeWhile(pred).count();
    }

    /**
     * <h1>Задание 2.</h1>
     * Реализовать метод поиска элемента на позиции N в переданном односвязном списке.
     *
     * @param list односвязный список
     * @param n    позиция искомого элемента
     * @param <T>
     * @return сам элемент
     */
    public <T> T findNthElement(Node<T> list, int n) {
        AtomicInteger currentIndex = new AtomicInteger(0);

        if(list == null){
            throw new IllegalArgumentException();
        }

        if(n < 0 || n >= list.size()){
            throw new IndexOutOfBoundsException();
        }

        Optional<T> element = list.stream()
                .filter(e -> currentIndex.getAndIncrement() == n)
                .findFirst();

        return element.orElse(null);
    }
}

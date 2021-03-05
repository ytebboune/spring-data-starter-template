package com.commonstarter.common.utils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author : Xavier PHILIPPONNEAU
 *
 * Utility class for redondant operations on Collections
 */
public class CollectionUtils {

    /**
     * Check a collection is empty with safe operations
     * @param col
     * @param <T>
     * @return
     */
    public static <T> boolean isEmptySafe(Collection<T> col){
        return null == col || col.size() == 0;
    }

    /**
     * Check a collection is not empty with safe operations
     * @param col
     * @param <T>
     * @return
     */
    public static <T> boolean isNotEmptySafe(Collection<T> col){
        return !isEmptySafe(col);
    }

    /**
     * returns a new List if input collection not null
     * @param col
     * @param <T>
     * @return
     */
    public static <T> Collection<T> getCollectionSafe(Collection<T> col){
        return null == col ? new ArrayList<>() : col;
    }

    /**
     * Returns a new Collection from supplier if input collection is null
     * @param col
     * @param supplier
     * @param <T>
     * @return
     */
    public static <T> Collection<T> getSafe(Collection<T> col, Supplier<Collection<T>> supplier){
        return null == col ? supplier.get() : col;
    }

    /**
     * Simple shortcut for a stream::filter operation
     * @param col
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(Collection<T> col, Predicate<T> predicate) {
        return getSafe(col, ArrayList::new)
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    /**
     * Map a collection containing T elements to a List containing U elements
     * @param col
     * @param mapper
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> List<U> map(Collection<T> col, Function<T, U> mapper){
        return getCollectionSafe(col)
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    /**
     * Map a collection containing T elements to a Set containing U elements
     * @param col
     * @param mapper
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> Set<U> mapToSet(Collection<T> col, Function<T, U> mapper){
        return getCollectionSafe(col)
                .stream()
                .map(mapper)
                .collect(Collectors.toSet());
    }


    /**
     * Provides an easy way to concat collections and map to another type
     *
     * @param mapper
     * @param supplier
     * @param cols multiple collections of same type
     * @param <T> input type
     * @param <U> output type
     * @return
     */
    public static <T, U> Collection<U> concatAndMap(Function<T, U> mapper, Supplier<Collection<U>> supplier, Collection<T> ...cols){
        return Stream.of(cols)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .map(mapper)
                .collect(Collectors.toCollection(supplier));
    }

    /**
     * Concat multiple lists in a single one
     * @param cols
     * @param <T>
     * @return
     */
    public static <T> List<T> concatToList(Collection<T> ...cols){
        return Stream.of(cols)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


}

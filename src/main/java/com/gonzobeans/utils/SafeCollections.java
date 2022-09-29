package com.gonzobeans.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/**
 * Access collections with null safety, particularly useful in streams.
 * @author David Lerner
 */
@SuppressWarnings("unused")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SafeCollections {

    /**
     * Provides an empty list if the input is null, but otherwise returns the provided input.
     *
     * @param list the input list
     * @return the input, or an empty list if the input is null
     */
    public static <E> List<E> safeList(List<E> list) {
        return Objects.nonNull(list) ? list : Collections.emptyList();
    }

    /**
     * Provides an empty set if the input is null, but otherwise returns the provided input.
     *
     * @param set the input set
     * @return the input, or an empty set if the input is null
     */
    public static <E> Set<E> safeSet(Set<E> set) {
        return Objects.nonNull(set) ? set : Collections.emptySet();
    }

    /**
     * Provides an empty sorted set if the input is null, but otherwise returns the provided input.
     *
     * @param set the input set
     * @return the input, or an empty sorted set if the input is null
     */
    public static <E> SortedSet<E> safeSortedSet(SortedSet<E> set) {
        return Objects.nonNull(set) ? set : Collections.emptySortedSet();
    }

    /**
     * Provides an empty navigable set if the input is null, but otherwise returns the provided input.
     *
     * @param set the input set
     * @param <E> the input set type
     * @return the input, or an empty navigable set if the input is null
     */
    public static <E> NavigableSet<E> safeNavigableSet(NavigableSet<E> set) {
        return Objects.nonNull(set) ? set : Collections.emptyNavigableSet();
    }

    /**
     * Provides an empty map if the input is null, but otherwise returns the provided input.
     * @param map the input map
     * @param <K> the map key type
     * @param <V> the map value type
     * @return the input, or an empty map if the input is null
     */
    public static <K, V> Map<K, V> safeMap(Map<K, V> map) {
        return Objects.nonNull(map) ? map : Collections.emptyMap();
    }

    /**
     * Provides an empty sorted map if the input is null, but otherwise returns the provided input.
     * @param map the input map
     * @param <K> the map key type
     * @param <V> the map value type
     * @return the input, or an empty sorted map if the input is null
     */
    public static <K, V> SortedMap<K, V> safeSortedMap(SortedMap<K, V> map) {
        return Objects.nonNull(map) ? map : Collections.emptySortedMap();
    }

    /**
     * Provides an empty navigable map if the input is null, but otherwise returns the provided input.
     * @param map the input map
     * @param <K> the map key type
     * @param <V> the map value type
     * @return the input, or an empty navigable map if the input is null
     */
    public static <K, V> NavigableMap<K, V> safeNavigableMap(NavigableMap<K, V> map) {
        return Objects.nonNull(map) ? map : Collections.emptyNavigableMap();
    }

    /**
     * Provides an empty enumeration if the input is null, but otherwise returns the provided input.
     * @param enumeration the input enumeration
     * @return the input, or an empty enumeration if the input is null
     */
    public static <E> Enumeration<E> safeEnumeration(Enumeration<E> enumeration) {
        return Objects.nonNull(enumeration) ? enumeration : Collections.emptyEnumeration();
    }
}

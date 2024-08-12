/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ArrayMap
 *  androidx.collection.ArraySet
 */
package com.google.android.gms.common.util;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        if (collection != null) return collection.isEmpty();
        return true;
    }

    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @Deprecated
    public static <T> List<T> listOf(T t) {
        return Collections.singletonList(t);
    }

    @Deprecated
    public static <T> List<T> listOf(T ... TArray) {
        int n = TArray.length;
        if (n == 0) return CollectionUtils.listOf();
        if (n == 1) return CollectionUtils.listOf(TArray[0]);
        return Collections.unmodifiableList(Arrays.asList(TArray));
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3) {
        Map<K, V> map = CollectionUtils.zzb(3, false);
        map.put(k, v);
        map.put(k2, v2);
        map.put(k3, v3);
        return Collections.unmodifiableMap(map);
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map<K, V> map = CollectionUtils.zzb(6, false);
        map.put(k, v);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        return Collections.unmodifiableMap(map);
    }

    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] object, V[] VArray) {
        int n = ((K[])object).length;
        int n2 = VArray.length;
        if (n != n2) {
            object = new StringBuilder(66);
            ((StringBuilder)object).append("Key and values array lengths not equal: ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(" != ");
            ((StringBuilder)object).append(n2);
            object = new IllegalArgumentException(((StringBuilder)object).toString());
            throw object;
        }
        if (n == 0) return Collections.emptyMap();
        n2 = 0;
        if (n == 1) return Collections.singletonMap(object[0], VArray[0]);
        Map<Object, V> map = CollectionUtils.zzb(n, false);
        while (n2 < ((Object)object).length) {
            map.put(object[n2], VArray[n2]);
            ++n2;
        }
        return Collections.unmodifiableMap(map);
    }

    public static <T> Set<T> mutableSetOfWithSize(int n) {
        Object object = n == 0 ? new ArraySet() : CollectionUtils.zza(n, true);
        return object;
    }

    @Deprecated
    public static <T> Set<T> setOf(T t, T t2, T t3) {
        Set<T> set = CollectionUtils.zza(3, false);
        set.add(t);
        set.add(t2);
        set.add(t3);
        return Collections.unmodifiableSet(set);
    }

    @Deprecated
    public static <T> Set<T> setOf(T ... object) {
        int n = ((T[])object).length;
        if (n == 0) return Collections.emptySet();
        if (n == 1) return Collections.singleton(object[0]);
        if (n == 2) {
            T t = object[0];
            T t2 = object[1];
            object = CollectionUtils.zza(2, false);
            object.add(t);
            object.add(t2);
            return Collections.unmodifiableSet(object);
        }
        if (n == 3) return CollectionUtils.setOf(object[0], object[1], object[2]);
        if (n != 4) {
            Set<T> set = CollectionUtils.zza(n, false);
            Collections.addAll(set, object);
            return Collections.unmodifiableSet(set);
        }
        T t = object[0];
        T t3 = object[1];
        Object object2 = object[2];
        Object object3 = object[3];
        object = CollectionUtils.zza(4, false);
        object.add(t);
        object.add(t3);
        object.add(object2);
        object.add(object3);
        return Collections.unmodifiableSet(object);
    }

    private static <T> Set<T> zza(int n, boolean bl) {
        float f = true != bl ? 1.0f : 0.75f;
        int n2 = true != bl ? 256 : 128;
        Object object = n <= n2 ? new ArraySet(n) : new HashSet(n, f);
        return object;
    }

    private static <K, V> Map<K, V> zzb(int n, boolean bl) {
        Object object = n <= 256 ? new ArrayMap(n) : new HashMap(n, 1.0f);
        return object;
    }
}

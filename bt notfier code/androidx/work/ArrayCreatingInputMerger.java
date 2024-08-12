/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Data
 *  androidx.work.Data$Builder
 *  androidx.work.InputMerger
 */
package androidx.work;

import androidx.work.Data;
import androidx.work.InputMerger;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ArrayCreatingInputMerger
extends InputMerger {
    private Object concatenateArrayAndNonArray(Object object, Object object2) {
        int n = Array.getLength(object);
        Object object3 = Array.newInstance(object2.getClass(), n + 1);
        System.arraycopy(object, 0, object3, 0, n);
        Array.set(object3, n, object2);
        return object3;
    }

    private Object concatenateArrays(Object object, Object object2) {
        int n = Array.getLength(object);
        int n2 = Array.getLength(object2);
        Object object3 = Array.newInstance(object.getClass().getComponentType(), n + n2);
        System.arraycopy(object, 0, object3, 0, n);
        System.arraycopy(object2, 0, object3, n, n2);
        return object3;
    }

    private Object concatenateNonArrays(Object object, Object object2) {
        Object object3 = Array.newInstance(object.getClass(), 2);
        Array.set(object3, 0, object);
        Array.set(object3, 1, object2);
        return object3;
    }

    private Object createArrayFor(Object object) {
        Object object2 = Array.newInstance(object.getClass(), 1);
        Array.set(object2, 0, object);
        return object2;
    }

    public Data merge(List<Data> object) {
        Data.Builder builder = new Data.Builder();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Iterator<Data> iterator = object.iterator();
        block0: while (true) {
            if (!iterator.hasNext()) {
                builder.putAll(hashMap);
                return builder.build();
            }
            Iterator iterator2 = iterator.next().getKeyValueMap().entrySet().iterator();
            while (true) {
                if (!iterator2.hasNext()) continue block0;
                object = iterator2.next();
                String string = (String)object.getKey();
                object = object.getValue();
                Class<?> clazz = object.getClass();
                Object v = hashMap.get(string);
                if (v == null) {
                    if (!clazz.isArray()) {
                        object = this.createArrayFor(object);
                    }
                } else {
                    Class<?> clazz2 = v.getClass();
                    if (clazz2.equals(clazz)) {
                        object = clazz2.isArray() ? this.concatenateArrays(v, object) : this.concatenateNonArrays(v, object);
                    } else if (clazz2.isArray() && clazz2.getComponentType().equals(clazz)) {
                        object = this.concatenateArrayAndNonArray(v, object);
                    } else {
                        if (!clazz.isArray()) throw new IllegalArgumentException();
                        if (!clazz.getComponentType().equals(clazz2)) throw new IllegalArgumentException();
                        object = this.concatenateArrayAndNonArray(object, v);
                    }
                }
                hashMap.put(string, object);
            }
            break;
        }
    }
}

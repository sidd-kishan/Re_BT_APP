/*
 * Decompiled with CFR 0.152.
 */
package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class SpreadBuilder {
    private final ArrayList<Object> list;

    public SpreadBuilder(int n) {
        this.list = new ArrayList(n);
    }

    public void add(Object object) {
        this.list.add(object);
    }

    public void addSpread(Object object) {
        if (object == null) {
            return;
        }
        if (object instanceof Object[]) {
            Object[] objectArray = (Object[])object;
            if (objectArray.length <= 0) return;
            object = this.list;
            ((ArrayList)object).ensureCapacity(((ArrayList)object).size() + objectArray.length);
            Collections.addAll(this.list, objectArray);
        } else if (object instanceof Collection) {
            this.list.addAll((Collection)object);
        } else {
            if (object instanceof Iterable) {
                Iterator iterator = ((Iterable)object).iterator();
                while (iterator.hasNext()) {
                    object = iterator.next();
                    this.list.add(object);
                }
                return;
            }
            if (!(object instanceof Iterator)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Don't know how to spread ");
                stringBuilder.append(object.getClass());
                object = new UnsupportedOperationException(stringBuilder.toString());
                throw object;
            }
            object = (Iterator)object;
            while (object.hasNext()) {
                this.list.add(object.next());
            }
            return;
        }
    }

    public int size() {
        return this.list.size();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.list.toArray(objectArray);
    }
}

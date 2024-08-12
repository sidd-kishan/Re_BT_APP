/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package org.greenrobot.eventbus.util;

import android.util.Log;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExceptionToResourceMapping {
    public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap = new HashMap<Class<? extends Throwable>, Integer>();

    public ExceptionToResourceMapping addMapping(Class<? extends Throwable> clazz, int n) {
        this.throwableToMsgIdMap.put(clazz, n);
        return this;
    }

    public Integer mapThrowable(Throwable throwable) {
        Serializable serializable;
        int n = 20;
        Serializable serializable2 = throwable;
        do {
            if ((serializable = this.mapThrowableFlat((Throwable)serializable2)) != null) {
                return serializable;
            }
            serializable = ((Throwable)serializable2).getCause();
            if (--n <= 0 || serializable == throwable) break;
            serializable2 = serializable;
        } while (serializable != null);
        serializable2 = new StringBuilder();
        ((StringBuilder)serializable2).append("No specific message resource ID found for ");
        ((StringBuilder)serializable2).append(throwable);
        Log.d((String)"EventBus", (String)((StringBuilder)serializable2).toString());
        return null;
    }

    protected Integer mapThrowableFlat(Throwable serializable) {
        Class<?> clazz = serializable.getClass();
        serializable = this.throwableToMsgIdMap.get(clazz);
        Serializable serializable2 = serializable;
        if (serializable != null) return serializable2;
        Serializable serializable3 = null;
        Iterator<Map.Entry<Class<? extends Throwable>, Integer>> iterator = this.throwableToMsgIdMap.entrySet().iterator();
        while (true) {
            serializable2 = serializable;
            if (!iterator.hasNext()) return serializable2;
            Map.Entry<Class<? extends Throwable>, Integer> entry = iterator.next();
            serializable2 = entry.getKey();
            if (!((Class)serializable2).isAssignableFrom(clazz) || serializable3 != null && !serializable3.isAssignableFrom((Class<?>)serializable2)) continue;
            serializable = entry.getValue();
            serializable3 = serializable2;
        }
    }
}

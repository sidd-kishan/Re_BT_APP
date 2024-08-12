/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  com.google.android.gms.common.api.internal.ListenerHolder
 *  com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class ListenerHolders {
    private final Set<ListenerHolder<?>> zaa = Collections.newSetFromMap(new WeakHashMap());

    public static <L> ListenerHolder<L> createListenerHolder(L l, Looper looper, String string) {
        Preconditions.checkNotNull(l, (Object)"Listener must not be null");
        Preconditions.checkNotNull((Object)looper, (Object)"Looper must not be null");
        Preconditions.checkNotNull((Object)string, (Object)"Listener type must not be null");
        return new ListenerHolder(looper, l, string);
    }

    public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L l, String string) {
        Preconditions.checkNotNull(l, (Object)"Listener must not be null");
        Preconditions.checkNotNull((Object)string, (Object)"Listener type must not be null");
        Preconditions.checkNotEmpty((String)string, (Object)"Listener type must not be empty");
        return new ListenerHolder.ListenerKey(l, string);
    }

    public final <L> ListenerHolder<L> zaa(L object, Looper looper, String string) {
        object = ListenerHolders.createListenerHolder(object, looper, "NO_TYPE");
        this.zaa.add((ListenerHolder<?>)object);
        return object;
    }

    public final void zab() {
        Iterator<ListenerHolder<?>> iterator = this.zaa.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zaa.clear();
                return;
            }
            iterator.next().clear();
        }
    }
}

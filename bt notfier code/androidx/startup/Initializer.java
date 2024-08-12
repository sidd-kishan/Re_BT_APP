/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.startup;

import android.content.Context;
import java.util.List;

public interface Initializer<T> {
    public T create(Context var1);

    public List<Class<? extends Initializer<?>>> dependencies();
}

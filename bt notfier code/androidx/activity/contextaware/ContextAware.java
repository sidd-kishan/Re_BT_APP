/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.activity.contextaware.OnContextAvailableListener
 */
package androidx.activity.contextaware;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;

public interface ContextAware {
    public void addOnContextAvailableListener(OnContextAvailableListener var1);

    public Context peekAvailableContext();

    public void removeOnContextAvailableListener(OnContextAvailableListener var1);
}

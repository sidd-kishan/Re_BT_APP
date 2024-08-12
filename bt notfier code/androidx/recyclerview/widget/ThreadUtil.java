/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
 *  androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ThreadUtil;

interface ThreadUtil<T> {
    public BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> var1);

    public MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> var1);
}

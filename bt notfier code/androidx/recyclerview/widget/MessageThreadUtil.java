/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.ThreadUtil
 *  androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
 *  androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ThreadUtil;

class MessageThreadUtil<T>
implements ThreadUtil<T> {
    MessageThreadUtil() {
    }

    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }
}

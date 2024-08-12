/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.manager.Lifecycle
 *  com.bumptech.glide.manager.RequestManagerTreeNode
 */
package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;

public static interface RequestManagerRetriever.RequestManagerFactory {
    public RequestManager build(Glide var1, Lifecycle var2, RequestManagerTreeNode var3, Context var4);
}

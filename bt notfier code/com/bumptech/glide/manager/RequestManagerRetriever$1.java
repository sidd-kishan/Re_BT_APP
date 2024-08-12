/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.manager.Lifecycle
 *  com.bumptech.glide.manager.RequestManagerRetriever$RequestManagerFactory
 *  com.bumptech.glide.manager.RequestManagerTreeNode
 */
package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerTreeNode;

class RequestManagerRetriever.1
implements RequestManagerRetriever.RequestManagerFactory {
    RequestManagerRetriever.1() {
    }

    public RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
    }
}

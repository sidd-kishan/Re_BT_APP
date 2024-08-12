/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.RequestManager
 */
package com.bumptech.glide.manager;

import com.bumptech.glide.RequestManager;
import java.util.Set;

public interface RequestManagerTreeNode {
    public Set<RequestManager> getDescendants();
}

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.manager.RequestManagerTreeNode
 */
package com.bumptech.glide.manager;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import java.util.Collections;
import java.util.Set;

final class EmptyRequestManagerTreeNode
implements RequestManagerTreeNode {
    EmptyRequestManagerTreeNode() {
    }

    public Set<RequestManager> getDescendants() {
        return Collections.emptySet();
    }
}

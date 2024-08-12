/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.manager.RequestManagerFragment
 *  com.bumptech.glide.manager.RequestManagerTreeNode
 */
package com.bumptech.glide.manager;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerFragment;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import java.util.HashSet;
import java.util.Set;

private class RequestManagerFragment.FragmentRequestManagerTreeNode
implements RequestManagerTreeNode {
    final RequestManagerFragment this$0;

    RequestManagerFragment.FragmentRequestManagerTreeNode(RequestManagerFragment requestManagerFragment) {
        this.this$0 = requestManagerFragment;
    }

    public Set<RequestManager> getDescendants() {
        Object object = this.this$0.getDescendantRequestManagerFragments();
        HashSet<RequestManager> hashSet = new HashSet<RequestManager>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            RequestManagerFragment requestManagerFragment = (RequestManagerFragment)object.next();
            if (requestManagerFragment.getRequestManager() == null) continue;
            hashSet.add(requestManagerFragment.getRequestManager());
        }
        return hashSet;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{fragment=");
        stringBuilder.append(this.this$0);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

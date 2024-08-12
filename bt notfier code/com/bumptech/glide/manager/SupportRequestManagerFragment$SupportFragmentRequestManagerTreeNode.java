/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.manager.RequestManagerTreeNode
 *  com.bumptech.glide.manager.SupportRequestManagerFragment
 */
package com.bumptech.glide.manager;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import java.util.HashSet;
import java.util.Set;

private class SupportRequestManagerFragment.SupportFragmentRequestManagerTreeNode
implements RequestManagerTreeNode {
    final SupportRequestManagerFragment this$0;

    SupportRequestManagerFragment.SupportFragmentRequestManagerTreeNode(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.this$0 = supportRequestManagerFragment;
    }

    public Set<RequestManager> getDescendants() {
        Object object = this.this$0.getDescendantRequestManagerFragments();
        HashSet<RequestManager> hashSet = new HashSet<RequestManager>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment)object.next();
            if (supportRequestManagerFragment.getRequestManager() == null) continue;
            hashSet.add(supportRequestManagerFragment.getRequestManager());
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

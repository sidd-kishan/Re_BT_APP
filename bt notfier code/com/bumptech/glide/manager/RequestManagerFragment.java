/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.Log
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.manager.ActivityFragmentLifecycle
 *  com.bumptech.glide.manager.RequestManagerFragment$FragmentRequestManagerTreeNode
 *  com.bumptech.glide.manager.RequestManagerTreeNode
 */
package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.ActivityFragmentLifecycle;
import com.bumptech.glide.manager.RequestManagerFragment;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RequestManagerFragment
extends Fragment {
    private static final String TAG = "RMFragment";
    private final Set<RequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    private Fragment parentFragmentHint;
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode = new FragmentRequestManagerTreeNode(this);
    private RequestManagerFragment rootRequestManagerFragment;

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    RequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.childRequestManagerFragments = new HashSet<RequestManagerFragment>();
        this.lifecycle = activityFragmentLifecycle;
    }

    private void addChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.add(requestManagerFragment);
    }

    private Fragment getParentFragmentUsingHint() {
        Fragment fragment = Build.VERSION.SDK_INT >= 17 ? this.getParentFragment() : null;
        if (fragment != null) return fragment;
        fragment = this.parentFragmentHint;
        return fragment;
    }

    private boolean isDescendant(Fragment fragment) {
        Fragment fragment2;
        Fragment fragment3 = this.getParentFragment();
        while ((fragment2 = fragment.getParentFragment()) != null) {
            if (fragment2.equals((Object)fragment3)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return false;
    }

    private void registerFragmentWithRoot(Activity object) {
        this.unregisterFragmentWithRoot();
        object = Glide.get((Context)object).getRequestManagerRetriever().getRequestManagerFragment(object.getFragmentManager(), null);
        this.rootRequestManagerFragment = object;
        if (this.equals(object)) return;
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
    }

    private void removeChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.remove((Object)requestManagerFragment);
    }

    private void unregisterFragmentWithRoot() {
        RequestManagerFragment requestManagerFragment = this.rootRequestManagerFragment;
        if (requestManagerFragment == null) return;
        requestManagerFragment.removeChildRequestManagerFragment(this);
        this.rootRequestManagerFragment = null;
    }

    Set<RequestManagerFragment> getDescendantRequestManagerFragments() {
        if (this.equals((Object)this.rootRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        if (this.rootRequestManagerFragment == null) return Collections.emptySet();
        if (Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet<RequestManagerFragment> hashSet = new HashSet<RequestManagerFragment>();
        Iterator<RequestManagerFragment> iterator = this.rootRequestManagerFragment.getDescendantRequestManagerFragments().iterator();
        while (iterator.hasNext()) {
            RequestManagerFragment requestManagerFragment = iterator.next();
            if (!this.isDescendant(requestManagerFragment.getParentFragment())) continue;
            hashSet.add(requestManagerFragment);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    ActivityFragmentLifecycle getGlideLifecycle() {
        return this.lifecycle;
    }

    public RequestManager getRequestManager() {
        return this.requestManager;
    }

    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.registerFragmentWithRoot(activity);
        }
        catch (IllegalStateException illegalStateException) {
            if (!Log.isLoggable((String)TAG, (int)5)) return;
            Log.w((String)TAG, (String)"Unable to register fragment with root", (Throwable)illegalStateException);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        this.unregisterFragmentWithRoot();
    }

    public void onDetach() {
        super.onDetach();
        this.unregisterFragmentWithRoot();
    }

    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    void setParentFragmentHint(Fragment fragment) {
        this.parentFragmentHint = fragment;
        if (fragment == null) return;
        if (fragment.getActivity() == null) return;
        this.registerFragmentWithRoot(fragment.getActivity());
    }

    public void setRequestManager(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{parent=");
        stringBuilder.append(this.getParentFragmentUsingHint());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

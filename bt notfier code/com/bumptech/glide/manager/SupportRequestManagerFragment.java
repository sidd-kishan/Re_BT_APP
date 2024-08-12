/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.manager.ActivityFragmentLifecycle
 *  com.bumptech.glide.manager.RequestManagerTreeNode
 *  com.bumptech.glide.manager.SupportRequestManagerFragment$SupportFragmentRequestManagerTreeNode
 */
package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.ActivityFragmentLifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment
extends Fragment {
    private static final String TAG = "SupportRMFragment";
    private final Set<SupportRequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    private Fragment parentFragmentHint;
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode = new SupportFragmentRequestManagerTreeNode(this);
    private SupportRequestManagerFragment rootRequestManagerFragment;

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    public SupportRequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.childRequestManagerFragments = new HashSet<SupportRequestManagerFragment>();
        this.lifecycle = activityFragmentLifecycle;
    }

    private void addChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.add(supportRequestManagerFragment);
    }

    private Fragment getParentFragmentUsingHint() {
        Fragment fragment = this.getParentFragment();
        if (fragment != null) return fragment;
        fragment = this.parentFragmentHint;
        return fragment;
    }

    private boolean isDescendant(Fragment fragment) {
        Fragment fragment2;
        Fragment fragment3 = this.getParentFragmentUsingHint();
        while ((fragment2 = fragment.getParentFragment()) != null) {
            if (fragment2.equals((Object)fragment3)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return false;
    }

    private void registerFragmentWithRoot(FragmentActivity object) {
        this.unregisterFragmentWithRoot();
        object = Glide.get((Context)object).getRequestManagerRetriever().getSupportRequestManagerFragment(object.getSupportFragmentManager(), null);
        this.rootRequestManagerFragment = object;
        if (this.equals(object)) return;
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
    }

    private void removeChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.remove((Object)supportRequestManagerFragment);
    }

    private void unregisterFragmentWithRoot() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment == null) return;
        supportRequestManagerFragment.removeChildRequestManagerFragment(this);
        this.rootRequestManagerFragment = null;
    }

    Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        Object object = this.rootRequestManagerFragment;
        if (object == null) {
            return Collections.emptySet();
        }
        if (this.equals(object)) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        HashSet<SupportRequestManagerFragment> hashSet = new HashSet<SupportRequestManagerFragment>();
        object = this.rootRequestManagerFragment.getDescendantRequestManagerFragments().iterator();
        while (object.hasNext()) {
            SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment)((Object)object.next());
            if (!this.isDescendant(supportRequestManagerFragment.getParentFragmentUsingHint())) continue;
            hashSet.add(supportRequestManagerFragment);
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

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.registerFragmentWithRoot(this.getActivity());
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
        this.parentFragmentHint = null;
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

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
 */
package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentLifecycleCallbacksDispatcher;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class FragmentLifecycleCallbacksDispatcher {
    private final FragmentManager mFragmentManager;
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> mLifecycleCallbacks = new CopyOnWriteArrayList();

    FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    void dispatchOnFragmentActivityCreated(Fragment fragment, Bundle bundle, boolean bl) {
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(fragment, bundle, true);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (object.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)object.next();
            if (bl && !fragmentLifecycleCallbacksHolder.mRecursive) continue;
            fragmentLifecycleCallbacksHolder.mCallback.onFragmentActivityCreated(this.mFragmentManager, fragment, bundle);
        }
    }

    void dispatchOnFragmentAttached(Fragment fragment, boolean bl) {
        Context context = this.mFragmentManager.getHost().getContext();
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(fragment, true);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (object.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)object.next();
            if (bl && !fragmentLifecycleCallbacksHolder.mRecursive) continue;
            fragmentLifecycleCallbacksHolder.mCallback.onFragmentAttached(this.mFragmentManager, fragment, context);
        }
    }

    void dispatchOnFragmentCreated(Fragment fragment, Bundle bundle, boolean bl) {
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(fragment, bundle, true);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (object.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)object.next();
            if (bl && !fragmentLifecycleCallbacksHolder.mRecursive) continue;
            fragmentLifecycleCallbacksHolder.mCallback.onFragmentCreated(this.mFragmentManager, fragment, bundle);
        }
    }

    void dispatchOnFragmentDestroyed(Fragment fragment, boolean bl) {
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(fragment, true);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (object.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)object.next();
            if (bl && !fragmentLifecycleCallbacksHolder.mRecursive) continue;
            fragmentLifecycleCallbacksHolder.mCallback.onFragmentDestroyed(this.mFragmentManager, fragment);
        }
    }

    void dispatchOnFragmentDetached(Fragment fragment, boolean bl) {
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(fragment, true);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (object.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)object.next();
            if (bl && !fragmentLifecycleCallbacksHolder.mRecursive) continue;
            fragmentLifecycleCallbacksHolder.mCallback.onFragmentDetached(this.mFragmentManager, fragment);
        }
    }

    void dispatchOnFragmentPaused(Fragment fragment, boolean bl) {
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(fragment, true);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (object.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)object.next();
            if (bl && !fragmentLifecycleCallbacksHolder.mRecursive) continue;
            fragmentLifecycleCallbacksHolder.mCallback.onFragmentPaused(this.mFragmentManager, fragment);
        }
    }

    void dispatchOnFragmentPreAttached(Fragment fragment, boolean bl) {
        Context context = this.mFragmentManager.getHost().getContext();
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(fragment, true);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (object.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)object.next();
            if (bl && !fragmentLifecycleCallbacksHolder.mRecursive) continue;
            fragmentLifecycleCallbacksHolder.mCallback.onFragmentPreAttached(this.mFragmentManager, fragment, context);
        }
    }

    void dispatchOnFragmentPreCreated(Fragment fragment, Bundle bundle, boolean bl) {
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(fragment, bundle, true);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (object.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)object.next();
            if (bl && !fragmentLifecycleCallbacksHolder.mRecursive) continue;
            fragmentLifecycleCallbacksHolder.mCallback.onFragmentPreCreated(this.mFragmentManager, fragment, bundle);
        }
    }

    void dispatchOnFragmentResumed(Fragment fragment, boolean bl) {
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(fragment, true);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (object.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)object.next();
            if (bl && !fragmentLifecycleCallbacksHolder.mRecursive) continue;
            fragmentLifecycleCallbacksHolder.mCallback.onFragmentResumed(this.mFragmentManager, fragment);
        }
    }

    void dispatchOnFragmentSaveInstanceState(Fragment fragment, Bundle bundle, boolean bl) {
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (object.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)object.next();
            if (bl && !fragmentLifecycleCallbacksHolder.mRecursive) continue;
            fragmentLifecycleCallbacksHolder.mCallback.onFragmentSaveInstanceState(this.mFragmentManager, fragment, bundle);
        }
    }

    void dispatchOnFragmentStarted(Fragment fragment, boolean bl) {
        Fragment fragment2 = this.mFragmentManager.getParent();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> iterator = this.mLifecycleCallbacks.iterator();
        while (iterator.hasNext()) {
            fragment2 = iterator.next();
            if (bl && !fragment2.mRecursive) continue;
            fragment2.mCallback.onFragmentStarted(this.mFragmentManager, fragment);
        }
    }

    void dispatchOnFragmentStopped(Fragment fragment, boolean bl) {
        Fragment fragment2 = this.mFragmentManager.getParent();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> iterator = this.mLifecycleCallbacks.iterator();
        while (iterator.hasNext()) {
            fragment2 = iterator.next();
            if (bl && !fragment2.mRecursive) continue;
            fragment2.mCallback.onFragmentStopped(this.mFragmentManager, fragment);
        }
    }

    void dispatchOnFragmentViewCreated(Fragment fragment, View view, Bundle bundle, boolean bl) {
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(fragment, view, bundle, true);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (object.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)object.next();
            if (bl && !fragmentLifecycleCallbacksHolder.mRecursive) continue;
            fragmentLifecycleCallbacksHolder.mCallback.onFragmentViewCreated(this.mFragmentManager, fragment, view, bundle);
        }
    }

    void dispatchOnFragmentViewDestroyed(Fragment fragment, boolean bl) {
        Fragment fragment2 = this.mFragmentManager.getParent();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> iterator = this.mLifecycleCallbacks.iterator();
        while (iterator.hasNext()) {
            fragment2 = iterator.next();
            if (bl && !fragment2.mRecursive) continue;
            fragment2.mCallback.onFragmentViewDestroyed(this.mFragmentManager, fragment);
        }
    }

    public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean bl) {
        this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, bl));
    }

    /*
     * Enabled force condition propagation
     */
    public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> copyOnWriteArrayList = this.mLifecycleCallbacks;
        synchronized (copyOnWriteArrayList) {
            int n = 0;
            int n2 = this.mLifecycleCallbacks.size();
            while (n < n2) {
                if (this.mLifecycleCallbacks.get((int)n).mCallback == fragmentLifecycleCallbacks) {
                    this.mLifecycleCallbacks.remove(n);
                    return;
                }
                ++n;
            }
            return;
        }
    }
}

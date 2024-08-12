/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.Fragment$SavedState
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransaction
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.viewpager.widget.PagerAdapter
 */
package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

@Deprecated
public abstract class FragmentStatePagerAdapter
extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapt";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;
    private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();

    @Deprecated
    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public FragmentStatePagerAdapter(FragmentManager fragmentManager, int n) {
        this.mFragments = new ArrayList();
        this.mFragmentManager = fragmentManager;
        this.mBehavior = n;
    }

    public void destroyItem(ViewGroup object, int n, Object object2) {
        object2 = (Fragment)object2;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        while (this.mSavedState.size() <= n) {
            this.mSavedState.add(null);
        }
        ArrayList<Fragment.SavedState> arrayList = this.mSavedState;
        object = object2.isAdded() ? this.mFragmentManager.saveFragmentInstanceState((Fragment)object2) : null;
        arrayList.set(n, (Fragment.SavedState)object);
        this.mFragments.set(n, null);
        this.mCurTransaction.remove((Fragment)object2);
        if (!object2.equals((Object)this.mCurrentPrimaryItem)) return;
        this.mCurrentPrimaryItem = null;
    }

    public void finishUpdate(ViewGroup viewGroup) {
        viewGroup = this.mCurTransaction;
        if (viewGroup == null) return;
        if (!this.mExecutingFinishUpdate) {
            try {
                this.mExecutingFinishUpdate = true;
                viewGroup.commitNowAllowingStateLoss();
            }
            finally {
                this.mExecutingFinishUpdate = false;
            }
        }
        this.mCurTransaction = null;
    }

    public abstract Fragment getItem(int var1);

    public Object instantiateItem(ViewGroup viewGroup, int n) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.mFragments.size() > n && (fragment = this.mFragments.get(n)) != null) {
            return fragment;
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        fragment = this.getItem(n);
        if (this.mSavedState.size() > n && (savedState = this.mSavedState.get(n)) != null) {
            fragment.setInitialSavedState(savedState);
        }
        while (this.mFragments.size() <= n) {
            this.mFragments.add(null);
        }
        fragment.setMenuVisibility(false);
        if (this.mBehavior == 0) {
            fragment.setUserVisibleHint(false);
        }
        this.mFragments.set(n, fragment);
        this.mCurTransaction.add(viewGroup.getId(), fragment);
        if (this.mBehavior != 1) return fragment;
        this.mCurTransaction.setMaxLifecycle(fragment, Lifecycle.State.STARTED);
        return fragment;
    }

    public boolean isViewFromObject(View view, Object object) {
        boolean bl = ((Fragment)object).getView() == view;
        return bl;
    }

    public void restoreState(Parcelable parcelable, ClassLoader object) {
        int n;
        if (parcelable == null) return;
        parcelable = (Bundle)parcelable;
        parcelable.setClassLoader((ClassLoader)object);
        object = parcelable.getParcelableArray("states");
        this.mSavedState.clear();
        this.mFragments.clear();
        if (object != null) {
            for (n = 0; n < ((Parcelable[])object).length; ++n) {
                this.mSavedState.add((Fragment.SavedState)object[n]);
            }
        }
        object = parcelable.keySet().iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            if (!string.startsWith("f")) continue;
            n = Integer.parseInt(string.substring(1));
            Object object2 = this.mFragmentManager.getFragment((Bundle)parcelable, string);
            if (object2 != null) {
                while (this.mFragments.size() <= n) {
                    this.mFragments.add(null);
                }
                object2.setMenuVisibility(false);
                this.mFragments.set(n, (Fragment)object2);
                continue;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Bad fragment at key ");
            ((StringBuilder)object2).append(string);
            Log.w((String)TAG, (String)((StringBuilder)object2).toString());
        }
    }

    public Parcelable saveState() {
        Bundle bundle;
        Object object;
        if (this.mSavedState.size() > 0) {
            object = new Bundle();
            bundle = new Fragment.SavedState[this.mSavedState.size()];
            this.mSavedState.toArray((T[])bundle);
            object.putParcelableArray("states", (Parcelable[])bundle);
        } else {
            object = null;
        }
        int n = 0;
        while (n < this.mFragments.size()) {
            Fragment fragment = this.mFragments.get(n);
            bundle = object;
            if (fragment != null) {
                bundle = object;
                if (fragment.isAdded()) {
                    bundle = object;
                    if (object == null) {
                        bundle = new Bundle();
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("f");
                    ((StringBuilder)object).append(n);
                    object = ((StringBuilder)object).toString();
                    this.mFragmentManager.putFragment(bundle, (String)object, fragment);
                }
            }
            ++n;
            object = bundle;
        }
        return object;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int n, Object object) {
        viewGroup = (Fragment)object;
        if (viewGroup == (object = this.mCurrentPrimaryItem)) return;
        if (object != null) {
            object.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.beginTransaction();
                }
                this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
            } else {
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }
        }
        viewGroup.setMenuVisibility(true);
        if (this.mBehavior == 1) {
            if (this.mCurTransaction == null) {
                this.mCurTransaction = this.mFragmentManager.beginTransaction();
            }
            this.mCurTransaction.setMaxLifecycle((Fragment)viewGroup, Lifecycle.State.RESUMED);
        } else {
            viewGroup.setUserVisibleHint(true);
        }
        this.mCurrentPrimaryItem = viewGroup;
    }

    public void startUpdate(ViewGroup object) {
        if (object.getId() != -1) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("ViewPager with adapter ");
        ((StringBuilder)object).append((Object)this);
        ((StringBuilder)object).append(" requires a view id");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }
}

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransaction
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.viewpager.widget.PagerAdapter
 */
package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

@Deprecated
public abstract class FragmentPagerAdapter
extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;

    @Deprecated
    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public FragmentPagerAdapter(FragmentManager fragmentManager, int n) {
        this.mFragmentManager = fragmentManager;
        this.mBehavior = n;
    }

    private static String makeFragmentName(int n, long l) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android:switcher:");
        stringBuilder.append(n);
        stringBuilder.append(":");
        stringBuilder.append(l);
        return stringBuilder.toString();
    }

    public void destroyItem(ViewGroup viewGroup, int n, Object object) {
        viewGroup = (Fragment)object;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        this.mCurTransaction.detach((Fragment)viewGroup);
        if (!viewGroup.equals((Object)this.mCurrentPrimaryItem)) return;
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

    public long getItemId(int n) {
        return n;
    }

    public Object instantiateItem(ViewGroup object, int n) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        long l = this.getItemId(n);
        String string = FragmentPagerAdapter.makeFragmentName(object.getId(), l);
        if ((string = this.mFragmentManager.findFragmentByTag(string)) != null) {
            this.mCurTransaction.attach((Fragment)string);
            object = string;
        } else {
            string = this.getItem(n);
            this.mCurTransaction.add(object.getId(), (Fragment)string, FragmentPagerAdapter.makeFragmentName(object.getId(), l));
            object = string;
        }
        if (object == this.mCurrentPrimaryItem) return object;
        object.setMenuVisibility(false);
        if (this.mBehavior == 1) {
            this.mCurTransaction.setMaxLifecycle((Fragment)object, Lifecycle.State.STARTED);
        } else {
            object.setUserVisibleHint(false);
        }
        return object;
    }

    public boolean isViewFromObject(View view, Object object) {
        boolean bl = ((Fragment)object).getView() == view;
        return bl;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int n, Object object) {
        viewGroup = this.mCurrentPrimaryItem;
        if ((object = (Fragment)object) == viewGroup) return;
        if (viewGroup != null) {
            viewGroup.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.beginTransaction();
                }
                this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
            } else {
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }
        }
        object.setMenuVisibility(true);
        if (this.mBehavior == 1) {
            if (this.mCurTransaction == null) {
                this.mCurTransaction = this.mFragmentManager.beginTransaction();
            }
            this.mCurTransaction.setMaxLifecycle((Fragment)object, Lifecycle.State.RESUMED);
        } else {
            object.setUserVisibleHint(true);
        }
        this.mCurrentPrimaryItem = object;
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

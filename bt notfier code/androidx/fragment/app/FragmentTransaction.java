/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.view.ViewCompat
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentFactory
 *  androidx.fragment.app.FragmentTransaction$Op
 *  androidx.fragment.app.FragmentTransition
 *  androidx.lifecycle.Lifecycle$State
 */
package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransition;
import androidx.lifecycle.Lifecycle;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class FragmentTransaction {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SET_MAX_LIFECYCLE = 10;
    static final int OP_SET_PRIMARY_NAV = 8;
    static final int OP_SHOW = 5;
    static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack = true;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    private final ClassLoader mClassLoader;
    ArrayList<Runnable> mCommitRunnables;
    int mEnterAnim;
    int mExitAnim;
    private final FragmentFactory mFragmentFactory;
    String mName;
    ArrayList<Op> mOps = new ArrayList();
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed = false;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;

    @Deprecated
    public FragmentTransaction() {
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        this.mFragmentFactory = fragmentFactory;
        this.mClassLoader = classLoader;
    }

    private Fragment createFragment(Class<? extends Fragment> fragment, Bundle bundle) {
        FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory == null) throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
        ClassLoader classLoader = this.mClassLoader;
        if (classLoader == null) throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        fragment = fragmentFactory.instantiate(classLoader, fragment.getName());
        if (bundle == null) return fragment;
        fragment.setArguments(bundle);
        return fragment;
    }

    public FragmentTransaction add(int n, Fragment fragment) {
        this.doAddOp(n, fragment, null, 1);
        return this;
    }

    public FragmentTransaction add(int n, Fragment fragment, String string) {
        this.doAddOp(n, fragment, string, 1);
        return this;
    }

    public final FragmentTransaction add(int n, Class<? extends Fragment> clazz, Bundle bundle) {
        return this.add(n, this.createFragment(clazz, bundle));
    }

    public final FragmentTransaction add(int n, Class<? extends Fragment> clazz, Bundle bundle, String string) {
        return this.add(n, this.createFragment(clazz, bundle), string);
    }

    FragmentTransaction add(ViewGroup viewGroup, Fragment fragment, String string) {
        fragment.mContainer = viewGroup;
        return this.add(viewGroup.getId(), fragment, string);
    }

    public FragmentTransaction add(Fragment fragment, String string) {
        this.doAddOp(0, fragment, string, 1);
        return this;
    }

    public final FragmentTransaction add(Class<? extends Fragment> clazz, Bundle bundle, String string) {
        return this.add(this.createFragment(clazz, bundle), string);
    }

    void addOp(Op op) {
        this.mOps.add(op);
        op.mEnterAnim = this.mEnterAnim;
        op.mExitAnim = this.mExitAnim;
        op.mPopEnterAnim = this.mPopEnterAnim;
        op.mPopExitAnim = this.mPopExitAnim;
    }

    public FragmentTransaction addSharedElement(View object, String charSequence) {
        if (!FragmentTransition.supportsTransition()) return this;
        if ((object = ViewCompat.getTransitionName((View)object)) == null) throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
        if (this.mSharedElementSourceNames == null) {
            this.mSharedElementSourceNames = new ArrayList();
            this.mSharedElementTargetNames = new ArrayList();
        } else {
            if (this.mSharedElementTargetNames.contains(charSequence)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("A shared element with the target name '");
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append("' has already been added to the transaction.");
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            if (this.mSharedElementSourceNames.contains(object)) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("A shared element with the source name '");
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append("' has already been added to the transaction.");
                throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
            }
        }
        this.mSharedElementSourceNames.add((String)object);
        this.mSharedElementTargetNames.add((String)charSequence);
        return this;
    }

    public FragmentTransaction addToBackStack(String string) {
        if (!this.mAllowAddToBackStack) throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        this.mAddToBackStack = true;
        this.mName = string;
        return this;
    }

    public FragmentTransaction attach(Fragment fragment) {
        this.addOp(new Op(7, fragment));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    public FragmentTransaction detach(Fragment fragment) {
        this.addOp(new Op(6, fragment));
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) throw new IllegalStateException("This transaction is already being added to the back stack");
        this.mAllowAddToBackStack = false;
        return this;
    }

    void doAddOp(int n, Fragment object, String charSequence, int n2) {
        Serializable serializable = object.getClass();
        int n3 = ((Class)serializable).getModifiers();
        if (!((Class)serializable).isAnonymousClass() && Modifier.isPublic(n3) && (!((Class)serializable).isMemberClass() || Modifier.isStatic(n3))) {
            if (charSequence != null) {
                if (((Fragment)object).mTag != null && !((String)charSequence).equals(((Fragment)object).mTag)) {
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("Can't change tag of fragment ");
                    ((StringBuilder)serializable).append(object);
                    ((StringBuilder)serializable).append(": was ");
                    ((StringBuilder)serializable).append(((Fragment)object).mTag);
                    ((StringBuilder)serializable).append(" now ");
                    ((StringBuilder)serializable).append((String)charSequence);
                    throw new IllegalStateException(((StringBuilder)serializable).toString());
                }
                ((Fragment)object).mTag = charSequence;
            }
            if (n != 0) {
                if (n == -1) {
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("Can't add fragment ");
                    ((StringBuilder)serializable).append(object);
                    ((StringBuilder)serializable).append(" with tag ");
                    ((StringBuilder)serializable).append((String)charSequence);
                    ((StringBuilder)serializable).append(" to container view with no id");
                    throw new IllegalArgumentException(((StringBuilder)serializable).toString());
                }
                if (((Fragment)object).mFragmentId != 0 && ((Fragment)object).mFragmentId != n) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("Can't change container ID of fragment ");
                    ((StringBuilder)charSequence).append(object);
                    ((StringBuilder)charSequence).append(": was ");
                    ((StringBuilder)charSequence).append(((Fragment)object).mFragmentId);
                    ((StringBuilder)charSequence).append(" now ");
                    ((StringBuilder)charSequence).append(n);
                    throw new IllegalStateException(((StringBuilder)charSequence).toString());
                }
                ((Fragment)object).mFragmentId = n;
                ((Fragment)object).mContainerId = n;
            }
            this.addOp(new Op(n2, (Fragment)object));
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(((Class)serializable).getCanonicalName());
        ((StringBuilder)object).append(" must be a public static class to be  properly recreated from instance state.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public FragmentTransaction hide(Fragment fragment) {
        this.addOp(new Op(4, fragment));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    public FragmentTransaction remove(Fragment fragment) {
        this.addOp(new Op(3, fragment));
        return this;
    }

    public FragmentTransaction replace(int n, Fragment fragment) {
        return this.replace(n, fragment, null);
    }

    public FragmentTransaction replace(int n, Fragment fragment, String string) {
        if (n == 0) throw new IllegalArgumentException("Must use non-zero containerViewId");
        this.doAddOp(n, fragment, string, 2);
        return this;
    }

    public final FragmentTransaction replace(int n, Class<? extends Fragment> clazz, Bundle bundle) {
        return this.replace(n, clazz, bundle, null);
    }

    public final FragmentTransaction replace(int n, Class<? extends Fragment> clazz, Bundle bundle, String string) {
        return this.replace(n, this.createFragment(clazz, bundle), string);
    }

    public FragmentTransaction runOnCommit(Runnable runnable) {
        this.disallowAddToBackStack();
        if (this.mCommitRunnables == null) {
            this.mCommitRunnables = new ArrayList();
        }
        this.mCommitRunnables.add(runnable);
        return this;
    }

    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean bl) {
        return this.setReorderingAllowed(bl);
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(int n) {
        this.mBreadCrumbShortTitleRes = n;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(int n) {
        this.mBreadCrumbTitleRes = n;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int n, int n2) {
        return this.setCustomAnimations(n, n2, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int n, int n2, int n3, int n4) {
        this.mEnterAnim = n;
        this.mExitAnim = n2;
        this.mPopEnterAnim = n3;
        this.mPopExitAnim = n4;
        return this;
    }

    public FragmentTransaction setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        this.addOp(new Op(10, fragment, state));
        return this;
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment fragment) {
        this.addOp(new Op(8, fragment));
        return this;
    }

    public FragmentTransaction setReorderingAllowed(boolean bl) {
        this.mReorderingAllowed = bl;
        return this;
    }

    public FragmentTransaction setTransition(int n) {
        this.mTransition = n;
        return this;
    }

    @Deprecated
    public FragmentTransaction setTransitionStyle(int n) {
        return this;
    }

    public FragmentTransaction show(Fragment fragment) {
        this.addOp(new Op(5, fragment));
        return this;
    }
}

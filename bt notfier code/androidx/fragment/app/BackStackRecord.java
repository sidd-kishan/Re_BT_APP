/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.Fragment$OnStartEnterTransitionListener
 *  androidx.fragment.app.FragmentFactory
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManager$BackStackEntry
 *  androidx.fragment.app.FragmentManager$OpGenerator
 *  androidx.fragment.app.FragmentTransaction
 *  androidx.fragment.app.FragmentTransaction$Op
 *  androidx.fragment.app.LogWriter
 *  androidx.lifecycle.Lifecycle$State
 */
package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.LogWriter;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

final class BackStackRecord
extends FragmentTransaction
implements FragmentManager.BackStackEntry,
FragmentManager.OpGenerator {
    private static final String TAG = "FragmentManager";
    boolean mCommitted;
    int mIndex;
    final FragmentManager mManager;

    BackStackRecord(FragmentManager fragmentManager) {
        FragmentFactory fragmentFactory = fragmentManager.getFragmentFactory();
        ClassLoader classLoader = fragmentManager.getHost() != null ? fragmentManager.getHost().getContext().getClassLoader() : null;
        super(fragmentFactory, classLoader);
        this.mIndex = -1;
        this.mManager = fragmentManager;
    }

    private static boolean isFragmentPostponed(FragmentTransaction.Op op) {
        op = op.mFragment;
        boolean bl = op != null && op.mAdded && op.mView != null && !op.mDetached && !op.mHidden && op.isPostponed();
        return bl;
    }

    void bumpBackStackNesting(int n) {
        StringBuilder stringBuilder;
        if (!this.mAddToBackStack) {
            return;
        }
        if (FragmentManager.isLoggingEnabled((int)2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Bump nesting in ");
            stringBuilder.append((Object)this);
            stringBuilder.append(" by ");
            stringBuilder.append(n);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        int n2 = this.mOps.size();
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder = (FragmentTransaction.Op)this.mOps.get(n3);
            if (((FragmentTransaction.Op)stringBuilder).mFragment != null) {
                Object object = ((FragmentTransaction.Op)stringBuilder).mFragment;
                ((Fragment)object).mBackStackNesting += n;
                if (FragmentManager.isLoggingEnabled((int)2)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Bump nesting of ");
                    ((StringBuilder)object).append(((FragmentTransaction.Op)stringBuilder).mFragment);
                    ((StringBuilder)object).append(" to ");
                    ((StringBuilder)object).append(((FragmentTransaction.Op)stringBuilder).mFragment.mBackStackNesting);
                    Log.v((String)TAG, (String)((StringBuilder)object).toString());
                }
            }
            ++n3;
        }
    }

    public int commit() {
        return this.commitInternal(false);
    }

    public int commitAllowingStateLoss() {
        return this.commitInternal(true);
    }

    int commitInternal(boolean bl) {
        if (this.mCommitted) throw new IllegalStateException("commit already called");
        if (FragmentManager.isLoggingEnabled((int)2)) {
            Appendable appendable = new StringBuilder();
            ((StringBuilder)appendable).append("Commit: ");
            ((StringBuilder)appendable).append((Object)this);
            Log.v((String)TAG, (String)((StringBuilder)appendable).toString());
            appendable = new PrintWriter((Writer)new LogWriter(TAG));
            this.dump("  ", (PrintWriter)appendable);
            ((PrintWriter)appendable).close();
        }
        this.mCommitted = true;
        this.mIndex = this.mAddToBackStack ? this.mManager.allocBackStackIndex() : -1;
        this.mManager.enqueueAction((FragmentManager.OpGenerator)this, bl);
        return this.mIndex;
    }

    public void commitNow() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction((FragmentManager.OpGenerator)this, false);
    }

    public void commitNowAllowingStateLoss() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction((FragmentManager.OpGenerator)this, true);
    }

    public FragmentTransaction detach(Fragment fragment) {
        if (fragment.mFragmentManager == null) return super.detach(fragment);
        if (fragment.mFragmentManager == this.mManager) {
            return super.detach(fragment);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
        stringBuilder.append(fragment.toString());
        stringBuilder.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    void doAddOp(int n, Fragment fragment, String string, int n2) {
        super.doAddOp(n, fragment, string, n2);
        fragment.mFragmentManager = this.mManager;
    }

    public void dump(String string, PrintWriter printWriter) {
        this.dump(string, printWriter, true);
    }

    public void dump(String string, PrintWriter printWriter, boolean bl) {
        if (bl) {
            printWriter.print(string);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(string);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(string);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(string);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(string);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(string);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.mOps.isEmpty()) return;
        printWriter.print(string);
        printWriter.println("Operations:");
        int n = this.mOps.size();
        int n2 = 0;
        while (n2 < n) {
            CharSequence charSequence;
            FragmentTransaction.Op op = (FragmentTransaction.Op)this.mOps.get(n2);
            switch (op.mCmd) {
                default: {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("cmd=");
                    ((StringBuilder)charSequence).append(op.mCmd);
                    charSequence = ((StringBuilder)charSequence).toString();
                    break;
                }
                case 10: {
                    charSequence = "OP_SET_MAX_LIFECYCLE";
                    break;
                }
                case 9: {
                    charSequence = "UNSET_PRIMARY_NAV";
                    break;
                }
                case 8: {
                    charSequence = "SET_PRIMARY_NAV";
                    break;
                }
                case 7: {
                    charSequence = "ATTACH";
                    break;
                }
                case 6: {
                    charSequence = "DETACH";
                    break;
                }
                case 5: {
                    charSequence = "SHOW";
                    break;
                }
                case 4: {
                    charSequence = "HIDE";
                    break;
                }
                case 3: {
                    charSequence = "REMOVE";
                    break;
                }
                case 2: {
                    charSequence = "REPLACE";
                    break;
                }
                case 1: {
                    charSequence = "ADD";
                    break;
                }
                case 0: {
                    charSequence = "NULL";
                }
            }
            printWriter.print(string);
            printWriter.print("  Op #");
            printWriter.print(n2);
            printWriter.print(": ");
            printWriter.print((String)charSequence);
            printWriter.print(" ");
            printWriter.println(op.mFragment);
            if (bl) {
                if (op.mEnterAnim != 0 || op.mExitAnim != 0) {
                    printWriter.print(string);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op.mEnterAnim));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op.mExitAnim));
                }
                if (op.mPopEnterAnim != 0 || op.mPopExitAnim != 0) {
                    printWriter.print(string);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(op.mPopEnterAnim));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(op.mPopExitAnim));
                }
            }
            ++n2;
        }
    }

    /*
     * Unable to fully structure code
     */
    void executeOps() {
        var2_1 = this.mOps.size();
        var1_2 = 0;
        block11: while (true) {
            if (var1_2 >= var2_1) {
                if (this.mReorderingAllowed != false) return;
                if (FragmentManager.USE_STATE_MANAGER != false) return;
                var3_3 = this.mManager;
                var3_3.moveToState(var3_3.mCurState, true);
                return;
            }
            var3_3 = (FragmentTransaction.Op)this.mOps.get(var1_2);
            var4_4 = var3_3.mFragment;
            if (var4_4 != null) {
                var4_4.setPopDirection(false);
                var4_4.setNextTransition(this.mTransition);
                var4_4.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
            }
            switch (var3_3.mCmd) {
                case 10: {
                    this.mManager.setMaxLifecycle((Fragment)var4_4, var3_3.mCurrentMaxState);
                    ** break;
                }
                case 9: {
                    this.mManager.setPrimaryNavigationFragment(null);
                    ** break;
                }
                case 8: {
                    this.mManager.setPrimaryNavigationFragment((Fragment)var4_4);
                    ** break;
                }
                case 7: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.setExitAnimationOrder((Fragment)var4_4, false);
                    this.mManager.attachFragment((Fragment)var4_4);
                    ** break;
                }
                case 6: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.detachFragment((Fragment)var4_4);
                    ** break;
                }
                case 5: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.setExitAnimationOrder((Fragment)var4_4, false);
                    this.mManager.showFragment((Fragment)var4_4);
                    ** break;
                }
                case 4: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.hideFragment((Fragment)var4_4);
                    ** break;
                }
                case 3: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.removeFragment((Fragment)var4_4);
                    ** break;
                }
                case 1: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.setExitAnimationOrder((Fragment)var4_4, false);
                    this.mManager.addFragment((Fragment)var4_4);
lbl53:
                    // 9 sources

                    if (!this.mReorderingAllowed && var3_3.mCmd != 1 && var4_4 != null && !FragmentManager.USE_STATE_MANAGER) {
                        this.mManager.moveFragmentToExpectedState((Fragment)var4_4);
                    }
                    ++var1_2;
                    continue block11;
                }
            }
            break;
        }
        var4_4 = new StringBuilder();
        var4_4.append("Unknown cmd: ");
        var4_4.append(var3_3.mCmd);
        throw new IllegalArgumentException(var4_4.toString());
    }

    /*
     * Unable to fully structure code
     */
    void executePopOps(boolean var1_1) {
        var2_2 = this.mOps.size() - 1;
        block11: while (true) {
            if (var2_2 < 0) {
                if (this.mReorderingAllowed != false) return;
                if (var1_1 == false) return;
                if (FragmentManager.USE_STATE_MANAGER != false) return;
                var3_3 = this.mManager;
                var3_3.moveToState(var3_3.mCurState, true);
                return;
            }
            var3_3 = (FragmentTransaction.Op)this.mOps.get(var2_2);
            var4_4 = var3_3.mFragment;
            if (var4_4 != null) {
                var4_4.setPopDirection(true);
                var4_4.setNextTransition(FragmentManager.reverseTransit((int)this.mTransition));
                var4_4.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
            switch (var3_3.mCmd) {
                case 10: {
                    this.mManager.setMaxLifecycle((Fragment)var4_4, var3_3.mOldMaxState);
                    ** break;
                }
                case 9: {
                    this.mManager.setPrimaryNavigationFragment((Fragment)var4_4);
                    ** break;
                }
                case 8: {
                    this.mManager.setPrimaryNavigationFragment(null);
                    ** break;
                }
                case 7: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.setExitAnimationOrder((Fragment)var4_4, true);
                    this.mManager.detachFragment((Fragment)var4_4);
                    ** break;
                }
                case 6: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.attachFragment((Fragment)var4_4);
                    ** break;
                }
                case 5: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.setExitAnimationOrder((Fragment)var4_4, true);
                    this.mManager.hideFragment((Fragment)var4_4);
                    ** break;
                }
                case 4: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.showFragment((Fragment)var4_4);
                    ** break;
                }
                case 3: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.addFragment((Fragment)var4_4);
                    ** break;
                }
                case 1: {
                    var4_4.setAnimations(var3_3.mEnterAnim, var3_3.mExitAnim, var3_3.mPopEnterAnim, var3_3.mPopExitAnim);
                    this.mManager.setExitAnimationOrder((Fragment)var4_4, true);
                    this.mManager.removeFragment((Fragment)var4_4);
lbl53:
                    // 9 sources

                    if (!this.mReorderingAllowed && var3_3.mCmd != 3 && var4_4 != null && !FragmentManager.USE_STATE_MANAGER) {
                        this.mManager.moveFragmentToExpectedState((Fragment)var4_4);
                    }
                    --var2_2;
                    continue block11;
                }
            }
            break;
        }
        var4_4 = new StringBuilder();
        var4_4.append("Unknown cmd: ");
        var4_4.append(var3_3.mCmd);
        throw new IllegalArgumentException(var4_4.toString());
    }

    Fragment expandOps(ArrayList<Fragment> arrayList, Fragment fragment) {
        int n = 0;
        Fragment fragment2 = fragment;
        while (n < this.mOps.size()) {
            int n2;
            block14: {
                boolean bl;
                int n3;
                Fragment fragment3;
                FragmentTransaction.Op op;
                block15: {
                    block11: {
                        block12: {
                            block13: {
                                op = (FragmentTransaction.Op)this.mOps.get(n);
                                n2 = op.mCmd;
                                if (n2 == 1) break block11;
                                if (n2 == 2) break block12;
                                if (n2 == 3 || n2 == 6) break block13;
                                if (n2 == 7) break block11;
                                if (n2 != 8) {
                                    fragment = fragment2;
                                    n2 = n;
                                } else {
                                    this.mOps.add(n, new FragmentTransaction.Op(9, fragment2));
                                    n2 = n + 1;
                                    fragment = op.mFragment;
                                }
                                break block14;
                            }
                            arrayList.remove(op.mFragment);
                            fragment = fragment2;
                            n2 = n;
                            if (op.mFragment == fragment2) {
                                this.mOps.add(n, new FragmentTransaction.Op(9, op.mFragment));
                                n2 = n + 1;
                                fragment = null;
                            }
                            break block14;
                        }
                        fragment3 = op.mFragment;
                        n3 = fragment3.mContainerId;
                        bl = false;
                        n2 = n;
                        fragment = fragment2;
                        break block15;
                    }
                    arrayList.add(op.mFragment);
                    n2 = n;
                    fragment = fragment2;
                    break block14;
                }
                for (int i = arrayList.size() - 1; i >= 0; --i) {
                    Fragment fragment4 = arrayList.get(i);
                    fragment2 = fragment;
                    n = n2;
                    boolean bl2 = bl;
                    if (fragment4.mContainerId == n3) {
                        if (fragment4 == fragment3) {
                            bl2 = true;
                            fragment2 = fragment;
                            n = n2;
                        } else {
                            fragment2 = fragment;
                            n = n2;
                            if (fragment4 == fragment) {
                                this.mOps.add(n2, new FragmentTransaction.Op(9, fragment4));
                                n = n2 + 1;
                                fragment2 = null;
                            }
                            fragment = new FragmentTransaction.Op(3, fragment4);
                            fragment.mEnterAnim = op.mEnterAnim;
                            fragment.mPopEnterAnim = op.mPopEnterAnim;
                            fragment.mExitAnim = op.mExitAnim;
                            fragment.mPopExitAnim = op.mPopExitAnim;
                            this.mOps.add(n, fragment);
                            arrayList.remove(fragment4);
                            bl2 = bl;
                        }
                    }
                    fragment = fragment2;
                    n2 = ++n;
                    bl = bl2;
                }
                if (bl) {
                    this.mOps.remove(n2);
                    --n2;
                } else {
                    op.mCmd = 1;
                    arrayList.add(fragment3);
                }
            }
            n = n2 + 1;
            fragment2 = fragment;
        }
        return fragment2;
    }

    public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.isLoggingEnabled((int)2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Run: ");
            stringBuilder.append((Object)this);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.mAddToBackStack) return true;
        this.mManager.addBackStackState(this);
        return true;
    }

    public CharSequence getBreadCrumbShortTitle() {
        if (this.mBreadCrumbShortTitleRes == 0) return this.mBreadCrumbShortTitleText;
        return this.mManager.getHost().getContext().getText(this.mBreadCrumbShortTitleRes);
    }

    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    public CharSequence getBreadCrumbTitle() {
        if (this.mBreadCrumbTitleRes == 0) return this.mBreadCrumbTitleText;
        return this.mManager.getHost().getContext().getText(this.mBreadCrumbTitleRes);
    }

    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    public int getId() {
        return this.mIndex;
    }

    public String getName() {
        return this.mName;
    }

    public FragmentTransaction hide(Fragment fragment) {
        if (fragment.mFragmentManager == null) return super.hide(fragment);
        if (fragment.mFragmentManager == this.mManager) {
            return super.hide(fragment);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot hide Fragment attached to a different FragmentManager. Fragment ");
        stringBuilder.append(fragment.toString());
        stringBuilder.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    boolean interactsWith(int n) {
        int n2 = this.mOps.size();
        int n3 = 0;
        while (n3 < n2) {
            FragmentTransaction.Op op = (FragmentTransaction.Op)this.mOps.get(n3);
            int n4 = op.mFragment != null ? op.mFragment.mContainerId : 0;
            if (n4 != 0 && n4 == n) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    boolean interactsWith(ArrayList<BackStackRecord> var1_1, int var2_2, int var3_3) {
        if (var3_3 == var2_2) {
            return false;
        }
        var9_4 = this.mOps.size();
        var6_5 = -1;
        var5_6 = 0;
        block0: while (true) {
            if (var5_6 >= var9_4) return false;
            var11_11 = (FragmentTransaction.Op)this.mOps.get(var5_6);
            var4_7 = var11_11.mFragment != null ? var11_11.mFragment.mContainerId : 0;
            var7_8 = var6_5;
            if (var4_7 == 0) ** GOTO lbl21
            var7_8 = var6_5;
            if (var4_7 == var6_5) ** GOTO lbl21
            var6_5 = var2_2;
            while (true) {
                if (var6_5 < var3_3) {
                    var12_12 = var1_1.get(var6_5);
                    var10_10 = var12_12.mOps.size();
                } else {
                    var7_8 = var4_7;
lbl21:
                    // 3 sources

                    ++var5_6;
                    var6_5 = var7_8;
                    continue block0;
                }
                for (var7_8 = 0; var7_8 < var10_10; ++var7_8) {
                    var11_11 = (FragmentTransaction.Op)var12_12.mOps.get(var7_8);
                    var8_9 = var11_11.mFragment != null ? var11_11.mFragment.mContainerId : 0;
                    if (var8_9 != var4_7) continue;
                    return true;
                }
                ++var6_5;
            }
            break;
        }
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    boolean isPostponed() {
        int n = 0;
        while (n < this.mOps.size()) {
            if (BackStackRecord.isFragmentPostponed((FragmentTransaction.Op)this.mOps.get(n))) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public FragmentTransaction remove(Fragment fragment) {
        if (fragment.mFragmentManager == null) return super.remove(fragment);
        if (fragment.mFragmentManager == this.mManager) {
            return super.remove(fragment);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        stringBuilder.append(fragment.toString());
        stringBuilder.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void runOnCommitRunnables() {
        if (this.mCommitRunnables == null) return;
        int n = 0;
        while (true) {
            if (n >= this.mCommitRunnables.size()) {
                this.mCommitRunnables = null;
                return;
            }
            ((Runnable)this.mCommitRunnables.get(n)).run();
            ++n;
        }
    }

    public FragmentTransaction setMaxLifecycle(Fragment object, Lifecycle.State state) {
        if (((Fragment)object).mFragmentManager != this.mManager) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
            ((StringBuilder)object).append(this.mManager);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (state == Lifecycle.State.INITIALIZED && ((Fragment)object).mState > -1) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot set maximum Lifecycle to ");
            ((StringBuilder)object).append(state);
            ((StringBuilder)object).append(" after the Fragment has been created");
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (state != Lifecycle.State.DESTROYED) {
            return super.setMaxLifecycle((Fragment)object, state);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot set maximum Lifecycle to ");
        ((StringBuilder)object).append(state);
        ((StringBuilder)object).append(". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        int n = 0;
        while (n < this.mOps.size()) {
            FragmentTransaction.Op op = (FragmentTransaction.Op)this.mOps.get(n);
            if (BackStackRecord.isFragmentPostponed(op)) {
                op.mFragment.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
            ++n;
        }
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment == null) return super.setPrimaryNavigationFragment(fragment);
        if (fragment.mFragmentManager == null) return super.setPrimaryNavigationFragment(fragment);
        if (fragment.mFragmentManager == this.mManager) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
        stringBuilder.append(fragment.toString());
        stringBuilder.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public FragmentTransaction show(Fragment fragment) {
        if (fragment.mFragmentManager == null) return super.show(fragment);
        if (fragment.mFragmentManager == this.mManager) {
            return super.show(fragment);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot show Fragment attached to a different FragmentManager. Fragment ");
        stringBuilder.append(fragment.toString());
        stringBuilder.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode((Object)this)));
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mName != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mName);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /*
     * Unable to fully structure code
     */
    Fragment trackAddedFragmentsInPop(ArrayList<Fragment> var1_1, Fragment var2_2) {
        var3_3 = this.mOps.size() - 1;
        while (var3_3 >= 0) {
            var5_5 = (FragmentTransaction.Op)this.mOps.get(var3_3);
            var4_4 = var5_5.mCmd;
            if (var4_4 == 1) ** GOTO lbl-1000
            if (var4_4 == 3) ** GOTO lbl-1000
            switch (var4_4) {
                default: {
                    break;
                }
                case 10: {
                    var5_5.mCurrentMaxState = var5_5.mOldMaxState;
                    break;
                }
                case 9: {
                    var2_2 = var5_5.mFragment;
                    break;
                }
                case 8: {
                    var2_2 = null;
                    break;
                }
                case 6: lbl-1000:
                // 2 sources

                {
                    var1_1.add(var5_5.mFragment);
                    break;
                }
                case 7: lbl-1000:
                // 2 sources

                {
                    var1_1.remove(var5_5.mFragment);
                }
            }
            --var3_3;
        }
        return var2_2;
    }
}

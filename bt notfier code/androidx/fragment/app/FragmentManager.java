/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.LayoutInflater$Factory2
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.activity.OnBackPressedCallback
 *  androidx.activity.OnBackPressedDispatcher
 *  androidx.activity.OnBackPressedDispatcherOwner
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.activity.result.ActivityResultRegistryOwner
 *  androidx.activity.result.IntentSenderRequest
 *  androidx.activity.result.IntentSenderRequest$Builder
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions
 *  androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult
 *  androidx.collection.ArraySet
 *  androidx.core.os.CancellationSignal
 *  androidx.fragment.R$id
 *  androidx.fragment.app.BackStackRecord
 *  androidx.fragment.app.BackStackState
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.Fragment$OnStartEnterTransitionListener
 *  androidx.fragment.app.Fragment$SavedState
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentAnim
 *  androidx.fragment.app.FragmentAnim$AnimationOrAnimator
 *  androidx.fragment.app.FragmentContainer
 *  androidx.fragment.app.FragmentContainerView
 *  androidx.fragment.app.FragmentFactory
 *  androidx.fragment.app.FragmentHostCallback
 *  androidx.fragment.app.FragmentLayoutInflaterFactory
 *  androidx.fragment.app.FragmentLifecycleCallbacksDispatcher
 *  androidx.fragment.app.FragmentManager$6
 *  androidx.fragment.app.FragmentManager$BackStackEntry
 *  androidx.fragment.app.FragmentManager$FragmentIntentSenderContract
 *  androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
 *  androidx.fragment.app.FragmentManager$LaunchedFragmentInfo
 *  androidx.fragment.app.FragmentManager$LifecycleAwareResultListener
 *  androidx.fragment.app.FragmentManager$OnBackStackChangedListener
 *  androidx.fragment.app.FragmentManager$OpGenerator
 *  androidx.fragment.app.FragmentManager$PopBackStackState
 *  androidx.fragment.app.FragmentManager$StartEnterTransitionListener
 *  androidx.fragment.app.FragmentManagerNonConfig
 *  androidx.fragment.app.FragmentManagerState
 *  androidx.fragment.app.FragmentManagerViewModel
 *  androidx.fragment.app.FragmentOnAttachListener
 *  androidx.fragment.app.FragmentResultListener
 *  androidx.fragment.app.FragmentResultOwner
 *  androidx.fragment.app.FragmentState
 *  androidx.fragment.app.FragmentStateManager
 *  androidx.fragment.app.FragmentStore
 *  androidx.fragment.app.FragmentTransaction
 *  androidx.fragment.app.FragmentTransaction$Op
 *  androidx.fragment.app.FragmentTransition
 *  androidx.fragment.app.FragmentTransition$Callback
 *  androidx.fragment.app.LogWriter
 *  androidx.fragment.app.SpecialEffectsController
 *  androidx.fragment.app.SpecialEffectsControllerFactory
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.ViewModelStore
 *  androidx.lifecycle.ViewModelStoreOwner
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.fragment.R;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.BackStackState;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentLayoutInflaterFactory;
import androidx.fragment.app.FragmentLifecycleCallbacksDispatcher;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.fragment.app.FragmentManagerState;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentResultOwner;
import androidx.fragment.app.FragmentState;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.FragmentStore;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.LogWriter;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SpecialEffectsControllerFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager
implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String TAG = "FragmentManager";
    static boolean USE_STATE_MANAGER = true;
    ArrayList<BackStackRecord> mBackStack;
    private ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex;
    private FragmentContainer mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    int mCurState = -1;
    private SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory;
    private boolean mDestroyed;
    private Runnable mExecCommit;
    private boolean mExecutingActions;
    private Map<Fragment, HashSet<CancellationSignal>> mExitAnimationCancellationSignals;
    private FragmentFactory mFragmentFactory = null;
    private final FragmentStore mFragmentStore;
    private final FragmentTransition.Callback mFragmentTransitionCallback;
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback<?> mHost;
    private FragmentFactory mHostFragmentFactory;
    ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments;
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory;
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher;
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private final CopyOnWriteArrayList<FragmentOnAttachListener> mOnAttachListeners;
    private final OnBackPressedCallback mOnBackPressedCallback;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private Fragment mParent;
    private final ArrayList<OpGenerator> mPendingActions = new ArrayList();
    private ArrayList<StartEnterTransitionListener> mPostponedTransactions;
    Fragment mPrimaryNav;
    private ActivityResultLauncher<String[]> mRequestPermissions;
    private final Map<String, LifecycleAwareResultListener> mResultListeners;
    private final Map<String, Bundle> mResults;
    private SpecialEffectsControllerFactory mSpecialEffectsControllerFactory = null;
    private ActivityResultLauncher<Intent> mStartActivityForResult;
    private ActivityResultLauncher<IntentSenderRequest> mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private ArrayList<Fragment> mTmpAddedFragments;
    private ArrayList<Boolean> mTmpIsPop;
    private ArrayList<BackStackRecord> mTmpRecords;

    public FragmentManager() {
        this.mFragmentStore = new FragmentStore();
        this.mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
        this.mOnBackPressedCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.mBackStackIndex = new AtomicInteger();
        this.mResults = Collections.synchronizedMap(new HashMap());
        this.mResultListeners = Collections.synchronizedMap(new HashMap());
        this.mExitAnimationCancellationSignals = Collections.synchronizedMap(new HashMap());
        this.mFragmentTransitionCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        this.mHostFragmentFactory = new /* Unavailable Anonymous Inner Class!! */;
        this.mDefaultSpecialEffectsControllerFactory = new /* Unavailable Anonymous Inner Class!! */;
        this.mLaunchedFragments = new ArrayDeque();
        this.mExecCommit = new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ Map access$000(FragmentManager fragmentManager) {
        return fragmentManager.mResults;
    }

    static /* synthetic */ Map access$100(FragmentManager fragmentManager) {
        return fragmentManager.mResultListeners;
    }

    static /* synthetic */ FragmentStore access$200(FragmentManager fragmentManager) {
        return fragmentManager.mFragmentStore;
    }

    private void addAddedFragments(ArraySet<Fragment> arraySet) {
        int n = this.mCurState;
        if (n < 1) {
            return;
        }
        n = Math.min(n, 5);
        Iterator iterator = this.mFragmentStore.getFragments().iterator();
        while (iterator.hasNext()) {
            Fragment fragment = (Fragment)iterator.next();
            if (fragment.mState >= n) continue;
            this.moveToState(fragment, n);
            if (fragment.mView == null || fragment.mHidden || !fragment.mIsNewlyAdded) continue;
            arraySet.add((Object)fragment);
        }
    }

    private void cancelExitAnimation(Fragment fragment) {
        HashSet<CancellationSignal> hashSet = this.mExitAnimationCancellationSignals.get(fragment);
        if (hashSet == null) return;
        Iterator<CancellationSignal> iterator = hashSet.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                hashSet.clear();
                this.destroyFragmentView(fragment);
                this.mExitAnimationCancellationSignals.remove(fragment);
                return;
            }
            iterator.next().cancel();
        }
    }

    private void checkStateLoss() {
        if (this.isStateSaved()) throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private Set<SpecialEffectsController> collectAllSpecialEffectsController() {
        HashSet<SpecialEffectsController> hashSet = new HashSet<SpecialEffectsController>();
        Iterator iterator = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (iterator.hasNext()) {
            ViewGroup viewGroup = ((FragmentStateManager)iterator.next()).getFragment().mContainer;
            if (viewGroup == null) continue;
            hashSet.add(SpecialEffectsController.getOrCreateController((ViewGroup)viewGroup, (SpecialEffectsControllerFactory)this.getSpecialEffectsControllerFactory()));
        }
        return hashSet;
    }

    private Set<SpecialEffectsController> collectChangedControllers(ArrayList<BackStackRecord> arrayList, int n, int n2) {
        HashSet<SpecialEffectsController> hashSet = new HashSet<SpecialEffectsController>();
        while (n < n2) {
            Iterator iterator = arrayList.get((int)n).mOps.iterator();
            while (iterator.hasNext()) {
                Fragment fragment = ((FragmentTransaction.Op)iterator.next()).mFragment;
                if (fragment == null || (fragment = fragment.mContainer) == null) continue;
                hashSet.add(SpecialEffectsController.getOrCreateController((ViewGroup)fragment, (FragmentManager)this));
            }
            ++n;
        }
        return hashSet;
    }

    private void completeShowHideFragment(Fragment fragment) {
        if (fragment.mView != null) {
            FragmentAnim.AnimationOrAnimator animationOrAnimator = FragmentAnim.loadAnimation((Context)this.mHost.getContext(), (Fragment)fragment, (boolean)(fragment.mHidden ^ true), (boolean)fragment.getPopDirection());
            if (animationOrAnimator != null && animationOrAnimator.animator != null) {
                animationOrAnimator.animator.setTarget((Object)fragment.mView);
                if (fragment.mHidden) {
                    if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    } else {
                        ViewGroup viewGroup = fragment.mContainer;
                        View view = fragment.mView;
                        viewGroup.startViewTransition(view);
                        animationOrAnimator.animator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
                    }
                } else {
                    fragment.mView.setVisibility(0);
                }
                animationOrAnimator.animator.start();
            } else {
                if (animationOrAnimator != null) {
                    fragment.mView.startAnimation(animationOrAnimator.animation);
                    animationOrAnimator.animation.start();
                }
                int n = fragment.mHidden && !fragment.isHideReplaced() ? 8 : 0;
                fragment.mView.setVisibility(n);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            }
        }
        this.invalidateMenuForFragment(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void destroyFragmentView(Fragment fragment) {
        fragment.performDestroyView();
        this.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(Fragment fragment) {
        if (fragment == null) return;
        if (!fragment.equals((Object)this.findActiveFragment(fragment.mWho))) return;
        fragment.performPrimaryNavigationFragmentChanged();
    }

    private void dispatchStateChange(int n) {
        try {
            this.mExecutingActions = true;
            this.mFragmentStore.dispatchStateChange(n);
            this.moveToState(n, false);
            if (USE_STATE_MANAGER) {
                Iterator<SpecialEffectsController> iterator = this.collectAllSpecialEffectsController().iterator();
                while (iterator.hasNext()) {
                    iterator.next().forceCompleteAllOperations();
                }
            }
            this.mExecutingActions = false;
            this.execPendingActions(true);
        }
        catch (Throwable throwable) {
            this.mExecutingActions = false;
            throw throwable;
        }
    }

    private void doPendingDeferredStart() {
        if (!this.mHavePendingDeferredStart) return;
        this.mHavePendingDeferredStart = false;
        this.startPendingDeferredFragments();
    }

    @Deprecated
    public static void enableDebugLogging(boolean bl) {
        DEBUG = bl;
    }

    public static void enableNewStateManager(boolean bl) {
        USE_STATE_MANAGER = bl;
    }

    private void endAnimatingAwayFragments() {
        if (USE_STATE_MANAGER) {
            Iterator<SpecialEffectsController> iterator = this.collectAllSpecialEffectsController().iterator();
            while (iterator.hasNext()) {
                iterator.next().forceCompleteAllOperations();
            }
            return;
        }
        if (this.mExitAnimationCancellationSignals.isEmpty()) return;
        Iterator<Fragment> iterator = this.mExitAnimationCancellationSignals.keySet().iterator();
        while (iterator.hasNext()) {
            Fragment fragment = iterator.next();
            this.cancelExitAnimation(fragment);
            this.moveToState(fragment);
        }
    }

    private void ensureExecReady(boolean bl) {
        if (this.mExecutingActions) throw new IllegalStateException("FragmentManager is already executing transactions");
        if (this.mHost == null) {
            if (!this.mDestroyed) throw new IllegalStateException("FragmentManager has not been attached to a host.");
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.mHost.getHandler().getLooper()) throw new IllegalStateException("Must be called from main thread of fragment host");
        if (!bl) {
            this.checkStateLoss();
        }
        if (this.mTmpRecords == null) {
            this.mTmpRecords = new ArrayList();
            this.mTmpIsPop = new ArrayList();
        }
        this.mExecutingActions = true;
        try {
            this.executePostponedTransaction(null, null);
            return;
        }
        finally {
            this.mExecutingActions = false;
        }
    }

    private static void executeOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int n, int n2) {
        while (n < n2) {
            BackStackRecord backStackRecord = arrayList.get(n);
            boolean bl = arrayList2.get(n);
            boolean bl2 = true;
            if (bl) {
                backStackRecord.bumpBackStackNesting(-1);
                if (n != n2 - 1) {
                    bl2 = false;
                }
                backStackRecord.executePopOps(bl2);
            } else {
                backStackRecord.bumpBackStackNesting(1);
                backStackRecord.executeOps();
            }
            ++n;
        }
    }

    private void executeOpsTogether(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int n, int n2) {
        int n3;
        boolean bl = arrayList.get((int)n).mReorderingAllowed;
        Object object2 = this.mTmpAddedFragments;
        if (object2 == null) {
            this.mTmpAddedFragments = new ArrayList();
        } else {
            ((ArrayList)object2).clear();
        }
        this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
        object2 = this.getPrimaryNavigationFragment();
        boolean bl2 = false;
        for (n3 = n; n3 < n2; ++n3) {
            BackStackRecord object3 = arrayList.get(n3);
            object2 = arrayList2.get(n3) == false ? object3.expandOps(this.mTmpAddedFragments, (Fragment)object2) : object3.trackAddedFragmentsInPop(this.mTmpAddedFragments, (Fragment)object2);
            if (!bl2 && !object3.mAddToBackStack) {
                bl2 = false;
                continue;
            }
            bl2 = true;
        }
        this.mTmpAddedFragments.clear();
        if (!bl && this.mCurState >= 1) {
            if (!USE_STATE_MANAGER) {
                FragmentTransition.startTransitions((Context)this.mHost.getContext(), (FragmentContainer)this.mContainer, arrayList, arrayList2, (int)n, (int)n2, (boolean)false, (FragmentTransition.Callback)this.mFragmentTransitionCallback);
            } else {
                for (n3 = n; n3 < n2; ++n3) {
                    object2 = arrayList.get((int)n3).mOps.iterator();
                    while (object2.hasNext()) {
                        Fragment fragment = ((FragmentTransaction.Op)object2.next()).mFragment;
                        if (fragment == null || fragment.mFragmentManager == null) continue;
                        FragmentStateManager fragmentStateManager = this.createOrGetFragmentStateManager(fragment);
                        this.mFragmentStore.makeActive(fragmentStateManager);
                    }
                }
            }
        }
        FragmentManager.executeOps(arrayList, arrayList2, n, n2);
        if (!USE_STATE_MANAGER) {
            if (bl) {
                object2 = new ArraySet();
                this.addAddedFragments((ArraySet<Fragment>)object2);
                n3 = this.postponePostponableTransactions(arrayList, arrayList2, n, n2, (ArraySet<Fragment>)object2);
                this.makeRemovedFragmentsInvisible((ArraySet<Fragment>)object2);
            } else {
                n3 = n2;
            }
            if (n3 != n && bl) {
                if (this.mCurState >= 1) {
                    FragmentTransition.startTransitions((Context)this.mHost.getContext(), (FragmentContainer)this.mContainer, arrayList, arrayList2, (int)n, (int)n3, (boolean)true, (FragmentTransition.Callback)this.mFragmentTransitionCallback);
                }
                object2 = arrayList2;
                n3 = n2;
                this.moveToState(this.mCurState, true);
            } else {
                object2 = arrayList2;
                n3 = n2;
            }
        } else {
            bl = arrayList2.get(n2 - 1);
            for (n3 = n; n3 < n2; ++n3) {
                object2 = arrayList.get(n3);
                if (bl) {
                    for (int i = ((BackStackRecord)object2).mOps.size() - 1; i >= 0; --i) {
                        Fragment fragment = ((FragmentTransaction.Op)((BackStackRecord)object2).mOps.get((int)i)).mFragment;
                        if (fragment == null) continue;
                        this.createOrGetFragmentStateManager(fragment).moveToExpectedState();
                    }
                    continue;
                }
                Iterator iterator = ((BackStackRecord)object2).mOps.iterator();
                while (iterator.hasNext()) {
                    object2 = ((FragmentTransaction.Op)iterator.next()).mFragment;
                    if (object2 == null) continue;
                    this.createOrGetFragmentStateManager((Fragment)object2).moveToExpectedState();
                }
            }
            this.moveToState(this.mCurState, true);
            for (SpecialEffectsController specialEffectsController : this.collectChangedControllers(arrayList, n, n2)) {
                specialEffectsController.updateOperationDirection(bl);
                specialEffectsController.markPostponedState();
                specialEffectsController.executePendingOperations();
            }
            n3 = n2;
            object2 = arrayList2;
        }
        while (true) {
            if (n >= n2) {
                if (!bl2) return;
                this.reportBackStackChanged();
                return;
            }
            object2 = arrayList.get(n);
            if (arrayList2.get(n).booleanValue() && ((BackStackRecord)object2).mIndex >= 0) {
                ((BackStackRecord)object2).mIndex = -1;
            }
            object2.runOnCommitRunnables();
            ++n;
        }
    }

    private void executePostponedTransaction(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        StartEnterTransitionListener startEnterTransitionListener = this.mPostponedTransactions;
        int n = startEnterTransitionListener == null ? 0 : startEnterTransitionListener.size();
        int n2 = 0;
        int n3 = n;
        while (n2 < n3) {
            int n4;
            block7: {
                block8: {
                    block6: {
                        startEnterTransitionListener = this.mPostponedTransactions.get(n2);
                        if (arrayList == null || startEnterTransitionListener.mIsBack || (n = arrayList.indexOf(startEnterTransitionListener.mRecord)) == -1 || arrayList2 == null || !arrayList2.get(n).booleanValue()) break block6;
                        this.mPostponedTransactions.remove(n2);
                        n4 = n2 - 1;
                        n = n3 - 1;
                        startEnterTransitionListener.cancelTransaction();
                        break block7;
                    }
                    if (startEnterTransitionListener.isReady()) break block8;
                    n = n3;
                    n4 = n2;
                    if (arrayList == null) break block7;
                    n = n3;
                    n4 = n2;
                    if (!startEnterTransitionListener.mRecord.interactsWith(arrayList, 0, arrayList.size())) break block7;
                }
                this.mPostponedTransactions.remove(n2);
                n4 = n2 - 1;
                n = n3 - 1;
                if (arrayList != null && !startEnterTransitionListener.mIsBack && (n2 = arrayList.indexOf(startEnterTransitionListener.mRecord)) != -1 && arrayList2 != null && arrayList2.get(n2).booleanValue()) {
                    startEnterTransitionListener.cancelTransaction();
                } else {
                    startEnterTransitionListener.completeTransaction();
                }
            }
            n2 = n4 + 1;
            n3 = n;
        }
    }

    public static <F extends Fragment> F findFragment(View view) {
        Object object = FragmentManager.findViewFragment(view);
        if (object != null) {
            return (F)object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("View ");
        ((StringBuilder)object).append(view);
        ((StringBuilder)object).append(" does not have a Fragment set");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    static FragmentManager findFragmentManager(View object) {
        Fragment fragment = FragmentManager.findViewFragment(object);
        if (fragment != null) {
            if (!fragment.isAdded()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The Fragment ");
                stringBuilder.append(fragment);
                stringBuilder.append(" that owns View ");
                stringBuilder.append(object);
                stringBuilder.append(" has already been destroyed. Nested fragments should always use the child FragmentManager.");
                throw new IllegalStateException(stringBuilder.toString());
            }
            object = fragment.getChildFragmentManager();
        } else {
            Object object2;
            fragment = object.getContext();
            FragmentActivity fragmentActivity = null;
            while (true) {
                object2 = fragmentActivity;
                if (!(fragment instanceof ContextWrapper)) break;
                if (fragment instanceof FragmentActivity) {
                    object2 = (FragmentActivity)fragment;
                    break;
                }
                fragment = ((ContextWrapper)fragment).getBaseContext();
            }
            if (object2 == null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("View ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(" is not within a subclass of FragmentActivity.");
                object = new IllegalStateException(((StringBuilder)object2).toString());
                throw object;
            }
            object = object2.getSupportFragmentManager();
        }
        return object;
    }

    private static Fragment findViewFragment(View view) {
        while (view != null) {
            Fragment fragment = FragmentManager.getViewFragment(view);
            if (fragment != null) {
                return fragment;
            }
            if ((view = view.getParent()) instanceof View) continue;
            view = null;
        }
        return null;
    }

    private void forcePostponedTransactions() {
        if (USE_STATE_MANAGER) {
            Iterator<SpecialEffectsController> iterator = this.collectAllSpecialEffectsController().iterator();
            while (iterator.hasNext()) {
                iterator.next().forcePostponedExecutePendingOperations();
            }
            return;
        }
        if (this.mPostponedTransactions == null) return;
        while (!this.mPostponedTransactions.isEmpty()) {
            this.mPostponedTransactions.remove(0).completeTransaction();
        }
    }

    /*
     * Enabled force condition propagation
     */
    private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        ArrayList<OpGenerator> arrayList3 = this.mPendingActions;
        synchronized (arrayList3) {
            boolean bl = this.mPendingActions.isEmpty();
            if (bl) {
                return false;
            }
            int n = this.mPendingActions.size();
            bl = false;
            for (int i = 0; i < n; bl |= this.mPendingActions.get(i).generateOps(arrayList, arrayList2), ++i) {
            }
            this.mPendingActions.clear();
            this.mHost.getHandler().removeCallbacks(this.mExecCommit);
            return bl;
        }
    }

    private FragmentManagerViewModel getChildNonConfig(Fragment fragment) {
        return this.mNonConfig.getChildNonConfig(fragment);
    }

    private ViewGroup getFragmentContainer(Fragment fragment) {
        if (fragment.mContainer != null) {
            return fragment.mContainer;
        }
        if (fragment.mContainerId <= 0) {
            return null;
        }
        if (!this.mContainer.onHasView()) return null;
        fragment = this.mContainer.onFindViewById(fragment.mContainerId);
        if (!(fragment instanceof ViewGroup)) return null;
        return (ViewGroup)fragment;
    }

    static Fragment getViewFragment(View object) {
        if (!((object = object.getTag(R.id.fragment_container_view_tag)) instanceof Fragment)) return null;
        return (Fragment)object;
    }

    static boolean isLoggingEnabled(int n) {
        boolean bl = DEBUG || Log.isLoggable((String)TAG, (int)n);
        return bl;
    }

    private boolean isMenuAvailable(Fragment fragment) {
        boolean bl = fragment.mHasMenu && fragment.mMenuVisible || fragment.mChildFragmentManager.checkForMenus();
        return bl;
    }

    private void makeRemovedFragmentsInvisible(ArraySet<Fragment> arraySet) {
        int n = arraySet.size();
        int n2 = 0;
        while (n2 < n) {
            Fragment fragment = (Fragment)arraySet.valueAt(n2);
            if (!fragment.mAdded) {
                View view = fragment.requireView();
                fragment.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
            ++n2;
        }
    }

    private boolean popBackStackImmediate(String string, int n, int n2) {
        this.execPendingActions(false);
        this.ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && n < 0 && string == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean bl = this.popBackStackState(this.mTmpRecords, this.mTmpIsPop, string, n, n2);
        if (bl) {
            this.mExecutingActions = true;
            try {
                this.removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            }
            finally {
                this.cleanupExec();
            }
        }
        this.updateOnBackPressedCallbackEnabled();
        this.doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return bl;
    }

    private int postponePostponableTransactions(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int n, int n2, ArraySet<Fragment> arraySet) {
        int n3 = n2 - 1;
        int n4 = n2;
        while (n3 >= n) {
            BackStackRecord backStackRecord = arrayList.get(n3);
            boolean bl = arrayList2.get(n3);
            boolean bl2 = backStackRecord.isPostponed() && !backStackRecord.interactsWith(arrayList, n3 + 1, n2);
            int n5 = n4;
            if (bl2) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList();
                }
                StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, bl);
                this.mPostponedTransactions.add(startEnterTransitionListener);
                backStackRecord.setOnStartPostponedListener((Fragment.OnStartEnterTransitionListener)startEnterTransitionListener);
                if (bl) {
                    backStackRecord.executeOps();
                } else {
                    backStackRecord.executePopOps(false);
                }
                n5 = n4 - 1;
                if (n3 != n5) {
                    arrayList.remove(n3);
                    arrayList.add(n5, backStackRecord);
                }
                this.addAddedFragments(arraySet);
            }
            --n3;
            n4 = n5;
        }
        return n4;
    }

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> serializable, ArrayList<Boolean> arrayList) {
        if (((ArrayList)serializable).isEmpty()) {
            return;
        }
        if (((ArrayList)serializable).size() != arrayList.size()) {
            serializable = new IllegalStateException("Internal error with the back stack records");
            throw serializable;
        }
        this.executePostponedTransaction((ArrayList<BackStackRecord>)serializable, arrayList);
        int n = ((ArrayList)serializable).size();
        int n2 = 0;
        int n3 = 0;
        while (true) {
            if (n2 >= n) {
                if (n3 == n) return;
                this.executeOpsTogether((ArrayList<BackStackRecord>)serializable, arrayList, n3, n);
                return;
            }
            int n4 = n2;
            int n5 = n3;
            if (!((BackStackRecord)((ArrayList)serializable).get((int)n2)).mReorderingAllowed) {
                if (n3 != n2) {
                    this.executeOpsTogether((ArrayList<BackStackRecord>)serializable, arrayList, n3, n2);
                }
                n5 = n3 = n2 + 1;
                if (arrayList.get(n2).booleanValue()) {
                    while (true) {
                        n5 = n3;
                        if (n3 >= n) break;
                        n5 = n3;
                        if (!arrayList.get(n3).booleanValue()) break;
                        n5 = n3;
                        if (((BackStackRecord)((ArrayList)serializable).get((int)n3)).mReorderingAllowed) break;
                        ++n3;
                    }
                }
                this.executeOpsTogether((ArrayList<BackStackRecord>)serializable, arrayList, n2, n5);
                n4 = n5 - 1;
            }
            n2 = n4 + 1;
            n3 = n5;
        }
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners == null) return;
        int n = 0;
        while (n < this.mBackStackChangeListeners.size()) {
            this.mBackStackChangeListeners.get(n).onBackStackChanged();
            ++n;
        }
    }

    static int reverseTransit(int n) {
        int n2 = 8194;
        if (n == 4097) return n2;
        n2 = n != 4099 ? (n != 8194 ? 0 : 4097) : 4099;
        return n2;
    }

    private void setVisibleRemovingFragment(Fragment fragment) {
        ViewGroup viewGroup = this.getFragmentContainer(fragment);
        if (viewGroup == null) return;
        if (fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) return;
        if (viewGroup.getTag(R.id.visible_removing_fragment_view_tag) == null) {
            viewGroup.setTag(R.id.visible_removing_fragment_view_tag, (Object)fragment);
        }
        ((Fragment)viewGroup.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
    }

    private void startPendingDeferredFragments() {
        Iterator iterator = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (iterator.hasNext()) {
            this.performPendingDeferredStart((FragmentStateManager)iterator.next());
        }
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e((String)TAG, (String)runtimeException.getMessage());
        Log.e((String)TAG, (String)"Activity state:");
        PrintWriter printWriter = new PrintWriter((Writer)new LogWriter(TAG));
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump("  ", null, printWriter, new String[0]);
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)"Failed dumping state", (Throwable)exception);
            }
        } else {
            try {
                this.dump("  ", null, printWriter, new String[0]);
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)"Failed dumping state", (Throwable)exception);
            }
        }
        throw runtimeException;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void updateOnBackPressedCallbackEnabled() {
        ArrayList<OpGenerator> arrayList = this.mPendingActions;
        synchronized (arrayList) {
            boolean bl = this.mPendingActions.isEmpty();
            boolean bl2 = true;
            if (!bl) {
                this.mOnBackPressedCallback.setEnabled(true);
                return;
            }
            OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
            if (this.getBackStackEntryCount() <= 0 || !this.isPrimaryNavigation(this.mParent)) {
                bl2 = false;
            }
            onBackPressedCallback.setEnabled(bl2);
            return;
        }
    }

    void addBackStackState(BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList();
        }
        this.mBackStack.add(backStackRecord);
    }

    void addCancellationSignal(Fragment fragment, CancellationSignal cancellationSignal) {
        if (this.mExitAnimationCancellationSignals.get(fragment) == null) {
            this.mExitAnimationCancellationSignals.put(fragment, new HashSet());
        }
        this.mExitAnimationCancellationSignals.get(fragment).add(cancellationSignal);
    }

    FragmentStateManager addFragment(Fragment fragment) {
        StringBuilder stringBuilder;
        if (FragmentManager.isLoggingEnabled(2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("add: ");
            stringBuilder.append(fragment);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        stringBuilder = this.createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        this.mFragmentStore.makeActive((FragmentStateManager)stringBuilder);
        if (fragment.mDetached) return stringBuilder;
        this.mFragmentStore.addFragment(fragment);
        fragment.mRemoving = false;
        if (fragment.mView == null) {
            fragment.mHiddenChanged = false;
        }
        if (!this.isMenuAvailable(fragment)) return stringBuilder;
        this.mNeedMenuInvalidate = true;
        return stringBuilder;
    }

    public void addFragmentOnAttachListener(FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.add(fragmentOnAttachListener);
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    void addRetainedFragment(Fragment fragment) {
        this.mNonConfig.addRetainedFragment(fragment);
    }

    int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    void attachController(FragmentHostCallback<?> object, FragmentContainer fragmentContainer, Fragment object2) {
        if (this.mHost != null) throw new IllegalStateException("Already attached");
        this.mHost = object;
        this.mContainer = fragmentContainer;
        this.mParent = object2;
        if (object2 != null) {
            this.addFragmentOnAttachListener((FragmentOnAttachListener)new /* Unavailable Anonymous Inner Class!! */);
        } else if (object instanceof FragmentOnAttachListener) {
            this.addFragmentOnAttachListener((FragmentOnAttachListener)object);
        }
        if (this.mParent != null) {
            this.updateOnBackPressedCallbackEnabled();
        }
        if (object instanceof OnBackPressedDispatcherOwner) {
            fragmentContainer = (OnBackPressedDispatcherOwner)object;
            this.mOnBackPressedDispatcher = fragmentContainer.getOnBackPressedDispatcher();
            if (object2 != null) {
                fragmentContainer = object2;
            }
            this.mOnBackPressedDispatcher.addCallback((LifecycleOwner)fragmentContainer, this.mOnBackPressedCallback);
        }
        this.mNonConfig = object2 != null ? ((Fragment)object2).mFragmentManager.getChildNonConfig((Fragment)object2) : (object instanceof ViewModelStoreOwner ? FragmentManagerViewModel.getInstance((ViewModelStore)((ViewModelStoreOwner)object).getViewModelStore()) : new FragmentManagerViewModel(false));
        this.mNonConfig.setIsStateSaved(this.isStateSaved());
        this.mFragmentStore.setNonConfig(this.mNonConfig);
        object = this.mHost;
        if (!(object instanceof ActivityResultRegistryOwner)) return;
        fragmentContainer = ((ActivityResultRegistryOwner)object).getActivityResultRegistry();
        if (object2 != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(((Fragment)object2).mWho);
            ((StringBuilder)object).append(":");
            object = ((StringBuilder)object).toString();
        } else {
            object = "";
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("FragmentManager:");
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("StartActivityForResult");
        this.mStartActivityForResult = fragmentContainer.register(((StringBuilder)object2).toString(), (ActivityResultContract)new ActivityResultContracts.StartActivityForResult(), (ActivityResultCallback)new /* Unavailable Anonymous Inner Class!! */);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("StartIntentSenderForResult");
        this.mStartIntentSenderForResult = fragmentContainer.register(((StringBuilder)object2).toString(), (ActivityResultContract)new FragmentIntentSenderContract(), (ActivityResultCallback)new /* Unavailable Anonymous Inner Class!! */);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("RequestPermissions");
        this.mRequestPermissions = fragmentContainer.register(((StringBuilder)object2).toString(), (ActivityResultContract)new ActivityResultContracts.RequestMultiplePermissions(), (ActivityResultCallback)new /* Unavailable Anonymous Inner Class!! */);
    }

    void attachFragment(Fragment fragment) {
        StringBuilder stringBuilder;
        if (FragmentManager.isLoggingEnabled(2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("attach: ");
            stringBuilder.append(fragment);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        if (!fragment.mDetached) return;
        fragment.mDetached = false;
        if (fragment.mAdded) return;
        this.mFragmentStore.addFragment(fragment);
        if (FragmentManager.isLoggingEnabled(2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("add from attach: ");
            stringBuilder.append(fragment);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        if (!this.isMenuAvailable(fragment)) return;
        this.mNeedMenuInvalidate = true;
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    boolean checkForMenus() {
        boolean bl;
        Iterator iterator = this.mFragmentStore.getActiveFragments().iterator();
        boolean bl2 = false;
        do {
            if (!iterator.hasNext()) return false;
            Fragment fragment = (Fragment)iterator.next();
            bl = bl2;
            if (fragment != null) {
                bl = this.isMenuAvailable(fragment);
            }
            bl2 = bl;
        } while (!bl);
        return true;
    }

    public final void clearFragmentResult(String string) {
        this.mResults.remove(string);
    }

    public final void clearFragmentResultListener(String string) {
        if ((string = this.mResultListeners.remove(string)) == null) return;
        string.removeObserver();
    }

    void completeExecute(BackStackRecord backStackRecord, boolean bl, boolean bl2, boolean bl3) {
        if (bl) {
            backStackRecord.executePopOps(bl3);
        } else {
            backStackRecord.executeOps();
        }
        Object object = new ArrayList<BackStackRecord>(1);
        Fragment fragment = new ArrayList(1);
        ((ArrayList)object).add(backStackRecord);
        fragment.add(bl);
        if (bl2 && this.mCurState >= 1) {
            FragmentTransition.startTransitions((Context)this.mHost.getContext(), (FragmentContainer)this.mContainer, (ArrayList)object, (ArrayList)fragment, (int)0, (int)1, (boolean)true, (FragmentTransition.Callback)this.mFragmentTransitionCallback);
        }
        if (bl3) {
            this.moveToState(this.mCurState, true);
        }
        object = this.mFragmentStore.getActiveFragments().iterator();
        while (object.hasNext()) {
            fragment = (Fragment)object.next();
            if (fragment == null || fragment.mView == null || !fragment.mIsNewlyAdded || !backStackRecord.interactsWith(fragment.mContainerId)) continue;
            if (fragment.mPostponedAlpha > 0.0f) {
                fragment.mView.setAlpha(fragment.mPostponedAlpha);
            }
            if (bl3) {
                fragment.mPostponedAlpha = 0.0f;
                continue;
            }
            fragment.mPostponedAlpha = -1.0f;
            fragment.mIsNewlyAdded = false;
        }
    }

    FragmentStateManager createOrGetFragmentStateManager(Fragment fragment) {
        FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(fragment.mWho);
        if (fragmentStateManager != null) {
            return fragmentStateManager;
        }
        fragment = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment);
        fragment.restoreState(this.mHost.getContext().getClassLoader());
        fragment.setFragmentManagerState(this.mCurState);
        return fragment;
    }

    void detachFragment(Fragment fragment) {
        StringBuilder stringBuilder;
        if (FragmentManager.isLoggingEnabled(2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("detach: ");
            stringBuilder.append(fragment);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        if (fragment.mDetached) return;
        fragment.mDetached = true;
        if (!fragment.mAdded) return;
        if (FragmentManager.isLoggingEnabled(2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("remove from detach: ");
            stringBuilder.append(fragment);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        this.mFragmentStore.removeFragment(fragment);
        if (this.isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
        this.setVisibleRemovingFragment(fragment);
    }

    void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(4);
    }

    void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(0);
    }

    void dispatchConfigurationChanged(Configuration configuration) {
        Iterator iterator = this.mFragmentStore.getFragments().iterator();
        while (iterator.hasNext()) {
            Fragment fragment = (Fragment)iterator.next();
            if (fragment == null) continue;
            fragment.performConfigurationChanged(configuration);
        }
    }

    boolean dispatchContextItemSelected(MenuItem menuItem) {
        Fragment fragment;
        if (this.mCurState < 1) {
            return false;
        }
        Iterator iterator = this.mFragmentStore.getFragments().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while ((fragment = (Fragment)iterator.next()) == null || !fragment.performContextItemSelected(menuItem));
        return true;
    }

    void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(1);
    }

    boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        int n = this.mCurState;
        int n2 = 0;
        if (n < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        Iterator iterator = this.mFragmentStore.getFragments().iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            Fragment fragment = (Fragment)iterator.next();
            if (fragment == null || !this.isParentMenuVisible(fragment) || !fragment.performCreateOptionsMenu(menu, menuInflater)) continue;
            ArrayList<Fragment> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<Fragment>();
            }
            arrayList2.add(fragment);
            bl = true;
            arrayList = arrayList2;
        }
        if (this.mCreatedMenus != null) {
            while (n2 < this.mCreatedMenus.size()) {
                menu = this.mCreatedMenus.get(n2);
                if (arrayList == null || !arrayList.contains(menu)) {
                    menu.onDestroyOptionsMenu();
                }
                ++n2;
            }
        }
        this.mCreatedMenus = arrayList;
        return bl;
    }

    void dispatchDestroy() {
        ActivityResultLauncher<Intent> activityResultLauncher;
        this.mDestroyed = true;
        this.execPendingActions(true);
        this.endAnimatingAwayFragments();
        this.dispatchStateChange(-1);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = null;
        }
        if ((activityResultLauncher = this.mStartActivityForResult) == null) return;
        activityResultLauncher.unregister();
        this.mStartIntentSenderForResult.unregister();
        this.mRequestPermissions.unregister();
    }

    void dispatchDestroyView() {
        this.dispatchStateChange(1);
    }

    void dispatchLowMemory() {
        Iterator iterator = this.mFragmentStore.getFragments().iterator();
        while (iterator.hasNext()) {
            Fragment fragment = (Fragment)iterator.next();
            if (fragment == null) continue;
            fragment.performLowMemory();
        }
    }

    void dispatchMultiWindowModeChanged(boolean bl) {
        Iterator iterator = this.mFragmentStore.getFragments().iterator();
        while (iterator.hasNext()) {
            Fragment fragment = (Fragment)iterator.next();
            if (fragment == null) continue;
            fragment.performMultiWindowModeChanged(bl);
        }
    }

    void dispatchOnAttachFragment(Fragment fragment) {
        Iterator<FragmentOnAttachListener> iterator = this.mOnAttachListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().onAttachFragment(this, fragment);
        }
    }

    boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        Fragment fragment;
        if (this.mCurState < 1) {
            return false;
        }
        Iterator iterator = this.mFragmentStore.getFragments().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while ((fragment = (Fragment)iterator.next()) == null || !fragment.performOptionsItemSelected(menuItem));
        return true;
    }

    void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState < 1) {
            return;
        }
        Iterator iterator = this.mFragmentStore.getFragments().iterator();
        while (iterator.hasNext()) {
            Fragment fragment = (Fragment)iterator.next();
            if (fragment == null) continue;
            fragment.performOptionsMenuClosed(menu);
        }
    }

    void dispatchPause() {
        this.dispatchStateChange(5);
    }

    void dispatchPictureInPictureModeChanged(boolean bl) {
        Iterator iterator = this.mFragmentStore.getFragments().iterator();
        while (iterator.hasNext()) {
            Fragment fragment = (Fragment)iterator.next();
            if (fragment == null) continue;
            fragment.performPictureInPictureModeChanged(bl);
        }
    }

    boolean dispatchPrepareOptionsMenu(Menu menu) {
        int n = this.mCurState;
        boolean bl = false;
        if (n < 1) {
            return false;
        }
        Iterator iterator = this.mFragmentStore.getFragments().iterator();
        while (iterator.hasNext()) {
            Fragment fragment = (Fragment)iterator.next();
            if (fragment == null || !this.isParentMenuVisible(fragment) || !fragment.performPrepareOptionsMenu(menu)) continue;
            bl = true;
        }
        return bl;
    }

    void dispatchPrimaryNavigationFragmentChanged() {
        this.updateOnBackPressedCallbackEnabled();
        this.dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(7);
    }

    void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(5);
    }

    void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.setIsStateSaved(true);
        this.dispatchStateChange(4);
    }

    void dispatchViewCreated() {
        this.dispatchStateChange(2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public void dump(String string, FileDescriptor serializable, PrintWriter printWriter, String[] opGenerator) {
        int n;
        int n2;
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string);
        charSequence.append("    ");
        charSequence = charSequence.toString();
        this.mFragmentStore.dump(string, (FileDescriptor)((Object)serializable), printWriter, (String[])opGenerator);
        serializable = this.mCreatedMenus;
        int n3 = 0;
        if (serializable != null && (n2 = ((ArrayList)serializable).size()) > 0) {
            printWriter.print(string);
            printWriter.println("Fragments Created Menus:");
            for (n = 0; n < n2; ++n) {
                serializable = this.mCreatedMenus.get(n);
                printWriter.print(string);
                printWriter.print("  #");
                printWriter.print(n);
                printWriter.print(": ");
                printWriter.println(serializable.toString());
            }
        }
        if ((serializable = this.mBackStack) != null && (n2 = ((ArrayList)serializable).size()) > 0) {
            printWriter.print(string);
            printWriter.println("Back Stack:");
            for (n = 0; n < n2; ++n) {
                serializable = this.mBackStack.get(n);
                printWriter.print(string);
                printWriter.print("  #");
                printWriter.print(n);
                printWriter.print(": ");
                printWriter.println(serializable.toString());
                serializable.dump((String)charSequence, printWriter);
            }
        }
        printWriter.print(string);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("Back Stack Index: ");
        ((StringBuilder)serializable).append(this.mBackStackIndex.get());
        printWriter.println(((StringBuilder)serializable).toString());
        serializable = this.mPendingActions;
        synchronized (serializable) {
            n2 = this.mPendingActions.size();
            if (n2 > 0) {
                printWriter.print(string);
                printWriter.println("Pending Actions:");
                for (n = n3; n < n2; ++n) {
                    opGenerator = this.mPendingActions.get(n);
                    printWriter.print(string);
                    printWriter.print("  #");
                    printWriter.print(n);
                    printWriter.print(": ");
                    printWriter.println(opGenerator);
                }
            }
            {
                printWriter.print(string);
                printWriter.println("FragmentManager misc state:");
                printWriter.print(string);
                printWriter.print("  mHost=");
                printWriter.println(this.mHost);
                printWriter.print(string);
                printWriter.print("  mContainer=");
                printWriter.println(this.mContainer);
                if (this.mParent != null) {
                    printWriter.print(string);
                    printWriter.print("  mParent=");
                    printWriter.println(this.mParent);
                }
                printWriter.print(string);
                printWriter.print("  mCurState=");
                printWriter.print(this.mCurState);
                printWriter.print(" mStateSaved=");
                printWriter.print(this.mStateSaved);
                printWriter.print(" mStopped=");
                printWriter.print(this.mStopped);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.mDestroyed);
                if (!this.mNeedMenuInvalidate) return;
                printWriter.print(string);
                printWriter.print("  mNeedMenuInvalidate=");
                printWriter.println(this.mNeedMenuInvalidate);
                return;
            }
        }
    }

    void enqueueAction(OpGenerator object, boolean bl) {
        if (!bl) {
            if (this.mHost == null) {
                if (!this.mDestroyed) throw new IllegalStateException("FragmentManager has not been attached to a host.");
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            this.checkStateLoss();
        }
        ArrayList<OpGenerator> arrayList = this.mPendingActions;
        synchronized (arrayList) {
            if (this.mHost != null) {
                this.mPendingActions.add((OpGenerator)object);
                this.scheduleCommit();
                return;
            }
            if (bl) {
                return;
            }
            object = new IllegalStateException("Activity has been destroyed");
            throw object;
        }
    }

    boolean execPendingActions(boolean bl) {
        this.ensureExecReady(bl);
        bl = false;
        while (true) {
            if (!this.generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
                this.updateOnBackPressedCallbackEnabled();
                this.doPendingDeferredStart();
                this.mFragmentStore.burpActive();
                return bl;
            }
            this.mExecutingActions = true;
            this.removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            bl = true;
            continue;
            break;
        }
        finally {
            this.cleanupExec();
        }
    }

    void execSingleAction(OpGenerator opGenerator, boolean bl) {
        if (bl) {
            if (this.mHost == null) return;
            if (this.mDestroyed) {
                return;
            }
        }
        this.ensureExecReady(bl);
        if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                this.removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            }
            finally {
                this.cleanupExec();
            }
        }
        this.updateOnBackPressedCallbackEnabled();
        this.doPendingDeferredStart();
        this.mFragmentStore.burpActive();
    }

    public boolean executePendingTransactions() {
        boolean bl = this.execPendingActions(true);
        this.forcePostponedTransactions();
        return bl;
    }

    Fragment findActiveFragment(String string) {
        return this.mFragmentStore.findActiveFragment(string);
    }

    public Fragment findFragmentById(int n) {
        return this.mFragmentStore.findFragmentById(n);
    }

    public Fragment findFragmentByTag(String string) {
        return this.mFragmentStore.findFragmentByTag(string);
    }

    Fragment findFragmentByWho(String string) {
        return this.mFragmentStore.findFragmentByWho(string);
    }

    int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    List<Fragment> getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    public BackStackEntry getBackStackEntryAt(int n) {
        return (BackStackEntry)this.mBackStack.get(n);
    }

    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> arrayList = this.mBackStack;
        int n = arrayList != null ? arrayList.size() : 0;
        return n;
    }

    FragmentContainer getContainer() {
        return this.mContainer;
    }

    public Fragment getFragment(Bundle object, String string) {
        if ((object = object.getString(string)) == null) {
            return null;
        }
        Fragment fragment = this.findActiveFragment((String)object);
        if (fragment != null) return fragment;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment no longer exists for key ");
        stringBuilder.append(string);
        stringBuilder.append(": unique id ");
        stringBuilder.append((String)object);
        this.throwException(new IllegalStateException(stringBuilder.toString()));
        return fragment;
    }

    public FragmentFactory getFragmentFactory() {
        FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        fragmentFactory = this.mParent;
        if (fragmentFactory == null) return this.mHostFragmentFactory;
        return fragmentFactory.mFragmentManager.getFragmentFactory();
    }

    FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    public List<Fragment> getFragments() {
        return this.mFragmentStore.getFragments();
    }

    FragmentHostCallback<?> getHost() {
        return this.mHost;
    }

    LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    Fragment getParent() {
        return this.mParent;
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        SpecialEffectsControllerFactory specialEffectsControllerFactory = this.mSpecialEffectsControllerFactory;
        if (specialEffectsControllerFactory != null) {
            return specialEffectsControllerFactory;
        }
        specialEffectsControllerFactory = this.mParent;
        if (specialEffectsControllerFactory == null) return this.mDefaultSpecialEffectsControllerFactory;
        return specialEffectsControllerFactory.mFragmentManager.getSpecialEffectsControllerFactory();
    }

    ViewModelStore getViewModelStore(Fragment fragment) {
        return this.mNonConfig.getViewModelStore(fragment);
    }

    void handleOnBackPressed() {
        this.execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled()) {
            this.popBackStackImmediate();
        } else {
            this.mOnBackPressedDispatcher.onBackPressed();
        }
    }

    void hideFragment(Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hide: ");
            stringBuilder.append(fragment);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        if (fragment.mHidden) return;
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        this.setVisibleRemovingFragment(fragment);
    }

    void invalidateMenuForFragment(Fragment fragment) {
        if (!fragment.mAdded) return;
        if (!this.isMenuAvailable(fragment)) return;
        this.mNeedMenuInvalidate = true;
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    boolean isParentMenuVisible(Fragment fragment) {
        if (fragment != null) return fragment.isMenuVisible();
        return true;
    }

    boolean isPrimaryNavigation(Fragment fragment) {
        boolean bl = true;
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragment.equals((Object)fragmentManager.getPrimaryNavigationFragment()) && this.isPrimaryNavigation(fragmentManager.mParent)) return bl;
        bl = false;
        return bl;
    }

    boolean isStateAtLeast(int n) {
        boolean bl = this.mCurState >= n;
        return bl;
    }

    public boolean isStateSaved() {
        boolean bl = this.mStateSaved || this.mStopped;
        return bl;
    }

    void launchRequestPermissions(Fragment fragment, String[] stringArray, int n) {
        if (this.mRequestPermissions != null) {
            fragment = new LaunchedFragmentInfo(fragment.mWho, n);
            this.mLaunchedFragments.addLast((LaunchedFragmentInfo)fragment);
            this.mRequestPermissions.launch((Object)stringArray);
        } else {
            this.mHost.onRequestPermissionsFromFragment(fragment, stringArray, n);
        }
    }

    void launchStartActivityForResult(Fragment fragment, Intent intent, int n, Bundle bundle) {
        if (this.mStartActivityForResult != null) {
            fragment = new LaunchedFragmentInfo(fragment.mWho, n);
            this.mLaunchedFragments.addLast((LaunchedFragmentInfo)fragment);
            if (intent != null && bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.mStartActivityForResult.launch((Object)intent);
        } else {
            this.mHost.onStartActivityFromFragment(fragment, intent, n, bundle);
        }
    }

    void launchStartIntentSenderForResult(Fragment fragment, IntentSender intentSender, int n, Intent object, int n2, int n3, int n4, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mStartIntentSenderForResult != null) {
            if (bundle != null) {
                if (object == null) {
                    object = new Intent();
                    object.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ActivityOptions ");
                    stringBuilder.append(bundle);
                    stringBuilder.append(" were added to fillInIntent ");
                    stringBuilder.append(object);
                    stringBuilder.append(" for fragment ");
                    stringBuilder.append(fragment);
                    Log.v((String)TAG, (String)stringBuilder.toString());
                }
                object.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            intentSender = new IntentSenderRequest.Builder(intentSender).setFillInIntent((Intent)object).setFlags(n3, n2).build();
            object = new LaunchedFragmentInfo(fragment.mWho, n);
            this.mLaunchedFragments.addLast((LaunchedFragmentInfo)object);
            if (FragmentManager.isLoggingEnabled(2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Fragment ");
                ((StringBuilder)object).append(fragment);
                ((StringBuilder)object).append("is launching an IntentSender for result ");
                Log.v((String)TAG, (String)((StringBuilder)object).toString());
            }
            this.mStartIntentSenderForResult.launch((Object)intentSender);
        } else {
            this.mHost.onStartIntentSenderFromFragment(fragment, intentSender, n, (Intent)object, n2, n3, n4, bundle);
        }
    }

    void moveFragmentToExpectedState(Fragment fragment) {
        if (!this.mFragmentStore.containsActiveFragment(fragment.mWho)) {
            if (!FragmentManager.isLoggingEnabled(3)) return;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ignoring moving ");
            stringBuilder.append(fragment);
            stringBuilder.append(" to state ");
            stringBuilder.append(this.mCurState);
            stringBuilder.append("since it is not added to ");
            stringBuilder.append(this);
            Log.d((String)TAG, (String)stringBuilder.toString());
            return;
        }
        this.moveToState(fragment);
        if (fragment.mView != null && fragment.mIsNewlyAdded && fragment.mContainer != null) {
            if (fragment.mPostponedAlpha > 0.0f) {
                fragment.mView.setAlpha(fragment.mPostponedAlpha);
            }
            fragment.mPostponedAlpha = 0.0f;
            fragment.mIsNewlyAdded = false;
            FragmentAnim.AnimationOrAnimator animationOrAnimator = FragmentAnim.loadAnimation((Context)this.mHost.getContext(), (Fragment)fragment, (boolean)true, (boolean)fragment.getPopDirection());
            if (animationOrAnimator != null) {
                if (animationOrAnimator.animation != null) {
                    fragment.mView.startAnimation(animationOrAnimator.animation);
                } else {
                    animationOrAnimator.animator.setTarget((Object)fragment.mView);
                    animationOrAnimator.animator.start();
                }
            }
        }
        if (!fragment.mHiddenChanged) return;
        this.completeShowHideFragment(fragment);
    }

    void moveToState(int n, boolean bl) {
        Iterator iterator;
        if (this.mHost == null) {
            if (n != -1) throw new IllegalStateException("No activity");
        }
        if (!bl && n == this.mCurState) {
            return;
        }
        this.mCurState = n;
        if (USE_STATE_MANAGER) {
            this.mFragmentStore.moveToExpectedState();
        } else {
            iterator = this.mFragmentStore.getFragments().iterator();
            while (iterator.hasNext()) {
                this.moveFragmentToExpectedState((Fragment)iterator.next());
            }
            for (FragmentStateManager fragmentStateManager : this.mFragmentStore.getActiveFragmentStateManagers()) {
                Fragment fragment = fragmentStateManager.getFragment();
                if (!fragment.mIsNewlyAdded) {
                    this.moveFragmentToExpectedState(fragment);
                }
                if ((n = fragment.mRemoving && !fragment.isInBackStack() ? 1 : 0) == 0) continue;
                this.mFragmentStore.makeInactive(fragmentStateManager);
            }
        }
        this.startPendingDeferredFragments();
        if (!this.mNeedMenuInvalidate) return;
        iterator = this.mHost;
        if (iterator == null) return;
        if (this.mCurState != 7) return;
        iterator.onSupportInvalidateOptionsMenu();
        this.mNeedMenuInvalidate = false;
    }

    void moveToState(Fragment fragment) {
        this.moveToState(fragment, this.mCurState);
    }

    /*
     * Unable to fully structure code
     */
    void moveToState(Fragment var1_1, int var2_2) {
        block42: {
            block35: {
                block41: {
                    block40: {
                        block39: {
                            block38: {
                                block37: {
                                    block36: {
                                        var6_3 = this.mFragmentStore.getFragmentStateManager(var1_1.mWho);
                                        var4_4 = 1;
                                        var5_5 = var6_3;
                                        if (var6_3 == null) {
                                            var5_5 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, var1_1);
                                            var5_5.setFragmentManagerState(1);
                                        }
                                        var3_6 = var2_2;
                                        if (var1_1.mFromLayout) {
                                            var3_6 = var2_2;
                                            if (var1_1.mInLayout) {
                                                var3_6 = var2_2;
                                                if (var1_1.mState == 2) {
                                                    var3_6 = Math.max(var2_2, 2);
                                                }
                                            }
                                        }
                                        if (var1_1.mState > (var2_2 = Math.min(var3_6, var5_5.computeExpectedState()))) break block35;
                                        if (var1_1.mState < var2_2 && !this.mExitAnimationCancellationSignals.isEmpty()) {
                                            this.cancelExitAnimation(var1_1);
                                        }
                                        if ((var3_6 = var1_1.mState) == -1) break block36;
                                        if (var3_6 == 0) break block37;
                                        if (var3_6 == 1) break block38;
                                        if (var3_6 == 2) break block39;
                                        if (var3_6 == 4) break block40;
                                        if (var3_6 == 5) break block41;
                                        var3_6 = var2_2;
                                        break block42;
                                    }
                                    if (var2_2 > -1) {
                                        var5_5.attach();
                                    }
                                }
                                if (var2_2 > 0) {
                                    var5_5.create();
                                }
                            }
                            if (var2_2 > -1) {
                                var5_5.ensureInflatedView();
                            }
                            if (var2_2 > 1) {
                                var5_5.createView();
                            }
                        }
                        if (var2_2 > 2) {
                            var5_5.activityCreated();
                        }
                    }
                    if (var2_2 > 4) {
                        var5_5.start();
                    }
                }
                var3_6 = var2_2;
                if (var2_2 > 5) {
                    var5_5.resume();
                    var3_6 = var2_2;
                }
                break block42;
            }
            var3_6 = var2_2;
            if (var1_1.mState <= var2_2) break block42;
            var3_6 = var1_1.mState;
            if (var3_6 == 0) ** GOTO lbl121
            if (var3_6 == 1) ** GOTO lbl116
            if (var3_6 == 2) ** GOTO lbl75
            if (var3_6 == 4) ** GOTO lbl64
            if (var3_6 == 5) ** GOTO lbl62
            if (var3_6 != 7) {
                var3_6 = var2_2;
            } else {
                if (var2_2 < 7) {
                    var5_5.pause();
                }
lbl62:
                // 4 sources

                if (var2_2 < 5) {
                    var5_5.stop();
                }
lbl64:
                // 4 sources

                if (var2_2 < 4) {
                    if (FragmentManager.isLoggingEnabled(3)) {
                        var6_3 = new StringBuilder();
                        var6_3.append("movefrom ACTIVITY_CREATED: ");
                        var6_3.append(var1_1);
                        Log.d((String)"FragmentManager", (String)var6_3.toString());
                    }
                    if (var1_1.mView != null && this.mHost.onShouldSaveFragmentState(var1_1) && var1_1.mSavedViewState == null) {
                        var5_5.saveViewState();
                    }
                }
lbl75:
                // 6 sources

                if (var2_2 < 2) {
                    var7_7 = null;
                    if (var1_1.mView != null && var1_1.mContainer != null) {
                        var1_1.mContainer.endViewTransition(var1_1.mView);
                        var1_1.mView.clearAnimation();
                        if (!var1_1.isRemovingParent()) {
                            var6_3 = var7_7;
                            if (this.mCurState > -1) {
                                var6_3 = var7_7;
                                if (!this.mDestroyed) {
                                    var6_3 = var7_7;
                                    if (var1_1.mView.getVisibility() == 0) {
                                        var6_3 = var7_7;
                                        if (var1_1.mPostponedAlpha >= 0.0f) {
                                            var6_3 = FragmentAnim.loadAnimation((Context)this.mHost.getContext(), (Fragment)var1_1, (boolean)false, (boolean)var1_1.getPopDirection());
                                        }
                                    }
                                }
                            }
                            var1_1.mPostponedAlpha = 0.0f;
                            var8_8 = var1_1.mContainer;
                            var7_7 = var1_1.mView;
                            if (var6_3 != null) {
                                FragmentAnim.animateRemoveFragment((Fragment)var1_1, (FragmentAnim.AnimationOrAnimator)var6_3, (FragmentTransition.Callback)this.mFragmentTransitionCallback);
                            }
                            var8_8.removeView(var7_7);
                            if (FragmentManager.isLoggingEnabled(2)) {
                                var6_3 = new StringBuilder();
                                var6_3.append("Removing view ");
                                var6_3.append(var7_7);
                                var6_3.append(" for fragment ");
                                var6_3.append(var1_1);
                                var6_3.append(" from container ");
                                var6_3.append(var8_8);
                                Log.v((String)"FragmentManager", (String)var6_3.toString());
                            }
                            if (var8_8 != var1_1.mContainer) {
                                return;
                            }
                        }
                    }
                    if (this.mExitAnimationCancellationSignals.get(var1_1) == null) {
                        var5_5.destroyFragmentView();
                    }
                }
lbl116:
                // 6 sources

                if (var2_2 < 1) {
                    if (this.mExitAnimationCancellationSignals.get(var1_1) != null) {
                        var2_2 = var4_4;
                    } else {
                        var5_5.destroy();
                    }
                }
lbl121:
                // 5 sources

                if (var2_2 < 0) {
                    var5_5.detach();
                }
                var3_6 = var2_2;
            }
        }
        if (var1_1.mState == var3_6) return;
        if (FragmentManager.isLoggingEnabled(3)) {
            var5_5 = new StringBuilder();
            var5_5.append("moveToState: Fragment state for ");
            var5_5.append(var1_1);
            var5_5.append(" not updated inline; expected state ");
            var5_5.append(var3_6);
            var5_5.append(" found ");
            var5_5.append(var1_1.mState);
            Log.d((String)"FragmentManager", (String)var5_5.toString());
        }
        var1_1.mState = var3_6;
    }

    void noteStateNotSaved() {
        if (this.mHost == null) {
            return;
        }
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        Iterator iterator = this.mFragmentStore.getFragments().iterator();
        while (iterator.hasNext()) {
            Fragment fragment = (Fragment)iterator.next();
            if (fragment == null) continue;
            fragment.noteStateNotSaved();
        }
    }

    void onContainerAvailable(FragmentContainerView fragmentContainerView) {
        Iterator iterator = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (iterator.hasNext()) {
            FragmentStateManager fragmentStateManager = (FragmentStateManager)iterator.next();
            Fragment fragment = fragmentStateManager.getFragment();
            if (fragment.mContainerId != fragmentContainerView.getId() || fragment.mView == null || fragment.mView.getParent() != null) continue;
            fragment.mContainer = fragmentContainerView;
            fragmentStateManager.addViewToContainer();
        }
    }

    @Deprecated
    public FragmentTransaction openTransaction() {
        return this.beginTransaction();
    }

    void performPendingDeferredStart(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.getFragment();
        if (!fragment.mDeferStart) return;
        if (this.mExecutingActions) {
            this.mHavePendingDeferredStart = true;
            return;
        }
        fragment.mDeferStart = false;
        if (USE_STATE_MANAGER) {
            fragmentStateManager.moveToExpectedState();
        } else {
            this.moveToState(fragment);
        }
    }

    public void popBackStack() {
        this.enqueueAction((OpGenerator)new PopBackStackState(this, null, -1, 0), false);
    }

    public void popBackStack(int n, int n2) {
        if (n >= 0) {
            this.enqueueAction((OpGenerator)new PopBackStackState(this, null, n, n2), false);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad id: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void popBackStack(String string, int n) {
        this.enqueueAction((OpGenerator)new PopBackStackState(this, string, -1, n), false);
    }

    public boolean popBackStackImmediate() {
        return this.popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackImmediate(int n, int n2) {
        if (n >= 0) {
            return this.popBackStackImmediate(null, n, n2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad id: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean popBackStackImmediate(String string, int n) {
        return this.popBackStackImmediate(string, -1, n);
    }

    boolean popBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String string, int n, int n2) {
        BackStackRecord backStackRecord = this.mBackStack;
        if (backStackRecord == null) {
            return false;
        }
        if (string == null && n < 0 && (n2 & 1) == 0) {
            n = backStackRecord.size() - 1;
            if (n < 0) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(n));
            arrayList2.add(true);
            return true;
        }
        if (string == null && n < 0) {
            n = -1;
        } else {
            int n3;
            for (n3 = this.mBackStack.size() - 1; n3 >= 0; --n3) {
                backStackRecord = this.mBackStack.get(n3);
                if (string != null && string.equals(backStackRecord.getName()) || n >= 0 && n == backStackRecord.mIndex) break;
            }
            if (n3 < 0) {
                return false;
            }
            int n4 = n3;
            if ((n2 & 1) != 0) {
                while (true) {
                    n4 = n2 = n3 - 1;
                    if (n2 < 0) break;
                    backStackRecord = this.mBackStack.get(n2);
                    if (string != null) {
                        n3 = n2;
                        if (string.equals(backStackRecord.getName())) continue;
                    }
                    n4 = n2;
                    if (n < 0) break;
                    n4 = n2;
                    if (n != backStackRecord.mIndex) break;
                    n3 = n2;
                }
            }
            n = n4;
        }
        if (n == this.mBackStack.size() - 1) {
            return false;
        }
        n2 = this.mBackStack.size() - 1;
        while (n2 > n) {
            arrayList.add(this.mBackStack.remove(n2));
            arrayList2.add(true);
            --n2;
        }
        return true;
    }

    public void putFragment(Bundle bundle, String string, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" is not currently in the FragmentManager");
            this.throwException(new IllegalStateException(stringBuilder.toString()));
        }
        bundle.putString(string, fragment.mWho);
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean bl) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, bl);
    }

    void removeCancellationSignal(Fragment fragment, CancellationSignal cancellationSignal) {
        HashSet<CancellationSignal> hashSet = this.mExitAnimationCancellationSignals.get(fragment);
        if (hashSet == null) return;
        if (!hashSet.remove(cancellationSignal)) return;
        if (!hashSet.isEmpty()) return;
        this.mExitAnimationCancellationSignals.remove(fragment);
        if (fragment.mState >= 5) return;
        this.destroyFragmentView(fragment);
        this.moveToState(fragment);
    }

    void removeFragment(Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("remove: ");
            stringBuilder.append(fragment);
            stringBuilder.append(" nesting=");
            stringBuilder.append(fragment.mBackStackNesting);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        boolean bl = fragment.isInBackStack();
        if (fragment.mDetached) {
            if (!(bl ^ true)) return;
        }
        this.mFragmentStore.removeFragment(fragment);
        if (this.isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mRemoving = true;
        this.setVisibleRemovingFragment(fragment);
    }

    public void removeFragmentOnAttachListener(FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.remove(fragmentOnAttachListener);
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<OnBackStackChangedListener> arrayList = this.mBackStackChangeListeners;
        if (arrayList == null) return;
        arrayList.remove(onBackStackChangedListener);
    }

    void removeRetainedFragment(Fragment fragment) {
        this.mNonConfig.removeRetainedFragment(fragment);
    }

    void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.mHost instanceof ViewModelStoreOwner) {
            this.throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.mNonConfig.restoreFromSnapshot(fragmentManagerNonConfig);
        this.restoreSaveState(parcelable);
    }

    void restoreSaveState(Parcelable object) {
        int n;
        Object object2;
        if (object == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState)object;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        this.mFragmentStore.resetActiveFragments();
        Object object32 = fragmentManagerState.mActive.iterator();
        while (object32.hasNext()) {
            StringBuilder stringBuilder;
            object = (FragmentState)object32.next();
            if (object == null) continue;
            object2 = this.mNonConfig.findRetainedFragmentByWho(((FragmentState)object).mWho);
            if (object2 != null) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("restoreSaveState: re-attaching retained ");
                    stringBuilder.append(object2);
                    Log.v((String)TAG, (String)stringBuilder.toString());
                }
                object = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, (Fragment)object2, (FragmentState)object);
            } else {
                object = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.getContext().getClassLoader(), this.getFragmentFactory(), (FragmentState)object);
            }
            stringBuilder = object.getFragment();
            ((Fragment)stringBuilder).mFragmentManager = this;
            if (FragmentManager.isLoggingEnabled(2)) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("restoreSaveState: active (");
                ((StringBuilder)object2).append(((Fragment)stringBuilder).mWho);
                ((StringBuilder)object2).append("): ");
                ((StringBuilder)object2).append((Object)stringBuilder);
                Log.v((String)TAG, (String)((StringBuilder)object2).toString());
            }
            object.restoreState(this.mHost.getContext().getClassLoader());
            this.mFragmentStore.makeActive((FragmentStateManager)object);
            object.setFragmentManagerState(this.mCurState);
        }
        for (Object object32 : this.mNonConfig.getRetainedFragments()) {
            if (this.mFragmentStore.containsActiveFragment(((Fragment)object32).mWho)) continue;
            if (FragmentManager.isLoggingEnabled(2)) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Discarding retained Fragment ");
                ((StringBuilder)object2).append(object32);
                ((StringBuilder)object2).append(" that was not found in the set of active Fragments ");
                ((StringBuilder)object2).append(fragmentManagerState.mActive);
                Log.v((String)TAG, (String)((StringBuilder)object2).toString());
            }
            this.mNonConfig.removeRetainedFragment((Fragment)object32);
            ((Fragment)object32).mFragmentManager = this;
            object2 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, (Fragment)object32);
            object2.setFragmentManagerState(1);
            object2.moveToExpectedState();
            ((Fragment)object32).mRemoving = true;
            object2.moveToExpectedState();
        }
        this.mFragmentStore.restoreAddedFragments((List)fragmentManagerState.mAdded);
        object = fragmentManagerState.mBackStack;
        int n2 = 0;
        if (object != null) {
            this.mBackStack = new ArrayList(fragmentManagerState.mBackStack.length);
            for (n = 0; n < fragmentManagerState.mBackStack.length; ++n) {
                object = fragmentManagerState.mBackStack[n].instantiate(this);
                if (FragmentManager.isLoggingEnabled(2)) {
                    object32 = new StringBuilder();
                    ((StringBuilder)object32).append("restoreAllState: back stack #");
                    ((StringBuilder)object32).append(n);
                    ((StringBuilder)object32).append(" (index ");
                    ((StringBuilder)object32).append(((BackStackRecord)object).mIndex);
                    ((StringBuilder)object32).append("): ");
                    ((StringBuilder)object32).append(object);
                    Log.v((String)TAG, (String)((StringBuilder)object32).toString());
                    object32 = new PrintWriter((Writer)new LogWriter(TAG));
                    object.dump("  ", (PrintWriter)object32, false);
                    ((PrintWriter)object32).close();
                }
                this.mBackStack.add((BackStackRecord)object);
            }
        } else {
            this.mBackStack = null;
        }
        this.mBackStackIndex.set(fragmentManagerState.mBackStackIndex);
        if (fragmentManagerState.mPrimaryNavActiveWho != null) {
            object = this.findActiveFragment(fragmentManagerState.mPrimaryNavActiveWho);
            this.mPrimaryNav = object;
            this.dispatchParentPrimaryNavigationFragmentChanged((Fragment)object);
        }
        if ((object32 = fragmentManagerState.mResultKeys) != null) {
            for (n = n2; n < ((ArrayList)object32).size(); ++n) {
                object = (Bundle)fragmentManagerState.mResults.get(n);
                object.setClassLoader(this.mHost.getContext().getClassLoader());
                this.mResults.put((String)((ArrayList)object32).get(n), (Bundle)object);
            }
        }
        this.mLaunchedFragments = new ArrayDeque(fragmentManagerState.mLaunchedFragments);
    }

    @Deprecated
    FragmentManagerNonConfig retainNonConfig() {
        if (!(this.mHost instanceof ViewModelStoreOwner)) return this.mNonConfig.getSnapshot();
        this.throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        return this.mNonConfig.getSnapshot();
    }

    Parcelable saveAllState() {
        this.forcePostponedTransactions();
        this.endAnimatingAwayFragments();
        this.execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.setIsStateSaved(true);
        ArrayList arrayList = this.mFragmentStore.saveActiveFragments();
        boolean bl = arrayList.isEmpty();
        Fragment fragment = null;
        if (bl) {
            if (!FragmentManager.isLoggingEnabled(2)) return null;
            Log.v((String)TAG, (String)"saveAllState: no fragments!");
            return null;
        }
        ArrayList arrayList2 = this.mFragmentStore.saveAddedFragments();
        ArrayList<BackStackRecord> arrayList3 = this.mBackStack;
        Object object = fragment;
        if (arrayList3 != null) {
            int n = arrayList3.size();
            object = fragment;
            if (n > 0) {
                fragment = new BackStackState[n];
                int n2 = 0;
                while (true) {
                    object = fragment;
                    if (n2 >= n) break;
                    fragment[n2] = new BackStackState(this.mBackStack.get(n2));
                    if (FragmentManager.isLoggingEnabled(2)) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("saveAllState: adding back stack #");
                        ((StringBuilder)object).append(n2);
                        ((StringBuilder)object).append(": ");
                        ((StringBuilder)object).append(this.mBackStack.get(n2));
                        Log.v((String)TAG, (String)((StringBuilder)object).toString());
                    }
                    ++n2;
                }
            }
        }
        fragment = new FragmentManagerState();
        fragment.mActive = arrayList;
        fragment.mAdded = arrayList2;
        fragment.mBackStack = object;
        fragment.mBackStackIndex = this.mBackStackIndex.get();
        object = this.mPrimaryNav;
        if (object != null) {
            fragment.mPrimaryNavActiveWho = ((Fragment)object).mWho;
        }
        fragment.mResultKeys.addAll(this.mResults.keySet());
        fragment.mResults.addAll(this.mResults.values());
        fragment.mLaunchedFragments = new ArrayList<LaunchedFragmentInfo>(this.mLaunchedFragments);
        return fragment;
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(fragment.mWho);
        if (fragmentStateManager != null) {
            if (fragmentStateManager.getFragment().equals((Object)fragment)) return fragmentStateManager.saveInstanceState();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(fragment);
        stringBuilder.append(" is not currently in the FragmentManager");
        this.throwException(new IllegalStateException(stringBuilder.toString()));
        return fragmentStateManager.saveInstanceState();
    }

    void scheduleCommit() {
        ArrayList<OpGenerator> arrayList = this.mPendingActions;
        synchronized (arrayList) {
            ArrayList<StartEnterTransitionListener> arrayList2 = this.mPostponedTransactions;
            boolean bl = false;
            boolean bl2 = arrayList2 != null && !this.mPostponedTransactions.isEmpty();
            if (this.mPendingActions.size() == 1) {
                bl = true;
            }
            if (!bl2) {
                if (!bl) return;
            }
            this.mHost.getHandler().removeCallbacks(this.mExecCommit);
            this.mHost.getHandler().post(this.mExecCommit);
            this.updateOnBackPressedCallbackEnabled();
            return;
        }
    }

    void setExitAnimationOrder(Fragment fragment, boolean bl) {
        if ((fragment = this.getFragmentContainer(fragment)) == null) return;
        if (!(fragment instanceof FragmentContainerView)) return;
        ((FragmentContainerView)fragment).setDrawDisappearingViewsLast(bl ^ true);
    }

    public void setFragmentFactory(FragmentFactory fragmentFactory) {
        this.mFragmentFactory = fragmentFactory;
    }

    public final void setFragmentResult(String string, Bundle bundle) {
        LifecycleAwareResultListener lifecycleAwareResultListener = this.mResultListeners.get(string);
        if (lifecycleAwareResultListener != null && lifecycleAwareResultListener.isAtLeast(Lifecycle.State.STARTED)) {
            lifecycleAwareResultListener.onFragmentResult(string, bundle);
        } else {
            this.mResults.put(string, bundle);
        }
    }

    public final void setFragmentResultListener(String string, LifecycleOwner lifecycleOwner, FragmentResultListener fragmentResultListener) {
        if ((lifecycleOwner = lifecycleOwner.getLifecycle()).getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        6 var4_4 = new /* Unavailable Anonymous Inner Class!! */;
        lifecycleOwner.addObserver((LifecycleObserver)var4_4);
        string = this.mResultListeners.put(string, new LifecycleAwareResultListener((Lifecycle)lifecycleOwner, fragmentResultListener, (LifecycleEventObserver)var4_4));
        if (string == null) return;
        string.removeObserver();
    }

    void setMaxLifecycle(Fragment fragment, Lifecycle.State object) {
        if (fragment.equals((Object)this.findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = object;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(fragment);
        ((StringBuilder)object).append(" is not an active fragment of FragmentManager ");
        ((StringBuilder)object).append(this);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment != null && (!fragment.equals((Object)this.findActiveFragment(fragment.mWho)) || fragment.mHost != null && fragment.mFragmentManager != this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" is not an active fragment of FragmentManager ");
            stringBuilder.append(this);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        Fragment fragment2 = this.mPrimaryNav;
        this.mPrimaryNav = fragment;
        this.dispatchParentPrimaryNavigationFragmentChanged(fragment2);
        this.dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    void setSpecialEffectsControllerFactory(SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        this.mSpecialEffectsControllerFactory = specialEffectsControllerFactory;
    }

    void showFragment(Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("show: ");
            stringBuilder.append(fragment);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        if (!fragment.mHidden) return;
        fragment.mHidden = false;
        fragment.mHiddenChanged ^= true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        FragmentHostCallback<?> fragmentHostCallback = this.mParent;
        if (fragmentHostCallback != null) {
            stringBuilder.append(fragmentHostCallback.getClass().getSimpleName());
            stringBuilder.append("{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            stringBuilder.append("}");
        } else {
            fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                stringBuilder.append(fragmentHostCallback.getClass().getSimpleName());
                stringBuilder.append("{");
                stringBuilder.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                stringBuilder.append("}");
            } else {
                stringBuilder.append("null");
            }
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks);
    }
}

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.app.Activity
 *  android.app.Application
 *  android.content.ComponentCallbacks
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory2
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnCreateContextMenuListener
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.activity.result.ActivityResultCaller
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.activity.result.ActivityResultRegistry
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.arch.core.util.Function
 *  androidx.core.app.SharedElementCallback
 *  androidx.core.view.LayoutInflaterCompat
 *  androidx.fragment.app.Fragment$AnimationInfo
 *  androidx.fragment.app.Fragment$InstantiationException
 *  androidx.fragment.app.Fragment$OnPreAttachedListener
 *  androidx.fragment.app.Fragment$OnStartEnterTransitionListener
 *  androidx.fragment.app.Fragment$SavedState
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentContainer
 *  androidx.fragment.app.FragmentFactory
 *  androidx.fragment.app.FragmentHostCallback
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManagerImpl
 *  androidx.fragment.app.FragmentViewLifecycleOwner
 *  androidx.fragment.app.SpecialEffectsController
 *  androidx.fragment.app.SuperNotCalledException
 *  androidx.lifecycle.HasDefaultViewModelProviderFactory
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.MutableLiveData
 *  androidx.lifecycle.SavedStateViewModelFactory
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  androidx.lifecycle.ViewModelStore
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.lifecycle.ViewTreeLifecycleOwner
 *  androidx.lifecycle.ViewTreeViewModelStoreOwner
 *  androidx.loader.app.LoaderManager
 *  androidx.savedstate.SavedStateRegistry
 *  androidx.savedstate.SavedStateRegistryController
 *  androidx.savedstate.SavedStateRegistryOwner
 *  androidx.savedstate.ViewTreeSavedStateRegistryOwner
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.arch.core.util.Function;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.FragmentViewLifecycleOwner;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SuperNotCalledException;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment
implements ComponentCallbacks,
View.OnCreateContextMenuListener,
LifecycleOwner,
ViewModelStoreOwner,
HasDefaultViewModelProviderFactory,
SavedStateRegistryOwner,
ActivityResultCaller {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    ViewModelProvider.Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment = null;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible = true;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<OnPreAttachedListener> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    SavedStateRegistryController mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState = -1;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho = null;
    boolean mUserVisibleHint = true;
    View mView;
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    String mWho = UUID.randomUUID().toString();

    public Fragment() {
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mPostponedDurationRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList();
        this.initLifecycle();
    }

    public Fragment(int n) {
        this();
        this.mContentLayoutId = n;
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo != null) return this.mAnimationInfo;
        this.mAnimationInfo = new AnimationInfo();
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        if (this.mMaxState == Lifecycle.State.INITIALIZED) return this.mMaxState.ordinal();
        if (this.mParentFragment != null) return Math.min(this.mMaxState.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
        return this.mMaxState.ordinal();
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create((SavedStateRegistryOwner)this);
        this.mDefaultFactory = null;
    }

    @Deprecated
    public static Fragment instantiate(Context context, String string) {
        return Fragment.instantiate(context, string, null);
    }

    @Deprecated
    public static Fragment instantiate(Context object, String string, Bundle object2) {
        try {
            object = (Fragment)FragmentFactory.loadFragmentClass((ClassLoader)object.getClassLoader(), (String)string).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (object2 == null) return object;
            object2.setClassLoader(object.getClass().getClassLoader());
            ((Fragment)object).setArguments((Bundle)object2);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to instantiate fragment ");
            ((StringBuilder)object2).append(string);
            ((StringBuilder)object2).append(": calling Fragment constructor caused an exception");
            throw new InstantiationException(((StringBuilder)object2).toString(), (Exception)invocationTargetException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to instantiate fragment ");
            ((StringBuilder)object2).append(string);
            ((StringBuilder)object2).append(": could not find Fragment constructor");
            throw new InstantiationException(((StringBuilder)object2).toString(), (Exception)noSuchMethodException);
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to instantiate fragment ");
            ((StringBuilder)object2).append(string);
            ((StringBuilder)object2).append(": make sure class name exists, is public, and has an empty constructor that is public");
            throw new InstantiationException(((StringBuilder)object2).toString(), (Exception)illegalAccessException);
        }
        catch (java.lang.InstantiationException instantiationException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to instantiate fragment ");
            ((StringBuilder)object2).append(string);
            ((StringBuilder)object2).append(": make sure class name exists, is public, and has an empty constructor that is public");
            throw new InstantiationException(((StringBuilder)object2).toString(), (Exception)instantiationException);
        }
    }

    private <I, O> ActivityResultLauncher<I> prepareCallInternal(ActivityResultContract<I, O> object, Function<Void, ActivityResultRegistry> function, ActivityResultCallback<O> activityResultCallback) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            this.registerOnPreAttachListener((OnPreAttachedListener)new /* Unavailable Anonymous Inner Class!! */);
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    private void registerOnPreAttachListener(OnPreAttachedListener onPreAttachedListener) {
        if (this.mState >= 0) {
            onPreAttachedListener.onPreAttached();
        } else {
            this.mOnPreAttachedListeners.add(onPreAttachedListener);
        }
    }

    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled((int)3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("moveto RESTORE_VIEW_STATE: ");
            stringBuilder.append(this);
            Log.d((String)"FragmentManager", (String)stringBuilder.toString());
        }
        if (this.mView != null) {
            this.restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    void callStartTransitionListener(boolean bl) {
        AnimationInfo animationInfo = this.mAnimationInfo;
        OnStartEnterTransitionListener onStartEnterTransitionListener = null;
        if (animationInfo != null) {
            animationInfo.mEnterTransitionPostponed = false;
            onStartEnterTransitionListener = this.mAnimationInfo.mStartEnterTransitionListener;
            this.mAnimationInfo.mStartEnterTransitionListener = null;
        }
        if (onStartEnterTransitionListener != null) {
            onStartEnterTransitionListener.onStartEnterTransition();
        } else {
            if (!FragmentManager.USE_STATE_MANAGER) return;
            if (this.mView == null) return;
            animationInfo = this.mContainer;
            if (animationInfo == null) return;
            onStartEnterTransitionListener = this.mFragmentManager;
            if (onStartEnterTransitionListener == null) return;
            onStartEnterTransitionListener = SpecialEffectsController.getOrCreateController((ViewGroup)animationInfo, (FragmentManager)onStartEnterTransitionListener);
            onStartEnterTransitionListener.markPostponedState();
            if (bl) {
                this.mHost.getHandler().post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            } else {
                onStartEnterTransitionListener.executePendingOperations();
            }
        }
    }

    FragmentContainer createFragmentContainer() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        Object object;
        printWriter.print(string);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(string);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(string);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(string);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(string);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(string);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(string);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(string);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(string);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(string);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(string);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(string);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        if ((object = this.getTargetFragment()) != null) {
            printWriter.print(string);
            printWriter.print("mTarget=");
            printWriter.print(object);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(string);
        printWriter.print("mPopDirection=");
        printWriter.println(this.getPopDirection());
        if (this.getEnterAnim() != 0) {
            printWriter.print(string);
            printWriter.print("getEnterAnim=");
            printWriter.println(this.getEnterAnim());
        }
        if (this.getExitAnim() != 0) {
            printWriter.print(string);
            printWriter.print("getExitAnim=");
            printWriter.println(this.getExitAnim());
        }
        if (this.getPopEnterAnim() != 0) {
            printWriter.print(string);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(this.getPopEnterAnim());
        }
        if (this.getPopExitAnim() != 0) {
            printWriter.print(string);
            printWriter.print("getPopExitAnim=");
            printWriter.println(this.getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(string);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(string);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.getAnimatingAway() != null) {
            printWriter.print(string);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.getAnimatingAway());
        }
        if (this.getContext() != null) {
            LoaderManager.getInstance((LifecycleOwner)this).dump(string, fileDescriptor, printWriter, stringArray);
        }
        printWriter.print(string);
        object = new StringBuilder();
        ((StringBuilder)object).append("Child ");
        ((StringBuilder)object).append(this.mChildFragmentManager);
        ((StringBuilder)object).append(":");
        printWriter.println(((StringBuilder)object).toString());
        object = this.mChildFragmentManager;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("  ");
        object.dump(stringBuilder.toString(), fileDescriptor, printWriter, stringArray);
    }

    public final boolean equals(Object object) {
        return super.equals(object);
    }

    Fragment findFragmentByWho(String string) {
        if (!string.equals(this.mWho)) return this.mChildFragmentManager.findFragmentByWho(string);
        return this;
    }

    String generateActivityResultKey() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fragment_");
        stringBuilder.append(this.mWho);
        stringBuilder.append("_rq#");
        stringBuilder.append(this.mNextLocalRequestCode.getAndIncrement());
        return stringBuilder.toString();
    }

    public final FragmentActivity getActivity() {
        Object object = this.mHost;
        object = object == null ? null : (FragmentActivity)object.getActivity();
        return object;
    }

    public boolean getAllowEnterTransitionOverlap() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        boolean bl = animationInfo != null && animationInfo.mAllowEnterTransitionOverlap != null ? this.mAnimationInfo.mAllowEnterTransitionOverlap : true;
        return bl;
    }

    public boolean getAllowReturnTransitionOverlap() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        boolean bl = animationInfo != null && animationInfo.mAllowReturnTransitionOverlap != null ? this.mAnimationInfo.mAllowReturnTransitionOverlap : true;
        return bl;
    }

    View getAnimatingAway() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mAnimatingAway;
        return null;
    }

    Animator getAnimator() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mAnimator;
        return null;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" has not been attached yet.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public Context getContext() {
        Object object = this.mHost;
        object = object == null ? null : object.getContext();
        return object;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Can't access ViewModels from detached fragment");
            throw illegalStateException;
        }
        if (this.mDefaultFactory != null) return this.mDefaultFactory;
        Application application2 = null;
        Object object = this.requireContext().getApplicationContext();
        while (true) {
            application = application2;
            if (!(object instanceof ContextWrapper)) break;
            if (object instanceof Application) {
                application = (Application)object;
                break;
            }
            object = ((ContextWrapper)object).getBaseContext();
        }
        if (application == null && FragmentManager.isLoggingEnabled((int)3)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Could not find Application instance from Context ");
            ((StringBuilder)object).append(this.requireContext().getApplicationContext());
            ((StringBuilder)object).append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            Log.d((String)"FragmentManager", (String)((StringBuilder)object).toString());
        }
        this.mDefaultFactory = new SavedStateViewModelFactory(application, (SavedStateRegistryOwner)this, this.getArguments());
        return this.mDefaultFactory;
    }

    int getEnterAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mEnterAnim;
        return 0;
    }

    public Object getEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mEnterTransition;
        return null;
    }

    SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mEnterTransitionCallback;
        return null;
    }

    int getExitAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mExitAnim;
        return 0;
    }

    public Object getExitTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mExitTransition;
        return null;
    }

    SharedElementCallback getExitTransitionCallback() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mExitTransitionCallback;
        return null;
    }

    View getFocusedView() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mFocusedView;
        return null;
    }

    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        Object object = this.mHost;
        object = object == null ? null : object.onGetHost();
        return object;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater;
        LayoutInflater layoutInflater2 = layoutInflater = this.mLayoutInflater;
        if (layoutInflater != null) return layoutInflater2;
        layoutInflater2 = this.performGetLayoutInflater(null);
        return layoutInflater2;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle layoutInflater) {
        layoutInflater = this.mHost;
        if (layoutInflater == null) throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        layoutInflater = layoutInflater.onGetLayoutInflater();
        LayoutInflaterCompat.setFactory2((LayoutInflater)layoutInflater, (LayoutInflater.Factory2)this.mChildFragmentManager.getLayoutInflaterFactory());
        return layoutInflater;
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance((LifecycleOwner)this);
    }

    int getNextTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mNextTransition;
        return 0;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final FragmentManager getParentFragmentManager() {
        Object object = this.mFragmentManager;
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not associated with a fragment manager.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    boolean getPopDirection() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mIsPop;
        return false;
    }

    int getPopEnterAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mPopEnterAnim;
        return 0;
    }

    int getPopExitAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mPopExitAnim;
        return 0;
    }

    float getPostOnViewCreatedAlpha() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mPostOnViewCreatedAlpha;
        return 1.0f;
    }

    public Object getReenterTransition() {
        Object object = this.mAnimationInfo;
        if (object == null) {
            return null;
        }
        object = object.mReenterTransition == USE_DEFAULT_TRANSITION ? this.getExitTransition() : this.mAnimationInfo.mReenterTransition;
        return object;
    }

    public final Resources getResources() {
        return this.requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        Object object = this.mAnimationInfo;
        if (object == null) {
            return null;
        }
        object = object.mReturnTransition == USE_DEFAULT_TRANSITION ? this.getEnterTransition() : this.mAnimationInfo.mReturnTransition;
        return object;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public Object getSharedElementEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mSharedElementEnterTransition;
        return null;
    }

    public Object getSharedElementReturnTransition() {
        Object object = this.mAnimationInfo;
        if (object == null) {
            return null;
        }
        object = object.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION ? this.getSharedElementEnterTransition() : this.mAnimationInfo.mSharedElementReturnTransition;
        return object;
    }

    ArrayList<String> getSharedElementSourceNames() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) return new ArrayList<String>();
        if (animationInfo.mSharedElementSourceNames != null) return this.mAnimationInfo.mSharedElementSourceNames;
        return new ArrayList<String>();
    }

    ArrayList<String> getSharedElementTargetNames() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) return new ArrayList<String>();
        if (animationInfo.mSharedElementTargetNames != null) return this.mAnimationInfo.mSharedElementTargetNames;
        return new ArrayList<String>();
    }

    public final String getString(int n) {
        return this.getResources().getString(n);
    }

    public final String getString(int n, Object ... objectArray) {
        return this.getResources().getString(n, objectArray);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        fragment = this.mFragmentManager;
        if (fragment == null) return null;
        String string = this.mTargetWho;
        if (string == null) return null;
        return fragment.findActiveFragment(string);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int n) {
        return this.getResources().getText(n);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.mViewLifecycleOwner;
        if (fragmentViewLifecycleOwner == null) throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
        return fragmentViewLifecycleOwner;
    }

    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) throw new IllegalStateException("Can't access ViewModels from detached fragment");
        if (this.getMinimumMaxLifecycleState() == Lifecycle.State.INITIALIZED.ordinal()) throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        return this.mFragmentManager.getViewModelStore(this);
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        this.initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        boolean bl = this.mHost != null && this.mAdded;
        return bl;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    boolean isHideReplaced() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mIsHideReplaced;
        return false;
    }

    final boolean isInBackStack() {
        boolean bl = this.mBackStackNesting > 0;
        return bl;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        FragmentManager fragmentManager;
        boolean bl = this.mMenuVisible && ((fragmentManager = this.mFragmentManager) == null || fragmentManager.isParentMenuVisible(this.mParentFragment));
        return bl;
    }

    boolean isPostponed() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) return animationInfo.mEnterTransitionPostponed;
        return false;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    final boolean isRemovingParent() {
        Fragment fragment = this.getParentFragment();
        boolean bl = fragment != null && (fragment.isRemoving() || fragment.isRemovingParent());
        return bl;
    }

    public final boolean isResumed() {
        boolean bl = this.mState >= 7;
        return bl;
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) return fragmentManager.isStateSaved();
        return false;
    }

    public final boolean isVisible() {
        View view;
        boolean bl = this.isAdded() && !this.isHidden() && (view = this.mView) != null && view.getWindowToken() != null && this.mView.getVisibility() == 0;
        return bl;
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int n, int n2, Intent intent) {
        if (!FragmentManager.isLoggingEnabled((int)2)) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" received the following in onActivityResult(): requestCode: ");
        stringBuilder.append(n);
        stringBuilder.append(" resultCode: ");
        stringBuilder.append(n2);
        stringBuilder.append(" data: ");
        stringBuilder.append(intent);
        Log.v((String)"FragmentManager", (String)stringBuilder.toString());
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onAttach(Context object) {
        this.mCalled = true;
        object = this.mHost;
        object = object == null ? null : object.getActivity();
        if (object == null) return;
        this.mCalled = false;
        this.onAttach((Activity)object);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        this.restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.isStateAtLeast(1)) return;
        this.mChildFragmentManager.dispatchCreate();
    }

    public Animation onCreateAnimation(int n, boolean bl, int n2) {
        return null;
    }

    public Animator onCreateAnimator(int n, boolean bl, int n2) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int n = this.mContentLayoutId;
        if (n == 0) return null;
        return layoutInflater.inflate(n, viewGroup, false);
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return this.getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean bl) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onInflate(Context object, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        object = this.mHost;
        object = object == null ? null : object.getActivity();
        if (object == null) return;
        this.mCalled = false;
        this.onInflate((Activity)object, attributeSet, bundle);
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean bl) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean bl) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean bl) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle object) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        this.onActivityCreated((Bundle)object);
        if (this.mCalled) {
            this.restoreViewState();
            this.mChildFragmentManager.dispatchActivityCreated();
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not call through to super.onActivityCreated()");
        throw new SuperNotCalledException(((StringBuilder)object).toString());
    }

    void performAttach() {
        Object object = this.mOnPreAttachedListeners.iterator();
        while (object.hasNext()) {
            object.next().onPreAttached();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, this.createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        this.onAttach(this.mHost.getContext());
        if (this.mCalled) {
            this.mFragmentManager.dispatchOnAttachFragment(this);
            this.mChildFragmentManager.dispatchAttach();
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not call through to super.onAttach()");
        object = new SuperNotCalledException(((StringBuilder)object).toString());
        throw object;
    }

    void performConfigurationChanged(Configuration configuration) {
        this.onConfigurationChanged(configuration);
        this.mChildFragmentManager.dispatchConfigurationChanged(configuration);
    }

    boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) return false;
        if (!this.onContextItemSelected(menuItem)) return this.mChildFragmentManager.dispatchContextItemSelected(menuItem);
        return true;
    }

    void performCreate(Bundle object) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        if (Build.VERSION.SDK_INT >= 19) {
            this.mLifecycleRegistry.addObserver((LifecycleObserver)new /* Unavailable Anonymous Inner Class!! */);
        }
        this.mSavedStateRegistryController.performRestore((Bundle)object);
        this.onCreate((Bundle)object);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not call through to super.onCreate()");
        throw new SuperNotCalledException(((StringBuilder)object).toString());
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean bl = this.mHidden;
        boolean bl2 = false;
        boolean bl3 = false;
        if (bl) return bl2;
        boolean bl4 = bl3;
        if (this.mHasMenu) {
            bl4 = bl3;
            if (this.mMenuVisible) {
                bl4 = true;
                this.onCreateOptionsMenu(menu, menuInflater);
            }
        }
        bl2 = bl4 | this.mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
        return bl2;
    }

    void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, this.getViewModelStore());
        layoutInflater = this.onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = layoutInflater;
        if (layoutInflater != null) {
            this.mViewLifecycleOwner.initialize();
            ViewTreeLifecycleOwner.set((View)this.mView, (LifecycleOwner)this.mViewLifecycleOwner);
            ViewTreeViewModelStoreOwner.set((View)this.mView, (ViewModelStoreOwner)this.mViewLifecycleOwner);
            ViewTreeSavedStateRegistryOwner.set((View)this.mView, (SavedStateRegistryOwner)this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.setValue((Object)this.mViewLifecycleOwner);
        } else {
            if (this.mViewLifecycleOwner.isInitialized()) throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            this.mViewLifecycleOwner = null;
        }
    }

    void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        this.onDestroy();
        if (this.mCalled) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroy()");
        throw new SuperNotCalledException(stringBuilder.toString());
    }

    void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        this.onDestroyView();
        if (this.mCalled) {
            LoaderManager.getInstance((LifecycleOwner)this).markForRedelivery();
            this.mPerformedCreateView = false;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroyView()");
        throw new SuperNotCalledException(stringBuilder.toString());
    }

    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        this.onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (this.mChildFragmentManager.isDestroyed()) return;
            this.mChildFragmentManager.dispatchDestroy();
            this.mChildFragmentManager = new FragmentManagerImpl();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDetach()");
        throw new SuperNotCalledException(stringBuilder.toString());
    }

    LayoutInflater performGetLayoutInflater(Bundle bundle) {
        bundle = this.onGetLayoutInflater(bundle);
        this.mLayoutInflater = bundle;
        return bundle;
    }

    void performLowMemory() {
        this.onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    void performMultiWindowModeChanged(boolean bl) {
        this.onMultiWindowModeChanged(bl);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(bl);
    }

    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) return false;
        if (!this.mHasMenu) return this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem);
        if (!this.mMenuVisible) return this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem);
        if (!this.onOptionsItemSelected(menuItem)) return this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem);
        return true;
    }

    void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) return;
        if (this.mHasMenu && this.mMenuVisible) {
            this.onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
    }

    void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        this.onPause();
        if (this.mCalled) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onPause()");
        throw new SuperNotCalledException(stringBuilder.toString());
    }

    void performPictureInPictureModeChanged(boolean bl) {
        this.onPictureInPictureModeChanged(bl);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(bl);
    }

    boolean performPrepareOptionsMenu(Menu menu) {
        boolean bl = this.mHidden;
        boolean bl2 = false;
        boolean bl3 = false;
        if (bl) return bl2;
        boolean bl4 = bl3;
        if (this.mHasMenu) {
            bl4 = bl3;
            if (this.mMenuVisible) {
                bl4 = true;
                this.onPrepareOptionsMenu(menu);
            }
        }
        bl2 = bl4 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
        return bl2;
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean bl = this.mFragmentManager.isPrimaryNavigation(this);
        Boolean bl2 = this.mIsPrimaryNavigationFragment;
        if (bl2 != null) {
            if (bl2 == bl) return;
        }
        this.mIsPrimaryNavigationFragment = bl;
        this.onPrimaryNavigationFragmentChanged(bl);
        this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
    }

    void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        this.onResume();
        if (!this.mCalled) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onResume()");
            throw new SuperNotCalledException(stringBuilder.toString());
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        }
        this.mChildFragmentManager.dispatchResume();
    }

    void performSaveInstanceState(Bundle bundle) {
        this.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
        Parcelable parcelable = this.mChildFragmentManager.saveAllState();
        if (parcelable == null) return;
        bundle.putParcelable("android:support:fragments", parcelable);
    }

    void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        this.onStart();
        if (!this.mCalled) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onStart()");
            throw new SuperNotCalledException(stringBuilder.toString());
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_START);
        }
        this.mChildFragmentManager.dispatchStart();
    }

    void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        this.onStop();
        if (this.mCalled) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onStop()");
        throw new SuperNotCalledException(stringBuilder.toString());
    }

    void performViewCreated() {
        this.onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    public void postponeEnterTransition() {
        this.ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public final void postponeEnterTransition(long l, TimeUnit timeUnit) {
        this.ensureAnimationInfo().mEnterTransitionPostponed = true;
        FragmentManager fragmentManager = this.mFragmentManager;
        fragmentManager = fragmentManager != null ? fragmentManager.getHost().getHandler() : new Handler(Looper.getMainLooper());
        fragmentManager.removeCallbacks(this.mPostponedDurationRunnable);
        fragmentManager.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(l));
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        return this.prepareCallInternal(activityResultContract, (Function<Void, ActivityResultRegistry>)new /* Unavailable Anonymous Inner Class!! */, activityResultCallback);
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback<O> activityResultCallback) {
        return this.prepareCallInternal(activityResultContract, (Function<Void, ActivityResultRegistry>)new /* Unavailable Anonymous Inner Class!! */, activityResultCallback);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener)this);
    }

    @Deprecated
    public final void requestPermissions(String[] object, int n) {
        if (this.mHost != null) {
            this.getParentFragmentManager().launchRequestPermissions(this, (String[])object, n);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not attached to Activity");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public final FragmentActivity requireActivity() {
        Object object = this.getActivity();
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not attached to an activity.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public final Bundle requireArguments() {
        Object object = this.getArguments();
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" does not have any arguments.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public final Context requireContext() {
        Object object = this.getContext();
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not attached to a context.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return this.getParentFragmentManager();
    }

    public final Object requireHost() {
        Object object = this.getHost();
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not attached to a host.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public final Fragment requireParentFragment() {
        Object object = this.getParentFragment();
        if (object != null) return object;
        if (this.getContext() == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Fragment ");
            ((StringBuilder)object).append(this);
            ((StringBuilder)object).append(" is not attached to any Fragment or host");
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" is not a child Fragment, it is directly attached to ");
        ((StringBuilder)object).append(this.getContext());
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public final View requireView() {
        Object object = this.getView();
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not return a View from onCreateView() or this was called before onCreateView().");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    void restoreChildFragmentState(Bundle bundle) {
        if (bundle == null) return;
        if ((bundle = bundle.getParcelable("android:support:fragments")) == null) return;
        this.mChildFragmentManager.restoreSaveState((Parcelable)bundle);
        this.mChildFragmentManager.dispatchCreate();
    }

    final void restoreViewState(Bundle object) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        this.onViewStateRestored((Bundle)object);
        if (this.mCalled) {
            if (this.mView == null) return;
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not call through to super.onViewStateRestored()");
        throw new SuperNotCalledException(((StringBuilder)object).toString());
    }

    public void setAllowEnterTransitionOverlap(boolean bl) {
        this.ensureAnimationInfo().mAllowEnterTransitionOverlap = bl;
    }

    public void setAllowReturnTransitionOverlap(boolean bl) {
        this.ensureAnimationInfo().mAllowReturnTransitionOverlap = bl;
    }

    void setAnimatingAway(View view) {
        this.ensureAnimationInfo().mAnimatingAway = view;
    }

    void setAnimations(int n, int n2, int n3, int n4) {
        if (this.mAnimationInfo == null && n == 0 && n2 == 0 && n3 == 0 && n4 == 0) {
            return;
        }
        this.ensureAnimationInfo().mEnterAnim = n;
        this.ensureAnimationInfo().mExitAnim = n2;
        this.ensureAnimationInfo().mPopEnterAnim = n3;
        this.ensureAnimationInfo().mPopExitAnim = n4;
    }

    void setAnimator(Animator animator) {
        this.ensureAnimationInfo().mAnimator = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null) {
            if (this.isStateSaved()) throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.ensureAnimationInfo().mEnterTransitionCallback = sharedElementCallback;
    }

    public void setEnterTransition(Object object) {
        this.ensureAnimationInfo().mEnterTransition = object;
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.ensureAnimationInfo().mExitTransitionCallback = sharedElementCallback;
    }

    public void setExitTransition(Object object) {
        this.ensureAnimationInfo().mExitTransition = object;
    }

    void setFocusedView(View view) {
        this.ensureAnimationInfo().mFocusedView = view;
    }

    public void setHasOptionsMenu(boolean bl) {
        if (this.mHasMenu == bl) return;
        this.mHasMenu = bl;
        if (!this.isAdded()) return;
        if (this.isHidden()) return;
        this.mHost.onSupportInvalidateOptionsMenu();
    }

    void setHideReplaced(boolean bl) {
        this.ensureAnimationInfo().mIsHideReplaced = bl;
    }

    public void setInitialSavedState(SavedState object) {
        if (this.mFragmentManager != null) throw new IllegalStateException("Fragment already added");
        object = object != null && object.mState != null ? object.mState : null;
        this.mSavedFragmentState = object;
    }

    public void setMenuVisibility(boolean bl) {
        if (this.mMenuVisible == bl) return;
        this.mMenuVisible = bl;
        if (!this.mHasMenu) return;
        if (!this.isAdded()) return;
        if (this.isHidden()) return;
        this.mHost.onSupportInvalidateOptionsMenu();
    }

    void setNextTransition(int n) {
        if (this.mAnimationInfo == null && n == 0) {
            return;
        }
        this.ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = n;
    }

    void setOnStartEnterTransitionListener(OnStartEnterTransitionListener object) {
        this.ensureAnimationInfo();
        if (object == this.mAnimationInfo.mStartEnterTransitionListener) {
            return;
        }
        if (object != null && this.mAnimationInfo.mStartEnterTransitionListener != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Trying to set a replacement startPostponedEnterTransition on ");
            ((StringBuilder)object).append(this);
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        if (this.mAnimationInfo.mEnterTransitionPostponed) {
            this.mAnimationInfo.mStartEnterTransitionListener = object;
        }
        if (object == null) return;
        object.startListening();
    }

    void setPopDirection(boolean bl) {
        if (this.mAnimationInfo == null) {
            return;
        }
        this.ensureAnimationInfo().mIsPop = bl;
    }

    void setPostOnViewCreatedAlpha(float f) {
        this.ensureAnimationInfo().mPostOnViewCreatedAlpha = f;
    }

    public void setReenterTransition(Object object) {
        this.ensureAnimationInfo().mReenterTransition = object;
    }

    @Deprecated
    public void setRetainInstance(boolean bl) {
        this.mRetainInstance = bl;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            if (bl) {
                fragmentManager.addRetainedFragment(this);
            } else {
                fragmentManager.removeRetainedFragment(this);
            }
        } else {
            this.mRetainInstanceChangedWhileDetached = true;
        }
    }

    public void setReturnTransition(Object object) {
        this.ensureAnimationInfo().mReturnTransition = object;
    }

    public void setSharedElementEnterTransition(Object object) {
        this.ensureAnimationInfo().mSharedElementEnterTransition = object;
    }

    void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.ensureAnimationInfo();
        this.mAnimationInfo.mSharedElementSourceNames = arrayList;
        this.mAnimationInfo.mSharedElementTargetNames = arrayList2;
    }

    public void setSharedElementReturnTransition(Object object) {
        this.ensureAnimationInfo().mSharedElementReturnTransition = object;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int n) {
        FragmentManager fragmentManager = this.mFragmentManager;
        Object object = fragment != null ? fragment.mFragmentManager : null;
        if (fragmentManager != null && object != null && fragmentManager != object) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Fragment ");
            ((StringBuilder)object).append(fragment);
            ((StringBuilder)object).append(" must share the same FragmentManager to be set as a target fragment");
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        for (object = fragment; object != null; object = ((Fragment)object).getTargetFragment()) {
            if (!((Fragment)object).equals(this)) continue;
            object = new StringBuilder();
            ((StringBuilder)object).append("Setting ");
            ((StringBuilder)object).append(fragment);
            ((StringBuilder)object).append(" as the target of ");
            ((StringBuilder)object).append(this);
            ((StringBuilder)object).append(" would create a target cycle");
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager != null && fragment.mFragmentManager != null) {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        } else {
            this.mTargetWho = null;
            this.mTarget = fragment;
        }
        this.mTargetRequestCode = n;
    }

    @Deprecated
    public void setUserVisibleHint(boolean bl) {
        if (!this.mUserVisibleHint && bl && this.mState < 5 && this.mFragmentManager != null && this.isAdded() && this.mIsCreated) {
            FragmentManager fragmentManager = this.mFragmentManager;
            fragmentManager.performPendingDeferredStart(fragmentManager.createOrGetFragmentStateManager(this));
        }
        this.mUserVisibleHint = bl;
        boolean bl2 = this.mState < 5 && !bl;
        this.mDeferStart = bl2;
        if (this.mSavedFragmentState == null) return;
        this.mSavedUserVisibleHint = bl;
    }

    public boolean shouldShowRequestPermissionRationale(String string) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) return false;
        return fragmentHostCallback.onShouldShowRequestPermissionRationale(string);
    }

    public void startActivity(Intent intent) {
        this.startActivity(intent, null);
    }

    public void startActivity(Intent object, Bundle bundle) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.onStartActivityFromFragment(this, (Intent)object, -1, bundle);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not attached to Activity");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int n) {
        this.startActivityForResult(intent, n, null);
    }

    @Deprecated
    public void startActivityForResult(Intent object, int n, Bundle bundle) {
        if (this.mHost != null) {
            this.getParentFragmentManager().launchStartActivityForResult(this, (Intent)object, n, bundle);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" not attached to Activity");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender object, int n, Intent intent, int n2, int n3, int n4, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mHost == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Fragment ");
            ((StringBuilder)object).append(this);
            ((StringBuilder)object).append(" not attached to Activity");
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        if (FragmentManager.isLoggingEnabled((int)2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" received the following in startIntentSenderForResult() requestCode: ");
            stringBuilder.append(n);
            stringBuilder.append(" IntentSender: ");
            stringBuilder.append(object);
            stringBuilder.append(" fillInIntent: ");
            stringBuilder.append(intent);
            stringBuilder.append(" options: ");
            stringBuilder.append(bundle);
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
        this.getParentFragmentManager().launchStartIntentSenderForResult(this, (IntentSender)object, n, intent, n2, n3, n4, bundle);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null) return;
        if (!this.ensureAnimationInfo().mEnterTransitionPostponed) return;
        if (this.mHost == null) {
            this.ensureAnimationInfo().mEnterTransitionPostponed = false;
        } else if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            this.mHost.getHandler().postAtFrontOfQueue((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            this.callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append("}");
        stringBuilder.append(" (");
        stringBuilder.append(this.mWho);
        if (this.mFragmentId != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            stringBuilder.append(" tag=");
            stringBuilder.append(this.mTag);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }
}

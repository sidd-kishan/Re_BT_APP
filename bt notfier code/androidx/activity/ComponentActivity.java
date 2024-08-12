/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  androidx.activity.ComponentActivity$NonConfigurationInstances
 *  androidx.activity.ImmLeaksCleaner
 *  androidx.activity.OnBackPressedDispatcher
 *  androidx.activity.OnBackPressedDispatcherOwner
 *  androidx.activity.contextaware.ContextAware
 *  androidx.activity.contextaware.ContextAwareHelper
 *  androidx.activity.contextaware.OnContextAvailableListener
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.activity.result.ActivityResultCaller
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.activity.result.ActivityResultRegistry
 *  androidx.activity.result.ActivityResultRegistryOwner
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.core.app.ComponentActivity
 *  androidx.core.content.ContextCompat
 *  androidx.lifecycle.HasDefaultViewModelProviderFactory
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  androidx.lifecycle.ReportFragment
 *  androidx.lifecycle.SavedStateViewModelFactory
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  androidx.lifecycle.ViewModelStore
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.lifecycle.ViewTreeLifecycleOwner
 *  androidx.lifecycle.ViewTreeViewModelStoreOwner
 *  androidx.savedstate.SavedStateRegistry
 *  androidx.savedstate.SavedStateRegistry$SavedStateProvider
 *  androidx.savedstate.SavedStateRegistryController
 *  androidx.savedstate.SavedStateRegistryOwner
 *  androidx.savedstate.ViewTreeSavedStateRegistryOwner
 *  androidx.tracing.Trace
 */
package androidx.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.ImmLeaksCleaner;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity
extends androidx.core.app.ComponentActivity
implements ContextAware,
LifecycleOwner,
ViewModelStoreOwner,
HasDefaultViewModelProviderFactory,
SavedStateRegistryOwner,
OnBackPressedDispatcherOwner,
ActivityResultRegistryOwner,
ActivityResultCaller {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper = new ContextAwareHelper();
    private ViewModelProvider.Factory mDefaultFactory;
    private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    final SavedStateRegistryController mSavedStateRegistryController = SavedStateRegistryController.create((SavedStateRegistryOwner)this);
    private ViewModelStore mViewModelStore;

    public ComponentActivity() {
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new /* Unavailable Anonymous Inner Class!! */;
        if (this.getLifecycle() == null) throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        if (Build.VERSION.SDK_INT >= 19) {
            this.getLifecycle().addObserver((LifecycleObserver)new /* Unavailable Anonymous Inner Class!! */);
        }
        this.getLifecycle().addObserver((LifecycleObserver)new /* Unavailable Anonymous Inner Class!! */);
        this.getLifecycle().addObserver((LifecycleObserver)new /* Unavailable Anonymous Inner Class!! */);
        if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
            this.getLifecycle().addObserver((LifecycleObserver)new ImmLeaksCleaner((Activity)this));
        }
        this.getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, (SavedStateRegistry.SavedStateProvider)new /* Unavailable Anonymous Inner Class!! */);
        this.addOnContextAvailableListener((OnContextAvailableListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public ComponentActivity(int n) {
        this();
        this.mContentLayoutId = n;
    }

    static /* synthetic */ void access$001(ComponentActivity componentActivity) {
        super.onBackPressed();
    }

    static /* synthetic */ ActivityResultRegistry access$100(ComponentActivity componentActivity) {
        return componentActivity.mActivityResultRegistry;
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set((View)this.getWindow().getDecorView(), (LifecycleOwner)this);
        ViewTreeViewModelStoreOwner.set((View)this.getWindow().getDecorView(), (ViewModelStoreOwner)this);
        ViewTreeSavedStateRegistryOwner.set((View)this.getWindow().getDecorView(), (SavedStateRegistryOwner)this);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.addOnContextAvailableListener(onContextAvailableListener);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore != null) return;
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances)this.getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            this.mViewModelStore = nonConfigurationInstances.viewModelStore;
        }
        if (this.mViewModelStore != null) return;
        this.mViewModelStore = new ViewModelStore();
    }

    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.getApplication() == null) throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        if (this.mDefaultFactory != null) return this.mDefaultFactory;
        Application application = this.getApplication();
        Bundle bundle = this.getIntent() != null ? this.getIntent().getExtras() : null;
        this.mDefaultFactory = new SavedStateViewModelFactory(application, (SavedStateRegistryOwner)this, bundle);
        return this.mDefaultFactory;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        Object object = (NonConfigurationInstances)this.getLastNonConfigurationInstance();
        object = object != null ? object.custom : null;
        return object;
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public ViewModelStore getViewModelStore() {
        if (this.getApplication() == null) throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        this.ensureViewModelStore();
        return this.mViewModelStore;
    }

    @Deprecated
    protected void onActivityResult(int n, int n2, Intent intent) {
        if (this.mActivityResultRegistry.dispatchResult(n, n2, intent)) return;
        super.onActivityResult(n, n2, intent);
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.performRestore(bundle);
        this.mContextAwareHelper.dispatchOnContextAvailable((Context)this);
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn((Activity)this);
        int n = this.mContentLayoutId;
        if (n == 0) return;
        this.setContentView(n);
    }

    @Deprecated
    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
        if (this.mActivityResultRegistry.dispatchResult(n, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", stringArray).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", nArray))) return;
        if (Build.VERSION.SDK_INT < 23) return;
        super.onRequestPermissionsResult(n, stringArray, nArray);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        ViewModelStore viewModelStore;
        Object object = this.onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore2 = viewModelStore = this.mViewModelStore;
        if (viewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances)this.getLastNonConfigurationInstance();
            viewModelStore2 = viewModelStore;
            if (nonConfigurationInstances != null) {
                viewModelStore2 = nonConfigurationInstances.viewModelStore;
            }
        }
        if (viewModelStore2 == null && object == null) {
            return null;
        }
        viewModelStore = new NonConfigurationInstances();
        viewModelStore.custom = object;
        viewModelStore.viewModelStore = viewModelStore2;
        return viewModelStore;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = this.getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry)lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        return this.registerForActivityResult(activityResultContract, this.mActivityResultRegistry, activityResultCallback);
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback<O> activityResultCallback) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("activity_rq#");
        stringBuilder.append(this.mNextLocalRequestCode.getAndIncrement());
        return activityResultRegistry.register(stringBuilder.toString(), (LifecycleOwner)this, activityResultContract, activityResultCallback);
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.removeOnContextAvailableListener(onContextAvailableListener);
    }

    public void reportFullyDrawn() {
        try {
            if (Trace.isEnabled()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("reportFullyDrawn() for ");
                stringBuilder.append(this.getComponentName());
                Trace.beginSection((String)stringBuilder.toString());
            }
            if (Build.VERSION.SDK_INT > 19) {
                super.reportFullyDrawn();
            } else {
                if (Build.VERSION.SDK_INT != 19) return;
                if (ContextCompat.checkSelfPermission((Context)this, (String)"android.permission.UPDATE_DEVICE_STATS") != 0) return;
                super.reportFullyDrawn();
            }
            return;
        }
        finally {
            Trace.endSection();
        }
    }

    public void setContentView(int n) {
        this.initViewTreeOwners();
        super.setContentView(n);
    }

    public void setContentView(View view) {
        this.initViewTreeOwners();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int n) {
        super.startActivityForResult(intent, n);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int n, Bundle bundle) {
        super.startActivityForResult(intent, n, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int n, Intent intent, int n2, int n3, int n4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int n, Intent intent, int n2, int n3, int n4, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4, bundle);
    }
}

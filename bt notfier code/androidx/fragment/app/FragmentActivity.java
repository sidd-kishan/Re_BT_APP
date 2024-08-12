/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  androidx.activity.ComponentActivity
 *  androidx.activity.contextaware.OnContextAvailableListener
 *  androidx.core.app.ActivityCompat
 *  androidx.core.app.ActivityCompat$OnRequestPermissionsResultCallback
 *  androidx.core.app.ActivityCompat$RequestPermissionsRequestCodeValidator
 *  androidx.core.app.SharedElementCallback
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity$HostCallbacks
 *  androidx.fragment.app.FragmentController
 *  androidx.fragment.app.FragmentHostCallback
 *  androidx.fragment.app.FragmentManager
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  androidx.loader.app.LoaderManager
 *  androidx.savedstate.SavedStateRegistry$SavedStateProvider
 */
package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity
extends ComponentActivity
implements ActivityCompat.OnRequestPermissionsResultCallback,
ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final FragmentController mFragments = FragmentController.createController((FragmentHostCallback)new HostCallbacks(this));
    boolean mResumed;
    boolean mStopped = true;

    public FragmentActivity() {
        this.mFragmentLifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);
        this.init();
    }

    public FragmentActivity(int n) {
        super(n);
        this.mFragmentLifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);
        this.init();
    }

    private void init() {
        this.getSavedStateRegistry().registerSavedStateProvider(FRAGMENTS_TAG, (SavedStateRegistry.SavedStateProvider)new /* Unavailable Anonymous Inner Class!! */);
        this.addOnContextAvailableListener((OnContextAvailableListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private static boolean markState(FragmentManager object, Lifecycle.State state) {
        object = object.getFragments().iterator();
        boolean bl = false;
        while (object.hasNext()) {
            Fragment fragment = (Fragment)object.next();
            if (fragment == null) continue;
            boolean bl2 = bl;
            if (fragment.getHost() != null) {
                bl2 = bl | FragmentActivity.markState(fragment.getChildFragmentManager(), state);
            }
            bl = bl2;
            if (fragment.mViewLifecycleOwner != null) {
                bl = bl2;
                if (fragment.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mViewLifecycleOwner.setCurrentState(state);
                    bl = true;
                }
            }
            if (!fragment.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) continue;
            fragment.mLifecycleRegistry.setCurrentState(state);
            bl = true;
        }
        return bl;
    }

    final View dispatchFragmentsOnCreateView(View view, String string, Context context, AttributeSet attributeSet) {
        return this.mFragments.onCreateView(view, string, context, attributeSet);
    }

    public void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        super.dump(string, fileDescriptor, printWriter, stringArray);
        printWriter.print(string);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode((Object)this)));
        printWriter.println(" State:");
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string);
        charSequence.append("  ");
        charSequence = charSequence.toString();
        printWriter.print((String)charSequence);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (this.getApplication() != null) {
            LoaderManager.getInstance((LifecycleOwner)this).dump((String)charSequence, fileDescriptor, printWriter, stringArray);
        }
        this.mFragments.getSupportFragmentManager().dump(string, fileDescriptor, printWriter, stringArray);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance((LifecycleOwner)this);
    }

    void markFragmentsCreated() {
        while (FragmentActivity.markState(this.getSupportFragmentManager(), Lifecycle.State.CREATED)) {
        }
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(n, n2, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.noteStateNotSaved();
        super.onConfigurationChanged(configuration);
        this.mFragments.dispatchConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.mFragments.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int n, Menu menu) {
        if (n != 0) return super.onCreatePanelMenu(n, menu);
        return super.onCreatePanelMenu(n, menu) | this.mFragments.dispatchCreateOptionsMenu(menu, this.getMenuInflater());
    }

    public View onCreateView(View view, String string, Context context, AttributeSet attributeSet) {
        View view2 = this.dispatchFragmentsOnCreateView(view, string, context, attributeSet);
        if (view2 != null) return view2;
        return super.onCreateView(view, string, context, attributeSet);
    }

    public View onCreateView(String string, Context context, AttributeSet attributeSet) {
        View view = this.dispatchFragmentsOnCreateView(null, string, context, attributeSet);
        if (view != null) return view;
        return super.onCreateView(string, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int n, MenuItem menuItem) {
        if (super.onMenuItemSelected(n, menuItem)) {
            return true;
        }
        if (n == 0) return this.mFragments.dispatchOptionsItemSelected(menuItem);
        if (n == 6) return this.mFragments.dispatchContextItemSelected(menuItem);
        return false;
    }

    public void onMultiWindowModeChanged(boolean bl) {
        this.mFragments.dispatchMultiWindowModeChanged(bl);
    }

    protected void onNewIntent(Intent intent) {
        this.mFragments.noteStateNotSaved();
        super.onNewIntent(intent);
    }

    public void onPanelClosed(int n, Menu menu) {
        if (n == 0) {
            this.mFragments.dispatchOptionsMenuClosed(menu);
        }
        super.onPanelClosed(n, menu);
    }

    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean bl) {
        this.mFragments.dispatchPictureInPictureModeChanged(bl);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.onResumeFragments();
    }

    @Deprecated
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int n, View view, Menu menu) {
        if (n != 0) return super.onPreparePanel(n, view, menu);
        return this.onPrepareOptionsPanel(view, menu) | this.mFragments.dispatchPrepareOptionsMenu(menu);
    }

    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
        this.mFragments.noteStateNotSaved();
        super.onRequestPermissionsResult(n, stringArray, nArray);
    }

    protected void onResume() {
        this.mFragments.noteStateNotSaved();
        super.onResume();
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mFragments.dispatchResume();
    }

    protected void onStart() {
        this.mFragments.noteStateNotSaved();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.dispatchActivityCreated();
        }
        this.mFragments.execPendingActions();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.mFragments.dispatchStart();
    }

    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.markFragmentsCreated();
        this.mFragments.dispatchStop();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback((Activity)this, (SharedElementCallback)sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback((Activity)this, (SharedElementCallback)sharedElementCallback);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int n) {
        this.startActivityFromFragment(fragment, intent, n, null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int n, Bundle bundle) {
        if (n == -1) {
            ActivityCompat.startActivityForResult((Activity)this, (Intent)intent, (int)-1, (Bundle)bundle);
            return;
        }
        fragment.startActivityForResult(intent, n, bundle);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int n, Intent intent, int n2, int n3, int n4, Bundle bundle) throws IntentSender.SendIntentException {
        if (n == -1) {
            ActivityCompat.startIntentSenderForResult((Activity)this, (IntentSender)intentSender, (int)n, (Intent)intent, (int)n2, (int)n3, (int)n4, (Bundle)bundle);
            return;
        }
        fragment.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4, bundle);
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition((Activity)this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        this.invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition((Activity)this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition((Activity)this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int n) {
    }
}

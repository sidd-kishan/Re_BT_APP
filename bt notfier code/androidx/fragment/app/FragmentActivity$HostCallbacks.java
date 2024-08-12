/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.Window
 *  androidx.activity.OnBackPressedDispatcher
 *  androidx.activity.OnBackPressedDispatcherOwner
 *  androidx.activity.result.ActivityResultRegistry
 *  androidx.activity.result.ActivityResultRegistryOwner
 *  androidx.core.app.ActivityCompat
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentHostCallback
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentOnAttachListener
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.ViewModelStore
 *  androidx.lifecycle.ViewModelStoreOwner
 */
package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class FragmentActivity.HostCallbacks
extends FragmentHostCallback<FragmentActivity>
implements ViewModelStoreOwner,
OnBackPressedDispatcherOwner,
ActivityResultRegistryOwner,
FragmentOnAttachListener {
    final FragmentActivity this$0;

    public FragmentActivity.HostCallbacks(FragmentActivity fragmentActivity) {
        this.this$0 = fragmentActivity;
        super(fragmentActivity);
    }

    public ActivityResultRegistry getActivityResultRegistry() {
        return this.this$0.getActivityResultRegistry();
    }

    public Lifecycle getLifecycle() {
        return this.this$0.mFragmentLifecycleRegistry;
    }

    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.this$0.getOnBackPressedDispatcher();
    }

    public ViewModelStore getViewModelStore() {
        return this.this$0.getViewModelStore();
    }

    public void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
        this.this$0.onAttachFragment(fragment);
    }

    public void onDump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        this.this$0.dump(string, fileDescriptor, printWriter, stringArray);
    }

    public View onFindViewById(int n) {
        return this.this$0.findViewById(n);
    }

    public FragmentActivity onGetHost() {
        return this.this$0;
    }

    public LayoutInflater onGetLayoutInflater() {
        return this.this$0.getLayoutInflater().cloneInContext((Context)this.this$0);
    }

    public int onGetWindowAnimations() {
        Window window = this.this$0.getWindow();
        int n = window == null ? 0 : window.getAttributes().windowAnimations;
        return n;
    }

    public boolean onHasView() {
        Window window = this.this$0.getWindow();
        boolean bl = window != null && window.peekDecorView() != null;
        return bl;
    }

    public boolean onHasWindowAnimations() {
        boolean bl = this.this$0.getWindow() != null;
        return bl;
    }

    public boolean onShouldSaveFragmentState(Fragment fragment) {
        return this.this$0.isFinishing() ^ true;
    }

    public boolean onShouldShowRequestPermissionRationale(String string) {
        return ActivityCompat.shouldShowRequestPermissionRationale((Activity)this.this$0, (String)string);
    }

    public void onSupportInvalidateOptionsMenu() {
        this.this$0.supportInvalidateOptionsMenu();
    }
}

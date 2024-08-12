/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.os.Parcelable
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.util.Preconditions
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentHostCallback
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManagerNonConfig
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.loader.app.LoaderManager
 */
package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentController {
    private final FragmentHostCallback<?> mHost;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }

    public static FragmentController createController(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback)Preconditions.checkNotNull(fragmentHostCallback, (Object)"callbacks == null"));
    }

    public void attachHost(Fragment fragment) {
        FragmentManager fragmentManager = this.mHost.mFragmentManager;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        fragmentManager.attachController(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.mHost.mFragmentManager.dispatchConfigurationChanged(configuration);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.mHost.mFragmentManager.dispatchContextItemSelected(menuItem);
    }

    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory();
    }

    public void dispatchMultiWindowModeChanged(boolean bl) {
        this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(bl);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(menu);
    }

    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    public void dispatchPictureInPictureModeChanged(boolean bl) {
        this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(bl);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(menu);
    }

    @Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.mHost.mFragmentManager.dispatchResume();
    }

    public void dispatchStart() {
        this.mHost.mFragmentManager.dispatchStart();
    }

    public void dispatchStop() {
        this.mHost.mFragmentManager.dispatchStop();
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean bl) {
    }

    @Deprecated
    public void dumpLoaders(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
    }

    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions(true);
    }

    public Fragment findFragmentByWho(String string) {
        return this.mHost.mFragmentManager.findFragmentByWho(string);
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        return this.mHost.mFragmentManager.getActiveFragments();
    }

    public int getActiveFragmentsCount() {
        return this.mHost.mFragmentManager.getActiveFragmentCount();
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mHost.mFragmentManager;
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    public View onCreateView(View view, String string, Context context, AttributeSet attributeSet) {
        return this.mHost.mFragmentManager.getLayoutInflaterFactory().onCreateView(view, string, context, attributeSet);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.mHost.mFragmentManager.restoreAllState(parcelable, fragmentManagerNonConfig);
    }

    @Deprecated
    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.mHost.mFragmentManager.restoreAllState(parcelable, new FragmentManagerNonConfig(list, null, null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    public void restoreSaveState(Parcelable parcelable) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (!(fragmentHostCallback instanceof ViewModelStoreOwner)) throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        fragmentHostCallback.mFragmentManager.restoreSaveState(parcelable);
    }

    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.mFragmentManager.retainNonConfig();
    }

    @Deprecated
    public List<Fragment> retainNonConfig() {
        Object object = this.mHost.mFragmentManager.retainNonConfig();
        object = object != null && object.getFragments() != null ? new ArrayList(object.getFragments()) : null;
        return object;
    }

    public Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }
}

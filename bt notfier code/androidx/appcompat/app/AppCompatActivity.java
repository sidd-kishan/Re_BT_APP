/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  androidx.activity.contextaware.OnContextAvailableListener
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.app.ActionBarDrawerToggle$Delegate
 *  androidx.appcompat.app.ActionBarDrawerToggle$DelegateProvider
 *  androidx.appcompat.app.AppCompatCallback
 *  androidx.appcompat.app.AppCompatDelegate
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.ActionMode$Callback
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.VectorEnabledTintResources
 *  androidx.core.app.ActivityCompat
 *  androidx.core.app.NavUtils
 *  androidx.core.app.TaskStackBuilder
 *  androidx.core.app.TaskStackBuilder$SupportParentable
 *  androidx.fragment.app.FragmentActivity
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.lifecycle.ViewTreeLifecycleOwner
 *  androidx.lifecycle.ViewTreeViewModelStoreOwner
 *  androidx.savedstate.SavedStateRegistry$SavedStateProvider
 *  androidx.savedstate.SavedStateRegistryOwner
 *  androidx.savedstate.ViewTreeSavedStateRegistryOwner
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class AppCompatActivity
extends FragmentActivity
implements AppCompatCallback,
TaskStackBuilder.SupportParentable,
ActionBarDrawerToggle.DelegateProvider {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    public AppCompatActivity() {
        this.initDelegate();
    }

    public AppCompatActivity(int n) {
        super(n);
        this.initDelegate();
    }

    private void initDelegate() {
        this.getSavedStateRegistry().registerSavedStateProvider(DELEGATE_TAG, (SavedStateRegistry.SavedStateProvider)new /* Unavailable Anonymous Inner Class!! */);
        this.addOnContextAvailableListener((OnContextAvailableListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set((View)this.getWindow().getDecorView(), (LifecycleOwner)this);
        ViewTreeViewModelStoreOwner.set((View)this.getWindow().getDecorView(), (ViewModelStoreOwner)this);
        ViewTreeSavedStateRegistryOwner.set((View)this.getWindow().getDecorView(), (SavedStateRegistryOwner)this);
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 26) return false;
        if (keyEvent.isCtrlPressed()) return false;
        if (KeyEvent.metaStateHasNoModifiers((int)keyEvent.getMetaState())) return false;
        if (keyEvent.getRepeatCount() != 0) return false;
        if (KeyEvent.isModifierKey((int)keyEvent.getKeyCode())) return false;
        Window window = this.getWindow();
        if (window == null) return false;
        if (window.getDecorView() == null) return false;
        if (!window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) return false;
        return true;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initViewTreeOwners();
        this.getDelegate().addContentView(view, layoutParams);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(this.getDelegate().attachBaseContext2(context));
    }

    public void closeOptionsMenu() {
        ActionBar actionBar = this.getSupportActionBar();
        if (!this.getWindow().hasFeature(0)) return;
        if (actionBar != null) {
            if (actionBar.closeOptionsMenu()) return;
        }
        super.closeOptionsMenu();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        ActionBar actionBar = this.getSupportActionBar();
        if (n != 82) return super.dispatchKeyEvent(keyEvent);
        if (actionBar == null) return super.dispatchKeyEvent(keyEvent);
        if (!actionBar.onMenuKeyEvent(keyEvent)) return super.dispatchKeyEvent(keyEvent);
        return true;
    }

    public <T extends View> T findViewById(int n) {
        return (T)this.getDelegate().findViewById(n);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate != null) return this.mDelegate;
        this.mDelegate = AppCompatDelegate.create((Activity)this, (AppCompatCallback)this);
        return this.mDelegate;
    }

    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return this.getDelegate().getDrawerToggleDelegate();
    }

    public MenuInflater getMenuInflater() {
        return this.getDelegate().getMenuInflater();
    }

    public Resources getResources() {
        Resources resources;
        if (this.mResources == null && VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new VectorEnabledTintResources((Context)this, super.getResources());
        }
        Resources resources2 = resources = this.mResources;
        if (resources != null) return resources2;
        resources2 = super.getResources();
        return resources2;
    }

    public ActionBar getSupportActionBar() {
        return this.getDelegate().getSupportActionBar();
    }

    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent((Activity)this);
    }

    public void invalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            DisplayMetrics displayMetrics = super.getResources().getDisplayMetrics();
            this.mResources.updateConfiguration(configuration, displayMetrics);
        }
        this.getDelegate().onConfigurationChanged(configuration);
    }

    public void onContentChanged() {
        this.onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack((Activity)this);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.getDelegate().onDestroy();
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        if (!this.performMenuItemShortcut(keyEvent)) return super.onKeyDown(n, keyEvent);
        return true;
    }

    public final boolean onMenuItemSelected(int n, MenuItem menuItem) {
        if (super.onMenuItemSelected(n, menuItem)) {
            return true;
        }
        ActionBar actionBar = this.getSupportActionBar();
        if (menuItem.getItemId() != 16908332) return false;
        if (actionBar == null) return false;
        if ((actionBar.getDisplayOptions() & 4) == 0) return false;
        return this.onSupportNavigateUp();
    }

    public boolean onMenuOpened(int n, Menu menu) {
        return super.onMenuOpened(n, menu);
    }

    protected void onNightModeChanged(int n) {
    }

    public void onPanelClosed(int n, Menu menu) {
        super.onPanelClosed(n, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.getDelegate().onPostCreate(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.getDelegate().onPostResume();
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
    }

    protected void onStart() {
        super.onStart();
        this.getDelegate().onStart();
    }

    protected void onStop() {
        super.onStop();
        this.getDelegate().onStop();
    }

    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent intent = this.getSupportParentActivityIntent();
        if (intent == null) return false;
        if (this.supportShouldUpRecreateTask(intent)) {
            intent = TaskStackBuilder.create((Context)this);
            this.onCreateSupportNavigateUpTaskStack((TaskStackBuilder)intent);
            this.onPrepareSupportNavigateUpTaskStack((TaskStackBuilder)intent);
            intent.startActivities();
            try {
                ActivityCompat.finishAffinity((Activity)this);
            }
            catch (IllegalStateException illegalStateException) {
                this.finish();
            }
        } else {
            this.supportNavigateUpTo(intent);
        }
        return true;
    }

    protected void onTitleChanged(CharSequence charSequence, int n) {
        super.onTitleChanged(charSequence, n);
        this.getDelegate().setTitle(charSequence);
    }

    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void openOptionsMenu() {
        ActionBar actionBar = this.getSupportActionBar();
        if (!this.getWindow().hasFeature(0)) return;
        if (actionBar != null) {
            if (actionBar.openOptionsMenu()) return;
        }
        super.openOptionsMenu();
    }

    public void setContentView(int n) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(n);
    }

    public void setContentView(View view) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(view, layoutParams);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        this.getDelegate().setSupportActionBar(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int n) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean bl) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean bl) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean bl) {
    }

    public void setTheme(int n) {
        super.setTheme(n);
        this.getDelegate().setTheme(n);
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        return this.getDelegate().startSupportActionMode(callback);
    }

    public void supportInvalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(Intent intent) {
        NavUtils.navigateUpTo((Activity)this, (Intent)intent);
    }

    public boolean supportRequestWindowFeature(int n) {
        return this.getDelegate().requestWindowFeature(n);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return NavUtils.shouldUpRecreateTask((Activity)this, (Intent)intent);
    }
}

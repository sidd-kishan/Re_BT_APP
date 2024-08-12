/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.text.Editable
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.widget.TextView
 */
package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

private static class TextViewCompat.OreoCallback
implements ActionMode.Callback {
    private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
    private final ActionMode.Callback mCallback;
    private boolean mCanUseMenuBuilderReferences;
    private boolean mInitializedMenuBuilderReferences;
    private Class<?> mMenuBuilderClass;
    private Method mMenuBuilderRemoveItemAtMethod;
    private final TextView mTextView;

    TextViewCompat.OreoCallback(ActionMode.Callback callback, TextView textView) {
        this.mCallback = callback;
        this.mTextView = textView;
        this.mInitializedMenuBuilderReferences = false;
    }

    private Intent createProcessTextIntent() {
        return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }

    private Intent createProcessTextIntentForResolveInfo(ResolveInfo resolveInfo, TextView textView) {
        return this.createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", this.isEditable(textView) ^ true).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
    }

    private List<ResolveInfo> getSupportedActivities(Context context, PackageManager packageManager) {
        ArrayList<ResolveInfo> arrayList = new ArrayList<ResolveInfo>();
        if (!(context instanceof Activity)) {
            return arrayList;
        }
        Iterator iterator = packageManager.queryIntentActivities(this.createProcessTextIntent(), 0).iterator();
        while (iterator.hasNext()) {
            packageManager = (ResolveInfo)iterator.next();
            if (!this.isSupportedActivity((ResolveInfo)packageManager, context)) continue;
            arrayList.add((ResolveInfo)packageManager);
        }
        return arrayList;
    }

    private boolean isEditable(TextView textView) {
        boolean bl = textView instanceof Editable && textView.onCheckIsTextEditor() && textView.isEnabled();
        return bl;
    }

    private boolean isSupportedActivity(ResolveInfo resolveInfo, Context context) {
        boolean bl = context.getPackageName().equals(resolveInfo.activityInfo.packageName);
        boolean bl2 = true;
        if (bl) {
            return true;
        }
        if (!resolveInfo.activityInfo.exported) {
            return false;
        }
        bl = bl2;
        if (resolveInfo.activityInfo.permission == null) return bl;
        bl = context.checkSelfPermission(resolveInfo.activityInfo.permission) == 0 ? bl2 : false;
        return bl;
    }

    /*
     * Enabled force condition propagation
     */
    private void recomputeProcessTextMenuItems(Menu menu) {
        int n;
        Object object;
        Object object2 = this.mTextView.getContext();
        PackageManager packageManager = object2.getPackageManager();
        if (!this.mInitializedMenuBuilderReferences) {
            this.mInitializedMenuBuilderReferences = true;
            try {
                object = Class.forName("com.android.internal.view.menu.MenuBuilder");
                this.mMenuBuilderClass = object;
                this.mMenuBuilderRemoveItemAtMethod = object.getDeclaredMethod("removeItemAt", Integer.TYPE);
                this.mCanUseMenuBuilderReferences = true;
            }
            catch (ClassNotFoundException | NoSuchMethodException reflectiveOperationException) {
                this.mMenuBuilderClass = null;
                this.mMenuBuilderRemoveItemAtMethod = null;
                this.mCanUseMenuBuilderReferences = false;
            }
        }
        try {
            object = this.mCanUseMenuBuilderReferences && this.mMenuBuilderClass.isInstance(menu) ? this.mMenuBuilderRemoveItemAtMethod : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
            for (n = menu.size() - 1; n >= 0; --n) {
                MenuItem menuItem = menu.getItem(n);
                if (menuItem.getIntent() == null || !"android.intent.action.PROCESS_TEXT".equals(menuItem.getIntent().getAction())) continue;
                object.invoke(menu, n);
            }
            object2 = this.getSupportedActivities((Context)object2, packageManager);
            n = 0;
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
            return;
        }
        while (n < object2.size()) {
            object = (ResolveInfo)object2.get(n);
            menu.add(0, 0, n + 100, object.loadLabel(packageManager)).setIntent(this.createProcessTextIntentForResolveInfo((ResolveInfo)object, this.mTextView)).setShowAsAction(1);
            ++n;
        }
    }

    ActionMode.Callback getWrappedCallback() {
        return this.mCallback;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.mCallback.onCreateActionMode(actionMode, menu);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.mCallback.onDestroyActionMode(actionMode);
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        this.recomputeProcessTextMenuItems(menu);
        return this.mCallback.onPrepareActionMode(actionMode, menu);
    }
}

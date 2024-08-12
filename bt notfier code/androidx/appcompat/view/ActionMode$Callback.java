/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.MenuItem
 *  androidx.appcompat.view.ActionMode
 */
package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.view.ActionMode;

public static interface ActionMode.Callback {
    public boolean onActionItemClicked(ActionMode var1, MenuItem var2);

    public boolean onCreateActionMode(ActionMode var1, Menu var2);

    public void onDestroyActionMode(ActionMode var1);

    public boolean onPrepareActionMode(ActionMode var1, Menu var2);
}

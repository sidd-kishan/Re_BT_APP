/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.ActionMode$Callback
 */
package androidx.appcompat.app;

import androidx.appcompat.view.ActionMode;

public interface AppCompatCallback {
    public void onSupportActionModeFinished(ActionMode var1);

    public void onSupportActionModeStarted(ActionMode var1);

    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback var1);
}

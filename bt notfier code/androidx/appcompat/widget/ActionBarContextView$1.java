/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.widget.ActionBarContextView
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.ActionBarContextView;

class ActionBarContextView.1
implements View.OnClickListener {
    final ActionBarContextView this$0;
    final ActionMode val$mode;

    ActionBarContextView.1(ActionBarContextView actionBarContextView, ActionMode actionMode) {
        this.this$0 = actionBarContextView;
        this.val$mode = actionMode;
    }

    public void onClick(View view) {
        this.val$mode.finish();
    }
}

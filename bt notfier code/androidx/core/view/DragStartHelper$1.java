/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  androidx.core.view.DragStartHelper
 */
package androidx.core.view;

import android.view.View;
import androidx.core.view.DragStartHelper;

class DragStartHelper.1
implements View.OnLongClickListener {
    final DragStartHelper this$0;

    DragStartHelper.1(DragStartHelper dragStartHelper) {
        this.this$0 = dragStartHelper;
    }

    public boolean onLongClick(View view) {
        return this.this$0.onLongClick(view);
    }
}

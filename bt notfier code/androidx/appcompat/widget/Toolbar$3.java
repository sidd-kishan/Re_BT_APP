/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.widget.Toolbar
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.Toolbar;

class Toolbar.3
implements View.OnClickListener {
    final Toolbar this$0;

    Toolbar.3(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    public void onClick(View view) {
        this.this$0.collapseActionView();
    }
}

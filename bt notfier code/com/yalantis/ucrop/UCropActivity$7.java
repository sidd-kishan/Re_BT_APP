/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.yalantis.ucrop.UCropActivity
 */
package com.yalantis.ucrop;

import android.view.View;
import com.yalantis.ucrop.UCropActivity;

/*
 * Exception performing whole class analysis ignored.
 */
class UCropActivity.7
implements View.OnClickListener {
    final UCropActivity this$0;

    UCropActivity.7(UCropActivity uCropActivity) {
        this.this$0 = uCropActivity;
    }

    public void onClick(View view) {
        if (view.isSelected()) return;
        UCropActivity.access$900((UCropActivity)this.this$0, (int)view.getId());
    }
}

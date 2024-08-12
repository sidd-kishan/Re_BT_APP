/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  com.yalantis.ucrop.UCropActivity
 *  com.yalantis.ucrop.view.widget.AspectRatioTextView
 */
package com.yalantis.ucrop;

import android.view.View;
import android.view.ViewGroup;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import java.util.Iterator;

/*
 * Exception performing whole class analysis ignored.
 */
class UCropActivity.2
implements View.OnClickListener {
    final UCropActivity this$0;

    UCropActivity.2(UCropActivity uCropActivity) {
        this.this$0 = uCropActivity;
    }

    public void onClick(View view) {
        UCropActivity.access$500((UCropActivity)this.this$0).setTargetAspectRatio(((AspectRatioTextView)((ViewGroup)view).getChildAt(0)).getAspectRatio(view.isSelected()));
        UCropActivity.access$500((UCropActivity)this.this$0).setImageToWrapCropBounds();
        if (view.isSelected()) return;
        Iterator iterator = UCropActivity.access$600((UCropActivity)this.this$0).iterator();
        while (iterator.hasNext()) {
            ViewGroup viewGroup = (ViewGroup)iterator.next();
            boolean bl = viewGroup == view;
            viewGroup.setSelected(bl);
        }
    }
}

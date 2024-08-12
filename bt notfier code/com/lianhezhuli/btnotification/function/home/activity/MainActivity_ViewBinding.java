/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.RadioGroup
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.home.activity.MainActivity
 */
package com.lianhezhuli.btnotification.function.home.activity;

import android.view.View;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.home.activity.MainActivity;

public class MainActivity_ViewBinding
implements Unbinder {
    private MainActivity target;
    private View view7f090149;
    private View view7f09014a;
    private View view7f09014b;

    public MainActivity_ViewBinding(MainActivity mainActivity) {
        this(mainActivity, mainActivity.getWindow().getDecorView());
    }

    public MainActivity_ViewBinding(MainActivity mainActivity, View view) {
        View view2;
        this.target = mainActivity;
        mainActivity.navigatorRg = (RadioGroup)Utils.findRequiredViewAsType((View)view, (int)2131296583, (String)"field 'navigatorRg'", RadioGroup.class);
        this.view7f09014a = view2 = Utils.findRequiredView((View)view, (int)2131296586, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090149 = view2 = Utils.findRequiredView((View)view, (int)2131296585, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f09014b = view = Utils.findRequiredView((View)view, (int)2131296587, (String)"method 'click'");
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void unbind() {
        MainActivity mainActivity = this.target;
        if (mainActivity == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        mainActivity.navigatorRg = null;
        this.view7f09014a.setOnClickListener(null);
        this.view7f09014a = null;
        this.view7f090149.setOnClickListener(null);
        this.view7f090149 = null;
        this.view7f09014b.setOnClickListener(null);
        this.view7f09014b = null;
    }
}

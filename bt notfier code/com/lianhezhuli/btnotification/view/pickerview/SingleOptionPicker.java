/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bigkoo.pickerview.builder.OptionsPickerBuilder
 *  com.bigkoo.pickerview.listener.OnOptionsSelectListener
 *  com.bigkoo.pickerview.view.OptionsPickerView
 */
package com.lianhezhuli.btnotification.view.pickerview;

import android.content.Context;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import java.util.List;

public class SingleOptionPicker<T> {
    private OptionsPickerView mPickerView;

    public SingleOptionPicker(Context context, String string, List<T> list, int n, OnOptionsSelectListener onOptionsSelectListener) {
        this.setOptionPicker(context, string, list, n, onOptionsSelectListener);
    }

    private OptionsPickerView setOptionPicker(Context context, String string, List<T> list, int n, OnOptionsSelectListener onOptionsSelectListener) {
        context = new OptionsPickerBuilder(context, onOptionsSelectListener).setTitleText(string).setSelectOptions(n).setCancelText(context.getString(2131755050)).setSubmitText(context.getString(2131755116)).setOutSideCancelable(true).setSubmitColor(context.getResources().getColor(2131099739)).setCancelColor(context.getResources().getColor(2131099739)).setTitleBgColor(-1).build();
        this.mPickerView = context;
        context.setPicker(list);
        return this.mPickerView;
    }

    public void dismiss() {
        OptionsPickerView optionsPickerView = this.mPickerView;
        if (optionsPickerView == null) return;
        if (!optionsPickerView.isShowing()) return;
        this.mPickerView.dismiss();
    }

    public void show() {
        OptionsPickerView optionsPickerView = this.mPickerView;
        if (optionsPickerView == null) return;
        if (optionsPickerView.isShowing()) return;
        this.mPickerView.show();
    }
}

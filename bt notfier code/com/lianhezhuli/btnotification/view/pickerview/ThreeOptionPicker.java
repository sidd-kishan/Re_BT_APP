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

public class ThreeOptionPicker<T> {
    private OptionsPickerView mPickerView;

    public ThreeOptionPicker(Context context, String string, String string2, String string3, List<T> list, List<T> list2, List<T> list3, int n, int n2, int n3, OnOptionsSelectListener onOptionsSelectListener) {
        this.setOptionPicker(context, string, string2, string3, list, list2, list3, n, n2, n3, onOptionsSelectListener);
    }

    private OptionsPickerView setOptionPicker(Context context, String string, String string2, String string3, List<T> list, List<T> list2, List<T> list3, int n, int n2, int n3, OnOptionsSelectListener onOptionsSelectListener) {
        context = new OptionsPickerBuilder(context, onOptionsSelectListener).setTitleText(string).setCyclic(true, true, true).setSelectOptions(n, n2, n3).setCancelText(string2).setSubmitText(string3).setOutSideCancelable(true).setSubmitColor(context.getResources().getColor(2131099739)).setCancelColor(context.getResources().getColor(2131099739)).setTitleBgColor(-1).build();
        this.mPickerView = context;
        context.setNPicker(list, list2, list3);
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

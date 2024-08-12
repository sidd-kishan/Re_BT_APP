/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  com.bigkoo.pickerview.configure.PickerOptions
 *  com.bigkoo.pickerview.listener.CustomListener
 *  com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener
 *  com.bigkoo.pickerview.listener.OnOptionsSelectListener
 *  com.bigkoo.pickerview.view.OptionsPickerView
 *  com.contrarywind.view.WheelView$DividerType
 */
package com.bigkoo.pickerview.builder;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.contrarywind.view.WheelView;

public class OptionsPickerBuilder {
    private PickerOptions mPickerOptions;

    public OptionsPickerBuilder(Context context, OnOptionsSelectListener onOptionsSelectListener) {
        PickerOptions pickerOptions;
        this.mPickerOptions = pickerOptions = new PickerOptions(1);
        pickerOptions.context = context;
        this.mPickerOptions.optionsSelectListener = onOptionsSelectListener;
    }

    public <T> OptionsPickerView<T> build() {
        return new OptionsPickerView(this.mPickerOptions);
    }

    public OptionsPickerBuilder isCenterLabel(boolean bl) {
        this.mPickerOptions.isCenterLabel = bl;
        return this;
    }

    public OptionsPickerBuilder isDialog(boolean bl) {
        this.mPickerOptions.isDialog = bl;
        return this;
    }

    public OptionsPickerBuilder isRestoreItem(boolean bl) {
        this.mPickerOptions.isRestoreItem = bl;
        return this;
    }

    @Deprecated
    public OptionsPickerBuilder setBackgroundId(int n) {
        this.mPickerOptions.outSideColor = n;
        return this;
    }

    public OptionsPickerBuilder setBgColor(int n) {
        this.mPickerOptions.bgColorWheel = n;
        return this;
    }

    public OptionsPickerBuilder setCancelColor(int n) {
        this.mPickerOptions.textColorCancel = n;
        return this;
    }

    public OptionsPickerBuilder setCancelText(String string) {
        this.mPickerOptions.textContentCancel = string;
        return this;
    }

    public OptionsPickerBuilder setContentTextSize(int n) {
        this.mPickerOptions.textSizeContent = n;
        return this;
    }

    public OptionsPickerBuilder setCyclic(boolean bl, boolean bl2, boolean bl3) {
        this.mPickerOptions.cyclic1 = bl;
        this.mPickerOptions.cyclic2 = bl2;
        this.mPickerOptions.cyclic3 = bl3;
        return this;
    }

    public OptionsPickerBuilder setDecorView(ViewGroup viewGroup) {
        this.mPickerOptions.decorView = viewGroup;
        return this;
    }

    public OptionsPickerBuilder setDividerColor(int n) {
        this.mPickerOptions.dividerColor = n;
        return this;
    }

    public OptionsPickerBuilder setDividerType(WheelView.DividerType dividerType) {
        this.mPickerOptions.dividerType = dividerType;
        return this;
    }

    public OptionsPickerBuilder setLabels(String string, String string2, String string3) {
        this.mPickerOptions.label1 = string;
        this.mPickerOptions.label2 = string2;
        this.mPickerOptions.label3 = string3;
        return this;
    }

    public OptionsPickerBuilder setLayoutRes(int n, CustomListener customListener) {
        this.mPickerOptions.layoutRes = n;
        this.mPickerOptions.customListener = customListener;
        return this;
    }

    public OptionsPickerBuilder setLineSpacingMultiplier(float f) {
        this.mPickerOptions.lineSpacingMultiplier = f;
        return this;
    }

    public OptionsPickerBuilder setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.mPickerOptions.cancelListener = onClickListener;
        return this;
    }

    public OptionsPickerBuilder setOptionsSelectChangeListener(OnOptionsSelectChangeListener onOptionsSelectChangeListener) {
        this.mPickerOptions.optionsSelectChangeListener = onOptionsSelectChangeListener;
        return this;
    }

    public OptionsPickerBuilder setOutSideCancelable(boolean bl) {
        this.mPickerOptions.cancelable = bl;
        return this;
    }

    public OptionsPickerBuilder setOutSideColor(int n) {
        this.mPickerOptions.outSideColor = n;
        return this;
    }

    public OptionsPickerBuilder setSelectOptions(int n) {
        this.mPickerOptions.option1 = n;
        return this;
    }

    public OptionsPickerBuilder setSelectOptions(int n, int n2) {
        this.mPickerOptions.option1 = n;
        this.mPickerOptions.option2 = n2;
        return this;
    }

    public OptionsPickerBuilder setSelectOptions(int n, int n2, int n3) {
        this.mPickerOptions.option1 = n;
        this.mPickerOptions.option2 = n2;
        this.mPickerOptions.option3 = n3;
        return this;
    }

    public OptionsPickerBuilder setSubCalSize(int n) {
        this.mPickerOptions.textSizeSubmitCancel = n;
        return this;
    }

    public OptionsPickerBuilder setSubmitColor(int n) {
        this.mPickerOptions.textColorConfirm = n;
        return this;
    }

    public OptionsPickerBuilder setSubmitText(String string) {
        this.mPickerOptions.textContentConfirm = string;
        return this;
    }

    public OptionsPickerBuilder setTextColorCenter(int n) {
        this.mPickerOptions.textColorCenter = n;
        return this;
    }

    public OptionsPickerBuilder setTextColorOut(int n) {
        this.mPickerOptions.textColorOut = n;
        return this;
    }

    public OptionsPickerBuilder setTextXOffset(int n, int n2, int n3) {
        this.mPickerOptions.x_offset_one = n;
        this.mPickerOptions.x_offset_two = n2;
        this.mPickerOptions.x_offset_three = n3;
        return this;
    }

    public OptionsPickerBuilder setTitleBgColor(int n) {
        this.mPickerOptions.bgColorTitle = n;
        return this;
    }

    public OptionsPickerBuilder setTitleColor(int n) {
        this.mPickerOptions.textColorTitle = n;
        return this;
    }

    public OptionsPickerBuilder setTitleSize(int n) {
        this.mPickerOptions.textSizeTitle = n;
        return this;
    }

    public OptionsPickerBuilder setTitleText(String string) {
        this.mPickerOptions.textContentTitle = string;
        return this;
    }

    public OptionsPickerBuilder setTypeface(Typeface typeface) {
        this.mPickerOptions.font = typeface;
        return this;
    }
}

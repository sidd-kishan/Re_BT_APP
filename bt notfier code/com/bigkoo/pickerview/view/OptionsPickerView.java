/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.bigkoo.pickerview.R$id
 *  com.bigkoo.pickerview.R$string
 *  com.bigkoo.pickerview.configure.PickerOptions
 *  com.bigkoo.pickerview.view.BasePickerView
 *  com.bigkoo.pickerview.view.WheelOptions
 */
package com.bigkoo.pickerview.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.view.BasePickerView;
import com.bigkoo.pickerview.view.WheelOptions;
import java.util.List;

public class OptionsPickerView<T>
extends BasePickerView
implements View.OnClickListener {
    private static final String TAG_CANCEL = "cancel";
    private static final String TAG_SUBMIT = "submit";
    private WheelOptions wheelOptions;

    public OptionsPickerView(PickerOptions pickerOptions) {
        super(pickerOptions.context);
        this.mPickerOptions = pickerOptions;
        this.initView(pickerOptions.context);
    }

    private void initView(Context object) {
        this.setDialogOutSideCancelable();
        this.initViews();
        this.initAnim();
        this.initEvents();
        if (this.mPickerOptions.customListener == null) {
            LayoutInflater.from((Context)object).inflate(this.mPickerOptions.layoutRes, this.contentContainer);
            TextView textView = (TextView)this.findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout)this.findViewById(R.id.rv_topbar);
            Button button = (Button)this.findViewById(R.id.btnSubmit);
            Button button2 = (Button)this.findViewById(R.id.btnCancel);
            button.setTag((Object)TAG_SUBMIT);
            button2.setTag((Object)TAG_CANCEL);
            button.setOnClickListener((View.OnClickListener)this);
            button2.setOnClickListener((View.OnClickListener)this);
            String string2 = TextUtils.isEmpty((CharSequence)this.mPickerOptions.textContentConfirm) ? object.getResources().getString(R.string.pickerview_submit) : this.mPickerOptions.textContentConfirm;
            button.setText((CharSequence)string2);
            object = TextUtils.isEmpty((CharSequence)this.mPickerOptions.textContentCancel) ? object.getResources().getString(R.string.pickerview_cancel) : this.mPickerOptions.textContentCancel;
            button2.setText((CharSequence)object);
            object = TextUtils.isEmpty((CharSequence)this.mPickerOptions.textContentTitle) ? "" : this.mPickerOptions.textContentTitle;
            textView.setText((CharSequence)object);
            button.setTextColor(this.mPickerOptions.textColorConfirm);
            button2.setTextColor(this.mPickerOptions.textColorCancel);
            textView.setTextColor(this.mPickerOptions.textColorTitle);
            relativeLayout.setBackgroundColor(this.mPickerOptions.bgColorTitle);
            button.setTextSize((float)this.mPickerOptions.textSizeSubmitCancel);
            button2.setTextSize((float)this.mPickerOptions.textSizeSubmitCancel);
            textView.setTextSize((float)this.mPickerOptions.textSizeTitle);
        } else {
            this.mPickerOptions.customListener.customLayout(LayoutInflater.from((Context)object).inflate(this.mPickerOptions.layoutRes, this.contentContainer));
        }
        object = (LinearLayout)this.findViewById(R.id.optionspicker);
        object.setBackgroundColor(this.mPickerOptions.bgColorWheel);
        this.wheelOptions = new WheelOptions((View)object, this.mPickerOptions.isRestoreItem);
        if (this.mPickerOptions.optionsSelectChangeListener != null) {
            this.wheelOptions.setOptionsSelectChangeListener(this.mPickerOptions.optionsSelectChangeListener);
        }
        this.wheelOptions.setTextContentSize(this.mPickerOptions.textSizeContent);
        this.wheelOptions.setLabels(this.mPickerOptions.label1, this.mPickerOptions.label2, this.mPickerOptions.label3);
        this.wheelOptions.setTextXOffset(this.mPickerOptions.x_offset_one, this.mPickerOptions.x_offset_two, this.mPickerOptions.x_offset_three);
        this.wheelOptions.setCyclic(this.mPickerOptions.cyclic1, this.mPickerOptions.cyclic2, this.mPickerOptions.cyclic3);
        this.wheelOptions.setTypeface(this.mPickerOptions.font);
        this.setOutSideCancelable(this.mPickerOptions.cancelable);
        this.wheelOptions.setDividerColor(this.mPickerOptions.dividerColor);
        this.wheelOptions.setDividerType(this.mPickerOptions.dividerType);
        this.wheelOptions.setLineSpacingMultiplier(this.mPickerOptions.lineSpacingMultiplier);
        this.wheelOptions.setTextColorOut(this.mPickerOptions.textColorOut);
        this.wheelOptions.setTextColorCenter(this.mPickerOptions.textColorCenter);
        this.wheelOptions.isCenterLabel(this.mPickerOptions.isCenterLabel);
    }

    private void reSetCurrentItems() {
        WheelOptions wheelOptions = this.wheelOptions;
        if (wheelOptions == null) return;
        wheelOptions.setCurrentItems(this.mPickerOptions.option1, this.mPickerOptions.option2, this.mPickerOptions.option3);
    }

    public boolean isDialog() {
        return this.mPickerOptions.isDialog;
    }

    public void onClick(View view) {
        String string2 = (String)view.getTag();
        if (string2.equals(TAG_SUBMIT)) {
            this.returnData();
        } else if (string2.equals(TAG_CANCEL) && this.mPickerOptions.cancelListener != null) {
            this.mPickerOptions.cancelListener.onClick(view);
        }
        this.dismiss();
    }

    public void returnData() {
        if (this.mPickerOptions.optionsSelectListener == null) return;
        int[] nArray = this.wheelOptions.getCurrentItems();
        this.mPickerOptions.optionsSelectListener.onOptionsSelect(nArray[0], nArray[1], nArray[2], this.clickView);
    }

    public void setNPicker(List<T> list, List<T> list2, List<T> list3) {
        this.wheelOptions.setLinkage(false);
        this.wheelOptions.setNPicker(list, list2, list3);
        this.reSetCurrentItems();
    }

    public void setPicker(List<T> list) {
        this.setPicker(list, null, null);
    }

    public void setPicker(List<T> list, List<List<T>> list2) {
        this.setPicker(list, list2, null);
    }

    public void setPicker(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.wheelOptions.setPicker(list, list2, list3);
        this.reSetCurrentItems();
    }

    public void setSelectOptions(int n) {
        this.mPickerOptions.option1 = n;
        this.reSetCurrentItems();
    }

    public void setSelectOptions(int n, int n2) {
        this.mPickerOptions.option1 = n;
        this.mPickerOptions.option2 = n2;
        this.reSetCurrentItems();
    }

    public void setSelectOptions(int n, int n2, int n3) {
        this.mPickerOptions.option1 = n;
        this.mPickerOptions.option2 = n2;
        this.mPickerOptions.option3 = n3;
        this.reSetCurrentItems();
    }

    public void setTitleText(String string2) {
        TextView textView = (TextView)this.findViewById(R.id.tvTitle);
        if (textView == null) return;
        textView.setText((CharSequence)string2);
    }
}

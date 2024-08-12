/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bigkoo.pickerview.listener.OnOptionsSelectListener
 *  com.bigkoo.pickerview.listener.OnTimeSelectListener
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.lianhezhuli.btnotification.view.pickerview.SingleOptionPicker
 *  com.lianhezhuli.btnotification.view.pickerview.ThreeOptionPicker
 *  com.lianhezhuli.btnotification.view.pickerview.UnLimitDatePicker
 */
package com.lianhezhuli.btnotification.view.pickerview;

import android.content.Context;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.lianhezhuli.btnotification.view.pickerview.SingleOptionPicker;
import com.lianhezhuli.btnotification.view.pickerview.ThreeOptionPicker;
import com.lianhezhuli.btnotification.view.pickerview.UnLimitDatePicker;
import java.util.ArrayList;
import java.util.List;

public class PickerViewHelper<T> {
    private static PickerViewHelper instance;

    public static PickerViewHelper getInstance() {
        if (instance != null) return instance;
        instance = new PickerViewHelper();
        return instance;
    }

    public static void showDateDialog(Context context, OnTimeSelectListener onTimeSelectListener) {
        new UnLimitDatePicker(context, onTimeSelectListener).show();
    }

    public static void showSingleDialog(Context context, String string, List<String> list, int n, OnOptionsSelectListener onOptionsSelectListener) {
        new SingleOptionPicker(context, string, list, n, onOptionsSelectListener).show();
    }

    public void showTimePicker(Context context, String string, String string2, String string3, OnOptionsSelectListener onOptionsSelectListener) {
        int n;
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        int n2 = 0;
        for (n = 0; n < 24; ++n) {
            String string4 = StringUtils.formatStr((String)"%02d", (Object[])new Object[]{n});
            arrayList.add(string4);
            if (!string4.equals(string2)) continue;
            n2 = n;
        }
        n = 0;
        int n3 = 0;
        while (true) {
            if (n >= 60) {
                new ThreeOptionPicker(context, string, context.getString(2131755050), context.getString(2131755116), arrayList, arrayList2, null, n2, n3, 0, onOptionsSelectListener).show();
                return;
            }
            string2 = StringUtils.formatStr((String)"%02d", (Object[])new Object[]{n});
            arrayList2.add(string2);
            if (string2.equals(string3)) {
                n3 = n;
            }
            ++n;
        }
    }
}

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bigkoo.pickerview.listener.ISelectTimeCallback
 *  com.bigkoo.pickerview.view.TimePickerView
 *  com.bigkoo.pickerview.view.WheelTime
 */
package com.bigkoo.pickerview.view;

import com.bigkoo.pickerview.listener.ISelectTimeCallback;
import com.bigkoo.pickerview.view.TimePickerView;
import com.bigkoo.pickerview.view.WheelTime;
import java.text.ParseException;
import java.util.Date;

/*
 * Exception performing whole class analysis ignored.
 */
class TimePickerView.1
implements ISelectTimeCallback {
    final TimePickerView this$0;

    TimePickerView.1(TimePickerView timePickerView) {
        this.this$0 = timePickerView;
    }

    public void onTimeSelectChanged() {
        try {
            Date date = WheelTime.dateFormat.parse(TimePickerView.access$000((TimePickerView)this.this$0).getTime());
            this.this$0.mPickerOptions.timeSelectChangeListener.onTimeSelectChanged(date);
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
        }
    }
}

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.haibin.calendarview.CalendarViewDelegate
 *  com.haibin.calendarview.YearView
 */
package com.haibin.calendarview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.haibin.calendarview.CalendarViewDelegate;
import com.haibin.calendarview.YearView;

private static class YearViewAdapter.YearViewHolder
extends RecyclerView.ViewHolder {
    YearView mYearView;

    YearViewAdapter.YearViewHolder(View view, CalendarViewDelegate calendarViewDelegate) {
        super(view);
        view = (YearView)view;
        this.mYearView = view;
        view.setup(calendarViewDelegate);
    }
}

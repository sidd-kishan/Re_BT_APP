/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.haibin.calendarview.BaseRecyclerAdapter
 *  com.haibin.calendarview.CalendarViewDelegate
 *  com.haibin.calendarview.DefaultYearView
 *  com.haibin.calendarview.Month
 *  com.haibin.calendarview.YearView
 *  com.haibin.calendarview.YearViewAdapter$YearViewHolder
 */
package com.haibin.calendarview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.haibin.calendarview.BaseRecyclerAdapter;
import com.haibin.calendarview.CalendarViewDelegate;
import com.haibin.calendarview.DefaultYearView;
import com.haibin.calendarview.Month;
import com.haibin.calendarview.YearView;
import com.haibin.calendarview.YearViewAdapter;

final class YearViewAdapter
extends BaseRecyclerAdapter<Month> {
    private CalendarViewDelegate mDelegate;
    private int mItemHeight;
    private int mItemWidth;

    YearViewAdapter(Context context) {
        super(context);
    }

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Month month, int n) {
        viewHolder = ((YearViewHolder)viewHolder).mYearView;
        viewHolder.init(month.getYear(), month.getMonth());
        viewHolder.measureSize(this.mItemWidth, this.mItemHeight);
    }

    RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup viewGroup, int n) {
        if (TextUtils.isEmpty((CharSequence)this.mDelegate.getYearViewClassPath())) {
            viewGroup = new DefaultYearView(this.mContext);
        } else {
            try {
                viewGroup = (YearView)this.mDelegate.getYearViewClass().getConstructor(Context.class).newInstance(this.mContext);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                viewGroup = new DefaultYearView(this.mContext);
            }
        }
        viewGroup.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, -1));
        return new YearViewHolder((View)viewGroup, this.mDelegate);
    }

    final void setYearViewSize(int n, int n2) {
        this.mItemWidth = n;
        this.mItemHeight = n2;
    }

    final void setup(CalendarViewDelegate calendarViewDelegate) {
        this.mDelegate = calendarViewDelegate;
    }
}

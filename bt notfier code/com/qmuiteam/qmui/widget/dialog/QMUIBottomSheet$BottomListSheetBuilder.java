/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface$OnDismissListener
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.BaseAdapter
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$layout
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUILangHelper
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomListSheetBuilder$BottomSheetListItemData
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomListSheetBuilder$ListAdapter
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomListSheetBuilder$OnSheetItemClickListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$OnBottomSheetShowListener
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public static class QMUIBottomSheet.BottomListSheetBuilder {
    private BaseAdapter mAdapter;
    private int mCheckedIndex;
    private ListView mContainerView;
    private Context mContext;
    private QMUIBottomSheet mDialog;
    private List<View> mHeaderViews;
    private List<BottomSheetListItemData> mItems;
    private boolean mNeedRightMark;
    private DialogInterface.OnDismissListener mOnBottomDialogDismissListener;
    private OnSheetItemClickListener mOnSheetItemClickListener;
    private String mTitle;
    private TextView mTitleTv;

    public QMUIBottomSheet.BottomListSheetBuilder(Context context) {
        this(context, false);
    }

    public QMUIBottomSheet.BottomListSheetBuilder(Context context, boolean bl) {
        this.mContext = context;
        this.mItems = new ArrayList<BottomSheetListItemData>();
        this.mHeaderViews = new ArrayList<View>();
        this.mNeedRightMark = bl;
    }

    static /* synthetic */ OnSheetItemClickListener access$1000(QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder) {
        return bottomListSheetBuilder.mOnSheetItemClickListener;
    }

    static /* synthetic */ QMUIBottomSheet access$1100(QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder) {
        return bottomListSheetBuilder.mDialog;
    }

    static /* synthetic */ int access$300(QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder) {
        return bottomListSheetBuilder.mCheckedIndex;
    }

    static /* synthetic */ ListView access$400(QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder) {
        return bottomListSheetBuilder.mContainerView;
    }

    static /* synthetic */ List access$600(QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder) {
        return bottomListSheetBuilder.mItems;
    }

    static /* synthetic */ Context access$700(QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder) {
        return bottomListSheetBuilder.mContext;
    }

    static /* synthetic */ boolean access$900(QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder) {
        return bottomListSheetBuilder.mNeedRightMark;
    }

    private View buildViews() {
        View view = View.inflate((Context)this.mContext, (int)this.getContentViewLayoutId(), null);
        this.mTitleTv = (TextView)view.findViewById(R.id.title);
        this.mContainerView = (ListView)view.findViewById(R.id.listview);
        String string2 = this.mTitle;
        if (string2 != null && string2.length() != 0) {
            this.mTitleTv.setVisibility(0);
            this.mTitleTv.setText((CharSequence)this.mTitle);
        } else {
            this.mTitleTv.setVisibility(8);
        }
        if (this.mHeaderViews.size() > 0) {
            for (View view2 : this.mHeaderViews) {
                this.mContainerView.addHeaderView(view2);
            }
        }
        if (this.needToScroll()) {
            this.mContainerView.getLayoutParams().height = this.getListMaxHeight();
            this.mDialog.setOnBottomSheetShowListener((QMUIBottomSheet.OnBottomSheetShowListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        ListAdapter listAdapter = new ListAdapter(this, null);
        this.mAdapter = listAdapter;
        this.mContainerView.setAdapter((android.widget.ListAdapter)listAdapter);
        return view;
    }

    private boolean needToScroll() {
        int n = QMUIResHelper.getAttrDimen((Context)this.mContext, (int)R.attr.qmui_bottom_sheet_list_item_height);
        int n2 = this.mItems.size() * n;
        int n3 = this.mHeaderViews.size();
        boolean bl = false;
        n = n2;
        if (n3 > 0) {
            Iterator<View> iterator = this.mHeaderViews.iterator();
            while (true) {
                n = n2;
                if (!iterator.hasNext()) break;
                View view = iterator.next();
                if (view.getMeasuredHeight() == 0) {
                    view.measure(0, 0);
                }
                n2 += view.getMeasuredHeight();
            }
        }
        n2 = n;
        if (this.mTitleTv != null) {
            n2 = n;
            if (!QMUILangHelper.isNullOrEmpty((CharSequence)this.mTitle)) {
                n2 = n + QMUIResHelper.getAttrDimen((Context)this.mContext, (int)R.attr.qmui_bottom_sheet_title_height);
            }
        }
        if (n2 <= this.getListMaxHeight()) return bl;
        bl = true;
        return bl;
    }

    public QMUIBottomSheet.BottomListSheetBuilder addHeaderView(View view) {
        if (view == null) return this;
        this.mHeaderViews.add(view);
        return this;
    }

    public QMUIBottomSheet.BottomListSheetBuilder addItem(int n, String string, String string2) {
        Drawable drawable = n != 0 ? ContextCompat.getDrawable((Context)this.mContext, (int)n) : null;
        this.mItems.add(new BottomSheetListItemData(drawable, string, string2));
        return this;
    }

    public QMUIBottomSheet.BottomListSheetBuilder addItem(int n, String string, String string2, boolean bl) {
        Drawable drawable = n != 0 ? ContextCompat.getDrawable((Context)this.mContext, (int)n) : null;
        this.mItems.add(new BottomSheetListItemData(drawable, string, string2, bl));
        return this;
    }

    public QMUIBottomSheet.BottomListSheetBuilder addItem(int n, String string, String string2, boolean bl, boolean bl2) {
        Drawable drawable = n != 0 ? ContextCompat.getDrawable((Context)this.mContext, (int)n) : null;
        this.mItems.add(new BottomSheetListItemData(drawable, string, string2, bl, bl2));
        return this;
    }

    public QMUIBottomSheet.BottomListSheetBuilder addItem(Drawable drawable, String string) {
        this.mItems.add(new BottomSheetListItemData(drawable, string, string));
        return this;
    }

    public QMUIBottomSheet.BottomListSheetBuilder addItem(String string) {
        this.mItems.add(new BottomSheetListItemData(string, string));
        return this;
    }

    public QMUIBottomSheet.BottomListSheetBuilder addItem(String string, String string2) {
        this.mItems.add(new BottomSheetListItemData(string, string2));
        return this;
    }

    public QMUIBottomSheet build() {
        this.mDialog = new QMUIBottomSheet(this.mContext);
        View view = this.buildViews();
        this.mDialog.setContentView(view, new ViewGroup.LayoutParams(-1, -2));
        view = this.mOnBottomDialogDismissListener;
        if (view == null) return this.mDialog;
        this.mDialog.setOnDismissListener((DialogInterface.OnDismissListener)view);
        return this.mDialog;
    }

    protected int getContentViewLayoutId() {
        return R.layout.qmui_bottom_sheet_list;
    }

    protected int getListMaxHeight() {
        double d = QMUIDisplayHelper.getScreenHeight((Context)this.mContext);
        Double.isNaN(d);
        return (int)(d * 0.5);
    }

    public void notifyDataSetChanged() {
        BaseAdapter baseAdapter = this.mAdapter;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
        if (!this.needToScroll()) return;
        this.mContainerView.getLayoutParams().height = this.getListMaxHeight();
        this.mContainerView.setSelection(this.mCheckedIndex);
    }

    public QMUIBottomSheet.BottomListSheetBuilder setCheckedIndex(int n) {
        this.mCheckedIndex = n;
        return this;
    }

    public QMUIBottomSheet.BottomListSheetBuilder setOnBottomDialogDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnBottomDialogDismissListener = onDismissListener;
        return this;
    }

    public QMUIBottomSheet.BottomListSheetBuilder setOnSheetItemClickListener(OnSheetItemClickListener onSheetItemClickListener) {
        this.mOnSheetItemClickListener = onSheetItemClickListener;
        return this;
    }

    public QMUIBottomSheet.BottomListSheetBuilder setTitle(int n) {
        this.mTitle = this.mContext.getResources().getString(n);
        return this;
    }

    public QMUIBottomSheet.BottomListSheetBuilder setTitle(String string) {
        this.mTitle = string;
        return this;
    }
}

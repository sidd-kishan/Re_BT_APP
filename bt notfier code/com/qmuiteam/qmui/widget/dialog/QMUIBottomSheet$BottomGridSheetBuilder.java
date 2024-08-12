/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewStub
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.AppCompatImageView
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$layout
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$BottomGridSheetBuilder$OnSheetItemClickListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetItemView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetItemView;

public static class QMUIBottomSheet.BottomGridSheetBuilder
implements View.OnClickListener {
    public static final int FIRST_LINE = 0;
    public static final int SECOND_LINE = 1;
    private TextView mBottomButton;
    private ViewGroup mBottomButtonContainer;
    private Typeface mBottomButtonTypeFace = null;
    private View.OnClickListener mButtonClickListener = null;
    private CharSequence mButtonText = null;
    private Context mContext;
    private QMUIBottomSheet mDialog;
    private SparseArray<View> mFirstLineViews;
    private boolean mIsShowButton = true;
    private Typeface mItemTextTypeFace = null;
    private int mMiniItemWidth = -1;
    private OnSheetItemClickListener mOnSheetItemClickListener;
    private SparseArray<View> mSecondLineViews;

    public QMUIBottomSheet.BottomGridSheetBuilder(Context context) {
        this.mContext = context;
        this.mFirstLineViews = new SparseArray();
        this.mSecondLineViews = new SparseArray();
    }

    static /* synthetic */ QMUIBottomSheet access$1200(QMUIBottomSheet.BottomGridSheetBuilder bottomGridSheetBuilder) {
        return bottomGridSheetBuilder.mDialog;
    }

    private void addViewsInSection(SparseArray<View> sparseArray, LinearLayout linearLayout, int n) {
        int n2 = 0;
        while (n2 < sparseArray.size()) {
            View view = (View)sparseArray.get(n2);
            this.setItemWidth(view, n);
            linearLayout.addView(view);
            ++n2;
        }
    }

    private View buildViews() {
        int n;
        LinearLayout linearLayout = (LinearLayout)View.inflate((Context)this.mContext, (int)this.getContentViewLayoutId(), null);
        LinearLayout linearLayout2 = (LinearLayout)linearLayout.findViewById(R.id.bottom_sheet_first_linear_layout);
        Object object = (LinearLayout)linearLayout.findViewById(R.id.bottom_sheet_second_linear_layout);
        this.mBottomButtonContainer = (ViewGroup)linearLayout.findViewById(R.id.bottom_sheet_button_container);
        this.mBottomButton = (TextView)linearLayout.findViewById(R.id.bottom_sheet_close_button);
        int n2 = Math.max(this.mFirstLineViews.size(), this.mSecondLineViews.size());
        int n3 = QMUIDisplayHelper.getScreenWidth((Context)this.mContext);
        if (n3 >= (n = QMUIDisplayHelper.getScreenHeight((Context)this.mContext))) {
            n3 = n;
        }
        n3 = this.calculateItemWidth(n3, n2, linearLayout2.getPaddingLeft(), linearLayout2.getPaddingRight());
        this.addViewsInSection(this.mFirstLineViews, linearLayout2, n3);
        this.addViewsInSection(this.mSecondLineViews, (LinearLayout)object, n3);
        n3 = this.mFirstLineViews.size();
        n = 1;
        n3 = n3 > 0 ? 1 : 0;
        if (this.mSecondLineViews.size() <= 0) {
            n = 0;
        }
        if (n3 == 0) {
            linearLayout2.setVisibility(8);
        }
        if (n == 0) {
            if (n3 != 0) {
                linearLayout2.setPadding(linearLayout2.getPaddingLeft(), linearLayout2.getPaddingTop(), linearLayout2.getPaddingRight(), 0);
            }
            object.setVisibility(8);
        }
        if ((object = this.mBottomButtonContainer) == null) return linearLayout;
        if (this.mIsShowButton) {
            object.setVisibility(0);
            linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), 0);
        } else {
            object.setVisibility(8);
        }
        object = this.mBottomButtonTypeFace;
        if (object != null) {
            this.mBottomButton.setTypeface((Typeface)object);
        }
        if ((object = this.mButtonText) != null) {
            this.mBottomButton.setText((CharSequence)object);
        }
        if ((object = this.mButtonClickListener) != null) {
            this.mBottomButton.setOnClickListener((View.OnClickListener)object);
        } else {
            this.mBottomButton.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        return linearLayout;
    }

    private int calculateItemWidth(int n, int n2, int n3, int n4) {
        if (this.mMiniItemWidth == -1) {
            this.mMiniItemWidth = QMUIResHelper.getAttrDimen((Context)this.mContext, (int)R.attr.qmui_bottom_sheet_grid_item_mini_width);
        }
        int n5 = n - n3;
        n4 = n5 - n4;
        n = n3 = this.mMiniItemWidth;
        if (n2 >= 3) {
            int n6 = n4 - n2 * n3;
            n = n3;
            if (n6 > 0) {
                n = n3;
                if (n6 < n3) {
                    n = n4 / (n4 / n3);
                }
            }
        }
        n3 = n;
        if (n2 * n <= n4) return n3;
        n = n5 / n;
        n3 = (int)((float)n5 / ((float)n + 0.5f));
        return n3;
    }

    private void setItemWidth(View view, int n) {
        if (view.getLayoutParams() != null) {
            view = (LinearLayout.LayoutParams)view.getLayoutParams();
            view.width = n;
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n, -2);
            view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            view = layoutParams;
        }
        view.gravity = 48;
    }

    public QMUIBottomSheet.BottomGridSheetBuilder addItem(int n, CharSequence charSequence, int n2) {
        return this.addItem(n, charSequence, charSequence, n2, 0);
    }

    public QMUIBottomSheet.BottomGridSheetBuilder addItem(int n, CharSequence charSequence, Object object, int n2) {
        return this.addItem(n, charSequence, object, n2, 0);
    }

    public QMUIBottomSheet.BottomGridSheetBuilder addItem(int n, CharSequence charSequence, Object object, int n2, int n3) {
        return this.addItem((View)this.createItemView(AppCompatResources.getDrawable((Context)this.mContext, (int)n), charSequence, object, n3), n2);
    }

    public QMUIBottomSheet.BottomGridSheetBuilder addItem(View view, int n) {
        if (n != 0) {
            if (n != 1) return this;
            SparseArray<View> sparseArray = this.mSecondLineViews;
            sparseArray.append(sparseArray.size(), (Object)view);
        } else {
            SparseArray<View> sparseArray = this.mFirstLineViews;
            sparseArray.append(sparseArray.size(), (Object)view);
        }
        return this;
    }

    public QMUIBottomSheet build() {
        this.mDialog = new QMUIBottomSheet(this.mContext);
        View view = this.buildViews();
        this.mDialog.setContentView(view, new ViewGroup.LayoutParams(-1, -2));
        return this.mDialog;
    }

    public QMUIBottomSheetItemView createItemView(Drawable drawable, CharSequence charSequence, Object object, int n) {
        QMUIBottomSheetItemView qMUIBottomSheetItemView = (QMUIBottomSheetItemView)LayoutInflater.from((Context)this.mContext).inflate(this.getItemViewLayoutId(), null, false);
        TextView textView = (TextView)qMUIBottomSheetItemView.findViewById(R.id.grid_item_title);
        Typeface typeface = this.mItemTextTypeFace;
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        textView.setText(charSequence);
        qMUIBottomSheetItemView.setTag(object);
        qMUIBottomSheetItemView.setOnClickListener((View.OnClickListener)this);
        ((AppCompatImageView)qMUIBottomSheetItemView.findViewById(R.id.grid_item_image)).setImageDrawable(drawable);
        if (n == 0) return qMUIBottomSheetItemView;
        ((ImageView)((ViewStub)qMUIBottomSheetItemView.findViewById(R.id.grid_item_subscript)).inflate()).setImageResource(n);
        return qMUIBottomSheetItemView;
    }

    protected int getContentViewLayoutId() {
        return R.layout.qmui_bottom_sheet_grid;
    }

    protected int getItemViewLayoutId() {
        return R.layout.qmui_bottom_sheet_grid_item;
    }

    public void onClick(View view) {
        OnSheetItemClickListener onSheetItemClickListener = this.mOnSheetItemClickListener;
        if (onSheetItemClickListener == null) return;
        onSheetItemClickListener.onClick(this.mDialog, view);
    }

    public QMUIBottomSheet.BottomGridSheetBuilder setBottomButtonTypeFace(Typeface typeface) {
        this.mBottomButtonTypeFace = typeface;
        return this;
    }

    public QMUIBottomSheet.BottomGridSheetBuilder setButtonClickListener(View.OnClickListener onClickListener) {
        this.mButtonClickListener = onClickListener;
        return this;
    }

    public QMUIBottomSheet.BottomGridSheetBuilder setButtonText(CharSequence charSequence) {
        this.mButtonText = charSequence;
        return this;
    }

    public QMUIBottomSheet.BottomGridSheetBuilder setIsShowButton(boolean bl) {
        this.mIsShowButton = bl;
        return this;
    }

    public QMUIBottomSheet.BottomGridSheetBuilder setItemTextTypeFace(Typeface typeface) {
        this.mItemTextTypeFace = typeface;
        return this;
    }

    public void setItemVisibility(Object object, int n) {
        View view;
        View view2;
        int n2;
        int n3 = 0;
        View view3 = null;
        int n4 = 0;
        while (true) {
            n2 = n3;
            view2 = view3;
            if (n4 >= this.mFirstLineViews.size()) break;
            view = (View)this.mFirstLineViews.get(n4);
            view2 = view3;
            if (view != null) {
                view2 = view3;
                if (view.getTag().equals(object)) {
                    view2 = view;
                }
            }
            ++n4;
            view3 = view2;
        }
        while (true) {
            if (n2 >= this.mSecondLineViews.size()) {
                if (view2 == null) return;
                view2.setVisibility(n);
                return;
            }
            view = (View)this.mSecondLineViews.get(n2);
            view3 = view2;
            if (view != null) {
                view3 = view2;
                if (view.getTag().equals(object)) {
                    view3 = view;
                }
            }
            ++n2;
            view2 = view3;
        }
    }

    public QMUIBottomSheet.BottomGridSheetBuilder setOnSheetItemClickListener(OnSheetItemClickListener onSheetItemClickListener) {
        this.mOnSheetItemClickListener = onSheetItemClickListener;
        return this;
    }
}

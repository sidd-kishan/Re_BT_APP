/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  androidx.legacy.widget.Space
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$color
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$layout
 *  com.qmuiteam.qmui.R$string
 *  com.qmuiteam.qmui.R$style
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.layout.QMUILinearLayout
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogAction
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogAction$ActionListener
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder$OnProvideDefaultTheme
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogView$OnDecorationListener
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.legacy.widget.Space;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class QMUIDialogBuilder<T extends QMUIDialogBuilder> {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private static OnProvideDefaultTheme sOnProvideDefaultTheme;
    protected QMUILinearLayout mActionContainer;
    private int mActionContainerOrientation = 0;
    private int mActionDividerColorRes;
    private int mActionDividerInsetEnd = 0;
    private int mActionDividerInsetStart = 0;
    private int mActionDividerThickness = 0;
    protected List<QMUIDialogAction> mActions = new ArrayList<QMUIDialogAction>();
    protected View mAnchorBottomView;
    protected View mAnchorTopView;
    private boolean mCancelable = true;
    private boolean mCanceledOnTouchOutside = true;
    private boolean mChangeAlphaForPressOrDisable = true;
    private int mContentAreaMaxHeight = -1;
    private Context mContext;
    protected QMUIDialog mDialog;
    protected QMUIDialogView mDialogView;
    private QMUIDialogView.OnDecorationListener mOnDecorationListener;
    protected LinearLayout mRootView;
    protected String mTitle;
    protected TextView mTitleView;

    public QMUIDialogBuilder(Context context) {
        this.mActionDividerColorRes = R.color.qmui_config_color_separator;
        this.mContext = context;
    }

    static /* synthetic */ Context access$000(QMUIDialogBuilder qMUIDialogBuilder) {
        return qMUIDialogBuilder.mContext;
    }

    private View createActionContainerSpace(Context context) {
        Space space = new Space(context);
        context = new LinearLayout.LayoutParams(0, 0);
        context.weight = 1.0f;
        space.setLayoutParams((ViewGroup.LayoutParams)context);
        return space;
    }

    public static void setOnProvideDefaultTheme(OnProvideDefaultTheme onProvideDefaultTheme) {
        sOnProvideDefaultTheme = onProvideDefaultTheme;
    }

    public T addAction(int n, int n2, int n3, QMUIDialogAction.ActionListener actionListener) {
        return this.addAction(n, this.mContext.getResources().getString(n2), n3, actionListener);
    }

    public T addAction(int n, int n2, QMUIDialogAction.ActionListener actionListener) {
        return this.addAction(n, n2, 1, actionListener);
    }

    public T addAction(int n, QMUIDialogAction.ActionListener actionListener) {
        return this.addAction(0, n, actionListener);
    }

    public T addAction(int n, CharSequence charSequence, int n2, QMUIDialogAction.ActionListener actionListener) {
        charSequence = new QMUIDialogAction(this.mContext, n, charSequence, n2, actionListener);
        this.mActions.add((QMUIDialogAction)charSequence);
        return (T)this;
    }

    public T addAction(int n, CharSequence charSequence, QMUIDialogAction.ActionListener actionListener) {
        return this.addAction(n, charSequence, 1, actionListener);
    }

    public T addAction(QMUIDialogAction qMUIDialogAction) {
        if (qMUIDialogAction == null) return (T)this;
        this.mActions.add(qMUIDialogAction);
        return (T)this;
    }

    public T addAction(CharSequence charSequence, QMUIDialogAction.ActionListener actionListener) {
        return this.addAction(0, charSequence, 1, actionListener);
    }

    public QMUIDialog create() {
        OnProvideDefaultTheme onProvideDefaultTheme = sOnProvideDefaultTheme;
        if (onProvideDefaultTheme == null) return this.create(R.style.QMUI_Dialog);
        int n = onProvideDefaultTheme.getThemeForBuilder(this);
        if (n <= 0) return this.create(R.style.QMUI_Dialog);
        return this.create(n);
    }

    public QMUIDialog create(int n) {
        LinearLayout linearLayout;
        QMUIDialog qMUIDialog;
        this.mDialog = qMUIDialog = new QMUIDialog(this.mContext, n);
        qMUIDialog = qMUIDialog.getContext();
        this.mRootView = linearLayout = (LinearLayout)LayoutInflater.from((Context)qMUIDialog).inflate(R.layout.qmui_dialog_layout, null);
        linearLayout = (QMUIDialogView)linearLayout.findViewById(R.id.dialog);
        this.mDialogView = linearLayout;
        linearLayout.setOnDecorationListener(this.mOnDecorationListener);
        this.mAnchorTopView = this.mRootView.findViewById(R.id.anchor_top);
        this.mAnchorBottomView = this.mRootView.findViewById(R.id.anchor_bottom);
        this.onCreateTitle(this.mDialog, (ViewGroup)this.mDialogView, (Context)qMUIDialog);
        this.onCreateContent(this.mDialog, (ViewGroup)this.mDialogView, (Context)qMUIDialog);
        this.onCreateHandlerBar(this.mDialog, (ViewGroup)this.mDialogView, (Context)qMUIDialog);
        this.mDialog.addContentView((View)this.mRootView, new ViewGroup.LayoutParams(-1, -2));
        this.mDialog.setCancelable(this.mCancelable);
        this.mDialog.setCanceledOnTouchOutside(this.mCanceledOnTouchOutside);
        this.onAfter(this.mDialog, this.mRootView, (Context)qMUIDialog);
        return this.mDialog;
    }

    public View getAnchorBottomView() {
        return this.mAnchorBottomView;
    }

    public View getAnchorTopView() {
        return this.mAnchorTopView;
    }

    public Context getBaseContext() {
        return this.mContext;
    }

    protected int getContentAreaMaxHeight() {
        int n;
        int n2 = n = this.mContentAreaMaxHeight;
        if (n != -1) return n2;
        double d = QMUIDisplayHelper.getScreenHeight((Context)this.mContext);
        Double.isNaN(d);
        n2 = (int)(d * 0.85) - QMUIDisplayHelper.dp2px((Context)this.mContext, (int)100);
        return n2;
    }

    public List<QMUIDialogAction> getPositiveAction() {
        ArrayList<QMUIDialogAction> arrayList = new ArrayList<QMUIDialogAction>();
        Iterator<QMUIDialogAction> iterator = this.mActions.iterator();
        while (iterator.hasNext()) {
            QMUIDialogAction qMUIDialogAction = iterator.next();
            if (qMUIDialogAction.getActionProp() != 0) continue;
            arrayList.add(qMUIDialogAction);
        }
        return arrayList;
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    protected boolean hasTitle() {
        String string = this.mTitle;
        boolean bl = string != null && string.length() != 0;
        return bl;
    }

    protected void onAfter(QMUIDialog qMUIDialog, LinearLayout linearLayout, Context context) {
        qMUIDialog = new /* Unavailable Anonymous Inner Class!! */;
        this.mAnchorBottomView.setOnClickListener((View.OnClickListener)qMUIDialog);
        this.mAnchorTopView.setOnClickListener((View.OnClickListener)qMUIDialog);
        this.mRootView.setOnClickListener((View.OnClickListener)qMUIDialog);
    }

    protected void onConfigTitleView(TextView textView) {
    }

    protected abstract void onCreateContent(QMUIDialog var1, ViewGroup var2, Context var3);

    protected void onCreateHandlerBar(QMUIDialog object, ViewGroup viewGroup, Context context) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        block26: {
            block24: {
                block27: {
                    block25: {
                        n7 = this.mActions.size();
                        if (n7 <= 0) return;
                        object = R.styleable.QMUIDialogActionContainerCustomDef;
                        n6 = R.attr.qmui_dialog_action_container_style;
                        int n8 = 0;
                        object = context.obtainStyledAttributes(null, (int[])object, n6, 0);
                        int n9 = object.getIndexCount();
                        n5 = 1;
                        n6 = 0;
                        n4 = -1;
                        n3 = 0;
                        for (n2 = 0; n2 < n9; ++n2) {
                            int n10;
                            int n11;
                            int n12 = object.getIndex(n2);
                            if (n12 == R.styleable.QMUIDialogActionContainerCustomDef_qmui_dialog_action_container_justify_content) {
                                n = object.getInteger(n12, n5);
                                n11 = n6;
                                n10 = n3;
                            } else if (n12 == R.styleable.QMUIDialogActionContainerCustomDef_qmui_dialog_action_container_custom_space_index) {
                                n11 = object.getInteger(n12, 0);
                                n = n5;
                                n10 = n3;
                            } else if (n12 == R.styleable.QMUIDialogActionContainerCustomDef_qmui_dialog_action_space) {
                                n10 = object.getDimensionPixelSize(n12, 0);
                                n = n5;
                                n11 = n6;
                            } else {
                                n = n5;
                                n11 = n6;
                                n10 = n3;
                                if (n12 == R.styleable.QMUIDialogActionContainerCustomDef_qmui_dialog_action_height) {
                                    n4 = object.getDimensionPixelSize(n12, 0);
                                    n10 = n3;
                                    n11 = n6;
                                    n = n5;
                                }
                            }
                            n5 = n;
                            n6 = n11;
                            n3 = n10;
                        }
                        object.recycle();
                        if (this.mActionContainerOrientation == 1) break block24;
                        if (n5 != 0) break block25;
                        n6 = n7;
                        break block26;
                    }
                    if (n5 != 1) break block27;
                    n6 = 0;
                    break block26;
                }
                if (n5 == 3) break block26;
            }
            n6 = -1;
        }
        object = new QMUILinearLayout(context, null, R.attr.qmui_dialog_action_container_style);
        this.mActionContainer = object;
        n2 = this.mActionContainerOrientation == 1 ? 1 : 0;
        object.setOrientation(n2);
        this.mActionContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        for (n2 = n8; n2 < n7; ++n2) {
            LinearLayout.LayoutParams layoutParams;
            if (n6 == n2) {
                this.mActionContainer.addView(this.createActionContainerSpace(context));
            }
            QMUIDialogAction qMUIDialogAction = this.mActions.get(n2);
            if (this.mActionContainerOrientation == 1) {
                object = new LinearLayout.LayoutParams(-1, n4);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, n4);
                if (n6 >= 0) {
                    if (n2 >= n6) {
                        layoutParams.leftMargin = n3;
                    } else {
                        layoutParams.rightMargin = n3;
                    }
                }
                object = layoutParams;
                if (n5 == 2) {
                    layoutParams.weight = 1.0f;
                    object = layoutParams;
                }
            }
            layoutParams = qMUIDialogAction.buildActionView(this.mDialog, n2);
            n = this.mActionDividerThickness;
            if (n > 0 && n2 > 0 && n6 != n2) {
                if (this.mActionContainerOrientation == 1) {
                    layoutParams.onlyShowTopDivider(this.mActionDividerInsetStart, this.mActionDividerInsetEnd, n, ContextCompat.getColor((Context)context, (int)this.mActionDividerColorRes));
                } else {
                    layoutParams.onlyShowLeftDivider(this.mActionDividerInsetStart, this.mActionDividerInsetEnd, n, ContextCompat.getColor((Context)context, (int)this.mActionDividerColorRes));
                }
            }
            layoutParams.setChangeAlphaWhenDisable(this.mChangeAlphaForPressOrDisable);
            layoutParams.setChangeAlphaWhenPress(this.mChangeAlphaForPressOrDisable);
            this.mActionContainer.addView((View)layoutParams, (ViewGroup.LayoutParams)object);
        }
        if (n6 == n7) {
            this.mActionContainer.addView(this.createActionContainerSpace(context));
        }
        if (this.mActionContainerOrientation == 0) {
            this.mActionContainer.addOnLayoutChangeListener((View.OnLayoutChangeListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        viewGroup.addView((View)this.mActionContainer);
    }

    protected void onCreateTitle(QMUIDialog qMUIDialog, ViewGroup viewGroup, Context context) {
        if (!this.hasTitle()) return;
        qMUIDialog = new TextView(context);
        this.mTitleView = qMUIDialog;
        qMUIDialog.setText((CharSequence)this.mTitle);
        QMUIResHelper.assignTextViewWithAttr((TextView)this.mTitleView, (int)R.attr.qmui_dialog_title_style);
        this.onConfigTitleView(this.mTitleView);
        qMUIDialog = new LinearLayout.LayoutParams(-1, -2);
        this.mTitleView.setLayoutParams((ViewGroup.LayoutParams)qMUIDialog);
        viewGroup.addView((View)this.mTitleView);
    }

    public T setActionContainerOrientation(int n) {
        this.mActionContainerOrientation = n;
        return (T)this;
    }

    public T setActionDivider(int n, int n2, int n3, int n4) {
        this.mActionDividerThickness = n;
        this.mActionDividerColorRes = n2;
        this.mActionDividerInsetStart = n3;
        this.mActionDividerInsetEnd = n4;
        return (T)this;
    }

    public T setCancelable(boolean bl) {
        this.mCancelable = bl;
        return (T)this;
    }

    public T setCanceledOnTouchOutside(boolean bl) {
        this.mCanceledOnTouchOutside = bl;
        return (T)this;
    }

    public T setChangeAlphaForPressOrDisable(boolean bl) {
        this.mChangeAlphaForPressOrDisable = bl;
        return (T)this;
    }

    public T setContentAreaMaxHeight(int n) {
        this.mContentAreaMaxHeight = n;
        return (T)this;
    }

    public T setOnDecorationListener(QMUIDialogView.OnDecorationListener onDecorationListener) {
        this.mOnDecorationListener = onDecorationListener;
        return (T)this;
    }

    public T setTitle(int n) {
        return this.setTitle(this.mContext.getResources().getString(n));
    }

    public T setTitle(String string2) {
        if (string2 == null) return (T)this;
        if (string2.length() <= 0) return (T)this;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(this.mContext.getString(R.string.qmui_tool_fixellipsize));
        this.mTitle = stringBuilder.toString();
        return (T)this;
    }

    public QMUIDialog show() {
        QMUIDialog qMUIDialog = this.create();
        qMUIDialog.show();
        return qMUIDialog;
    }
}

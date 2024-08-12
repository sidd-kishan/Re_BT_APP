/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.DialogInterface$OnMultiChoiceClickListener
 *  android.database.Cursor
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.SimpleCursorAdapter
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$AlertParams$OnPrepareListViewListener
 *  androidx.appcompat.app.AlertController$CheckedItemAdapter
 *  androidx.appcompat.app.AlertController$RecycleListView
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AlertController;

public static class AlertController.AlertParams {
    public ListAdapter mAdapter;
    public boolean mCancelable;
    public int mCheckedItem = -1;
    public boolean[] mCheckedItems;
    public final Context mContext;
    public Cursor mCursor;
    public View mCustomTitleView;
    public boolean mForceInverseBackground;
    public Drawable mIcon;
    public int mIconAttrId = 0;
    public int mIconId = 0;
    public final LayoutInflater mInflater;
    public String mIsCheckedColumn;
    public boolean mIsMultiChoice;
    public boolean mIsSingleChoice;
    public CharSequence[] mItems;
    public String mLabelColumn;
    public CharSequence mMessage;
    public Drawable mNegativeButtonIcon;
    public DialogInterface.OnClickListener mNegativeButtonListener;
    public CharSequence mNegativeButtonText;
    public Drawable mNeutralButtonIcon;
    public DialogInterface.OnClickListener mNeutralButtonListener;
    public CharSequence mNeutralButtonText;
    public DialogInterface.OnCancelListener mOnCancelListener;
    public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
    public DialogInterface.OnClickListener mOnClickListener;
    public DialogInterface.OnDismissListener mOnDismissListener;
    public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    public DialogInterface.OnKeyListener mOnKeyListener;
    public OnPrepareListViewListener mOnPrepareListViewListener;
    public Drawable mPositiveButtonIcon;
    public DialogInterface.OnClickListener mPositiveButtonListener;
    public CharSequence mPositiveButtonText;
    public boolean mRecycleOnMeasure = true;
    public CharSequence mTitle;
    public View mView;
    public int mViewLayoutResId;
    public int mViewSpacingBottom;
    public int mViewSpacingLeft;
    public int mViewSpacingRight;
    public boolean mViewSpacingSpecified = false;
    public int mViewSpacingTop;

    public AlertController.AlertParams(Context context) {
        this.mContext = context;
        this.mCancelable = true;
        this.mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    private void createListView(AlertController alertController) {
        Object object;
        AlertController.RecycleListView recycleListView = (AlertController.RecycleListView)this.mInflater.inflate(alertController.mListLayout, null);
        if (this.mIsMultiChoice) {
            object = this.mCursor == null ? new /* Unavailable Anonymous Inner Class!! */ : new /* Unavailable Anonymous Inner Class!! */;
        } else {
            int n = this.mIsSingleChoice ? alertController.mSingleChoiceItemLayout : alertController.mListItemLayout;
            if (this.mCursor != null) {
                object = new SimpleCursorAdapter(this.mContext, n, this.mCursor, new String[]{this.mLabelColumn}, new int[]{16908308});
            } else {
                object = this.mAdapter;
                if (object == null) {
                    object = new AlertController.CheckedItemAdapter(this.mContext, n, 16908308, this.mItems);
                }
            }
        }
        OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
        if (onPrepareListViewListener != null) {
            onPrepareListViewListener.onPrepareListView((ListView)recycleListView);
        }
        alertController.mAdapter = object;
        alertController.mCheckedItem = this.mCheckedItem;
        if (this.mOnClickListener != null) {
            recycleListView.setOnItemClickListener((AdapterView.OnItemClickListener)new /* Unavailable Anonymous Inner Class!! */);
        } else if (this.mOnCheckboxClickListener != null) {
            recycleListView.setOnItemClickListener((AdapterView.OnItemClickListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        object = this.mOnItemSelectedListener;
        if (object != null) {
            recycleListView.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)object);
        }
        if (this.mIsSingleChoice) {
            recycleListView.setChoiceMode(1);
        } else if (this.mIsMultiChoice) {
            recycleListView.setChoiceMode(2);
        }
        alertController.mListView = recycleListView;
    }

    public void apply(AlertController alertController) {
        int n;
        Object object = this.mCustomTitleView;
        if (object != null) {
            alertController.setCustomTitle(object);
        } else {
            object = this.mTitle;
            if (object != null) {
                alertController.setTitle((CharSequence)object);
            }
            if ((object = this.mIcon) != null) {
                alertController.setIcon((Drawable)object);
            }
            if ((n = this.mIconId) != 0) {
                alertController.setIcon(n);
            }
            if ((n = this.mIconAttrId) != 0) {
                alertController.setIcon(alertController.getIconAttributeResId(n));
            }
        }
        object = this.mMessage;
        if (object != null) {
            alertController.setMessage((CharSequence)object);
        }
        if (this.mPositiveButtonText != null || this.mPositiveButtonIcon != null) {
            alertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
        }
        if (this.mNegativeButtonText != null || this.mNegativeButtonIcon != null) {
            alertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
        }
        if (this.mNeutralButtonText != null || this.mNeutralButtonIcon != null) {
            alertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
        }
        if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
            this.createListView(alertController);
        }
        if ((object = this.mView) != null) {
            if (this.mViewSpacingSpecified) {
                alertController.setView(object, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            } else {
                alertController.setView(object);
            }
        } else {
            n = this.mViewLayoutResId;
            if (n == 0) return;
            alertController.setView(n);
        }
    }
}

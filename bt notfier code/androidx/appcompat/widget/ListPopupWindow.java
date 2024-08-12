/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AbsListView$OnScrollListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.view.menu.ShowableListMenu
 *  androidx.appcompat.widget.AppCompatPopupWindow
 *  androidx.appcompat.widget.DropDownListView
 *  androidx.appcompat.widget.ListPopupWindow$ListSelectorHider
 *  androidx.appcompat.widget.ListPopupWindow$PopupDataSetObserver
 *  androidx.appcompat.widget.ListPopupWindow$PopupScrollListener
 *  androidx.appcompat.widget.ListPopupWindow$PopupTouchInterceptor
 *  androidx.appcompat.widget.ListPopupWindow$ResizePopupRunnable
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.PopupWindowCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.AppCompatPopupWindow;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

public class ListPopupWindow
implements ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetClipToWindowEnabledMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible = false;
    private View mDropDownAnchorView;
    private int mDropDownGravity = 0;
    private int mDropDownHeight = -2;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth = -2;
    private int mDropDownWindowLayoutType = 1002;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch = false;
    final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum = Integer.MAX_VALUE;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    PopupWindow mPopup;
    private int mPromptPosition = 0;
    private View mPromptView;
    final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable(this);
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor(this);

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)TAG, (String)"Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)TAG, (String)"Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT > 23) return;
        try {
            sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.i((String)TAG, (String)"Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int n) {
        this(context, attributeSet, n, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int n, int n2) {
        int n3;
        this.mScrollListener = new PopupScrollListener(this);
        this.mHideSelector = new ListSelectorHider(this);
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, n, n2);
        this.mDropDownHorizontalOffset = typedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.mDropDownVerticalOffset = n3 = typedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (n3 != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        typedArray.recycle();
        context = new AppCompatPopupWindow(context, attributeSet, n, n2);
        this.mPopup = context;
        context.setInputMethodMode(1);
    }

    private int buildDropDown() {
        int n;
        int n2;
        int n3;
        DropDownListView dropDownListView = this.mDropDownList;
        boolean bl = true;
        if (dropDownListView == null) {
            DropDownListView dropDownListView2;
            dropDownListView = this.mContext;
            this.mShowDropDownRunnable = new /* Unavailable Anonymous Inner Class!! */;
            this.mDropDownList = dropDownListView2 = this.createDropDownListView((Context)dropDownListView, this.mModal ^ true);
            Object object = this.mDropDownListHighlight;
            if (object != null) {
                dropDownListView2.setSelector((Drawable)object);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
            this.mDropDownList.setOnScrollListener((AbsListView.OnScrollListener)this.mScrollListener);
            object = this.mItemSelectedListener;
            if (object != null) {
                this.mDropDownList.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)object);
            }
            object = this.mDropDownList;
            dropDownListView2 = this.mPromptView;
            if (dropDownListView2 != null) {
                dropDownListView = new LinearLayout((Context)dropDownListView);
                dropDownListView.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                n3 = this.mPromptPosition;
                if (n3 != 0) {
                    if (n3 != 1) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Invalid hint position ");
                        ((StringBuilder)object).append(this.mPromptPosition);
                        Log.e((String)TAG, (String)((StringBuilder)object).toString());
                    } else {
                        dropDownListView.addView((View)object, (ViewGroup.LayoutParams)layoutParams);
                        dropDownListView.addView((View)dropDownListView2);
                    }
                } else {
                    dropDownListView.addView((View)dropDownListView2);
                    dropDownListView.addView((View)object, (ViewGroup.LayoutParams)layoutParams);
                }
                n2 = this.mDropDownWidth;
                if (n2 >= 0) {
                    n3 = Integer.MIN_VALUE;
                } else {
                    n2 = 0;
                    n3 = 0;
                }
                dropDownListView2.measure(View.MeasureSpec.makeMeasureSpec((int)n2, (int)n3), 0);
                object = (LinearLayout.LayoutParams)dropDownListView2.getLayoutParams();
                n3 = dropDownListView2.getMeasuredHeight() + ((LinearLayout.LayoutParams)object).topMargin + ((LinearLayout.LayoutParams)object).bottomMargin;
            } else {
                n3 = 0;
                dropDownListView = object;
            }
            this.mPopup.setContentView((View)dropDownListView);
        } else {
            dropDownListView = (ViewGroup)this.mPopup.getContentView();
            View view = this.mPromptView;
            if (view != null) {
                dropDownListView = (LinearLayout.LayoutParams)view.getLayoutParams();
                n3 = view.getMeasuredHeight() + dropDownListView.topMargin + dropDownListView.bottomMargin;
            } else {
                n3 = 0;
            }
        }
        dropDownListView = this.mPopup.getBackground();
        if (dropDownListView != null) {
            dropDownListView.getPadding(this.mTempRect);
            n = n2 = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -this.mTempRect.top;
                n = n2;
            }
        } else {
            this.mTempRect.setEmpty();
            n = 0;
        }
        if (this.mPopup.getInputMethodMode() != 2) {
            bl = false;
        }
        int n4 = this.getMaxAvailableHeight(this.getAnchorView(), this.mDropDownVerticalOffset, bl);
        if (this.mDropDownAlwaysVisible) return n4 + n;
        if (this.mDropDownHeight == -1) {
            return n4 + n;
        }
        n2 = this.mDropDownWidth;
        n2 = n2 != -2 ? (n2 != -1 ? View.MeasureSpec.makeMeasureSpec((int)n2, (int)0x40000000) : View.MeasureSpec.makeMeasureSpec((int)(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right)), (int)0x40000000)) : View.MeasureSpec.makeMeasureSpec((int)(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right)), (int)Integer.MIN_VALUE);
        n4 = this.mDropDownList.measureHeightOfChildrenCompat(n2, 0, -1, n4 - n3, -1);
        n2 = n3;
        if (n4 <= 0) return n4 + n2;
        n2 = n3 + (n + (this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom()));
        return n4 + n2;
    }

    private int getMaxAvailableHeight(View view, int n, boolean bl) {
        if (Build.VERSION.SDK_INT > 23) return this.mPopup.getMaxAvailableHeight(view, n, bl);
        Method method = sGetMaxAvailableHeightMethod;
        if (method == null) return this.mPopup.getMaxAvailableHeight(view, n);
        try {
            int n2 = (Integer)method.invoke(this.mPopup, view, n, bl);
            return n2;
        }
        catch (Exception exception) {
            Log.i((String)TAG, (String)"Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
        }
        return this.mPopup.getMaxAvailableHeight(view, n);
    }

    private static boolean isConfirmKey(int n) {
        boolean bl = n == 66 || n == 23;
        return bl;
    }

    private void removePromptView() {
        View view = this.mPromptView;
        if (view == null) return;
        if (!((view = view.getParent()) instanceof ViewGroup)) return;
        ((ViewGroup)view).removeView(this.mPromptView);
    }

    private void setPopupClipToScreenEnabled(boolean bl) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = sSetClipToWindowEnabledMethod;
            if (method == null) return;
            try {
                method.invoke(this.mPopup, bl);
            }
            catch (Exception exception) {
                Log.i((String)TAG, (String)"Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        } else {
            this.mPopup.setIsClippedToScreen(bl);
        }
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView == null) return;
        dropDownListView.setListSelectionHidden(true);
        dropDownListView.requestLayout();
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    DropDownListView createDropDownListView(Context context, boolean bl) {
        return new DropDownListView(context, bl);
    }

    public void dismiss() {
        this.mPopup.dismiss();
        this.removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks((Runnable)this.mResizePopupRunnable);
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public Rect getEpicenterBounds() {
        Rect rect = this.mEpicenterBounds != null ? new Rect(this.mEpicenterBounds) : null;
        return rect;
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public Object getSelectedItem() {
        if (this.isShowing()) return this.mDropDownList.getSelectedItem();
        return null;
    }

    public long getSelectedItemId() {
        if (this.isShowing()) return this.mDropDownList.getSelectedItemId();
        return Long.MIN_VALUE;
    }

    public int getSelectedItemPosition() {
        if (this.isShowing()) return this.mDropDownList.getSelectedItemPosition();
        return -1;
    }

    public View getSelectedView() {
        if (this.isShowing()) return this.mDropDownList.getSelectedView();
        return null;
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (this.mDropDownVerticalOffsetSet) return this.mDropDownVerticalOffset;
        return 0;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        boolean bl = this.mPopup.getInputMethodMode() == 2;
        return bl;
    }

    public boolean isModal() {
        return this.mModal;
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        if (!this.isShowing()) return false;
        if (n == 62) return false;
        if (this.mDropDownList.getSelectedItemPosition() < 0) {
            if (ListPopupWindow.isConfirmKey(n)) return false;
        }
        int n2 = this.mDropDownList.getSelectedItemPosition();
        boolean bl = this.mPopup.isAboveAnchor() ^ true;
        ListAdapter listAdapter = this.mAdapter;
        int n3 = Integer.MAX_VALUE;
        int n4 = Integer.MIN_VALUE;
        if (listAdapter != null) {
            boolean bl2 = listAdapter.areAllItemsEnabled();
            n3 = bl2 ? 0 : this.mDropDownList.lookForSelectablePosition(0, true);
            n4 = bl2 ? listAdapter.getCount() - 1 : this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() - 1, false);
        }
        if (bl && n == 19 && n2 <= n3 || !bl && n == 20 && n2 >= n4) {
            this.clearListSelection();
            this.mPopup.setInputMethodMode(1);
            this.show();
            return true;
        }
        this.mDropDownList.setListSelectionHidden(false);
        if (this.mDropDownList.onKeyDown(n, keyEvent)) {
            this.mPopup.setInputMethodMode(2);
            this.mDropDownList.requestFocusFromTouch();
            this.show();
            if (n == 19) return true;
            if (n == 20) return true;
            if (n == 23) return true;
            if (n == 66) return true;
            return false;
        }
        if (bl && n == 20) {
            if (n2 != n4) return false;
            return true;
        }
        if (bl) return false;
        if (n != 19) return false;
        if (n2 != n3) return false;
        return true;
    }

    public boolean onKeyPreIme(int n, KeyEvent keyEvent) {
        if (n != 4) return false;
        if (!this.isShowing()) return false;
        View view = this.mDropDownAnchorView;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            if ((view = view.getKeyDispatcherState()) == null) return true;
            view.startTracking(keyEvent, (Object)this);
            return true;
        }
        if (keyEvent.getAction() != 1) return false;
        if ((view = view.getKeyDispatcherState()) != null) {
            view.handleUpEvent(keyEvent);
        }
        if (!keyEvent.isTracking()) return false;
        if (keyEvent.isCanceled()) return false;
        this.dismiss();
        return true;
    }

    public boolean onKeyUp(int n, KeyEvent keyEvent) {
        if (!this.isShowing()) return false;
        if (this.mDropDownList.getSelectedItemPosition() < 0) return false;
        boolean bl = this.mDropDownList.onKeyUp(n, keyEvent);
        if (!bl) return bl;
        if (!ListPopupWindow.isConfirmKey(n)) return bl;
        this.dismiss();
        return bl;
    }

    public boolean performItemClick(int n) {
        if (!this.isShowing()) return false;
        if (this.mItemClickListener == null) return true;
        DropDownListView dropDownListView = this.mDropDownList;
        View view = dropDownListView.getChildAt(n - dropDownListView.getFirstVisiblePosition());
        ListAdapter listAdapter = dropDownListView.getAdapter();
        this.mItemClickListener.onItemClick((AdapterView)dropDownListView, view, n, listAdapter.getItemId(n));
        return true;
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.mObserver;
        if (dataSetObserver == null) {
            this.mObserver = new PopupDataSetObserver(this);
        } else {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if ((listAdapter = this.mDropDownList) == null) return;
        listAdapter.setAdapter(this.mAdapter);
    }

    public void setAnchorView(View view) {
        this.mDropDownAnchorView = view;
    }

    public void setAnimationStyle(int n) {
        this.mPopup.setAnimationStyle(n);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int n) {
        Drawable drawable = this.mPopup.getBackground();
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            this.mDropDownWidth = this.mTempRect.left + this.mTempRect.right + n;
        } else {
            this.setWidth(n);
        }
    }

    public void setDropDownAlwaysVisible(boolean bl) {
        this.mDropDownAlwaysVisible = bl;
    }

    public void setDropDownGravity(int n) {
        this.mDropDownGravity = n;
    }

    public void setEpicenterBounds(Rect object) {
        object = object != null ? new Rect(object) : null;
        this.mEpicenterBounds = object;
    }

    public void setForceIgnoreOutsideTouch(boolean bl) {
        this.mForceIgnoreOutsideTouch = bl;
    }

    public void setHeight(int n) {
        if (n < 0 && -2 != n) {
            if (-1 != n) throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.mDropDownHeight = n;
    }

    public void setHorizontalOffset(int n) {
        this.mDropDownHorizontalOffset = n;
    }

    public void setInputMethodMode(int n) {
        this.mPopup.setInputMethodMode(n);
    }

    void setListItemExpandMax(int n) {
        this.mListItemExpandMaximum = n;
    }

    public void setListSelector(Drawable drawable) {
        this.mDropDownListHighlight = drawable;
    }

    public void setModal(boolean bl) {
        this.mModal = bl;
        this.mPopup.setFocusable(bl);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    public void setOverlapAnchor(boolean bl) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = bl;
    }

    public void setPromptPosition(int n) {
        this.mPromptPosition = n;
    }

    public void setPromptView(View view) {
        boolean bl = this.isShowing();
        if (bl) {
            this.removePromptView();
        }
        this.mPromptView = view;
        if (!bl) return;
        this.show();
    }

    public void setSelection(int n) {
        DropDownListView dropDownListView = this.mDropDownList;
        if (!this.isShowing()) return;
        if (dropDownListView == null) return;
        dropDownListView.setListSelectionHidden(false);
        dropDownListView.setSelection(n);
        if (dropDownListView.getChoiceMode() == 0) return;
        dropDownListView.setItemChecked(n, true);
    }

    public void setSoftInputMode(int n) {
        this.mPopup.setSoftInputMode(n);
    }

    public void setVerticalOffset(int n) {
        this.mDropDownVerticalOffset = n;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int n) {
        this.mDropDownWidth = n;
    }

    public void setWindowLayoutType(int n) {
        this.mDropDownWindowLayoutType = n;
    }

    public void show() {
        int n = this.buildDropDown();
        boolean bl = this.isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType((PopupWindow)this.mPopup, (int)this.mDropDownWindowLayoutType);
        boolean bl2 = this.mPopup.isShowing();
        boolean bl3 = true;
        if (bl2) {
            PopupWindow popupWindow;
            int n2;
            if (!ViewCompat.isAttachedToWindow((View)this.getAnchorView())) {
                return;
            }
            int n3 = this.mDropDownWidth;
            if (n3 == -1) {
                n2 = -1;
            } else {
                n2 = n3;
                if (n3 == -2) {
                    n2 = this.getAnchorView().getWidth();
                }
            }
            n3 = this.mDropDownHeight;
            if (n3 == -1) {
                if (!bl) {
                    n = -1;
                }
                if (bl) {
                    popupWindow = this.mPopup;
                    n3 = this.mDropDownWidth == -1 ? -1 : 0;
                    popupWindow.setWidth(n3);
                    this.mPopup.setHeight(0);
                } else {
                    popupWindow = this.mPopup;
                    n3 = this.mDropDownWidth == -1 ? -1 : 0;
                    popupWindow.setWidth(n3);
                    this.mPopup.setHeight(-1);
                }
            } else if (n3 != -2) {
                n = n3;
            }
            popupWindow = this.mPopup;
            if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
                bl3 = false;
            }
            popupWindow.setOutsideTouchable(bl3);
            PopupWindow popupWindow2 = this.mPopup;
            popupWindow = this.getAnchorView();
            n3 = this.mDropDownHorizontalOffset;
            int n4 = this.mDropDownVerticalOffset;
            if (n2 < 0) {
                n2 = -1;
            }
            if (n < 0) {
                n = -1;
            }
            popupWindow2.update((View)popupWindow, n3, n4, n2, n);
        } else {
            int n5;
            int n6 = this.mDropDownWidth;
            if (n6 == -1) {
                n5 = -1;
            } else {
                n5 = n6;
                if (n6 == -2) {
                    n5 = this.getAnchorView().getWidth();
                }
            }
            n6 = this.mDropDownHeight;
            if (n6 == -1) {
                n = -1;
            } else if (n6 != -2) {
                n = n6;
            }
            this.mPopup.setWidth(n5);
            this.mPopup.setHeight(n);
            this.setPopupClipToScreenEnabled(true);
            Object object = this.mPopup;
            bl3 = !this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible;
            object.setOutsideTouchable(bl3);
            this.mPopup.setTouchInterceptor((View.OnTouchListener)this.mTouchInterceptor);
            if (this.mOverlapAnchorSet) {
                PopupWindowCompat.setOverlapAnchor((PopupWindow)this.mPopup, (boolean)this.mOverlapAnchor);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                object = sSetEpicenterBoundsMethod;
                if (object != null) {
                    try {
                        ((Method)object).invoke(this.mPopup, this.mEpicenterBounds);
                    }
                    catch (Exception exception) {
                        Log.e((String)TAG, (String)"Could not invoke setEpicenterBounds on PopupWindow", (Throwable)exception);
                    }
                }
            } else {
                this.mPopup.setEpicenterBounds(this.mEpicenterBounds);
            }
            PopupWindowCompat.showAsDropDown((PopupWindow)this.mPopup, (View)this.getAnchorView(), (int)this.mDropDownHorizontalOffset, (int)this.mDropDownVerticalOffset, (int)this.mDropDownGravity);
            this.mDropDownList.setSelection(-1);
            if (!this.mModal || this.mDropDownList.isInTouchMode()) {
                this.clearListSelection();
            }
            if (this.mModal) return;
            this.mHandler.post((Runnable)this.mHideSelector);
        }
    }
}

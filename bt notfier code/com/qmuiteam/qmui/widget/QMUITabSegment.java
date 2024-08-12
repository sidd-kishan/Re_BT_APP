/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.HorizontalScrollView
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  androidx.viewpager.widget.ViewPager$OnAdapterChangeListener
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.qmuiteam.qmui.QMUIInterpolatorStaticHolder
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$color
 *  com.qmuiteam.qmui.R$dimen
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUIColorHelper
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUILangHelper
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.widget.QMUITabSegment$AdapterChangeListener
 *  com.qmuiteam.qmui.widget.QMUITabSegment$Container
 *  com.qmuiteam.qmui.widget.QMUITabSegment$OnTabClickListener
 *  com.qmuiteam.qmui.widget.QMUITabSegment$OnTabSelectedListener
 *  com.qmuiteam.qmui.widget.QMUITabSegment$PagerAdapterObserver
 *  com.qmuiteam.qmui.widget.QMUITabSegment$Tab
 *  com.qmuiteam.qmui.widget.QMUITabSegment$TabAdapter
 *  com.qmuiteam.qmui.widget.QMUITabSegment$TabItemView
 *  com.qmuiteam.qmui.widget.QMUITabSegment$TabLayoutOnPageChangeListener
 *  com.qmuiteam.qmui.widget.QMUITabSegment$TypefaceProvider
 *  com.qmuiteam.qmui.widget.QMUITabSegment$ViewPagerOnTabSelectedListener
 */
package com.qmuiteam.qmui.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.qmuiteam.qmui.QMUIInterpolatorStaticHolder;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIColorHelper;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public class QMUITabSegment
extends HorizontalScrollView {
    public static final int ICON_POSITION_BOTTOM = 3;
    public static final int ICON_POSITION_LEFT = 0;
    public static final int ICON_POSITION_RIGHT = 2;
    public static final int ICON_POSITION_TOP = 1;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int NO_POSITION = -1;
    private static final String TAG = "QMUITabSegment";
    private AdapterChangeListener mAdapterChangeListener;
    private Container mContentLayout;
    private int mCurrentSelectedIndex = -1;
    private int mDefaultNormalColor;
    private int mDefaultSelectedColor;
    private int mDefaultTabIconPosition;
    private boolean mHasIndicator = true;
    private Drawable mIndicatorDrawable;
    private int mIndicatorHeight;
    private Paint mIndicatorPaint = null;
    private Rect mIndicatorRect = null;
    private boolean mIndicatorTop = false;
    private boolean mIsInSelectTab = false;
    private boolean mIsIndicatorWidthFollowContent = true;
    private int mItemSpaceInScrollMode;
    private int mMode = 1;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private OnTabClickListener mOnTabClickListener;
    private PagerAdapter mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private int mPendingSelectedIndex = -1;
    private Animator mSelectAnimator;
    private final ArrayList<OnTabSelectedListener> mSelectedListeners = new ArrayList();
    protected View.OnClickListener mTabOnClickListener = new /* Unavailable Anonymous Inner Class!! */;
    private int mTabTextSize;
    private TypefaceProvider mTypefaceProvider;
    private ViewPager mViewPager;
    private int mViewPagerScrollState = 0;
    private OnTabSelectedListener mViewPagerSelectedListener;

    public QMUITabSegment(Context context) {
        this(context, null);
    }

    public QMUITabSegment(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUITabSegmentStyle);
    }

    public QMUITabSegment(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
        this.setHorizontalScrollBarEnabled(false);
        this.setClipToPadding(false);
    }

    public QMUITabSegment(Context context, boolean bl) {
        this(context, null);
        this.mHasIndicator = bl;
    }

    static /* synthetic */ Animator access$000(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mSelectAnimator;
    }

    static /* synthetic */ Animator access$002(QMUITabSegment qMUITabSegment, Animator animator) {
        qMUITabSegment.mSelectAnimator = animator;
        return animator;
    }

    static /* synthetic */ int access$100(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mViewPagerScrollState;
    }

    static /* synthetic */ void access$1000(QMUITabSegment qMUITabSegment, TextView textView, boolean bl) {
        qMUITabSegment.setTextViewTypeface(textView, bl);
    }

    static /* synthetic */ int access$1100(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mCurrentSelectedIndex;
    }

    static /* synthetic */ int access$1102(QMUITabSegment qMUITabSegment, int n) {
        qMUITabSegment.mCurrentSelectedIndex = n;
        return n;
    }

    static /* synthetic */ boolean access$1202(QMUITabSegment qMUITabSegment, boolean bl) {
        qMUITabSegment.mIsInSelectTab = bl;
        return bl;
    }

    static /* synthetic */ int access$1300(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mPendingSelectedIndex;
    }

    static /* synthetic */ int access$1302(QMUITabSegment qMUITabSegment, int n) {
        qMUITabSegment.mPendingSelectedIndex = n;
        return n;
    }

    static /* synthetic */ void access$1400(QMUITabSegment qMUITabSegment, Tab tab, boolean bl) {
        qMUITabSegment.layoutIndicator(tab, bl);
    }

    static /* synthetic */ void access$1700(QMUITabSegment qMUITabSegment, int n) {
        qMUITabSegment.setViewPagerScrollState(n);
    }

    static /* synthetic */ int access$1800(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.getTabCount();
    }

    static /* synthetic */ int access$1900(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mMode;
    }

    static /* synthetic */ TabAdapter access$200(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.getAdapter();
    }

    static /* synthetic */ int access$2000(QMUITabSegment qMUITabSegment, Tab tab) {
        return qMUITabSegment.getTabTextSize(tab);
    }

    static /* synthetic */ ViewPager access$2100(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mViewPager;
    }

    static /* synthetic */ ArrayList access$2200(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mSelectedListeners;
    }

    static /* synthetic */ void access$2300(QMUITabSegment qMUITabSegment, int n) {
        qMUITabSegment.dispatchTabDoubleTap(n);
    }

    static /* synthetic */ int access$2400(QMUITabSegment qMUITabSegment, Tab tab) {
        return qMUITabSegment.getTabIconPosition(tab);
    }

    static /* synthetic */ void access$2500(QMUITabSegment qMUITabSegment, TextView textView, Drawable drawable, int n) {
        qMUITabSegment.setDrawable(textView, drawable, n);
    }

    static /* synthetic */ int access$2800(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mItemSpaceInScrollMode;
    }

    static /* synthetic */ boolean access$300(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mHasIndicator;
    }

    static /* synthetic */ boolean access$3100(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mIsIndicatorWidthFollowContent;
    }

    static /* synthetic */ Rect access$3200(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mIndicatorRect;
    }

    static /* synthetic */ boolean access$3300(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mIndicatorTop;
    }

    static /* synthetic */ int access$3400(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mIndicatorHeight;
    }

    static /* synthetic */ Drawable access$3500(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mIndicatorDrawable;
    }

    static /* synthetic */ Paint access$3600(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mIndicatorPaint;
    }

    static /* synthetic */ OnTabClickListener access$400(QMUITabSegment qMUITabSegment) {
        return qMUITabSegment.mOnTabClickListener;
    }

    static /* synthetic */ int access$500(QMUITabSegment qMUITabSegment, Tab tab) {
        return qMUITabSegment.getTabSelectedColor(tab);
    }

    static /* synthetic */ int access$600(QMUITabSegment qMUITabSegment, Tab tab) {
        return qMUITabSegment.getTabNormalColor(tab);
    }

    static /* synthetic */ void access$700(QMUITabSegment qMUITabSegment, Tab tab, Tab tab2, float f) {
        qMUITabSegment.layoutIndicatorInTransition(tab, tab2, f);
    }

    static /* synthetic */ void access$800(QMUITabSegment qMUITabSegment, int n) {
        qMUITabSegment.dispatchTabSelected(n);
    }

    static /* synthetic */ void access$900(QMUITabSegment qMUITabSegment, int n) {
        qMUITabSegment.dispatchTabUnselected(n);
    }

    private void createTypefaceProvider(Context object, String string) {
        if (QMUILangHelper.isNullOrEmpty((CharSequence)string)) {
            return;
        }
        if ((string = string.trim()).length() == 0) {
            return;
        }
        string = this.getFullClassName((Context)object, string);
        try {
            object = this.isInEditMode() ? ((Object)((Object)this)).getClass().getClassLoader() : object.getClassLoader();
            object = ((ClassLoader)object).loadClass(string).asSubclass(TypefaceProvider.class);
            try {
                object = ((Class)object).getConstructor(new Class[0]);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error creating TypefaceProvider ");
                stringBuilder.append(string);
                object = new IllegalStateException(stringBuilder.toString(), noSuchMethodException);
                throw object;
            }
            ((AccessibleObject)object).setAccessible(true);
            this.mTypefaceProvider = (TypefaceProvider)((Constructor)object).newInstance(new Object[0]);
            return;
        }
        catch (ClassCastException classCastException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class is not a TypefaceProvider ");
            stringBuilder.append(string);
            throw new IllegalStateException(stringBuilder.toString(), classCastException);
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot access non-public constructor ");
            ((StringBuilder)object).append(string);
            throw new IllegalStateException(((StringBuilder)object).toString(), illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not instantiate the TypefaceProvider: ");
            stringBuilder.append(string);
            throw new IllegalStateException(stringBuilder.toString(), instantiationException);
        }
        catch (InvocationTargetException invocationTargetException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Could not instantiate the TypefaceProvider: ");
            ((StringBuilder)object).append(string);
            throw new IllegalStateException(((StringBuilder)object).toString(), invocationTargetException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Unable to find TypefaceProvider ");
            ((StringBuilder)object).append(string);
            throw new IllegalStateException(((StringBuilder)object).toString(), classNotFoundException);
        }
    }

    private void dispatchTabDoubleTap(int n) {
        int n2 = this.mSelectedListeners.size() - 1;
        while (n2 >= 0) {
            this.mSelectedListeners.get(n2).onDoubleTap(n);
            --n2;
        }
    }

    private void dispatchTabReselected(int n) {
        int n2 = this.mSelectedListeners.size() - 1;
        while (n2 >= 0) {
            this.mSelectedListeners.get(n2).onTabReselected(n);
            --n2;
        }
    }

    private void dispatchTabSelected(int n) {
        int n2 = this.mSelectedListeners.size() - 1;
        while (n2 >= 0) {
            this.mSelectedListeners.get(n2).onTabSelected(n);
            --n2;
        }
    }

    private void dispatchTabUnselected(int n) {
        int n2 = this.mSelectedListeners.size() - 1;
        while (n2 >= 0) {
            this.mSelectedListeners.get(n2).onTabUnselected(n);
            --n2;
        }
    }

    private TabAdapter getAdapter() {
        return this.mContentLayout.getTabAdapter();
    }

    private String getFullClassName(Context context, String string) {
        if (string.charAt(0) != '.') return string;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getPackageName());
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    private int getTabCount() {
        return this.getAdapter().getSize();
    }

    private int getTabIconPosition(Tab tab) {
        int n;
        int n2 = n = tab.getIconPosition();
        if (n != Integer.MIN_VALUE) return n2;
        n2 = this.mDefaultTabIconPosition;
        return n2;
    }

    private int getTabNormalColor(Tab tab) {
        int n;
        int n2 = n = tab.getNormalColor();
        if (n != Integer.MIN_VALUE) return n2;
        n2 = this.mDefaultNormalColor;
        return n2;
    }

    private int getTabSelectedColor(Tab tab) {
        int n;
        int n2 = n = tab.getSelectedColor();
        if (n != Integer.MIN_VALUE) return n2;
        n2 = this.mDefaultSelectedColor;
        return n2;
    }

    private int getTabTextSize(Tab tab) {
        int n;
        int n2 = n = tab.getTextSize();
        if (n != Integer.MIN_VALUE) return n2;
        n2 = this.mTabTextSize;
        return n2;
    }

    private void init(Context context, AttributeSet object, int n) {
        this.mDefaultSelectedColor = QMUIResHelper.getAttrColor((Context)context, (int)R.attr.qmui_config_color_blue);
        this.mDefaultNormalColor = ContextCompat.getColor((Context)context, (int)R.color.qmui_config_color_gray_5);
        TypedArray typedArray = context.obtainStyledAttributes((AttributeSet)object, R.styleable.QMUITabSegment, n, 0);
        this.mHasIndicator = typedArray.getBoolean(R.styleable.QMUITabSegment_qmui_tab_has_indicator, true);
        this.mIndicatorHeight = typedArray.getDimensionPixelSize(R.styleable.QMUITabSegment_qmui_tab_indicator_height, this.getResources().getDimensionPixelSize(R.dimen.qmui_tab_segment_indicator_height));
        this.mTabTextSize = typedArray.getDimensionPixelSize(R.styleable.QMUITabSegment_android_textSize, this.getResources().getDimensionPixelSize(R.dimen.qmui_tab_segment_text_size));
        this.mIndicatorTop = typedArray.getBoolean(R.styleable.QMUITabSegment_qmui_tab_indicator_top, false);
        this.mDefaultTabIconPosition = typedArray.getInt(R.styleable.QMUITabSegment_qmui_tab_icon_position, 0);
        this.mMode = typedArray.getInt(R.styleable.QMUITabSegment_qmui_tab_mode, 1);
        this.mItemSpaceInScrollMode = typedArray.getDimensionPixelSize(R.styleable.QMUITabSegment_qmui_tab_space, QMUIDisplayHelper.dp2px((Context)context, (int)10));
        object = typedArray.getString(R.styleable.QMUITabSegment_qmui_tab_typeface_provider);
        typedArray.recycle();
        typedArray = new Container(this, context);
        this.mContentLayout = typedArray;
        this.addView((View)typedArray, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -1));
        this.createTypefaceProvider(context, (String)object);
    }

    private void layoutIndicator(Tab tab, boolean bl) {
        if (tab == null) {
            return;
        }
        Rect rect = this.mIndicatorRect;
        if (rect == null) {
            this.mIndicatorRect = new Rect(Tab.access$1500((Tab)tab), 0, Tab.access$1500((Tab)tab) + Tab.access$1600((Tab)tab), 0);
        } else {
            rect.left = Tab.access$1500((Tab)tab);
            this.mIndicatorRect.right = Tab.access$1500((Tab)tab) + Tab.access$1600((Tab)tab);
        }
        if (this.mIndicatorPaint == null) {
            rect = new Paint();
            this.mIndicatorPaint = rect;
            rect.setStyle(Paint.Style.FILL);
        }
        this.mIndicatorPaint.setColor(this.getTabSelectedColor(tab));
        if (!bl) return;
        this.mContentLayout.invalidate();
    }

    private void layoutIndicatorInTransition(Tab tab, Tab tab2, float f) {
        int n = tab2.getContentLeft();
        int n2 = tab.getContentLeft();
        int n3 = tab2.getContentWidth();
        int n4 = tab.getContentWidth();
        n = (int)((float)tab.getContentLeft() + (float)(n - n2) * f);
        n3 = (int)((float)tab.getContentWidth() + (float)(n3 - n4) * f);
        Rect rect = this.mIndicatorRect;
        if (rect == null) {
            this.mIndicatorRect = new Rect(n, 0, n3 + n, 0);
        } else {
            rect.left = n;
            this.mIndicatorRect.right = n + n3;
        }
        if (this.mIndicatorPaint == null) {
            rect = new Paint();
            this.mIndicatorPaint = rect;
            rect.setStyle(Paint.Style.FILL);
        }
        n3 = QMUIColorHelper.computeColor((int)this.getTabSelectedColor(tab), (int)this.getTabSelectedColor(tab2), (float)f);
        this.mIndicatorPaint.setColor(n3);
        this.mContentLayout.invalidate();
    }

    private void setDrawable(TextView textView, Drawable drawable, int n) {
        Object object = n == 0 ? drawable : null;
        Object object2 = n == 1 ? drawable : null;
        Object object3 = n == 2 ? drawable : null;
        if (n != 3) {
            drawable = null;
        }
        textView.setCompoundDrawables(object, object2, object3, drawable);
    }

    private void setTextViewTypeface(TextView textView, boolean bl) {
        TypefaceProvider typefaceProvider = this.mTypefaceProvider;
        if (typefaceProvider == null) return;
        if (textView == null) return;
        int n = (bl ? typefaceProvider.isSelectedTabBold() : typefaceProvider.isNormalTabBold()) ? 1 : 0;
        textView.setTypeface(this.mTypefaceProvider.getTypeface(), n);
    }

    private void setViewPagerScrollState(int n) {
        this.mViewPagerScrollState = n;
        if (n != 0) return;
        n = this.mPendingSelectedIndex;
        if (n == -1) return;
        if (this.mSelectAnimator != null) return;
        this.selectTab(n, true, false);
        this.mPendingSelectedIndex = -1;
    }

    public void addOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        if (this.mSelectedListeners.contains(onTabSelectedListener)) return;
        this.mSelectedListeners.add(onTabSelectedListener);
    }

    public QMUITabSegment addTab(Tab tab) {
        this.mContentLayout.getTabAdapter().addItem((Object)tab);
        return this;
    }

    public void clearOnTabSelectedListeners() {
        this.mSelectedListeners.clear();
    }

    public int getMode() {
        return this.mMode;
    }

    public int getSelectedIndex() {
        return this.mCurrentSelectedIndex;
    }

    public int getSignCount(int n) {
        return ((Tab)this.getAdapter().getItem(n)).getSignCount();
    }

    public Tab getTab(int n) {
        return (Tab)this.getAdapter().getItem(n);
    }

    public void hideSignCountView(int n) {
        ((Tab)this.getAdapter().getItem(n)).hideSignCountView();
    }

    public void notifyDataChanged() {
        this.getAdapter().setup();
        this.populateFromPagerAdapter(false);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        if (this.mCurrentSelectedIndex == -1) return;
        if (this.mMode != 0) return;
        TabItemView tabItemView = (TabItemView)this.getAdapter().getViews().get(this.mCurrentSelectedIndex);
        if (this.getScrollX() > tabItemView.getLeft()) {
            this.scrollTo(tabItemView.getLeft(), 0);
        } else {
            n = this.getWidth() - this.getPaddingRight() - this.getPaddingLeft();
            if (this.getScrollX() + n >= tabItemView.getRight()) return;
            this.scrollBy(tabItemView.getRight() - n - this.getScrollX(), 0);
        }
    }

    protected void onMeasure(int n, int n2) {
        int n3 = View.MeasureSpec.getSize((int)n);
        int n4 = View.MeasureSpec.getMode((int)n);
        if (this.getChildCount() > 0) {
            View view = this.getChildAt(0);
            int n5 = this.getPaddingLeft() + this.getPaddingRight();
            view.measure(View.MeasureSpec.makeMeasureSpec((int)(n3 - n5), (int)0x40000000), n2);
            if (n4 == Integer.MIN_VALUE) {
                this.setMeasuredDimension(Math.min(n3, view.getMeasuredWidth() + n5), n2);
                return;
            }
        }
        this.setMeasuredDimension(n, n2);
    }

    void populateFromPagerAdapter(boolean bl) {
        PagerAdapter pagerAdapter = this.mPagerAdapter;
        if (pagerAdapter == null) {
            if (!bl) return;
            this.reset();
            return;
        }
        int n = pagerAdapter.getCount();
        if (bl) {
            this.reset();
            for (int i = 0; i < n; ++i) {
                this.addTab(new Tab(this.mPagerAdapter.getPageTitle(i)));
            }
            this.notifyDataChanged();
        }
        if ((pagerAdapter = this.mViewPager) == null) return;
        if (n <= 0) return;
        this.selectTab(pagerAdapter.getCurrentItem(), true, false);
    }

    public void removeOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mSelectedListeners.remove(onTabSelectedListener);
    }

    public void replaceTab(int n, Tab tab) {
        try {
            this.getAdapter().replaceItem(n, (Object)tab);
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
    }

    public void reset() {
        this.mContentLayout.getTabAdapter().clear();
        this.mCurrentSelectedIndex = -1;
        Animator animator = this.mSelectAnimator;
        if (animator == null) return;
        animator.cancel();
        this.mSelectAnimator = null;
    }

    public void selectTab(int n) {
        this.selectTab(n, false, false);
    }

    public void selectTab(int n, boolean bl, boolean bl2) {
        List list;
        if (this.mIsInSelectTab) {
            return;
        }
        this.mIsInSelectTab = true;
        TabAdapter tabAdapter = this.getAdapter();
        List list2 = list = tabAdapter.getViews();
        if (list.size() != tabAdapter.getSize()) {
            tabAdapter.setup();
            list2 = tabAdapter.getViews();
        }
        if (list2.size() != 0 && list2.size() > n) {
            if (this.mSelectAnimator == null && this.mViewPagerScrollState == 0) {
                int n2 = this.mCurrentSelectedIndex;
                if (n2 == n) {
                    if (bl2) {
                        this.dispatchTabReselected(n);
                    }
                    this.mIsInSelectTab = false;
                    this.mContentLayout.invalidate();
                    return;
                }
                if (n2 > list2.size()) {
                    Log.i((String)"QMUITabSegment", (String)"selectTab: current selected index is bigger than views size.");
                    this.mCurrentSelectedIndex = -1;
                }
                if ((n2 = this.mCurrentSelectedIndex) == -1) {
                    list = (Tab)tabAdapter.getItem(n);
                    this.layoutIndicator((Tab)list, true);
                    this.setTextViewTypeface(((TabItemView)list2.get(n)).getTextView(), true);
                    ((TabItemView)list2.get(n)).updateDecoration((Tab)list, true);
                    this.dispatchTabSelected(n);
                    this.mCurrentSelectedIndex = n;
                    this.mIsInSelectTab = false;
                    return;
                }
                list = (Tab)tabAdapter.getItem(n2);
                TabItemView tabItemView = (TabItemView)list2.get(n2);
                tabAdapter = (Tab)tabAdapter.getItem(n);
                TabItemView tabItemView2 = (TabItemView)list2.get(n);
                if (!bl) {
                    list2 = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
                    list2.setInterpolator((TimeInterpolator)QMUIInterpolatorStaticHolder.LINEAR_INTERPOLATOR);
                    list2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
                    list2.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
                    list2.setDuration(200L);
                    list2.start();
                    return;
                }
                this.dispatchTabUnselected(n2);
                this.dispatchTabSelected(n);
                this.setTextViewTypeface(tabItemView.getTextView(), false);
                this.setTextViewTypeface(tabItemView2.getTextView(), true);
                tabItemView.updateDecoration((Tab)list, false);
                tabItemView2.updateDecoration((Tab)tabAdapter, true);
                if (this.getScrollX() > tabItemView2.getLeft()) {
                    this.smoothScrollTo(tabItemView2.getLeft(), 0);
                } else {
                    n2 = this.getWidth() - this.getPaddingRight() - this.getPaddingLeft();
                    if (this.getScrollX() + n2 < tabItemView2.getRight()) {
                        this.smoothScrollBy(tabItemView2.getRight() - n2 - this.getScrollX(), 0);
                    }
                }
                this.mCurrentSelectedIndex = n;
                this.mIsInSelectTab = false;
                this.layoutIndicator((Tab)tabAdapter, true);
                return;
            }
            this.mPendingSelectedIndex = n;
            this.mIsInSelectTab = false;
            return;
        }
        this.mIsInSelectTab = false;
    }

    public void setDefaultNormalColor(int n) {
        this.mDefaultNormalColor = n;
    }

    public void setDefaultSelectedColor(int n) {
        this.mDefaultSelectedColor = n;
    }

    public void setDefaultTabIconPosition(int n) {
        this.mDefaultTabIconPosition = n;
    }

    public void setHasIndicator(boolean bl) {
        if (this.mHasIndicator == bl) return;
        this.mHasIndicator = bl;
        this.invalidate();
    }

    public void setIndicatorDrawable(Drawable drawable) {
        this.mIndicatorDrawable = drawable;
        if (drawable != null) {
            this.mIndicatorHeight = drawable.getIntrinsicHeight();
        }
        this.mContentLayout.invalidate();
    }

    public void setIndicatorPosition(boolean bl) {
        if (this.mIndicatorTop == bl) return;
        this.mIndicatorTop = bl;
        this.mContentLayout.invalidate();
    }

    public void setIndicatorWidthAdjustContent(boolean bl) {
        if (this.mIsIndicatorWidthFollowContent == bl) return;
        this.mIsIndicatorWidthFollowContent = bl;
        this.mContentLayout.requestLayout();
    }

    public void setItemSpaceInScrollMode(int n) {
        this.mItemSpaceInScrollMode = n;
    }

    public void setMode(int n) {
        if (this.mMode == n) return;
        this.mMode = n;
        this.mContentLayout.invalidate();
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.mOnTabClickListener = onTabClickListener;
    }

    void setPagerAdapter(PagerAdapter pagerAdapter, boolean bl, boolean bl2) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.mPagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.mPagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.mPagerAdapter = pagerAdapter;
        if (bl2 && pagerAdapter != null) {
            if (this.mPagerAdapterObserver == null) {
                this.mPagerAdapterObserver = new PagerAdapterObserver(this, bl);
            }
            pagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
        }
        this.populateFromPagerAdapter(bl);
    }

    public void setTabTextSize(int n) {
        this.mTabTextSize = n;
    }

    public void setTypefaceProvider(TypefaceProvider typefaceProvider) {
        this.mTypefaceProvider = typefaceProvider;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        this.setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean bl) {
        this.setupWithViewPager(viewPager, bl, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean bl, boolean bl2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            onPageChangeListener = this.mOnPageChangeListener;
            if (onPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(onPageChangeListener);
            }
            if ((onPageChangeListener = this.mAdapterChangeListener) != null) {
                this.mViewPager.removeOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)onPageChangeListener);
            }
        }
        if ((onPageChangeListener = this.mViewPagerSelectedListener) != null) {
            this.removeOnTabSelectedListener((OnTabSelectedListener)onPageChangeListener);
            this.mViewPagerSelectedListener = null;
        }
        if (viewPager != null) {
            this.mViewPager = viewPager;
            if (this.mOnPageChangeListener == null) {
                this.mOnPageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            viewPager.addOnPageChangeListener(this.mOnPageChangeListener);
            onPageChangeListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.mViewPagerSelectedListener = onPageChangeListener;
            this.addOnTabSelectedListener((OnTabSelectedListener)onPageChangeListener);
            onPageChangeListener = viewPager.getAdapter();
            if (onPageChangeListener != null) {
                this.setPagerAdapter((PagerAdapter)onPageChangeListener, bl, bl2);
            }
            if (this.mAdapterChangeListener == null) {
                this.mAdapterChangeListener = new AdapterChangeListener(this, bl);
            }
            this.mAdapterChangeListener.setAutoRefresh(bl2);
            viewPager.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)this.mAdapterChangeListener);
        } else {
            this.mViewPager = null;
            this.setPagerAdapter(null, false, false);
        }
    }

    public void showSignCountView(Context context, int n, int n2) {
        ((Tab)this.getAdapter().getItem(n)).showSignCountView(context, n2);
        this.notifyDataChanged();
    }

    public void updateIndicatorPosition(int n, float f) {
        int n2;
        if (this.mSelectAnimator != null) return;
        if (this.mIsInSelectTab) return;
        if (f == 0.0f) return;
        if (f < 0.0f) {
            n2 = n - 1;
            f = -f;
        } else {
            n2 = n + 1;
        }
        TabAdapter tabAdapter = this.getAdapter();
        List list = tabAdapter.getViews();
        if (list.size() <= n) return;
        if (list.size() <= n2) return;
        Tab tab = (Tab)tabAdapter.getItem(n);
        Tab tab2 = (Tab)tabAdapter.getItem(n2);
        tabAdapter = (TabItemView)list.get(n);
        list = (TabItemView)list.get(n2);
        n2 = QMUIColorHelper.computeColor((int)this.getTabSelectedColor(tab), (int)this.getTabNormalColor(tab), (float)f);
        n = QMUIColorHelper.computeColor((int)this.getTabNormalColor(tab2), (int)this.getTabSelectedColor(tab2), (float)f);
        tabAdapter.setColorInTransition(tab, n2);
        list.setColorInTransition(tab2, n);
        this.layoutIndicatorInTransition(tab, tab2, f);
    }

    public void updateTabText(int n, String string) {
        Tab tab = (Tab)this.getAdapter().getItem(n);
        if (tab == null) {
            return;
        }
        tab.setText((CharSequence)string);
        this.notifyDataChanged();
    }
}

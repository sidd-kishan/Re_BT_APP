/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.DataSetObserver
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils$TruncateAt
 *  android.text.method.TransformationMethod
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.core.widget.TextViewCompat
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.PagerTitleStrip$PageListener
 *  androidx.viewpager.widget.PagerTitleStrip$SingleLineAllCapsTransform
 *  androidx.viewpager.widget.ViewPager
 *  androidx.viewpager.widget.ViewPager$DecorView
 *  androidx.viewpager.widget.ViewPager$OnAdapterChangeListener
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

@ViewPager.DecorView
public class PagerTitleStrip
extends ViewGroup {
    private static final int[] ATTRS = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final float SIDE_ALPHA = 0.6f;
    private static final int[] TEXT_ATTRS = new int[]{16843660};
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage = -1;
    float mLastKnownPositionOffset = -1.0f;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PageListener mPageListener = new PageListener(this);
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference<PagerAdapter> mWatchingAdapter;

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n;
        TextView textView;
        this.mPrevText = textView = new TextView(context);
        this.addView((View)textView);
        this.mCurrText = textView = new TextView(context);
        this.addView((View)textView);
        this.mNextText = textView = new TextView(context);
        this.addView((View)textView);
        attributeSet = context.obtainStyledAttributes(attributeSet, ATTRS);
        boolean bl = false;
        int n2 = attributeSet.getResourceId(0, 0);
        if (n2 != 0) {
            TextViewCompat.setTextAppearance((TextView)this.mPrevText, (int)n2);
            TextViewCompat.setTextAppearance((TextView)this.mCurrText, (int)n2);
            TextViewCompat.setTextAppearance((TextView)this.mNextText, (int)n2);
        }
        if ((n = attributeSet.getDimensionPixelSize(1, 0)) != 0) {
            this.setTextSize(0, n);
        }
        if (attributeSet.hasValue(2)) {
            n = attributeSet.getColor(2, 0);
            this.mPrevText.setTextColor(n);
            this.mCurrText.setTextColor(n);
            this.mNextText.setTextColor(n);
        }
        this.mGravity = attributeSet.getInteger(3, 80);
        attributeSet.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        this.setNonPrimaryAlpha(0.6f);
        this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
        if (n2 != 0) {
            attributeSet = context.obtainStyledAttributes(n2, TEXT_ATTRS);
            bl = attributeSet.getBoolean(0, false);
            attributeSet.recycle();
        }
        if (bl) {
            PagerTitleStrip.setSingleLineAllCaps(this.mPrevText);
            PagerTitleStrip.setSingleLineAllCaps(this.mCurrText);
            PagerTitleStrip.setSingleLineAllCaps(this.mNextText);
        } else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            this.mNextText.setSingleLine();
        }
        this.mScaledTextSpacing = (int)(context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod((TransformationMethod)new SingleLineAllCapsTransform(textView.getContext()));
    }

    int getMinHeight() {
        Drawable drawable = this.getBackground();
        int n = drawable != null ? drawable.getIntrinsicHeight() : 0;
        return n;
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object object = this.getParent();
        if (!(object instanceof ViewPager)) throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        object = (ViewPager)object;
        PagerAdapter pagerAdapter = object.getAdapter();
        object.setInternalPageChangeListener((ViewPager.OnPageChangeListener)this.mPageListener);
        object.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)this.mPageListener);
        this.mPager = object;
        object = this.mWatchingAdapter;
        object = object != null ? (PagerAdapter)((Reference)object).get() : null;
        this.updateAdapter((PagerAdapter)object, pagerAdapter);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.mPager;
        if (viewPager == null) return;
        this.updateAdapter(viewPager.getAdapter(), null);
        this.mPager.setInternalPageChangeListener(null);
        this.mPager.removeOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)this.mPageListener);
        this.mPager = null;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        if (this.mPager == null) return;
        float f = this.mLastKnownPositionOffset;
        if (!(f >= 0.0f)) {
            f = 0.0f;
        }
        this.updateTextPositions(this.mLastKnownCurrentPage, f, true);
    }

    protected void onMeasure(int n, int n2) {
        if (View.MeasureSpec.getMode((int)n) != 0x40000000) throw new IllegalStateException("Must measure with an exact width");
        int n3 = this.getPaddingTop() + this.getPaddingBottom();
        int n4 = PagerTitleStrip.getChildMeasureSpec((int)n2, (int)n3, (int)-2);
        int n5 = View.MeasureSpec.getSize((int)n);
        n = PagerTitleStrip.getChildMeasureSpec((int)n, (int)((int)((float)n5 * 0.2f)), (int)-2);
        this.mPrevText.measure(n, n4);
        this.mCurrText.measure(n, n4);
        this.mNextText.measure(n, n4);
        if (View.MeasureSpec.getMode((int)n2) == 0x40000000) {
            n = View.MeasureSpec.getSize((int)n2);
        } else {
            n = this.mCurrText.getMeasuredHeight();
            n = Math.max(this.getMinHeight(), n + n3);
        }
        this.setMeasuredDimension(n5, View.resolveSizeAndState((int)n, (int)n2, (int)(this.mCurrText.getMeasuredState() << 16)));
    }

    public void requestLayout() {
        if (this.mUpdatingText) return;
        super.requestLayout();
    }

    public void setGravity(int n) {
        this.mGravity = n;
        this.requestLayout();
    }

    public void setNonPrimaryAlpha(float f) {
        int n;
        this.mNonPrimaryAlpha = n = (int)(f * 255.0f) & 0xFF;
        n = n << 24 | this.mTextColor & 0xFFFFFF;
        this.mPrevText.setTextColor(n);
        this.mNextText.setTextColor(n);
    }

    public void setTextColor(int n) {
        this.mTextColor = n;
        this.mCurrText.setTextColor(n);
        n = this.mNonPrimaryAlpha << 24 | this.mTextColor & 0xFFFFFF;
        this.mPrevText.setTextColor(n);
        this.mNextText.setTextColor(n);
    }

    public void setTextSize(int n, float f) {
        this.mPrevText.setTextSize(n, f);
        this.mCurrText.setTextSize(n, f);
        this.mNextText.setTextSize(n, f);
    }

    public void setTextSpacing(int n) {
        this.mScaledTextSpacing = n;
        this.requestLayout();
    }

    void updateAdapter(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver((DataSetObserver)this.mPageListener);
            this.mWatchingAdapter = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver((DataSetObserver)this.mPageListener);
            this.mWatchingAdapter = new WeakReference<PagerAdapter>(pagerAdapter2);
        }
        if ((pagerAdapter = this.mPager) == null) return;
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.updateText(pagerAdapter.getCurrentItem(), pagerAdapter2);
        this.requestLayout();
    }

    void updateText(int n, PagerAdapter pagerAdapter) {
        int n2 = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.mUpdatingText = true;
        Object var6_4 = null;
        CharSequence charSequence = n >= 1 && pagerAdapter != null ? pagerAdapter.getPageTitle(n - 1) : null;
        this.mPrevText.setText(charSequence);
        TextView textView = this.mCurrText;
        charSequence = pagerAdapter != null && n < n2 ? pagerAdapter.getPageTitle(n) : null;
        textView.setText(charSequence);
        int n3 = n + 1;
        charSequence = var6_4;
        if (n3 < n2) {
            charSequence = var6_4;
            if (pagerAdapter != null) {
                charSequence = pagerAdapter.getPageTitle(n3);
            }
        }
        this.mNextText.setText(charSequence);
        n2 = View.MeasureSpec.makeMeasureSpec((int)Math.max(0, (int)((float)(this.getWidth() - this.getPaddingLeft() - this.getPaddingRight()) * 0.8f)), (int)Integer.MIN_VALUE);
        n3 = View.MeasureSpec.makeMeasureSpec((int)Math.max(0, this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()), (int)Integer.MIN_VALUE);
        this.mPrevText.measure(n2, n3);
        this.mCurrText.measure(n2, n3);
        this.mNextText.measure(n2, n3);
        this.mLastKnownCurrentPage = n;
        if (!this.mUpdatingPositions) {
            this.updateTextPositions(n, this.mLastKnownPositionOffset, false);
        }
        this.mUpdatingText = false;
    }

    void updateTextPositions(int n, float f, boolean bl) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        block6: {
            int n11;
            int n12;
            block7: {
                int n13;
                int n14;
                block4: {
                    block5: {
                        float f2;
                        if (n != this.mLastKnownCurrentPage) {
                            this.updateText(n, this.mPager.getAdapter());
                        } else if (!bl && f == this.mLastKnownPositionOffset) {
                            return;
                        }
                        this.mUpdatingPositions = true;
                        n10 = this.mPrevText.getMeasuredWidth();
                        n9 = this.mCurrText.getMeasuredWidth();
                        n8 = this.mNextText.getMeasuredWidth();
                        n7 = n9 / 2;
                        n6 = this.getWidth();
                        n5 = this.getHeight();
                        n4 = this.getPaddingLeft();
                        n3 = this.getPaddingRight();
                        n = this.getPaddingTop();
                        n14 = this.getPaddingBottom();
                        n2 = n3 + n7;
                        float f3 = f2 = 0.5f + f;
                        if (f2 > 1.0f) {
                            f3 = f2 - 1.0f;
                        }
                        n2 = n6 - n2 - (int)((float)(n6 - (n4 + n7) - n2) * f3) - n7;
                        n7 = n9 + n2;
                        n12 = this.mPrevText.getBaseline();
                        n9 = this.mCurrText.getBaseline();
                        n11 = this.mNextText.getBaseline();
                        int n15 = Math.max(Math.max(n12, n9), n11);
                        n12 = n15 - n12;
                        n9 = n15 - n9;
                        n11 = n15 - n11;
                        int n16 = this.mPrevText.getMeasuredHeight();
                        n13 = this.mCurrText.getMeasuredHeight();
                        n15 = this.mNextText.getMeasuredHeight();
                        n13 = Math.max(Math.max(n16 + n12, n13 + n9), n15 + n11);
                        n15 = this.mGravity & 0x70;
                        if (n15 == 16) break block4;
                        if (n15 == 80) break block5;
                        n5 = n12 + n;
                        n9 += n;
                        n += n11;
                        break block6;
                    }
                    n = n5 - n14 - n13;
                    break block7;
                }
                n = (n5 - n - n14 - n13) / 2;
            }
            n5 = n12 + n;
            n9 += n;
            n += n11;
        }
        TextView textView = this.mCurrText;
        textView.layout(n2, n9, n7, textView.getMeasuredHeight() + n9);
        n9 = Math.min(n4, n2 - this.mScaledTextSpacing - n10);
        textView = this.mPrevText;
        textView.layout(n9, n5, n10 + n9, textView.getMeasuredHeight() + n5);
        n5 = Math.max(n6 - n3 - n8, n7 + this.mScaledTextSpacing);
        textView = this.mNextText;
        textView.layout(n5, n, n5 + n8, textView.getMeasuredHeight() + n);
        this.mLastKnownPositionOffset = f;
        this.mUpdatingPositions = false;
    }
}

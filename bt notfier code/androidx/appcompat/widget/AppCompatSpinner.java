/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$Theme
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.ArrayAdapter
 *  android.widget.ListAdapter
 *  android.widget.Spinner
 *  android.widget.SpinnerAdapter
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$layout
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.view.ContextThemeWrapper
 *  androidx.appcompat.widget.AppCompatBackgroundHelper
 *  androidx.appcompat.widget.AppCompatSpinner$DialogPopup
 *  androidx.appcompat.widget.AppCompatSpinner$DropDownAdapter
 *  androidx.appcompat.widget.AppCompatSpinner$DropdownPopup
 *  androidx.appcompat.widget.AppCompatSpinner$SavedState
 *  androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
 *  androidx.appcompat.widget.ForwardingListener
 *  androidx.appcompat.widget.ThemeUtils
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.view.TintableBackgroundView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.TintableBackgroundView;

public class AppCompatSpinner
extends Spinner
implements TintableBackgroundView {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = new int[]{16843505};
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private SpinnerPopup mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    public AppCompatSpinner(Context context, int n) {
        this(context, null, R.attr.spinnerStyle, n);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int n) {
        this(context, attributeSet, n, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int n, int n2) {
        this(context, attributeSet, n, n2, null);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public AppCompatSpinner(Context context, AttributeSet dropdownPopup, int n, int n2, Resources.Theme dropdownPopup2) {
        int n3;
        DropdownPopup dropdownPopup3;
        TintTypedArray tintTypedArray;
        block15: {
            int n4;
            super(context, (AttributeSet)dropdownPopup, n);
            this.mTempRect = new Rect();
            ThemeUtils.checkAppCompatTheme((View)this, (Context)this.getContext());
            tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)context, (AttributeSet)dropdownPopup, (int[])R.styleable.Spinner, (int)n, (int)0);
            this.mBackgroundTintHelper = new AppCompatBackgroundHelper((View)this);
            this.mPopupContext = dropdownPopup2 != null ? new ContextThemeWrapper(context, (Resources.Theme)dropdownPopup2) : ((n4 = tintTypedArray.getResourceId(R.styleable.Spinner_popupTheme, 0)) != 0 ? new ContextThemeWrapper(context, n4) : context);
            dropdownPopup3 = null;
            n3 = n2;
            if (n2 == -1) {
                void var1_4;
                block18: {
                    block16: {
                        block17: {
                            dropdownPopup2 = context.obtainStyledAttributes((AttributeSet)dropdownPopup, ATTRS_ANDROID_SPINNERMODE, n, 0);
                            n4 = n2;
                            dropdownPopup3 = dropdownPopup2;
                            try {
                                if (dropdownPopup2.hasValue(0)) {
                                    dropdownPopup3 = dropdownPopup2;
                                    n4 = dropdownPopup2.getInt(0, 0);
                                }
                                n3 = n4;
                                if (dropdownPopup2 == null) break block15;
                                n2 = n4;
                                break block16;
                            }
                            catch (Exception exception) {
                                break block17;
                            }
                            catch (Throwable throwable) {
                                dropdownPopup = dropdownPopup3;
                                break block18;
                            }
                            catch (Exception exception) {
                                dropdownPopup2 = null;
                            }
                        }
                        dropdownPopup3 = dropdownPopup2;
                        try {
                            void var9_15;
                            Log.i((String)TAG, (String)"Could not read android:spinnerMode", (Throwable)var9_15);
                            n3 = n2;
                            if (dropdownPopup2 == null) break block15;
                        }
                        catch (Throwable throwable) {
                            dropdownPopup = dropdownPopup3;
                        }
                    }
                    dropdownPopup2.recycle();
                    n3 = n2;
                    {
                        break block15;
                    }
                }
                if (dropdownPopup == null) throw var1_4;
                dropdownPopup.recycle();
                throw var1_4;
            }
        }
        if (n3 != 0) {
            if (n3 == 1) {
                dropdownPopup2 = new DropdownPopup(this, this.mPopupContext, (AttributeSet)dropdownPopup, n);
                dropdownPopup3 = TintTypedArray.obtainStyledAttributes((Context)this.mPopupContext, (AttributeSet)dropdownPopup, (int[])R.styleable.Spinner, (int)n, (int)0);
                this.mDropDownWidth = dropdownPopup3.getLayoutDimension(R.styleable.Spinner_android_dropDownWidth, -2);
                dropdownPopup2.setBackgroundDrawable(dropdownPopup3.getDrawable(R.styleable.Spinner_android_popupBackground));
                dropdownPopup2.setPromptText((CharSequence)tintTypedArray.getString(R.styleable.Spinner_android_prompt));
                dropdownPopup3.recycle();
                this.mPopup = dropdownPopup2;
                this.mForwardingListener = new /* Unavailable Anonymous Inner Class!! */;
            }
        } else {
            this.mPopup = dropdownPopup2 = new DialogPopup(this);
            dropdownPopup2.setPromptText((CharSequence)tintTypedArray.getString(R.styleable.Spinner_android_prompt));
        }
        dropdownPopup2 = tintTypedArray.getTextArray(R.styleable.Spinner_android_entries);
        if (dropdownPopup2 != null) {
            context = new ArrayAdapter(context, 17367048, (Object[])dropdownPopup2);
            context.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            this.setAdapter((SpinnerAdapter)context);
        }
        tintTypedArray.recycle();
        this.mPopupSet = true;
        context = this.mTempAdapter;
        if (context != null) {
            this.setAdapter((SpinnerAdapter)context);
            this.mTempAdapter = null;
        }
        this.mBackgroundTintHelper.loadFromAttributes((AttributeSet)dropdownPopup, n);
    }

    int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int n = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int n2 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0);
        int n3 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)0);
        int n4 = Math.max(0, this.getSelectedItemPosition());
        int n5 = Math.min(spinnerAdapter.getCount(), n4 + 15);
        int n6 = Math.max(0, n4 - (15 - (n5 - n4)));
        View view = null;
        n4 = 0;
        while (true) {
            if (n6 >= n5) {
                n6 = n4;
                if (drawable == null) return n6;
                drawable.getPadding(this.mTempRect);
                n6 = n4 + (this.mTempRect.left + this.mTempRect.right);
                return n6;
            }
            int n7 = spinnerAdapter.getItemViewType(n6);
            int n8 = n;
            if (n7 != n) {
                view = null;
                n8 = n7;
            }
            if ((view = spinnerAdapter.getView(n6, view, (ViewGroup)this)).getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(n2, n3);
            n4 = Math.max(n4, view.getMeasuredWidth());
            ++n6;
            n = n8;
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper == null) return;
        appCompatBackgroundHelper.applySupportBackgroundTint();
    }

    public int getDropDownHorizontalOffset() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            return spinnerPopup.getHorizontalOffset();
        }
        if (Build.VERSION.SDK_INT < 16) return 0;
        return super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            return spinnerPopup.getVerticalOffset();
        }
        if (Build.VERSION.SDK_INT < 16) return 0;
        return super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        if (Build.VERSION.SDK_INT < 16) return 0;
        return super.getDropDownWidth();
    }

    final SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    public Drawable getPopupBackground() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            return spinnerPopup.getBackground();
        }
        if (Build.VERSION.SDK_INT < 16) return null;
        return super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public CharSequence getPrompt() {
        Object object = this.mPopup;
        object = object != null ? object.getHintText() : super.getPrompt();
        return object;
    }

    public ColorStateList getSupportBackgroundTintList() {
        Object object = this.mBackgroundTintHelper;
        object = object != null ? object.getSupportBackgroundTintList() : null;
        return object;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        Object object = this.mBackgroundTintHelper;
        object = object != null ? object.getSupportBackgroundTintMode() : null;
        return object;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup == null) return;
        if (!spinnerPopup.isShowing()) return;
        this.mPopup.dismiss();
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        if (this.mPopup == null) return;
        if (View.MeasureSpec.getMode((int)n) != Integer.MIN_VALUE) return;
        this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.compatMeasureContentWidth(this.getAdapter(), this.getBackground())), View.MeasureSpec.getSize((int)n)), this.getMeasuredHeight());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (!parcelable.mShowDropdown) return;
        parcelable = this.getViewTreeObserver();
        if (parcelable == null) return;
        parcelable.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SpinnerPopup spinnerPopup = this.mPopup;
        boolean bl = spinnerPopup != null && spinnerPopup.isShowing();
        savedState.mShowDropdown = bl;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener = this.mForwardingListener;
        if (forwardingListener == null) return super.onTouchEvent(motionEvent);
        if (!forwardingListener.onTouch((View)this, motionEvent)) return super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean performClick() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup == null) return super.performClick();
        if (spinnerPopup.isShowing()) return true;
        this.showPopup();
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        Context context;
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mPopup == null) return;
        Context context2 = context = this.mPopupContext;
        if (context == null) {
            context2 = this.getContext();
        }
        this.mPopup.setAdapter((ListAdapter)new DropDownAdapter(spinnerAdapter, context2.getTheme()));
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper == null) return;
        appCompatBackgroundHelper.onSetBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(int n) {
        super.setBackgroundResource(n);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper == null) return;
        appCompatBackgroundHelper.onSetBackgroundResource(n);
    }

    public void setDropDownHorizontalOffset(int n) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setHorizontalOriginalOffset(n);
            this.mPopup.setHorizontalOffset(n);
        } else {
            if (Build.VERSION.SDK_INT < 16) return;
            super.setDropDownHorizontalOffset(n);
        }
    }

    public void setDropDownVerticalOffset(int n) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setVerticalOffset(n);
        } else {
            if (Build.VERSION.SDK_INT < 16) return;
            super.setDropDownVerticalOffset(n);
        }
    }

    public void setDropDownWidth(int n) {
        if (this.mPopup != null) {
            this.mDropDownWidth = n;
        } else {
            if (Build.VERSION.SDK_INT < 16) return;
            super.setDropDownWidth(n);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setBackgroundDrawable(drawable);
        } else {
            if (Build.VERSION.SDK_INT < 16) return;
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int n) {
        this.setPopupBackgroundDrawable(AppCompatResources.getDrawable((Context)this.getPopupContext(), (int)n));
    }

    public void setPrompt(CharSequence charSequence) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper == null) return;
        appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper == null) return;
        appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
    }

    void showPopup() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.mPopup.show(this.getTextDirection(), this.getTextAlignment());
        } else {
            this.mPopup.show(-1, -1);
        }
    }
}

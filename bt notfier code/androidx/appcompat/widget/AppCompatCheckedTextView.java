/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ActionMode$Callback
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.CheckedTextView
 *  android.widget.TextView
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.AppCompatHintHelper
 *  androidx.appcompat.widget.AppCompatTextHelper
 *  androidx.appcompat.widget.ThemeUtils
 *  androidx.appcompat.widget.TintContextWrapper
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.widget.TextViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.widget.TextViewCompat;

public class AppCompatCheckedTextView
extends CheckedTextView {
    private static final int[] TINT_ATTRS = new int[]{0x1010108};
    private final AppCompatTextHelper mTextHelper;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int n) {
        super(TintContextWrapper.wrap((Context)context), attributeSet, n);
        ThemeUtils.checkAppCompatTheme((View)this, (Context)this.getContext());
        context = new AppCompatTextHelper((TextView)this);
        this.mTextHelper = context;
        context.loadFromAttributes(attributeSet, n);
        this.mTextHelper.applyCompoundDrawablesTints();
        context = TintTypedArray.obtainStyledAttributes((Context)this.getContext(), (AttributeSet)attributeSet, (int[])TINT_ATTRS, (int)n, (int)0);
        this.setCheckMarkDrawable(context.getDrawable(0));
        context.recycle();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null) return;
        appCompatTextHelper.applyCompoundDrawablesTints();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.onCreateInputConnection((InputConnection)super.onCreateInputConnection(editorInfo), (EditorInfo)editorInfo, (View)this);
    }

    public void setCheckMarkDrawable(int n) {
        this.setCheckMarkDrawable(AppCompatResources.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, (ActionMode.Callback)callback));
    }

    public void setTextAppearance(Context context, int n) {
        super.setTextAppearance(context, n);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null) return;
        appCompatTextHelper.onSetTextAppearance(context, n);
    }
}

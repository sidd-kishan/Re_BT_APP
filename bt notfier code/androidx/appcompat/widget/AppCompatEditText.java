/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.text.Editable
 *  android.view.ActionMode$Callback
 *  android.view.DragEvent
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.textclassifier.TextClassifier
 *  android.widget.EditText
 *  android.widget.TextView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.widget.AppCompatBackgroundHelper
 *  androidx.appcompat.widget.AppCompatHintHelper
 *  androidx.appcompat.widget.AppCompatReceiveContentHelper
 *  androidx.appcompat.widget.AppCompatTextClassifierHelper
 *  androidx.appcompat.widget.AppCompatTextHelper
 *  androidx.appcompat.widget.ThemeUtils
 *  androidx.appcompat.widget.TintContextWrapper
 *  androidx.core.view.ContentInfoCompat
 *  androidx.core.view.OnReceiveContentViewBehavior
 *  androidx.core.view.TintableBackgroundView
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.inputmethod.EditorInfoCompat
 *  androidx.core.view.inputmethod.InputConnectionCompat
 *  androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener
 *  androidx.core.widget.TextViewCompat
 *  androidx.core.widget.TextViewOnReceiveContentListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.AppCompatReceiveContentHelper;
import androidx.appcompat.widget.AppCompatTextClassifierHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;

public class AppCompatEditText
extends EditText
implements TintableBackgroundView,
OnReceiveContentViewBehavior {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int n) {
        super(TintContextWrapper.wrap((Context)context), attributeSet, n);
        ThemeUtils.checkAppCompatTheme((View)this, (Context)this.getContext());
        context = new AppCompatBackgroundHelper((View)this);
        this.mBackgroundTintHelper = context;
        context.loadFromAttributes(attributeSet, n);
        context = new AppCompatTextHelper((TextView)this);
        this.mTextHelper = context;
        context.loadFromAttributes(attributeSet, n);
        this.mTextHelper.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper((TextView)this);
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
        if ((appCompatBackgroundHelper = this.mTextHelper) == null) return;
        appCompatBackgroundHelper.applyCompoundDrawablesTints();
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

    public Editable getText() {
        if (Build.VERSION.SDK_INT < 28) return super.getEditableText();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        if (Build.VERSION.SDK_INT >= 28) return super.getTextClassifier();
        AppCompatTextClassifierHelper appCompatTextClassifierHelper = this.mTextClassifierHelper;
        if (appCompatTextClassifierHelper != null) return appCompatTextClassifierHelper.getTextClassifier();
        return super.getTextClassifier();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.populateSurroundingTextIfNeeded((TextView)this, inputConnection, editorInfo);
        InputConnection inputConnection2 = AppCompatHintHelper.onCreateInputConnection((InputConnection)inputConnection, (EditorInfo)editorInfo, (View)this);
        String[] stringArray = ViewCompat.getOnReceiveContentMimeTypes((View)this);
        inputConnection = inputConnection2;
        if (inputConnection2 == null) return inputConnection;
        inputConnection = inputConnection2;
        if (stringArray == null) return inputConnection;
        EditorInfoCompat.setContentMimeTypes((EditorInfo)editorInfo, (String[])stringArray);
        inputConnection = InputConnectionCompat.createWrapper((InputConnection)inputConnection2, (EditorInfo)editorInfo, (InputConnectionCompat.OnCommitContentListener)AppCompatReceiveContentHelper.createOnCommitContentListener((View)this));
        return inputConnection;
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        if (!AppCompatReceiveContentHelper.maybeHandleDragEventViaPerformReceiveContent((View)this, (DragEvent)dragEvent)) return super.onDragEvent(dragEvent);
        return true;
    }

    public ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent((View)this, contentInfoCompat);
    }

    public boolean onTextContextMenuItem(int n) {
        if (!AppCompatReceiveContentHelper.maybeHandleMenuActionViaPerformReceiveContent((TextView)this, (int)n)) return super.onTextContextMenuItem(n);
        return true;
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

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, (ActionMode.Callback)callback));
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

    public void setTextAppearance(Context context, int n) {
        super.setTextAppearance(context, n);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null) return;
        appCompatTextHelper.onSetTextAppearance(context, n);
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT < 28 && (appCompatTextClassifierHelper = this.mTextClassifierHelper) != null) {
            appCompatTextClassifierHelper.setTextClassifier(textClassifier);
            return;
        }
        super.setTextClassifier(textClassifier);
    }
}

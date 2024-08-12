/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.KeyEvent
 *  android.view.KeyEvent$DispatcherState
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.AutoCompleteTextView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.widget.AppCompatAutoCompleteTextView
 *  androidx.appcompat.widget.SearchView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.SearchView;

/*
 * Exception performing whole class analysis ignored.
 */
public static class SearchView.SearchAutoComplete
extends AppCompatAutoCompleteTextView {
    private boolean mHasPendingShowSoftInputRequest;
    final Runnable mRunShowSoftInputIfNecessary = new /* Unavailable Anonymous Inner Class!! */;
    private SearchView mSearchView;
    private int mThreshold = this.getThreshold();

    public SearchView.SearchAutoComplete(Context context) {
        this(context, null);
    }

    public SearchView.SearchAutoComplete(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public SearchView.SearchAutoComplete(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    private int getSearchViewTextMinWidthDp() {
        Configuration configuration = this.getResources().getConfiguration();
        int n = configuration.screenWidthDp;
        int n2 = configuration.screenHeightDp;
        if (n >= 960 && n2 >= 720 && configuration.orientation == 2) {
            return 256;
        }
        if (n >= 600) return 192;
        if (n < 640) return 160;
        if (n2 < 480) return 160;
        return 192;
    }

    public boolean enoughToFilter() {
        boolean bl = this.mThreshold <= 0 || super.enoughToFilter();
        return bl;
    }

    void ensureImeVisible() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.setInputMethodMode(1);
            if (!this.enoughToFilter()) return;
            this.showDropDown();
        } else {
            SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER.ensureImeVisible((AutoCompleteTextView)this);
        }
    }

    boolean isEmpty() {
        boolean bl = TextUtils.getTrimmedLength((CharSequence)this.getText()) == 0;
        return bl;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo = super.onCreateInputConnection(editorInfo);
        if (!this.mHasPendingShowSoftInputRequest) return editorInfo;
        this.removeCallbacks(this.mRunShowSoftInputIfNecessary);
        this.post(this.mRunShowSoftInputIfNecessary);
        return editorInfo;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        this.setMinWidth((int)TypedValue.applyDimension((int)1, (float)this.getSearchViewTextMinWidthDp(), (DisplayMetrics)displayMetrics));
    }

    protected void onFocusChanged(boolean bl, int n, Rect rect) {
        super.onFocusChanged(bl, n, rect);
        this.mSearchView.onTextFocusChanged();
    }

    public boolean onKeyPreIme(int n, KeyEvent keyEvent) {
        if (n != 4) return super.onKeyPreIme(n, keyEvent);
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState dispatcherState = this.getKeyDispatcherState();
            if (dispatcherState == null) return true;
            dispatcherState.startTracking(keyEvent, (Object)this);
            return true;
        }
        if (keyEvent.getAction() != 1) return super.onKeyPreIme(n, keyEvent);
        KeyEvent.DispatcherState dispatcherState = this.getKeyDispatcherState();
        if (dispatcherState != null) {
            dispatcherState.handleUpEvent(keyEvent);
        }
        if (!keyEvent.isTracking()) return super.onKeyPreIme(n, keyEvent);
        if (keyEvent.isCanceled()) return super.onKeyPreIme(n, keyEvent);
        this.mSearchView.clearFocus();
        this.setImeVisibility(false);
        return true;
    }

    public void onWindowFocusChanged(boolean bl) {
        super.onWindowFocusChanged(bl);
        if (!bl) return;
        if (!this.mSearchView.hasFocus()) return;
        if (this.getVisibility() != 0) return;
        this.mHasPendingShowSoftInputRequest = true;
        if (!SearchView.isLandscapeMode((Context)this.getContext())) return;
        this.ensureImeVisible();
    }

    public void performCompletion() {
    }

    protected void replaceText(CharSequence charSequence) {
    }

    void setImeVisibility(boolean bl) {
        InputMethodManager inputMethodManager = (InputMethodManager)this.getContext().getSystemService("input_method");
        if (!bl) {
            this.mHasPendingShowSoftInputRequest = false;
            this.removeCallbacks(this.mRunShowSoftInputIfNecessary);
            inputMethodManager.hideSoftInputFromWindow(this.getWindowToken(), 0);
            return;
        }
        if (inputMethodManager.isActive((View)this)) {
            this.mHasPendingShowSoftInputRequest = false;
            this.removeCallbacks(this.mRunShowSoftInputIfNecessary);
            inputMethodManager.showSoftInput((View)this, 0);
            return;
        }
        this.mHasPendingShowSoftInputRequest = true;
    }

    void setSearchView(SearchView searchView) {
        this.mSearchView = searchView;
    }

    public void setThreshold(int n) {
        super.setThreshold(n);
        this.mThreshold = n;
    }

    void showSoftInputIfNecessary() {
        if (!this.mHasPendingShowSoftInputRequest) return;
        ((InputMethodManager)this.getContext().getSystemService("input_method")).showSoftInput((View)this, 0);
        this.mHasPendingShowSoftInputRequest = false;
    }
}

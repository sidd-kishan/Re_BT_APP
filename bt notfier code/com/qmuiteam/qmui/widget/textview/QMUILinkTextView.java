/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Message
 *  android.os.SystemClock
 *  android.text.Spannable
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.ViewConfiguration
 *  android.widget.TextView$BufferType
 *  androidx.core.content.ContextCompat
 *  com.qmuiteam.qmui.R$color
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.alpha.QMUIAlphaTextView
 *  com.qmuiteam.qmui.link.QMUILinkTouchMovementMethod
 *  com.qmuiteam.qmui.link.QMUILinkify
 *  com.qmuiteam.qmui.span.QMUIOnSpanClickListener
 *  com.qmuiteam.qmui.widget.textview.ISpanTouchFix
 *  com.qmuiteam.qmui.widget.textview.QMUILinkTextView$OnLinkClickListener
 *  com.qmuiteam.qmui.widget.textview.QMUILinkTextView$OnLinkLongClickListener
 */
package com.qmuiteam.qmui.widget.textview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaTextView;
import com.qmuiteam.qmui.link.QMUILinkTouchMovementMethod;
import com.qmuiteam.qmui.link.QMUILinkify;
import com.qmuiteam.qmui.span.QMUIOnSpanClickListener;
import com.qmuiteam.qmui.widget.textview.ISpanTouchFix;
import com.qmuiteam.qmui.widget.textview.QMUILinkTextView;
import java.util.HashSet;
import java.util.Set;

public class QMUILinkTextView
extends QMUIAlphaTextView
implements QMUIOnSpanClickListener,
ISpanTouchFix {
    public static int AUTO_LINK_MASK_REQUIRED = 7;
    private static Set<String> AUTO_LINK_SCHEME_INTERRUPTED;
    private static final long DOUBLE_TAP_TIMEOUT;
    private static final int MSG_CHECK_DOUBLE_TAP_TIMEOUT = 1000;
    private static final String TAG = "LinkTextView";
    private static final long TAP_TIMEOUT = 200L;
    private int mAutoLinkMaskCompat;
    private long mDownMillis = 0L;
    private ColorStateList mLinkBgColor;
    private ColorStateList mLinkTextColor;
    private boolean mNeedForceEventToParent = false;
    private OnLinkClickListener mOnLinkClickListener;
    private OnLinkLongClickListener mOnLinkLongClickListener;
    private CharSequence mOriginText = null;
    private Handler mSingleTapConfirmedHandler = new /* Unavailable Anonymous Inner Class!! */;
    private boolean mTouchSpanHit;

    static {
        HashSet<String> hashSet = new HashSet<String>();
        AUTO_LINK_SCHEME_INTERRUPTED = hashSet;
        hashSet.add("tel");
        AUTO_LINK_SCHEME_INTERRUPTED.add("mailto");
        AUTO_LINK_SCHEME_INTERRUPTED.add("http");
        AUTO_LINK_SCHEME_INTERRUPTED.add("https");
        DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    }

    public QMUILinkTextView(Context context) {
        this(context, null);
        this.mLinkBgColor = null;
        this.mLinkTextColor = ContextCompat.getColorStateList((Context)context, (int)R.color.qmui_s_link_color);
    }

    public QMUILinkTextView(Context context, ColorStateList colorStateList, ColorStateList colorStateList2) {
        this(context, null);
        this.mLinkBgColor = colorStateList2;
        this.mLinkTextColor = colorStateList;
    }

    public QMUILinkTextView(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        this.mAutoLinkMaskCompat = this.getAutoLinkMask() | AUTO_LINK_MASK_REQUIRED;
        this.setAutoLinkMask(0);
        this.setMovementMethod(QMUILinkTouchMovementMethod.getInstance());
        this.setHighlightColor(0);
        object = object.obtainStyledAttributes(attributeSet, R.styleable.QMUILinkTextView);
        this.mLinkBgColor = object.getColorStateList(R.styleable.QMUILinkTextView_qmui_linkBackgroundColor);
        this.mLinkTextColor = object.getColorStateList(R.styleable.QMUILinkTextView_qmui_linkTextColor);
        object.recycle();
        object = this.mOriginText;
        if (object != null) {
            this.setText((CharSequence)object);
        }
        this.setChangeAlphaWhenPress(false);
    }

    static /* synthetic */ OnLinkClickListener access$000(QMUILinkTextView qMUILinkTextView) {
        return qMUILinkTextView.mOnLinkClickListener;
    }

    private void disallowOnSpanClickInterrupt() {
        this.mSingleTapConfirmedHandler.removeMessages(1000);
        this.mDownMillis = 0L;
    }

    public void addAutoLinkMaskCompat(int n) {
        this.mAutoLinkMaskCompat = n | this.mAutoLinkMaskCompat;
    }

    public int getAutoLinkMaskCompat() {
        return this.mAutoLinkMaskCompat;
    }

    public boolean onSpanClick(String charSequence) {
        if (charSequence == null) {
            Log.w((String)TAG, (String)"onSpanClick interrupt null text");
            return true;
        }
        long l = SystemClock.uptimeMillis() - this.mDownMillis;
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append("onSpanClick clickUpTime: ");
        charSequence2.append(l);
        Log.w((String)TAG, (String)charSequence2.toString());
        if (this.mSingleTapConfirmedHandler.hasMessages(1000)) {
            this.disallowOnSpanClickInterrupt();
            return true;
        }
        if (200L < l) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("onSpanClick interrupted because of TAP_TIMEOUT: ");
            ((StringBuilder)charSequence).append(l);
            Log.w((String)TAG, (String)((StringBuilder)charSequence).toString());
            return true;
        }
        String string = Uri.parse((String)charSequence).getScheme();
        charSequence2 = string;
        if (string != null) {
            charSequence2 = string.toLowerCase();
        }
        if (!AUTO_LINK_SCHEME_INTERRUPTED.contains(charSequence2)) return false;
        long l2 = DOUBLE_TAP_TIMEOUT;
        this.mSingleTapConfirmedHandler.removeMessages(1000);
        charSequence2 = Message.obtain();
        ((Message)charSequence2).what = 1000;
        ((Message)charSequence2).obj = charSequence;
        this.mSingleTapConfirmedHandler.sendMessageDelayed((Message)charSequence2, l2 - l);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl;
        if ((motionEvent.getAction() & 0xFF) == 0) {
            bl = this.mSingleTapConfirmedHandler.hasMessages(1000);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onTouchEvent hasSingleTap: ");
            stringBuilder.append(bl);
            Log.w((String)TAG, (String)stringBuilder.toString());
            if (!bl) {
                this.mDownMillis = SystemClock.uptimeMillis();
            } else {
                Log.w((String)TAG, (String)"onTouchEvent disallow onSpanClick mSingleTapConfirmedHandler because of DOUBLE TAP");
                this.disallowOnSpanClickInterrupt();
            }
        }
        bl = super.onTouchEvent(motionEvent);
        if (!this.mNeedForceEventToParent) return bl;
        bl = this.mTouchSpanHit;
        return bl;
    }

    public boolean performClick() {
        if (this.mTouchSpanHit) return false;
        if (this.mNeedForceEventToParent) return false;
        return super.performClick();
    }

    public boolean performLongClick() {
        int n = this.getSelectionEnd();
        if (n <= 0) return super.performLongClick();
        boolean bl = this.performSpanLongClick(this.getText().subSequence(this.getSelectionStart(), n).toString()) || super.performLongClick();
        return bl;
    }

    protected boolean performSpanLongClick(String string) {
        OnLinkLongClickListener onLinkLongClickListener = this.mOnLinkLongClickListener;
        if (onLinkLongClickListener == null) return false;
        onLinkLongClickListener.onLongClick(string);
        return true;
    }

    public void removeAutoLinkMaskCompat(int n) {
        this.mAutoLinkMaskCompat = ~n & this.mAutoLinkMaskCompat;
    }

    public void setAutoLinkMaskCompat(int n) {
        this.mAutoLinkMaskCompat = n;
    }

    public void setLinkColor(ColorStateList colorStateList) {
        this.mLinkTextColor = colorStateList;
    }

    public void setNeedForceEventToParent(boolean bl) {
        if (this.mNeedForceEventToParent == bl) return;
        this.mNeedForceEventToParent = bl;
        CharSequence charSequence = this.mOriginText;
        if (charSequence == null) return;
        this.setText(charSequence);
    }

    public void setOnLinkClickListener(OnLinkClickListener onLinkClickListener) {
        this.mOnLinkClickListener = onLinkClickListener;
    }

    public void setOnLinkLongClickListener(OnLinkLongClickListener onLinkLongClickListener) {
        this.mOnLinkLongClickListener = onLinkLongClickListener;
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.mOriginText = charSequence;
        CharSequence charSequence2 = charSequence;
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            charSequence2 = new SpannableStringBuilder(charSequence);
            QMUILinkify.addLinks((Spannable)charSequence2, (int)this.mAutoLinkMaskCompat, (ColorStateList)this.mLinkTextColor, (ColorStateList)this.mLinkBgColor, (QMUIOnSpanClickListener)this);
        }
        super.setText(charSequence2, bufferType);
        if (!this.mNeedForceEventToParent) return;
        if (!this.getLinksClickable()) return;
        this.setFocusable(false);
        this.setClickable(false);
        this.setLongClickable(false);
    }

    public void setTouchSpanHit(boolean bl) {
        if (this.mTouchSpanHit == bl) return;
        this.mTouchSpanHit = bl;
    }
}

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.text.TextPaint
 *  android.text.TextUtils$TruncateAt
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  androidx.core.content.ContextCompat
 *  com.qmuiteam.qmui.QMUILog
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.link.ITouchableSpan
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler$Element
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler$ElementList
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler$ElementType
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceView$PressCancelAction
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceView$QQFaceViewListener
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceView$SpanInfo
 *  com.qmuiteam.qmui.span.QMUITouchableSpan
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUILangHelper
 */
package com.qmuiteam.qmui.qqface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.QMUILog;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.link.ITouchableSpan;
import com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import com.qmuiteam.qmui.span.QMUITouchableSpan;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QMUIQQFaceView
extends View {
    private static final String TAG = "QMUIQQFaceView";
    private static final String mEllipsizeText = "...";
    private QMUIQQFaceCompiler mCompiler;
    private int mContentCalMaxWidth = 0;
    private int mCurrentCalLine = 0;
    private int mCurrentCalWidth = 0;
    private int mCurrentDrawBaseLine;
    private int mCurrentDrawLine;
    private QMUITouchableSpan mCurrentDrawSpan;
    private int mCurrentDrawUsedWidth;
    private Runnable mDelayTextSetter = null;
    private QMUIQQFaceCompiler.ElementList mElementList;
    private TextUtils.TruncateAt mEllipsize;
    private int mEllipsizeTextLength = 0;
    private int mFirstBaseLine;
    private int mFontHeight;
    private int mGravity = 0;
    private boolean mIncludePad = true;
    private boolean mIsExecutedMiddleEllipsize = false;
    private boolean mIsInDrawSpan = false;
    private boolean mIsNeedEllipsize = false;
    private boolean mIsSingleLine = false;
    private boolean mIsTouchDownInMoreText = false;
    private boolean mJumpHandleMeasureAndDraw = false;
    private int mLastCalContentWidth = 0;
    private int mLastCalLimitWidth = 0;
    private int mLastCalLines = 0;
    private int mLastNeedStopLineRecord = -1;
    private int mLineSpace = -1;
    private int mLines = 0;
    private QQFaceViewListener mListener;
    private int mMaxLine = Integer.MAX_VALUE;
    private int mMaxWidth;
    private int mMiddleEllipsizeWidthRecord = -1;
    private int mMoreActionColor;
    private String mMoreActionText;
    private int mMoreActionTextLength = 0;
    private Rect mMoreHitRect;
    private int mNeedDrawLine = 0;
    private boolean mNeedReCalculateLines = false;
    private boolean mOpenQQFace = true;
    private CharSequence mOriginText;
    private TextPaint mPaint;
    private int mParagraphShowCount = 0;
    private int mParagraphSpace = 0;
    private PressCancelAction mPendingPressCancelAction = null;
    private int mQQFaceSize = 0;
    private int mQQFaceSizeAddon = 0;
    private Paint mSpanBgPaint;
    private Set<SpanInfo> mSpanInfos = new HashSet<SpanInfo>();
    private int mSpecialDrawablePadding = 0;
    private int mTextColor;
    private int mTextSize;
    SpanInfo mTouchSpanInfo = null;
    private Typeface mTypeface = null;
    private boolean needReCalculateFontHeight = true;

    public QMUIQQFaceView(Context context) {
        this(context, null);
    }

    public QMUIQQFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIQQFaceStyle);
    }

    public QMUIQQFaceView(Context object, AttributeSet attributeSet, int n) {
        super(object, attributeSet, n);
        this.mMoreHitRect = new Rect();
        this.mEllipsize = TextUtils.TruncateAt.END;
        this.mMaxWidth = Integer.MAX_VALUE;
        attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUIQQFaceView, n, 0);
        this.mQQFaceSizeAddon = -QMUIDisplayHelper.dp2px((Context)object, (int)2);
        this.mTextSize = attributeSet.getDimensionPixelSize(R.styleable.QMUIQQFaceView_android_textSize, QMUIDisplayHelper.dp2px((Context)object, (int)14));
        this.mTextColor = attributeSet.getColor(R.styleable.QMUIQQFaceView_android_textColor, -16777216);
        this.mIsSingleLine = attributeSet.getBoolean(R.styleable.QMUIQQFaceView_android_singleLine, false);
        this.mMaxLine = attributeSet.getInt(R.styleable.QMUIQQFaceView_android_maxLines, this.mMaxLine);
        this.setLineSpace(attributeSet.getDimensionPixelOffset(R.styleable.QMUIQQFaceView_android_lineSpacingExtra, 0));
        n = attributeSet.getInt(R.styleable.QMUIQQFaceView_android_ellipsize, -1);
        if (n != 1) {
            if (n != 2) {
                if (n == 3) {
                    this.mEllipsize = TextUtils.TruncateAt.END;
                }
                this.mEllipsize = null;
            } else {
                this.mEllipsize = TextUtils.TruncateAt.MIDDLE;
            }
        } else {
            this.mEllipsize = TextUtils.TruncateAt.START;
        }
        this.mMaxWidth = attributeSet.getDimensionPixelSize(R.styleable.QMUIQQFaceView_android_maxWidth, this.mMaxWidth);
        this.mSpecialDrawablePadding = attributeSet.getDimensionPixelSize(R.styleable.QMUIQQFaceView_qmui_special_drawable_padding, 0);
        object = attributeSet.getString(R.styleable.QMUIQQFaceView_android_text);
        if (!QMUILangHelper.isNullOrEmpty((CharSequence)object)) {
            this.mDelayTextSetter = new /* Unavailable Anonymous Inner Class!! */;
        }
        this.mMoreActionText = attributeSet.getString(R.styleable.QMUIQQFaceView_qmui_more_action_text);
        this.mMoreActionColor = attributeSet.getColor(R.styleable.QMUIQQFaceView_qmui_more_action_color, this.mTextColor);
        attributeSet.recycle();
        object = new TextPaint();
        this.mPaint = object;
        object.setAntiAlias(true);
        this.mPaint.setTextSize((float)this.mTextSize);
        this.mPaint.setColor(this.mTextColor);
        this.mEllipsizeTextLength = (int)Math.ceil(this.mPaint.measureText(mEllipsizeText));
        this.measureMoreActionTextLength();
        object = new Paint();
        this.mSpanBgPaint = object;
        object.setAntiAlias(true);
        this.mSpanBgPaint.setStyle(Paint.Style.FILL);
    }

    static /* synthetic */ PressCancelAction access$000(QMUIQQFaceView qMUIQQFaceView) {
        return qMUIQQFaceView.mPendingPressCancelAction;
    }

    static /* synthetic */ int access$100(QMUIQQFaceView qMUIQQFaceView) {
        return qMUIQQFaceView.mFontHeight;
    }

    static /* synthetic */ int access$200(QMUIQQFaceView qMUIQQFaceView) {
        return qMUIQQFaceView.mLineSpace;
    }

    private void calculateLinesInner(List<QMUIQQFaceCompiler.Element> list, int n) {
        int n2 = this.getPaddingLeft();
        int n3 = n - this.getPaddingRight();
        int n4 = 0;
        while (n4 < list.size()) {
            int n5;
            int n6;
            if (this.mJumpHandleMeasureAndDraw || this.mCurrentCalLine > this.mMaxLine && this.mEllipsize == TextUtils.TruncateAt.END && Build.VERSION.SDK_INT < 21) return;
            QMUIQQFaceCompiler.Element element = list.get(n4);
            if (element.getType() == QMUIQQFaceCompiler.ElementType.DRAWABLE) {
                n6 = this.mCurrentCalWidth;
                n5 = this.mQQFaceSize;
                if (n6 + n5 > n3) {
                    this.gotoCalNextLine(n2);
                    this.mCurrentCalWidth += this.mQQFaceSize;
                } else if (n6 + n5 == n3) {
                    this.gotoCalNextLine(n2);
                } else {
                    this.mCurrentCalWidth = n6 + n5;
                }
                if (n3 - n2 < this.mQQFaceSize) {
                    this.mJumpHandleMeasureAndDraw = true;
                }
            } else if (element.getType() == QMUIQQFaceCompiler.ElementType.TEXT) {
                this.measureText(element.getText(), n2, n3);
            } else if (element.getType() == QMUIQQFaceCompiler.ElementType.SPAN) {
                QMUIQQFaceCompiler.ElementList elementList = element.getChildList();
                element = element.getTouchableSpan();
                if (elementList != null && elementList.getElements().size() > 0) {
                    if (element == null) {
                        this.calculateLinesInner(elementList.getElements(), n);
                    } else {
                        element = new SpanInfo(this, (ITouchableSpan)element);
                        element.setStart(this.mCurrentCalLine, this.mCurrentCalWidth);
                        this.calculateLinesInner(elementList.getElements(), n);
                        element.setEnd(this.mCurrentCalLine, this.mCurrentCalWidth);
                        this.mSpanInfos.add((SpanInfo)element);
                    }
                }
            } else if (element.getType() == QMUIQQFaceCompiler.ElementType.NEXTLINE) {
                this.gotoCalNextLine(n2);
            } else if (element.getType() == QMUIQQFaceCompiler.ElementType.SPECIAL_BOUNDS_DRAWABLE) {
                n6 = element.getSpecialBoundsDrawable().getIntrinsicWidth();
                n5 = n4 != 0 && n4 != list.size() - 1 ? this.mSpecialDrawablePadding * 2 : this.mSpecialDrawablePadding;
                n6 += n5;
                n5 = this.mCurrentCalWidth;
                if (n5 + n6 > n3) {
                    this.gotoCalNextLine(n2);
                    this.mCurrentCalWidth += n6;
                } else if (n5 + n6 == n3) {
                    this.gotoCalNextLine(n2);
                } else {
                    this.mCurrentCalWidth = n5 + n6;
                }
                if (n3 - n2 < n6) {
                    this.mJumpHandleMeasureAndDraw = true;
                }
            }
            ++n4;
        }
    }

    private void calculateNeedDrawLine(int n) {
        int n2;
        this.mNeedDrawLine = n2 = this.mLines;
        boolean bl = this.mIsSingleLine;
        boolean bl2 = true;
        if (bl) {
            this.mNeedDrawLine = Math.min(1, n2);
        } else if (n < n2) {
            this.mNeedDrawLine = n;
        }
        if (this.mLines <= this.mNeedDrawLine) {
            bl2 = false;
        }
        this.mIsNeedEllipsize = bl2;
    }

    private void drawElements(Canvas canvas, List<QMUIQQFaceCompiler.Element> list, int n) {
        int n2 = this.getPaddingLeft();
        int n3 = n + n2;
        if (this.mIsNeedEllipsize && this.mEllipsize == TextUtils.TruncateAt.START) {
            canvas.drawText(mEllipsizeText, 0, 3, (float)n2, (float)this.mFirstBaseLine, (Paint)this.mPaint);
        }
        int n4 = 0;
        while (n4 < list.size()) {
            int n5;
            boolean bl;
            boolean bl2;
            int n6;
            Object object = list.get(n4);
            Object object2 = object.getType();
            if (object2 == QMUIQQFaceCompiler.ElementType.DRAWABLE) {
                n6 = object.getDrawableRes();
                bl2 = n4 == 0;
                bl = n4 == list.size() - 1;
                this.onDrawQQFace(canvas, n6, null, n2, n3, bl2, bl);
            } else if (object2 == QMUIQQFaceCompiler.ElementType.SPECIAL_BOUNDS_DRAWABLE) {
                object2 = object.getSpecialBoundsDrawable();
                bl2 = n4 == 0;
                bl = n4 == list.size() - 1;
                this.onDrawQQFace(canvas, 0, (Drawable)object2, n2, n3, bl2, bl);
            } else if (object2 == QMUIQQFaceCompiler.ElementType.TEXT) {
                object2 = object.getText();
                object = new float[object2.length()];
                this.mPaint.getTextWidths(object2.toString(), (float[])object);
                this.onDrawText(canvas, (CharSequence)object2, (float[])object, 0, n2, n3);
            } else if (object2 == QMUIQQFaceCompiler.ElementType.SPAN) {
                object2 = object.getChildList();
                this.mCurrentDrawSpan = object.getTouchableSpan();
                if (object2 != null && !object2.getElements().isEmpty()) {
                    object = this.mCurrentDrawSpan;
                    if (object == null) {
                        this.drawElements(canvas, object2.getElements(), n);
                    } else {
                        this.mIsInDrawSpan = true;
                        n6 = object.isPressed() ? this.mCurrentDrawSpan.getPressedTextColor() : this.mCurrentDrawSpan.getNormalTextColor();
                        object = this.mPaint;
                        n5 = n6;
                        if (n6 == 0) {
                            n5 = this.mTextColor;
                        }
                        object.setColor(n5);
                        this.drawElements(canvas, object2.getElements(), n);
                        this.mPaint.setColor(this.mTextColor);
                        this.mIsInDrawSpan = false;
                    }
                }
            } else if (object2 == QMUIQQFaceCompiler.ElementType.NEXTLINE) {
                n5 = this.mEllipsizeTextLength;
                n6 = this.mMoreActionTextLength;
                if (this.mIsNeedEllipsize && this.mEllipsize == TextUtils.TruncateAt.END && this.mCurrentDrawUsedWidth <= n3 - (n5 + n6) && this.mCurrentDrawLine == this.mNeedDrawLine) {
                    this.drawText(canvas, mEllipsizeText, 0, 3, this.mEllipsizeTextLength);
                    this.mCurrentDrawUsedWidth += this.mEllipsizeTextLength;
                    this.drawMoreActionText(canvas, n3);
                    return;
                }
                this.toNewDrawLine(n2, true, n);
            }
            ++n4;
        }
    }

    private void drawMoreActionText(Canvas canvas, int n) {
        if (QMUILangHelper.isNullOrEmpty((CharSequence)this.mMoreActionText)) return;
        this.mPaint.setColor(this.mMoreActionColor);
        int n2 = this.getPaddingTop();
        int n3 = this.mCurrentDrawLine;
        int n4 = n2;
        if (n3 > 1) {
            n4 = n2 + (n3 - 1) * (this.mFontHeight + this.mLineSpace);
        }
        this.mMoreHitRect.set(this.mCurrentDrawUsedWidth, n4, n, this.mFontHeight + n4);
        String string = this.mMoreActionText;
        canvas.drawText(string, 0, string.length(), (float)this.mCurrentDrawUsedWidth, (float)this.mCurrentDrawBaseLine, (Paint)this.mPaint);
        this.mPaint.setColor(this.mTextColor);
    }

    private void drawQQFace(Canvas canvas, int n, Drawable drawable, int n2, boolean bl, boolean bl2) {
        int n3;
        int n4;
        Drawable drawable2 = n != 0 ? ContextCompat.getDrawable((Context)this.getContext(), (int)n) : drawable;
        if (n == 0 && drawable != null) {
            n4 = drawable.getIntrinsicWidth();
            n3 = !bl && !bl2 ? this.mSpecialDrawablePadding * 2 : this.mSpecialDrawablePadding;
            n3 = n4 + n3;
        } else {
            n3 = this.mQQFaceSize;
        }
        if (drawable2 == null) {
            return;
        }
        n4 = 0;
        if (n != 0) {
            n4 = this.mFontHeight;
            n = this.mQQFaceSize;
            n4 = (n4 - n) / 2;
            drawable2.setBounds(0, n4, n, n4 + n);
        } else {
            n = n4;
            if (bl2) {
                n = this.mSpecialDrawablePadding;
            }
            int n5 = drawable2.getIntrinsicWidth();
            int n6 = drawable2.getIntrinsicHeight();
            int n7 = this.mFontHeight;
            int n8 = n5;
            n4 = n6;
            if (n6 > n7) {
                float f = (float)n7 / (float)n6;
                n8 = (int)((float)n5 * f);
                n4 = n7;
            }
            n7 = (this.mFontHeight - n4) / 2;
            drawable2.setBounds(n, n7, n8 + n, n4 + n7);
        }
        n = n4 = this.getPaddingTop();
        if (n2 > 1) {
            n = n4 + (n2 - 1) * (this.mFontHeight + this.mLineSpace);
        }
        canvas.save();
        canvas.translate((float)this.mCurrentDrawUsedWidth, (float)n);
        if (this.mIsInDrawSpan && (drawable = this.mCurrentDrawSpan) != null && (n = drawable.isPressed() ? this.mCurrentDrawSpan.getPressedBackgroundColor() : this.mCurrentDrawSpan.getNormalBackgroundColor()) != 0) {
            this.mSpanBgPaint.setColor(n);
            canvas.drawRect(0.0f, 0.0f, (float)n3, (float)this.mFontHeight, this.mSpanBgPaint);
        }
        drawable2.draw(canvas);
        canvas.restore();
    }

    private void drawText(Canvas canvas, CharSequence charSequence, int n, int n2, int n3) {
        int n4;
        QMUITouchableSpan qMUITouchableSpan;
        if (n2 <= n) return;
        if (n2 > charSequence.length()) return;
        if (n >= charSequence.length()) return;
        if (this.mIsInDrawSpan && (qMUITouchableSpan = this.mCurrentDrawSpan) != null && (n4 = qMUITouchableSpan.isPressed() ? this.mCurrentDrawSpan.getPressedBackgroundColor() : this.mCurrentDrawSpan.getNormalBackgroundColor()) != 0) {
            this.mSpanBgPaint.setColor(n4);
            n4 = this.mCurrentDrawUsedWidth;
            float f = n4;
            int n5 = this.mCurrentDrawBaseLine;
            int n6 = this.mFirstBaseLine;
            canvas.drawRect(f, (float)(n5 - n6), (float)(n4 + n3), (float)(n5 - n6 + this.mFontHeight), this.mSpanBgPaint);
        }
        canvas.drawText(charSequence, n, n2, (float)this.mCurrentDrawUsedWidth, (float)this.mCurrentDrawBaseLine, (Paint)this.mPaint);
    }

    private int getMiddleEllipsizeLine() {
        int n = this.mNeedDrawLine;
        n = n % 2 == 0 ? (n /= 2) : (n + 1) / 2;
        return n;
    }

    private void gotoCalNextLine(int n) {
        ++this.mCurrentCalLine;
        this.setContentCalMaxWidth(this.mCurrentCalWidth);
        this.mCurrentCalWidth = n;
        TextUtils.TruncateAt truncateAt = this.mEllipsize;
        if (truncateAt == null) {
            ++this.mParagraphShowCount;
        } else {
            if (truncateAt != TextUtils.TruncateAt.END) return;
            if (this.mCurrentCalLine > this.mMaxLine) return;
            ++this.mParagraphShowCount;
        }
    }

    private void handleQQFaceAfterMiddleEllipsize(Canvas canvas, int n, Drawable drawable, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5;
        int n6;
        if (n != 0) {
            n6 = this.mQQFaceSize;
        } else {
            n5 = drawable.getIntrinsicWidth();
            n6 = !bl && !bl2 ? this.mSpecialDrawablePadding * 2 : this.mSpecialDrawablePadding;
            n6 = n5 + n6;
        }
        int n7 = this.mMiddleEllipsizeWidthRecord;
        if (n7 == -1) {
            this.onRealDrawQQFace(canvas, n, drawable, n4 - this.mLastNeedStopLineRecord, n2, n3, bl, bl2);
            return;
        }
        n5 = this.mNeedDrawLine;
        int n8 = n3 - this.mCurrentCalWidth - (n7 - n2);
        int n9 = 1;
        n5 = n7 = this.mLines - (n5 - n4);
        if (n8 > 0) {
            n5 = n7 - 1;
        }
        n7 = n8 > 0 ? n3 - n8 : this.mMiddleEllipsizeWidthRecord - (n3 - this.mCurrentCalWidth);
        n8 = this.mCurrentDrawLine;
        if (n8 < n5) {
            n4 = this.mCurrentDrawUsedWidth;
            if (n6 + n4 > n3) {
                this.toNewDrawLine(n2, n3 - n2);
                this.onDrawQQFace(canvas, n, drawable, n2, n3, bl, bl2);
            } else {
                this.mCurrentDrawUsedWidth = n4 + n6;
            }
        } else if (n8 == n5) {
            n4 = this.mCurrentDrawUsedWidth;
            if (n6 + n4 <= n7) {
                this.mCurrentDrawUsedWidth = n4 + n6;
            } else {
                n4 = n4 >= n7 ? n9 : 0;
                this.mCurrentDrawUsedWidth = this.mMiddleEllipsizeWidthRecord;
                this.mMiddleEllipsizeWidthRecord = -1;
                this.mLastNeedStopLineRecord = n5;
                if (n4 == 0) return;
                this.onDrawQQFace(canvas, n, drawable, n2, n3, bl, bl2);
            }
        } else {
            this.onRealDrawQQFace(canvas, n, drawable, n4 - n5, n2, n3, bl, bl2);
        }
    }

    private void handleTextAfterMiddleEllipsize(Canvas canvas, CharSequence charSequence, float[] fArray, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        block10: {
            n7 = n;
            n6 = charSequence.length();
            if (n7 >= n6) {
                return;
            }
            n5 = this.mMiddleEllipsizeWidthRecord;
            if (n5 == -1) {
                this.onRealDrawText(canvas, charSequence, fArray, n, n3, n4);
                return;
            }
            n6 = this.mNeedDrawLine;
            int n8 = n4 - this.mCurrentCalWidth - (n5 - n3);
            n6 = n5 = this.mLines - (n6 - n2);
            if (n8 > 0) {
                n6 = n5 - 1;
            }
            n5 = n8 > 0 ? n4 - n8 : this.mMiddleEllipsizeWidthRecord - (n4 - this.mCurrentCalWidth);
            n8 = this.mCurrentDrawLine;
            if (n8 < n6) {
                while (n7 < fArray.length) {
                    n = this.mCurrentDrawUsedWidth;
                    if (!((float)n + fArray[n7] <= (float)n4)) {
                        this.toNewDrawLine(n3, n3 - n4);
                        this.handleTextAfterMiddleEllipsize(canvas, charSequence, fArray, n7, n2, n3, n4);
                        return;
                    }
                    this.mCurrentDrawUsedWidth = (int)((float)n + fArray[n7]);
                    ++n7;
                }
                return;
            }
            if (n8 != n6) {
                this.onRealDrawText(canvas, charSequence, fArray, n, n3, n4);
                return;
            }
            while (n7 < fArray.length) {
                n = this.mCurrentDrawUsedWidth;
                if ((float)n + fArray[n7] <= (float)n5) {
                    this.mCurrentDrawUsedWidth = (int)((float)n + fArray[n7]);
                    ++n7;
                    continue;
                }
                break block10;
            }
            return;
        }
        if (n < n5) {
            ++n7;
        }
        this.mCurrentDrawUsedWidth = this.mMiddleEllipsizeWidthRecord;
        this.mMiddleEllipsizeWidthRecord = -1;
        this.mLastNeedStopLineRecord = n6;
        this.onRealDrawText(canvas, charSequence, fArray, n7, n3, n4);
    }

    private boolean isElementEmpty() {
        QMUIQQFaceCompiler.ElementList elementList = this.mElementList;
        boolean bl = elementList == null || elementList.getElements() == null || this.mElementList.getElements().isEmpty();
        return bl;
    }

    private void measureMoreActionTextLength() {
        this.mMoreActionTextLength = QMUILangHelper.isNullOrEmpty((CharSequence)this.mMoreActionText) ? 0 : (int)Math.ceil(this.mPaint.measureText(this.mMoreActionText));
    }

    private void measureText(CharSequence charSequence, int n, int n2) {
        int n3 = charSequence.length();
        float[] fArray = new float[n3];
        this.mPaint.getTextWidths(charSequence.toString(), fArray);
        long l = System.currentTimeMillis();
        int n4 = 0;
        while (n4 < n3) {
            if ((float)(n2 - n) < fArray[n4]) {
                this.mJumpHandleMeasureAndDraw = true;
                return;
            }
            if (System.currentTimeMillis() - l > 2000L) {
                QMUILog.d((String)TAG, (String)"measureText: text = %s, mCurrentCalWidth = %d, widthStart = %d, widthEnd = %d", (Object[])new Object[]{charSequence, this.mCurrentCalWidth, n, n2});
                this.mJumpHandleMeasureAndDraw = true;
                return;
            }
            if ((float)this.mCurrentCalWidth + fArray[n4] > (float)n2) {
                this.gotoCalNextLine(n);
            }
            double d = this.mCurrentCalWidth;
            double d2 = Math.ceil(fArray[n4]);
            Double.isNaN(d);
            this.mCurrentCalWidth = (int)(d + d2);
            ++n4;
        }
    }

    private void onDrawQQFace(Canvas canvas, int n, Drawable drawable, int n2, int n3, boolean bl, boolean bl2) {
        int n4;
        int n5;
        if (n == -1 && drawable != null) {
            n5 = drawable.getIntrinsicWidth();
            n4 = !bl && !bl2 ? this.mSpecialDrawablePadding * 2 : this.mSpecialDrawablePadding;
            n4 = n5 + n4;
        } else {
            n4 = this.mQQFaceSize;
        }
        if (this.mIsNeedEllipsize) {
            if (this.mEllipsize == TextUtils.TruncateAt.START) {
                int n6 = this.mCurrentDrawLine;
                int n7 = this.mLines;
                n5 = this.mNeedDrawLine;
                if (n6 > n7 - n5) {
                    this.onRealDrawQQFace(canvas, n, drawable, n5 - n7, n2, n3, bl, bl2);
                } else if (n6 < n7 - n5) {
                    n5 = this.mCurrentDrawUsedWidth;
                    if (n4 + n5 > n3) {
                        this.toNewDrawLine(n2, n3 - n2);
                        this.onDrawQQFace(canvas, n, drawable, n2, n3, bl, bl2);
                    } else {
                        this.mCurrentDrawUsedWidth = n5 + n4;
                    }
                } else {
                    n = this.mCurrentDrawUsedWidth;
                    n6 = this.mCurrentCalWidth;
                    n5 = this.mEllipsizeTextLength;
                    if (n4 + n < n6 + n5) {
                        this.mCurrentDrawUsedWidth = n + n4;
                    } else {
                        this.toNewDrawLine(n2 + n5, n3 - n2);
                    }
                }
            } else if (this.mEllipsize == TextUtils.TruncateAt.MIDDLE) {
                int n8 = this.mCurrentDrawLine;
                n5 = this.getMiddleEllipsizeLine();
                if (n8 < n5) {
                    if (this.mCurrentDrawUsedWidth + n4 > n3) {
                        this.onRealDrawQQFace(canvas, n, drawable, 0, n2, n3, bl, bl2);
                    } else {
                        this.drawQQFace(canvas, n, drawable, n8, bl, bl2);
                        this.mCurrentDrawUsedWidth += n4;
                    }
                } else if (n8 == n5) {
                    n8 = this.getWidth() / 2;
                    int n9 = this.mEllipsizeTextLength;
                    int n10 = n9 / 2;
                    if (this.mIsExecutedMiddleEllipsize) {
                        this.handleQQFaceAfterMiddleEllipsize(canvas, n, drawable, n2, n3, n5, bl, bl2);
                    } else if (this.mCurrentDrawUsedWidth + n4 <= n8 - n10) {
                        this.drawQQFace(canvas, n, drawable, this.mCurrentDrawLine, bl, bl2);
                        this.mCurrentDrawUsedWidth += n4;
                    } else {
                        this.drawText(canvas, mEllipsizeText, 0, 3, n9);
                        this.mMiddleEllipsizeWidthRecord = this.mCurrentDrawUsedWidth + this.mEllipsizeTextLength;
                        this.mIsExecutedMiddleEllipsize = true;
                        this.handleQQFaceAfterMiddleEllipsize(canvas, n, drawable, n2, n3, n5, bl, bl2);
                    }
                } else {
                    this.handleQQFaceAfterMiddleEllipsize(canvas, n, drawable, n2, n3, n5, bl, bl2);
                }
            } else {
                n5 = this.mCurrentDrawLine;
                int n11 = this.mNeedDrawLine;
                if (n5 == n11) {
                    n5 = n11 = this.mMoreActionTextLength;
                    if (this.mEllipsize == TextUtils.TruncateAt.END) {
                        n5 = n11 + this.mEllipsizeTextLength;
                    }
                    if (n4 + (n11 = this.mCurrentDrawUsedWidth) >= (n5 = n3 - n5)) {
                        if (n11 + n4 == n5) {
                            this.drawQQFace(canvas, n, drawable, this.mCurrentDrawLine, bl, bl2);
                            this.mCurrentDrawUsedWidth += n4;
                        }
                        if (this.mEllipsize == TextUtils.TruncateAt.END) {
                            this.drawText(canvas, mEllipsizeText, 0, 3, this.mEllipsizeTextLength);
                            this.mCurrentDrawUsedWidth += this.mEllipsizeTextLength;
                        }
                        this.drawMoreActionText(canvas, n3);
                        this.toNewDrawLine(n2, n3 - n2);
                    } else {
                        this.drawQQFace(canvas, n, drawable, this.mCurrentDrawLine, bl, bl2);
                        this.mCurrentDrawUsedWidth += n4;
                    }
                } else {
                    if (n5 >= n11) return;
                    if (this.mCurrentDrawUsedWidth + n4 > n3) {
                        this.onRealDrawQQFace(canvas, n, drawable, 0, n2, n3, bl, bl2);
                    } else {
                        this.drawQQFace(canvas, n, drawable, n5, bl, bl2);
                        this.mCurrentDrawUsedWidth += n4;
                    }
                }
            }
        } else {
            this.onRealDrawQQFace(canvas, n, drawable, 0, n2, n3, bl, bl2);
        }
    }

    /*
     * Enabled force condition propagation
     */
    private void onDrawText(Canvas canvas, CharSequence charSequence, float[] fArray, int n, int n2, int n3) {
        int n4 = n;
        int n5 = charSequence.length();
        if (n4 >= n5) {
            return;
        }
        if (!this.mIsNeedEllipsize) {
            this.onRealDrawText(canvas, charSequence, fArray, 0, n2, n3);
            return;
        }
        if (this.mEllipsize == TextUtils.TruncateAt.START) {
            block28: {
                int n6 = this.mCurrentDrawLine;
                n5 = this.mLines;
                int n7 = this.mNeedDrawLine;
                if (n6 > n5 - n7) {
                    this.onRealDrawText(canvas, charSequence, fArray, n, n2, n3);
                    return;
                }
                if (n6 < n5 - n7) {
                    while (n4 < charSequence.length()) {
                        n = this.mCurrentDrawUsedWidth;
                        if (!((float)n + fArray[n4] <= (float)n3)) {
                            this.toNewDrawLine(n2, n3 - n2);
                            this.onDrawText(canvas, charSequence, fArray, n4, n2, n3);
                            return;
                        }
                        this.mCurrentDrawUsedWidth = (int)((float)n + fArray[n4]);
                        ++n4;
                    }
                    return;
                }
                n = this.mCurrentCalWidth + this.mEllipsizeTextLength;
                while (n4 < charSequence.length()) {
                    n5 = this.mCurrentDrawUsedWidth;
                    if ((float)n5 + fArray[n4] <= (float)n) {
                        this.mCurrentDrawUsedWidth = (int)((float)n5 + fArray[n4]);
                        ++n4;
                        continue;
                    }
                    break block28;
                }
                return;
            }
            if (n5 <= n) {
                ++n4;
            }
            this.toNewDrawLine(this.mEllipsizeTextLength + n2, n3 - n2);
            this.onDrawText(canvas, charSequence, fArray, n4, n2, n3);
            return;
        }
        if (this.mEllipsize == TextUtils.TruncateAt.MIDDLE) {
            n5 = this.mCurrentDrawLine;
            int n8 = this.getMiddleEllipsizeLine();
            if (n5 < n8) {
                n5 = this.mCurrentDrawUsedWidth;
                while (true) {
                    if (n4 >= fArray.length) {
                        this.drawText(canvas, charSequence, n, charSequence.length(), n5 - this.mCurrentDrawUsedWidth);
                        this.mCurrentDrawUsedWidth = n5;
                        return;
                    }
                    float f = n5;
                    if (!(fArray[n4] + f <= (float)n3)) {
                        this.drawText(canvas, charSequence, n, n4, n3 - this.mCurrentDrawUsedWidth);
                        this.toNewDrawLine(n2, n3 - n2);
                        this.onDrawText(canvas, charSequence, fArray, n4, n2, n3);
                        return;
                    }
                    n5 = (int)(f + fArray[n4]);
                    ++n4;
                }
            }
            if (n5 != n8) {
                this.handleTextAfterMiddleEllipsize(canvas, charSequence, fArray, n, n8, n2, n3);
                return;
            }
            if (this.mIsExecutedMiddleEllipsize) {
                this.handleTextAfterMiddleEllipsize(canvas, charSequence, fArray, n, n8, n2, n3);
                return;
            }
            int n9 = (n3 + n2) / 2;
            int n10 = this.mEllipsizeTextLength / 2;
            n5 = this.mCurrentDrawUsedWidth;
            while (true) {
                if (n4 >= fArray.length) {
                    this.drawText(canvas, charSequence, n, charSequence.length(), n5 - this.mCurrentDrawUsedWidth);
                    this.mCurrentDrawUsedWidth = n5;
                    return;
                }
                float f = n5;
                if (!(fArray[n4] + f <= (float)(n9 - n10))) {
                    this.drawText(canvas, charSequence, n, n4, n5 - this.mCurrentDrawUsedWidth);
                    this.mCurrentDrawUsedWidth = n5;
                    this.drawText(canvas, mEllipsizeText, 0, 3, this.mEllipsizeTextLength);
                    this.mMiddleEllipsizeWidthRecord = this.mCurrentDrawUsedWidth + this.mEllipsizeTextLength;
                    this.mIsExecutedMiddleEllipsize = true;
                    this.handleTextAfterMiddleEllipsize(canvas, charSequence, fArray, n4, n8, n2, n3);
                    return;
                }
                n5 = (int)(f + fArray[n4]);
                ++n4;
            }
        }
        n5 = this.mCurrentDrawLine;
        int n11 = this.mNeedDrawLine;
        if (n5 < n11) {
            n5 = this.mCurrentDrawUsedWidth;
            while (true) {
                if (n4 >= fArray.length) {
                    this.drawText(canvas, charSequence, n, fArray.length, n5 - this.mCurrentDrawUsedWidth);
                    this.mCurrentDrawUsedWidth = n5;
                    return;
                }
                float f = n5;
                if (!(fArray[n4] + f <= (float)n3)) {
                    this.drawText(canvas, charSequence, n, n4, n3 - this.mCurrentDrawUsedWidth);
                    this.toNewDrawLine(n2, n3 - n2);
                    this.onDrawText(canvas, charSequence, fArray, n4, n2, n3);
                    return;
                }
                n5 = (int)(f + fArray[n4]);
                ++n4;
            }
        }
        if (n5 != n11) return;
        n5 = n11 = this.mMoreActionTextLength;
        if (this.mEllipsize == TextUtils.TruncateAt.END) {
            n5 = n11 + this.mEllipsizeTextLength;
        }
        n11 = this.mCurrentDrawUsedWidth;
        while (true) {
            if (n4 >= fArray.length) {
                this.drawText(canvas, charSequence, n, fArray.length, n11 - this.mCurrentDrawUsedWidth);
                this.mCurrentDrawUsedWidth = n11;
                return;
            }
            float f = n11;
            if (!(fArray[n4] + f <= (float)(n3 - n5))) break;
            n11 = (int)(f + fArray[n4]);
            ++n4;
        }
        this.drawText(canvas, charSequence, n, n4, n11 - this.mCurrentDrawUsedWidth);
        this.mCurrentDrawUsedWidth = n11;
        if (this.mEllipsize == TextUtils.TruncateAt.END) {
            this.drawText(canvas, mEllipsizeText, 0, 3, this.mEllipsizeTextLength);
            this.mCurrentDrawUsedWidth += this.mEllipsizeTextLength;
        }
        this.drawMoreActionText(canvas, n3);
        this.toNewDrawLine(n2, n3 - n2);
    }

    private void onRealDrawQQFace(Canvas canvas, int n, Drawable drawable, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5;
        if (n == 0 && drawable != null) {
            int n6 = drawable.getIntrinsicWidth();
            n5 = !bl && !bl2 ? this.mSpecialDrawablePadding * 2 : this.mSpecialDrawablePadding;
            n5 = n6 + n5;
        } else {
            n5 = this.mQQFaceSize;
        }
        if (this.mCurrentDrawUsedWidth + n5 > n4) {
            this.toNewDrawLine(n3, n4 - n3);
        }
        this.drawQQFace(canvas, n, drawable, this.mCurrentDrawLine + n2, bl, bl2);
        this.mCurrentDrawUsedWidth += n5;
    }

    private void onRealDrawText(Canvas canvas, CharSequence charSequence, float[] fArray, int n, int n2, int n3) {
        int n4 = this.mCurrentDrawUsedWidth;
        int n5 = n;
        while (true) {
            if (n >= fArray.length) {
                if (n5 >= fArray.length) return;
                this.drawText(canvas, charSequence, n5, fArray.length, n4 - this.mCurrentDrawUsedWidth);
                this.mCurrentDrawUsedWidth = n4;
                return;
            }
            int n6 = n4;
            int n7 = n5;
            if ((float)n4 + fArray[n] > (float)n3) {
                this.drawText(canvas, charSequence, n5, n, n3 - this.mCurrentDrawUsedWidth);
                this.toNewDrawLine(n2, n3 - n2);
                n6 = this.mCurrentDrawUsedWidth;
                n7 = n;
            }
            n4 = (int)((float)n6 + fArray[n]);
            ++n;
            n5 = n7;
        }
    }

    private void setContentCalMaxWidth(int n) {
        this.mContentCalMaxWidth = Math.max(n, this.mContentCalMaxWidth);
    }

    private void setStartDrawUsedWidth(int n, int n2) {
        int n3;
        if (this.mIsNeedEllipsize) {
            this.mCurrentDrawUsedWidth = n;
            return;
        }
        this.mCurrentDrawUsedWidth = this.mCurrentDrawLine == this.mNeedDrawLine ? ((n3 = this.mGravity) == 17 ? (n2 - (this.mCurrentCalWidth - n)) / 2 + n : (n3 == 5 ? n2 - (this.mCurrentCalWidth - n) + n : n)) : n;
    }

    private void toNewDrawLine(int n, int n2) {
        this.toNewDrawLine(n, false, n2);
    }

    private void toNewDrawLine(int n, boolean bl, int n2) {
        TextUtils.TruncateAt truncateAt;
        int n3 = bl && ((truncateAt = this.mEllipsize) == null || truncateAt == TextUtils.TruncateAt.END) ? this.mParagraphSpace : 0;
        n3 += this.mLineSpace;
        ++this.mCurrentDrawLine;
        if (this.mIsNeedEllipsize) {
            if (this.mEllipsize == TextUtils.TruncateAt.START) {
                if (this.mCurrentDrawLine > this.mLines - this.mNeedDrawLine + 1) {
                    this.mCurrentDrawBaseLine += this.mFontHeight + n3;
                }
            } else if (this.mEllipsize == TextUtils.TruncateAt.MIDDLE) {
                if (!this.mIsExecutedMiddleEllipsize || this.mMiddleEllipsizeWidthRecord == -1) {
                    this.mCurrentDrawBaseLine += this.mFontHeight + n3;
                }
            } else {
                this.mCurrentDrawBaseLine += this.mFontHeight + n3;
            }
            if ((truncateAt = this.mEllipsize) != null && truncateAt != TextUtils.TruncateAt.END && this.mCurrentDrawBaseLine > this.getHeight() - this.getPaddingBottom()) {
                QMUILog.d((String)TAG, (String)"draw outside the visible height, the ellipsize is inaccurate: mEllipsize = %s; mCurrentDrawLine = %d; mNeedDrawLine = %d;viewWidth = %d; viewHeight = %d; paddingLeft = %d; paddingRight = %d; paddingTop = %d; paddingBottom = %d; text = %s", (Object[])new Object[]{this.mEllipsize.name(), this.mCurrentDrawLine, this.mNeedDrawLine, this.getWidth(), this.getHeight(), this.getPaddingLeft(), this.getPaddingRight(), this.getPaddingTop(), this.getPaddingBottom(), this.mOriginText});
            }
        } else {
            this.mCurrentDrawBaseLine += this.mFontHeight + n3;
        }
        this.setStartDrawUsedWidth(n, n2);
    }

    protected int calculateFontHeight() {
        if (!this.needReCalculateFontHeight) return this.mFontHeight;
        Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
        if (fontMetricsInt == null) {
            this.mQQFaceSize = 0;
            this.mFontHeight = 0;
        } else {
            this.needReCalculateFontHeight = false;
            int n = this.getFontHeightCalTop(fontMetricsInt, this.mIncludePad);
            int n2 = this.getFontHeightCalBottom(fontMetricsInt, this.mIncludePad) - n;
            this.mQQFaceSize = this.mQQFaceSizeAddon + n2;
            int n3 = this.mCompiler.getSpecialBoundsMaxHeight();
            if (n2 >= (n3 = Math.max(this.mQQFaceSize, n3))) {
                this.mFontHeight = n2;
                this.mFirstBaseLine = -n;
            } else {
                this.mFontHeight = n3;
                this.mFirstBaseLine = -n + (n3 - n2) / 2;
            }
        }
        return this.mFontHeight;
    }

    protected int calculateLinesAndContentWidth(int n) {
        if (n > this.getPaddingRight() + this.getPaddingLeft() && !this.isElementEmpty()) {
            if (!this.mNeedReCalculateLines && this.mLastCalLimitWidth == n) {
                this.mLines = this.mLastCalLines;
                return this.mLastCalContentWidth;
            }
            this.mLastCalLimitWidth = n;
            List list = this.mElementList.getElements();
            this.mSpanInfos.clear();
            this.mCurrentCalLine = 1;
            this.mCurrentCalWidth = this.getPaddingLeft();
            this.calculateLinesInner(list, n);
            int n2 = this.mCurrentCalLine;
            if (n2 != this.mLines) {
                list = this.mListener;
                if (list != null) {
                    list.onCalculateLinesChange(n2);
                }
                this.mLines = this.mCurrentCalLine;
            }
            this.mLastCalContentWidth = this.mLines == 1 ? this.mCurrentCalWidth + this.getPaddingRight() : n;
            this.mLastCalLines = this.mLines;
            return this.mLastCalContentWidth;
        }
        this.mLines = 0;
        this.mParagraphShowCount = 0;
        this.mLastCalLines = 0;
        this.mLastCalContentWidth = 0;
        return 0;
    }

    public int getFontHeight() {
        return this.mFontHeight;
    }

    protected int getFontHeightCalBottom(Paint.FontMetricsInt fontMetricsInt, boolean bl) {
        int n = bl ? fontMetricsInt.bottom : fontMetricsInt.descent;
        return n;
    }

    protected int getFontHeightCalTop(Paint.FontMetricsInt fontMetricsInt, boolean bl) {
        int n = bl ? fontMetricsInt.top : fontMetricsInt.ascent;
        return n;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getLineCount() {
        return this.mLines;
    }

    public int getLineSpace() {
        return this.mLineSpace;
    }

    public int getMaxLine() {
        return this.mMaxLine;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public Rect getMoreHitRect() {
        return this.mMoreHitRect;
    }

    public TextPaint getPaint() {
        return this.mPaint;
    }

    public CharSequence getText() {
        return this.mOriginText;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public boolean isNeedEllipsize() {
        return this.mIsNeedEllipsize;
    }

    protected void onDraw(Canvas object) {
        if (this.mJumpHandleMeasureAndDraw) return;
        if (this.mOriginText == null) return;
        if (this.mLines == 0) return;
        if (this.isElementEmpty()) return;
        long l = System.currentTimeMillis();
        List list = this.mElementList.getElements();
        this.mCurrentDrawBaseLine = this.getPaddingTop() + this.mFirstBaseLine;
        this.mCurrentDrawLine = 1;
        this.setStartDrawUsedWidth(this.getPaddingLeft(), this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
        this.mIsExecutedMiddleEllipsize = false;
        this.drawElements((Canvas)object, list, this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
        object = new StringBuilder();
        ((StringBuilder)object).append("onDraw spend time = ");
        ((StringBuilder)object).append(System.currentTimeMillis() - l);
        Log.i((String)TAG, (String)((StringBuilder)object).toString());
    }

    /*
     * Unable to fully structure code
     */
    protected void onMeasure(int var1_1, int var2_2) {
        block9: {
            block6: {
                block7: {
                    block8: {
                        var8_3 = System.currentTimeMillis();
                        var3_4 = 0;
                        this.mJumpHandleMeasureAndDraw = false;
                        this.calculateFontHeight();
                        var5_5 = View.MeasureSpec.getMode((int)var1_1);
                        var4_6 = View.MeasureSpec.getMode((int)var2_2);
                        var1_1 = View.MeasureSpec.getSize((int)var1_1);
                        var2_2 = View.MeasureSpec.getSize((int)var2_2);
                        var10_7 = new StringBuilder();
                        var10_7.append("widthSize = ");
                        var10_7.append(var1_1);
                        var10_7.append("; heightSize = ");
                        var10_7.append(var2_2);
                        Log.i((String)"QMUIQQFaceView", (String)var10_7.toString());
                        this.mLines = 0;
                        this.mParagraphShowCount = 0;
                        if (var5_5 != 0 && var5_5 != 0x40000000) {
                            var10_7 = this.mOriginText;
                            var1_1 = var10_7 != null && var10_7.length() != 0 ? this.calculateLinesAndContentWidth(Math.min(var1_1, this.mMaxWidth)) : 0;
                        } else {
                            this.calculateLinesAndContentWidth(var1_1);
                        }
                        if (this.mJumpHandleMeasureAndDraw) {
                            if (var4_6 == -2147483648) {
                                var2_2 = var3_4;
                            }
                            this.setMeasuredDimension(var1_1, var2_2);
                            return;
                        }
                        var3_4 = this.mMaxLine;
                        if (var4_6 == -2147483648) break block6;
                        if (var4_6 == 0x40000000) break block7;
                        this.calculateNeedDrawLine(var3_4);
                        var4_6 = this.getPaddingTop() + this.getPaddingBottom();
                        var5_5 = this.mNeedDrawLine;
                        if (var5_5 >= 2) break block8;
                        var6_8 = this.mFontHeight;
                        var2_2 = var4_6;
                        ** GOTO lbl70
                    }
                    var2_2 = this.mFontHeight;
                    var5_5 = (var5_5 - 1) * (this.mLineSpace + var2_2) + var2_2;
                    var6_9 = this.mParagraphShowCount;
                    var7_10 = this.mParagraphSpace;
                    var2_2 = var3_4;
                    var3_4 = var4_6;
                    ** GOTO lbl79
                }
                var5_5 = this.getPaddingTop();
                var3_4 = this.getPaddingBottom();
                var4_6 = this.mLineSpace;
                var3_4 = Math.min((var2_2 - var5_5 - var3_4 + var4_6) / (this.mFontHeight + var4_6), this.mMaxLine);
                this.calculateNeedDrawLine(var3_4);
                break block9;
            }
            var3_4 = this.getPaddingTop();
            var5_5 = this.getPaddingBottom();
            var4_6 = this.mLineSpace;
            var4_6 = Math.min((var2_2 - var3_4 - var5_5 + var4_6) / (this.mFontHeight + var4_6), this.mMaxLine);
            this.calculateNeedDrawLine(var4_6);
            var2_2 = this.getPaddingTop() + this.getPaddingBottom();
            var5_5 = this.mNeedDrawLine;
            if (var5_5 < 2) {
                var6_8 = this.mFontHeight;
                var3_4 = var4_6;
lbl70:
                // 2 sources

                var4_6 = var5_5 * var6_8;
                var5_5 = var2_2;
            } else {
                var3_4 = this.mFontHeight;
                var5_5 = (var5_5 - 1) * (this.mLineSpace + var3_4) + var3_4;
                var6_9 = this.mParagraphShowCount;
                var7_10 = this.mParagraphSpace;
                var3_4 = var2_2;
                var2_2 = var4_6;
lbl79:
                // 2 sources

                var4_6 = var5_5 + var6_9 * var7_10;
                var5_5 = var3_4;
                var3_4 = var2_2;
            }
            var2_2 = var5_5 + var4_6;
        }
        this.setMeasuredDimension(var1_1, var2_2);
        var10_7 = new StringBuilder();
        var10_7.append("mLines = ");
        var10_7.append(this.mLines);
        var10_7.append(" ; width = ");
        var10_7.append(var1_1);
        var10_7.append(" ; height = ");
        var10_7.append(var2_2);
        var10_7.append(" ; maxLine = ");
        var10_7.append(var3_4);
        var10_7.append("; measure time = ");
        var10_7.append(System.currentTimeMillis() - var8_3);
        Log.i((String)"QMUIQQFaceView", (String)var10_7.toString());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n = (int)motionEvent.getX();
        int n2 = (int)motionEvent.getY();
        if (this.mSpanInfos.isEmpty() && this.mMoreHitRect.isEmpty()) {
            return super.onTouchEvent(motionEvent);
        }
        int n3 = motionEvent.getAction();
        if (n3 != 0 && !this.mIsTouchDownInMoreText && this.mTouchSpanInfo == null) {
            return super.onTouchEvent(motionEvent);
        }
        PressCancelAction pressCancelAction2 = this.mPendingPressCancelAction;
        if (pressCancelAction2 != null) {
            pressCancelAction2.run();
            this.mPendingPressCancelAction = null;
        }
        if (n3 != 0) {
            if (n3 != 1) {
                if (n3 != 2) {
                    if (n3 != 3) return true;
                    this.mPendingPressCancelAction = null;
                    motionEvent = this.mTouchSpanInfo;
                    if (motionEvent == null) return true;
                    motionEvent.setPressed(false);
                    this.mTouchSpanInfo.invalidateSpan();
                } else {
                    motionEvent = this.mTouchSpanInfo;
                    if (motionEvent == null) return true;
                    if (motionEvent.onTouch(n, n2)) return true;
                    this.mTouchSpanInfo.setPressed(false);
                    this.mTouchSpanInfo.invalidateSpan();
                    this.mTouchSpanInfo = null;
                }
            } else {
                motionEvent = this.mTouchSpanInfo;
                if (motionEvent != null) {
                    motionEvent.onClick();
                    this.mPendingPressCancelAction = new PressCancelAction(this.mTouchSpanInfo);
                    this.postDelayed((Runnable)new /* Unavailable Anonymous Inner Class!! */, 100L);
                } else {
                    if (!this.mIsTouchDownInMoreText) return true;
                    motionEvent = this.mListener;
                    if (motionEvent != null) {
                        motionEvent.onMoreTextClick();
                    } else {
                        if (!this.isClickable()) return true;
                        this.performClick();
                    }
                }
            }
        } else {
            this.mTouchSpanInfo = null;
            this.mIsTouchDownInMoreText = false;
            if (this.mMoreHitRect.contains(n, n2)) {
                this.mIsTouchDownInMoreText = true;
            } else {
                for (SpanInfo spanInfo : this.mSpanInfos) {
                    if (!spanInfo.onTouch(n, n2)) continue;
                    this.mTouchSpanInfo = spanInfo;
                    break;
                }
            }
            SpanInfo spanInfo = this.mTouchSpanInfo;
            if (spanInfo == null) {
                if (this.mIsTouchDownInMoreText) return true;
                return super.onTouchEvent(motionEvent);
            }
            spanInfo.setPressed(true);
            this.mTouchSpanInfo.invalidateSpan();
        }
        return true;
    }

    public void setCompiler(QMUIQQFaceCompiler object) {
        this.mCompiler = object;
        object = this.mDelayTextSetter;
        if (object == null) return;
        object.run();
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.mEllipsize == truncateAt) return;
        this.mEllipsize = truncateAt;
        this.requestLayout();
        this.invalidate();
    }

    public void setGravity(int n) {
        this.mGravity = n;
    }

    public void setIncludeFontPadding(boolean bl) {
        if (this.mIncludePad == bl) return;
        this.needReCalculateFontHeight = true;
        this.mIncludePad = bl;
        this.requestLayout();
        this.invalidate();
    }

    public void setLineSpace(int n) {
        if (this.mLineSpace == n) return;
        this.mLineSpace = n;
        this.requestLayout();
        this.invalidate();
    }

    public void setListener(QQFaceViewListener qQFaceViewListener) {
        this.mListener = qQFaceViewListener;
    }

    public void setMaxLine(int n) {
        if (this.mMaxLine == n) return;
        this.mMaxLine = n;
        this.requestLayout();
        this.invalidate();
    }

    public void setMaxWidth(int n) {
        if (this.mMaxWidth == n) return;
        this.mMaxWidth = n;
        this.requestLayout();
    }

    public void setMoreActionColor(int n) {
        if (n == this.mMoreActionColor) return;
        this.mMoreActionColor = n;
        this.invalidate();
    }

    public void setMoreActionText(String string) {
        String string2 = this.mMoreActionText;
        if (string2 != null) {
            if (string2.equals(string)) return;
        }
        this.mMoreActionText = string;
        this.measureMoreActionTextLength();
        this.requestLayout();
        this.invalidate();
    }

    public void setOpenQQFace(boolean bl) {
        this.mOpenQQFace = bl;
    }

    public void setPadding(int n, int n2, int n3, int n4) {
        if (this.getPaddingLeft() != n || this.getPaddingRight() != n3) {
            this.mNeedReCalculateLines = true;
        }
        super.setPadding(n, n2, n3, n4);
    }

    public void setParagraphSpace(int n) {
        if (this.mParagraphSpace == n) return;
        this.mParagraphSpace = n;
        this.requestLayout();
        this.invalidate();
    }

    public void setQQFaceSizeAddon(int n) {
        if (this.mQQFaceSizeAddon == n) return;
        this.mQQFaceSizeAddon = n;
        this.mNeedReCalculateLines = true;
        this.requestLayout();
        this.invalidate();
    }

    public void setSingleLine(boolean bl) {
        if (this.mIsSingleLine == bl) return;
        this.mIsSingleLine = bl;
        this.requestLayout();
        this.invalidate();
    }

    public void setSpecialDrawablePadding(int n) {
        if (this.mSpecialDrawablePadding == n) return;
        this.mSpecialDrawablePadding = n;
        this.requestLayout();
        this.invalidate();
    }

    public void setText(CharSequence stringArray) {
        int n;
        this.mDelayTextSetter = null;
        CharSequence charSequence = this.mOriginText;
        if (charSequence != null && charSequence.equals(stringArray)) {
            return;
        }
        this.mOriginText = stringArray;
        this.setContentDescription((CharSequence)stringArray);
        if (this.mOpenQQFace) {
            if (this.mCompiler == null) throw new RuntimeException("mCompiler == null");
        }
        if (QMUILangHelper.isNullOrEmpty((CharSequence)this.mOriginText)) {
            if (QMUILangHelper.isNullOrEmpty((CharSequence)charSequence)) return;
            this.mElementList = null;
            this.requestLayout();
            this.invalidate();
            return;
        }
        if (this.mOpenQQFace && (stringArray = this.mCompiler) != null) {
            this.mElementList = stringArray.compile(this.mOriginText);
        } else {
            this.mElementList = new QMUIQQFaceCompiler.ElementList(0, this.mOriginText.length());
            stringArray = this.mOriginText.toString().split("\\n");
            for (n = 0; n < stringArray.length; ++n) {
                this.mElementList.add(QMUIQQFaceCompiler.Element.createTextElement((CharSequence)stringArray[n]));
                if (n == stringArray.length - 1) continue;
                this.mElementList.add(QMUIQQFaceCompiler.Element.createNextLineElement());
            }
        }
        this.mNeedReCalculateLines = true;
        if (this.getLayoutParams() == null) {
            return;
        }
        if (this.getLayoutParams().width != -2 && this.getLayoutParams().height != -2) {
            int n2 = this.getPaddingLeft();
            int n3 = this.getPaddingRight();
            n = this.getPaddingBottom() + this.getPaddingTop();
            if (this.getWidth() <= n2 + n3) return;
            if (this.getHeight() <= n) return;
            this.mLines = 0;
            this.calculateLinesAndContentWidth(this.getWidth());
            n2 = this.mNeedDrawLine;
            n3 = this.getHeight();
            int n4 = this.mLineSpace;
            this.calculateNeedDrawLine(Math.min((n3 - n + n4) / (this.mFontHeight + n4), this.mMaxLine));
            if (n2 == this.mNeedDrawLine) {
                this.invalidate();
            } else {
                this.requestLayout();
                this.invalidate();
            }
            return;
        }
        this.requestLayout();
        this.invalidate();
    }

    public void setTextColor(int n) {
        if (this.mTextColor == n) return;
        this.mTextColor = n;
        this.mPaint.setColor(n);
        this.invalidate();
    }

    public void setTextSize(int n) {
        if (this.mTextSize == n) return;
        this.mTextSize = n;
        this.mPaint.setTextSize((float)n);
        this.needReCalculateFontHeight = true;
        this.mNeedReCalculateLines = true;
        this.mEllipsizeTextLength = (int)Math.ceil(this.mPaint.measureText(mEllipsizeText));
        this.measureMoreActionTextLength();
        this.requestLayout();
        this.invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.mTypeface == typeface) return;
        this.mTypeface = typeface;
        this.needReCalculateFontHeight = true;
        this.mPaint.setTypeface(typeface);
        this.requestLayout();
        this.invalidate();
    }

    public void setTypeface(Typeface typeface, int n) {
        float f = 0.0f;
        boolean bl = false;
        if (n > 0) {
            typeface = typeface == null ? Typeface.defaultFromStyle((int)n) : Typeface.create((Typeface)typeface, (int)n);
            this.setTypeface(typeface);
            int n2 = typeface != null ? typeface.getStyle() : 0;
            n = ~n2 & n;
            typeface = this.mPaint;
            if ((n & 1) != 0) {
                bl = true;
            }
            typeface.setFakeBoldText(bl);
            typeface = this.mPaint;
            if ((n & 2) != 0) {
                f = -0.25f;
            }
            typeface.setTextSkewX(f);
        } else {
            this.mPaint.setFakeBoldText(false);
            this.mPaint.setTextSkewX(0.0f);
            this.setTypeface(typeface);
        }
    }
}

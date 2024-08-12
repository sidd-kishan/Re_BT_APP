/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler$ElementList
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler$ElementType
 *  com.qmuiteam.qmui.span.QMUITouchableSpan
 */
package com.qmuiteam.qmui.qqface;

import android.graphics.drawable.Drawable;
import com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler;
import com.qmuiteam.qmui.span.QMUITouchableSpan;

/*
 * Exception performing whole class analysis ignored.
 */
public static class QMUIQQFaceCompiler.Element {
    private QMUIQQFaceCompiler.ElementList mChildList;
    private int mDrawableRes;
    private Drawable mSpecialBoundsDrawable;
    private CharSequence mText;
    private QMUITouchableSpan mTouchableSpan;
    private QMUIQQFaceCompiler.ElementType mType;

    public static QMUIQQFaceCompiler.Element createDrawableElement(int n) {
        QMUIQQFaceCompiler.Element element = new QMUIQQFaceCompiler.Element();
        element.mType = QMUIQQFaceCompiler.ElementType.DRAWABLE;
        element.mDrawableRes = n;
        return element;
    }

    public static QMUIQQFaceCompiler.Element createNextLineElement() {
        QMUIQQFaceCompiler.Element element = new QMUIQQFaceCompiler.Element();
        element.mType = QMUIQQFaceCompiler.ElementType.NEXTLINE;
        return element;
    }

    public static QMUIQQFaceCompiler.Element createSpeaicalBoundsDrawableElement(Drawable drawable) {
        QMUIQQFaceCompiler.Element element = new QMUIQQFaceCompiler.Element();
        element.mType = QMUIQQFaceCompiler.ElementType.SPECIAL_BOUNDS_DRAWABLE;
        element.mSpecialBoundsDrawable = drawable;
        return element;
    }

    public static QMUIQQFaceCompiler.Element createTextElement(CharSequence charSequence) {
        QMUIQQFaceCompiler.Element element = new QMUIQQFaceCompiler.Element();
        element.mType = QMUIQQFaceCompiler.ElementType.TEXT;
        element.mText = charSequence;
        return element;
    }

    public static QMUIQQFaceCompiler.Element createTouchSpanElement(CharSequence charSequence, QMUITouchableSpan qMUITouchableSpan, QMUIQQFaceCompiler qMUIQQFaceCompiler) {
        QMUIQQFaceCompiler.Element element = new QMUIQQFaceCompiler.Element();
        element.mType = QMUIQQFaceCompiler.ElementType.SPAN;
        element.mChildList = QMUIQQFaceCompiler.access$000((QMUIQQFaceCompiler)qMUIQQFaceCompiler, (CharSequence)charSequence, (int)0, (int)charSequence.length(), (boolean)true);
        element.mTouchableSpan = qMUITouchableSpan;
        return element;
    }

    public QMUIQQFaceCompiler.ElementList getChildList() {
        return this.mChildList;
    }

    public int getDrawableRes() {
        return this.mDrawableRes;
    }

    public Drawable getSpecialBoundsDrawable() {
        return this.mSpecialBoundsDrawable;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public QMUITouchableSpan getTouchableSpan() {
        return this.mTouchableSpan;
    }

    public QMUIQQFaceCompiler.ElementType getType() {
        return this.mType;
    }
}

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler$Element
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler$ElementType
 */
package com.qmuiteam.qmui.qqface;

import com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler;
import java.util.ArrayList;
import java.util.List;

public static class QMUIQQFaceCompiler.ElementList {
    private List<QMUIQQFaceCompiler.Element> mElements;
    private int mEnd;
    private int mNewLineCount = 0;
    private int mQQFaceCount = 0;
    private int mStart;

    public QMUIQQFaceCompiler.ElementList(int n, int n2) {
        this.mStart = n;
        this.mEnd = n2;
        this.mElements = new ArrayList<QMUIQQFaceCompiler.Element>();
    }

    public void add(QMUIQQFaceCompiler.Element element) {
        if (element.getType() == QMUIQQFaceCompiler.ElementType.DRAWABLE) {
            ++this.mQQFaceCount;
        } else if (element.getType() == QMUIQQFaceCompiler.ElementType.NEXTLINE) {
            ++this.mNewLineCount;
        } else if (element.getType() == QMUIQQFaceCompiler.ElementType.SPAN && element.getChildList() != null) {
            this.mQQFaceCount += element.getChildList().getQQFaceCount();
            this.mNewLineCount += element.getChildList().getNewLineCount();
        }
        this.mElements.add(element);
    }

    public List<QMUIQQFaceCompiler.Element> getElements() {
        return this.mElements;
    }

    public int getEnd() {
        return this.mEnd;
    }

    public int getNewLineCount() {
        return this.mNewLineCount;
    }

    public int getQQFaceCount() {
        return this.mQQFaceCount;
    }

    public int getStart() {
        return this.mStart;
    }
}

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.LinearLayout$LayoutParams
 *  com.qmuiteam.qmui.R$styleable
 */
package com.qmuiteam.qmui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qmuiteam.qmui.R;

public static class QMUIPriorityLinearLayout.LayoutParams
extends LinearLayout.LayoutParams {
    static final int PRIORITY_DISPOSABLE = 1;
    static final int PRIORITY_INCOMPRESSIBLE = 3;
    static final int PRIORITY_MINI_CONTENT_PROTECTION = 2;
    private int backupHeight;
    private int backupWidth = Integer.MIN_VALUE;
    public int miniContentProtectionSize = 0;
    private int priority = 2;

    public QMUIPriorityLinearLayout.LayoutParams(int n, int n2) {
        super(n, n2);
        this.backupHeight = Integer.MIN_VALUE;
    }

    public QMUIPriorityLinearLayout.LayoutParams(int n, int n2, float f) {
        super(n, n2, f);
        this.backupHeight = Integer.MIN_VALUE;
    }

    public QMUIPriorityLinearLayout.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.backupHeight = Integer.MIN_VALUE;
        context = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIPriorityLinearLayout_Layout);
        this.priority = context.getInteger(R.styleable.QMUIPriorityLinearLayout_Layout_qmui_layout_priority, 2);
        this.miniContentProtectionSize = context.getDimensionPixelSize(R.styleable.QMUIPriorityLinearLayout_Layout_qmui_layout_miniContentProtectionSize, 0);
        context.recycle();
    }

    public QMUIPriorityLinearLayout.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.backupHeight = Integer.MIN_VALUE;
    }

    public QMUIPriorityLinearLayout.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.backupHeight = Integer.MIN_VALUE;
    }

    public QMUIPriorityLinearLayout.LayoutParams(LinearLayout.LayoutParams layoutParams) {
        super(layoutParams);
        this.backupHeight = Integer.MIN_VALUE;
    }

    void backupOrRestore() {
        int n = this.backupWidth;
        if (n == Integer.MIN_VALUE) {
            this.backupWidth = this.width;
        } else {
            this.width = n;
        }
        n = this.backupHeight;
        if (n == Integer.MIN_VALUE) {
            this.backupHeight = this.height;
        } else {
            this.height = n;
        }
    }

    public int getPriority(int n) {
        if (this.weight > 0.0f) {
            return 1;
        }
        if (n == 0) {
            if (this.width < 0) return this.priority;
            return 3;
        }
        if (this.height < 0) return this.priority;
        return 3;
    }

    public void setPriority(int n) {
        this.priority = n;
    }
}

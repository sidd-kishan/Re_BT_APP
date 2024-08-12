/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$layout
 *  com.qmuiteam.qmui.R$style
 *  com.qmuiteam.qmui.layout.IQMUILayout
 *  com.qmuiteam.qmui.layout.QMUIFrameLayout
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.widget.popup.QMUIBasePopup
 */
package com.qmuiteam.qmui.widget.popup;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.IQMUILayout;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.popup.QMUIBasePopup;

public class QMUIPopup
extends QMUIBasePopup {
    public static final int ANIM_AUTO = 4;
    public static final int ANIM_GROW_FROM_CENTER = 3;
    public static final int ANIM_GROW_FROM_LEFT = 1;
    public static final int ANIM_GROW_FROM_RIGHT = 2;
    public static final int DIRECTION_BOTTOM = 1;
    public static final int DIRECTION_NONE = 2;
    public static final int DIRECTION_TOP = 0;
    protected int mAnimStyle = 4;
    protected int mArrowCenter;
    protected ImageView mArrowDown;
    protected ImageView mArrowUp;
    protected int mDirection;
    private int mOffsetX = 0;
    private int mOffsetYWhenBottom = 0;
    private int mOffsetYWhenTop = 0;
    private int mPopupLeftRightMinMargin = 0;
    private int mPopupTopBottomMinMargin = 0;
    private int mPreferredDirection;
    protected int mX = -1;
    protected int mY = -1;

    public QMUIPopup(Context context) {
        this(context, 2);
    }

    public QMUIPopup(Context context, int n) {
        super(context);
        this.mPreferredDirection = n;
        this.mDirection = n;
    }

    private void calculatePosition(View view) {
        if (view != null) {
            int n;
            int n2;
            int n3;
            int[] nArray = new int[2];
            view.getLocationOnScreen(nArray);
            this.mArrowCenter = n3 = nArray[0] + view.getWidth() / 2;
            this.mX = n3 < this.mScreenSize.x / 2 ? ((n3 = this.mArrowCenter) - (n2 = this.mWindowWidth / 2) > (n = this.mPopupLeftRightMinMargin) ? this.mArrowCenter - this.mWindowWidth / 2 : n) : (this.mArrowCenter + this.mWindowWidth / 2 < this.mScreenSize.x - this.mPopupLeftRightMinMargin ? this.mArrowCenter - this.mWindowWidth / 2 : this.mScreenSize.x - this.mPopupLeftRightMinMargin - this.mWindowWidth);
            this.mDirection = n3 = this.mPreferredDirection;
            if (n3 != 0) {
                if (n3 != 1) {
                    if (n3 != 2) return;
                    this.mY = nArray[1];
                } else {
                    this.mY = n3 = nArray[1] + view.getHeight();
                    if (n3 <= this.mScreenSize.y - this.mPopupTopBottomMinMargin - this.mWindowHeight) return;
                    this.mY = nArray[1] - this.mWindowHeight;
                    this.mDirection = 0;
                }
            } else {
                this.mY = n3 = nArray[1] - this.mWindowHeight;
                if (n3 >= this.mPopupTopBottomMinMargin) return;
                this.mY = nArray[1] + view.getHeight();
                this.mDirection = 1;
            }
        } else {
            this.mX = (this.mScreenSize.x - this.mWindowWidth) / 2;
            this.mY = (this.mScreenSize.y - this.mWindowHeight) / 2;
            this.mDirection = 2;
        }
    }

    private void setAnimationStyle(int n, int n2) {
        ImageView imageView = this.mArrowUp;
        int n3 = n2;
        if (imageView != null) {
            n3 = n2 - imageView.getMeasuredWidth() / 2;
        }
        n2 = this.mDirection == 0 ? 1 : 0;
        int n4 = this.mAnimStyle;
        if (n4 != 1) {
            if (n4 != 2) {
                if (n4 != 3) {
                    if (n4 != 4) return;
                    if (n3 <= (n /= 4)) {
                        imageView = this.mWindow;
                        n = n2 != 0 ? R.style.QMUI_Animation_PopUpMenu_Left : R.style.QMUI_Animation_PopDownMenu_Left;
                        imageView.setAnimationStyle(n);
                    } else if (n3 > n && n3 < n * 3) {
                        imageView = this.mWindow;
                        n = n2 != 0 ? R.style.QMUI_Animation_PopUpMenu_Center : R.style.QMUI_Animation_PopDownMenu_Center;
                        imageView.setAnimationStyle(n);
                    } else {
                        imageView = this.mWindow;
                        n = n2 != 0 ? R.style.QMUI_Animation_PopUpMenu_Right : R.style.QMUI_Animation_PopDownMenu_Right;
                        imageView.setAnimationStyle(n);
                    }
                } else {
                    imageView = this.mWindow;
                    n = n2 != 0 ? R.style.QMUI_Animation_PopUpMenu_Center : R.style.QMUI_Animation_PopDownMenu_Center;
                    imageView.setAnimationStyle(n);
                }
            } else {
                imageView = this.mWindow;
                n = n2 != 0 ? R.style.QMUI_Animation_PopUpMenu_Right : R.style.QMUI_Animation_PopDownMenu_Right;
                imageView.setAnimationStyle(n);
            }
        } else {
            imageView = this.mWindow;
            n = n2 != 0 ? R.style.QMUI_Animation_PopUpMenu_Left : R.style.QMUI_Animation_PopDownMenu_Left;
            imageView.setAnimationStyle(n);
        }
    }

    private void setViewVisibility(View view, boolean bl) {
        if (view == null) return;
        int n = bl ? 0 : 4;
        view.setVisibility(n);
    }

    private void showArrow() {
        ImageView imageView;
        int n = this.mDirection;
        if (n != 0) {
            if (n != 1) {
                if (n == 2) {
                    this.setViewVisibility((View)this.mArrowDown, false);
                    this.setViewVisibility((View)this.mArrowUp, false);
                }
                imageView = null;
            } else {
                this.setViewVisibility((View)this.mArrowUp, true);
                this.setViewVisibility((View)this.mArrowDown, false);
                imageView = this.mArrowUp;
            }
        } else {
            this.setViewVisibility((View)this.mArrowDown, true);
            this.setViewVisibility((View)this.mArrowUp, false);
            imageView = this.mArrowDown;
        }
        if (imageView == null) return;
        n = this.mArrowUp.getMeasuredWidth();
        ((ViewGroup.MarginLayoutParams)imageView.getLayoutParams()).leftMargin = this.mArrowCenter - this.mX - n / 2;
    }

    public ViewGroup.LayoutParams generateLayoutParam(int n, int n2) {
        return new FrameLayout.LayoutParams(n, n2);
    }

    protected int getRootLayout() {
        return R.layout.qmui_popup_layout;
    }

    protected int getRootLayoutRadius(Context context) {
        return QMUIDisplayHelper.dp2px((Context)context, (int)5);
    }

    protected Point onShowBegin(View view, View view2) {
        this.calculatePosition(view2);
        this.showArrow();
        this.setAnimationStyle(this.mScreenSize.x, this.mArrowCenter);
        int n = this.mDirection;
        n = n == 0 ? this.mOffsetYWhenTop : (n == 1 ? this.mOffsetYWhenBottom : 0);
        return new Point(this.mX + this.mOffsetX, this.mY + n);
    }

    protected void onWindowSizeChange() {
    }

    public void setAnimStyle(int n) {
        this.mAnimStyle = n;
    }

    public void setContentView(View view) {
        View view2 = view;
        if (view.getBackground() != null) {
            if (view instanceof IQMUILayout) {
                ((IQMUILayout)view).setRadius(this.getRootLayoutRadius(this.mContext));
                view2 = view;
            } else {
                view2 = new QMUIFrameLayout(this.mContext);
                view2.setRadius(this.getRootLayoutRadius(this.mContext));
                view2.addView(view);
            }
        }
        view = (FrameLayout)LayoutInflater.from((Context)this.mContext).inflate(this.getRootLayout(), null, false);
        this.mArrowDown = (ImageView)view.findViewById(R.id.arrow_down);
        this.mArrowUp = (ImageView)view.findViewById(R.id.arrow_up);
        ((FrameLayout)view.findViewById(R.id.box)).addView(view2);
        super.setContentView(view);
    }

    public void setPopupLeftRightMinMargin(int n) {
        this.mPopupLeftRightMinMargin = n;
    }

    public void setPopupTopBottomMinMargin(int n) {
        this.mPopupTopBottomMinMargin = n;
    }

    public void setPositionOffsetX(int n) {
        this.mOffsetX = n;
    }

    public void setPositionOffsetYWhenBottom(int n) {
        this.mOffsetYWhenBottom = n;
    }

    public void setPositionOffsetYWhenTop(int n) {
        this.mOffsetYWhenTop = n;
    }

    public void setPreferredDirection(int n) {
        this.mPreferredDirection = n;
    }
}

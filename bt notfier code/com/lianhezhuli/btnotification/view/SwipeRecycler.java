/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.WindowManager
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.lianhezhuli.btnotification.view._$$Lambda$SwipeRecycler$1guqWiNjNU3QCPZ7CyoFM25HSnQ
 *  com.lianhezhuli.btnotification.view._$$Lambda$SwipeRecycler$JLqoW8dzScma2sUL0HLm6PQLW9U
 */
package com.lianhezhuli.btnotification.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lianhezhuli.btnotification.view._$;
import java.io.PrintStream;

public class SwipeRecycler
extends RecyclerView {
    private int add = -1;
    private Context context;
    public int distance = 0;
    private int exSize;
    private boolean isSroll = false;
    public boolean isSwipe = false;
    private LinearLayoutManager layoutManager;
    private float startx;
    private float starty;
    private boolean toLeft = false;
    private boolean toRight = false;

    public SwipeRecycler(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        attributeSet = new LinearLayoutManager(context);
        this.layoutManager = attributeSet;
        this.setLayoutManager((RecyclerView.LayoutManager)attributeSet);
        this.context = context;
        this.addOnScrollListener((RecyclerView.OnScrollListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ boolean access$002(SwipeRecycler swipeRecycler, boolean bl) {
        swipeRecycler.isSroll = bl;
        return bl;
    }

    static /* synthetic */ void access$100(SwipeRecycler swipeRecycler) {
        swipeRecycler.initData();
    }

    static /* synthetic */ int access$202(SwipeRecycler swipeRecycler, int n) {
        swipeRecycler.add = n;
        return n;
    }

    private int getPosition(MotionEvent motionEvent) {
        int n = this.layoutManager.findFirstVisibleItemPosition();
        int n2 = this.layoutManager.findLastVisibleItemPosition();
        while (n <= n2) {
            View view = this.findViewHolderForAdapterPosition((int)n).itemView;
            int[] nArray = new int[2];
            view.getLocationOnScreen(nArray);
            if (motionEvent.getY() < (float)nArray[1] && motionEvent.getY() > (float)(nArray[1] - view.getHeight()) && motionEvent.getX() > (float)nArray[0] && motionEvent.getX() < (float)(nArray[0] + view.getWidth())) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    private void initData() {
        this.isSwipe = false;
        this.startx = 0.0f;
        this.starty = 0.0f;
        this.toRight = false;
        this.toLeft = false;
    }

    private void move() {
        int n;
        int n2;
        if (this.distance > 0) {
            this.distance = 0;
        }
        if ((n2 = this.distance) < -(n = this.exSize)) {
            this.distance = -n;
        }
        if ((n2 = this.add) == -1) return;
        this.setPaddingLeft(this.findViewHolderForAdapterPosition((int)n2).itemView, this.distance);
    }

    private void playBack(int n, int n2) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt((int[])new int[]{n, n2});
        valueAnimator.setDuration((long)(Math.abs(n2 - n) / 3));
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new _$.Lambda.SwipeRecycler.1guqWiNjNU3QCPZ7CyoFM25HSnQ(this, this.findViewHolderForAdapterPosition((int)this.add).itemView));
        valueAnimator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.start();
    }

    private void setPaddingLeft(View view, int n) {
        view.setPadding(n, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public void closeEx() {
        RecyclerView.ViewHolder viewHolder = this.findViewHolderForAdapterPosition(this.add);
        if (viewHolder == null) return;
        viewHolder = viewHolder.itemView;
        this.add = -1;
        this.distance = 0;
        viewHolder.setPadding(0, viewHolder.getPaddingTop(), viewHolder.getPaddingRight(), viewHolder.getPaddingBottom());
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.startx = motionEvent.getX();
            this.starty = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            int n = (int)(motionEvent.getX() - this.startx);
            int n2 = (int)(motionEvent.getY() - this.starty);
            if (!this.isSwipe && !this.isSroll && Math.abs(n) > 50) {
                this.isSwipe = true;
                if (n > 0 && this.distance < 0) {
                    this.toRight = true;
                    this.toLeft = false;
                } else if (n < 0 && this.distance == 0) {
                    int n3 = this.getPosition(motionEvent);
                    if (n3 != -1) {
                        this.add = n3;
                        this.exSize = this.findViewHolderForAdapterPosition((int)n3).itemView.getWidth() - this.getWidth();
                        this.toRight = false;
                        this.toLeft = true;
                    }
                } else if (n < 0 && this.distance < 0) {
                    int n4 = this.getPosition(motionEvent);
                    if (n4 != -1 && n4 != this.add) {
                        this.playLastBack();
                        this.add = n4;
                        this.exSize = this.findViewHolderForAdapterPosition((int)n4).itemView.getWidth() - this.getWidth();
                        this.toRight = false;
                        this.toLeft = true;
                    }
                } else {
                    this.toRight = false;
                    this.toLeft = false;
                }
            } else if (!this.isSroll && !this.isSwipe && Math.abs(n2) > 50) {
                this.isSroll = true;
                this.closeEx();
            }
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.isSroll);
            stringBuilder.append(" ");
            stringBuilder.append(this.isSwipe);
            stringBuilder.append(" ");
            stringBuilder.append(this.toLeft);
            stringBuilder.append(" ");
            stringBuilder.append(this.toRight);
            stringBuilder.append(" ");
            stringBuilder.append(this.distance);
            stringBuilder.append(" ");
            stringBuilder.append(n);
            stringBuilder.append(" ");
            stringBuilder.append(n2);
            printStream.println(stringBuilder.toString());
        } else {
            int n;
            int n5;
            if (this.toRight) {
                n5 = this.distance;
                n = this.exSize;
                if (n5 > n * -2 / 3) {
                    this.playBack(n5, 0);
                } else {
                    this.playBack(n5, -n);
                }
            }
            if (this.toLeft) {
                n5 = this.distance;
                n = this.exSize;
                if (n5 < -n / 3) {
                    this.playBack(n5, -n);
                } else {
                    this.playBack(n5, 0);
                }
            } else {
                this.initData();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int dp2px(int n) {
        float f = this.context.getResources().getDisplayMetrics().density;
        return (int)((float)n * f + 0.5f);
    }

    public int getScreenWidth() {
        WindowManager windowManager = (WindowManager)this.context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public /* synthetic */ void lambda$playBack$0$SwipeRecycler(View view, ValueAnimator valueAnimator) {
        if (this.add == -1) return;
        this.setPaddingLeft(view, (Integer)valueAnimator.getAnimatedValue());
        this.distance = (Integer)valueAnimator.getAnimatedValue();
    }

    public /* synthetic */ void lambda$playLastBack$1$SwipeRecycler(View view, ValueAnimator valueAnimator) {
        this.setPaddingLeft(view, (Integer)valueAnimator.getAnimatedValue());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isSwipe) return true;
        if (!this.isSroll) return super.onInterceptTouchEvent(motionEvent);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 2) {
            if (!this.isSwipe) return super.onTouchEvent(motionEvent);
            return false;
        }
        int n = (int)(motionEvent.getX() - this.startx);
        if (Math.abs((int)(motionEvent.getY() - this.starty)) < 50 && Math.abs(n) < 50) {
            return false;
        }
        if (this.isSroll) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.isSwipe && this.toLeft) {
            this.distance = n;
            this.move();
        }
        if (!this.isSwipe) return false;
        if (!this.toRight) return false;
        this.distance = -this.exSize + n;
        this.move();
        return false;
    }

    public void playLastBack() {
        View view = this.findViewHolderForAdapterPosition((int)this.add).itemView;
        if (view == null) return;
        ValueAnimator valueAnimator = ValueAnimator.ofInt((int[])new int[]{-this.exSize, 0});
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new _$.Lambda.SwipeRecycler.JLqoW8dzScma2sUL0HLm6PQLW9U(this, view));
        valueAnimator.start();
    }
}

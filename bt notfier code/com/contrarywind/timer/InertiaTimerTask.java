/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.contrarywind.view.WheelView
 */
package com.contrarywind.timer;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

public final class InertiaTimerTask
extends TimerTask {
    private float mCurrentVelocityY;
    private final float mFirstVelocityY;
    private final WheelView mWheelView;

    public InertiaTimerTask(WheelView wheelView, float f) {
        this.mWheelView = wheelView;
        this.mFirstVelocityY = f;
        this.mCurrentVelocityY = 2.14748365E9f;
    }

    @Override
    public final void run() {
        float f;
        float f2;
        if (this.mCurrentVelocityY == 2.14748365E9f) {
            f2 = Math.abs(this.mFirstVelocityY);
            f = 2000.0f;
            if (f2 > 2000.0f) {
                if (!(this.mFirstVelocityY > 0.0f)) {
                    f = -2000.0f;
                }
                this.mCurrentVelocityY = f;
            } else {
                this.mCurrentVelocityY = this.mFirstVelocityY;
            }
        }
        if (Math.abs(this.mCurrentVelocityY) >= 0.0f && Math.abs(this.mCurrentVelocityY) <= 20.0f) {
            this.mWheelView.cancelFuture();
            this.mWheelView.getHandler().sendEmptyMessage(2000);
            return;
        }
        int n = (int)(this.mCurrentVelocityY / 100.0f);
        WheelView wheelView = this.mWheelView;
        f = wheelView.getTotalScrollY();
        float f3 = n;
        wheelView.setTotalScrollY(f - f3);
        if (!this.mWheelView.isLoop()) {
            f = this.mWheelView.getItemHeight();
            float f4 = (float)(-this.mWheelView.getInitPosition()) * f;
            float f5 = (float)(this.mWheelView.getItemsCount() - 1 - this.mWheelView.getInitPosition()) * f;
            double d = this.mWheelView.getTotalScrollY();
            double d2 = f;
            Double.isNaN(d2);
            d2 *= 0.25;
            Double.isNaN(d);
            if (d - d2 < (double)f4) {
                f = this.mWheelView.getTotalScrollY() + f3;
                f2 = f5;
            } else {
                d = this.mWheelView.getTotalScrollY();
                Double.isNaN(d);
                f = f4;
                f2 = f5;
                if (d + d2 > (double)f5) {
                    f2 = this.mWheelView.getTotalScrollY() + f3;
                    f = f4;
                }
            }
            if (this.mWheelView.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.mWheelView.setTotalScrollY((float)((int)f));
            } else if (this.mWheelView.getTotalScrollY() >= f2) {
                this.mWheelView.setTotalScrollY((float)((int)f2));
                this.mCurrentVelocityY = -40.0f;
            }
        }
        this.mCurrentVelocityY = (f = this.mCurrentVelocityY) < 0.0f ? f + 20.0f : f - 20.0f;
        this.mWheelView.getHandler().sendEmptyMessage(1000);
    }
}

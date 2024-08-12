/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.contrarywind.view.WheelView
 */
package com.contrarywind.timer;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

public final class SmoothScrollTimerTask
extends TimerTask {
    private int offset;
    private int realOffset;
    private int realTotalOffset;
    private final WheelView wheelView;

    public SmoothScrollTimerTask(WheelView wheelView, int n) {
        this.wheelView = wheelView;
        this.offset = n;
        this.realTotalOffset = Integer.MAX_VALUE;
        this.realOffset = 0;
    }

    @Override
    public final void run() {
        int n;
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        int n2 = this.realTotalOffset;
        this.realOffset = n = (int)((float)n2 * 0.1f);
        if (n == 0) {
            this.realOffset = n2 < 0 ? -1 : 1;
        }
        if (Math.abs(this.realTotalOffset) <= 1) {
            this.wheelView.cancelFuture();
            this.wheelView.getHandler().sendEmptyMessage(3000);
        } else {
            WheelView wheelView = this.wheelView;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + (float)this.realOffset);
            if (!this.wheelView.isLoop()) {
                float f = this.wheelView.getItemHeight();
                float f2 = -this.wheelView.getInitPosition();
                float f3 = this.wheelView.getItemsCount() - 1 - this.wheelView.getInitPosition();
                if (this.wheelView.getTotalScrollY() <= f2 * f || this.wheelView.getTotalScrollY() >= f3 * f) {
                    wheelView = this.wheelView;
                    wheelView.setTotalScrollY(wheelView.getTotalScrollY() - (float)this.realOffset);
                    this.wheelView.cancelFuture();
                    this.wheelView.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.wheelView.getHandler().sendEmptyMessage(1000);
            this.realTotalOffset -= this.realOffset;
        }
    }
}

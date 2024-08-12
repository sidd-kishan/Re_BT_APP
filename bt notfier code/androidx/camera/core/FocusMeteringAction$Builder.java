/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.FocusMeteringAction
 *  androidx.camera.core.MeteringPoint
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.MeteringPoint;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public static class FocusMeteringAction.Builder {
    long mAutoCancelDurationInMillis = 5000L;
    final List<MeteringPoint> mMeteringPointsAe;
    final List<MeteringPoint> mMeteringPointsAf = new ArrayList<MeteringPoint>();
    final List<MeteringPoint> mMeteringPointsAwb;

    public FocusMeteringAction.Builder(MeteringPoint meteringPoint) {
        this(meteringPoint, 7);
    }

    public FocusMeteringAction.Builder(MeteringPoint meteringPoint, int n) {
        this.mMeteringPointsAe = new ArrayList<MeteringPoint>();
        this.mMeteringPointsAwb = new ArrayList<MeteringPoint>();
        this.addPoint(meteringPoint, n);
    }

    public FocusMeteringAction.Builder addPoint(MeteringPoint meteringPoint) {
        return this.addPoint(meteringPoint, 7);
    }

    public FocusMeteringAction.Builder addPoint(MeteringPoint meteringPoint, int n) {
        boolean bl = false;
        boolean bl2 = meteringPoint != null;
        Preconditions.checkArgument((boolean)bl2, (Object)"Point cannot be null.");
        bl2 = bl;
        if (n >= 1) {
            bl2 = bl;
            if (n <= 7) {
                bl2 = true;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid metering mode ");
        stringBuilder.append(n);
        Preconditions.checkArgument((boolean)bl2, (Object)stringBuilder.toString());
        if ((n & 1) != 0) {
            this.mMeteringPointsAf.add(meteringPoint);
        }
        if ((n & 2) != 0) {
            this.mMeteringPointsAe.add(meteringPoint);
        }
        if ((n & 4) == 0) return this;
        this.mMeteringPointsAwb.add(meteringPoint);
        return this;
    }

    public FocusMeteringAction build() {
        return new FocusMeteringAction(this);
    }

    public FocusMeteringAction.Builder disableAutoCancel() {
        this.mAutoCancelDurationInMillis = 0L;
        return this;
    }

    public FocusMeteringAction.Builder setAutoCancelDuration(long l, TimeUnit timeUnit) {
        boolean bl = l >= 1L;
        Preconditions.checkArgument((boolean)bl, (Object)"autoCancelDuration must be at least 1");
        this.mAutoCancelDurationInMillis = timeUnit.toMillis(l);
        return this;
    }
}

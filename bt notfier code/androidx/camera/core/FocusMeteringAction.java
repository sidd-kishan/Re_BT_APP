/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.FocusMeteringAction$Builder
 *  androidx.camera.core.MeteringPoint
 */
package androidx.camera.core;

import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.MeteringPoint;
import java.util.Collections;
import java.util.List;

public final class FocusMeteringAction {
    static final long DEFAULT_AUTOCANCEL_DURATION = 5000L;
    static final int DEFAULT_METERING_MODE = 7;
    public static final int FLAG_AE = 2;
    public static final int FLAG_AF = 1;
    public static final int FLAG_AWB = 4;
    private final long mAutoCancelDurationInMillis;
    private final List<MeteringPoint> mMeteringPointsAe;
    private final List<MeteringPoint> mMeteringPointsAf;
    private final List<MeteringPoint> mMeteringPointsAwb;

    FocusMeteringAction(Builder builder) {
        this.mMeteringPointsAf = Collections.unmodifiableList(builder.mMeteringPointsAf);
        this.mMeteringPointsAe = Collections.unmodifiableList(builder.mMeteringPointsAe);
        this.mMeteringPointsAwb = Collections.unmodifiableList(builder.mMeteringPointsAwb);
        this.mAutoCancelDurationInMillis = builder.mAutoCancelDurationInMillis;
    }

    public long getAutoCancelDurationInMillis() {
        return this.mAutoCancelDurationInMillis;
    }

    public List<MeteringPoint> getMeteringPointsAe() {
        return this.mMeteringPointsAe;
    }

    public List<MeteringPoint> getMeteringPointsAf() {
        return this.mMeteringPointsAf;
    }

    public List<MeteringPoint> getMeteringPointsAwb() {
        return this.mMeteringPointsAwb;
    }

    public boolean isAutoCancelEnabled() {
        boolean bl = this.mAutoCancelDurationInMillis > 0L;
        return bl;
    }
}

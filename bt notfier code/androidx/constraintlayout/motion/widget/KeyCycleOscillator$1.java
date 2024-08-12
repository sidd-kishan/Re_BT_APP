/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$WavePoint
 */
package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import java.util.Comparator;

class KeyCycleOscillator.1
implements Comparator<KeyCycleOscillator.WavePoint> {
    final KeyCycleOscillator this$0;

    KeyCycleOscillator.1(KeyCycleOscillator keyCycleOscillator) {
        this.this$0 = keyCycleOscillator;
    }

    @Override
    public int compare(KeyCycleOscillator.WavePoint wavePoint, KeyCycleOscillator.WavePoint wavePoint2) {
        return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
    }
}

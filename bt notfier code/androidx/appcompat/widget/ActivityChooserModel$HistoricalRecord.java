/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 */
package androidx.appcompat.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public static final class ActivityChooserModel.HistoricalRecord {
    public final ComponentName activity;
    public final long time;
    public final float weight;

    public ActivityChooserModel.HistoricalRecord(ComponentName componentName, long l, float f) {
        this.activity = componentName;
        this.time = l;
        this.weight = f;
    }

    public ActivityChooserModel.HistoricalRecord(String string, long l, float f) {
        this(ComponentName.unflattenFromString((String)string), l, f);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        ActivityChooserModel.HistoricalRecord historicalRecord = (ActivityChooserModel.HistoricalRecord)object;
        object = this.activity;
        if (object == null ? historicalRecord.activity != null : !object.equals((Object)historicalRecord.activity)) {
            return false;
        }
        if (this.time != historicalRecord.time) {
            return false;
        }
        if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight)) return true;
        return false;
    }

    public int hashCode() {
        ComponentName componentName = this.activity;
        int n = componentName == null ? 0 : componentName.hashCode();
        long l = this.time;
        return ((n + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.weight);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("; activity:");
        stringBuilder.append(this.activity);
        stringBuilder.append("; time:");
        stringBuilder.append(this.time);
        stringBuilder.append("; weight:");
        stringBuilder.append(new BigDecimal(this.weight));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

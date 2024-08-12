/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ResolveInfo
 */
package androidx.appcompat.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public static final class ActivityChooserModel.ActivityResolveInfo
implements Comparable<ActivityChooserModel.ActivityResolveInfo> {
    public final ResolveInfo resolveInfo;
    public float weight;

    public ActivityChooserModel.ActivityResolveInfo(ResolveInfo resolveInfo) {
        this.resolveInfo = resolveInfo;
    }

    @Override
    public int compareTo(ActivityChooserModel.ActivityResolveInfo activityResolveInfo) {
        return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
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
        object = (ActivityChooserModel.ActivityResolveInfo)object;
        if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityChooserModel.ActivityResolveInfo)object).weight)) return true;
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.weight) + 31;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("resolveInfo:");
        stringBuilder.append(this.resolveInfo.toString());
        stringBuilder.append("; weight:");
        stringBuilder.append(new BigDecimal(this.weight));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

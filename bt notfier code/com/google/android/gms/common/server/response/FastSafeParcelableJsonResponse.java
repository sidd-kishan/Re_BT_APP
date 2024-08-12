/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelable
 *  com.google.android.gms.common.server.response.FastJsonResponse
 *  com.google.android.gms.common.server.response.FastJsonResponse$Field
 */
package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.Iterator;

public abstract class FastSafeParcelableJsonResponse
extends FastJsonResponse
implements SafeParcelable {
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!((Object)((Object)this)).getClass().isInstance(object)) {
            return false;
        }
        object = (FastJsonResponse)object;
        Iterator iterator = this.getFieldMappings().values().iterator();
        while (iterator.hasNext()) {
            FastJsonResponse.Field field = (FastJsonResponse.Field)iterator.next();
            if (this.isFieldSet(field)) {
                if (!object.isFieldSet(field)) return false;
                if (Objects.equal((Object)this.getFieldValue(field), (Object)object.getFieldValue(field))) continue;
                return false;
            }
            if (object.isFieldSet(field)) return false;
        }
        return true;
    }

    public Object getValueObject(String string) {
        return null;
    }

    public int hashCode() {
        Iterator iterator = this.getFieldMappings().values().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            FastJsonResponse.Field field = (FastJsonResponse.Field)iterator.next();
            if (!this.isFieldSet(field)) continue;
            n = n * 31 + Preconditions.checkNotNull((Object)this.getFieldValue(field)).hashCode();
        }
        return n;
    }

    public boolean isPrimitiveFieldSet(String string) {
        return false;
    }

    public byte[] toByteArray() {
        Parcel parcel = Parcel.obtain();
        this.writeToParcel(parcel, 0);
        byte[] byArray = parcel.marshall();
        parcel.recycle();
        return byArray;
    }
}

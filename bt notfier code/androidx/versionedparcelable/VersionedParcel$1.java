/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.versionedparcelable.VersionedParcel
 */
package androidx.versionedparcelable;

import androidx.versionedparcelable.VersionedParcel;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class VersionedParcel.1
extends ObjectInputStream {
    final VersionedParcel this$0;

    VersionedParcel.1(VersionedParcel versionedParcel, InputStream inputStream) {
        this.this$0 = versionedParcel;
        super(inputStream);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        Class<?> clazz = Class.forName(objectStreamClass.getName(), false, this.getClass().getClassLoader());
        if (clazz == null) return super.resolveClass(objectStreamClass);
        return clazz;
    }
}

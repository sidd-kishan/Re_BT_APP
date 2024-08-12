/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  androidx.versionedparcelable.ParcelImpl
 *  androidx.versionedparcelable.VersionedParcelStream
 *  androidx.versionedparcelable.VersionedParcelable
 */
package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import androidx.versionedparcelable.VersionedParcelStream;
import androidx.versionedparcelable.VersionedParcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ParcelUtils {
    private static final String INNER_BUNDLE_KEY = "a";

    private ParcelUtils() {
    }

    public static <T extends VersionedParcelable> T fromInputStream(InputStream inputStream) {
        return (T)new VersionedParcelStream(inputStream, null).readVersionedParcelable();
    }

    public static <T extends VersionedParcelable> T fromParcelable(Parcelable parcelable) {
        if (!(parcelable instanceof ParcelImpl)) throw new IllegalArgumentException("Invalid parcel");
        return (T)((ParcelImpl)parcelable).getVersionedParcel();
    }

    public static <T extends VersionedParcelable> T getVersionedParcelable(Bundle object, String string) {
        try {
            object = (Bundle)object.getParcelable(string);
            if (object == null) {
                return null;
            }
            object.setClassLoader(ParcelUtils.class.getClassLoader());
            object = ParcelUtils.fromParcelable(object.getParcelable(INNER_BUNDLE_KEY));
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        return (T)object;
    }

    public static <T extends VersionedParcelable> List<T> getVersionedParcelableList(Bundle object, String string) {
        ArrayList<T> arrayList = new ArrayList<T>();
        try {
            object = (Bundle)object.getParcelable(string);
            object.setClassLoader(ParcelUtils.class.getClassLoader());
            object = object.getParcelableArrayList(INNER_BUNDLE_KEY).iterator();
            while (object.hasNext()) {
                arrayList.add(ParcelUtils.fromParcelable((Parcelable)object.next()));
            }
            return arrayList;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    public static void putVersionedParcelable(Bundle bundle, String string, VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(INNER_BUNDLE_KEY, ParcelUtils.toParcelable(versionedParcelable));
        bundle.putParcelable(string, (Parcelable)bundle2);
    }

    public static void putVersionedParcelableList(Bundle bundle, String string, List<? extends VersionedParcelable> object) {
        Bundle bundle2 = new Bundle();
        ArrayList<Parcelable> arrayList = new ArrayList<Parcelable>();
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                bundle2.putParcelableArrayList(INNER_BUNDLE_KEY, arrayList);
                bundle.putParcelable(string, (Parcelable)bundle2);
                return;
            }
            arrayList.add(ParcelUtils.toParcelable((VersionedParcelable)object.next()));
        }
    }

    public static void toOutputStream(VersionedParcelable versionedParcelable, OutputStream outputStream) {
        outputStream = new VersionedParcelStream(null, outputStream);
        outputStream.writeVersionedParcelable(versionedParcelable);
        outputStream.closeField();
    }

    public static Parcelable toParcelable(VersionedParcelable versionedParcelable) {
        return new ParcelImpl(versionedParcelable);
    }
}

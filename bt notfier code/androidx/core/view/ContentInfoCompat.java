/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.ClipDescription
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.Pair
 *  androidx.core.util.Preconditions
 *  androidx.core.util.Predicate
 *  androidx.core.view.ContentInfoCompat$Builder
 */
package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import androidx.core.view.ContentInfoCompat;
import java.util.ArrayList;
import java.util.List;

public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    final ClipData mClip;
    final Bundle mExtras;
    final int mFlags;
    final Uri mLinkUri;
    final int mSource;

    ContentInfoCompat(Builder builder) {
        this.mClip = (ClipData)Preconditions.checkNotNull((Object)builder.mClip);
        this.mSource = Preconditions.checkArgumentInRange((int)builder.mSource, (int)0, (int)3, (String)"source");
        this.mFlags = Preconditions.checkFlagsArgument((int)builder.mFlags, (int)1);
        this.mLinkUri = builder.mLinkUri;
        this.mExtras = builder.mExtras;
    }

    private static ClipData buildClipData(ClipDescription clipDescription, List<ClipData.Item> list) {
        clipDescription = new ClipData(new ClipDescription(clipDescription), list.get(0));
        int n = 1;
        while (n < list.size()) {
            clipDescription.addItem(list.get(n));
            ++n;
        }
        return clipDescription;
    }

    static String flagsToString(int n) {
        if ((n & 1) == 0) return String.valueOf(n);
        return "FLAG_CONVERT_TO_PLAIN_TEXT";
    }

    static String sourceToString(int n) {
        if (n == 0) return "SOURCE_APP";
        if (n == 1) return "SOURCE_CLIPBOARD";
        if (n == 2) return "SOURCE_INPUT_METHOD";
        if (n == 3) return "SOURCE_DRAG_AND_DROP";
        return String.valueOf(n);
    }

    public ClipData getClip() {
        return this.mClip;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public Uri getLinkUri() {
        return this.mLinkUri;
    }

    public int getSource() {
        return this.mSource;
    }

    public Pair<ContentInfoCompat, ContentInfoCompat> partition(Predicate<ClipData.Item> object) {
        int n = this.mClip.getItemCount();
        Object object2 = null;
        if (n == 1) {
            boolean bl = object.test((Object)this.mClip.getItemAt(0));
            object = bl ? this : null;
            if (bl) return Pair.create(object, (Object)object2);
            object2 = this;
            return Pair.create(object, (Object)object2);
        }
        ArrayList<ClipData.Item> arrayList = new ArrayList<ClipData.Item>();
        object2 = new ArrayList();
        for (int i = 0; i < this.mClip.getItemCount(); ++i) {
            ClipData.Item item = this.mClip.getItemAt(i);
            if (object.test((Object)item)) {
                arrayList.add(item);
                continue;
            }
            ((ArrayList)object2).add(item);
        }
        if (arrayList.isEmpty()) {
            return Pair.create(null, (Object)this);
        }
        if (!((ArrayList)object2).isEmpty()) return Pair.create((Object)new Builder(this).setClip(ContentInfoCompat.buildClipData(this.mClip.getDescription(), arrayList)).build(), (Object)new Builder(this).setClip(ContentInfoCompat.buildClipData(this.mClip.getDescription(), (List<ClipData.Item>)object2)).build());
        return Pair.create((Object)this, null);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ContentInfoCompat{clip=");
        stringBuilder.append(this.mClip.getDescription());
        stringBuilder.append(", source=");
        stringBuilder.append(ContentInfoCompat.sourceToString(this.mSource));
        stringBuilder.append(", flags=");
        stringBuilder.append(ContentInfoCompat.flagsToString(this.mFlags));
        Object object = this.mLinkUri;
        String string = "";
        if (object == null) {
            object = "";
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append(", hasLinkUri(");
            ((StringBuilder)object).append(this.mLinkUri.toString().length());
            ((StringBuilder)object).append(")");
            object = ((StringBuilder)object).toString();
        }
        stringBuilder.append((String)object);
        object = this.mExtras == null ? string : ", hasExtras";
        stringBuilder.append((String)object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

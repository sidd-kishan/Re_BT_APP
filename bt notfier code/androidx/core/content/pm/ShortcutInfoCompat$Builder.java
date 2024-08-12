/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ShortcutInfo
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.PersistableBundle
 *  android.text.TextUtils
 *  androidx.core.app.Person
 *  androidx.core.content.LocusIdCompat
 *  androidx.core.content.pm.ShortcutInfoCompat
 *  androidx.core.graphics.drawable.IconCompat
 *  androidx.core.net.UriCompat
 */
package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Exception performing whole class analysis ignored.
 */
public static class ShortcutInfoCompat.Builder {
    private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
    private Set<String> mCapabilityBindings;
    private final ShortcutInfoCompat mInfo;
    private boolean mIsConversation;
    private Uri mSliceUri;

    public ShortcutInfoCompat.Builder(Context shortcutInfoCompat, ShortcutInfo shortcutInfo) {
        ShortcutInfoCompat shortcutInfoCompat2;
        this.mInfo = shortcutInfoCompat2 = new ShortcutInfoCompat();
        shortcutInfoCompat2.mContext = shortcutInfoCompat;
        this.mInfo.mId = shortcutInfo.getId();
        this.mInfo.mPackageName = shortcutInfo.getPackage();
        shortcutInfoCompat = shortcutInfo.getIntents();
        this.mInfo.mIntents = Arrays.copyOf(shortcutInfoCompat, ((Intent[])shortcutInfoCompat).length);
        this.mInfo.mActivity = shortcutInfo.getActivity();
        this.mInfo.mLabel = shortcutInfo.getShortLabel();
        this.mInfo.mLongLabel = shortcutInfo.getLongLabel();
        this.mInfo.mDisabledMessage = shortcutInfo.getDisabledMessage();
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.mDisabledReason = shortcutInfo.getDisabledReason();
        } else {
            shortcutInfoCompat = this.mInfo;
            int n = shortcutInfo.isEnabled() ? 0 : 3;
            shortcutInfoCompat.mDisabledReason = n;
        }
        this.mInfo.mCategories = shortcutInfo.getCategories();
        this.mInfo.mPersons = ShortcutInfoCompat.getPersonsFromExtra((PersistableBundle)shortcutInfo.getExtras());
        this.mInfo.mUser = shortcutInfo.getUserHandle();
        this.mInfo.mLastChangedTimestamp = shortcutInfo.getLastChangedTimestamp();
        if (Build.VERSION.SDK_INT >= 30) {
            this.mInfo.mIsCached = shortcutInfo.isCached();
        }
        this.mInfo.mIsDynamic = shortcutInfo.isDynamic();
        this.mInfo.mIsPinned = shortcutInfo.isPinned();
        this.mInfo.mIsDeclaredInManifest = shortcutInfo.isDeclaredInManifest();
        this.mInfo.mIsImmutable = shortcutInfo.isImmutable();
        this.mInfo.mIsEnabled = shortcutInfo.isEnabled();
        this.mInfo.mHasKeyFieldsOnly = shortcutInfo.hasKeyFieldsOnly();
        this.mInfo.mLocusId = ShortcutInfoCompat.getLocusId((ShortcutInfo)shortcutInfo);
        this.mInfo.mRank = shortcutInfo.getRank();
        this.mInfo.mExtras = shortcutInfo.getExtras();
    }

    public ShortcutInfoCompat.Builder(Context context, String string) {
        ShortcutInfoCompat shortcutInfoCompat;
        this.mInfo = shortcutInfoCompat = new ShortcutInfoCompat();
        shortcutInfoCompat.mContext = context;
        this.mInfo.mId = string;
    }

    public ShortcutInfoCompat.Builder(ShortcutInfoCompat shortcutInfoCompat) {
        ShortcutInfoCompat shortcutInfoCompat2;
        this.mInfo = shortcutInfoCompat2 = new ShortcutInfoCompat();
        shortcutInfoCompat2.mContext = shortcutInfoCompat.mContext;
        this.mInfo.mId = shortcutInfoCompat.mId;
        this.mInfo.mPackageName = shortcutInfoCompat.mPackageName;
        this.mInfo.mIntents = Arrays.copyOf(shortcutInfoCompat.mIntents, shortcutInfoCompat.mIntents.length);
        this.mInfo.mActivity = shortcutInfoCompat.mActivity;
        this.mInfo.mLabel = shortcutInfoCompat.mLabel;
        this.mInfo.mLongLabel = shortcutInfoCompat.mLongLabel;
        this.mInfo.mDisabledMessage = shortcutInfoCompat.mDisabledMessage;
        this.mInfo.mDisabledReason = shortcutInfoCompat.mDisabledReason;
        this.mInfo.mIcon = shortcutInfoCompat.mIcon;
        this.mInfo.mIsAlwaysBadged = shortcutInfoCompat.mIsAlwaysBadged;
        this.mInfo.mUser = shortcutInfoCompat.mUser;
        this.mInfo.mLastChangedTimestamp = shortcutInfoCompat.mLastChangedTimestamp;
        this.mInfo.mIsCached = shortcutInfoCompat.mIsCached;
        this.mInfo.mIsDynamic = shortcutInfoCompat.mIsDynamic;
        this.mInfo.mIsPinned = shortcutInfoCompat.mIsPinned;
        this.mInfo.mIsDeclaredInManifest = shortcutInfoCompat.mIsDeclaredInManifest;
        this.mInfo.mIsImmutable = shortcutInfoCompat.mIsImmutable;
        this.mInfo.mIsEnabled = shortcutInfoCompat.mIsEnabled;
        this.mInfo.mLocusId = shortcutInfoCompat.mLocusId;
        this.mInfo.mIsLongLived = shortcutInfoCompat.mIsLongLived;
        this.mInfo.mHasKeyFieldsOnly = shortcutInfoCompat.mHasKeyFieldsOnly;
        this.mInfo.mRank = shortcutInfoCompat.mRank;
        if (shortcutInfoCompat.mPersons != null) {
            this.mInfo.mPersons = Arrays.copyOf(shortcutInfoCompat.mPersons, shortcutInfoCompat.mPersons.length);
        }
        if (shortcutInfoCompat.mCategories != null) {
            this.mInfo.mCategories = new HashSet(shortcutInfoCompat.mCategories);
        }
        if (shortcutInfoCompat.mExtras == null) return;
        this.mInfo.mExtras = shortcutInfoCompat.mExtras;
    }

    public ShortcutInfoCompat.Builder addCapabilityBinding(String string) {
        if (this.mCapabilityBindings == null) {
            this.mCapabilityBindings = new HashSet<String>();
        }
        this.mCapabilityBindings.add(string);
        return this;
    }

    public ShortcutInfoCompat.Builder addCapabilityBinding(String string, String string2, List<String> list) {
        this.addCapabilityBinding(string);
        if (list.isEmpty()) return this;
        if (this.mCapabilityBindingParams == null) {
            this.mCapabilityBindingParams = new HashMap<String, Map<String, List<String>>>();
        }
        if (this.mCapabilityBindingParams.get(string) == null) {
            this.mCapabilityBindingParams.put(string, new HashMap());
        }
        this.mCapabilityBindingParams.get(string).put(string2, list);
        return this;
    }

    public ShortcutInfoCompat build() {
        Object object;
        if (TextUtils.isEmpty((CharSequence)this.mInfo.mLabel)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Shortcut must have a non-empty label");
            throw illegalArgumentException;
        }
        if (this.mInfo.mIntents == null) throw new IllegalArgumentException("Shortcut must have an intent");
        if (this.mInfo.mIntents.length == 0) throw new IllegalArgumentException("Shortcut must have an intent");
        if (this.mIsConversation) {
            if (this.mInfo.mLocusId == null) {
                object = this.mInfo;
                ((ShortcutInfoCompat)object).mLocusId = new LocusIdCompat(((ShortcutInfoCompat)object).mId);
            }
            this.mInfo.mIsLongLived = true;
        }
        if (this.mCapabilityBindings != null) {
            if (this.mInfo.mCategories == null) {
                this.mInfo.mCategories = new HashSet();
            }
            this.mInfo.mCategories.addAll(this.mCapabilityBindings);
        }
        if (Build.VERSION.SDK_INT < 21) return this.mInfo;
        if (this.mCapabilityBindingParams != null) {
            if (this.mInfo.mExtras == null) {
                this.mInfo.mExtras = new PersistableBundle();
            }
            for (String string : this.mCapabilityBindingParams.keySet()) {
                Map<String, List<String>> map = this.mCapabilityBindingParams.get(string);
                object = map.keySet();
                this.mInfo.mExtras.putStringArray(string, object.toArray(new String[0]));
                for (String string2 : map.keySet()) {
                    object = map.get(string2);
                    PersistableBundle persistableBundle = this.mInfo.mExtras;
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append(string);
                    charSequence.append("/");
                    charSequence.append(string2);
                    charSequence = charSequence.toString();
                    object = object == null ? new String[]{} : object.toArray(new String[0]);
                    persistableBundle.putStringArray((String)charSequence, (String[])object);
                }
            }
        }
        if (this.mSliceUri == null) return this.mInfo;
        if (this.mInfo.mExtras == null) {
            this.mInfo.mExtras = new PersistableBundle();
        }
        this.mInfo.mExtras.putString("extraSliceUri", UriCompat.toSafeString((Uri)this.mSliceUri));
        return this.mInfo;
    }

    public ShortcutInfoCompat.Builder setActivity(ComponentName componentName) {
        this.mInfo.mActivity = componentName;
        return this;
    }

    public ShortcutInfoCompat.Builder setAlwaysBadged() {
        this.mInfo.mIsAlwaysBadged = true;
        return this;
    }

    public ShortcutInfoCompat.Builder setCategories(Set<String> set) {
        this.mInfo.mCategories = set;
        return this;
    }

    public ShortcutInfoCompat.Builder setDisabledMessage(CharSequence charSequence) {
        this.mInfo.mDisabledMessage = charSequence;
        return this;
    }

    public ShortcutInfoCompat.Builder setExtras(PersistableBundle persistableBundle) {
        this.mInfo.mExtras = persistableBundle;
        return this;
    }

    public ShortcutInfoCompat.Builder setIcon(IconCompat iconCompat) {
        this.mInfo.mIcon = iconCompat;
        return this;
    }

    public ShortcutInfoCompat.Builder setIntent(Intent intent) {
        return this.setIntents(new Intent[]{intent});
    }

    public ShortcutInfoCompat.Builder setIntents(Intent[] intentArray) {
        this.mInfo.mIntents = intentArray;
        return this;
    }

    public ShortcutInfoCompat.Builder setIsConversation() {
        this.mIsConversation = true;
        return this;
    }

    public ShortcutInfoCompat.Builder setLocusId(LocusIdCompat locusIdCompat) {
        this.mInfo.mLocusId = locusIdCompat;
        return this;
    }

    public ShortcutInfoCompat.Builder setLongLabel(CharSequence charSequence) {
        this.mInfo.mLongLabel = charSequence;
        return this;
    }

    @Deprecated
    public ShortcutInfoCompat.Builder setLongLived() {
        this.mInfo.mIsLongLived = true;
        return this;
    }

    public ShortcutInfoCompat.Builder setLongLived(boolean bl) {
        this.mInfo.mIsLongLived = bl;
        return this;
    }

    public ShortcutInfoCompat.Builder setPerson(Person person) {
        return this.setPersons(new Person[]{person});
    }

    public ShortcutInfoCompat.Builder setPersons(Person[] personArray) {
        this.mInfo.mPersons = personArray;
        return this;
    }

    public ShortcutInfoCompat.Builder setRank(int n) {
        this.mInfo.mRank = n;
        return this;
    }

    public ShortcutInfoCompat.Builder setShortLabel(CharSequence charSequence) {
        this.mInfo.mLabel = charSequence;
        return this;
    }

    public ShortcutInfoCompat.Builder setSliceUri(Uri uri) {
        this.mSliceUri = uri;
        return this;
    }
}

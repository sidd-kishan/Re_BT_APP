/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Person
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.LocusId
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ShortcutInfo
 *  android.content.pm.ShortcutInfo$Builder
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.os.PersistableBundle
 *  android.os.UserHandle
 *  android.text.TextUtils
 *  androidx.core.app.Person
 *  androidx.core.content.LocusIdCompat
 *  androidx.core.content.pm.ShortcutInfoCompat$Builder
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.content.pm;

import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ShortcutInfoCompat {
    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    ComponentName mActivity;
    Set<String> mCategories;
    Context mContext;
    CharSequence mDisabledMessage;
    int mDisabledReason;
    PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled = true;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    CharSequence mLabel;
    long mLastChangedTimestamp;
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    androidx.core.app.Person[] mPersons;
    int mRank;
    UserHandle mUser;

    ShortcutInfoCompat() {
    }

    private PersistableBundle buildLegacyExtrasBundle() {
        Object object;
        if (this.mExtras == null) {
            this.mExtras = new PersistableBundle();
        }
        if ((object = this.mPersons) != null && ((androidx.core.app.Person[])object).length > 0) {
            this.mExtras.putInt(EXTRA_PERSON_COUNT, ((LocusIdCompat)object).length);
            int n = 0;
            while (n < this.mPersons.length) {
                PersistableBundle persistableBundle = this.mExtras;
                object = new StringBuilder();
                ((StringBuilder)object).append(EXTRA_PERSON_);
                int n2 = n + 1;
                ((StringBuilder)object).append(n2);
                persistableBundle.putPersistableBundle(((StringBuilder)object).toString(), this.mPersons[n].toPersistableBundle());
                n = n2;
            }
        }
        if ((object = this.mLocusId) != null) {
            this.mExtras.putString(EXTRA_LOCUS_ID, object.getId());
        }
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    }

    static List<ShortcutInfoCompat> fromShortcuts(Context context, List<ShortcutInfo> object) {
        ArrayList<ShortcutInfoCompat> arrayList = new ArrayList<ShortcutInfoCompat>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(new Builder(context, (ShortcutInfo)object.next()).build());
        }
        return arrayList;
    }

    static LocusIdCompat getLocusId(ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT < 29) return ShortcutInfoCompat.getLocusIdFromExtra(shortcutInfo.getExtras());
        if (shortcutInfo.getLocusId() != null) return LocusIdCompat.toLocusIdCompat((LocusId)shortcutInfo.getLocusId());
        return null;
    }

    private static LocusIdCompat getLocusIdFromExtra(PersistableBundle object) {
        Object var1_1 = null;
        if (object == null) {
            return null;
        }
        object = (object = object.getString(EXTRA_LOCUS_ID)) == null ? var1_1 : new LocusIdCompat((String)object);
        return object;
    }

    static boolean getLongLivedFromExtra(PersistableBundle persistableBundle) {
        if (persistableBundle == null) return false;
        if (persistableBundle.containsKey(EXTRA_LONG_LIVED)) return persistableBundle.getBoolean(EXTRA_LONG_LIVED);
        return false;
    }

    static androidx.core.app.Person[] getPersonsFromExtra(PersistableBundle persistableBundle) {
        if (persistableBundle == null) return null;
        if (!persistableBundle.containsKey(EXTRA_PERSON_COUNT)) {
            return null;
        }
        int n = persistableBundle.getInt(EXTRA_PERSON_COUNT);
        androidx.core.app.Person[] personArray = new androidx.core.app.Person[n];
        int n2 = 0;
        while (n2 < n) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(EXTRA_PERSON_);
            int n3 = n2 + 1;
            stringBuilder.append(n3);
            personArray[n2] = androidx.core.app.Person.fromPersistableBundle((PersistableBundle)persistableBundle.getPersistableBundle(stringBuilder.toString()));
            n2 = n3;
        }
        return personArray;
    }

    Intent addToIntent(Intent intent) {
        Drawable drawable = this.mIntents;
        intent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)drawable[((Intent[])drawable).length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon == null) return intent;
        Drawable drawable2 = null;
        Object var4_5 = null;
        if (this.mIsAlwaysBadged) {
            PackageManager packageManager = this.mContext.getPackageManager();
            drawable2 = this.mActivity;
            drawable = var4_5;
            if (drawable2 != null) {
                try {
                    drawable = packageManager.getActivityIcon((ComponentName)drawable2);
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    drawable = var4_5;
                }
            }
            drawable2 = drawable;
            if (drawable == null) {
                drawable2 = this.mContext.getApplicationInfo().loadIcon(packageManager);
            }
        }
        this.mIcon.addToShortcutIntent(intent, drawable2, this.mContext);
        return intent;
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public Set<String> getCategories() {
        return this.mCategories;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getId() {
        return this.mId;
    }

    public Intent getIntent() {
        Intent[] intentArray = this.mIntents;
        return intentArray[intentArray.length - 1];
    }

    public Intent[] getIntents() {
        Intent[] intentArray = this.mIntents;
        return Arrays.copyOf(intentArray, intentArray.length);
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public String getPackage() {
        return this.mPackageName;
    }

    public int getRank() {
        return this.mRank;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder builder = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            builder.setIcon(iconCompat.toIcon(this.mContext));
        }
        if (!TextUtils.isEmpty((CharSequence)this.mLongLabel)) {
            builder.setLongLabel(this.mLongLabel);
        }
        if (!TextUtils.isEmpty((CharSequence)this.mDisabledMessage)) {
            builder.setDisabledMessage(this.mDisabledMessage);
        }
        if ((iconCompat = this.mActivity) != null) {
            builder.setActivity((ComponentName)iconCompat);
        }
        if ((iconCompat = this.mCategories) != null) {
            builder.setCategories((Set)iconCompat);
        }
        builder.setRank(this.mRank);
        iconCompat = this.mExtras;
        if (iconCompat != null) {
            builder.setExtras((PersistableBundle)iconCompat);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            iconCompat = this.mPersons;
            if (iconCompat != null && ((androidx.core.app.Person[])iconCompat).length > 0) {
                int n = ((LocusIdCompat)iconCompat).length;
                iconCompat = new Person[n];
                for (int i = 0; i < n; ++i) {
                    iconCompat[i] = this.mPersons[i].toAndroidPerson();
                }
                builder.setPersons((Person[])iconCompat);
            }
            if ((iconCompat = this.mLocusId) != null) {
                builder.setLocusId(iconCompat.toLocusId());
            }
            builder.setLongLived(this.mIsLongLived);
        } else {
            builder.setExtras(this.buildLegacyExtrasBundle());
        }
        return builder.build();
    }
}

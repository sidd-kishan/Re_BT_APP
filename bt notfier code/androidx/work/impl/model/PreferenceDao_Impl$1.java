/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.work.impl.model.Preference
 *  androidx.work.impl.model.PreferenceDao_Impl
 */
package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao_Impl;

class PreferenceDao_Impl.1
extends EntityInsertionAdapter<Preference> {
    final PreferenceDao_Impl this$0;

    PreferenceDao_Impl.1(PreferenceDao_Impl preferenceDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = preferenceDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Preference preference) {
        if (preference.mKey == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, preference.mKey);
        }
        if (preference.mValue == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindLong(2, preference.mValue.longValue());
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
    }
}

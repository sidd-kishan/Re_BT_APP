/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.sqlite.db.SimpleSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.work.WorkInfo$State
 *  androidx.work.WorkQuery
 *  androidx.work.impl.model.WorkTypeConverters
 */
package androidx.work.impl.utils;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class RawQueries {
    private RawQueries() {
    }

    private static void bindings(StringBuilder stringBuilder, int n) {
        if (n <= 0) {
            return;
        }
        stringBuilder.append("?");
        int n2 = 1;
        while (n2 < n) {
            stringBuilder.append(",");
            stringBuilder.append("?");
            ++n2;
        }
    }

    public static SupportSQLiteQuery workQueryToRawQuery(WorkQuery object) {
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM workspec");
        Object object2 = object.getStates();
        boolean bl = object2.isEmpty();
        String string = " AND";
        Object object3 = " WHERE";
        if (!bl) {
            object3 = new ArrayList(object2.size());
            object2 = object2.iterator();
            while (object2.hasNext()) {
                object3.add(WorkTypeConverters.stateToInt((WorkInfo.State)((WorkInfo.State)object2.next())));
            }
            stringBuilder.append(" WHERE");
            stringBuilder.append(" state IN (");
            RawQueries.bindings(stringBuilder, object3.size());
            stringBuilder.append(")");
            arrayList.addAll(object3);
            object3 = " AND";
        }
        List list = object.getIds();
        object2 = object3;
        if (!list.isEmpty()) {
            object2 = new ArrayList(list.size());
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                object2.add(((UUID)iterator.next()).toString());
            }
            stringBuilder.append((String)object3);
            stringBuilder.append(" id IN (");
            RawQueries.bindings(stringBuilder, list.size());
            stringBuilder.append(")");
            arrayList.addAll(object2);
            object2 = " AND";
        }
        if (!(object3 = object.getTags()).isEmpty()) {
            stringBuilder.append((String)object2);
            stringBuilder.append(" id IN (SELECT work_spec_id FROM worktag WHERE tag IN (");
            RawQueries.bindings(stringBuilder, object3.size());
            stringBuilder.append("))");
            arrayList.addAll(object3);
            object3 = string;
        } else {
            object3 = object2;
        }
        object = object.getUniqueWorkNames();
        if (!object.isEmpty()) {
            stringBuilder.append((String)object3);
            stringBuilder.append(" id IN (SELECT work_spec_id FROM workname WHERE name IN (");
            RawQueries.bindings(stringBuilder, object.size());
            stringBuilder.append("))");
            arrayList.addAll(object);
        }
        stringBuilder.append(";");
        return new SimpleSQLiteQuery(stringBuilder.toString(), arrayList.toArray());
    }
}

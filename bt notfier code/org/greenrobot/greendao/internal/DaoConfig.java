/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.Property
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.identityscope.IdentityScope
 *  org.greenrobot.greendao.identityscope.IdentityScopeLong
 *  org.greenrobot.greendao.identityscope.IdentityScopeObject
 *  org.greenrobot.greendao.identityscope.IdentityScopeType
 *  org.greenrobot.greendao.internal.TableStatements
 */
package org.greenrobot.greendao.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.identityscope.IdentityScopeObject;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.TableStatements;

public final class DaoConfig
implements Cloneable {
    public final String[] allColumns;
    public final Database db;
    private IdentityScope<?, ?> identityScope;
    public final boolean keyIsNumeric;
    public final String[] nonPkColumns;
    public final String[] pkColumns;
    public final Property pkProperty;
    public final Property[] properties;
    public final TableStatements statements;
    public final String tablename;

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public DaoConfig(Database object, Class<? extends AbstractDao<?, ?>> tableStatements) {
        this.db = object;
        try {
            TableStatements tableStatements2 = tableStatements.getField("TABLENAME");
            TableStatements tableStatements3 = null;
            this.tablename = (String)tableStatements2.get(null);
            Property[] propertyArray = DaoConfig.reflectProperties(tableStatements);
            this.properties = propertyArray;
            this.allColumns = new String[propertyArray.length];
            ArrayList<String> arrayList = new ArrayList<String>();
            ArrayList<String> arrayList2 = new ArrayList<String>();
            boolean bl = false;
            tableStatements = null;
            for (int i = 0; i < propertyArray.length; ++i) {
                String string;
                tableStatements2 = propertyArray[i];
                this.allColumns[i] = string = tableStatements2.columnName;
                if (tableStatements2.primaryKey) {
                    arrayList.add(string);
                    tableStatements = tableStatements2;
                    continue;
                }
                arrayList2.add(string);
            }
            this.nonPkColumns = arrayList2.toArray(new String[arrayList2.size()]);
            tableStatements2 = arrayList.toArray(new String[arrayList.size()]);
            this.pkColumns = tableStatements2;
            if (((String[])tableStatements2).length == 1) {
                tableStatements3 = tableStatements;
            }
            this.pkProperty = tableStatements3;
            this.statements = tableStatements = new TableStatements((Database)object, this.tablename, this.allColumns, this.pkColumns);
            if (this.pkProperty == null) {
                this.keyIsNumeric = false;
                return;
            }
            object = this.pkProperty.type;
            if (object.equals(Long.TYPE) || object.equals(Long.class) || object.equals(Integer.TYPE) || object.equals(Integer.class) || object.equals(Short.TYPE) || object.equals(Short.class) || object.equals(Byte.TYPE) || object.equals(Byte.class)) {
                bl = true;
            }
            this.keyIsNumeric = bl;
            return;
        }
        catch (Exception exception) {
            DaoException daoException = new DaoException("Could not init DAOConfig", (Throwable)exception);
            throw daoException;
        }
    }

    public DaoConfig(DaoConfig daoConfig) {
        this.db = daoConfig.db;
        this.tablename = daoConfig.tablename;
        this.properties = daoConfig.properties;
        this.allColumns = daoConfig.allColumns;
        this.pkColumns = daoConfig.pkColumns;
        this.nonPkColumns = daoConfig.nonPkColumns;
        this.pkProperty = daoConfig.pkProperty;
        this.statements = daoConfig.statements;
        this.keyIsNumeric = daoConfig.keyIsNumeric;
    }

    private static Property[] reflectProperties(Class<? extends AbstractDao<?, ?>> serializable) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        Field[] fieldArray = new StringBuilder();
        fieldArray.append(((Class)serializable).getName());
        fieldArray.append("$Properties");
        fieldArray = Class.forName(fieldArray.toString()).getDeclaredFields();
        serializable = new ArrayList();
        for (Field field : fieldArray) {
            Object object;
            if ((field.getModifiers() & 9) != 9 || !((object = field.get(null)) instanceof Property)) continue;
            ((ArrayList)serializable).add((Property)object);
        }
        fieldArray = new Property[((ArrayList)serializable).size()];
        Iterator iterator = ((ArrayList)serializable).iterator();
        while (iterator.hasNext()) {
            serializable = (Property)iterator.next();
            if (fieldArray[((Property)serializable).ordinal] != null) throw new DaoException("Duplicate property ordinals");
            fieldArray[((Property)serializable).ordinal] = serializable;
        }
        return fieldArray;
    }

    public void clearIdentityScope() {
        IdentityScope<?, ?> identityScope = this.identityScope;
        if (identityScope == null) return;
        identityScope.clear();
    }

    public DaoConfig clone() {
        return new DaoConfig(this);
    }

    public IdentityScope<?, ?> getIdentityScope() {
        return this.identityScope;
    }

    public void initIdentityScope(IdentityScopeType identityScopeType) {
        if (identityScopeType == IdentityScopeType.None) {
            this.identityScope = null;
        } else {
            if (identityScopeType != IdentityScopeType.Session) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported type: ");
                stringBuilder.append(identityScopeType);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.identityScope = this.keyIsNumeric ? new IdentityScopeLong() : new IdentityScopeObject();
        }
    }

    public void setIdentityScope(IdentityScope<?, ?> identityScope) {
        this.identityScope = identityScope;
    }
}

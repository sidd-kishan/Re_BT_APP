/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.test.AbstractDaoTestSinglePk
 */
package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.test.AbstractDaoTestSinglePk;

public abstract class AbstractDaoTestStringPk<D extends AbstractDao<T, String>, T>
extends AbstractDaoTestSinglePk<D, T, String> {
    public AbstractDaoTestStringPk(Class<D> clazz) {
        super(clazz);
    }

    protected String createRandomPk() {
        int n = this.random.nextInt(30);
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        while (n2 < n + 1) {
            stringBuilder.append((char)(this.random.nextInt(25) + 97));
            ++n2;
        }
        return stringBuilder.toString();
    }
}

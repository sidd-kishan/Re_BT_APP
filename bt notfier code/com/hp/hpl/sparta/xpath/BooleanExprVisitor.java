/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.AttrEqualsExpr
 *  com.hp.hpl.sparta.xpath.AttrExistsExpr
 *  com.hp.hpl.sparta.xpath.AttrGreaterExpr
 *  com.hp.hpl.sparta.xpath.AttrLessExpr
 *  com.hp.hpl.sparta.xpath.AttrNotEqualsExpr
 *  com.hp.hpl.sparta.xpath.PositionEqualsExpr
 *  com.hp.hpl.sparta.xpath.TextEqualsExpr
 *  com.hp.hpl.sparta.xpath.TextExistsExpr
 *  com.hp.hpl.sparta.xpath.TextNotEqualsExpr
 *  com.hp.hpl.sparta.xpath.TrueExpr
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.hp.hpl.sparta.xpath.AttrExistsExpr;
import com.hp.hpl.sparta.xpath.AttrGreaterExpr;
import com.hp.hpl.sparta.xpath.AttrLessExpr;
import com.hp.hpl.sparta.xpath.AttrNotEqualsExpr;
import com.hp.hpl.sparta.xpath.PositionEqualsExpr;
import com.hp.hpl.sparta.xpath.TextEqualsExpr;
import com.hp.hpl.sparta.xpath.TextExistsExpr;
import com.hp.hpl.sparta.xpath.TextNotEqualsExpr;
import com.hp.hpl.sparta.xpath.TrueExpr;
import com.hp.hpl.sparta.xpath.XPathException;

public interface BooleanExprVisitor {
    public void visit(AttrEqualsExpr var1) throws XPathException;

    public void visit(AttrExistsExpr var1) throws XPathException;

    public void visit(AttrGreaterExpr var1) throws XPathException;

    public void visit(AttrLessExpr var1) throws XPathException;

    public void visit(AttrNotEqualsExpr var1) throws XPathException;

    public void visit(PositionEqualsExpr var1) throws XPathException;

    public void visit(TextEqualsExpr var1) throws XPathException;

    public void visit(TextExistsExpr var1) throws XPathException;

    public void visit(TextNotEqualsExpr var1) throws XPathException;

    public void visit(TrueExpr var1);
}

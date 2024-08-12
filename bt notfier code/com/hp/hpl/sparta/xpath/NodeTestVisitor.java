/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.AllElementTest
 *  com.hp.hpl.sparta.xpath.AttrTest
 *  com.hp.hpl.sparta.xpath.ElementTest
 *  com.hp.hpl.sparta.xpath.ParentNodeTest
 *  com.hp.hpl.sparta.xpath.TextTest
 *  com.hp.hpl.sparta.xpath.ThisNodeTest
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.AllElementTest;
import com.hp.hpl.sparta.xpath.AttrTest;
import com.hp.hpl.sparta.xpath.ElementTest;
import com.hp.hpl.sparta.xpath.ParentNodeTest;
import com.hp.hpl.sparta.xpath.TextTest;
import com.hp.hpl.sparta.xpath.ThisNodeTest;
import com.hp.hpl.sparta.xpath.XPathException;

public interface NodeTestVisitor {
    public void visit(AllElementTest var1);

    public void visit(AttrTest var1);

    public void visit(ElementTest var1);

    public void visit(ParentNodeTest var1) throws XPathException;

    public void visit(TextTest var1);

    public void visit(ThisNodeTest var1);
}

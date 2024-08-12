/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.xpath.AttrEqualsExpr
 *  com.hp.hpl.sparta.xpath.AttrExistsExpr
 *  com.hp.hpl.sparta.xpath.AttrGreaterExpr
 *  com.hp.hpl.sparta.xpath.AttrLessExpr
 *  com.hp.hpl.sparta.xpath.AttrNotEqualsExpr
 *  com.hp.hpl.sparta.xpath.BooleanExpr
 *  com.hp.hpl.sparta.xpath.PositionEqualsExpr
 *  com.hp.hpl.sparta.xpath.SimpleStreamTokenizer
 *  com.hp.hpl.sparta.xpath.TextEqualsExpr
 *  com.hp.hpl.sparta.xpath.TextExistsExpr
 *  com.hp.hpl.sparta.xpath.TextNotEqualsExpr
 *  com.hp.hpl.sparta.xpath.XPath
 *  com.hp.hpl.sparta.xpath.XPathException
 */
package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.hp.hpl.sparta.xpath.AttrExistsExpr;
import com.hp.hpl.sparta.xpath.AttrGreaterExpr;
import com.hp.hpl.sparta.xpath.AttrLessExpr;
import com.hp.hpl.sparta.xpath.AttrNotEqualsExpr;
import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.PositionEqualsExpr;
import com.hp.hpl.sparta.xpath.SimpleStreamTokenizer;
import com.hp.hpl.sparta.xpath.TextEqualsExpr;
import com.hp.hpl.sparta.xpath.TextExistsExpr;
import com.hp.hpl.sparta.xpath.TextNotEqualsExpr;
import com.hp.hpl.sparta.xpath.XPath;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;

public class ExprFactory {
    static BooleanExpr createExpr(XPath object, SimpleStreamTokenizer simpleStreamTokenizer) throws XPathException, IOException {
        int n = simpleStreamTokenizer.ttype;
        if (n != -3) {
            if (n == -2) {
                n = simpleStreamTokenizer.nval;
                simpleStreamTokenizer.nextToken();
                return new PositionEqualsExpr(n);
            }
            if (n != 64) throw new XPathException(object, "at beginning of expression", simpleStreamTokenizer, "@, number, or text()");
            if (simpleStreamTokenizer.nextToken() != -3) throw new XPathException(object, "after @", simpleStreamTokenizer, "name");
            String string = simpleStreamTokenizer.sval;
            n = simpleStreamTokenizer.nextToken();
            if (n != 33) {
                switch (n) {
                    default: {
                        return new AttrExistsExpr(string);
                    }
                    case 62: {
                        simpleStreamTokenizer.nextToken();
                        if (simpleStreamTokenizer.ttype != 34 && simpleStreamTokenizer.ttype != 39) {
                            if (simpleStreamTokenizer.ttype != -2) throw new XPathException(object, "right hand side of greater-than", simpleStreamTokenizer, "quoted string or number");
                            n = simpleStreamTokenizer.nval;
                        } else {
                            n = Integer.parseInt(simpleStreamTokenizer.sval);
                        }
                        simpleStreamTokenizer.nextToken();
                        return new AttrGreaterExpr(string, n);
                    }
                    case 61: {
                        simpleStreamTokenizer.nextToken();
                        if (simpleStreamTokenizer.ttype != 34) {
                            if (simpleStreamTokenizer.ttype != 39) throw new XPathException(object, "right hand side of equals", simpleStreamTokenizer, "quoted string");
                        }
                        object = simpleStreamTokenizer.sval;
                        simpleStreamTokenizer.nextToken();
                        return new AttrEqualsExpr(string, (String)object);
                    }
                    case 60: 
                }
                simpleStreamTokenizer.nextToken();
                if (simpleStreamTokenizer.ttype != 34 && simpleStreamTokenizer.ttype != 39) {
                    if (simpleStreamTokenizer.ttype != -2) throw new XPathException(object, "right hand side of less-than", simpleStreamTokenizer, "quoted string or number");
                    n = simpleStreamTokenizer.nval;
                } else {
                    n = Integer.parseInt(simpleStreamTokenizer.sval);
                }
                simpleStreamTokenizer.nextToken();
                return new AttrLessExpr(string, n);
            }
            simpleStreamTokenizer.nextToken();
            if (simpleStreamTokenizer.ttype != 61) throw new XPathException(object, "after !", simpleStreamTokenizer, "=");
            simpleStreamTokenizer.nextToken();
            if (simpleStreamTokenizer.ttype != 34) {
                if (simpleStreamTokenizer.ttype != 39) throw new XPathException(object, "right hand side of !=", simpleStreamTokenizer, "quoted string");
            }
            object = simpleStreamTokenizer.sval;
            simpleStreamTokenizer.nextToken();
            return new AttrNotEqualsExpr(string, (String)object);
        }
        if (!simpleStreamTokenizer.sval.equals("text")) throw new XPathException(object, "at beginning of expression", simpleStreamTokenizer, "text()");
        if (simpleStreamTokenizer.nextToken() != 40) throw new XPathException(object, "after text", simpleStreamTokenizer, "(");
        if (simpleStreamTokenizer.nextToken() != 41) throw new XPathException(object, "after text(", simpleStreamTokenizer, ")");
        n = simpleStreamTokenizer.nextToken();
        if (n != 33) {
            if (n != 61) {
                return TextExistsExpr.INSTANCE;
            }
            simpleStreamTokenizer.nextToken();
            if (simpleStreamTokenizer.ttype != 34) {
                if (simpleStreamTokenizer.ttype != 39) throw new XPathException(object, "right hand side of equals", simpleStreamTokenizer, "quoted string");
            }
            object = simpleStreamTokenizer.sval;
            simpleStreamTokenizer.nextToken();
            return new TextEqualsExpr((String)object);
        }
        simpleStreamTokenizer.nextToken();
        if (simpleStreamTokenizer.ttype != 61) throw new XPathException(object, "after !", simpleStreamTokenizer, "=");
        simpleStreamTokenizer.nextToken();
        if (simpleStreamTokenizer.ttype != 34) {
            if (simpleStreamTokenizer.ttype != 39) throw new XPathException(object, "right hand side of !=", simpleStreamTokenizer, "quoted string");
        }
        object = simpleStreamTokenizer.sval;
        simpleStreamTokenizer.nextToken();
        return new TextNotEqualsExpr((String)object);
    }
}

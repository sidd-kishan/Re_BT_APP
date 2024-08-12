/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.CharCircBuffer
 *  com.hp.hpl.sparta.Element
 *  com.hp.hpl.sparta.EncodingMismatchException
 *  com.hp.hpl.sparta.ParseException
 *  com.hp.hpl.sparta.ParseHandler
 *  com.hp.hpl.sparta.ParseLog
 *  com.hp.hpl.sparta.ParseSource
 *  com.hp.hpl.sparta.Sparta
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.CharCircBuffer;
import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.EncodingMismatchException;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.ParseHandler;
import com.hp.hpl.sparta.ParseLog;
import com.hp.hpl.sparta.ParseSource;
import com.hp.hpl.sparta.Sparta;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;

class ParseCharStream
implements ParseSource {
    private static final char[] BEGIN_CDATA;
    private static final char[] BEGIN_ETAG;
    private static final char[] CHARREF_BEGIN;
    private static final char[] COMMENT_BEGIN;
    private static final char[] COMMENT_END;
    private static final boolean DEBUG = true;
    private static final char[] DOCTYPE_BEGIN;
    private static final char[] ENCODING;
    private static final char[] END_CDATA;
    private static final char[] END_EMPTYTAG;
    private static final char[] ENTITY_BEGIN;
    public static final int HISTORY_LENGTH = 100;
    private static final boolean H_DEBUG = false;
    private static final boolean[] IS_NAME_CHAR;
    private static final char[] MARKUPDECL_BEGIN;
    private static final int MAX_COMMON_CHAR = 128;
    private static final char[] NAME_PUNCT_CHARS;
    private static final char[] NDATA;
    private static final char[] PI_BEGIN;
    private static final char[] PUBLIC;
    private static final char[] QU_END;
    private static final char[] SYSTEM;
    private static final int TMP_BUF_SIZE = 255;
    private static final char[] VERSION;
    private static final char[] VERSIONNUM_PUNC_CHARS;
    private static final char[] XML_BEGIN;
    private final int CBUF_SIZE;
    private final char[] cbuf_;
    private int ch_ = -2;
    private int curPos_ = 0;
    private String docTypeName_ = null;
    private final String encoding_;
    private int endPos_ = 0;
    private final Hashtable entities_ = new Hashtable();
    private boolean eos_ = false;
    private final ParseHandler handler_;
    private final CharCircBuffer history_ = null;
    private boolean isExternalDtd_ = false;
    private int lineNumber_ = 1;
    private final ParseLog log_;
    private final Hashtable pes_ = new Hashtable();
    private final Reader reader_;
    private String systemId_;
    private final char[] tmpBuf_ = new char[255];

    static {
        NAME_PUNCT_CHARS = new char[]{'.', '-', '_', ':'};
        IS_NAME_CHAR = new boolean[128];
        char c = '\u0000';
        while (true) {
            if (c >= '\u0080') {
                COMMENT_BEGIN = "<!--".toCharArray();
                COMMENT_END = "-->".toCharArray();
                PI_BEGIN = "<?".toCharArray();
                QU_END = "?>".toCharArray();
                DOCTYPE_BEGIN = "<!DOCTYPE".toCharArray();
                XML_BEGIN = "<?xml".toCharArray();
                ENCODING = "encoding".toCharArray();
                VERSION = "version".toCharArray();
                VERSIONNUM_PUNC_CHARS = new char[]{'_', '.', ':', '-'};
                MARKUPDECL_BEGIN = "<!".toCharArray();
                CHARREF_BEGIN = "&#".toCharArray();
                ENTITY_BEGIN = "<!ENTITY".toCharArray();
                NDATA = "NDATA".toCharArray();
                SYSTEM = "SYSTEM".toCharArray();
                PUBLIC = "PUBLIC".toCharArray();
                BEGIN_CDATA = "<![CDATA[".toCharArray();
                END_CDATA = "]]>".toCharArray();
                END_EMPTYTAG = "/>".toCharArray();
                BEGIN_ETAG = "</".toCharArray();
                return;
            }
            ParseCharStream.IS_NAME_CHAR[c] = ParseCharStream.isNameChar(c);
            c = (char)(c + '\u0001');
        }
    }

    public ParseCharStream(String string, Reader reader, ParseLog parseLog, String string2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this(string, reader, null, parseLog, string2, parseHandler);
    }

    public ParseCharStream(String object, Reader object2, char[] object3, ParseLog object4, String string, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this.CBUF_SIZE = 1024;
        ParseLog parseLog = object4;
        if (object4 == null) {
            parseLog = ParseSource.DEFAULT_LOG;
        }
        this.log_ = parseLog;
        object4 = string == null ? null : string.toLowerCase();
        this.encoding_ = object4;
        this.entities_.put("lt", "<");
        this.entities_.put("gt", ">");
        this.entities_.put("amp", "&");
        this.entities_.put("apos", "'");
        this.entities_.put("quot", "\"");
        if (object3 != null) {
            this.cbuf_ = object3;
            this.curPos_ = 0;
            this.endPos_ = ((char[])object3).length;
            this.eos_ = true;
            this.reader_ = null;
        } else {
            this.reader_ = object2;
            this.cbuf_ = new char[1024];
            this.fillBuf();
        }
        this.systemId_ = object;
        this.handler_ = parseHandler;
        parseHandler.setParseSource((ParseSource)this);
        this.readProlog();
        this.handler_.startDocument();
        object = this.readElement();
        object2 = this.docTypeName_;
        if (object2 != null && !((String)object2).equals(object.getTagName())) {
            object3 = this.log_;
            object2 = new StringBuffer();
            ((StringBuffer)object2).append("DOCTYPE name \"");
            ((StringBuffer)object2).append(this.docTypeName_);
            ((StringBuffer)object2).append("\" not same as tag name, \"");
            ((StringBuffer)object2).append(object.getTagName());
            ((StringBuffer)object2).append("\" of root element");
            object3.warning(((StringBuffer)object2).toString(), this.systemId_, this.getLineNumber());
        }
        while (true) {
            if (!this.isMisc()) {
                object = this.reader_;
                if (object != null) {
                    ((Reader)object).close();
                }
                this.handler_.endDocument();
                return;
            }
            this.readMisc();
        }
    }

    public ParseCharStream(String string, char[] cArray, ParseLog parseLog, String string2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this(string, null, cArray, parseLog, string2, parseHandler);
    }

    private int fillBuf() throws IOException {
        if (this.eos_) {
            return -1;
        }
        if (this.endPos_ == this.cbuf_.length) {
            this.endPos_ = 0;
            this.curPos_ = 0;
        }
        Reader reader = this.reader_;
        char[] cArray = this.cbuf_;
        int n = this.endPos_;
        if ((n = reader.read(cArray, n, cArray.length - n)) <= 0) {
            this.eos_ = true;
            return -1;
        }
        this.endPos_ += n;
        return n;
    }

    private int fillBuf(int n) throws IOException {
        if (this.eos_) {
            return -1;
        }
        int n2 = this.cbuf_.length;
        int n3 = this.curPos_;
        int n4 = 0;
        if (n2 - n3 < n) {
            n = 0;
            while (true) {
                if ((n3 = this.curPos_) + n >= (n4 = this.endPos_)) {
                    this.endPos_ = n4 -= n3;
                    this.curPos_ = 0;
                    break;
                }
                char[] cArray = this.cbuf_;
                cArray[n] = cArray[n3 + n];
                ++n;
            }
        }
        if ((n = this.fillBuf()) != -1) return n4 + n;
        if (n4 != 0) return n4;
        return -1;
    }

    private boolean isCdSect() throws ParseException, IOException {
        return this.isSymbol(BEGIN_CDATA);
    }

    private final boolean isChar(char c) throws ParseException, IOException {
        if (this.curPos_ >= this.endPos_) {
            if (this.fillBuf() == -1) throw new ParseException(this, "unexpected end of expression.");
        }
        boolean bl = this.cbuf_[this.curPos_] == c;
        return bl;
    }

    private final boolean isChar(char c, char c2) throws ParseException, IOException {
        int n = this.curPos_;
        int n2 = this.endPos_;
        boolean bl = false;
        if (n >= n2 && this.fillBuf() == -1) {
            return false;
        }
        n = this.cbuf_[this.curPos_];
        if (n != c) {
            if (n != c2) return bl;
        }
        bl = true;
        return bl;
    }

    private final boolean isChar(char c, char c2, char c3, char c4) throws ParseException, IOException {
        int n = this.curPos_;
        int n2 = this.endPos_;
        boolean bl = false;
        if (n >= n2 && this.fillBuf() == -1) {
            return false;
        }
        n = this.cbuf_[this.curPos_];
        if (n != c && n != c2 && n != c3) {
            if (n != c4) return bl;
        }
        bl = true;
        return bl;
    }

    private final boolean isComment() throws ParseException, IOException {
        return this.isSymbol(COMMENT_BEGIN);
    }

    private boolean isDeclSep() throws ParseException, IOException {
        boolean bl = this.isPeReference() || this.isS();
        return bl;
    }

    private boolean isDocTypeDecl() throws ParseException, IOException {
        return this.isSymbol(DOCTYPE_BEGIN);
    }

    private boolean isETag() throws ParseException, IOException {
        return this.isSymbol(BEGIN_ETAG);
    }

    private boolean isEncodingDecl() throws ParseException, IOException {
        return this.isSymbol(ENCODING);
    }

    private boolean isEntityDecl() throws ParseException, IOException {
        return this.isSymbol(ENTITY_BEGIN);
    }

    private final boolean isEntityValue() throws ParseException, IOException {
        return this.isChar('\'', '\"');
    }

    private static boolean isExtender(char c) {
        if (c == '\u00b7') return true;
        if (c == '\u0387') return true;
        if (c == '\u0640') return true;
        if (c == '\u0e46') return true;
        if (c == '\u0ec6') return true;
        if (c == '\u3005') return true;
        if (c == '\u02d0') return true;
        if (c == '\u02d1') return true;
        if (c == '\u309d') return true;
        if (c == '\u309e') return true;
        switch (c) {
            default: {
                switch (c) {
                    default: {
                        return false;
                    }
                    case '\u30fc': 
                    case '\u30fd': 
                    case '\u30fe': 
                }
                break;
            }
            case '\u3031': 
            case '\u3032': 
            case '\u3033': 
            case '\u3034': 
            case '\u3035': 
        }
        return true;
    }

    private boolean isExternalId() throws ParseException, IOException {
        boolean bl = this.isSymbol(SYSTEM) || this.isSymbol(PUBLIC);
        return bl;
    }

    private static final boolean isIn(char c, char[] cArray) {
        int n = 0;
        while (n < cArray.length) {
            if (c == cArray[n]) {
                return true;
            }
            ++n;
        }
        return false;
    }

    private static boolean isLetter(char c) {
        boolean bl = "abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(c)) != -1;
        return bl;
    }

    private boolean isMisc() throws ParseException, IOException {
        boolean bl = this.isComment() || this.isPi() || this.isS();
        return bl;
    }

    private boolean isNameChar() throws ParseException, IOException {
        char c = this.peekChar();
        boolean bl = c < '\u0080' ? IS_NAME_CHAR[c] : ParseCharStream.isNameChar(c);
        return bl;
    }

    private static boolean isNameChar(char c) {
        boolean bl = Character.isDigit(c) || ParseCharStream.isLetter(c) || ParseCharStream.isIn(c, NAME_PUNCT_CHARS) || ParseCharStream.isExtender(c);
        return bl;
    }

    private boolean isPeReference() throws ParseException, IOException {
        return this.isChar('%');
    }

    private final boolean isPi() throws ParseException, IOException {
        return this.isSymbol(PI_BEGIN);
    }

    private final boolean isReference() throws ParseException, IOException {
        return this.isChar('&');
    }

    private final boolean isS() throws ParseException, IOException {
        return this.isChar(' ', '\t', '\r', '\n');
    }

    private final boolean isSymbol(char[] cArray) throws ParseException, IOException {
        int n = cArray.length;
        if (this.endPos_ - this.curPos_ < n && this.fillBuf(n) <= 0) {
            this.ch_ = -1;
            return false;
        }
        char[] cArray2 = this.cbuf_;
        int n2 = this.endPos_;
        this.ch_ = cArray2[n2 - 1];
        if (n2 - this.curPos_ < n) {
            return false;
        }
        n2 = 0;
        while (n2 < n) {
            if (this.cbuf_[this.curPos_ + n2] != cArray[n2]) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    private boolean isVersionNumChar() throws ParseException, IOException {
        char c = this.peekChar();
        boolean bl = Character.isDigit(c) || 'a' <= c && c <= 'z' || 'Z' <= c && c <= 'Z' || ParseCharStream.isIn(c, VERSIONNUM_PUNC_CHARS);
        return bl;
    }

    private boolean isXmlDecl() throws ParseException, IOException {
        return this.isSymbol(XML_BEGIN);
    }

    private final char peekChar() throws ParseException, IOException {
        if (this.curPos_ < this.endPos_) return this.cbuf_[this.curPos_];
        if (this.fillBuf() == -1) throw new ParseException(this, "unexpected end of expression.");
        return this.cbuf_[this.curPos_];
    }

    private String readAttValue() throws ParseException, IOException {
        char c = this.readChar('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            if (this.isChar(c)) {
                this.readChar(c);
                return stringBuffer.toString();
            }
            if (this.isReference()) {
                stringBuffer.append(this.readReference());
                continue;
            }
            stringBuffer.append(this.readChar());
        }
    }

    private void readAttribute(Element element) throws ParseException, IOException {
        String string = this.readName();
        this.readEq();
        String string2 = this.readAttValue();
        if (element.getAttribute(string) != null) {
            ParseLog parseLog = this.log_;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Element ");
            stringBuffer.append(this);
            stringBuffer.append(" contains attribute ");
            stringBuffer.append(string);
            stringBuffer.append("more than once");
            parseLog.warning(stringBuffer.toString(), this.systemId_, this.getLineNumber());
        }
        element.setAttribute(string, string2);
    }

    private void readCdSect() throws ParseException, IOException {
        this.readSymbol(BEGIN_CDATA);
        Object object = null;
        int n = 0;
        while (true) {
            if (this.isSymbol(END_CDATA)) {
                this.readSymbol(END_CDATA);
                if (object != null) {
                    ((StringBuffer)object).append(this.tmpBuf_, 0, n);
                    object = ((StringBuffer)object).toString().toCharArray();
                    this.handler_.characters((char[])object, 0, ((Object)object).length);
                    break;
                }
                this.handler_.characters(this.tmpBuf_, 0, n);
                break;
            }
            Object object2 = object;
            int n2 = n;
            if (n >= 255) {
                if (object == null) {
                    object = new StringBuffer(n);
                    ((StringBuffer)object).append(this.tmpBuf_, 0, n);
                } else {
                    ((StringBuffer)object).append(this.tmpBuf_, 0, n);
                }
                n2 = 0;
                object2 = object;
            }
            this.tmpBuf_[n2] = this.readChar();
            n = n2 + 1;
            object = object2;
        }
    }

    private final char readChar() throws ParseException, IOException {
        if (this.curPos_ >= this.endPos_) {
            if (this.fillBuf() == -1) throw new ParseException(this, "unexpected end of expression.");
        }
        if (this.cbuf_[this.curPos_] == '\n') {
            ++this.lineNumber_;
        }
        char[] cArray = this.cbuf_;
        int n = this.curPos_;
        this.curPos_ = n + 1;
        return cArray[n];
    }

    private final char readChar(char c, char c2) throws ParseException, IOException {
        char c3 = this.readChar();
        if (c3 == c) return c3;
        if (c3 != c2) throw new ParseException(this, c3, new char[]{c, c2});
        return c3;
    }

    private final char readChar(char c, char c2, char c3, char c4) throws ParseException, IOException {
        char c5 = this.readChar();
        if (c5 == c) return c5;
        if (c5 == c2) return c5;
        if (c5 == c3) return c5;
        if (c5 != c4) throw new ParseException(this, c5, new char[]{c, c2, c3, c4});
        return c5;
    }

    private final void readChar(char c) throws ParseException, IOException {
        char c2 = this.readChar();
        if (c2 != c) throw new ParseException(this, c2, c);
    }

    private char readCharRef() throws ParseException, IOException {
        int n;
        this.readSymbol(CHARREF_BEGIN);
        if (this.isChar('x')) {
            this.readChar();
            n = 16;
        } else {
            n = 10;
        }
        int n2 = 0;
        while (true) {
            Object object;
            if (this.isChar(';')) {
                this.readChar(';');
                object = new String(this.tmpBuf_, 0, n2);
                try {
                    n2 = Integer.parseInt((String)object, n);
                }
                catch (NumberFormatException numberFormatException) {
                    ParseLog parseLog = this.log_;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("\"");
                    stringBuffer.append((String)object);
                    stringBuffer.append("\" is not a valid ");
                    object = n == 16 ? (Object)"hexadecimal" : (Object)"decimal";
                    stringBuffer.append((String)object);
                    stringBuffer.append(" number");
                    parseLog.warning(stringBuffer.toString(), this.systemId_, this.getLineNumber());
                    return ' ';
                }
                return (char)n2;
            }
            object = this.tmpBuf_;
            int n3 = n2 + 1;
            object[n2] = this.readChar();
            if (n3 >= 255) {
                this.log_.warning("Tmp buffer overflow on readCharRef", this.systemId_, this.getLineNumber());
                return ' ';
            }
            n2 = n3;
        }
    }

    private final void readComment() throws ParseException, IOException {
        this.readSymbol(COMMENT_BEGIN);
        while (true) {
            if (this.isSymbol(COMMENT_END)) {
                this.readSymbol(COMMENT_END);
                return;
            }
            this.readChar();
        }
    }

    /*
     * Unable to fully structure code
     */
    private void readContent() throws ParseException, IOException {
        this.readPossibleCharData();
        var1_1 = true;
        while (true) {
            if (!var1_1) {
                return;
            }
            if (this.isETag()) ** GOTO lbl-1000
            if (this.isReference()) {
                var2_2 = this.readReference();
                this.handler_.characters(var2_2, 0, var2_2.length);
            } else if (this.isCdSect()) {
                this.readCdSect();
            } else if (this.isPi()) {
                this.readPi();
            } else if (this.isComment()) {
                this.readComment();
            } else if (this.isChar('<')) {
                this.readElement();
            } else lbl-1000:
            // 2 sources

            {
                var1_1 = false;
            }
            this.readPossibleCharData();
        }
    }

    private void readDeclSep() throws ParseException, IOException {
        if (this.isPeReference()) {
            this.readPeReference();
        } else {
            this.readS();
        }
    }

    private void readDocTypeDecl() throws ParseException, IOException {
        this.readSymbol(DOCTYPE_BEGIN);
        this.readS();
        this.docTypeName_ = this.readName();
        if (this.isS()) {
            this.readS();
            if (!this.isChar('>') && !this.isChar('[')) {
                this.isExternalDtd_ = true;
                this.readExternalId();
                if (this.isS()) {
                    this.readS();
                }
            }
        }
        if (this.isChar('[')) {
            this.readChar();
            while (true) {
                if (this.isChar(']')) {
                    this.readChar(']');
                    if (!this.isS()) break;
                    this.readS();
                    break;
                }
                if (this.isDeclSep()) {
                    this.readDeclSep();
                    continue;
                }
                this.readMarkupDecl();
            }
        }
        this.readChar('>');
    }

    private void readETag(Element element) throws ParseException, IOException {
        this.readSymbol(BEGIN_ETAG);
        String string = this.readName();
        if (!string.equals(element.getTagName())) {
            ParseLog parseLog = this.log_;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("end tag (");
            stringBuffer.append(string);
            stringBuffer.append(") does not match begin tag (");
            stringBuffer.append(element.getTagName());
            stringBuffer.append(")");
            parseLog.warning(stringBuffer.toString(), this.systemId_, this.getLineNumber());
        }
        if (this.isS()) {
            this.readS();
        }
        this.readChar('>');
    }

    private final Element readElement() throws ParseException, IOException {
        Element element = new Element();
        boolean bl = this.readEmptyElementTagOrSTag(element);
        this.handler_.startElement(element);
        if (bl) {
            this.readContent();
            this.readETag(element);
        }
        this.handler_.endElement(element);
        return element;
    }

    private boolean readEmptyElementTagOrSTag(Element element) throws ParseException, IOException {
        boolean bl;
        this.readChar('<');
        element.setTagName(this.readName());
        while (true) {
            if (!this.isS()) {
                if (this.isS()) {
                    this.readS();
                }
                if (bl = this.isChar('>')) {
                    this.readChar('>');
                    break;
                }
                this.readSymbol(END_EMPTYTAG);
                break;
            }
            this.readS();
            if (this.isChar('/', '>')) continue;
            this.readAttribute(element);
        }
        return bl;
    }

    private String readEncodingDecl() throws ParseException, IOException {
        this.readSymbol(ENCODING);
        this.readEq();
        char c = this.readChar('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            if (this.isChar(c)) {
                this.readChar(c);
                return stringBuffer.toString();
            }
            stringBuffer.append(this.readChar());
        }
    }

    private void readEntityDecl() throws ParseException, IOException {
        Object object;
        Object object2;
        String string;
        this.readSymbol(ENTITY_BEGIN);
        this.readS();
        if (this.isChar('%')) {
            this.readChar('%');
            this.readS();
            string = this.readName();
            this.readS();
            object2 = this.isEntityValue() ? this.readEntityValue() : this.readExternalId();
            object = this.pes_;
        } else {
            string = this.readName();
            this.readS();
            if (this.isEntityValue()) {
                object2 = this.readEntityValue();
            } else {
                if (!this.isExternalId()) throw new ParseException(this, "expecting double-quote, \"PUBLIC\" or \"SYSTEM\" while reading entity declaration");
                object = this.readExternalId();
                if (this.isS()) {
                    this.readS();
                }
                object2 = object;
                if (this.isSymbol(NDATA)) {
                    this.readSymbol(NDATA);
                    this.readS();
                    this.readName();
                    object2 = object;
                }
            }
            object = this.entities_;
        }
        ((Hashtable)object).put(string, object2);
        if (this.isS()) {
            this.readS();
        }
        this.readChar('>');
    }

    private String readEntityRef() throws ParseException, IOException {
        String string;
        this.readChar('&');
        String string2 = this.readName();
        String string3 = string = (String)this.entities_.get(string2);
        if (string == null) {
            StringBuffer stringBuffer;
            if (this.isExternalDtd_) {
                string = this.log_;
                stringBuffer = new StringBuffer();
                stringBuffer.append("&");
                stringBuffer.append(string2);
                string3 = "; not found -- possibly defined in external DTD)";
            } else {
                string = this.log_;
                stringBuffer = new StringBuffer();
                stringBuffer.append("No declaration of &");
                stringBuffer.append(string2);
                string3 = ";";
            }
            stringBuffer.append(string3);
            string.warning(stringBuffer.toString(), this.systemId_, this.getLineNumber());
            string3 = "";
        }
        this.readChar(';');
        return string3;
    }

    private final String readEntityValue() throws ParseException, IOException {
        char c = this.readChar('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            if (this.isChar(c)) {
                this.readChar(c);
                return stringBuffer.toString();
            }
            if (this.isPeReference()) {
                stringBuffer.append(this.readPeReference());
                continue;
            }
            if (this.isReference()) {
                stringBuffer.append(this.readReference());
                continue;
            }
            stringBuffer.append(this.readChar());
        }
    }

    private final void readEq() throws ParseException, IOException {
        if (this.isS()) {
            this.readS();
        }
        this.readChar('=');
        if (!this.isS()) return;
        this.readS();
    }

    private String readExternalId() throws ParseException, IOException {
        if (this.isSymbol(SYSTEM)) {
            this.readSymbol(SYSTEM);
        } else {
            if (!this.isSymbol(PUBLIC)) throw new ParseException(this, "expecting \"SYSTEM\" or \"PUBLIC\" while reading external ID");
            this.readSymbol(PUBLIC);
            this.readS();
            this.readPubidLiteral();
        }
        this.readS();
        this.readSystemLiteral();
        return "(WARNING: external ID not read)";
    }

    /*
     * Enabled force condition propagation
     */
    private void readMarkupDecl() throws ParseException, IOException {
        if (this.isPi()) {
            this.readPi();
            return;
        }
        if (this.isComment()) {
            this.readComment();
            return;
        }
        if (this.isEntityDecl()) {
            this.readEntityDecl();
            return;
        }
        if (!this.isSymbol(MARKUPDECL_BEGIN)) {
            ParseException parseException = new ParseException(this, "expecting processing instruction, comment, or \"<!\"");
            throw parseException;
        }
        block0: while (true) {
            if (this.isChar('>')) {
                this.readChar('>');
                return;
            }
            if (!this.isChar('\'', '\"')) {
                this.readChar();
                continue;
            }
            char c = this.readChar();
            while (true) {
                if (this.isChar(c)) {
                    this.readChar(c);
                    continue block0;
                }
                this.readChar();
            }
            break;
        }
    }

    private void readMisc() throws ParseException, IOException {
        if (this.isComment()) {
            this.readComment();
        } else if (this.isPi()) {
            this.readPi();
        } else {
            if (!this.isS()) throw new ParseException(this, "expecting comment or processing instruction or space");
            this.readS();
        }
    }

    private final String readName() throws ParseException, IOException {
        this.tmpBuf_[0] = this.readNameStartChar();
        int n = 1;
        StringBuffer stringBuffer = null;
        while (true) {
            if (!this.isNameChar()) {
                if (stringBuffer != null) break;
                return Sparta.intern((String)new String(this.tmpBuf_, 0, n));
            }
            int n2 = n;
            StringBuffer stringBuffer2 = stringBuffer;
            if (n >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(n);
                    stringBuffer.append(this.tmpBuf_, 0, n);
                } else {
                    stringBuffer.append(this.tmpBuf_, 0, n);
                }
                n2 = 0;
                stringBuffer2 = stringBuffer;
            }
            this.tmpBuf_[n2] = this.readChar();
            n = n2 + 1;
            stringBuffer = stringBuffer2;
        }
        stringBuffer.append(this.tmpBuf_, 0, n);
        return stringBuffer.toString();
    }

    private char readNameStartChar() throws ParseException, IOException {
        char c = this.readChar();
        if (ParseCharStream.isLetter(c)) return c;
        if (c == '_') return c;
        if (c != ':') throw new ParseException(this, c, "letter, underscore, colon");
        return c;
    }

    private String readPeReference() throws ParseException, IOException {
        this.readChar('%');
        String string = this.readName();
        CharSequence charSequence = (String)this.pes_.get(string);
        String string2 = charSequence;
        if (charSequence == null) {
            string2 = this.log_;
            charSequence = new StringBuffer();
            ((StringBuffer)charSequence).append("No declaration of %");
            ((StringBuffer)charSequence).append(string);
            ((StringBuffer)charSequence).append(";");
            string2.warning(((StringBuffer)charSequence).toString(), this.systemId_, this.getLineNumber());
            string2 = "";
        }
        this.readChar(';');
        return string2;
    }

    private final void readPi() throws ParseException, IOException {
        this.readSymbol(PI_BEGIN);
        while (true) {
            if (this.isSymbol(QU_END)) {
                this.readSymbol(QU_END);
                return;
            }
            this.readChar();
        }
    }

    private void readPossibleCharData() throws ParseException, IOException {
        int n;
        block0: while (true) {
            n = 0;
            while (!(this.isChar('<') || this.isChar('&') || this.isSymbol(END_CDATA))) {
                int n2;
                this.tmpBuf_[n] = this.readChar();
                if (this.tmpBuf_[n] == '\r' && this.peekChar() == '\n') {
                    this.tmpBuf_[n] = this.readChar();
                }
                n = n2 = n + 1;
                if (n2 != 255) continue;
                this.handler_.characters(this.tmpBuf_, 0, 255);
                continue block0;
            }
            break;
        }
        if (n <= 0) return;
        this.handler_.characters(this.tmpBuf_, 0, n);
    }

    private void readProlog() throws ParseException, EncodingMismatchException, IOException {
        if (this.isXmlDecl()) {
            this.readXmlDecl();
        }
        while (true) {
            if (!this.isMisc()) break;
            this.readMisc();
        }
        if (!this.isDocTypeDecl()) return;
        this.readDocTypeDecl();
        while (this.isMisc()) {
            this.readMisc();
        }
        return;
    }

    private final void readPubidLiteral() throws ParseException, IOException {
        this.readSystemLiteral();
    }

    private final char[] readReference() throws ParseException, IOException {
        if (!this.isSymbol(CHARREF_BEGIN)) return this.readEntityRef().toCharArray();
        return new char[]{this.readCharRef()};
    }

    private final void readS() throws ParseException, IOException {
        this.readChar(' ', '\t', '\r', '\n');
        while (this.isChar(' ', '\t', '\r', '\n')) {
            this.readChar();
        }
        return;
    }

    private final void readSymbol(char[] object) throws ParseException, IOException {
        int n = ((char[])object).length;
        if (this.endPos_ - this.curPos_ < n && this.fillBuf(n) <= 0) {
            this.ch_ = -1;
            throw new ParseException(this, "end of XML file", object);
        }
        char[] cArray = this.cbuf_;
        int n2 = this.endPos_;
        this.ch_ = cArray[n2 - 1];
        if (n2 - this.curPos_ < n) {
            object = new ParseException(this, "end of XML file", object);
            throw object;
        }
        n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.curPos_ += n;
                return;
            }
            if (this.cbuf_[this.curPos_ + n2] != object[n2]) throw new ParseException(this, new String(this.cbuf_, this.curPos_, n), object);
            ++n2;
        }
    }

    private final void readSystemLiteral() throws ParseException, IOException {
        char c = this.readChar();
        while (true) {
            if (this.peekChar() == c) {
                this.readChar(c);
                return;
            }
            this.readChar();
        }
    }

    private void readVersionInfo() throws ParseException, IOException {
        this.readS();
        this.readSymbol(VERSION);
        this.readEq();
        char c = this.readChar('\'', '\"');
        this.readVersionNum();
        this.readChar(c);
    }

    private void readVersionNum() throws ParseException, IOException {
        do {
            this.readChar();
        } while (this.isVersionNumChar());
    }

    private void readXmlDecl() throws ParseException, EncodingMismatchException, IOException {
        this.readSymbol(XML_BEGIN);
        this.readVersionInfo();
        if (this.isS()) {
            this.readS();
        }
        if (this.isEncodingDecl()) {
            String string = this.readEncodingDecl();
            if (this.encoding_ != null) {
                if (!string.toLowerCase().equals(this.encoding_)) throw new EncodingMismatchException(this.systemId_, string, this.encoding_);
            }
        }
        while (true) {
            if (this.isSymbol(QU_END)) {
                this.readSymbol(QU_END);
                return;
            }
            this.readChar();
        }
    }

    final String getHistory() {
        return "";
    }

    int getLastCharRead() {
        return this.ch_;
    }

    public int getLineNumber() {
        return this.lineNumber_;
    }

    ParseLog getLog() {
        return this.log_;
    }

    public String getSystemId() {
        return this.systemId_;
    }

    public String toString() {
        return this.systemId_;
    }
}

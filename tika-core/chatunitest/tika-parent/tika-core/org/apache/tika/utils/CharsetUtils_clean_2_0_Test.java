package org.apache.tika.utils;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.util.Locale.ENGLISH;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CharsetUtils_clean_2_0_Test {

    private static final Map<String, Charset> COMMON_CHARSETS = new HashMap<>();

    private static final Pattern CHARSET_NAME_PATTERN = Pattern.compile("[ \\\"]*([^ >,;\\\"]+).*");

    private static final Pattern ISO_NAME_PATTERN = Pattern.compile(".*8859-(\\d+)");

    private static final Pattern CP_NAME_PATTERN = Pattern.compile("cp-(\\d+)");

    private static final Pattern WIN_NAME_PATTERN = Pattern.compile("win-?(\\d+)");

    @Test
    void testClean() {
        assertNull(CharsetUtils.clean(null));
        assertEquals("UTF-8", CharsetUtils.clean("UTF-8"));
        assertEquals("ISO-8859-1", CharsetUtils.clean("ISO 8859-1"));
        assertEquals("CP1252", CharsetUtils.clean("CP1252"));
        assertEquals("WINDOWS-1252", CharsetUtils.clean("WINDOWS-1252"));
        assertEquals("US-ASCII", CharsetUtils.clean("US-ASCII"));
        assertEquals("UTF-16", CharsetUtils.clean("UTF-16"));
        assertEquals("UTF-16BE", CharsetUtils.clean("UTF-16BE"));
        assertEquals("UTF-16LE", CharsetUtils.clean("UTF-16LE"));
        assertEquals("UTF-32", CharsetUtils.clean("UTF-32"));
        assertEquals("UTF-32BE", CharsetUtils.clean("UTF-32BE"));
        assertEquals("UTF-32LE", CharsetUtils.clean("UTF-32LE"));
        assertEquals("GBK", CharsetUtils.clean("GBK"));
        assertEquals("GB18030", CharsetUtils.clean("GB18030"));
        assertEquals("GB2312", CharsetUtils.clean("GB2312"));
        assertEquals("BIG5", CharsetUtils.clean("BIG5"));
        assertEquals("SHIFT_JIS", CharsetUtils.clean("SHIFT_JIS"));
        assertEquals("KOI8_R", CharsetUtils.clean("KOI8_R"));
        assertEquals("MAC_ROMAN", CharsetUtils.clean("MAC_ROMAN"));
        assertEquals("MAC_CENTRALEUROPE", CharsetUtils.clean("MAC_CENTRALEUROPE"));
        assertEquals("MAC_GREEK", CharsetUtils.clean("MAC_GREEK"));
        assertEquals("MAC_CYRILLIC", CharsetUtils.clean("MAC_CYRILLIC"));
        assertEquals("MAC_DEVANAGARI", CharsetUtils.clean("MAC_DEVANAGARI"));
        assertEquals("MAC_GURMUKSHA", CharsetUtils.clean("MAC_GURMUKSHA"));
        assertEquals("MAC_TELUGU", CharsetUtils.clean("MAC_TELUGU"));
        assertEquals("MAC_KANNADA", CharsetUtils.clean("MAC_KANNADA"));
        assertEquals("MAC_MALAYALAM", CharsetUtils.clean("MAC_MALAYALAM"));
        assertEquals("MAC_SINHALA", CharsetUtils.clean("MAC_SINHALA"));
        assertEquals("MAC_BENGALI", CharsetUtils.clean("MAC_BENGALI"));
        assertEquals("MAC_THAI", CharsetUtils.clean("MAC_THAI"));
        assertEquals("MAC_LAO", CharsetUtils.clean("MAC_LAO"));
        assertEquals("MAC_TIBETAN", CharsetUtils.clean("MAC_TIBETAN"));
        assertEquals("MAC_CJK_COMPAT", CharsetUtils.clean("MAC_CJK_COMPAT"));
    }
}

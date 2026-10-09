/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tika.utils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CharsetUtils_isSupported_1_2_Test {

    private static final String CHARSET_NAME = "UTF-8";

    private static final boolean IS_SUPPORTED = true;

    private static final boolean IS_NOT_SUPPORTED = false;

    private static final String NOT_SUPPORTED_CHARSET_NAME = "invalid-charset";

    private static final String NULL_CHARSET_NAME = null;

    private static CharsetUtils charsetUtils;

    private static Field getCharsetICU;

    private static Field isSupportedICU;

    @BeforeAll
    public static void setUp() throws Exception {
        charsetUtils = new CharsetUtils();
        getCharsetICU = CharsetUtils.class.getDeclaredField("getCharsetICU");
        getCharsetICU.setAccessible(true);
        isSupportedICU = CharsetUtils.class.getDeclaredField("isSupportedICU");
        isSupportedICU.setAccessible(true);
    }

    @Test
    public void testIsSupportedWithValidCharsetName() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        boolean result = CharsetUtils.isSupported(CHARSET_NAME);
        assertEquals(IS_SUPPORTED, result);
    }

    @Test
    public void testIsSupportedWithNotSupportedCharsetName() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        boolean result = CharsetUtils.isSupported(NOT_SUPPORTED_CHARSET_NAME);
        assertEquals(IS_NOT_SUPPORTED, result);
    }

    @Test
    public void testIsSupportedWithNullCharsetName() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        boolean result = CharsetUtils.isSupported(NULL_CHARSET_NAME);
        assertEquals(IS_NOT_SUPPORTED, result);
    }
}

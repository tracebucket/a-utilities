/**
 * Utilities - Utilities used by anon
 *
 * Copyright (C) 2012 Individual contributors as indicated by
 * the @authors tag
 *
 * This file is a part of Utilities.
 *
 * Utilities is a free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Utilities is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * */
 
/**
 * ************************************************************
 * HEADERS
 * ************************************************************
 * File:                org.anon.utilities.anatomy.JVMEnvironment
 * Author:              rsankar
 * Revision:            1.0
 * Date:                09-01-2013
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * An environment for the type of JVM the modules run in
 *
 * ************************************************************
 * */

package org.anon.utilities.anatomy;

import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.anon.utilities.lock.LockScheme;
import org.anon.utilities.jitq.DataListener;
import org.anon.utilities.atomic.AtomicCounter;
import org.anon.utilities.jitq.JITProcessQueue;
import org.anon.utilities.exception.CtxException;

public interface JVMEnvironment
{
    public ExecutorService executorFor(String type, String name)
        throws CtxException;

    public JITProcessQueue jitQueueFor(String group, String name, Object associated, DataListener listener)
        throws CtxException;

    public <K, T> Map<K, T> mapFor(String name)
        throws CtxException;

    public LockScheme createLock(String name)
        throws CtxException;

    public AtomicCounter createAtomicCounter(String name, int initial)
        throws CtxException;

    public boolean isDistributed();
}


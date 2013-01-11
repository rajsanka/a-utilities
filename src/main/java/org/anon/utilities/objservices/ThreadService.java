/**
 * SMART - State Machine ARchiTecture
 *
 * Copyright (C) 2012 Individual contributors as indicated by
 * the @authors tag
 *
 * This file is a part of SMART.
 *
 * SMART is a free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SMART is distributed in the hope that it will be useful,
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
 * File:                org.anon.utilities.objservices.ThreadService
 * Author:              rsankar
 * Revision:            1.0
 * Date:                09-01-2013
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * A thread service that provides thread related services
 *
 * ************************************************************
 * */

package org.anon.utilities.objservices;

import java.util.Map;

import static org.anon.utilities.services.ServiceLocator.*;
import org.anon.utilities.cthreads.CThread;
import org.anon.utilities.cthreads.CThreadContext;
import org.anon.utilities.cthreads.RuntimeContext;
import org.anon.utilities.exception.CtxException;

public class ThreadService extends ObjectServiceLocator.ObjectService
{
    public ThreadService()
    {
        super();
    }

    public CThreadContext threadContext()
        throws CtxException
    {
        CThreadContext ctx = null;
        try
        {
            Thread t = Thread.currentThread();
            if (t instanceof CThread)
            {
                CThread ct = (CThread)t;
                ctx = ct.thrdContext();
            }
        }
        catch (Exception e)
        {
            except().rt(e, new CtxException.Context("ThreadService.threadContext", "Exception"));
        }
        return ctx;
    }

    public RuntimeContext runtimeContext()
        throws CtxException
    {
        RuntimeContext ctx = null;
        try
        {
            Thread t = Thread.currentThread();
            if (t instanceof CThread)
            {
                CThread ct = (CThread)t;
                ctx = ct.runtime();
            }
        }
        catch (Exception e)
        {
            except().rt(e, new CtxException.Context("ThreadService.runtimeContext", "Exception"));
        }

        return ctx;
    }

    public Object contextLocal(String name)
        throws CtxException
    {
        Object ret = null;
        try
        {
            Thread t = Thread.currentThread();
            if (t instanceof CThread)
            {
                CThread ct = (CThread)t;
                ret = ct.ctxLocal(name);
            }
        }
        catch (Exception e)
        {
            except().rt(e, new CtxException.Context("ThreadService.contextLocal", "Exception"));
        }
        return ret;
    }

    public void setContextLocals(Map<String, Object> locals)
        throws CtxException
    {
        try
        {
            Thread t = Thread.currentThread();
            if (t instanceof CThread)
            {
                CThread ct = (CThread)t;
                ct.setContextLocals(locals);
            }
            else
            {
            }
        }
        catch (Exception e)
        {
            except().rt(e, new CtxException.Context("ThreadService.setContextLocals", "Exception"));
        }
    }
}

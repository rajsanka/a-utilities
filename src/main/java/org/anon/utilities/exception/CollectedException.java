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
 * File:                org.anon.utilities.exception.CollectedException
 * Author:              rsankarx
 * Revision:            1.0
 * Date:                24-09-2016
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * A collection of exceptions collected
 *
 * ************************************************************
 * */

package org.anon.utilities.exception;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CollectedException extends CtxException
{
    private Collection<CtxException> _collect;

    public CollectedException(int cde, Throwable first)
    {
        super(cde, first);
        _collect = new ConcurrentLinkedQueue<CtxException>();
        addException(first);
    }

    public void addException(Throwable e)
    {
        CtxException add = null;
        if (e instanceof CtxException)
        {
            add = (CtxException)e;
        }
        else
        {
            add = new CtxException(e);
        }

        _collect.add(add);
    }
}


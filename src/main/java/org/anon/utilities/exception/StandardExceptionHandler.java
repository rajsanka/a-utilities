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
 * File:                org.anon.utilities.exception.StandardExceptionHandler
 * Author:              rsankar
 * Revision:            1.0
 * Date:                03-08-2012
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * An exception thrown in all anon module
 *
 * ************************************************************
 * */

package org.anon.utilities.exception;

import static org.anon.utilities.services.ServiceLocator.*;

public class StandardExceptionHandler implements ExceptionHandler
{
    private CollectedException _exception;
    private Object _forObject;
    private int _code;

    public StandardExceptionHandler(Object fo, int cde) 
    {
        _forObject = fo;
        _code = cde;
    }

    public void handleException(Throwable e)
    {
        if (_exception == null)
            _exception = new CollectedException(_code, e);
        else
            _exception.addException(e);
    }

    public void hasException()
        throws CtxException
    {
        if (_exception != null) except().rt(_forObject, _exception, new CtxException.Context("StandardExceptionHandler", "hasException"));
    }
}


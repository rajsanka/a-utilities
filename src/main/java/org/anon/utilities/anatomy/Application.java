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
 * File:                org.anon.utilities.anatomy.Application
 * Author:              rsankar
 * Revision:            1.0
 * Date:                08-08-2012
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * An application representation
 *
 * ************************************************************
 * */

package org.anon.utilities.anatomy;

import org.anon.utilities.utils.VMSingleton;
import org.anon.utilities.exception.CtxException;

public class Application extends VMSingleton
{
    private ClassLoader _startLoader;

    private static final String APPNAME = "org.anon.utilities.anatomy.Application";

    private static Application SINGLE_INSTANCE = null;

    private Application()
    {
    }

    private static void setSingleInstance(Object obj)
    {
        if (SINGLE_INSTANCE == null)
            SINGLE_INSTANCE = (Application)obj;
    }

    private static Object getSingleInstance()
    {
        return SINGLE_INSTANCE;
    }


    public void setStartLoader(ClassLoader ldr)
    {
        _startLoader = ldr;
    }

    public ClassLoader getStartLoader()
    {
        return _startLoader;
    }

    public static Object getApplication()
        throws CtxException
    {
        return getInstance("org.anon.utilities.anatomy.Application");
    }
}


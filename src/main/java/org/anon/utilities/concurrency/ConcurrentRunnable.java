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
 * File:                org.anon.utilities.concurrency.ConcurrentRunnable
 * Author:              rsankar
 * Revision:            1.0
 * Date:                01-01-2013
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * A running run by the execution adapter
 *
 * ************************************************************
 * */

package org.anon.utilities.concurrency;

public class ConcurrentRunnable implements Runnable
{
    private ExecutionUnit _unit;
    private ExceptionHandler _handler;

    public ConcurrentRunnable(ExecutionUnit unit, ExceptionHandler handler)
    {
        _unit = unit;
        _handler = handler;
    }

    public void run()
    {
        try
        {
            _unit.execute();
        }
        catch (Exception e)
        {
            _handler.handleException(_unit, e);
        }
    }
}


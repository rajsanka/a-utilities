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
 * File:                org.anon.utilities.concurrency.AbstractExecute
 * Author:              rsankar
 * Revision:            1.0
 * Date:                01-01-2013
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * An abstract executor which provides commons functions
 *
 * ************************************************************
 * */

package org.anon.utilities.concurrency;

import java.util.List;

import org.anon.utilities.exception.CtxException;

public abstract class AbstractExecute implements ExecutionAdapter
{
    public AbstractExecute()
    {
    }

    public void executeWait(List<ExecutionUnit> runs)
        throws CtxException
    {
        execute(runs);
        waitToComplete();
    }

    public void execute(List<ExecutionUnit> runs)
        throws CtxException
    {
        if (runs == null)
            return;

        for (int i = 0; i < runs.size(); i++)
            execute(runs.get(i));
    }
}


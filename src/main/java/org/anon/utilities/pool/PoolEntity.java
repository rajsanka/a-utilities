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
 * File:                org.anon.utilities.pool.PoolEntity
 * Author:              rsankar
 * Revision:            1.0
 * Date:                08-08-2012
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * PoolEntity
 *
 * ************************************************************
 * */

package org.anon.utilities.pool;

public interface PoolEntity
{
    public PoolEntity nextEntity();
    public void setNextEntity(PoolEntity entity);
    public Pool pool();
    public void storePool(Pool p);
}


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
 * File:                org.anon.utilities.test.reflect.ComplexTestObject
 * Author:              rsankar
 * Revision:            1.0
 * Date:                08-08-2012
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * An object that contains another object
 *
 * ************************************************************
 * */

package org.anon.utilities.test.reflect;

import java.util.Date;
import java.util.UUID;

import org.anon.utilities.fsm.StateEntity;
import org.anon.utilities.fsm.FiniteState;
import org.anon.utilities.fsm.FiniteStateMachine;

import org.anon.utilities.exception.CtxException;

import static org.anon.utilities.objservices.ObjectServiceLocator.*;

public class ComplexTestObject implements java.io.Serializable, StateEntity
{
    Double _double;
    Date _dt;
    SimpleTestObject _simple;
    SimpleTestObject _simpleDuplicate;
    //UUID _id;
    //String _str;
    FiniteState _state;

    public ComplexTestObject()
        throws Exception
    {
        _simple = new SimpleTestObject();
        _double = new Double(10.123);
        _dt = new Date();
        _simpleDuplicate = _simple;
        //_id = UUID.randomUUID();
        //_str = _id.toString();
        FiniteStateMachine mc = fsm().fsm("ComplexTestObject");
        if (mc != null) mc.start(this);
    }
    public ComplexTestObject(int i)
    {
        _simple = new SimpleTestObject(i);
        _double = new Double(10.123);
        _dt = new Date();
        _simpleDuplicate = _simple;
        //_id = UUID.randomUUID();
        //_str = _id.toString();
    }

    public String toString()
    {
        return "_double:" + _double +
            ":_dt:" + _dt +
            ":_simple:" + _simple +
            "_simpleDuplicate:" + _simpleDuplicate;
    }

    public String utilities___stateEntityType()
    {
        return "ComplexTestObject";
    }

    public void utilities___setCurrentState(FiniteState state)
    {
        _state = state;
    }

    public FiniteState utilities___currentState() { 
        return _state; 
    }

    public StateEntity utilities___parent()
        throws CtxException
    {
        return null;
    }

    public StateEntity[] utilities___children(String setype)
        throws CtxException
    {
        return null;
    }
}


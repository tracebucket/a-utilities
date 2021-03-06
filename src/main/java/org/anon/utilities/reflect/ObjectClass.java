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
 * File:                org.anon.utilities.reflect.ObjectClass
 * Author:              rsankar
 * Revision:            1.0
 * Date:                29-12-2012
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * A class traversal for object
 *
 * ************************************************************
 * */

package org.anon.utilities.reflect;

import java.util.List;

import static org.anon.utilities.services.ServiceLocator.*;
import org.anon.utilities.exception.CtxException;

public class ObjectClass extends ObjectType
{
    public ObjectClass()
    {
        super();
        _object = false;
    }

    @Override
    protected RepeatableType createme()
    {
        return new ObjectClass();
    }

    @Override
    protected Object traverse(Traversal traverse, DataContext pctx, TVisitor visit, boolean mod, List<ObjectTraversal.myTraverser> at, 
            Class cls, Object primary, Object ... cotraverse)
        throws CtxException
    {
        try
        {
            if (primary == null)
            {
                primary = reflect().silentcreate(cls);
            }
            super.traverse(traverse, pctx, visit, mod, at, cls, primary);
        }
        catch (Exception e)
        {
            except().rt(this, e, new CtxException.Context("traverseSimpleClass", "Error:" + cls.getName() + ":" + primary));
        }

        return primary;
    }
}


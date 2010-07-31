/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.seam.xml.model;

import java.lang.reflect.Method;

import org.jboss.seam.xml.fieldset.FieldValueObject;
import org.jboss.seam.xml.fieldset.MethodFieldSetter;
import org.jboss.seam.xml.fieldset.SimpleFieldValue;

public class PropertyXmlItem extends AbstractFieldXmlItem
{

   private final String name;
   private final Class<?> type;
   private final Class<?> declaringClass;

   public PropertyXmlItem(XmlItem parent, String name, Method setter, String innerText, String document, int lineno)
   {
      super(XmlItemType.FIELD, parent, parent.getJavaClass(), innerText, null, document, lineno);
      this.name = name;
      this.type = setter.getParameterTypes()[0];
      this.declaringClass = setter.getDeclaringClass();
      this.fieldSetter = new MethodFieldSetter(setter);
      if (innerText != null && innerText.length() > 0)
      {
         fieldValue = new SimpleFieldValue(parent.getJavaClass(), fieldSetter, innerText);
      }
   }

   public FieldValueObject getFieldValue()
   {
      return fieldValue;
   }

   @Override
   public Class<?> getDeclaringClass()
   {
      return declaringClass;
   }

   @Override
   public String getFieldName()
   {
      return name;
   }

   @Override
   public Class<?> getFieldType()
   {
      return type;
   }

}

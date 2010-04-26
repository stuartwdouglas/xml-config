/*
 * Distributed under the LGPL License
 * 
 */
package org.jboss.seam.xml.test.fieldset;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Retention(RetentionPolicy.RUNTIME)
@Target( { TYPE, METHOD, PARAMETER, FIELD })
@Qualifier
public @interface FieldsetQualifier
{

}
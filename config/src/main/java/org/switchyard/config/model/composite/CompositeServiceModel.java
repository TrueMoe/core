/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.switchyard.config.model.composite;

import java.util.List;

import org.switchyard.config.model.NamedModel;
import org.switchyard.config.model.extensions.ExtensionsModel;

/**
 * The "composite/service" model.
 *
 * @author David Ward &lt;<a href="mailto:dward@jboss.org">dward@jboss.org</a>&gt; (C) 2011 Red Hat Inc.
 */
public interface CompositeServiceModel extends NamedModel {

    /** The "service" name. */
    public static final String SERVICE = "service";

    /** The "promote" name. */
    public static final String PROMOTE = "promote";

    /**
     * Gets the parent composite model.
     * @return the parent composite model
     */
    public CompositeModel getComposite();

    /**
     * Gets the child component model.
     * @return the child component model
     */
    public ComponentModel getComponent();

    /**
     * Gets the child component service model.
     * @return the child component service model
     */
    public ComponentServiceModel getComponentService();
    
    /**
     * Gets the child extensions model.
     * @return the child extensions model
     */
    public ExtensionsModel getExtensionsModel();
    
    /**
     * Gets the promote attribute.
     * @return the promote attribute
     */
    public String getPromote();

    /**
     * Sets the promote attribute.
     * @param promote the promote attribute
     * @return this CompositeServiceModel (useful for chaining)
     */
    public CompositeServiceModel setPromote(String promote);

    /**
     * Gets the child binding models.
     * @return the child binding models
     */
    public List<BindingModel> getBindings();

    /**
     * Adds a child binding model.
     * @param binding the child binding model
     * @return this CompositeServiceModel (useful for chaining)
     */
    public CompositeServiceModel addBinding(BindingModel binding);
    
    /**
     * Gets the child service interface model.
     * @return the child service interface model
     */
    public InterfaceModel getInterface();

    /**
     * Sets the child service interface model.
     * @param interfaze child service interface model
     * @return this CompositeServiceModel (useful for chaining)
     */
    public CompositeServiceModel setInterface(InterfaceModel interfaze);
    
    /**
     * Set the child extensions model. 
     * @param extensionsModel child extensions model
     * @return this this CompositeServiceModel (useful for chaining)
     */
    public CompositeServiceModel setExtensions(ExtensionsModel extensionsModel);
    
    /**
     * Indicates if a service extension is available. 
     * @return true if a service extension is available, otherwise false
     */
    public boolean hasExtensionsModel();

}

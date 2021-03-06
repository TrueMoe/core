/* 
 * JBoss, Home of Professional Open Source 
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved. 
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
package org.switchyard.config.model.extensions.v1;

import javax.xml.namespace.QName;

import org.switchyard.config.Configuration;
import org.switchyard.config.model.BaseNamedModel;
import org.switchyard.config.model.Descriptor;
import org.switchyard.config.model.extensions.ExtensionsModel;
import org.switchyard.config.model.extensions.adapter.AdapterModel;

/**
 * V1 Extensions model.
 * 
 * @author Christoph Gostner &lt;<a href="mailto:christoph.gostner@objectbay.com">christoph.gostner@objectbay.com</a>&gt; &copy; 2013 Objectbay
 */
public class V1ExtensionsModel extends BaseNamedModel implements ExtensionsModel {

    private AdapterModel _adapterModel;


    /**
     * Creates a new ExtensionsModel with the specified configuration and descriptor.
     * @param config the configuration
     * @param desc the descriptor
     */
    public V1ExtensionsModel(Configuration config, Descriptor desc) {
        super(config, desc);

        // only one adapter is supported
        for (Configuration adater_config : config.getChildrenStartsWith(AdapterModel.ADAPTER)) {
            _adapterModel = (AdapterModel)readModel(adater_config);
            if (_adapterModel != null) {
                break;
            }
        }
    }

    public V1ExtensionsModel() {
        super(new QName(ExtensionsModel.EXTENSIONS));
	}

	@Override
    public String getType() {
        return EXTENSIONS;
    }

    @Override
    public AdapterModel getAdapterModel() {
        return _adapterModel;
    }

    @Override
    public ExtensionsModel setAdapterModel(AdapterModel adapterModel) {
        setChildModel(adapterModel);
        _adapterModel = adapterModel;
        return this;
    }
    
    @Override
    public boolean hasAdapterModel() {
        return _adapterModel != null;
    }
}

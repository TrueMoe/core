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
package org.switchyard.exception;

/**
 * A DuplicateAdapterException is thrown by SwitchYard when a duplicate adapter
 * is trying to be registered for a 'from' server for which there already exists 
 * an adapter in the adapter registry.
 * 
 * @author Christoph Gostner &lt;<a href="mailto:christoph.gostner@objectbay.com">christoph.gostner@objectbay.com</a>&gt; &copy; 2013 Objectbay
 */
public class DuplicateAdapterException extends SwitchYardException {
    private static final long serialVersionUID = 3368823467745672974L;

    /**
     * Public constructor.
     * 
     * @param message Exception message.
     */
    public DuplicateAdapterException(final String message) {
        super(message);
    }

    /**
     * Public constructor.
     * 
     * @param message Exception message.
     * @param cause Throwable cause.
     */
    public DuplicateAdapterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

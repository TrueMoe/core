/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012 Red Hat Inc. and/or its affiliates and other contributors
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
package org.switchyard.serial.protostuff;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.w3c.dom.Element;

/**
 * Data for tests.
 *
 * @author David Ward &lt;<a href="mailto:dward@jboss.org">dward@jboss.org</a>&gt; &copy; 2012 Red Hat Inc.
 */
public final class ProtostuffSerializationData {

    @SuppressWarnings("serial")
    public static final class Person implements Serializable {
        private String _name;
        private Person _bestFriend;
        private Collection<Person> _relatives = new ArrayList<Person>();
        public Person() {}
        public Person(String name) {
            setName(name);
        }
        public String getName() {
            return _name;
        }
        public void setName(String name) {
            _name = name;
        }
        public Person getBestFriend() {
            return _bestFriend;
        }
        public void setBestFriend(Person bestFriend) {
            _bestFriend = bestFriend;
        }
        public Collection<Person> getRelatives() {
            return _relatives;
        }
        public void setRelatives(Collection<Person> relatives) {
            _relatives = relatives;
        }
        public String toString() {
            return "Person(name=" + getName() + ", bestFriend=" + (_bestFriend != null ? _bestFriend.getName() : "") + ", relatives=" + getRelatives().size() + ")";
        }
    }

    @SuppressWarnings("serial")
    public static final class Car implements Serializable {
        private Person _driver;
        private Person[] _passengers;
        private Title _title;
        private Part[] _cheapParts;
        private Collection<Part> _expensiveParts;
        private Element _inspection;
        private Exception _problem;
        private Antennae _antennae;
        public Car() {}
        public Car(Person driver) {
            setDriver(driver);
        }
        public Person getDriver() {
            return _driver;
        }
        public void setDriver(Person driver) {
            _driver = driver;
        }
        public Person[] getPassengers() {
            return _passengers;
        }
        public void setPassengers(Person[] passengers) {
            _passengers = passengers;
        }
        public Title getTitle() {
            return _title;
        }
        public void setTitle(Title title) {
            _title = title;
        }
        public Part[] getCheapParts() {
            return _cheapParts;
        }
        public void setCheapParts(Part[] cheapParts) {
            _cheapParts = cheapParts;
        }
        public Collection<Part> getExpensiveParts() {
            return _expensiveParts;
        }
        public void setExpensiveParts(Collection<Part> expensiveParts) {
            _expensiveParts = expensiveParts;
        }
        public Element getInspection() {
            return _inspection;
        }
        public void setInspection(Element inspection) {
            _inspection = inspection;
        }
        public Exception getProblem() {
            return _problem;
        }
        public void setProblem(Exception problem) {
            _problem = problem;
        }
        public Antennae getAntennae() {
            return _antennae;
        }
        public void setAntennae(Antennae antennae) {
            _antennae = antennae;
        }
        public String toString() {
            return "Car(driver=" + getDriver() + ", passengers=" + Arrays.toString(getPassengers()) + ", cheapParts=" + Arrays.toString(getCheapParts()) + ", expensiveParts=" + getExpensiveParts() + ", inspection=" + getInspection() + ", problem=" + getProblem() + ")";
        }
    }

    public static interface Title {
        public String getState();
        public boolean isLiened();
    }

    public static final class StrictTitle implements Title {
        private String _state;
        private boolean _liened;
        public StrictTitle() {}
        public String getState() {
            return _state;
        }
        public void setState(String state) {
            _state = state;
        }
        public boolean isLiened() {
            return _liened;
        }
        public void setLiened(boolean liened) {
            _liened = liened;
        }
    }

    public static final class FluentTitle implements Title {
        private String _state;
        private boolean _liened;
        public FluentTitle() {}
        public String getState() {
            return _state;
        }
        // purposely returns the implementation type, for the sake of the test
        public FluentTitle setState(String state) {
            _state = state;
            return this;
        }
        public boolean isLiened() {
            return _liened;
        }
        // purposely returns the interface type, for the sake of the test
        public Title setLiened(boolean liened) {
            _liened = liened;
            return this;
        }
    }

    public static interface Part {
        public boolean isReplaceable();
    }

    public static final class Wheel implements Part {
        public boolean isReplaceable() {
            return true;
        }
        public String toString() {
            return "Wheel(replaceable=" + isReplaceable() + ")";
        }
    }

    public static final class CustomPart implements Part {
        private boolean _replaceable;
        public CustomPart() {}
        public CustomPart(boolean replaceable) {
            setReplaceable(replaceable);
        }
        public boolean isReplaceable() {
            return _replaceable;
        }
        public void setReplaceable(boolean replaceable) {
            _replaceable = replaceable;
        }
        public String toString() {
            return "CustomPart(replaceable=" + isReplaceable() + ")";
        }
    }

    public static final class ExpiredPart implements Part {
        private Date _expiredDate;
        public ExpiredPart(Date expiredDate) {
            _expiredDate = expiredDate;
        }
        public boolean isReplaceable() {
            return false;
        }
        public Date getExpiredDate() {
            return _expiredDate;
        }
        public String toString() {
            return "BadPart(replaceable=" + isReplaceable() + ", " + getExpiredDate() + ")";
        }
    }

    public static final class Antennae {}

    private ProtostuffSerializationData() {}

}

/**
 * This file is part of org.everit.osgi.authentication.api.
 *
 * org.everit.osgi.authentication.api is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * org.everit.osgi.authentication.api is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with org.everit.osgi.authentication.api.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.authentication.api;

import java.io.Serializable;

/**
 * Represents an entity that can be authenticated, such as a user. The implementation must override the
 * {@link #equals(Object)}, {@link #hashCode()} and {@link #toString()} method.
 */
public interface Subject extends Serializable {

    @Override
    boolean equals(Object obj);

    /**
     * Returns the ID of the <a href="https://github.com/everit-org/resource">resource</a> assigned to this subject.
     * 
     * @return a resource ID
     */
    long getResourceId();

    @Override
    int hashCode();

    @Override
    String toString();

}

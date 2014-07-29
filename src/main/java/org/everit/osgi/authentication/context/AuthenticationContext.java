/**
 * This file is part of Everit - Authentication Context API.
 *
 * Everit - Authentication Context API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - Authentication Context API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - Authentication Context API.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.authentication.context;

/**
 * Using the AuthenticationContext interface we can query the Resource ID of the actual Thread or the configured Default
 * Resource ID (aka Guest Resource ID).
 */
public interface AuthenticationContext {

    /**
     * Returns the current Resource ID of the actual thread or the default Resource ID (a.k.a. guest or not
     * authenticated resource) if there is no authenticated resource available.
     *
     * @return the current Resource ID
     */
    long getCurrentResourceId();

    /**
     * Returns the configured Resource ID assigned to the default (guest) resource.
     *
     * @return the default Resource ID
     */
    long getDefaultResourceId();

}

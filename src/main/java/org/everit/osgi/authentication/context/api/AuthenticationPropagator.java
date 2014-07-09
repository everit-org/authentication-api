/**
 * This file is part of org.everit.osgi.authentication.context.api.
 *
 * org.everit.osgi.authentication.context.api is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * org.everit.osgi.authentication.context.api is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with org.everit.osgi.authentication.context.api.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.authentication.context.api;

import java.util.function.Supplier;

/**
 * The Authentication Propagator executes the authenticated process in the name of the authenticated Resource ID.
 */
public interface AuthenticationPropagator {

    /**
     * Executes the authentication action in the name of the given Resource ID. Steps:
     * <ul>
     * <li>Store the Resource ID assigned to the actual Thread.</li>
     * <li>Assign the given Resource ID to the actual Thread.</li>
     * <li>Execute the authenticated process.</li>
     * <li>Assign the previously stored Resource ID to the actual Thread (in case of an exception too).</li>
     * </ul>
     *
     * @param <T>
     *            the return type of the authenticated action
     * @param authenticatedResourceId
     *            the Resource ID that will be assigned to the actual thread while executing the authenticated action,
     *            cannot be <code>null</code> and can be the Default Resource ID if the authentication fails
     * @param authenticatedAction
     *            the action to execute in the name of the Resource ID, cannot be <code>null</code>
     * @return the result of the executed authenticated action
     */
    <T> T runAs(long authenticatedResourceId, Supplier<T> authenticatedAction);

}

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

/**
 * Service for executing {@link AuthenticatedAction}s as a {@link Subject}, retrieving the the current {@link Subject}
 * of the actual thread (that executes the {@link AuthenticatedAction}), and to log out other {@link Subject}s.
 */
// TODO Why do we need the Subject interface? A primitive long would be enough.
// TODO Why do we need the AuthenticatedAction interface? A java.util.concurrent.Callable would be enough.
public interface AuthenticationService {

    /**
     * The property key of the ID of the <a href="https://github.com/everit-org/resource">resource</a> assigned to the
     * default {@link Subject}. The default subject (a.k.a. guest or not authenticated subject) is the subject that is
     * returned by the {@link #getCurrentSubject()} method if there is no authenticated subject assigned to the current
     * thread. The value of this property is stored in the configuration.
     */
    String PROP_DEFAULT_SUBJECT_RESOURCE_ID = AuthenticationService.class.getName() + ".DEFAULT_SUBJECT_RESOURCE_ID";

    /**
     * Returns the current authenticated {@link Subject} of the actual thread or the default subject (a.k.a. guest or
     * not authenticated subject) if there is no authenticated subject available.
     * 
     * @return the current subject, never returns <code>null</code>
     */
    Subject getCurrentSubject();

    /**
     * Logs out the given {@link Subject}. Currently not supported!
     * 
     * @param subject
     *            the subject to log out. Cannot be null.
     */
    void logout(Subject subject);

    /**
     * Executes the {@link AuthenticatedAction} in the name of the given {@link Subject}. Steps:
     * <ul>
     * <li>assigns the given subject to the actual thread before executes the authenticated action</li>
     * <li>executes the authenticated action</li>
     * <li>assigns the default subject to the actual thread after the authenticated action is finished or in case of any
     * exception occurred</li>
     * </ul>
     * 
     * @param <T>
     *            the return type of the authenticated action
     * @param subject
     *            the subject that will be assigned to the actual thread while executing the authenticated action,
     *            cannot be <code>null</code>
     * @param authenticatedAction
     *            the action to execute in the name of the subject, cannot be <code>null</code>
     * @return the result of the executed authenticated action
     */
    <T> T runAs(Subject subject, AuthenticatedAction<T> authenticatedAction);

}

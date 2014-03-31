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

public interface AuthenticatedAction<T> {

    T run();

}

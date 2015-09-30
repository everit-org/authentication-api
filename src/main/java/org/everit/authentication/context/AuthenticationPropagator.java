/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.biz)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.authentication.context;

import java.util.function.Supplier;

/**
 * The Authentication Propagator executes the authenticated process in the name of the authenticated
 * Resource ID.
 */
public interface AuthenticationPropagator {

  /**
   * Executes the authentication action in the name of the given Resource ID. Steps:
   * <ul>
   * <li>Store the Resource ID assigned to the actual Thread.</li>
   * <li>Assign the given Resource ID to the actual Thread.</li>
   * <li>Execute the authenticated process.</li>
   * <li>Assign the previously stored Resource ID to the actual Thread (in case of an exception
   * too).</li>
   * </ul>
   *
   * @param <T>
   *          the return type of the authenticated action
   * @param authenticatedResourceId
   *          the Resource ID that will be assigned to the actual thread while executing the
   *          authenticated action, cannot be <code>null</code> and can be the Default Resource ID
   *          if the authentication fails
   * @param authenticatedAction
   *          the action to execute in the name of the Resource ID, cannot be <code>null</code>
   * @return the result of the executed authenticated action
   */
  <T> T runAs(long authenticatedResourceId, Supplier<T> authenticatedAction);

}

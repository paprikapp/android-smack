/*
 * Copyright (C) 2014 Paprikapp
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hu.paprikapp.smack.soup.app.login;

/**
 * Pure abstract user definition for authentication process.
 *
 * @author Balazs Varga
 */
public interface SmackUser {

    /**
     * Gets the identifier of user.
     *
     * @return Return the unique identifier of user.
     */
    String getId();

    /**
     * Sets the identifier of user.
     *
     * @param id Unique identifier of user.
     */
    void setId(String id);

    /**
     * Gets the username of user.
     *
     * @return Unique username of user.
     */
    String getUsername();

    /**
     * Sets the username of user.
     *
     * @param username Unique username of user.
     */
    void setUsername(String username);

    /**
     * Sets the password for authentication process.
     *
     * @param password Clear text password.
     */
    void setPassword(String password);
}

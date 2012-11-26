/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package javax.websocket;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ContainerProvider {

    private static final String CONTAINER_PROVIDER_IMPL =
            "org.apache.tomcat.websocket.ServerContainerImpl";

    public static ServerContainer getServerContainer() {
        // TODO SecurityManager
        ServerContainer result = null;
        try {
            Class<?> clazz = Class.forName(CONTAINER_PROVIDER_IMPL);
            Method m = clazz.getMethod("getServerContainer", (Class<?>[]) null);
            result = (ServerContainer) m.invoke(null, (Object[]) null);
        } catch (ClassNotFoundException | NoSuchMethodException |
                SecurityException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ClientContainer getClientContainer() {
        return null;
    }
}

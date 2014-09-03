/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.indytest;

import com.google.common.base.Throwables;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadLocalRandom;

public final class Bootstrap
{
    public static final Method METHOD;

    static {
        try {
            METHOD = Bootstrap.class.getMethod("bootstrap", MethodHandles.Lookup.class, String.class, MethodType.class, int.class);
        }
        catch (NoSuchMethodException e) {
            throw Throwables.propagate(e);
        }
    }

    public static CallSite bootstrap(MethodHandles.Lookup callerLookup, String name, MethodType type, int id)
            throws NoSuchMethodException, IllegalAccessException
    {
        System.out.println("initializing callsite #" + id);
        return new ConstantCallSite(callerLookup.findStatic(Bootstrap.class, "random", MethodType.methodType(int.class)));
    }

    public static int random()
    {
        return ThreadLocalRandom.current().nextInt();
    }
}

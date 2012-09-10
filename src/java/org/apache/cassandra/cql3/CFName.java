/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cassandra.cql3;

import java.util.Locale;

public class CFName
{
    private String ksName;
    private String cfName;

    public void setKeyspace(String ks, boolean keepCase)
    {
        ksName = keepCase ? ks : ks.toLowerCase(Locale.US);
    }

    public void setColumnFamily(String cf, boolean keepCase)
    {
        cfName = keepCase ? cf : cf.toLowerCase(Locale.US);
    }

    public boolean hasKeyspace()
    {
        return ksName != null;
    }

    public String getKeyspace()
    {
        return ksName;
    }

    public String getColumnFamily()
    {
        return cfName;
    }

    public String toResource()
    {
        return "/cassandra/keyspaces/" + (hasKeyspace() ? ksName + "/" + cfName : cfName);
    }

    @Override
    public String toString()
    {
        return (hasKeyspace() ? (ksName + ".") : "") + cfName;
    }
}

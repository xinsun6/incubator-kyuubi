/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.kyuubi.jdbc.hive.cli;

/**
 * FetchType indicates the type of fetchResults request. It maps the TFetchType, which is generated
 * from Thrift interface.
 */
public enum FetchType {
  QUERY_OUTPUT((short) 0),
  LOG((short) 1);

  private final short tFetchType;

  FetchType(short tFetchType) {
    this.tFetchType = tFetchType;
  }

  public static FetchType getFetchType(short tFetchType) {
    for (FetchType fetchType : values()) {
      if (tFetchType == fetchType.toTFetchType()) {
        return fetchType;
      }
    }
    return QUERY_OUTPUT;
  }

  public short toTFetchType() {
    return tFetchType;
  }
}

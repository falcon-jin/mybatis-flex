/*
 *  Copyright (c) 2022-2023, Mybatis-Flex (fuhai999@gmail.com).
 *  <p>
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  <p>
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mybatisflex.core.handler;

import com.google.gson.Gson;

public class GsonTypeHandler extends BaseJsonTypeHandler<Object> {

    private static Gson gson;
    private final Class<?> propertyType;

    public GsonTypeHandler(Class<?> type) {
        this.propertyType = type;
    }

    @Override
    protected Object parseJson(String json) {
        return getGson().fromJson(json, propertyType);
    }

    @Override
    protected String toJson(Object object) {
        return getGson().toJson(object);
    }


    public static Gson getGson() {
        if (null == gson) {
            gson = new Gson();
        }
        return gson;
    }

    public static void setGson(Gson gson) {
        GsonTypeHandler.gson = gson;
    }

}

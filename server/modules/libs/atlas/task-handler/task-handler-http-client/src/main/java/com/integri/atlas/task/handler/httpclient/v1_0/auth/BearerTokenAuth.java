/*
 * Copyright 2021 <your company/name>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.integri.atlas.task.handler.httpclient.v1_0.auth;

import static com.integri.atlas.task.handler.httpclient.HttpClientTaskConstants.TOKEN;

import com.integri.atlas.task.auth.TaskAuth;
import com.integri.atlas.task.handler.httpclient.v1_0.header.HttpHeader;
import com.integri.atlas.task.handler.httpclient.v1_0.param.HttpQueryParam;

import java.util.List;

/**
 * @author Ivica Cardic
 */
public class BearerTokenAuth implements Auth {

    @Override
    public void apply(List<HttpHeader> headers, List<HttpQueryParam> queryParameters, TaskAuth taskAuth) {
        headers.add(new HttpHeader("Authorization", "Bearer " + taskAuth.getProperty(TOKEN)));
    }
}

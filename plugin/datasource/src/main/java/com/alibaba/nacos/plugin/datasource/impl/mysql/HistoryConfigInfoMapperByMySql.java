/*
 * Copyright 1999-2022 Alibaba Group Holding Ltd.
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

package com.alibaba.nacos.plugin.datasource.impl.mysql;

import com.alibaba.nacos.plugin.datasource.constants.DataSourceConstant;
import com.alibaba.nacos.plugin.datasource.mapper.AbstractMapper;
import com.alibaba.nacos.plugin.datasource.mapper.HistoryConfigInfoMapper;

/**
 * The mysql implementation of HistoryConfigInfoMapper.
 *
 * @author hyx
 **/

public class HistoryConfigInfoMapperByMySql extends AbstractMapper implements HistoryConfigInfoMapper {

    @Override
    public String removeConfigHistory() {
        return "DELETE FROM his_config_info WHERE gmt_modified < ? LIMIT ?";
    }

    @Override
    public String findConfigHistory4PageFetchRows(int pageNo, int pageSize) {
        final StringBuilder builder = new StringBuilder();
        builder.append(findConfigHistoryFetchRows());
        builder.append(" limit " + pageSize + " offset " + (pageNo - 1) * pageSize);
        return builder.toString();
    }

    @Override
    public String getDataSource() {
        return DataSourceConstant.MYSQL;
    }

}

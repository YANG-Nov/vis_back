package com.dicadut.soms.service;

import com.dicadut.soms.domain.BusinessCode;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 业务编码表 服务类
 * </p>
 *
 * @author Radium
 * @since 2022-01-16
 */
public interface BusinessCodeService extends IService<BusinessCode> {

    /**
     * 生成特定业务表的业务编码<br>
     * 生成规则如下:<br>
     * 1.每张表按日生成，每日从1开始计<br>
     * 2.每日支持最多999999个编码的生成<br>
     * <p>
     * 示例: 20220106000001<br>
     * <p>
     * 备注:<br>
     * 1.线程安全，高并发环境下可能会有有些微小的性能开销<br>
     * 2.分布式环境下需要另行设计<br>
     *
     * @param tableName 表名
     * @return
     */
    String generateBusinessCode(String tableName);

}

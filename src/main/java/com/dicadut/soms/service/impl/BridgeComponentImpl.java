package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.BridgeComponent;
import com.dicadut.soms.mapper.BridgeComponentMapper;
import com.dicadut.soms.service.BridgeComponentService;
import org.springframework.stereotype.Service;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description 构件表 服务实现类
 * @date 2022-03-04 19:35
 */
@Service
public class BridgeComponentImpl extends ServiceImpl<BridgeComponentMapper, BridgeComponent> implements BridgeComponentService {
}

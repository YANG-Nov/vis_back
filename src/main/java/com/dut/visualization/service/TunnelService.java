package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.Tunnel;
import com.dut.visualization.dto.TunnelBasicInformationDTO;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
public interface TunnelService extends IService<Tunnel> {

    TunnelBasicInformationDTO getTunnelBasicInformation(String tunnelId);
}

package com.dut.visualization.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.Tunnel;
import com.dut.visualization.dto.TunnelBasicInformationDTO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
public interface TunnelMapper extends BaseMapper<Tunnel> {

    TunnelBasicInformationDTO selectTunnelBasicInformation(String tunnelId);
}

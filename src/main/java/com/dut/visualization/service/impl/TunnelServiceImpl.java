package com.dut.visualization.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dut.visualization.domain.Tunnel;
import com.dut.visualization.dto.TunnelBasicInformationDTO;
import com.dut.visualization.mapper.TunnelMapper;
import com.dut.visualization.service.TunnelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
@Slf4j
@Service
public class TunnelServiceImpl extends ServiceImpl<TunnelMapper, Tunnel> implements TunnelService {

    @Override
    public TunnelBasicInformationDTO getTunnelBasicInformation(String tunnelId){
        return baseMapper.selectTunnelBasicInformation(tunnelId);
    }
}

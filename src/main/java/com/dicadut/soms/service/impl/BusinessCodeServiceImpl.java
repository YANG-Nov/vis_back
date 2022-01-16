package com.dicadut.soms.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.BusinessCode;
import com.dicadut.soms.mapper.BusinessCodeMapper;
import com.dicadut.soms.service.BusinessCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务编码表 服务实现类
 * </p>
 *
 * @author Radium
 * @since 2022-01-16
 */
@Slf4j
@Service
public class BusinessCodeServiceImpl extends ServiceImpl<BusinessCodeMapper, BusinessCode> implements BusinessCodeService {

    @Override
    public synchronized String generateBusinessCode(String tableName) {
        String codeDate = DateUtil.format(DateUtil.date(), DatePattern.PURE_DATE_PATTERN);
        QueryWrapper<BusinessCode> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("table_name", tableName);
        queryWrapper.eq("code_date", codeDate);
        BusinessCode businessCode = baseMapper.selectOne(queryWrapper);
        if (businessCode == null) {
            businessCode = new BusinessCode();
            businessCode.setCurrentIndex(1);
            businessCode.setTableName(tableName);
            businessCode.setCodeDate(codeDate);
            baseMapper.insert(businessCode);
        } else {
            businessCode.setCurrentIndex(businessCode.getCurrentIndex() + 1);
            baseMapper.updateById(businessCode);
        }
        String code = String.format("%s%06d", businessCode.getCodeDate(), businessCode.getCurrentIndex());
        log.info("generate business code, table_name {}, business_code {}", tableName, code);
        return code;
    }

}

package com.dut.visualization.json;

import cn.hutool.core.date.BetweenFormatter;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Date;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 2:19 下午 2022/3/7
 * @ Description：倒计时
 * @Version: 1.0.0$
 */
@Slf4j
public class DeadLineSerializer extends JsonSerializer<String> {
    /**
     * 把java对象转换成json 返回给前端
     * Method that can be called to ask implementation to serialize
     * values of type this serializer handles.
     *
     * @param value       Value to serialize; can <b>not</b> be null.
     * @param gen         Generator used to output resulting Json content
     * @param serializers Provider that can be used to get serializers for
     */
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Date endDate = DateUtil.parse(value).toJdkDate();
        Date currentDate = DateUtil.beginOfDay(DateUtil.date());
        Long between = DateUtil.between(endDate, currentDate, DateUnit.MS);
        String result = DateUtil.formatBetween(between, BetweenFormatter.Level.DAY);
        gen.writeString(result);
        log.info("serialize rest time: {} -->> {}", value, result);
    }
}

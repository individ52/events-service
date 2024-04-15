package com.rikeventsmanager.eventsservice.Mapper;

import com.rikeventsmanager.eventsservice.DTO.PayMethodDto;
import com.rikeventsmanager.eventsservice.Model.PayMethod;

public class PayMethodMapper {
    public static PayMethodDto mapToPayMethodDto(PayMethod payMethod) {
        return new PayMethodDto(
                payMethod.getPayMethodCode(),
                payMethod.getPayMethodName()
        );
    }
    public static PayMethod mapToPayMethod(PayMethodDto payMethodDto) {
        return new PayMethod(
                payMethodDto.getPayMethodCode(),
                payMethodDto.getPayMethodName()
        );
    }
}

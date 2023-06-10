package com.example.practicing.Util;

import com.example.practicing.Dto.PracticeRequestDto;
import com.example.practicing.Dto.PracticeResponseDto;
import com.example.practicing.Entity.PracticeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PracticeMapping {
    public PracticeResponseDto mapPracticeDaoToPracticeResponseDto(PracticeDao save) {
        return PracticeResponseDto
                .builder().name(save.getName()).mail(save.getMail()).password(save.getPassword()).build();


    }
    public PracticeRequestDto mapPracticeDaoToPracticeRequestDto(PracticeDao save) {
        return PracticeRequestDto
                .builder().name(save.getName()).mail(save.getMail()).password(save.getPassword()).build();


    }
}

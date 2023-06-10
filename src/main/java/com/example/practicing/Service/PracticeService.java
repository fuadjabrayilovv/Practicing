package com.example.practicing.Service;

import com.example.practicing.Dto.PracticeRequestDto;
import com.example.practicing.Dto.PracticeResponseDto;
import com.example.practicing.Entity.PracticeDao;
import com.example.practicing.Repository.PracticeRepository;
import com.example.practicing.Util.PracticeMapping;
import com.example.practicing.enums.Status;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PracticeService {
    private final PracticeRepository practiceRepository;
    private final PracticeMapping practiceMapping;
    public void add(PracticeRequestDto practiceDto){
        Status status = Status.fromValue(practiceDto.getRoles());
        PracticeDao practiceDao = PracticeDao.builder().status(status).name(practiceDto.getName()).mail(practiceDto.getMail()).password(practiceDto.getPassword()).roles(practiceDto.getRoles()).build();
        PracticeDao save = practiceRepository.save(practiceDao);
    }

    public String login(PracticeRequestDto dto){

        List<PracticeDao> all = practiceRepository.findAll();
        log.info("start of the logging in");
        for (PracticeDao r:
                all
        )
        {
            if(r.getName().equals(dto.getName()) || r.getPassword().equals(dto.getPassword()) ){
                log.info("information written correctly,logging in.");

                return "succesfully logged in, your nickname: " + r.getName();


            }else{
                log.info("incorrect password or login");
                return "incorrect";
            }

        }
        return null;
    }
    public String resetPassword(PracticeResponseDto dto){
        List<PracticeDao> all = practiceRepository.findAll();
        for (PracticeDao r:
                all
        )
        {
            if(r.getMail().equals(dto.getMail()) ){
                r.setPassword(dto.getPassword());
                PracticeDao save = practiceRepository.save(r);
                log.info("new password: {}",String.valueOf(r.getPassword()));

                PracticeResponseDto responseDto = practiceMapping.mapPracticeDaoToPracticeResponseDto(save);
                log.info("Response from controller : {}", String.valueOf(responseDto));


                PracticeRequestDto practiceRequestDto = practiceMapping.mapPracticeDaoToPracticeRequestDto(save);
                log.info("Request from controller : {}", String.valueOf(practiceRequestDto));

                return "new password: " + r.getPassword();


            }else{
                log.info("no such mail");
                return "incorrect";
            }

        }
        return null;
    }
    public String logoutt(){
        return "logged out";
    }
    public String logout(){
        log.info("logged out");

        return "succesfully logged out";
    }
}

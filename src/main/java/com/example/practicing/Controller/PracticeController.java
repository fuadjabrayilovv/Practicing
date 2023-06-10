package com.example.practicing.Controller;

import com.example.practicing.Dto.PracticeRequestDto;
import com.example.practicing.Dto.PracticeResponseDto;
import com.example.practicing.Service.PracticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("practice")
@RequiredArgsConstructor
public class PracticeController {
    private  final PracticeService practiceService;
    @PostMapping("add")
    public void add(@RequestBody PracticeRequestDto dto){
        practiceService.add(dto);


    }
    @GetMapping("login")
    public String login(@RequestBody PracticeRequestDto dto) {
        return practiceService.login(dto);


    }
    @GetMapping("resetPassword")
    public String resetPassword(@RequestBody PracticeResponseDto dto){
        return practiceService.resetPassword(dto);
    }
    @GetMapping("logout")
    public String logout(){
        return practiceService.logout();
    }
}

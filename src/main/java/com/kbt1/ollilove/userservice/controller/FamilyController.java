package com.kbt1.ollilove.userservice.controller;

import com.kbt1.ollilove.userservice.service.FamilyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/family")
@Tag(name = "Family",description = "가족 API")
public class FamilyController {
//    private final FamilyService familyService;
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<> selectFamilyId(@PathVariable Long userId){
//        familyService
//    }
}

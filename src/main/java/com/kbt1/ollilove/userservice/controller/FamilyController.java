package com.kbt1.ollilove.userservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/family")
@Tag(name = "Family",description = "가족 API")
public class FamilyController {

//    @PostMapping("")
//    @Operation(summary = "가족 정보 가져오기")
//    public ResponseEntity<List<>> selectFamilyInfo(@RequestBody SignupDTO userRequestDTO) {
//        return ResponseEntity.ok();
//    }
}

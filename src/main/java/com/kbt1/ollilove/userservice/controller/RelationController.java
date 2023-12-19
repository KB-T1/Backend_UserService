package com.kbt1.ollilove.userservice.controller;

import com.kbt1.ollilove.userservice.dto.RelationDTO;
import com.kbt1.ollilove.userservice.service.RelationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/relation")
@Tag(name = "Relation", description = "관계API")
public class RelationController {

    private final RelationService relationService;
    @PostMapping("")
    @Operation(summary = "별명 정하기")
    public ResponseEntity<Boolean> saveNickname(@RequestBody RelationDTO relationDTO){
        return ResponseEntity.ok(relationService.saveRelation(relationDTO));
    }



}

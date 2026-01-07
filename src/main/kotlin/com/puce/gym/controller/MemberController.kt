package com.puce.gym.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.puce.gym.service.MemberService
import com.puce.gym.models.request.MemberRequest
import com.puce.gym.models.response.MemberResponse

@RestController
@RequestMapping("/api/members")
class MemberController(
    private val memberService: MemberService
) {

    @PostMapping
    fun createMember(@RequestBody request: MemberRequest): ResponseEntity<MemberResponse> {
        val member = memberService.createMember(request)
        return ResponseEntity.ok(member)
    }

    @GetMapping
    fun getAllMembers(): ResponseEntity<List<MemberResponse>> {
        val members = memberService.getAllMembers()
        return ResponseEntity.ok(members)
    }

    @GetMapping("/{id}")
    fun getMemberById(@PathVariable id: Long): ResponseEntity<MemberResponse> {
        val member = memberService.getMemberById(id)
        return ResponseEntity.ok(member)
    }

    @PutMapping("/{id}")
    fun updateMember(
        @PathVariable id: Long,
        @RequestBody request: MemberRequest
    ): ResponseEntity<MemberResponse> {
        val member = memberService.updateMember(id, request)
        return ResponseEntity.ok(member)
    }

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: Long): ResponseEntity<Void> {
        memberService.deleteMember(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/active/list")
    fun getActiveMembers(): ResponseEntity<List<MemberResponse>> {
        val members = memberService.getActiveMembers()
        return ResponseEntity.ok(members)
    }
}


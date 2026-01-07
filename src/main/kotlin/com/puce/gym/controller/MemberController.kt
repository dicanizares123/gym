package com.puce.gym.controller
}
    }
        return ResponseEntity.ok(members)
        val members = memberService.getActiveMembers()
    fun getActiveMembers(): ResponseEntity<List<MemberResponse>> {
    @GetMapping("/active")

    }
        return ResponseEntity.noContent().build()
        memberService.deleteMember(id)
    fun deleteMember(@PathVariable id: Long): ResponseEntity<Void> {
    @DeleteMapping("/{id}")

    }
        return ResponseEntity.ok(member)
        val member = memberService.updateMember(id, request)
    ): ResponseEntity<MemberResponse> {
        @RequestBody request: MemberRequest
        @PathVariable id: Long,
    fun updateMember(
    @PutMapping("/{id}")

    }
        return ResponseEntity.ok(member)
        val member = memberService.getMemberById(id)
    fun getMemberById(@PathVariable id: Long): ResponseEntity<MemberResponse> {
    @GetMapping("/{id}")

    }
        return ResponseEntity.ok(members)
        val members = memberService.getAllMembers()
    fun getAllMembers(): ResponseEntity<List<MemberResponse>> {
    @GetMapping

    }
        return ResponseEntity.status(HttpStatus.CREATED).body(member)
        val member = memberService.createMember(request)
    fun createMember(@RequestBody request: MemberRequest): ResponseEntity<MemberResponse> {
    @PostMapping

) {
    private val memberService: MemberService
class MemberController(
@RequestMapping("/api/members")
@RestController

import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import com.puce.gym.service.MemberService
import com.puce.gym.models.Response.MemberResponse
import com.puce.gym.models.Request.MemberRequest



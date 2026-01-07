package com.puce.gym.controller

import com.puce.gym.models.Request.MembershipRequest
import com.puce.gym.models.Response.MembershipResponse
import com.puce.gym.service.MembershipService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/memberships")
class MembershipController(
    private val membershipService: MembershipService
) {

    @PostMapping
    fun createMembership(@RequestBody request: MembershipRequest): ResponseEntity<MembershipResponse> {
        val membership = membershipService.createMembership(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(membership)
    }

    @GetMapping
    fun getAllMemberships(): ResponseEntity<List<MembershipResponse>> {
        val memberships = membershipService.getAllMemberships()
        return ResponseEntity.ok(memberships)
    }

    @GetMapping("/{id}")
    fun getMembershipById(@PathVariable id: Long): ResponseEntity<MembershipResponse> {
        val membership = membershipService.getMembershipById(id)
        return ResponseEntity.ok(membership)
    }

    @PutMapping("/{id}")
    fun updateMembership(
        @PathVariable id: Long,
        @RequestBody request: MembershipRequest
    ): ResponseEntity<MembershipResponse> {
        val membership = membershipService.updateMembership(id, request)
        return ResponseEntity.ok(membership)
    }

    @DeleteMapping("/{id}")
    fun deleteMembership(@PathVariable id: Long): ResponseEntity<Void> {
        membershipService.deleteMembership(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/active")
    fun getActiveMemberships(): ResponseEntity<List<MembershipResponse>> {
        val memberships = membershipService.getActiveMemberships()
        return ResponseEntity.ok(memberships)
    }
}


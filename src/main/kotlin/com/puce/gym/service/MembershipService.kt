package com.puce.gym.service

import com.puce.gym.mappers.MembershipMapper
import com.puce.gym.models.request.MembershipRequest
import com.puce.gym.models.response.MembershipResponse
import com.puce.gym.repositories.MembershipRepository
import org.springframework.stereotype.Service

@Service
class MembershipService(
    private val membershipRepository: MembershipRepository,
    private val membershipMapper: MembershipMapper
) {

    fun createMembership(request: MembershipRequest): MembershipResponse {
        val membership = membershipMapper.toEntity(request)
        val savedMembership = membershipRepository.save(membership)
        return membershipMapper.toResponse(savedMembership)
    }

    fun getAllMemberships(): List<MembershipResponse> {
        val memberships = membershipRepository.findAll()
        return membershipMapper.toResponseList(memberships)
    }

    fun getMembershipById(id: Long): MembershipResponse {
        val membership = membershipRepository.findById(id)
            .orElseThrow { RuntimeException("Membership not found with id: $id") }
        return membershipMapper.toResponse(membership)
    }

    fun updateMembership(id: Long, request: MembershipRequest): MembershipResponse {
        val existingMembership = membershipRepository.findById(id)
            .orElseThrow { RuntimeException("Membership not found with id: $id") }

        val updatedMembership = existingMembership.copy(
            name = request.name,
            description = request.description,
            durationDays = request.durationDays,
            price = request.price
        )

        val savedMembership = membershipRepository.save(updatedMembership)
        return membershipMapper.toResponse(savedMembership)
    }

    fun deleteMembership(id: Long) {
        val membership = membershipRepository.findById(id)
            .orElseThrow { RuntimeException("Membership not found with id: $id") }

        val inactiveMembership = membership.copy(active = false)
        membershipRepository.save(inactiveMembership)
    }

    fun getActiveMemberships(): List<MembershipResponse> {
        val memberships = membershipRepository.findByActive(true)
        return membershipMapper.toResponseList(memberships)
    }
}


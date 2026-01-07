package com.puce.gym.service

import org.springframework.stereotype.Service
import com.puce.gym.repositories.MemberRepository
import com.puce.gym.models.response.MemberResponse
import com.puce.gym.models.request.MemberRequest
import com.puce.gym.mappers.MemberMapper

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val memberMapper: MemberMapper
) {
    fun createMember(request: MemberRequest): MemberResponse {
        val member = memberMapper.toEntity(request)
        val savedMember = memberRepository.save(member)
        return memberMapper.toResponse(savedMember)
    }

    fun getAllMembers(): List<MemberResponse> {
        val members = memberRepository.findAll()
        return memberMapper.toResponseList(members)
    }

    fun getMemberById(id: Long): MemberResponse {
        val member = memberRepository.findById(id)
            .orElseThrow { RuntimeException("Member not found with id: $id") }
        return memberMapper.toResponse(member)
    }

    fun updateMember(id: Long, request: MemberRequest): MemberResponse {
        val existingMember = memberRepository.findById(id)
            .orElseThrow { RuntimeException("Member not found with id: $id") }
        val updatedMember = existingMember.copy(
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email,
            phone = request.phone,
            dateOfBirth = request.dateOfBirth
        )
        val savedMember = memberRepository.save(updatedMember)
        return memberMapper.toResponse(savedMember)
    }

    fun deleteMember(id: Long) {
        val member = memberRepository.findById(id)
            .orElseThrow { RuntimeException("Member not found with id: $id") }
        val inactiveMember = member.copy(active = false)
        memberRepository.save(inactiveMember)
    }

    fun getActiveMembers(): List<MemberResponse> {
        val members = memberRepository.findByActive(true)
        return memberMapper.toResponseList(members)
    }
}



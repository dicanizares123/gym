package com.puce.gym.service
}
    }
        return memberMapper.toResponseList(members)
        val members = memberRepository.findByActive(true)
    fun getActiveMembers(): List<MemberResponse> {

    }
        memberRepository.save(inactiveMember)
        val inactiveMember = member.copy(active = false)

            .orElseThrow { RuntimeException("Member not found with id: $id") }
        val member = memberRepository.findById(id)
    fun deleteMember(id: Long) {

    }
        return memberMapper.toResponse(savedMember)
        val savedMember = memberRepository.save(updatedMember)

        )
            dateOfBirth = request.dateOfBirth
            phone = request.phone,
            email = request.email,
            lastName = request.lastName,
            firstName = request.firstName,
        val updatedMember = existingMember.copy(

            .orElseThrow { RuntimeException("Member not found with id: $id") }
        val existingMember = memberRepository.findById(id)
    fun updateMember(id: Long, request: MemberRequest): MemberResponse {

    }
        return memberMapper.toResponse(member)
            .orElseThrow { RuntimeException("Member not found with id: $id") }
        val member = memberRepository.findById(id)
    fun getMemberById(id: Long): MemberResponse {

    }
        return memberMapper.toResponseList(members)
        val members = memberRepository.findAll()
    fun getAllMembers(): List<MemberResponse> {

    }
        return memberMapper.toResponse(savedMember)
        val savedMember = memberRepository.save(member)
        val member = memberMapper.toEntity(request)
    fun createMember(request: MemberRequest): MemberResponse {

) {
    private val memberMapper: MemberMapper
    private val memberRepository: MemberRepository,
class MemberService(
@Service

import org.springframework.stereotype.Service
import com.puce.gym.repositories.MemberRepository
import com.puce.gym.models.Response.MemberResponse
import com.puce.gym.models.Request.MemberRequest
import com.puce.gym.mappers.MemberMapper



package com.puce.gym.mappers

import org.springframework.stereotype.Component
import com.puce.gym.models.entities.Member
import com.puce.gym.models.request.MemberRequest
import com.puce.gym.models.response.MemberResponse

@Component
class MemberMapper {

    fun toEntity(request: MemberRequest): Member {
        return Member(
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email,
            phone = request.phone,
            dateOfBirth = request.dateOfBirth
        )
    }

    fun toResponse(member: Member): MemberResponse {
        return MemberResponse(
            id = member.id!!,
            firstName = member.firstName,
            lastName = member.lastName,
            email = member.email,
            phone = member.phone,
            dateOfBirth = member.dateOfBirth,
            registrationDate = member.registrationDate,
            active = member.active
        )
    }

    fun toResponseList(members: List<Member>): List<MemberResponse> {
        return members.map { toResponse(it) }
    }
}


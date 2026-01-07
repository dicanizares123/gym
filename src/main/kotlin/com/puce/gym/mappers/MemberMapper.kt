package com.puce.gym.mappers
}
    }
        return entities.map { toResponse(it) }
    fun toResponseList(entities: List<Member>): List<MemberResponse> {
    
    }
        )
            active = entity.active
            registrationDate = entity.registrationDate,
            dateOfBirth = entity.dateOfBirth,
            phone = entity.phone,
            email = entity.email,
            lastName = entity.lastName,
            firstName = entity.firstName,
            id = entity.id!!,
        return MemberResponse(
    fun toResponse(entity: Member): MemberResponse {
    
    }
        )
            active = true
            registrationDate = LocalDate.now(),
            dateOfBirth = request.dateOfBirth,
            phone = request.phone,
            email = request.email,
            lastName = request.lastName,
            firstName = request.firstName,
        return Member(
    fun toEntity(request: MemberRequest): Member {
    
class MemberMapper {
@Component

import java.time.LocalDate
import org.springframework.stereotype.Component
import com.puce.gym.models.Response.MemberResponse
import com.puce.gym.models.Request.MemberRequest
import com.puce.gym.models.Entities.Member



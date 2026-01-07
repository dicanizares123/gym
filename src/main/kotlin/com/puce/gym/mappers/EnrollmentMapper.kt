package com.puce.gym.mappers

import com.puce.gym.models.Entities.Enrollment
import com.puce.gym.models.Entities.Member
import com.puce.gym.models.Entities.Membership
import com.puce.gym.models.Request.EnrollmentRequest
import com.puce.gym.models.Response.EnrollmentResponse
import org.springframework.stereotype.Component

@Component
class EnrollmentMapper(
    private val memberMapper: MemberMapper,
    private val membershipMapper: MembershipMapper
) {
    
    fun toEntity(request: EnrollmentRequest, member: Member, membership: Membership): Enrollment {
        val endDate = request.startDate.plusDays(membership.durationDays.toLong())
        return Enrollment(
            member = member,
            membership = membership,
            startDate = request.startDate,
            endDate = endDate,
            active = true
        )
    }
    
    fun toResponse(entity: Enrollment): EnrollmentResponse {
        return EnrollmentResponse(
            id = entity.id!!,
            member = memberMapper.toResponse(entity.member),
            membership = membershipMapper.toResponse(entity.membership),
            startDate = entity.startDate,
            endDate = entity.endDate,
            active = entity.active
        )
    }
    
    fun toResponseList(entities: List<Enrollment>): List<EnrollmentResponse> {
        return entities.map { toResponse(it) }
    }
}


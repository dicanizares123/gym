package com.puce.gym.mappers

import com.puce.gym.models.entities.Membership
import com.puce.gym.models.request.MembershipRequest
import com.puce.gym.models.response.MembershipResponse
import org.springframework.stereotype.Component

@Component
class MembershipMapper {
    
    fun toEntity(request: MembershipRequest): Membership {
        return Membership(
            name = request.name,
            description = request.description,
            durationDays = request.durationDays,
            price = request.price,
            active = true
        )
    }
    
    fun toResponse(entity: Membership): MembershipResponse {
        return MembershipResponse(
            id = entity.id!!,
            name = entity.name,
            description = entity.description,
            durationDays = entity.durationDays,
            price = entity.price,
            active = entity.active
        )
    }
    
    fun toResponseList(entities: List<Membership>): List<MembershipResponse> {
        return entities.map { toResponse(it) }
    }
}


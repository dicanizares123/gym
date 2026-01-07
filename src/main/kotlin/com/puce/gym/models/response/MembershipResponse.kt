package com.puce.gym.models.response

import java.math.BigDecimal

data class MembershipResponse(
    val id: Long,
    val name: String,
    val description: String,
    val durationDays: Int,
    val price: BigDecimal,
    val active: Boolean
)


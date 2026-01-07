package com.puce.gym.models.Request

import java.math.BigDecimal

data class MembershipRequest(
    val name: String,
    val description: String,
    val durationDays: Int,
    val price: BigDecimal
)


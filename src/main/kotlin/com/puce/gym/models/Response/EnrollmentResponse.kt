package com.puce.gym.models.Response

import java.time.LocalDate

data class EnrollmentResponse(
    val id: Long,
    val member: MemberResponse,
    val membership: MembershipResponse,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val active: Boolean
)


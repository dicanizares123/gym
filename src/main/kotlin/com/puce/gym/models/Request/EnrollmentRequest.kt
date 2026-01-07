package com.puce.gym.models.Request

import java.time.LocalDate

data class EnrollmentRequest(
    val memberId: Long,
    val membershipId: Long,
    val startDate: LocalDate
)


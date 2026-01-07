package com.puce.gym.models.request

import java.time.LocalDate

data class EnrollmentRequest(
    val memberId: Long,
    val membershipId: Long,
    val startDate: LocalDate
)


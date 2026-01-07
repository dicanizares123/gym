package com.puce.gym.models.response

import java.time.LocalDate

data class MemberResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val dateOfBirth: LocalDate,
    val registrationDate: LocalDate,
    val active: Boolean
)


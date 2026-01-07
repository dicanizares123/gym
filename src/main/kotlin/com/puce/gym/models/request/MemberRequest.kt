package com.puce.gym.models.request

import java.time.LocalDate

data class MemberRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val dateOfBirth: LocalDate
)


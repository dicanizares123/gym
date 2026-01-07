package com.puce.gym.models.entities

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "members")
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val lastName: String,

    @Column(unique = true, nullable = false)
    val email: String,

    @Column(nullable = false)
    val phone: String,

    @Column(nullable = false)
    val dateOfBirth: LocalDate,

    @Column(nullable = false)
    val registrationDate: LocalDate = LocalDate.now(),

    @Column(nullable = false)
    val active: Boolean = true
)


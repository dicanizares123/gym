package com.puce.gym.models.Entities
)
    val active: Boolean = true
    @Column(nullable = false)

    val registrationDate: LocalDate = LocalDate.now(),
    @Column(nullable = false)

    val dateOfBirth: LocalDate,
    @Column(nullable = false)

    val phone: String,
    @Column(nullable = false)

    val email: String,
    @Column(unique = true, nullable = false)

    val lastName: String,
    @Column(nullable = false)

    val firstName: String,
    @Column(nullable = false)

    val id: Long? = null,
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
data class Member(
@Table(name = "members")
@Entity

import java.time.LocalDate
import jakarta.persistence.*



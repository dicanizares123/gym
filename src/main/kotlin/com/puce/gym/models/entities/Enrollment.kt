package com.puce.gym.models.entities

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "enrollments")
data class Enrollment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    val member: Member,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_id", nullable = false)
    val membership: Membership,

    @Column(nullable = false)
    val startDate: LocalDate,

    @Column(nullable = false)
    val endDate: LocalDate,

    @Column(nullable = false)
    val active: Boolean = true
)


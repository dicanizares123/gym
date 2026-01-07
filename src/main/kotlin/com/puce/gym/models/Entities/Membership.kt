package com.puce.gym.models.Entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "memberships")
data class Membership(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    val name: String,

    @Column(nullable = false)
    val description: String,

    @Column(nullable = false)
    val durationDays: Int,

    @Column(nullable = false)
    val price: BigDecimal,

    @Column(nullable = false)
    val active: Boolean = true
)


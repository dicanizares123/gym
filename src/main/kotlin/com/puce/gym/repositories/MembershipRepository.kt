package com.puce.gym.repositories

import com.puce.gym.models.Entities.Membership
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MembershipRepository : JpaRepository<Membership, Long> {
    fun findByActive(active: Boolean): List<Membership>
}


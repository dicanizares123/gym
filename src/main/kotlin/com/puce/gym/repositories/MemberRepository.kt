package com.puce.gym.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.puce.gym.models.entities.Member

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
    fun findByActive(active: Boolean): List<Member>
    fun findByEmail(email: String): Member?
}


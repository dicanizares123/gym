package com.puce.gym.repositories
}
    fun findByActive(active: Boolean): List<Member>
    fun findByEmail(email: String): Member?
interface MemberRepository : JpaRepository<Member, Long> {
@Repository

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.puce.gym.models.Entities.Member



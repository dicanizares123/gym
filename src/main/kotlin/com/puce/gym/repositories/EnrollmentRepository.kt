package com.puce.gym.repositories

import com.puce.gym.models.entities.Enrollment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnrollmentRepository : JpaRepository<Enrollment, Long> {
    fun findByMemberId(memberId: Long): List<Enrollment>
    fun findByActive(active: Boolean): List<Enrollment>
}


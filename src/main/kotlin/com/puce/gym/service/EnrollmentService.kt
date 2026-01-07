package com.puce.gym.service

import com.puce.gym.mappers.EnrollmentMapper
import com.puce.gym.models.request.EnrollmentRequest
import com.puce.gym.models.response.EnrollmentResponse
import com.puce.gym.repositories.EnrollmentRepository
import com.puce.gym.repositories.MemberRepository
import com.puce.gym.repositories.MembershipRepository
import org.springframework.stereotype.Service

@Service
class EnrollmentService(
    private val enrollmentRepository: EnrollmentRepository,
    private val memberRepository: MemberRepository,
    private val membershipRepository: MembershipRepository,
    private val enrollmentMapper: EnrollmentMapper
) {

    fun createEnrollment(request: EnrollmentRequest): EnrollmentResponse {
        val member = memberRepository.findById(request.memberId)
            .orElseThrow { RuntimeException("Member not found with id: ${request.memberId}") }

        val membership = membershipRepository.findById(request.membershipId)
            .orElseThrow { RuntimeException("Membership not found with id: ${request.membershipId}") }

        val enrollment = enrollmentMapper.toEntity(request, member, membership)
        val savedEnrollment = enrollmentRepository.save(enrollment)
        return enrollmentMapper.toResponse(savedEnrollment)
    }

    fun getAllEnrollments(): List<EnrollmentResponse> {
        val enrollments = enrollmentRepository.findAll()
        return enrollmentMapper.toResponseList(enrollments)
    }

    fun getEnrollmentById(id: Long): EnrollmentResponse {
        val enrollment = enrollmentRepository.findById(id)
            .orElseThrow { RuntimeException("Enrollment not found with id: $id") }
        return enrollmentMapper.toResponse(enrollment)
    }

    fun getEnrollmentsByMember(memberId: Long): List<EnrollmentResponse> {
        val enrollments = enrollmentRepository.findByMemberId(memberId)
        return enrollmentMapper.toResponseList(enrollments)
    }

    fun cancelEnrollment(id: Long) {
        val enrollment = enrollmentRepository.findById(id)
            .orElseThrow { RuntimeException("Enrollment not found with id: $id") }

        val canceledEnrollment = enrollment.copy(active = false)
        enrollmentRepository.save(canceledEnrollment)
    }

    fun getActiveEnrollments(): List<EnrollmentResponse> {
        val enrollments = enrollmentRepository.findByActive(true)
        return enrollmentMapper.toResponseList(enrollments)
    }
}


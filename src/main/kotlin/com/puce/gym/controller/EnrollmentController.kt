package com.puce.gym.controller

import com.puce.gym.models.Request.EnrollmentRequest
import com.puce.gym.models.Response.EnrollmentResponse
import com.puce.gym.service.EnrollmentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/enrollments")
class EnrollmentController(
    private val enrollmentService: EnrollmentService
) {

    @PostMapping
    fun createEnrollment(@RequestBody request: EnrollmentRequest): ResponseEntity<EnrollmentResponse> {
        val enrollment = enrollmentService.createEnrollment(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollment)
    }

    @GetMapping
    fun getAllEnrollments(): ResponseEntity<List<EnrollmentResponse>> {
        val enrollments = enrollmentService.getAllEnrollments()
        return ResponseEntity.ok(enrollments)
    }

    @GetMapping("/{id}")
    fun getEnrollmentById(@PathVariable id: Long): ResponseEntity<EnrollmentResponse> {
        val enrollment = enrollmentService.getEnrollmentById(id)
        return ResponseEntity.ok(enrollment)
    }

    @GetMapping("/member/{memberId}")
    fun getEnrollmentsByMember(@PathVariable memberId: Long): ResponseEntity<List<EnrollmentResponse>> {
        val enrollments = enrollmentService.getEnrollmentsByMember(memberId)
        return ResponseEntity.ok(enrollments)
    }

    @DeleteMapping("/{id}")
    fun cancelEnrollment(@PathVariable id: Long): ResponseEntity<Void> {
        enrollmentService.cancelEnrollment(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/active")
    fun getActiveEnrollments(): ResponseEntity<List<EnrollmentResponse>> {
        val enrollments = enrollmentService.getActiveEnrollments()
        return ResponseEntity.ok(enrollments)
    }
}


package com.puce.gym

import com.puce.gym.mappers.MemberMapper
import com.puce.gym.models.entities.Member
import com.puce.gym.models.request.MemberRequest
import com.puce.gym.models.response.MemberResponse
import com.puce.gym.repositories.MemberRepository
import com.puce.gym.service.MemberService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import java.util.*
import kotlin.test.assertEquals

@SpringBootTest
class GymApplicationTests {

	@Test
	fun contextLoads() {
	}

}

class MemberServiceTests {

	@Mock
	private lateinit var memberRepository: MemberRepository

	@Mock
	private lateinit var memberMapper: MemberMapper

	@InjectMocks
	private lateinit var memberService: MemberService

	private lateinit var testMember: Member
	private lateinit var testMemberRequest: MemberRequest
	private lateinit var testMemberResponse: MemberResponse

	@BeforeEach
	fun setUp() {
		MockitoAnnotations.openMocks(this)

		testMember = Member(
			id = 1L,
			firstName = "Juan",
			lastName = "Pérez",
			email = "juan@example.com",
			phone = "1234567890",
			dateOfBirth = LocalDate.of(1990, 5, 15),
			registrationDate = LocalDate.now(),
			active = true
		)

		testMemberRequest = MemberRequest(
			firstName = "Juan",
			lastName = "Pérez",
			email = "juan@example.com",
			phone = "1234567890",
			dateOfBirth = LocalDate.of(1990, 5, 15)
		)

		testMemberResponse = MemberResponse(
			id = 1L,
			firstName = "Juan",
			lastName = "Pérez",
			email = "juan@example.com",
			phone = "1234567890",
			dateOfBirth = LocalDate.of(1990, 5, 15),
			registrationDate = LocalDate.now(),
			active = true
		)
	}

	@Test
	fun `createMember should save and return member response`() {
		whenever(memberMapper.toEntity(testMemberRequest)).thenReturn(testMember)
		whenever(memberRepository.save(testMember)).thenReturn(testMember)
		whenever(memberMapper.toResponse(testMember)).thenReturn(testMemberResponse)

		val result = memberService.createMember(testMemberRequest)

		assertEquals(testMemberResponse, result)
		verify(memberRepository).save(testMember)
		verify(memberMapper).toEntity(testMemberRequest)
		verify(memberMapper).toResponse(testMember)
	}

	@Test
	fun `getAllMembers should return list of members`() {
		val members = listOf(testMember)
		val responses = listOf(testMemberResponse)

		whenever(memberRepository.findAll()).thenReturn(members)
		whenever(memberMapper.toResponseList(members)).thenReturn(responses)

		val result = memberService.getAllMembers()

		assertEquals(responses, result)
		assertEquals(1, result.size)
		verify(memberRepository).findAll()
	}

	@Test
	fun `getMemberById should return member when found`() {
		whenever(memberRepository.findById(1L)).thenReturn(Optional.of(testMember))
		whenever(memberMapper.toResponse(testMember)).thenReturn(testMemberResponse)

		val result = memberService.getMemberById(1L)

		assertEquals(testMemberResponse, result)
		verify(memberRepository).findById(1L)
	}

	@Test
	fun `getMemberById should throw exception when not found`() {
		whenever(memberRepository.findById(999L)).thenReturn(Optional.empty())

		assertThrows<RuntimeException> {
			memberService.getMemberById(999L)
		}
	}

	@Test
	fun `updateMember should update and return member response`() {
		val updatedRequest = MemberRequest(
			firstName = "Carlos",
			lastName = "García",
			email = "carlos@example.com",
			phone = "9876543210",
			dateOfBirth = LocalDate.of(1991, 6, 20)
		)

		val updatedMember = testMember.copy(
			firstName = "Carlos",
			lastName = "García",
			email = "carlos@example.com",
			phone = "9876543210",
			dateOfBirth = LocalDate.of(1991, 6, 20)
		)

		val updatedResponse = testMemberResponse.copy(
			firstName = "Carlos",
			lastName = "García",
			email = "carlos@example.com",
			phone = "9876543210",
			dateOfBirth = LocalDate.of(1991, 6, 20)
		)

		whenever(memberRepository.findById(1L)).thenReturn(Optional.of(testMember))
		whenever(memberRepository.save(updatedMember)).thenReturn(updatedMember)
		whenever(memberMapper.toResponse(updatedMember)).thenReturn(updatedResponse)

		val result = memberService.updateMember(1L, updatedRequest)

		assertEquals(updatedResponse, result)
		verify(memberRepository).findById(1L)
		verify(memberRepository).save(any())
	}

	@Test
	fun `updateMember should throw exception when member not found`() {
		whenever(memberRepository.findById(999L)).thenReturn(Optional.empty())

		assertThrows<RuntimeException> {
			memberService.updateMember(999L, testMemberRequest)
		}
	}

	@Test
	fun `deleteMember should deactivate member`() {
		val inactiveMember = testMember.copy(active = false)

		whenever(memberRepository.findById(1L)).thenReturn(Optional.of(testMember))
		whenever(memberRepository.save(inactiveMember)).thenReturn(inactiveMember)

		memberService.deleteMember(1L)

		verify(memberRepository).findById(1L)
		verify(memberRepository).save(inactiveMember)
	}

	@Test
	fun `deleteMember should throw exception when member not found`() {
		whenever(memberRepository.findById(999L)).thenReturn(Optional.empty())

		assertThrows<RuntimeException> {
			memberService.deleteMember(999L)
		}
	}

	@Test
	fun `getActiveMembers should return list of active members`() {
		val activeMembers = listOf(testMember)
		val responses = listOf(testMemberResponse)

		whenever(memberRepository.findByActive(true)).thenReturn(activeMembers)
		whenever(memberMapper.toResponseList(activeMembers)).thenReturn(responses)

		val result = memberService.getActiveMembers()

		assertEquals(responses, result)
		assertEquals(1, result.size)
		verify(memberRepository).findByActive(true)
	}

}


package com.forzafootball.forzafootballexam

import com.forzafootball.forzafootballexam.mocks.TeamsListResponseEventMock
import com.forzafootball.forzafootballexam.mvp.interactors.TeamsListInteractorImpl
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

/**
 * Unit Test class in Kotlin to test the correct/incorrect JSON responses from service
 * @author e.castellanos on 08/02/2018.
 */
@RunWith(MockitoJUnitRunner::class)
class TeamsListInteractorImplTest {
    @Mock
    lateinit var teamsListInteractor: TeamsListInteractorImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun testCorrectResponse200CodePayloadOk() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockSuccessResponsePayloadOk())
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, true)
        assertEquals(event.payload.size > 0, true)
    }

    @Test
    fun testCorrectResponse200CodeEmptyPayload() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockSuccessResponseEmptyPayload())
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, true)
        assertEquals(event.payload.size > 0, false)
    }

    @Test
    fun testCorrectParseJSONresponse() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockSuccessResponsePayloadOk())
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, true)
        assertEquals(event.payload.size > 0, true)

        assertEquals(event.payload[0].name, "Arsenal FC")
        assertEquals(event.payload[1].name, "FC Barcelona")
        assertEquals(event.payload[2].name, "Sweden")
        assertEquals(event.payload[3].name, "Inter Milan")


        assertEquals(event.payload[0].country_name, "England")
        assertEquals(event.payload[1].country_name, "Spain")
        assertEquals(event.payload[2].country_name, "Sweden")
        assertEquals(event.payload[3].country_name, "Italy")

        assertEquals(event.payload[0].isNational, false)
        assertEquals(event.payload[1].isNational, false)
        assertEquals(event.payload[2].isNational, true)
        assertEquals(event.payload[3].isNational, false)
    }

    @Test
    fun testErrorResponse400() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockErrorResponse(400))
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, false)
        assertEquals(event.throwable.message, "Error 400: Bad Request")
    }

    @Test
    fun testErrorResponse401() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockErrorResponse(401))
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, false)
        assertEquals(event.throwable.message, "Error 401: Unauthorized")
    }

    @Test
    fun testErrorResponse403() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockErrorResponse(403))
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, false)
        assertEquals(event.throwable.message, "Error 403: Forbidden")
    }

    @Test
    fun testErrorResponse404() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockErrorResponse(404))
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, false)
        assertEquals(event.throwable.message, "Error 404: Url Not Found")
    }

    @Test
    fun testErrorResponse408() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockErrorResponse(408))
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, false)
        assertEquals(event.throwable.message, "Error 408: Request Timeout")
    }

    @Test
    fun testErrorResponse500() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockErrorResponse(500))
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, false)
        assertEquals(event.throwable.message, "Error 500: Internal Server Error")
    }

    @Test
    fun testErrorResponse501() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockErrorResponse(501))
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, false)
        assertEquals(event.throwable.message, "Error 501: Not Implemented")
    }

    @Test
    fun testErrorResponse502() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockErrorResponse(502))
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, false)
        assertEquals(event.throwable.message, "Error 502: Bad Gateway")
    }

    @Test
    fun testErrorResponse503() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockErrorResponse(503))
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, false)
        assertEquals(event.throwable.message, "Error 503: Service Unavailable")
    }

    @Test
    fun testErrorResponse504() {
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockErrorResponse(504))
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, false)
        assertEquals(event.throwable.message, "Error 504: Gateway timeout")
    }

    @Test
    fun testErrorResponse505() {
        val errorCode = 505
        Mockito.`when`(teamsListInteractor.fetchData())
                .thenReturn(TeamsListResponseEventMock.mockErrorResponse(errorCode))
        val event = teamsListInteractor.fetchData()

        assertEquals(event.isSuccess, false)
        assertEquals(event.throwable.message, "Error $errorCode: Unrecognized Error")
    }
}
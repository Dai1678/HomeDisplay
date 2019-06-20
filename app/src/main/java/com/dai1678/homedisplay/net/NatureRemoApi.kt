package com.dai1678.homedisplay.net

import com.dai1678.homedisplay.entity.RemoResponse
import retrofit2.Response
import retrofit2.http.GET

interface NatureRemoApi {
    @GET("1/devices")
    suspend fun getMyDeviceInfosAsync(): Response<List<RemoResponse>>
}

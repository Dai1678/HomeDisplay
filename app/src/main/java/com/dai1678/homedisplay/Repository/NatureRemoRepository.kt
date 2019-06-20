package com.dai1678.homedisplay.Repository

import com.dai1678.homedisplay.entity.RemoResponse
import com.dai1678.homedisplay.net.NatureRemoApiClient.natureRemoApi

class NatureRemoRepository : BaseRepository() {

    companion object Factory {
        private var instance: NatureRemoRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: NatureRemoRepository().also { instance = it }
        }
    }

    suspend fun callMyDeviceInfosAsync(): List<RemoResponse>? {
        return safeApiCall(
            call = natureRemoApi.getMyDeviceInfosAsync(),
            error = "API Call Error"
        )
    }

}

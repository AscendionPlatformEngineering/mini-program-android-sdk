package com.ascendion.miniprogramandroidsdk

import android.app.Application
import com.ascendion.miniprogram.core.sdk.MiniProgramSDK

class HostApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Initialize the Mini Program SDK here
        MiniProgramSDK.init(this)
    }
}

package com.ascendion.miniprogramandroidsdk.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ascendion.miniprogram.BuildConfig
import com.ascendion.miniprogram.core.callback.MiniProgramCallback
import com.ascendion.miniprogram.core.config.HostAppContext
import com.ascendion.miniprogram.core.config.MiniProgramConfig
import com.ascendion.miniprogram.core.config.MiniProgramEvent
import com.ascendion.miniprogram.core.config.SessionConfig
import com.ascendion.miniprogram.core.sdk.MiniProgramSDK.launch
import com.ascendion.miniprogramandroidsdk.ui.theme.MiniAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiniAppTheme {
                launch(
                    context = this,
                    config = MiniProgramConfig(
                        appId = "bpi-meridian-remit",
                        title = "BPI Remittance",
                        env = if (BuildConfig.DEBUG) "debug" else "release",
                        nonce = "nonce", // optional
                        requestedVersion = this.packageManager.getPackageInfo(
                            this.packageName,
                            0
                        ).versionName.orEmpty(),
                        sessionConfig = SessionConfig.forUAT(),
                        context = HostAppContext(
                            "bpi-investments",
                            HostAppContext.Companion.Environment.UAT,
                            1739163905123,
                            "hostapp.menu.investments",
                            "hs_9f2a...c1",
                            "tok_rm_q81nX3"
                        )
                    ), object : MiniProgramCallback {
                        override fun onEvent(
                            event: MiniProgramEvent,
                            data: String?,
                        ) {
                            when (event) {
                                MiniProgramEvent.CONSENT_CONFIRMED -> {}
                                MiniProgramEvent.CONSENT_CANCELLED -> {}
                                MiniProgramEvent.NAVIGATE_TO_HOST -> {}
                                MiniProgramEvent.UNKNOWN -> {}
                                MiniProgramEvent.SESSION_LAUNCH -> {}
                                MiniProgramEvent.SESSION_TERMINATE -> {}
                                MiniProgramEvent.SESSION_IN_PROGRESS -> {}
                            }
                        }
                    })
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiniAppTheme {
        Greeting("Android")
    }
}
package com.example.composepritices.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.composepritices.R
import com.example.composepritices.ui.theme.ComposePriticesTheme
import kotlinx.coroutines.delay

private const val SplashWaitTime:Long=4000

@Composable
fun AnimatedPreloader(modifier: Modifier = Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(spec =
        LottieCompositionSpec.RawRes(
         R.raw.lottie_splash
    ))

    val preloaderProgress by animateLottieCompositionAsState(
        composition = preloaderLottieComposition,
        isPlaying = true
    )

    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = { preloaderProgress },
        modifier=modifier
        )
}
@Composable
fun SplashScreen(
    onTimeOut: () -> Unit = {},
){
    Surface {
       Box(
          modifier = Modifier.fillMaxSize(),
           contentAlignment = Alignment.Center
       ){
           val currentOnTimeout by rememberUpdatedState(newValue = onTimeOut)
           LaunchedEffect(Unit){
               delay(SplashWaitTime)
               currentOnTimeout()
           }

           AnimatedPreloader(modifier = Modifier
               .size(400.dp)
               .align(Alignment.Center))
       }
    }
}

@Preview
@Composable
fun SplashScreenPreView(){
    ComposePriticesTheme {
        SplashScreen()
    }
}
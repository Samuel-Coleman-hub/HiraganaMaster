package com.example.hiraganamaster;
// AnimationUtils.java
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

public class AnimationUtils {

    public static void shakeEditText(EditText editText) {
        TranslateAnimation shake = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -0.01f,
                Animation.RELATIVE_TO_PARENT, 0.01f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        shake.setDuration(100); // Duration in milliseconds (1 second)
        shake.setRepeatCount(5); // Number of times to repeat the animation
        shake.setRepeatMode(Animation.REVERSE); // Reverse the animation on repeat

        editText.startAnimation(shake);
    }
}
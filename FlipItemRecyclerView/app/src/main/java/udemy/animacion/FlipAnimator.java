package udemy.animacion;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;

/**
 * Created by daniel on 10/03/2017.
 */

public class FlipAnimator {
    private static String TAG = FlipAnimator.class.getSimpleName();
    private static AnimatorSet buttonIn, topOut, buttonOut, topIn;

    /**
     * Performs flip animation on two views
     */
    public static void flipView(Context context, final View back, final View front, boolean showFront) {
        buttonIn = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_button_in);
        topOut = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_top_out);
        buttonOut = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_button_out);
        topIn = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_top_in);

        final AnimatorSet showFrontAnim = new AnimatorSet();
        final AnimatorSet showBackAnim = new AnimatorSet();

        buttonIn.setTarget(back);
        topOut.setTarget(front);
        showFrontAnim.playTogether(buttonIn, topOut);

        buttonOut.setTarget(back);
        topIn.setTarget(front);
        showBackAnim.playTogether(topIn, buttonOut);

        if (showFront) {
            showFrontAnim.start();
        } else {
            showBackAnim.start();
        }
    }
}

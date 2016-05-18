package io.freshnotes.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by motan on 02.11.2015.
 */
public class KeyboardUtils {

    public static void showKeyboard(View view) {
        if (view == null) {
            return;
        }

        view.requestFocus();

        InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);

        ((InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(view, 0);

        if (!isKeyboardShowed(view)) {
            inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }

    public static boolean isKeyboardShowed(View view) {
        if (view == null) {
            return false;
        }
        InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        return inputManager.isActive(view);
    }


}

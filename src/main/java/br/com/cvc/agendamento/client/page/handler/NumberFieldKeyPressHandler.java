package br.com.cvc.agendamento.client.page.handler;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.IntegerBox;

public class NumberFieldKeyPressHandler implements KeyPressHandler {


    @Override
    public void onKeyPress(KeyPressEvent keyPressEvent) {
        if (!Character.isDigit(keyPressEvent.getCharCode())
                && keyPressEvent.getNativeEvent().getKeyCode() != KeyCodes.KEY_TAB
                && keyPressEvent.getNativeEvent().getKeyCode() != KeyCodes.KEY_BACKSPACE) {
            ((IntegerBox) keyPressEvent.getSource()).cancelKey();
            return;
        }
    }
}

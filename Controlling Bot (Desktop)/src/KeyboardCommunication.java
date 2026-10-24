import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.StandardWatchEventKinds;

public class KeyboardCommunication extends Thread {

    private Socket KeyboardSk;
    private BufferedReader reader;
    private Robot bot;

    public KeyboardCommunication(Socket sk){
        try{
            KeyboardSk = sk;
            System.out.println("Client connected.");
            reader = new BufferedReader(new InputStreamReader(KeyboardSk.getInputStream()));
            bot = new Robot();
        } catch (Exception e) {
            System.err.println("Error initializing server: " + e.getMessage());
            System.exit(1);
        }
        start();
    }

    @Override
    public void run(){
        try{
            while(true){
                int press;
                boolean pressed;
                int funcKey=0;
                int arrow = 5;
                String charrac ="";
                int choice = reader.read();
                if(choice == -1) break;
                switch (choice) {
                    case 0:
                        System.out.println("Case 0: Esc button pressed");
                        press = reader.read();
                        pressed = (press == 1);
                        escBtn(pressed);
                        break;
                    case 1:
                        System.out.println("Case 1: Tab button pressed");
                        press = reader.read();
                        pressed = (press == 1);
                        tabBtn(pressed);
                        break;
                    case 2:
                        System.out.println("Case 2: CapsLock button pressed");
                        press = reader.read();
                        pressed = (press == 1);
                        capslockBtn(pressed);
                        break;
                    case 3:
                        System.out.println("Case 3: Shift button pressed");
                        press = reader.read();
                        pressed = (press == 1);
                        shiftBtn(pressed);
                        break;
                    case 4:
                        System.out.println("Case 4: Control button pressed");
                        press = reader.read();
                        pressed = (press == 1);
                        controlBtn(pressed);
                        break;
                    case 5:
                        System.out.println("Case 5: Win button pressed");
                        press = reader.read();
                        pressed = (press == 1);
                        winBtn(pressed);
                        break;
                    case 6:
                        System.out.println("Case 6: Alt button pressed");
                        press = reader.read();
                        pressed = (press == 1);
                        altBtn(pressed);
                        break;
                    case 7:
                        System.out.println("Case 7: Space button pressed");
                        press = reader.read();
                        pressed = (press == 1);
                        spaceBtn(pressed);
                        break;
                    case 8:
                        System.out.println("Case 8: AltGr button pressed");
                        press = reader.read();
                        pressed = (press == 1);
                        altGrBtn(pressed);
                        break;
                    case 9:
                        System.out.println("Case 9: Backspace button pressed");
                        press = reader.read();
                        pressed = (press == 1);
                        backspaceBtn(pressed);
                        break;
                    case 10:
                        System.out.println("Case 10: Enter button pressed");
                        press = reader.read();
                        pressed = (press == 1);
                        enterBtn(pressed);
                        break;
                    case 11:
                        System.out.println("Case 11: Esc button clicked");
                        clickEscBtn();
                        break;
                    case 12:
                        System.out.println("Case 12: Tab button clicked");
                        clickTabBtn();
                        break;
                    case 13:
                        System.out.println("Case 13: CapsLock button clicked");
                        clickCapsBtn();
                        break;
                    case 14:
                        System.out.println("Case 14: Shift button clicked");
                        clickShiftBtn();
                        break;
                    case 15:
                        System.out.println("Case 15: Control button clicked");
                        clickControlBtn();
                        break;
                    case 16:
                        System.out.println("Case 16: Win button clicked");
                        clickWinBtn();
                        break;
                    case 17:
                        System.out.println("Case 17: Alt button clicked");
                        clickAltBtn();
                        break;
                    case 18:
                        System.out.println("Case 18: Space button clicked");
                        clickSpaceBtn();
                        break;
                    case 19:
                        System.out.println("Case 19: AltGr button clicked");
                        clickAltGrBtn();
                        break;
                    case 20:
                        System.out.println("Case 20: Backspace button clicked");
                        clickBackspaceBtn();
                        break;
                    case 21:
                        System.out.println("Case 21: Enter button clicked");
                        clickEnterBtn();
                        break;
                    case 22:
                        System.out.println("Case 22: Function key pressed");
                        funcKey = reader.read();
                        press = reader.read();
                        pressed = (press == 1);
                        funcBtn(funcKey, pressed);
                        break;
                    case 23:
                        System.out.println("Case 23: Letter/Number button pressed");
                        charrac = reader.readLine();
                        System.out.println("readed line:"+charrac);
                        press = reader.read();
                        pressed = (press == 1);
                        letterAndNumbersBtn(charrac.charAt(0), pressed);
                        break;
                    case 24:
                        System.out.println("Case 24: Symbol button pressed");
                        charrac = reader.readLine();
                        press = reader.read();
                        System.out.println("readed line:" + charrac);
                        pressed = (press == 1);
                        symbolBtn(charrac.charAt(0), pressed);
                        break;
                    case 25:
                        System.out.println("Case 25: Function key clicked");
                        funcKey = reader.read();
                        clickFuncBtn(funcKey);
                        break;
                    case 26:
                        System.out.println("Case 26: Letter/Number button clicked");
                        charrac = reader.readLine();
                        clickLetterAndNumbersBtn(charrac.charAt(0));
                        break;
                    case 27:
                        System.out.println("Case 27: Symbol button clicked again");
                        charrac = reader.readLine();
                        clickSymbolBtn(charrac.charAt(0));
                        break;
                    case 28:
                        System.out.println("Case 28: Arrow button click");
                        arrow = reader.read();
                        clickArrowBtn(arrow);
                        break;
                    case 29:
                        System.out.println("Case 29: arrow button pressed");
                        arrow = reader.read();
                        press = reader.read();
                        pressed = (press == 1);
                        pressArrowBtn(arrow, pressed);
                        break;
                    default:
                        System.out.println("Default case: No action");
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error in communication: " + e.getMessage());
        }finally {
            closeConnections();
        }
    }

    public void escBtn(boolean pressed){
        if(pressed){
                bot.keyPress(KeyEvent.VK_ESCAPE);
        }else {
                bot.keyRelease(KeyEvent.VK_ESCAPE);
        }
    }

    public void clickEscBtn(){
        bot.keyPress(KeyEvent.VK_ESCAPE);
        bot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public void tabBtn(boolean pressed){
        if(pressed){
            bot.keyPress(KeyEvent.VK_TAB);
        }else{
            bot.keyRelease(KeyEvent.VK_TAB);
        }
    }

    public void clickTabBtn(){
        bot.keyPress(KeyEvent.VK_TAB);
        bot.keyRelease(KeyEvent.VK_TAB);
    }

    public void capslockBtn(boolean pressed){
        if(pressed){
            bot.keyPress(KeyEvent.VK_CAPS_LOCK);
        }else{
            bot.keyRelease(KeyEvent.VK_CAPS_LOCK);
        }
    }

    public void clickCapsBtn(){
        bot.keyPress(KeyEvent.VK_CAPS_LOCK);
        bot.keyRelease(KeyEvent.VK_CAPS_LOCK);
    }

    public void shiftBtn(boolean pressed){
        if(pressed){
            bot.keyPress(KeyEvent.VK_SHIFT);
        }else{
            bot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    public void clickShiftBtn(){
        bot.keyPress(KeyEvent.VK_SHIFT);
        bot.keyRelease(KeyEvent.VK_SHIFT);
    }

    public void controlBtn(boolean pressed){
        if(pressed){
            bot.keyPress(KeyEvent.VK_CONTROL);
        }else{
            bot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    public void clickControlBtn(){
        bot.keyPress(KeyEvent.VK_CONTROL);
        bot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void winBtn(boolean pressed){
        if(pressed){
            bot.keyPress(KeyEvent.VK_WINDOWS);
        }else{
            bot.keyRelease(KeyEvent.VK_WINDOWS);
        }
    }

    public void clickWinBtn(){
        bot.keyPress(KeyEvent.VK_WINDOWS);
        bot.keyRelease(KeyEvent.VK_WINDOWS);
    }

    public void altBtn(boolean pressed){
        if(pressed){
            bot.keyPress(KeyEvent.VK_ALT);
        }else{
            bot.keyRelease(KeyEvent.VK_ALT);
        }
    }

    public void clickAltBtn(){
        bot.keyPress(KeyEvent.VK_ALT);
        bot.keyRelease(KeyEvent.VK_ALT);
    }

    public void spaceBtn(boolean pressed){
        if(pressed){
            bot.keyPress(KeyEvent.VK_SPACE);
        }else{
            bot.keyRelease(KeyEvent.VK_SPACE);
        }
    }

    public void clickSpaceBtn(){
        bot.keyPress(KeyEvent.VK_SPACE);
        bot.keyRelease(KeyEvent.VK_SPACE);
    }

    public void altGrBtn(boolean pressed){
        if(pressed){
            bot.keyPress(KeyEvent.VK_ALT_GRAPH);
        }else{
            bot.keyRelease(KeyEvent.VK_ALT_GRAPH);
        }
    }

    public void clickAltGrBtn(){
        bot.keyPress(KeyEvent.VK_ALT_GRAPH);
        bot.keyRelease(KeyEvent.VK_ALT_GRAPH);
    }

    public void backspaceBtn(boolean pressed){
        if(pressed){
            bot.keyPress(KeyEvent.VK_BACK_SPACE);
        }else{
            bot.keyRelease(KeyEvent.VK_BACK_SPACE);
        }
    }

    public void clickBackspaceBtn(){
        bot.keyPress(KeyEvent.VK_BACK_SPACE);
        bot.keyRelease(KeyEvent.VK_BACK_SPACE);
    }

    public void enterBtn(boolean pressed){
        if(pressed){
            bot.keyPress(KeyEvent.VK_ENTER);
        }else{
            bot.keyRelease(KeyEvent.VK_ENTER);
        }
    }

    public void clickEnterBtn(){
        bot.keyPress(KeyEvent.VK_ENTER);
        bot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void letterAndNumbersBtn(char key, boolean pressed){
        if(pressed){
            bot.keyPress(KeyEvent.getExtendedKeyCodeForChar(key));
        }else{
            bot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(key));
        }
    }

    public void clickLetterAndNumbersBtn(char key){
        bot.keyPress(KeyEvent.getExtendedKeyCodeForChar(key));
        bot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(key));
    }

    public void symbolBtn(char key, boolean pressed){
        if(pressed){
            if(isShiftRequired(key)){
                pressKeyWithShiftForSpecialChars(key);
            }else{
                bot.keyPress(KeyEvent.getExtendedKeyCodeForChar(key));
            }
        }else{
            if(isShiftRequired(key)){
                releaseKeyWithShiftForSpecialChars(key);
            }else{
                bot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(key));
            }
        }
    }

    public void clickSymbolBtn(char key){
        bot.keyPress(KeyEvent.getExtendedKeyCodeForChar(key));
        bot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(key));
    }

    public void funcBtn(int key, boolean pressed){
        if(pressed){
            pressFuncBtn(key);
        }else{
            releaseFuncBtn(key);
        }
    }

    public void clickFuncBtn(int key){
        switch (key){
            case 1:
                bot.keyPress(KeyEvent.VK_F1);
                bot.keyRelease(KeyEvent.VK_F1);
                break;
            case 2:
                bot.keyPress(KeyEvent.VK_F2);
                bot.keyRelease(KeyEvent.VK_F2);
                break;
            case 3:
                bot.keyPress(KeyEvent.VK_F3);
                bot.keyRelease(KeyEvent.VK_F3);
                break;
            case 4:
                bot.keyPress(KeyEvent.VK_F4);
                bot.keyRelease(KeyEvent.VK_F4);
                break;
            case 5:
                bot.keyPress(KeyEvent.VK_F5);
                bot.keyRelease(KeyEvent.VK_F5);
                break;
            case 6:
                bot.keyPress(KeyEvent.VK_F6);
                bot.keyRelease(KeyEvent.VK_F6);
                break;
            case 7:
                bot.keyPress(KeyEvent.VK_F7);
                bot.keyRelease(KeyEvent.VK_F7);
                break;
            case 8:
                bot.keyPress(KeyEvent.VK_F8);
                bot.keyRelease(KeyEvent.VK_F8);
                break;
            case 9:
                bot.keyPress(KeyEvent.VK_F9);
                bot.keyRelease(KeyEvent.VK_F9);
                break;
            case 10:
                bot.keyPress(KeyEvent.VK_F10);
                bot.keyRelease(KeyEvent.VK_F10);
                break;
            case 11:
                bot.keyPress(KeyEvent.VK_F11);
                bot.keyRelease(KeyEvent.VK_F11);
                break;
            case 12:
                bot.keyPress(KeyEvent.VK_F12);
                bot.keyRelease(KeyEvent.VK_F12);
                break;
            default: break;
        }
    }

    public void pressFuncBtn(int key){
        switch (key){
            case 1:
                bot.keyPress(KeyEvent.VK_F1);
                break;
            case 2:
                bot.keyPress(KeyEvent.VK_F2);
                break;
            case 3:
                bot.keyPress(KeyEvent.VK_F3);
                break;
            case 4:
                bot.keyPress(KeyEvent.VK_F4);
                break;
            case 5:
                bot.keyPress(KeyEvent.VK_F5);
                break;
            case 6:
                bot.keyPress(KeyEvent.VK_F6);
                break;
            case 7:
                bot.keyPress(KeyEvent.VK_F7);
                break;
            case 8:
                bot.keyPress(KeyEvent.VK_F8);
                break;
            case 9:
                bot.keyPress(KeyEvent.VK_F9);
                break;
            case 10:
                bot.keyPress(KeyEvent.VK_F10);
                break;
            case 11:
                bot.keyPress(KeyEvent.VK_F11);
                break;
            case 12:
                bot.keyPress(KeyEvent.VK_F12);
                break;
            default: break;
        }
    }

    public void releaseFuncBtn(int key){
        switch (key){
            case 1:
                bot.keyRelease(KeyEvent.VK_F1);
                break;
            case 2:
                bot.keyRelease(KeyEvent.VK_F2);
                break;
            case 3:
                bot.keyRelease(KeyEvent.VK_F3);
                break;
            case 4:
                bot.keyRelease(KeyEvent.VK_F4);
                break;
            case 5:
                bot.keyRelease(KeyEvent.VK_F5);
                break;
            case 6:
                bot.keyRelease(KeyEvent.VK_F6);
                break;
            case 7:
                bot.keyRelease(KeyEvent.VK_F7);
                break;
            case 8:
                bot.keyRelease(KeyEvent.VK_F8);
                break;
            case 9:
                bot.keyRelease(KeyEvent.VK_F9);
                break;
            case 10:
                bot.keyRelease(KeyEvent.VK_F10);
                break;
            case 11:
                bot.keyRelease(KeyEvent.VK_F11);
                break;
            case 12:
                bot.keyRelease(KeyEvent.VK_F12);
                break;
            default: break;
        }
    }

    private void clickArrowBtn(int key){
        switch (key){
            case 0:
                bot.keyPress(KeyEvent.VK_UP);
                bot.keyRelease(KeyEvent.VK_UP);
                break;
            case 1:
                bot.keyPress(KeyEvent.VK_DOWN);
                bot.keyRelease(KeyEvent.VK_DOWN);
                break;
            case 2:
                bot.keyPress(KeyEvent.VK_LEFT);
                bot.keyRelease(KeyEvent.VK_LEFT);
                break;
            case 3:
                bot.keyPress(KeyEvent.VK_RIGHT);
                bot.keyRelease(KeyEvent.VK_RIGHT);
                break;
            default: break;
        }
    }

    private void pressArrowBtn(int key, boolean press){
        switch (key){
            case 0:
                if(press){
                    bot.keyPress(KeyEvent.VK_UP);
                } else{
                    bot.keyRelease(KeyEvent.VK_UP);
                }
                break;
            case 1:
                if(press){
                    bot.keyPress(KeyEvent.VK_DOWN);
                } else{
                    bot.keyRelease(KeyEvent.VK_DOWN);
                }
                break;
            case 2:
                if (press) {
                    bot.keyPress(KeyEvent.VK_LEFT);
                } else{
                    bot.keyRelease(KeyEvent.VK_LEFT);
                }
                break;
            case 3:
                if(press){
                    bot.keyPress(KeyEvent.VK_RIGHT);
                } else{
                    bot.keyRelease(KeyEvent.VK_RIGHT);
                }
                break;
            default: break;
        }
    }

    private void closeConnections() {
        try {
            if (reader != null) reader.close();
            if (KeyboardSk != null) KeyboardSk.close();
            System.out.println("Connections closed.");
        } catch (Exception e) {
            System.err.println("Error closing connections: " + e.getMessage());
        }
    }

    private void pressKeyWithShiftForSpecialChars(char c) {
        switch (c) {
            case '!':
                pressKeyWithShift(KeyEvent.VK_1);
                break;
            case '@':
                pressKeyWithShift(KeyEvent.VK_2);
                break;
            case '#':
                pressKeyWithShift(KeyEvent.VK_3);
                break;
            case '$':
                pressKeyWithShift(KeyEvent.VK_4);
                break;
            case '%':
                pressKeyWithShift(KeyEvent.VK_5);
                break;
            case '^':
                pressKeyWithShift(KeyEvent.VK_6);
                break;
            case '&':
                pressKeyWithShift(KeyEvent.VK_7);
                break;
            case '*':
                pressKeyWithShift(KeyEvent.VK_8);
                break;
            case '(':
                pressKeyWithShift(KeyEvent.VK_9);
                break;
            case ')':
                pressKeyWithShift(KeyEvent.VK_0);
                break;
            case ':':
                pressKeyWithShift(KeyEvent.VK_SEMICOLON);
                break;
            case '"':
                pressKeyWithShift(KeyEvent.VK_QUOTE);
                break;
            case '<':
                pressKeyWithShift(KeyEvent.VK_COMMA);
                break;
            case '>':
                pressKeyWithShift(KeyEvent.VK_PERIOD);
                break;
            case '?':
                pressKeyWithShift(KeyEvent.VK_SLASH);
                break;
            case '_':
                pressKeyWithShift(KeyEvent.VK_MINUS);
                break;
            case '+':
                pressKeyWithShift(KeyEvent.VK_EQUALS);
                break;
            case '{':
                pressKeyWithShift(KeyEvent.VK_OPEN_BRACKET);
                break;
            case '}':
                pressKeyWithShift(KeyEvent.VK_CLOSE_BRACKET);
                break;
            case '|':
                pressKeyWithShift(KeyEvent.VK_BACK_SLASH);
                break;
            case '~':
                pressKeyWithShift(KeyEvent.VK_BACK_QUOTE);
                break;
            default:
                break;
        }
    }

    private void releaseKeyWithShiftForSpecialChars(char c) {
        switch (c) {
            case '!':
                releaseKeyWithShift(KeyEvent.VK_1);
                break;
            case '@':
                releaseKeyWithShift(KeyEvent.VK_2);
                break;
            case '#':
                releaseKeyWithShift(KeyEvent.VK_3);
                break;
            case '$':
                releaseKeyWithShift(KeyEvent.VK_4);
                break;
            case '%':
                releaseKeyWithShift(KeyEvent.VK_5);
                break;
            case '^':
                releaseKeyWithShift(KeyEvent.VK_6);
                break;
            case '&':
                releaseKeyWithShift(KeyEvent.VK_7);
                break;
            case '*':
                releaseKeyWithShift(KeyEvent.VK_8);
                break;
            case '(':
                releaseKeyWithShift(KeyEvent.VK_9);
                break;
            case ')':
                releaseKeyWithShift(KeyEvent.VK_0);
                break;
            case ':':
                releaseKeyWithShift(KeyEvent.VK_SEMICOLON);
                break;
            case '"':
                releaseKeyWithShift(KeyEvent.VK_QUOTE);
                break;
            case '<':
                releaseKeyWithShift(KeyEvent.VK_COMMA);
                break;
            case '>':
                releaseKeyWithShift(KeyEvent.VK_PERIOD);
                break;
            case '?':
                releaseKeyWithShift(KeyEvent.VK_SLASH);
                break;
            case '_':
                releaseKeyWithShift(KeyEvent.VK_MINUS);
                break;
            case '+':
                releaseKeyWithShift(KeyEvent.VK_EQUALS);
                break;
            case '{':
                releaseKeyWithShift(KeyEvent.VK_OPEN_BRACKET);
                break;
            case '}':
                releaseKeyWithShift(KeyEvent.VK_CLOSE_BRACKET);
                break;
            case '|':
                releaseKeyWithShift(KeyEvent.VK_BACK_SLASH);
                break;
            case '~':
                releaseKeyWithShift(KeyEvent.VK_BACK_QUOTE);
                break;
            default:
                break;
        }
    }

    private void pressKeyWithShift(int key) {
        bot.keyPress(KeyEvent.VK_SHIFT);
        bot.keyPress(key);
    }

    private void releaseKeyWithShift(int key) {
        bot.keyRelease(key);
        bot.keyRelease(KeyEvent.VK_SHIFT);
    }

    private boolean isShiftRequired(char c) {
        switch (c) {
            case '!':
            case '@':
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '(':
            case ')':
            case ':':
            case '"':
            case '<':
            case '>':
            case '?':
            case '_':
            case '+':
            case '{':
            case '}':
            case '|':
            case '~':
                return true;
            default:
                return false;
        }
    }

}

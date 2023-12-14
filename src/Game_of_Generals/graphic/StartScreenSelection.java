package Game_of_Generals.graphic;

public enum StartScreenSelection {
    START_GAME(0),
    VIEW_ABOUT(1);


    private final int lineNumber;

    StartScreenSelection(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public StartScreenSelection getSelection(int number) {
        if (number == 0)
            return START_GAME;
        else if (number == 1)
            return VIEW_ABOUT;
        else
            return null;
    }

    public StartScreenSelection select(boolean toUp) {

        int selection;

        if(lineNumber > -1 && lineNumber < 2){
            selection = lineNumber - (toUp ? 1 : -1);
            if(selection == -1)
                selection = 1;
            else if(selection == 2)
                selection = 0;
            return getSelection(selection);
        }

        return null;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}


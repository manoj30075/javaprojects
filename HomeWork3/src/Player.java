public class Player {
    String playerGuessWord;
    String playerFileName;
    int wordsGuessed = 0;
    Picture2 picture = new Picture2();

    public void setPlayerFileName(String playerFileName) {
        this.playerFileName = playerFileName;
    }

    public String getPlayerFileName() {
        return playerFileName;
    }

    public void setPlayerGuessWord(String playerGuessWord) {
        this.playerGuessWord = playerGuessWord;
    }

    public String getPlayerGuessWord() {
        return playerGuessWord;
    }

    public int getWordsGuessed() {
        return wordsGuessed;
    }

    public Picture2 getPicture() {
        return picture;
    }

    public void setPicture(Picture2 picture) {
        this.picture = picture;
    }
}

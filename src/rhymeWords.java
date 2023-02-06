import javafx.scene.image.Image;
import javafx.scene.media.Media;

public class rhymeWords {
    String word;
    Image image;
    Media audio;
    
    public rhymeWords(String word, Image image,Media audio) {
        this.word = word;
        this.image = image;
        this.audio = audio;
    }

    public String getWord() {
        return word;
    }

    public Image getImage() {
        return image;
    }


    public Media getAudio() {
        return audio;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setImage(Image image1) {
        this.image = image1;
    }

    public void setAudio(Media audio) {
        this.audio = audio;
    }


}

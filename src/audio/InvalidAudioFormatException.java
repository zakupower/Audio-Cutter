package audio;

/**
 * Created by Tomov on 1.7.2018 г..
 */
public class InvalidAudioFormatException extends Exception{
    public InvalidAudioFormatException(String msg){
        super(msg);
    }
    public InvalidAudioFormatException(){
    }
}

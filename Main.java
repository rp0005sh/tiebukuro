import java.util.concurrent.ExecutionException;
import am.ik.voicetext4j.EmotionalSpeaker;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("voicetext.apikey", "★APIキーはここに書く★");
        
		EmotionalSpeaker.HARUKA.ready()
			    .pitch(105)
			    .speed(105)
			    .very().happy()
			    .speak("こんにちは。私の名前は山田太郎です") // ここに設定した文字列を読み上げる
			    .get();
	}
}

import java.util.List;
import java.util.Map;

public class Characters {


    public static int id;
    private int instanceId;
    private Map<KeyCharacter, List<String>> characterMap;


    public Characters(Map<KeyCharacter, List<String>> characterMap) {
        this.instanceId = id++;
        this.characterMap = characterMap;
    }



    @Override
    public String toString() {
        return "Characters{" +
                "instanceId=" + instanceId +
                ", characterMap=" + characterMap +
                '}';
    }
}
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {

    public static int id;
    private int instanceId;
    private Category category;
    private String name;
    private Map<KeyCharacter, List<String>> characterMap;
    private double price;

    public Product(Category category, String name, Map<KeyCharacter, List<String>> characterMap, double price) {
        this.instanceId = id++;
        this.category = category;
        this.name = name;
        this.characterMap = characterMap;
        this.price = price;
    }



    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<KeyCharacter, List<String>> getCharacterMap() {
        return characterMap;
    }




    @Override
    public String toString() {
        return "Product{" +
                "instanceId=" + instanceId +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", characterMap=" + characterMap +
                ", price=" + price +
                '}';
    }
}

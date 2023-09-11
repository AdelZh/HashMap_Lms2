import java.util.*;

public class DataBase {

    private List<Product> products;

    public DataBase(List<Product> products) {
        this.products = products;
    }

    public List<String> filterByCharacter(KeyCharacter key, String value) {
        List<String> filteredValues = new ArrayList<>();

        for (Product product : products) {
            if (product.getCharacterMap().containsKey(key)) {
                List<String> valueList = product.getCharacterMap().get(key);
                if (valueList.contains(value)) {
                    filteredValues.add(value);
                }
            }
        }

        return filteredValues;
    }

    public List<Product> sortByCharacter(KeyCharacter key) {

        List<Product> sortedProducts = new ArrayList<>(products); // Create a copy of the original list

        Collections.sort(sortedProducts, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                if (product1.getCharacterMap().containsKey(key) && product2.getCharacterMap().containsKey(key)) {
                    String value1 = product1.getCharacterMap().get(key).toString();
                    String value2 = product2.getCharacterMap().get(key).toString();
                    return value1.compareTo(value2);
                }
                return 0;
            }
        });

        return sortedProducts; // Return the sorted list
    }

    public void deleteCharacterByKeyName(KeyCharacter name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product pp = iterator.next();
            Map<KeyCharacter, List<String>> characterMap = pp.getCharacterMap();
            if (characterMap.containsKey(name)) {
                List<String> removedCharacter = characterMap.remove(name);
                System.out.println("Removed character: " + removedCharacter);
            }
        }
    }

    public void deleteAllCharacters(int id) {
        for (Product pp : products) {
            if (pp.getInstanceId() == id) {
                Map<KeyCharacter, List<String>> characterMap = pp.getCharacterMap();


                for (List<String> characterList : characterMap.values()) {
                    for (String character : characterList) {
                        System.out.println("Removed character: " + character);
                    }
                }


                characterMap.clear();
            }
        }
    }

    public Product saveBook(Product product) {

        List<Product> newProduct = products;
        if (!newProduct.contains(product)) {

            newProduct.add(product);
            for (int i = 0; i < newProduct.size(); i++) {
                newProduct.get(i).setInstanceId(i + 1 - 1);
            }
            System.out.println("New Book added");
        } else {
            System.out.println("This book already exist");
        }
        return product;
    }


    public void updateProduct(int id, String name) {
        for (Product pp : products) {
            if (pp.getInstanceId() == id) {
                pp.setName(name);
                System.out.println(pp);
            }
        }

    }

    public void getByIdProduct(int id) {
        for (Product pp : products) {
            if (pp.getInstanceId() == id) {
                System.out.println(pp);
            }
        }
    }

    public void searchByProductName(String name) {
        for (Product pp : products) {
            if (pp.getName().contains(name)) {
                System.out.println(pp);
            }
        }
    }

    public void getAllProduct() {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product pp = iterator.next();
            System.out.println(pp);
        }
    }

}

























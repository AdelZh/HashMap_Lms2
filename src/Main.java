import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        Map<KeyCharacter, List<String>> characterListMap = new HashMap<>();
        characterListMap.put(KeyCharacter.RAM, List.of("32GB"));
        characterListMap.put(KeyCharacter.CPU, List.of("Dual-Core"));
        characterListMap.put(KeyCharacter.STORAGE, List.of("16GB"));

        Map<KeyCharacter, List<String>> characterListMap1 = new HashMap<>();
        characterListMap1.put(KeyCharacter.CPU, List.of("Single-Core"));

        Product product = new Product(Category.LAPTOP, "Windows", characterListMap, 34);
        Product product1 = new Product(Category.PHONE, "Linux", characterListMap1, 45);
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product1);

        DataBase dataBase = new DataBase(products);




        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Filter by character");
            System.out.println("2. Sort by character");
            System.out.println("3. Delete character by key name");
            System.out.println("4. Delete all character by product id");
            System.out.println("5. Save product");
            System.out.println("6. Get product by id");
            System.out.println("7. Search by product name");
            System.out.println("8. Get all product");
            System.out.println("9. Update the product name");
            System.out.println("10. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter character key:  RAM, CPU, STORAGE - ");
                    String key = scanner.next();
                    System.out.print("Enter character value to filter: 32GB, Dual-Core, 16GB, Single-Core - ");
                    String value = scanner.next();
                    KeyCharacter key1 = KeyCharacter.valueOf(key.toUpperCase());
                    System.out.println(dataBase.filterByCharacter(key1, value));
                    break;
                case 2:
                    System.out.print("Enter character key: (CPU) - ");
                    String key11 = scanner.next();
                    KeyCharacter key111 = KeyCharacter.valueOf(key11.toUpperCase());
                    System.out.println("Original products: " + products);
                    for (Product pp : dataBase.sortByCharacter(key111)) {
                        System.out.println(pp.getName());
                    }
                    break;
                    case 3:
                        System.out.println("Put name of key option is: RAM, CPU, STORAGE ");
                        String input1 = scanner.next();
                        KeyCharacter keyCharacter=KeyCharacter.valueOf(input1.toUpperCase());
                        dataBase.deleteCharacterByKeyName(keyCharacter);
                        break;
                case 4:
                    System.out.print("Put id to delete the characters: ");
                    int nn=scanner.nextInt();
                    dataBase.deleteAllCharacters(nn);
                    break;
                    case 5:
                    System.out.println(dataBase.saveBook(new Product(Category.LAPTOP, "Tech", characterListMap1, 20000)));
                    break;
                case 6:
                    System.out.print("Put id to get product: ");
                    int id=scanner.nextInt();
                    dataBase.getByIdProduct(id);
                    break;
                case 7:
                    System.out.print("Search product by part or fullName: ");
                    String h=scanner.next();
                    dataBase.searchByProductName(h);
                    break;
                case 8:
                    dataBase.getAllProduct();
                    break;
                case 9:
                    System.out.println("Write id of product to update the name: ");
                    int m=scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Put any name to update of the product name: ");
                    String ss=scanner.next();
                    dataBase.updateProduct(m, ss);
                    break;
                case 10:
                    System.exit(0);
            }

        }
    }






















}

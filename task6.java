import java.util.*;
class PhoneBook {
    private HashMap<String, HashSet<String>> phoneBook = new HashMap<>();
     public void addContact(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            HashSet<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }
    //Выводим содержимое телефонной книги, отсортированное по убыванию количества телефонных номеров
public void showPhoneBook() {
        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        // Сортировка в убывающем порядке по количеству телефонов
        sortedEntries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + " - " + entry.getValue().size() + " phones: " + entry.getValue());
        }
    }
}
public class task6 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("John", "123456");
        phoneBook.addContact("Alice", "789012");
        phoneBook.addContact("John", "345678");
        phoneBook.addContact("Bob", "901234");
        phoneBook.addContact("Alice", "567890");

        phoneBook.showPhoneBook();
    }
}

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
public void showPhoneBook() {
        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        // Сортировка в убывающем порядке по количеству телефонов
        sortedEntries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + " - " + entry.getValue().size() + " phones: " + entry.getValue());
        }
    }
}
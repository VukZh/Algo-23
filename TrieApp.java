package trieapp;

public class TrieApp {

    private TrieNode root; // корень

// рекурсивный ввод
    public void add(String str) {
        root = add(root, str, 0);
    }

    private TrieNode add(TrieNode tn, String str, int length) {
        if (tn == null) {
            tn = new TrieNode(); // создаем узел если его нет
        }
        if (length == str.length()) { // отмечаем конец слова
            tn.setFlagWord(true);
            return tn;
        }
        char nextC = str.charAt(length); // следущий узел
        tn.nextTrieNode[nextC] = add(tn.nextTrieNode[nextC], str, length + 1);
        return tn;
    }

// рекурсивный поиск
    public boolean find(String str) {
        TrieNode tn = find(root, str, 0);
        if (tn != null) {
            return true;
        } else {
            return false;
        }
    }

    private TrieNode find(TrieNode tn, String str, int length) {
        if (tn == null) {
            return null; // не дошли до конца поиска
        }
        if (length == str.length()) { // дошли до конца поиска
            if (tn.getFlagWord()) {
                return tn; // проверяем флаг слова
            } else {
                return null;
            }
        }
        char nextC = str.charAt(length); // следущий узел
        return find(tn.nextTrieNode[nextC], str, length + 1);
    }

// ввод строки (набора слов) в Trie
    public void addString(String str) {
        String[] arrStr = str.split(" ");
        for (String arrStr1 : arrStr) {
            add(arrStr1);
        }
    }

//////////////////////////////////////////////
    public static void main(String[] args) {

        TrieApp tn = new TrieApp();

        tn.add("aaasd"); // ввод слов
        tn.add("aasdg");
        tn.add("dogs");
        System.out.println(tn.find("dogs"));
        System.out.println(tn.find("Generate"));

        System.out.println("-----------");

        tn.addString("Generate Random Text "); // ввод строк
        System.out.println(tn.find("dogs"));
        System.out.println(tn.find("Generate"));

    }

}

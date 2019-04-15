package trieapp;

public class TrieNode { // класс узла бора

    private int alphabet = 256; // размер алфавита
    private boolean flagWord; // флаг слова
    public TrieNode[] nextTrieNode = new TrieNode[alphabet]; // массив потомков размером алфавита

    public void setFlagWord(boolean f) {
        flagWord = f;
    }

    public boolean getFlagWord() {
        return flagWord;
    }
}

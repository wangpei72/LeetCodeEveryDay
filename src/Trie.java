/**
 * 前缀树、字典树
 * @author wpkks
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie(){
        children = new Trie[26];
        isEnd = false;
    }

    /**
     * 插入这个单词
     * 每一次for循环内 node将被转移一次
     * @param word
     */
    public void insert(String word){
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';//计算该char相对a偏移量
                if(node.children[index] == null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word){
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;

    }

    public boolean startsWith(String prefix){
        return searchPrefix(prefix) != null;
    }

    public Trie searchPrefix(String prefix){
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

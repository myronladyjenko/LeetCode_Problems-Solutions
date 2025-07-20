class Solution {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            isWord = false;
            children = new TrieNode[27];
        }

        public String traverseForDebug() {
            // now let's do a traverse
            StringBuilder traversalOfTrie = new StringBuilder();
            traverse(this, new StringBuilder(), traversalOfTrie);
            return traversalOfTrie.toString();
        }

        public void traverse(TrieNode node, StringBuilder currentPath, StringBuilder traversalOfTrie) {
            if (node.isWord) {
                traversalOfTrie.append(currentPath)
                        .append("\n");
            }

            for (int i = 0; i < node.children.length; i++) {
                TrieNode child = node.children[i];

                // if child is not null then it's value will need to be added
                if (child != null) {
                    char ch = '/';
                    if (i != 26) {
                        ch = (char) ('a' + i);
                    } 

                    currentPath.append(ch);
                    traverse(child, currentPath, traversalOfTrie);
                    // cut the last character out to simulate traversing back
                    currentPath.setLength(currentPath.length() - 1);
                } 
            }
        }

        public void insert(String sToInsert) {
            TrieNode curr = this;

            for (char ch : sToInsert.toCharArray()) {
                int position = ch - 'a';
                if (ch == '/') {
                    position = 26;
                }

                // System.out.println(ch + "-" + (ch - 'a'));
                if (curr.children[position] == null) {
                    TrieNode newNode = new TrieNode();
                    curr.children[position] = newNode;
                }

                curr = curr.children[position];
            }
            curr.isWord = true;
        }

        /*
         * If hit existing node that ends the word -> it was found
         */
        public boolean isSubfolder(String sToSearch) {
            TrieNode curr = this;
            boolean isFound = false;

            int index = 0;
            for (char ch : sToSearch.toCharArray()) {
                int position = ch - 'a';
                if (ch == '/') {
                    position = 26;
                }

                // if node is null, and we got here, definitely not a subfolder
                if (curr.children[position] == null) {
                    return false;
                }
                // this is needed so that /a/b -> /a/b/c counted as subfolder
                if (curr.children[position].isWord) {
                    // somewhat a cheat? exception case
                    if (sToSearch.charAt(index + 1) == '/') {
                        return true;
                    }
                }

                curr = curr.children[position];
                index++;
            }

            // on the last node gives a definitive answer whether it's a subfolder or not
            return curr.isWord;
        }
    }

    TrieNode root;

    public List<String> removeSubfolders(String[] folder) {
        List<String> folders = new ArrayList<>();
        root = new TrieNode();

        // sort the folders by length and then build a try incrementally
        Arrays.sort(folder, (s1, s2) -> s1.length() - s2.length());
        root.insert(folder[0]);
        folders.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            String s = folder[i];

            // my seach doesn't just match, but if I go into some existing node that has 
            // isWord set to true, then it's guaranteed to be a subfolder
            if (!root.isSubfolder(s)) {
                folders.add(s);
                root.insert(s);
            }
        }

        // let's try inserting something
        // root.insert("myron/");
        // root.insert("ben/");
        // root.insert("vedant/roman/");

        // System.out.println("Trie:\n" + root.traverseForDebug());

        return folders;
    }
}
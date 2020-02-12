package com.lonuslan.dailyleetcode.chapter2.chapter2easy;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/12 11:14
 * @description： longest common prefix
 * @modified By：
 */
public class LongestCommonPrefix {

    /**
     * problem description:
     *
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     * Example 1:
     *
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     * Note:
     *
     * All given inputs are in lowercase letters a-z.
     *
     */

    /**
     * approach: Horizontal scanning
     * Intuition: For s start we will describe a simple way of finding the longest prefix
     * shared by a set of of Strings LCP(S1 ... Sn). We will use the observation that :
     * LCP(S1 ... Sn) = LCP( LCP( LCP(S1, S2), S3), ... Sn)
     * Time complexity : O(S) , where S is the sum of all characters in all strings.
     * In the worst case all nn strings are the same.
     * The algorithm compares the string S1 with the other strings [S1, S2 ... Sn]There are S character comparisons,
     * where S is the sum of all characters in the input array.
     * Space complexity : O(1). We only used constant extra space.
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * approach_2: Vertical scanning
     * Imagine a very short string is at the end of the array. The above approach will still do S comparisons.
     * One way to optimize this case is to do vertical scanning.
     * We compare characters from top to bottom on the same column (same character index of the strings) before moving on to the next column.
     * Time complexity : O(S), where S is the sum of all characters in all strings.
     * In the worst case there will be n equal strings with length m and the algorithm performs S = m*n character comparisons.
     * Even though the worst case is still the same as Approach 1,
     * in the best case there are at most n * minLen comparisons where minLen is the length of the shortest string in the array.
     * Space complexity : O(1). We only used constant extra space.
     * @param strs
     * @return
     */
    public static String longestCommonPrefix_approach_2(String[] strs) {
        if (strs == null || strs.length <= 0){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        for (int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++){
                if (i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * approach_3: Divide and conquer
     * Time complexity : O(S)
     * where S is the number of all characters in the array, S = m*n Time complexity is 2*T(n/2) + O(m) Therefore time complexity is O(S).
     * In the best case this algorithm performs O(minLen*n) comparisons, where minLen is the shortest string of the array
     * Space complexity : O(m*log n)
     * There is a memory overhead since we store recursive calls in the execution stack.
     * There are n*log n recursive calls, each store need mm space to store the result, so space complexity is O(m*log n)
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix_approach_3(String[] strs) {
        if (strs == null || strs.length <= 0){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        return longestCommonPrefix_approach_3(strs, 0, strs.length - 1);
    }

    private static String commonPrefix(String left, String right){
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++){
            if (left.charAt(i) != right.charAt(i)){
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    private static String longestCommonPrefix_approach_3(String[] strs, int l, int r){
        if (l == r){
            return strs[l];
        }else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix_approach_3(strs, l, mid);
            String lcpRight = longestCommonPrefix_approach_3(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    /**
     * approach_4: Binary search
     *
     *
     * The idea is to apply binary search method to find the string with maximum value L, which is common prefix of all of the strings.
     * The algorithm searches space is the interval (0 … minLen), where minLen is minimum string length and the maximum possible common prefix.
     * Each time search space is divided in two equal parts, one of them is discarded, because it is sure that it doesn't contain the solution.
     * There are two possible cases: S[ 1 ... mid ] is not a common string. This means that for each j > i S[1..j] is not a common string and we discard the second half of the search space.
     * S[1...mid] is common string. This means that for for each i < j S[1..i] is a common string and we discard the first half of the search space,
     * because we try to find longer common prefix
     *
     *
     * In the worst case we have n equal strings with length m
     * Time complexity : O(S*log n).
     * where SS is the sum of all characters in all strings.
     * The algorithm makes n*log n iterations, for each of them there are S=m * n comparisons,
     * which gives in total O(S* log n) time complexity.
     * Space complexity : O(1).
     * We only used constant extra space.
     * @param strs
     * @return
     */
    public static String longestCommonPrefix_approach_4(String[] strs) {
        if (strs == null || strs.length <= 0){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs){
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high){
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)){
                low = middle + 1;
            }else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) /  2);
    }

    private static boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++){
            if (!strs[i].startsWith(str1)){
                return false;
            }
        }
        return true;
    }


    // TODO read and think ...
    // Further thought / Follow up
    /**
     * problem further description:
     * Given a set of keys S = [S1, S2 ... Sn], find the longest common prefix among a string q and S.
     * This LCP query will be called frequently.
     */
    /**
     * approach_5:
     * Solution:
     * We could optimize LCP queries by storing the set of keys S in a Trie. For more information about Trie, please see this article Implement a trie (Prefix trie).
     * In a Trie, each node descending from the root represents a common prefix of some keys. But we need to find the longest common prefix of a string q and all key strings.
     * This means that we have to find the deepest path from the root, which satisfies the following conditions:
     * it is prefix of query string q each node along the path must contain only one child element.
     * Otherwise the found path will not be a common prefix among all strings. * the path doesn't comprise of nodes which are marked as end of key.
     * Otherwise the path couldn't be a prefix a of key which is shorter than itself.
     *
     * complexity:
     * In the worst case query qq has length mm and it is equal to all nn strings of the array.
     * Time complexity : pre_processing O(S).
     * where SS is the number of all characters in the array, LCP query O(m).
     * Trie build has O(S) time complexity. To find the common prefix of qq in the Trie takes in the worst case O(m).
     * Space complexity : O(S).
     * We only used additional S extra space for the Trie.
     * @param strs
     * @return
     */
    public String longestCommonPrefix_approach_5(String q, String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Trie trie = new Trie();
        for (int i = 1; i < strs.length ; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(q);
    }

    class TrieNode {
        // R links to node children
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        // number of children non null links
        private int size;
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
            size++;
        }

        public int getLinks() {
            return size;
        }
        //assume methods containsKey, isEnd, get, put are implemented as it is described
        //in  https://leetcode.com/articles/implement-trie-prefix-tree/)

        public boolean containsKey(char c){
            //TODO do not implement
            return true;
        }

        public TrieNode get(char c){
            //TODO do not implement
            return new TrieNode();
        }
        public boolean isEnd(){
            //TODO do not implement
            return true;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String str){
            //TODO do not implement
        }

        //assume methods insert, search, searchPrefix are implemented as it is described
        //in  https://leetcode.com/articles/implement-trie-prefix-tree/)
        private String searchLongestPrefix(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
                    prefix.append(curLetter);
                    node = node.get(curLetter);
                }
                else {
                    return prefix.toString();
                }

            }
            return prefix.toString();
        }
    }
}

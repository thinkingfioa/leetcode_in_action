package com.thinking.design.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: Implement Trie (Prefix Tree)
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Design Add and Search Words Data Structure
 * <p>
 * Design Search Autocomplete System
 * <p>
 * Replace Words
 * <p>
 * Implement Magic Dictionary
 * <p>
 * Encrypt and Decrypt Strings
 * <p>
 * Implement Trie II(Prefix Tree)
 *
 * @author vlin 2022/4/5
 */
public class Leetcode208 {

  private static class TrieNode {

    private boolean isEnd;
    private Character val;
    private Map<Character, TrieNode> nextNodeMap;

    public TrieNode() {
      this.isEnd = false;
      this.val = null;
      this.nextNodeMap = new HashMap<>();
    }

    public TrieNode(boolean isEnd, Character val) {
      this.isEnd = isEnd;
      this.val = val;
      this.nextNodeMap = new HashMap<>();
    }
  }

  /**
   * faster than 80.98%，less than 82.47%
   */
  static class Trie {

    private TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    public void insert(String word) {
      TrieNode move = root;
      for (int i = 0; i < word.length(); i++) {
        Character single = word.charAt(i);
        TrieNode find = move.nextNodeMap.get(single);
        if (find != null) {
          move = find;
        } else {
          TrieNode cur = new TrieNode(false, single);
          move.nextNodeMap.put(single, cur);
          move = cur;
        }
        if (i == word.length() - 1) {
          move.isEnd = true;
        }
      }
    }

    public boolean search(String word) {
      TrieNode move = root;
      for (int i = 0; i < word.length(); i++) {
        Character single = word.charAt(i);
        if (!move.nextNodeMap.containsKey(single)) {
          return false;
        }
        move = move.nextNodeMap.get(single);
        if (i == word.length() - 1) {
          return move.isEnd;
        }
      }
      return false;
    }

    public boolean startsWith(String prefix) {
      TrieNode move = root;
      for (int i = 0; i < prefix.length(); i++) {
        Character single = prefix.charAt(i);
        if (!move.nextNodeMap.containsKey(single)) {
          return false;
        }
        move = move.nextNodeMap.get(single);
      }
      return true;
    }
  }
}

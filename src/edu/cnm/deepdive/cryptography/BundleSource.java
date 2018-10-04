package edu.cnm.deepdive.cryptography;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class BundleSource implements WordSource {

  private ArrayList<String> words;

  public BundleSource(String baseName) {
    ResourceBundle bundle = ResourceBundle.getBundle(baseName);
    words = new ArrayList<>(
        bundle.keySet().stream()//create stream of keys(in a Resource Bundle, keys are always Strings, but they may not always be in other kinds of maps)
            .map((k) -> bundle.getString(k))//map lets us transform types, returns a stream of strings; BEFORE WE MAPPED, ALL WE HAD WERE KEYS
            .filter((s) -> !s.matches("^.*\\W|\\d.*$"))//filter out words with punctuation or non-word character
            .filter((s) -> s.length() > 3)
            .collect(Collectors.toList())//collect lets us collect the items into a different kind of structure, returns a list of strings, which we will use as the argument to our ArrayList constructor, which will create an ArrayList that contains all of our items
    );
  }

  @Override
  public String get(int i) {
    return words.get(i);
  }

  @Override
  public int size() {
    return words.size();
  }
}

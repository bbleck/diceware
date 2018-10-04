package edu.cnm.deepdive.cryptography;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class BundleSource implements WordSource {

  private ArrayList<String> words;

  public BundleSource(String baseName) {
    ResourceBundle bundle = ResourceBundle.getBundle(baseName);
    words = new ArrayList<>(
        bundle.keySet().stream()//create stream of keys(string)
            .map((k) -> bundle.getString(k))//map lets us transform types, returns a stream of strings
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

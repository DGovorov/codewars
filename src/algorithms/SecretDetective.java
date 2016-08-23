package algorithms;

import javafx.util.Pair;

import java.util.*;

/**
 * There is a secret string which is unknown to you. Given a collection of random triplets from the string,
 * recover the original string.
 * <p>
 * A triplet here is defined as a sequence of three lettersPool such that each letter occurs somewhere before the next
 * in the given string. "whi" is a triplet for the string "whatisup".
 * <p>
 * As a simplification, you may assume that no letter occurs more than once in the secret string.
 * <p>
 * You can assume nothing about the triplets given to you other than that they are valid triplets and that they contain
 * sufficient information to deduce the original string. In particular, this means that the secret string will never
 * contain lettersPool that do not occur in one of the triplets given to you.
 * <p>
 * Created by Dim on 22.08.2016.
 */
public class SecretDetective {

    List<Character> lettersPool;
    List<Pair<Character, Character>> relations;

    public String recoverSecret(char[][] triplets) {
        init(triplets);

        String result = "";
        while (lettersPool.size() > 0){
            char next = findLeftmostLetter();
            result += next;
            removePairsWithKey(next);
        }

        return result;
    }

    private void init(char[][] triplets) {
        lettersPool = new ArrayList<>();
        relations = new ArrayList<>();

        for (char[] triplet : triplets) {
            for (int i = 0; i < 3; i++) {
                if (!lettersPool.contains(triplet[i])) {
                    lettersPool.add(triplet[i]);
                }
            }

            relations.add(new Pair<>(triplet[0], triplet[1]));
            relations.add(new Pair<>(triplet[0], triplet[2]));
            relations.add(new Pair<>(triplet[1], triplet[2]));
        }
    }

    private void removePairsWithKey(Character c){
        relations.removeIf(x -> x.getKey().equals(c));
        lettersPool.remove(c);
    }

    private Character findLeftmostLetter() {
        List<Character> pool = new ArrayList<>(lettersPool);
        Collections.copy(pool, lettersPool);

        for (Pair<Character, Character> pair : relations) {
            pool.remove(pair.getValue());
        }

        return pool.get(0);
    }

}
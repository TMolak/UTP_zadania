/**
 * @author Molak Tomasz S26635
 */

package zad1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {

    private List<String> words;

    private Map<String, List<String>> mapOfAnagrams;

    public Anagrams(String path) {
        this.words = new ArrayList<>();
        this.mapOfAnagrams = new HashMap<>();
        File file = new File(String.valueOf(path));
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                words.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        addAnagramsToMap();
    }

    public void addAnagramsToMap() {
        for (String s : words) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (mapOfAnagrams.containsKey(sorted)) {
                mapOfAnagrams.get(sorted).add(s);
            } else {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(s);
                mapOfAnagrams.put(sorted, anagramList);
            }
        }
    }

    public List<List<String>> getSortedByAnQty() {
        List<List<String>> sortedList = mapOfAnagrams.values()
                .stream()
                .sorted(Comparator.comparingInt((List<String> list) -> list.size()).reversed())
                .collect(Collectors.toList());
        return sortedList;
    }

    public String getAnagramsFor(String word) {
        String anagrams = word + ": [";
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String wordSorted = new String(chars);
        List<String> anagramList = mapOfAnagrams.getOrDefault(wordSorted, Collections.emptyList());

        anagrams += anagramList.stream()
                .filter(anagram -> !anagram.equals(word))
                .collect(Collectors.joining(", "));

        return anagrams + "]";
    }


}  

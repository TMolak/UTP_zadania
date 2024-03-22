package zad3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProgLang {

    private Map<String, List<String>> langsMap;
    private Map<String, List<String>> progsMap;

    public ProgLang(String path) {
        this.langsMap = new LinkedHashMap<>();
        this.progsMap = new LinkedHashMap<>();
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitedLine = line.split("\t");
                String lang = splitedLine[0];
                List<String> names = new ArrayList<>();
                for (int i = 1; i < splitedLine.length; i++) {
                    if (!names.contains(splitedLine[i])){
                        names.add(splitedLine[i]);
                    }
                }

                langsMap.putIfAbsent(lang, names);

                names.forEach(name -> {
                    progsMap.computeIfAbsent(name, k -> new ArrayList<>()).add(lang);
                });
          }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, List<String>> getLangsMap() {
        return langsMap;
    }

    public Map<String, List<String>> getProgsMap() {
        return progsMap;
    }


    public Map<String, List<String>> getLangsMapSortedByNumOfProgs() {
        Map<String, List<String>> copyMap = new LinkedHashMap<>();
        copyMap.putAll(langsMap);
        Comparator<Map.Entry<String, List<String>>> comparator = Comparator
                .comparingInt(value -> value.getValue().size() * -1);
        return sorted(copyMap, comparator.thenComparing(Map.Entry::getKey));
    }

    public Map<String, List<String>> getProgsMapSortedByNumOfLangs() {
        Map<String, List<String>> copyMap = new LinkedHashMap<>();
        copyMap.putAll(progsMap);
        Comparator<Map.Entry<String, List<String>>> comparator = Comparator
                .comparingInt(value -> value.getValue().size() * -1);
        return sorted(copyMap, comparator.thenComparing(Map.Entry::getKey));
    }

    public Map<String, List<String>> getProgsMapForNumOfLangsGreaterThan(int i) {
        Map<String, List<String>> copyMap = new LinkedHashMap<>();
        copyMap.putAll(progsMap);

        return filtered(copyMap, e -> e.getValue().size() > i);
    }

    private <T, K> Map<T, List<K>> sorted(Map<T, List<K>> map, Comparator<Map.Entry<T, List<K>>> comparator) {
        return map.entrySet()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    }

    private <T, K> Map<T, List<K>> filtered(Map<T, List<K>> map, Predicate<Map.Entry<T, List<K>>> predicate) {
        return map.entrySet()
                .stream()
                .filter(predicate)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    }
}

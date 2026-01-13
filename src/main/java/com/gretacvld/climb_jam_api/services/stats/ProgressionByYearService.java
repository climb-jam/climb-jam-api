package com.gretacvld.climb_jam_api.services.stats;

import com.gretacvld.climb_jam_api.entities.Ascent;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProgressionByYearService {

    public Map<Integer, Map<String, String>> getProgressionByYear(List<Ascent> ascents) {
        return ascents.stream()
                .filter(ascent -> ascent.getDate() != null && ascent.getRoute() != null)
                .collect(Collectors.groupingBy(
                        ascent -> ascent.getDate().getYear(),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    String maxGrade = list.stream()
                                            .map(ascent -> ascent.getRoute().getGrade())
                                            .max(Comparator.comparingInt(this::convertGradeToNumeric))
                                            .orElse("N/A");
                                    Map<String, String> stats = new HashMap<>();
                                    stats.put("maxGrade", maxGrade);
                                    return stats;
                                }
                        )
                ));
    }

    private int convertGradeToNumeric(String grade) {
        Map<String, Integer> gradesMap = Map.ofEntries(
                Map.entry("1a", 1), Map.entry("1b", 2), Map.entry("1c", 3),
                Map.entry("2a", 4), Map.entry("2b", 5), Map.entry("2c", 6),
                Map.entry("3a", 7), Map.entry("3b", 8), Map.entry("3c", 9),
                Map.entry("4a", 10), Map.entry("4b", 11), Map.entry("4c", 12),
                Map.entry("5a", 13), Map.entry("5b", 14), Map.entry("5c", 15),
                Map.entry("6a", 16), Map.entry("6b", 17), Map.entry("6c", 18),
                Map.entry("7a", 19), Map.entry("7b", 20), Map.entry("7c", 21),
                Map.entry("8a", 22), Map.entry("8b", 23), Map.entry("8c", 24),
                Map.entry("9a", 25), Map.entry("9b", 26), Map.entry("9c", 27)
        );
        return gradesMap.getOrDefault(grade, 0);
    }
}
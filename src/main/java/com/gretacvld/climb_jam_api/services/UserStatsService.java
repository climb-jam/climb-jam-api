package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.UserStatsDTO;
import com.gretacvld.climb_jam_api.entities.Ascent;
import com.gretacvld.climb_jam_api.entities.Session;
import com.gretacvld.climb_jam_api.repositories.AscentRepository;
import com.gretacvld.climb_jam_api.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserStatsService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private AscentRepository ascentRepository;

    public UserStatsDTO getUserStats(Long userId) {

        List<Session> sessions = sessionRepository.findByUserId(userId);
        List<Ascent> ascents = ascentRepository.findByUserId(userId);

        long totalSessions = sessionRepository.countByUserId(userId);
        long totalAscents = ascentRepository.countByUserId(userId);

        int totalMetersClimbed = ascents.stream()
                .filter(ascent -> ascent.getRoute() != null && ascent.getRoute().getHeight() != null)
                .mapToInt(ascent -> ascent.getRoute().getHeight())
                .sum();

        // Ascents by Route Climbing Type
        Map<String, Long> ascentsByClimbingType = new LinkedHashMap<>();
        List<String> climbingTypes = List.of(
                "VOIE","BLOC","GRANDE_VOIE","TRADITIONNELLE","DEEP_WATER","VIA_FERRATA"
        );
        climbingTypes.forEach(type -> ascentsByClimbingType.put(type, 0L));

        ascents.forEach(ascent -> {
            if(ascent.getRoute() != null && ascent.getRoute().getClimbingTypes() != null) {
                ascent.getRoute().getClimbingTypes()
                        .forEach(type -> ascentsByClimbingType.put(type.name(),
                        ascentsByClimbingType.get(type.name()) + 1)
                );
            }
        });

        // Ascents by Route Grade
        Map<String, Long> ascentsByGrade = new LinkedHashMap<>();
        List<String> allGrades = List.of(
                "1a","1b","1c","2a","2b","2c","3a","3b","3c",
                "4a","4b","4c","5a","5b","5c","6a","6b","6c",
                "7a","7b","7c","8a","8b","8c","9a", "9b", "9c"
        );
        allGrades.forEach(grade -> ascentsByGrade.put(grade, 0L));

        ascents.stream()
                .filter(ascent -> ascent.getRoute() != null && ascent.getRoute().getGrade() !=null)
                .forEach(ascent -> ascentsByGrade.put(ascent.getRoute().getGrade(),
                        ascentsByGrade.get(ascent.getRoute().getGrade()) + 1));

        // Ascents by month
        Map<Month, Long> ascentsByMonth = Arrays.stream(Month.values())
                .collect(Collectors.toMap(month -> month, month -> 0L, (a,b) -> b, LinkedHashMap::new));
        ascents.forEach(ascent -> {
            if(ascent.getDate() != null) {
                Month month = ascent.getDate().getMonth();
                ascentsByMonth.put(month, ascentsByMonth.get(month) + 1);
            }
        });

        // Ascents by year
        Map<Integer, Long> ascentsByYear = new TreeMap<>();
        ascents.forEach(ascent -> {
            if(ascent.getDate() != null) {
                int year = ascent.getDate().getYear();
                ascentsByYear.put(year, ascentsByYear.getOrDefault(year, 0L) + 1);
            }
        });

        // Annual progress
        Map<Integer, Map<String, String>> progressionByYear = ascents.stream()
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

        UserStatsDTO dto = new UserStatsDTO();
        dto.setTotalSessions(totalSessions);
        dto.setTotalAscents(totalAscents);
        dto.setTotalMetersClimbed(totalMetersClimbed);
        dto.setAscentsByClimbingType(ascentsByClimbingType);
        dto.setAscentsByGrade(ascentsByGrade);
        dto.setAscentsByMonth(ascentsByMonth);
        dto.setAscentsByYear(ascentsByYear);
        dto.setProgressionByYear(progressionByYear);

        return dto;
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
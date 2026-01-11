package com.gretacvld.climb_jam_api.services.stats;

import com.gretacvld.climb_jam_api.entities.Ascent;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AscentsByGradeService {
    public Map<String, Long> getAscentsByGrade(List<Ascent> ascents) {
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
        return ascentsByGrade;
    }
}
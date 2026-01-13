package com.gretacvld.climb_jam_api.services.stats;

import com.gretacvld.climb_jam_api.entities.Ascent;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AscentsByClimbingTypeService {

    public Map<String, Long> getAscentsByClimbingType(List<Ascent> ascents) {
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
        return ascentsByClimbingType;
    }
}
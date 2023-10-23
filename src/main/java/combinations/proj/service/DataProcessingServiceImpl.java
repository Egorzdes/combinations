package combinations.proj.service;


import combinations.proj.model.DataRequest;
import org.assertj.core.groups.Tuple;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DataProcessingServiceImpl implements DataProcessingService {

    @Override
    public List<Tuple> generateCombinations(DataRequest request) {
        return getTuples(request);

    }

    public static List<Tuple> getTuples(DataRequest request) {
        List<Tuple> combinations = new ArrayList<>();
        Set<String> first = new HashSet<>(request.getFirst());
        Set<String> second = new HashSet<>(request.getSecond());
        Set<String> third = new HashSet<>(request.getThird());
        Set<String> fourth = new HashSet<>(request.getFourth());
        Set<String> fifth = new HashSet<>(request.getFifth());
        Set<String> sixth = new HashSet<>(request.getSixth());
        Set<String> seventh = new HashSet<>(request.getSeventh());
        Set<String> eight = new HashSet<>(request.getEight());
        for (String x : first) {
            for (String y : second) {
                for (String z : third) {
                    for (String m : fourth) {
                        for (String n : fifth) {
                            for (String o : sixth) {
                                for (String p : seventh) {
                                    for (String d : eight)
                                        combinations.add(new Tuple(new String[]{x, y, z, m, n, o, p, d}));
                                }
                            }
                        }
                    }
                }
            }
        }
        return combinations;
    }
}

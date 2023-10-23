package combinations.proj.service;

import combinations.proj.model.DataRequest;
import org.assertj.core.groups.Tuple;

import java.util.List;

public interface DataProcessingService {

    List<Tuple> generateCombinations(DataRequest request);
}

package sber_project.proj.controller;

import org.assertj.core.groups.Tuple;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import sber_project.proj.model.DataRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class DataProcessingController {
    private final AtomicInteger counter = new AtomicInteger(1);

    @PostMapping("/process-data")
    public ModelAndView processData(@RequestBody DataRequest request, Model model) {
        List<Tuple> combinations = generateCombinations(request);
        int combinationCount = combinations.size();

        ModelAndView modelAndView = new ModelAndView("dataProcessingResultPage");
        modelAndView.addObject("combinations", combinations);
        modelAndView.addObject("combinationCount", combinationCount);

        counter.set(1);
        return modelAndView;
    }


    private List<Tuple> generateCombinations(DataRequest request) {
        List<Tuple> combinations = new ArrayList<>();
        Set<String> first = new HashSet<>(request.getFirst());
        Set<String> second = new HashSet<>(request.getSecond());
        Set<String> third = new HashSet<>(request.getThird());
        Set<String> fourth = new HashSet<>(request.getFourth());
        Set<String> fifth = new HashSet<>(request.getFifth());
        Set<String> sixth = new HashSet<>(request.getSixth());
        Set<String> seventh = new HashSet<>(request.getSeventh());
        for (String x : first) {
            for (String y : second) {
                for (String z : third) {
                    for (String m : fourth) {
                        for (String n : fifth) {
                            for (String o : sixth) {
                                for (String p : seventh) {
                                    combinations.add(new Tuple(new String[]{x, y, z, m, n, o, p}));
                                }
                            }
                        }
                    }
                }
            }
        }
        return combinations;

    }


    @GetMapping("/dataProcessingPage")
    public String showDataProcessingPage() {
        return "dataProcessingPage";
    }
}
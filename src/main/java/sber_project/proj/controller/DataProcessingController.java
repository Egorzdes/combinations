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

        ModelAndView modelAndView = new ModelAndView("dataProcessingResultPage");
        modelAndView.addObject("combinations", combinations);

        counter.set(1);
        return modelAndView;
    }

    private List<Tuple> generateCombinations(DataRequest request) {
        List<Tuple> combinations = new ArrayList<>();
        Set<String> first = new HashSet<>(request.getfirst());
        Set<String> second = new HashSet<>(request.getsecond());
        Set<String> third = new HashSet<>(request.getsecond());
        for (String x : first) {
            for (String y : second) {
                for (String z : third) {
                    combinations.add(new Tuple(new String[]{x, y, z}));
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
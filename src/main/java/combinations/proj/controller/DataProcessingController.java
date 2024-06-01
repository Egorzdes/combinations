package combinations.proj.controller;

import combinations.proj.model.DataRequest;
import combinations.proj.service.DataProcessingService;
import combinations.proj.service.DataProcessingServiceImpl;
import org.assertj.core.groups.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/app")
public class DataProcessingController {

    private final DataProcessingService dp;

    @Autowired
    public DataProcessingController(DataProcessingService dp) {
        this.dp = dp;
    }

    private final AtomicInteger counter = new AtomicInteger(1);

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/process-data")
    public ModelAndView processData(@RequestBody DataRequest request) {
        List<Tuple> combinations = dp.generateCombinations(request);
        int combinationCount = combinations.size();

        ModelAndView modelAndView = new ModelAndView("dataProcessingResultPage");
        modelAndView.addObject("combinations", combinations);
        modelAndView.addObject("combinationCount", combinationCount);

        counter.set(1);
        return modelAndView;
    }


    @GetMapping("/dataProcessingPage")
    public String showDataProcessingPage() {
        return "dataProcessingPage";
    }
}

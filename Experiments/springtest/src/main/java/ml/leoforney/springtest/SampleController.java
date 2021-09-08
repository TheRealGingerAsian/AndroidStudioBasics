package ml.leoforney.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SampleController {

    @Autowired
    private ListService listService;

    @PostMapping("/addString")
    public String addStringToList(@RequestBody String newString) {
        listService.addStringToList(newString);
        return "Added";
    }

    @PostMapping("/deleteString")
    public String removeStringFromList(@RequestBody String removeString) {
        listService.removeStringFromList(removeString);
        return "Removed (if existed)";
    }

    @GetMapping("/getList")
    public List<String> getList() {
        return listService.getList();
    }

}

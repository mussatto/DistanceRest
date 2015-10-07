package distance.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * rest controller designed to expose the functionality
 * renders response as JSON
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/services/distance")
    public String distance(@RequestParam(value="loc", defaultValue="0") String loc){

        return loc;
    }
}

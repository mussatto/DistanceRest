package distance.app;

import distance.calc.City;
import distance.calc.Distance;
import distance.calc.DistanceCalculator;
import distance.dao.CityDAO;
import distance.dao.DatabaseInconsistencyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;


/**
 * rest controller designed to expose the functionality
 * renders response as JSON
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    public static final String PLEASE_INFORM_FROM_AND_TO_CITY_NAMES = "Please inform from and to city names";
    public static final String KM = "KM";
    public static final String MI = "MI";

    @RequestMapping("/services/distance")
    public Double distance(@RequestParam(value="from", defaultValue="") String from,
                           @RequestParam(value="to", defaultValue="") String to,
                           @RequestParam(value="unit", defaultValue="KM") String unit){

        if(from==null || to == null || "".equals(from) || "".equals(to)){
            throw new IllegalArgumentException(PLEASE_INFORM_FROM_AND_TO_CITY_NAMES);
        }

        try {
            CityDAO dao = new CityDAO();
            City cityfrom = dao.findByName(from);

            City cityto = dao.findByName(to);
            Distance distance=Distance.ZERO;

            if(KM.equals(unit)) {
                DistanceCalculator distancecalculator = DistanceCalculator.createDefault();
                distance = distancecalculator.calculateDistance(cityfrom, cityto);
            }else if(MI.equals(unit)){
                DistanceCalculator distancecalculator = DistanceCalculator.createInMiles();
                distance = distancecalculator.calculateDistance(cityfrom, cityto);
            }

            return distance.getUnits();
        } catch (DatabaseInconsistencyException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}

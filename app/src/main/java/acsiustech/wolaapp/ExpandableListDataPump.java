package acsiustech.wolaapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SAI on 11-07-2019.
 */

public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("India");
        cricket.add("Pakistan");
        cricket.add("Australia");
        cricket.add("England");
        cricket.add("South Africa");

        List<String> football = new ArrayList<String>();
        football.add("Brazil");
        football.add("Spain");
        football.add("Germany");
        football.add("Netherlands");
        football.add("Italy");

        List<String> basketball = new ArrayList<String>();
        basketball.add("United States");
        basketball.add("Spain");
        basketball.add("Argentina");
        basketball.add("France");
        basketball.add("Russia");

        List<String> basketball1 = new ArrayList<String>();
        basketball1.add("United States");
        basketball1.add("Spain");
        basketball1.add("Argentina");
        basketball1.add("France");
        basketball1.add("Russia");

        expandableListDetail.put("BASKETBALL TEAMS1", basketball1);
        expandableListDetail.put("CRICKET TEAMS", cricket);
        expandableListDetail.put("FOOTBALL TEAMS", football);
        expandableListDetail.put("BASKETBALL TEAMS", basketball);

        return expandableListDetail;
    }
}

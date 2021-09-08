package ml.leoforney.springtest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {

    private List<String> list;

    public ListService() {
        list = new ArrayList<String>();
    }

    public void addStringToList(String newVal) {
        list.add(newVal);
    }

    public void removeStringFromList(String removeVal) {
        list.remove(removeVal);
    }

    public List<String> getList() {
        return list;
    }

}

package fr.weefle.tddevweb.services;

import fr.weefle.tddevweb.models.LightBulb;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class LightBulbService {

    private int id = 0;
    private List<LightBulb> lightBulbList = new ArrayList<>();

    public LightBulbService(){
        this.addLightBulb();
    }

    public void addLightBulb(){
        lightBulbList.add(new LightBulb(this.id, false));
        this.id++;
    }

    public int getLightBulbSize(){
        return lightBulbList.size();
    }

    public void toggleLightBulb(int id) throws Exception {
        LightBulb found = lightBulbList.stream().filter(list->list.getId() == id).findFirst().orElse(null);
        if(found == null) throw new Exception("Id of lightBulb not found !");

        found.setState(!found.isState());
    }

    public void removeLightBulb(){
        if(lightBulbList.size()==0) return;
        lightBulbList.remove(lightBulbList.size()-1);
    }

}

package fr.weefle.tddevweb.controllers;

import fr.weefle.tddevweb.models.LightBulb;
import fr.weefle.tddevweb.services.LightBulbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LightBulbController {

    private final LightBulbService lightBulbService;

    public LightBulbController(LightBulbService lightBulbService){
        this.lightBulbService = lightBulbService;
    }

    @GetMapping("/lightBulb")
    public List<LightBulb> getLightBulbs(){
        return lightBulbService.getLightBulbList();
    }

    @PostMapping("/lightBulb")
    public ResponseEntity addLightBulb(){
        this.lightBulbService.addLightBulb();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/lightBulbSize")
    public int getLightBulbSize(){
        return this.lightBulbService.getLightBulbSize();
    }

    @DeleteMapping("/lightBulb")
    public ResponseEntity removeLightBulb(){
        this.lightBulbService.removeLightBulb();
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/lightBulb")
    public ResponseEntity updateLightBulb(@RequestParam("id") int id){
        try{
            this.lightBulbService.toggleLightBulb(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/errorBulb")
    public ResponseEntity error(){
        return ResponseEntity.internalServerError().build();
    }

}

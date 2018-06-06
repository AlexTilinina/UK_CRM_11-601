package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.services.CityService;
import ru.itis.services.PositionService;

@Controller
public class AdminController {

    @Autowired
    private CityService cityService;

    @Autowired
    private PositionService positionService;

    @GetMapping("/admin/setting")
    public String getSetting(@ModelAttribute("model")ModelMap model){
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("positions", positionService.getAllPositions());
        return "admin-setting";
    }
    @PostMapping("/admin/setting/add/city")
    public String addCity(@ModelAttribute("city")String city){
        cityService.add(city);
        return "redirect:/admin/setting";
    }
    @PostMapping("/admin/setting/add/position")
    public String addPosition(@ModelAttribute("position")String position){
        positionService.add(position);
        return "redirect:/admin/setting";
    }
}

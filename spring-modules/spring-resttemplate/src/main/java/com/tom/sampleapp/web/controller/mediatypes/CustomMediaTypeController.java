package com.tom.sampleapp.web.controller.mediatypes;

import com.tom.sampleapp.web.dto.TomItem;
import com.tom.sampleapp.web.dto.TomItemV2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", produces = "application/vnd.tom.api.v1+json")
public class CustomMediaTypeController {

    @RequestMapping(method = RequestMethod.GET, value = "/public/api/items/{id}", produces = "application/vnd.tom.api.v1+json")
    public @ResponseBody
    TomItem getItem(@PathVariable("id") String id) {
        return new TomItem("itemId1");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/public/api/items/{id}", produces = "application/vnd.tom.api.v2+json")
    public @ResponseBody
    TomItemV2 getItemSecondAPIVersion(@PathVariable("id") String id) {
        return new TomItemV2("itemName");
    }
}

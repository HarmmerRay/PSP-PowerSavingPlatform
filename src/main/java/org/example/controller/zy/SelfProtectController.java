package org.example.controller.zy;

import org.example.service.zy.serviceInterface.ProtectService;
import org.example.service.zy.interfaceImpl.ProtectServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zy
 */
@Controller
public class SelfProtectController {
    ProtectService protectService=new ProtectServiceImpl();
    @RequestMapping("selfProtect")
    public int selfProtect(){
        return 666666;
    }
}

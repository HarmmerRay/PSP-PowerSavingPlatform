package org.example.controller.zy;

import org.example.service.zy.MonitorService;
import org.example.service.zy.ProtectService;
import org.example.service.zy.ProtectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

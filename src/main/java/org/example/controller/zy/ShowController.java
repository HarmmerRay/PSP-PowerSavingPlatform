package org.example.controller.zy;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.entity.User;
import org.example.service.zy.interfaceImpl.MonitorServiceImpl;
import org.example.service.zy.serviceInterface.MonitorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zy
 */
@Controller
@Api(tags = "数据展示")
public class ShowController {

    MonitorService monitorService=new MonitorServiceImpl();
    @PostMapping("/show1")
    @ApiOperation("总闸实时数据")
    public @ResponseBody ElecBrake show1(@RequestBody @ApiParam(name = "user elecBrake的json文档")String json){
        JSONObject jsonObject= JSON.parseObject(json);
        User user=jsonObject.getObject("user",User.class);
        ElecBrake elecBrake=jsonObject.getObject("elecBrake",ElecBrake.class);
        while(true){
            try {
                monitorService.produceElecBrake(user,elecBrake);
                Thread.sleep(10000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    @PostMapping("/show2")
    @ApiOperation("插座实时数据")
    public @ResponseBody Socket show2(@RequestBody @ApiParam(name = "user&elecBrake& socket的json文档") String json){
        JSONObject jsonObject=JSON.parseObject(json);
        User user =jsonObject.getObject("user",User.class);
        ElecBrake elecBrake=jsonObject.getObject("elecBrake",ElecBrake.class);
        Socket socket=jsonObject.getObject("socket",Socket.class);
        while (true){
            try{
                monitorService.produceSocket(user,elecBrake,socket);
                Thread.sleep(10000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

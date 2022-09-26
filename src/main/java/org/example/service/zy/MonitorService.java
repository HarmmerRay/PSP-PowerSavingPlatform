package org.example.service.zy;

import org.example.entity.Brake;
import org.springframework.stereotype.Service;

/**
 *   监测
 * @author zy
 */

public interface MonitorService {
    /**
     * 展示现在 电压 电流 温度
     * @return 返回给前端数据对象
     */
    public Brake show();
    /**
     * 监测数据是否异常
     * @return 正常代表1绿  不稳定代表0黄   故障代表-1红
     */
    public int monitor();
}

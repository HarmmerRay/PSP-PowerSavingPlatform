package org.example.service.zy.serviceInterface;

import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.entity.User;
import org.springframework.stereotype.Service;

/**
 *   保护
 * @author zy
 */
@Service
public interface ProtectService {
    /**
     *自我保护方法，守护进程
     * 精准守护一个插座
     * @param user
     * @param elecBrake
     * @param socket
     * @return 返回守护状态，及电路状态
     */
    public int selfProtect(User user, ElecBrake elecBrake, Socket socket);

    /**
     * 守护整个电路
     * @param user
     * @param elecBrake
     * @return
     */
    public int selfProtect(User user, ElecBrake elecBrake);
}

package org.example.mapper.zy;

import org.example.entity.Socket;

import java.util.List;

public interface SocketWeekMapper {
    public int insertSocketWeek(Socket socketWeek);
    public int deleteSocketWeek(Socket socketWeek);
    public int updateSocketWeek(Socket socketWeek);
    public Socket selectSocketWeek(Socket socketWeek);
    public List<Socket> selectAll();
}

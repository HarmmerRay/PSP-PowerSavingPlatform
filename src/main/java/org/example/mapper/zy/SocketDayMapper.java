package org.example.mapper.zy;

import org.example.entity.Socket;

import java.util.List;

public interface SocketDayMapper {
    public int insertSocketDay(Socket socketDay);
    public int deleteSocketDay(Socket socketDay);
    public int updateSocketDay(Socket socketDay);
    public Socket selectSocketDay(Socket socketDay);
    public List<Socket> selectAll();
}

package org.example.mapper.zy;

import org.example.entity.Socket;

import java.util.List;

public interface SocketMapper {
    public int insertSocket(Socket socket);
    public int deleteSocket(Socket socket);
    public int updateSocket(Socket socket);
    public Socket selectSocket(Socket socket);
    public List<Socket> selectAll();
}

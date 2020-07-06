package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static ServerSocket server;
    // 线程池,处理每个客户端请求
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws IOException {
        start();
    }

    public static void start() throws IOException {
        try {
            // 通过构造函数创建ServerSocket
            server = new ServerSocket(8111);
            System.out.println("服务器已启动，端口号：" + 8111);
            while (true) {
                // 真正处理的还是Socket
                Socket socket = server.accept();// 阻塞方法
                // 把客户端请求打包成一个任务，放到线程池执行
                executorService.execute(new ServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                server.close();
            }
        }

    }
}

class ServerHandler implements Runnable {
    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            String message;
            String result;
            // 通过输入流读取客户端传输的数据
            while ((message = br.readLine()) != null) {
                System.out.println("server receive data:" + message);
                result = response(message);
                // 将业务结果通过输出流返回给客户端
                pw.println(result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }

    // 返回给客户端的应答
    public static String response(String msg) {
        return "Hello," + msg + ",Now is " + new java.util.Date(System.currentTimeMillis()).toString();
    }
}

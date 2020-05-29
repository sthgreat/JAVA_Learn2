package IO.Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private int port;
    private Selector selector;
    private ExecutorService service = Executors.newFixedThreadPool(5);

    public Server(int port){
        this.port = port;
    }

    public static void main(String[] args){
        new Server(8080).start();
    }

    public void init(){
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(port));
            selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("server started...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        this.init();
        while(true){
            try {
                int events = selector.select();
                if(events > 0){ //有io事件
                    Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                    while (selectionKeys.hasNext()){
                        SelectionKey key = selectionKeys.next();
                        selectionKeys.remove();
                        if(key.isAcceptable()){
                            accept(key);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

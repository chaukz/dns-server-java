package src.dns.handler;

import java.net.InetSocketAddress;

import src.dns.message.Message;

public class ForwardHandler implements Handler {

    private final InetSocketAddress resolverAddress;

    public ForwardHandler(InetSocketAddress resolverAddress) {
        this.resolverAddress = resolverAddress;
    }

    @Override
    public Message handle(Message request) {
        // Implementation for forwarding DNS requests
        Message response = new Message();

        response.id = request.id;
        response.flags = (short) (request.flags | 0x8000);
        response.qdCount = request.qdCount;
        response.anCount = request.anCount;
        response.nsCount = request.nsCount;
        response.arCount = request.arCount;

        return response;
    }
}
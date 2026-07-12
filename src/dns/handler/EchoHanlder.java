package src.dns.handler;

import src.dns.message.Message;

public class EchoHanlder implements Handler {
    @Override
    public Message handle(Message request) {
        Message response = new Message();

        // copy the transaction ID from the request
        // The client uses this to match responses to requests
        response.id = request.id;

        // Set the QR bit (bit 15) to 1 , making trhis a response
        // 0x8000 in binary: 1000 0000 0000 0000
        // request.flags | 0x8000 keeps alls other flags. flips QR to 1
        response.flags = (short) (request.flags | 0x8000);

        // copy the counts for now
        response.qdCount = request.qdCount;
        response.anCount = request.anCount;
        response.nsCount = request.nsCount;
        response.arCount = request.arCount;

        return response;
    }
}
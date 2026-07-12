package src.dns.message;

import java.nio.ByteBuffer;

public class Message{
    public short id;
    public short flags;
    public short qdCount;
    public short anCount;
    public short nsCount;
    public short arCount;

    public static Message parse(ByteBuffer buffer){
        Message msg = new Message();
        msg.id = buffer.getShort();
        msg.flags = buffer.getShort();
        msg.qdCount = buffer.getShort();
        msg.anCount = buffer.getShort();
        msg.nsCount = buffer.getShort();
        msg.arCount = buffer.getShort();
        return msg;
    }

    public void encode(ByteBuffer buffer){
        buffer.putShort(id);
        buffer.putShort(flags);
        buffer.putShort(qdCount);
        buffer.putShort(anCount);
        buffer.putShort(nsCount);
        buffer.putShort(arCount);
    }
}
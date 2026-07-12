package src.dns.handler;

import src.dns.message.Message;

public interface Handler {
    Message handle(Message request);
}
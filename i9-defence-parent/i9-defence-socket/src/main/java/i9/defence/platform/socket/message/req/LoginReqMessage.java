package i9.defence.platform.socket.message.req;

import i9.defence.platform.socket.message.MessageDecodeConvert;
import io.netty.buffer.ByteBuf;

public class LoginReqMessage extends MessageDecodeConvert {
    
    public byte dataLen;
    
    public byte[] data;

    @Override
    public void decode(ByteBuf buf) {
        this.dataLen = buf.readByte();
        this.data = new byte[this.dataLen];
        buf.readBytes(this.data);
    }
}

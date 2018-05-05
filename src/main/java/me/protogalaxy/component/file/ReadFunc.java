package me.protogalaxy.component.file;

import org.bytedeco.javacpp.*;

import static org.bytedeco.javacpp.avutil.*;

import java.nio.ByteBuffer;

public class ReadFunc extends avformat.Read_packet_Pointer_ByteBuffer_int {
    private ByteBuffer _buffer = null;

    public ReadFunc(ByteBuffer buffer) {
        super();
        this._buffer = buffer;
    }

    @Override
    public int call(Pointer opaque, ByteBuffer buf, int buf_size) {
        byte[] bytes = new byte[buf_size];
        int len;
        len = _buffer.limit();
        if (len == 0) {
            return (AVERROR_EOF);
        } else {
            buf.put(_buffer.array(), 0, len);
            return len;
        }
    }
}

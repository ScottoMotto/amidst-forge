// automatically generated by the FlatBuffers compiler, do not modify

package amidst.remote;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class CreateNewWorldReply extends Table {
  public static CreateNewWorldReply getRootAsCreateNewWorldReply(ByteBuffer _bb) { return getRootAsCreateNewWorldReply(_bb, new CreateNewWorldReply()); }
  public static CreateNewWorldReply getRootAsCreateNewWorldReply(ByteBuffer _bb, CreateNewWorldReply obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public CreateNewWorldReply __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }


  public static void startCreateNewWorldReply(FlatBufferBuilder builder) { builder.startObject(0); }
  public static int endCreateNewWorldReply(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}


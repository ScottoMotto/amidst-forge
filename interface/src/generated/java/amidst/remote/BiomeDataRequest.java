// automatically generated by the FlatBuffers compiler, do not modify

package amidst.remote;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class BiomeDataRequest extends Table {
  public static BiomeDataRequest getRootAsBiomeDataRequest(ByteBuffer _bb) { return getRootAsBiomeDataRequest(_bb, new BiomeDataRequest()); }
  public static BiomeDataRequest getRootAsBiomeDataRequest(ByteBuffer _bb, BiomeDataRequest obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public BiomeDataRequest __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int x() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int y() { int o = __offset(6); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int width() { int o = __offset(8); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int height() { int o = __offset(10); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public boolean useQuarterResolution() { int o = __offset(12); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }

  public static int createBiomeDataRequest(FlatBufferBuilder builder,
      int x,
      int y,
      int width,
      int height,
      boolean useQuarterResolution) {
    builder.startObject(5);
    BiomeDataRequest.addHeight(builder, height);
    BiomeDataRequest.addWidth(builder, width);
    BiomeDataRequest.addY(builder, y);
    BiomeDataRequest.addX(builder, x);
    BiomeDataRequest.addUseQuarterResolution(builder, useQuarterResolution);
    return BiomeDataRequest.endBiomeDataRequest(builder);
  }

  public static void startBiomeDataRequest(FlatBufferBuilder builder) { builder.startObject(5); }
  public static void addX(FlatBufferBuilder builder, int x) { builder.addInt(0, x, 0); }
  public static void addY(FlatBufferBuilder builder, int y) { builder.addInt(1, y, 0); }
  public static void addWidth(FlatBufferBuilder builder, int width) { builder.addInt(2, width, 0); }
  public static void addHeight(FlatBufferBuilder builder, int height) { builder.addInt(3, height, 0); }
  public static void addUseQuarterResolution(FlatBufferBuilder builder, boolean useQuarterResolution) { builder.addBoolean(4, useQuarterResolution, false); }
  public static int endBiomeDataRequest(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}


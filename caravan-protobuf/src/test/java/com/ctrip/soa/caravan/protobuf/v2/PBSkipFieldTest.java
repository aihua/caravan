package com.ctrip.soa.caravan.protobuf.v2;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.junit.Test;

public class PBSkipFieldTest {

  @Test
  public void testSkipUnownField() throws Exception {
    ThreeField threeField = new ThreeField();
    threeField.setF1(1);
    threeField.setF2(2);
    threeField.setF3(3);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    JacksonProtobuf2Serializer.INSTANCE.serialize(out, threeField);

    OneField oneField = JacksonProtobuf2Serializer.INSTANCE.deserialize(new ByteArrayInputStream(out.toByteArray()), OneField.class);

    assertEquals(threeField.getF3(), oneField.getF3());
  }

  public static class OneField {

    @JsonProperty(value = "f3", index = 3)
    private int f3;

    public int getF3() {
      return f3;
    }

    public void setF3(int f3) {
      this.f3 = f3;
    }
  }

  public static class ThreeField {

    @JsonProperty(value = "f1", index = 1)
    private int f1;

    @JsonProperty(value = "f2", index = 2)
    private int f2;

    @JsonProperty(value = "f3", index = 3)
    private int f3;

    public int getF1() {
      return f1;
    }

    public void setF1(int f1) {
      this.f1 = f1;
    }

    public int getF2() {
      return f2;
    }

    public void setF2(int f2) {
      this.f2 = f2;
    }

    public int getF3() {
      return f3;
    }

    public void setF3(int f3) {
      this.f3 = f3;
    }
  }

}
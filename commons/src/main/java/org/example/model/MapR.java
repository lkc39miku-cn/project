package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseR;
import org.example.constants.CodeEnum;

import java.io.Serial;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public final class MapR extends BaseR<Map<String, Object>, MapR> {

    @Serial
    private static final long serialVersionUID = -1243300953491952845L;

    @Override
    public MapR ok() {
        return (MapR) new MapR()
                .setCode(CodeEnum.SC_OK.getCode())
                .setMessage(CodeEnum.SC_OK.getMessage());
    }

    @Override
    public MapR ok(Map<String, Object> data) {
        return (MapR) ok()
                .setData(data);
    }

    @Override
    public MapR fail() {
        return (MapR) new MapR()
                .setCode(CodeEnum.SC_INTERNAL_SERVER_ERROR.getCode())
                .setMessage(CodeEnum.SC_INTERNAL_SERVER_ERROR.getMessage());
    }

    @Override
    public MapR fail(String message) {
        return (MapR) fail()
                .setMessage(message);
    }
}

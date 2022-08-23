package org.example.result;

import lombok.Data;
import lombok.experimental.Accessors;
import org.example.constants.CodeEnum;
import org.example.exception.service.ServiceException;

@Data
@Accessors(fluent = true)
public final class ServiceExecute {
    public enum ExecuteStatus {
        INSERT("添加出现错误"),
        UPDATE("修改出现错误"),
        DELETE("删除出现错误");

        private final String message;
        ExecuteStatus(String message) {
            this.message = message;
        }
    }

    public static void compare(int count, ExecuteStatus executeStatus) {
        if (count <= 0) throw new ServiceException(CodeEnum.SC_OK, executeStatus.message);
    }

    public static void compare(int count, int size, ExecuteStatus executeStatus) {
        if (size <= 0 || count != size) throw new ServiceException(CodeEnum.SC_OK, executeStatus.message);
    }

    public static void compare(boolean flag, ExecuteStatus executeStatus) {
        if (!flag) throw new ServiceException(CodeEnum.SC_OK, executeStatus.message);
    }
}

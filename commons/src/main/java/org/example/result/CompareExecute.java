package org.example.result;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.model.R;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public final class CompareExecute<T> extends R<T> {

    @Serial
    private static final long serialVersionUID = 7444970589490469245L;

    public enum ExecuteStatus {
        INSERT("添加成功", "添加失败"),
        UPDATE("修改成功", "修改失败"),
        DELETE("删除成功", "删除失败");

        private final String success;
        private final String error;

        ExecuteStatus(String success, String error) {
            this.success = success;
            this.error = error;
        }
    }

    public R<String> compare(int count, ExecuteStatus executeStatus) {
        if (count > 0) {
            return new R<String>()
                    .ok(executeStatus.success);
        } else {
            return new R<String>()
                    .fail(executeStatus.error);
        }
    }

    public R<String> compare(int count, int size, ExecuteStatus executeStatus) {
        if (size > 0 && count == size) {
            return new R<String>()
                    .ok(executeStatus.success);
        } else {
            return new R<String>()
                    .fail(executeStatus.error);
        }
    }

    public R<String> compare(boolean flag, ExecuteStatus executeStatus) {
        if (flag) {
            return new R<String>()
                    .ok(executeStatus.success);
        } else {
            return new R<String>()
                    .fail(executeStatus.error);
        }
    }
}

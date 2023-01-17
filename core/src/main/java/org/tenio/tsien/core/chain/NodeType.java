package org.tenio.tsien.core.chain;

import cn.hutool.core.text.CharSequenceUtil;
import org.tenio.tsien.exceptions.NotSupportNodeTypeException;

public enum NodeType {
    Normal(1),
    Catch(2),
    Finally(3),
    Pre(4);

    private int typeValue;

    NodeType(int typeValue) {
        this.typeValue = typeValue;
    }

    NodeType valueOf(int typeValue) {
        switch (typeValue) {
            case 1:
                return Normal;
            case 2:
                return Catch;
            case 3:
                return Finally;
            case 4:
                return Pre;
            default:
                throw new NotSupportNodeTypeException(CharSequenceUtil.format("Not support the NodeType value {}", typeValue));
        }
    }
}

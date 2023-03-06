package org.tenio.tsien.parser.groovy

import cn.hutool.core.io.FileUtil
import cn.hutool.core.io.IoUtil
import org.tenio.tsien.core.Chain
import org.tenio.tsien.core.ChainManager
import org.tenio.tsien.parser.Parser

class GyfParser implements Parser {
    private GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
    @Override
    Chain parse(String chainPath) {
        return null
    }

    ChainManager config(String chainManagerPath) {
        groovyClassLoader.defineClass(FileUtil.mainName(chainManagerPath), IoUtil.readBytes(FileUtil.getInputStream(chainManagerPath)))
    }
}

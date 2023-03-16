package org.tenio.tsien.parser.groovy

import cn.hutool.core.io.FileUtil
import cn.hutool.core.io.IoUtil
import org.tenio.tsien.core.Chain
import org.tenio.tsien.core.ChainManager
import org.tenio.tsien.parser.Parser

abstract class GyfParser implements Parser {

    @Override
    Chain parse(String chainPath) {
        getGroovyClassLoader(chainPath)
                .parseClass(getCodeSourceByPath(chainPath), false)
    }

    @Override
    ChainManager config(String chainManagerPath) {
        getGroovyClassLoader(chainManagerPath)
                .parseClass(getCodeSourceByPath(chainManagerPath), false)
    }

    GroovyCodeSource getCodeSourceByPath(String codePath) {
        String codeContent = IoUtil.read(FileUtil.getInputStream(codePath))
        String fileName = FileUtil.mainName(codePath)
        return new GroovyCodeSource(codeContent, fileName, "/groovy/script")
    }

    abstract GroovyClassLoader getGroovyClassLoader(String codePath)
}

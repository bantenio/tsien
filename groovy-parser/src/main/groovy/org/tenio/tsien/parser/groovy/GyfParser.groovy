package org.tenio.tsien.parser.groovy

import cn.hutool.core.io.FileUtil
import cn.hutool.core.io.IoUtil
import org.tenio.tsien.core.Chain
import org.tenio.tsien.core.ChainManager
import org.tenio.tsien.parser.Parser
import org.tenio.tsien.parser.groovy.dsl.ChainConfigScript
import org.tenio.tsien.parser.groovy.dsl.ChainManagerConfigScript
import org.tenio.tsien.parser.groovy.extention.GroovyClassLoaderProvider

class GyfParser implements Parser {
    private GroovyClassLoaderProvider groovyClassLoaderProvider

    @Override
    Chain parse(String chainPath) {
        Class<?> clazz = getGroovyClassLoader(chainPath)
                .parseClass(getCodeSourceByPath(chainPath), false)
        ChainConfigScript chainConfigScript = ChainConfigScript.cast(clazz.newInstance())
        chainConfigScript.run()
        return chainConfigScript.getChain()
    }

    @Override
    ChainManager config(String chainManagerPath) {
        Class<?> clazz = getGroovyClassLoader(chainManagerPath)
                .parseClass(getCodeSourceByPath(chainManagerPath), false)
        ChainManagerConfigScript chainManagerConfigScript = ChainManagerConfigScript.cast(clazz.newInstance())
        chainManagerConfigScript.setParser(this)
        // TODO 处理脚本需要环境
        chainManagerConfigScript.run()
        return chainManagerConfigScript.getChainManager()
    }

    GroovyCodeSource getCodeSourceByPath(String codePath) {
        String codeContent = IoUtil.read(FileUtil.getInputStream(codePath))
        String fileName = FileUtil.mainName(codePath)
        return new GroovyCodeSource(codeContent, fileName, "/groovy/script")
    }

    GroovyClassLoader getGroovyClassLoader(String codePath) {
        return groovyClassLoaderProvider.getGroovyClassLoader()
    }
}

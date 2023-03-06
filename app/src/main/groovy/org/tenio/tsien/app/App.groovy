package org.tenio.tsien.app

import org.tenio.tsien.core.component.NopComponent
import org.tenio.tsien.parser.Parser
import org.tenio.tsien.parser.groovy.GyfParser

class App {
    static void main(String[] args) {
        Parser parser = new GyfParser();
        parser.node(new NopComponent());
    }
}

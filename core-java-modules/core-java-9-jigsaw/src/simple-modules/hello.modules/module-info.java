module hello.modules {
    exports com.tom.modules.hello;
    provides com.tom.modules.hello.HelloInterface with com.tom.modules.hello.HelloModules;
}
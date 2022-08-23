package org.example.constants;

public interface BaseConfiguration {
    void init();
    interface Swagger extends BaseConfiguration {
        interface Configuration extends Swagger {}
        interface Properties extends Swagger {}
    }

    interface Security extends BaseConfiguration {
        interface Configuration extends Security {}
    }
    interface OAuth2 extends BaseConfiguration {
        interface Configuration extends OAuth2 {}
        interface ResourceServer extends OAuth2 {}

    }
}

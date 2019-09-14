module com.arasio.webdev.strangehorizon {
    requires spring.web;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;
    exports com.arasio.webdev.strangehorizon;
    opens com.arasio.webdev.strangehorizon.controllers;
}

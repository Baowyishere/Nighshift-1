module edu.sdccd.cisc190 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.media;
    requires jdk.jsobject;
    requires java.desktop;
    requires jdk.incubator.vector;
    requires java.prefs;

    exports edu.sdccd.cisc190.generalstuff;
    exports edu.sdccd.cisc190.scenes;
    exports edu.sdccd.cisc190.Tests;
}